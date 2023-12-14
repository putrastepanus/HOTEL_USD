package Data;
import java.util.ArrayList;
import java.util.List;

public class CreateRooms {
    private List<String> roomList;

    public CreateRooms() {
        roomList = new ArrayList<>();
    }

    public void addRoom(String room) {
        roomList.add(room);
    }

    public List<String> getRoomList() {
        return roomList;
    }
}