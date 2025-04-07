import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        LinkedList<Room> rooms = new LinkedList<>();
        rooms.add(new Room("Bedroom", 50));
        rooms.add(new Room("Bathroom", 20));
        rooms.add(new Room("kitchen", 30));
        rooms.add(new Room("Hall", 10));

        House house = new House(rooms);
        System.out.println(house.addRoom(new Room("Bedroom", 40)));
    }
}