package missile;

import players.Player;

public class BasicMissile implements Missile {
    int xCoordinate;
    int yCoordinate;
    Player opponent;

    public BasicMissile(int xCoordinate,int yCoordinate, Player opponent) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.opponent = opponent;

    }
    @Override
    public int getXCoordinate() {
        return xCoordinate;
    }

    @Override
    public int getYCoordinate() {
        return yCoordinate;
    }

    @Override
    public Player getOpponent() {
        return opponent;
    }
}
