package org.example;

enum Planet {
    MERCURY(1, "Mercury", 0.39, 2439, 58),
    VENUS(2, "Venus", 0.72, 6052, 243),
    EARTH(3, "Earth", 1, 6371, 24),
    MARS(4, "Mars", 1.52, 3390, 24),
    JUPITER(5, "Jupiter", 5, 69911, 10),
    SATURN(6, "Saturn", 9, 58232, 11),
    URANUS(7, "Uranus", 19, 25362, 17),
    NEPTUNE(8, "Neptune", 30, 24622, 16),
    PLUTO(9, "Pluto", 39, 1188, 153);

    private int order;
    private String name;
    private double distanceFromSun;
    private int radius;
    private int rotationPeriod;

    Planet(int order, String name, double distanceFromSun, int radius, int rotationPeriod) {
        this.order = order;
        this.name = name;
        this.distanceFromSun = distanceFromSun;
        this.radius = radius;
        this.rotationPeriod = rotationPeriod;
    }

    public int getOrder() {
        return order;
    }

    public String getName() {
        return name;
    }

    public double getDistanceFromSun() {
        return distanceFromSun;
    }

    public int getRadius() {
        return radius;
    }

    public int getRotationPeriod() {
        return rotationPeriod;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Güneş Sistemi Gezegenleri:");
        for (Planet planet : Planet.values()) {
            System.out.println("Gezegen: " + planet.getName() +
                    ", Sıralama: " + planet.getOrder() +
                    ", Uzaklık: " + planet.getDistanceFromSun() + " AU" +
                    ", Yarıçap: " + planet.getRadius() + " km" +
                    ", Dönme Süresi: " + planet.getRotationPeriod() + " saat");
        }
    }
}
