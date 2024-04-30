package ships.strategies;

import battlegrounds.BattleGround;
import players.Player;

public interface ShipPlacementStrategy {
    void placeShip(Player[] players) throws Exception;
}
