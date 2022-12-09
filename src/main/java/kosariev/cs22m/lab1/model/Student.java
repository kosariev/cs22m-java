package kosariev.cs22m.lab1.model;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String passportSeries;
    private String passportNumber;

    public Student() {
        super();
    }

    public Student(int id, String firstName, String lastName, String passportSeries, String passportNumber) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportSeries = passportSeries;
        this.passportNumber = passportNumber;
    }

    public Student(String firstName, String lastName, String passportSeries, String passportNumber) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportSeries = passportSeries;
        this.passportNumber = passportNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Override
    public String toString() {
        return String.format("Student [id=%s, first_name=%s, last_name=%s, passport_series=%s, passport_number=%s]", id, firstName, lastName, passportSeries, passportNumber);
    }
}
