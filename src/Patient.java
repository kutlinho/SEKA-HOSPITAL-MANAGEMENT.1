import java.util.ArrayList;

public class Patient extends Person{
    private int weight;
    private int height;
    private boolean isInpatient;
    private String bloodGroup;
    private ArrayList<String> diagnosis = new ArrayList<String>();
    private ArrayList<Medicine> medicines = new ArrayList<Medicine>();
    private ArrayList<Doctor> doctors = new ArrayList<Doctor>();

    public Patient(String name, String id, String gender, String birthday,
                   int weight,int height,boolean isInpatient,String bloodGroup) {
        super(name, id, gender, birthday);
        this.weight = weight;
        this.height = height;
        this.isInpatient = isInpatient;
        this.bloodGroup = bloodGroup;
    }

    //Encapsulation Fields
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isInpatient() {
        return isInpatient;
    }

    public void setInpatient(boolean inpatient) {
        isInpatient = inpatient;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public ArrayList<String> getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(ArrayList<String> diagnosis) {
        this.diagnosis = diagnosis;
    }

    public ArrayList<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(ArrayList<Medicine> medicines) {
        this.medicines = medicines;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }
}
