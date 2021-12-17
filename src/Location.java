public class Location {
    private String roomName;
    private int floor;
    private Policlinic policlinic;

    public Location(String roomName, int floor, Policlinic policlinic) {
        this.setRoomName(roomName);
        this.setFloor(floor);
        this.setPoliclinic(policlinic);
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Policlinic getPoliclinic() {
        return policlinic;
    }

    public void setPoliclinic(Policlinic policlinic) {
        this.policlinic = policlinic;
    }
}
