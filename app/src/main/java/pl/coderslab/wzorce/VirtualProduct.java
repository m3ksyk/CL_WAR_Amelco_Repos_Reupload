package pl.coderslab.wzorce;

public class VirtualProduct implements Product {
    private double value;
    private String name;
    private String atWebsiteName;

    public String getAtWebsiteName() {
        return atWebsiteName;
    }

    public VirtualProduct() {
    }

    public Product setAtWebsiteName(String atWebsiteName) {
        this.atWebsiteName = atWebsiteName;
        return this;

    }

    public VirtualProduct(String name, double value) {
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

