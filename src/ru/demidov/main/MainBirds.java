package ru.demidov.main;

import ru.demidov.birds.Bird;

import java.util.List;

public class MainBirds {
    public static void makeBirdsSing(List<Bird> birds) {
        for (Bird bird : birds) {
            System.out.print("Птица поет: ");
            bird.sing();
        }
    }
}
