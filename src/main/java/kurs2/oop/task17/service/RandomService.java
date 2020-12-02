package kurs2.oop.task17.service;

public class RandomService {
    static int interval(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
