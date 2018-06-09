package pl.coderslab.wzorce;

public class SimpleProduct implements Product {
    private double value;
    private String name;

    public SimpleProduct(String name, double value ) {
        this.setValue(value);
        this.setName(name);
    }

    public SimpleProduct() {
    }

    @Override
    public double getValue() {
        return 0;
    }

    @Override
    public Product setValue(double value) {
        this.value = value;
        return this;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Product setName(String name) {
        this.name = name;
        return this;
    }
}
