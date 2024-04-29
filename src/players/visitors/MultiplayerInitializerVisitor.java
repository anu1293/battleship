package players.visitors;

import factories.PlayerFactory;
import missile.MissileFactory;
import missile.missileinitilizer.MultiPlayerMissileInitializer;
import missile.missileinitilizer.TwoPlayerMissileInitializer;
import players.Player;
import players.initializers.MultiPlayerInitializer;
import players.initializers.TwoPlayerInitializer;

public class MultiplayerInitializerVisitor implements PlayerInitializerVisitor {
    @Override
    public Player[] visit(TwoPlayerInitializer initializer) throws Exception {
        throw new Exception("this initializer doesn't support 2 player initilization");
    }

    @Override
    public void visit(TwoPlayerMissileInitializer initializer, Player[] players) throws Exception {
        throw new Exception("this initializer doesn't support 2 player missile initialization");
    }

    @Override
    public Player[] visit(MultiPlayerInitializer initializer) throws Exception {
        if(initializer.types==null || initializer.noOfPlayers!=initializer.types.length)
            throw new Exception("input no of players is not equal to input player types");
        if(initializer.noOfPlayers<3)
            throw new Exception("minimum 3 players needed for multiplayer game");
        Player[] players = new Player[initializer.noOfPlayers];
        for(int i=0;i< initializer.noOfPlayers;i++) {
            players[i] = PlayerFactory.getPlayer(initializer.types[i]);
        }
        return players;
    }

    @Override
    public void visit(MultiPlayerMissileInitializer initializer, Player[] players) throws Exception {
        if(initializer.sequence==null || initializer.sequence.length!= players.length) {
            throw new Exception("please supply missile sequence for all the players");
        }

        for(int i=0;i<players.length;i++) {
            String seq = initializer.sequence[i];
            if(seq.isBlank())
                throw new Exception("empty sequence for player: "+i);
            String[] missileDetails = seq.split(" ");
            for(int j=0;j<missileDetails.length;j++)
                players[i].getMissileSequence().add(MissileFactory.createMissile(missileDetails[j].substring(0,1).charAt(0)-'A'+1,
                        Integer.parseInt(missileDetails[j].substring(1,2)),
                        players[Integer.parseInt(missileDetails[j].substring(2))]));
        }
    }
}
