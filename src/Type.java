public enum Type {
    WORK("Рабочая задача"),
    PERSONAL ("Личная задача");

    private String type;

    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }
}
