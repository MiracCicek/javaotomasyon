package org.example;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Main {

    public static <T> int findElementIndexInCollection(List<T> collection, T element) {
        OptionalInt resultIndex = IntStream.range(0, collection.size())
                .filter(i -> collection.get(i).equals(element))
                .findFirst();

        return resultIndex.orElse(-1); // Bulunamazsa -1 döndürür
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // Örnek kullanım
        int elementToFind = 4;
        int foundIndex = findElementIndexInCollection(numbers, elementToFind);

        if (foundIndex != -1) {
            System.out.println("Bulunan öğe indeksi: " + foundIndex);
        } else {
            System.out.println("Öğe bulunamadı.");
        }
    }
}