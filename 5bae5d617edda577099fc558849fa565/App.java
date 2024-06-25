public class App {

    // calcule le prix payé par l'utilisateur dans le restaurant, en fonction de type de
    // repas qu'il prend (assiette ou sandwich), de la taille de la boisson (petit, moyen, grand), du dessert et
    // de son type (normal ou special) et si il prend un café ou pas (yes ou no).
    // les prix sont fixes pour chaque type de chose mais des réductions peuvent s'appliquer
    // si cela rentre dans une formule!
    public int Compute(DishType type, DishName name, BeverageName beverage, BeverageSize size, Dessert dessert, DessertSize dsize, boolean coffee) {
        // prix total à payer pour le client
        int total = 0;

        // le type ne peut être vide car le client doit déclarer au moins un repas
        if (type == null || name == null) return -1;

        // si le client prends un plat en assiette
        switch (type) {
            case DishType.ASSIETTE -> {
                total += 15;
                total = handleAssiette(BeverageSize.valueOf(size));
            }
            // mode sandwich
            case DishType.SANDWICH -> {
                total += 10;
                // ainsi qu'une boisson de taille:
                switch (size) {
                    case BeverageSize.PETIT -> {
                        total += 2;
                        // dans ce cas, on applique la formule standard
                        if (DessertSize.PETIT.equals(dsize)) {
                            // pas de formule
                            // on ajoute le prix du dessert normal
                            return total + 2;
                        }   // sinon on rajoute le prix du dessert special
                        return total + 4;

                        // si on prends moyen
                    }
                    case BeverageSize.MOYEN -> {
                        total += 3;
                        // dans ce cas, on applique la formule standard
                        if (DessertSize.PETIT.equals(dsize)) {
                            // j'affiche la formule appliquée
                            System.out.print("Prix Formule Standard appliquée ");
                            // le prix de la formule est donc 13
                            return total;
                        }
                        // sinon on rajoute le prix du dessert special
                        return total + 4;

                    }
                    case BeverageSize.GRAND -> {
                        total += 4;
                        // dans ce cas, on applique la formule standard
                        if (DessertSize.PETIT.equals(dsize)) {
                            // pas de formule
                            // on ajoute le prix du dessert normal
                            return total + 2;
                        }
                        // dans ce cas on a la fomule max
                        System.out.print("Prix Formule Max appliquée ");
                        return 16;
                    }
                }
            }
        }
        total = handleCoffe(type, size, dsize, coffee, total);
        return total;
    }

    private int handleCoffe(DishType type, BeverageSize size, DessertSize dsize, boolean coffee, int total) {
        if (DishType.ASSIETTE.equals(type) && BeverageSize.MOYEN.equals(size) && DessertSize.PETIT.equals(dsize) && coffee) {
            System.out.print("\navec café offert ! ");
            return total;
        }
        // Assume coffee costs 1 unit, adding to the total only if coffee is not included
        if (coffee) {
            return total + 1;
        }

        return total;
    }

    private static int handleAssiette(BeverageSize size, int total) {
        return switch (size) {
            case BeverageSize.PETIT -> {

                total += 2;
                // dans ce cas, on applique la formule standard
                if (dsize.equals("normal")) {
                    // pas de formule
                    // on ajoute le prix du dessert normal
                    total += 2;
                } else {
                    // sinon on rajoute le prix du dessert special
                    total += 4;
                }
                yield total;
                // si on prends moyen
            }
            return total;
            case BeverageSize.MOYEN -> {


                total += 3;
                // dans ce cas, on applique la formule standard
                if (dsize.equals("normal")) {
                    // j'affiche la formule appliquée
                    System.out.print("Prix Formule Standard appliquée ");
                    // le prix de la formule est donc 18
                    total = 18;
                } else {
                    // sinon on rajoute le prix du dessert special
                    total += 4;
                }
                return total;
            }
            case BeverageSize.GRAND -> {
                total += 4;
                // dans ce cas, on applique la formule standard
                if (dsize.equals("normal")) {
                    // pas de formule
                    // on ajoute le prix du dessert normal
                    total += 2;
                } else {
                    // dans ce cas on a la fomule max
                    System.out.print("Prix Formule Max appliquée ");
                    total = 21;
                }
                return total;
            }
        }
    }
}
}