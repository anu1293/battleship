package ships.initializers;

import players.Player;

public interface ShipCreationStrategy {
    void createShip(Player[] players) throws Exception;
}
