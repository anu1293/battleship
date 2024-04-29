package ships;

import ships.Ship;

public class QTypeShip extends Ship {

    public QTypeShip(int width, int height) {
        super(width, height);
        hitPerPart =2;
    }

    @Override
    public boolean isHit(int x, int y) {
        return hits[y - getyCoordinate()][x - getxCoordinate()]<=2 && hits[y - getyCoordinate()][x - getxCoordinate()]>=1;
    }
}
