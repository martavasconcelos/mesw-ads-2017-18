package hot.compositesingleton;

import hot.HoTapp;
import hot.RoomFactory;

import java.awt.*;
import java.util.ArrayList;

public class Composite {

    private static ArrayList<RoomFactory> rooms;


    public Composite() {
        rooms = House.getRooms();
    }


    public static void turnAllRoomsOn() {
        int numberofRooms;
        for (RoomFactory r : rooms) {
            r.turnOn();
            numberofRooms=rooms.size();
            HoTapp.numberOfDevices= HoTapp.numberOfDevices+numberofRooms;
            System.out.println("Turned on room " + House.getRooms().toString());
        }
    }

    public static void turnAllRoomsOff() {
        for (RoomFactory r : rooms) {
          int  numberofRooms2=rooms.size();
            r.turnOff();HoTapp.numberOfDevices= HoTapp.numberOfDevices-numberofRooms2;
            System.out.println("Turned off room " + House.getRooms().toString());
//ir aos filhos do House
        }
    }





}