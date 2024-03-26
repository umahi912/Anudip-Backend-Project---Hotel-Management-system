package com.hotel.entities;
import java.util.Scanner;

public class Booking 
{
static Room room = new Room();

public static void main(String[] args) {
    String roomID;      
    Room room = null;  
    Scanner inputID = new Scanner(System.in);

        while(true){

            System.out.println("Please choose the room you want to book \n"+getRoomList(room));

            while(true){
                roomID = inputID.nextLine();
                if(roomID.equals ("x")){
                    break;
                }

                if(getRoom(roomID) == null){

                    System.out.println("The room ID is incorrect, please enter again or enter x to quit");

                }
                else{

                    room = getRoom(roomID);

                    if(!room.isBooked()){
                        System.out.println("Book successfully");
                        break;
                    }
                    else{
                        System.out.println("please enter the room ID again or enter x to quit");
                    }
                }

            }

        }

    }

public static String getRoomList(Room room)
{

    String roomList = "";
    for(Room r:room.getRoom())
    {

        if(!r.isBooked())
        {
            roomList = roomList+r.getRoomID()+" is free"+"   ";
        }
        else
        {
            roomList = roomList+r.getRoomID()+" has been booked ";
        }

    }
    return roomList;
}


public static Room getRoom(String roomID){

    for(Room r:room.getRoom()){

        if(r.getRoomID()==roomID){

            return r;

        }

    }
    return null;

}
}