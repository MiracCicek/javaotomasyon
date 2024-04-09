// Singleton tasarım deseni


// Builder tasarım deseni


import org.example.Product;
import org.example.Singleton;

public class Main {
    public static void main(String[] args) {
        // Singleton örneği
        Singleton singletonInstance1 = Singleton.getInstance();
        Singleton singletonInstance2 = Singleton.getInstance();

        System.out.println("singletonInstance1 == singletonInstance2: " + (singletonInstance1 == singletonInstance2));

        // Builder örneği
        Product product = new Product.ProductBuilder("Telefon", 999.99)
                .description("Akıllı telefon")
                .build();

        System.out.println("Ürün Adı: " + product.getName());
        System.out.println("Ürün Açıklaması: " + product.getDescription());
        System.out.println("Ürün Fiyatı: " + product.getPrice());
    }
}