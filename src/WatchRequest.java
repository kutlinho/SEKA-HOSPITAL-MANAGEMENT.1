public class WatchRequest extends Request{
    private int watchCount;

    public WatchRequest(String explanation, HealthCareStaff byWho, int watchCount) {
        super(explanation, byWho);
        this.setWatchCount(watchCount);
    }

    public int getWatchCount() {
        return watchCount;
    }

    public void setWatchCount(int watchCount) {
        this.watchCount = watchCount;
    }
}
