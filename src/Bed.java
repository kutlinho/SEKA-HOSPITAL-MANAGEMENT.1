public class Bed {
    private String bedId;
    private boolean isEmpty;

    public Bed(String bedId, boolean isEmpty) {
        this.setBedId(bedId);
        this.setEmpty(isEmpty);
    }

    public String getBedId() {
        return bedId;
    }

    public void setBedId(String bedId) {
        this.bedId = bedId;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
}
