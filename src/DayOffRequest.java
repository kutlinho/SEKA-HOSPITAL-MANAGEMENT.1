public class DayOffRequest extends Request{
    private int dayOffCount;

    public DayOffRequest(String explanation, HealthCareStaff byWho, int dayOffCount) {
        super(explanation, byWho);
        this.setDayOffCount(dayOffCount);
    }

    public int getDayOffCount() {
        return dayOffCount;
    }

    public void setDayOffCount(int dayOffCount) {
        this.dayOffCount = dayOffCount;
    }
}
