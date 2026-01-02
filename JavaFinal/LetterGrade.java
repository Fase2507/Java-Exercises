package JavaFinal;

public enum LetterGrade {

    AA(4.00), BA(3.50), BB(3.25),
    CB(3.00), CC(2.50),
    DC(2.25), DD(2.00),
    FD(1.50), FF(0.00);

    private double value;

    LetterGrade(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
