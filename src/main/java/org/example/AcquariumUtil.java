package org.example;

import java.util.Random;

public class AcquariumUtil {

    public static final int coordinateX =5;
    public static final int getCoordinateY =5;
    public static final int totalAmount = (coordinateX+1)*(getCoordinateY+1);

    public static Random random = new Random();

    public static int  getRandom(int n)
    {
        return random.nextInt(n);
    }

    public static int getRandomBetween(int a, int b)
    {
        return random.nextInt(a,b);
    }

    public static Gender getRandomGender()
    {
        if(random.nextInt(2)==0)
            return Gender.Female;

        return Gender.Male;

    }
}
