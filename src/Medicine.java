public class Medicine {
    private String medName;
    private int medStock;

    public Medicine(String medName, int medStock) {
        this.setMedName(medName);
        this.setMedStock(medStock);
    }

    public String getMedName() {
        return medName;
    }

    public void setMedName(String medName) {
        this.medName = medName;
    }

    public int getMedStock() {
        return medStock;
    }

    public void setMedStock(int medStock) {
        this.medStock = medStock;
    }
}
