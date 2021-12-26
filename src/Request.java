public class Request {
    private String explanation;
    private HealthCareStaff byWho;


    public Request(String explanation, HealthCareStaff byWho) {
        this.setExplanation(explanation);
        this.setByWho(byWho);
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public HealthCareStaff getByWho() {
        return byWho;
    }

    public void setByWho(HealthCareStaff byWho) {
        this.byWho = byWho;
    }
}
