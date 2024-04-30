package display;
import battlegrounds.RectangularBattleGround;
import players.Player;
import ships.PTypeShip;
import ships.Ship;

public class DisplayBoard {

//    @Override
//    public void updateBattleground(Player player) {
//
//    }
//
//    public static void display(Player player, RectangularBattleGround battleGround) {
//
//
//        char[][] displayBoard = new char[player.getBattleGround().getBattleAreaHeight()][battleGround.getBattleAreaWidth()];
//
//        for (int i = 0; i < battleGround.getBattleAreaHeight(); i++) {
//            for (int j = 0; j < battleGround.getBattleAreaWidth(); j++) {
//                displayBoard[i][j] = '.';
//            }
//        }
//
//        for (Ship ship : player.getShips()) {
//            char shipMark = (ship instanceof PTypeShip) ? 'p' : 'q';
//            int hits[][] = ship.getHits();
//            int hitPerPart = ship.getHitPerPart();
//            for (int i = ship.getyCoordinate(); i < ship.getyCoordinate() + ship.getHeight(); i++) {
//                for (int j = ship.getxCoordinate(); j < ship.getxCoordinate() + ship.getWidth(); j++) {
//                    if(hits[i-ship.getyCoordinate()][j-ship.getxCoordinate()]>=hitPerPart) {
//                        displayBoard[i - 1][j - 1] ='X';
//                    } else {
//                        displayBoard[i - 1][j - 1] = shipMark;
//                    }
//                }
//            }
//        }
//
//        for (int i = 0; i < player.getBattleAreaHeight(); i++) {
//            for (int j = 0; j < player.getBattleAreaWidth(); j++) {
//                System.out.print(displayBoard[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
//
//    public static void display(Player[] players) {
//        int i=1;
//        for (Player player : players) {
//            System.out.println("PLAYER: "+i+" ship positions");
//            display(player);
//            System.out.println();
//            i++;
//        }
//    }
}
