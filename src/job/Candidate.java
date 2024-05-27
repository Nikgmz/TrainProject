package job; //adres kum papkata job

public class Candidate {
    String name;
    double years;
    double yearsExp;

    public Candidate(String name, double years, double yearsExp) {
        this.name = name;
        this.years = years;
        this.yearsExp = yearsExp;
    }

    @Override
    public String toString() {
        return "Candidate:" +
                "Name: " + name +
                " Age: " + years +
                " Experience: " + yearsExp;
    }
}
