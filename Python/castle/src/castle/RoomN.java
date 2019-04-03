package castle;

import java.util.ArrayList;

public class RoomN {
    private String descreption;
    private RoomN eastExit;
    private RoomN westExit;
    private RoomN northExit;
    private RoomN southExit;

    public RoomN(String descreption){
        this.descreption = descreption;
    }


    public void setExits(RoomN eastExit,RoomN westExit,RoomN northExit,RoomN southExit){
        if (eastExit != null){
            this.eastExit = eastExit;
        }
        if (westExit != null){
            this.westExit = westExit;
        }
        if (northExit != null){
            this.northExit = northExit;
        }
        if (southExit != null){
            this.southExit = southExit;
        }
    }

    public ArrayList<String> getExits(){
        ArrayList<String> exits = new ArrayList<String>();
        if (southExit != null){
            exits.add("south");
        }
        if (eastExit != null){
            exits.add("east");
        }
        if (northExit!= null){
            exits.add("north");
        }
        if (westExit != null){
            exits.add("west");
        }
        return exits;
    }
    public RoomN goToNextRoom(String direction){
        RoomN result = null;
        if (direction.equals("east")){
            result = eastExit;
        }
        if (direction.equals("south")){
            result = southExit;
        }
        if (direction.equals("north")){
            result = northExit;
        }
        if (direction.equals("west")){
            result = westExit;
        }
        return result;
    }

    @Override
    public String toString() {
        return descreption;
    }
}
