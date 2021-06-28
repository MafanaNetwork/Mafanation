package me.TahaCheji.Mafana.utils;

import java.util.Random;

public class RandomUtil {

    public static int getRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

}
