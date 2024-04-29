package players.initializers;

import players.visitors.PlayerInitializerVisitor;
import players.Player;
import players.PlayerType;

public class TwoPlayerInitializer implements PlayerInitializer {
     public final int noOfPlayers = 2;
     public PlayerType[] types;

     public TwoPlayerInitializer(PlayerType[] type) {
          this.types = type;
     }
     @Override
     public Player[] initializePlayers(PlayerInitializerVisitor visitor) throws Exception {
          return visitor.visit(this);
     }
}
