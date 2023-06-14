package org.example;

public class Fish extends Thread {
    private  Integer x;
    private Integer y;
    private Integer life;
    private Gender gender;
    private Acquarium acquarium;

    public Fish(Integer x, Integer y, Integer life, Gender gender, Acquarium acquarium) {
        this.x = x;
        this.y = y;
        this.life = life;
        this.gender = gender;
        this.acquarium = acquarium;
    }


    @Override
    public void run() {
        while (life>0)
        {
            move();
            try {
                Thread.sleep(500);
                life--;
                acquarium.checkCollision(this);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        acquarium.removeFish(this);
    }

    private void move() {

       int direction = AcquariumUtil.getRandom(4);
       // 0-up,1-right,2-down,3-left

        switch (direction)
        {
            case 0:
                if(y<AcquariumUtil.coordinateX)
                    y++;
                break;
            case 1:
                if(x<AcquariumUtil.getCoordinateY)
                    x++;
                break;
            case 2:
                if(y>0)
                    y--;
                break;
            case 3:
                if(x<0)
                  x++;

                break;
        }
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Integer getLife() {
        return life;
    }

    public Gender getGender() {
        return gender;
    }

    public Acquarium getAcquarium() {
        return acquarium;
    }

    public boolean collision(Fish f) {
        if(this.x==f.getX() && this.y==f.getY() && this.gender!=f.getGender())
        {
            return true;
        }
        return false;
    }
}
