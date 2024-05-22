package job;

public class Candidate {
    String name;
    int years;
    int yearsExp;

    public Candidate(String name, int years, int yearsExp) {
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
