public enum DishType {
    ASSIETTE("assiette"),
    SANDWICH("sandwich");

    private String label;

    DishType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
