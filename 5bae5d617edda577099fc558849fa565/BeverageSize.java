public enum BeverageSize {
    PETIT("petit"),
    MOYEN("moyen"),
    GRAND("grand");

    private String label;

    BeverageSize(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
