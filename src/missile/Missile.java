package missile;

import players.Player;

public interface Missile {
    int getXCoordinate();
    int getYCoordinate();
    Player getOpponent();
}
