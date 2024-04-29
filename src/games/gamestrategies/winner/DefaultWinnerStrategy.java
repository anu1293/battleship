package games.gamestrategies.winner;

import games.gamestrategies.winner.WinnerStrategy;
import players.Player;

public class DefaultWinnerStrategy implements WinnerStrategy {
    @Override
    public void getWinner(Player[] players) {
        int count=0,index=-1;
        for(int i=0;i< players.length;i++) {
            if(players[i].getRemainingShips()>0) {
                count++;
                index=i+1;
            }
        }
        if(count==1) {
            System.out.println("player: "+index+" wins");
        } else {
            System.out.println("game draw");
        }
    }
}
