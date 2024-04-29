package factories;

import ships.PTypeShip;
import ships.QTypeShip;
import ships.Ship;
import ships.ShipType;

public class ShipFactory {
    public static Ship createShip(ShipType type, int width, int height) {
        return switch (type) {
            case P -> new PTypeShip(width, height);
            case Q -> new QTypeShip(width, height);
        };
    }
}
