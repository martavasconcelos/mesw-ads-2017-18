package hot.compositesingleton;

import hot.RoomFactory;

import java.awt.*;
import java.util.ArrayList;

public class Composite {

    private static ArrayList<RoomFactory> rooms;

    public Composite() {
        rooms = House.getRooms();
    }


    public static void turnAllRoomsOn() {

        for (RoomFactory r : rooms) {
            r.turnOn();
            System.out.println("Turned on room " + House.getRooms().toString());
        }
    }

    public static void turnAllRoomsOff() {
        for (RoomFactory r : rooms) {
            r.turnOff();
            System.out.println("Turned off room " + House.getRooms().toString());
//ir aos filhos do House
        }
    }





}