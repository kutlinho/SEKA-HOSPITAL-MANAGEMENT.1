public class InpatientRoom {
    private int roomId;
    private boolean isEmpty;


    public InpatientRoom(int roomId, boolean isEmpty) {
        this.setRoomId(roomId);
        this.setEmpty(isEmpty);
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
}
