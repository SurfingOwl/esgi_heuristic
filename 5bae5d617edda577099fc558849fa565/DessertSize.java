public enum DessertSize {
    PETIT("petit"),
    SPECIAL("special");

    private String label;

    DessertSize(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
