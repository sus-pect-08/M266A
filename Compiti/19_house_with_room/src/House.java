import java.util.LinkedList;
import java.util.Objects;

public class House {
    private LinkedList<Room> rooms;

    public House(LinkedList<Room> rooms) {
        this.rooms = rooms;
    }

    public LinkedList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(LinkedList<Room> rooms) {
        this.rooms = rooms;
    }

    public String addRoom(Room room) {
        rooms.add(room);
        return toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return Objects.equals(rooms, house.rooms);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(rooms);
    }

    @Override
    public String toString() {
        return "House " +
                "rooms: \n"+ rooms ;
    }
}
