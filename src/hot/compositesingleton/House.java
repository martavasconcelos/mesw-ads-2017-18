package hot.compositesingleton;

import hot.RoomFactory;
import java.util.ArrayList;
//Singleton class
public final class House {
    //tem uma lista de rooms, e esta classe pode ser acedida em qualquer outra classe
    private static ArrayList<RoomFactory> rooms= new ArrayList<>();

    private static final House instance = new House();

    //make the constructor private so that this class cannot be
    //instantiated
    private House(){}

    //Get the only object available
    public static House getInstance(){
        return instance;
    }


    public static void add(RoomFactory r){
        rooms.add(r);
    }

    public static ArrayList<RoomFactory> getRooms() {
        return rooms;
    }

    public static RoomFactory remove(RoomFactory r){
        RoomFactory removed = null;
        for(int i = 0; i < rooms.size(); i++) {
            if(rooms.get(i) == r) {
                removed = rooms.remove(i);
                break;
            }
        }
        return removed;
    }

}