public class MedicineRequest extends Request{
    private Medicine medicine;

    public MedicineRequest(String explanation, HealthCareStaff byWho, Medicine medicine) {
        super(explanation, byWho);
        this.setMedicine(medicine);
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }
}
