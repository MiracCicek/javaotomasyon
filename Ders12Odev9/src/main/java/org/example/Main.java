package org.example;

public class Main {
    public static void simulateFreeFall(double initialHeight, double gravity) throws InvalidParameterException, NegativeTimeException, SimulationException {
        // Başlangıç yüksekliğini kontrol et
        if (initialHeight < 0 || gravity < 0) {
            throw new InvalidParameterException("Geçersiz başlangıç yüksekliği veya yerçekimi ivmesi");
        }

        // Serbest düşüş simülasyonu
        double time = 0;
        double height = initialHeight;
        double velocity = 0;

        while (height > 0) {
            // Hızı ve yüksekliği güncelle
            velocity = velocity + gravity * time;
            height = initialHeight - 0.5 * gravity * time * time;

            // Zamanı güncelle
            time++;

            // Negatif zaman kontrolü
            if (time < 0) {
                throw new NegativeTimeException("Negatif zaman hatası");
            }

            // Hız veya yükseklik negatif kontrolü
            if (velocity < 0 || height < 0) {
                throw new SimulationException("Negatif hız veya yükseklik hatası");
            }
        }

        System.out.println("Top toprağa düştü.");
    }

    public static void main(String[] args) {
        try {
            simulateFreeFall(2, 9.81); // Geçerli deney
            simulateFreeFall(-2, 9.81); // Geçersiz başlangıç yüksekliği
            simulateFreeFall(2, -9.81); // Geçersiz yerçekimi ivmesi
            simulateFreeFall(2, 9.81); // Negatif hız veya yükseklik hatası
        } catch (InvalidParameterException | NegativeTimeException | SimulationException e) {
            System.out.println("Hata oluştu: " + e.getMessage());
        }
    }
}

class InvalidParameterException extends Exception {
    public InvalidParameterException(String message) {
        super(message);
    }
}

class NegativeTimeException extends Exception {
    public NegativeTimeException(String message) {
        super(message);
    }
}

class SimulationException extends Exception {
    public SimulationException(String message) {
        super(message);
    }
}