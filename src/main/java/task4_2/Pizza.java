package task4_2;

class Pizza {
    private String size;
    private String name;
    private int price;

    public Pizza(String size, String name, int price) {
        this.size = size;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pizza{size='" + size + "', name='" + name + "', price=" + price + "}";
    }
}