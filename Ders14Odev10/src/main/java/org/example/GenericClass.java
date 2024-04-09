package org.example;

public class GenericClass<T> {

    private T genericField;

    public GenericClass(T genericField) {
        this.genericField = genericField;
    }

    public void printGenericField() {
        System.out.println("Generic Field: " + genericField);
    }

    public static void main(String[] args) {
        // String tipinde GenericClass örneği oluşturulması
        GenericClass<String> stringGenericClass = new GenericClass<>("Hello, World!");
        stringGenericClass.printGenericField();

        // Integer tipinde GenericClass örneği oluşturulması
        GenericClass<Integer> integerGenericClass = new GenericClass<>(42);
        integerGenericClass.printGenericField();
    }
}