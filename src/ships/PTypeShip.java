package ships;

import ships.Ship;

public class PTypeShip extends Ship {

    public PTypeShip(int width, int height) {
        super(width, height);
    }

    @Override
    public boolean isHit(int x, int y) {
        return hits[y - getyCoordinate()][x - getxCoordinate()]==1;
    }
}
