package ships.initializers;

import factories.ShipFactory;
import players.Player;
import ships.ShipType;


public class EqualShipPerPlayerStrategy implements ShipCreationStrategy{
    int noOfShips;
    ShipType[] types;
    int[] height;
    int[] width;

    public EqualShipPerPlayerStrategy(int noOfShips,ShipType[] types,int[] height, int[] width) {
        this.noOfShips = noOfShips;
        this.types = types;
        this.height = height;
        this.width = width;
    }

    @Override
    public void createShip(Player[] players) throws Exception {
        if(noOfShips<=0)
            throw new Exception("no of ships should be atleast 1");
        if(types==null)
            throw new Exception("ship type not provided");
        if(noOfShips!=types.length)
            throw new Exception("no of ships and ship types are not equal");
        if(height==null || width==null || height.length!=width.length)
            throw new Exception("width or height of the ship are not given");

        for(int i=0;i<noOfShips;i++) {
            for(Player player: players) {
                player.addShip(ShipFactory.createShip(types[i],width[i],height[i]));
            }
        }
    }
}
