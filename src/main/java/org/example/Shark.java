package org.example;

public class Shark extends Thread{

    private  Integer x;
    private Integer y;
    private Integer life;

    private Acquarium acquarium;
    public Shark(Integer x, Integer y, Integer life, Acquarium acquarium) {
        this.x = x;
        this.y = y;
        this.life = life;
        this.acquarium = acquarium;

    }

    @Override
    public void run() {
        while (life>0)
        {
            move();
            try {
                Thread.sleep(100);
                life--;
                acquarium.checkCollisionShark(this);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        acquarium.removeShark(this);
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

    public Acquarium getAcquarium() {
        return acquarium;
    }

    @Override
    public String toString() {
        return "Shark{" +
                "x=" + x +
                ", y=" + y +
                ", life=" + life +
                ", acquarium=" + acquarium +
                '}';
    }

    public boolean collision(Fish fish) {
        if(this.x==fish.getX() && this.y==fish.getY())
        {
            return true;
        }
        return false;
    }
}
