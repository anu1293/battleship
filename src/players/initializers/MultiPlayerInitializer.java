package players.initializers;

import players.visitors.PlayerInitializerVisitor;
import players.Player;
import players.PlayerType;

public class MultiPlayerInitializer implements PlayerInitializer {
    public int noOfPlayers;
    public PlayerType[] types;

    @Override
    public Player[] initializePlayers(PlayerInitializerVisitor visitor) throws Exception {
          return visitor.visit(this);
    }
}
