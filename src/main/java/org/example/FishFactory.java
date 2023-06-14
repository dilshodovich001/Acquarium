package org.example;

public class FishFactory {

    public static Fish createFish(Acquarium acquarium) {

        int x = AcquariumUtil.getRandom(AcquariumUtil.coordinateX + 1); // 0,1,2,3,4,5
        int y = AcquariumUtil.getRandom(AcquariumUtil.getCoordinateY + 1); // 0,1,2,3,4,5
        int life = AcquariumUtil.getRandomBetween(5, 20);
        Gender gender = AcquariumUtil.getRandomGender();
        Fish fish = new Fish(x, y, life, gender, acquarium);
        return fish;

    }


    public static Shark createShark(Acquarium acquarium) {

        int x = AcquariumUtil.getRandom(AcquariumUtil.coordinateX + 1); // 0,1,2,3,4,5
        int y = AcquariumUtil.getRandom(AcquariumUtil.getCoordinateY + 1); // 0,1,2,3,4,5
        int life = AcquariumUtil.getRandomBetween(5, 20);
        Shark shark = new Shark(x, y, life, acquarium);
        return shark;

    }
}
