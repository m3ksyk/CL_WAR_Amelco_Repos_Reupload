package pl.coderslab.wzorce;

public class AdvanceProduct implements Product {
    private double value;
    private String name;

    public AdvanceProduct() {
    }

    public AdvanceProduct( String name, double value) {
        this.setValue(value);
        this.setName(name);
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

