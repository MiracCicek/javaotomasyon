package org.example;
public class Product {
    private String name;
    private String description;
    private double price;

    private Product(ProductBuilder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.price = builder.price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public static class ProductBuilder {
        private String name;
        private String description;
        private double price;

        public ProductBuilder(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public ProductBuilder description(String description) {
            this.description = description;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}