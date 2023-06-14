package org.example;

import java.util.LinkedList;

public class Acquarium {
    private   LinkedList<Fish> fishLinkedList = new LinkedList<>();

    private boolean isSharkLive = true;



    public void start() {
        int size = AcquariumUtil.getRandom(10);

        for (int i = 0; i < size; i++) {
            fishLinkedList.add(FishFactory.createFish(this));
        }

        for (Fish fish: fishLinkedList)
        {
            fish.start();
        }

        Shark shark = FishFactory.createShark(this);
        shark.start();

    }

    public void checkCollision(Fish fish) {
      synchronized (fishLinkedList)
      {
          if(fishLinkedList.size()<AcquariumUtil.totalAmount)
          {
              Fish babyFish = null;
              for (Fish f: fishLinkedList)
              {
                  if(fish.collision(f))
                  {
                     babyFish = FishFactory.createFish(this);
                      String str = String.format("Collision: Fish1 - {%s}, Fish2 - {%s}, baby - {%s}", fish.getName(),f.getName(),babyFish.getName());
                      System.out.println(str);
                      break;
                  }

              }

              if(babyFish != null)
              {
               fishLinkedList.add(babyFish);
               babyFish.start();
              }

              printDetail();


          }
      }

    }

    private synchronized void printDetail() {
        int tot = fishLinkedList.size();
        int m = 0;
        int f = 0;
        for(Fish fish : fishLinkedList)
        {
            if(fish.getGender().equals(Gender.Male)){
                m++;}
            else {f++;}

        }

        System.out.println("==============================");
        System.out.println("TotalFish: " +tot);
        System.out.println("Number of Male Fish: "+m);
        System.out.println("Number of Female Fish: "+f);
        if(isSharkLive)
          System.out.println("Shark is live ");
        System.out.println("==============================");

    }



    public synchronized void removeFish(Fish fish) {

        fishLinkedList.remove(fish);
        System.out.println("-------------------");
        System.out.println("Fish dead  "+fish);
        System.out.println("-------------------");
        printDetail();
    }

    public  void sharkEatFish(Fish fish) {

        fishLinkedList.remove(fish);
        System.out.println("-------------------");
        System.out.println("Fish eated by shark  "+fish);
        System.out.println("-------------------");
        printDetail();
    }


    public  void removeShark(Shark shark) {

        System.out.println("-------------------");
        System.out.println("Shark dead  "+shark);
        System.out.println("-------------------");
        this.isSharkLive=false;

    }

    public void checkCollisionShark(Shark shark) {

                for (Fish f: fishLinkedList)
                {
                    if(shark.collision(f))
                    {
                       sharkEatFish(f);
                        break;
                    }

                }

              //  printDetail();



        }

}

