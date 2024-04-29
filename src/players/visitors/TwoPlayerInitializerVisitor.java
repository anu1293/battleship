package players.visitors;

import factories.PlayerFactory;
import missile.MissileFactory;
import missile.missileinitilizer.MultiPlayerMissileInitializer;
import missile.missileinitilizer.TwoPlayerMissileInitializer;
import players.Player;
import players.initializers.MultiPlayerInitializer;
import players.initializers.TwoPlayerInitializer;

public class TwoPlayerInitializerVisitor implements PlayerInitializerVisitor {


    @Override
    public Player[] visit(MultiPlayerInitializer initializer) throws Exception {
        throw new Exception("this initializer doesn't support multi player initilization");
    }

    @Override
    public void visit(MultiPlayerMissileInitializer initializer, Player[] players) throws Exception {
        throw new Exception("this initializer doesn't support multi player missile initialization");
    }

    @Override
    public Player[] visit(TwoPlayerInitializer initializer) throws Exception {

        if(initializer.types==null || initializer.types.length!= 2) {
            throw new Exception("please supply exactly 2 types of players");
        }
        Player[] players = new Player[initializer.noOfPlayers];
        for(int i=0;i< initializer.noOfPlayers;i++) {
            players[i] = PlayerFactory.getPlayer(initializer.types[i]);
        }
        return players;
    }

    @Override
    public void visit(TwoPlayerMissileInitializer initializer, Player[] players) throws Exception {

        if(initializer.sequence==null || initializer.sequence.length!= 2) {
            throw new Exception("please supply missile sequence for exactly 2 players");
        }

        for(int i=0;i<players.length;i++) {
            String seq = initializer.sequence[i];
            if(seq.isBlank())
                throw new Exception("empty sequence for player: "+i);
            String[] missileDetails = seq.split(" ");
            for (String missileDetail : missileDetails)
                players[i].getMissileSequence().add(MissileFactory.createMissile(missileDetail.substring(0, 1).charAt(0)-'A'+1,
                        Integer.parseInt(missileDetail.substring(1, 2)),
                        players[((i + 1) % 2)]));
        }
    }
}
