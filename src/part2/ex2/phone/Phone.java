package part2.ex2.phone;

public class Phone {
    private int id;
    private String firstName;
    private String lastName;
    private int creditNumber;
    private double debet;
    private double credit;
    private Address address;
    private Time time;

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

    public int getCreditNumber() {
        return creditNumber;
    }

    public void setCreditNumber(int creditNumber) {
        this.creditNumber = creditNumber;
    }

    public double getDebet() {
        return debet;
    }

    public void setDebet(double debet) {
        this.debet = debet;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Phone{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", creditNumber=").append(creditNumber);
        sb.append(", debet=").append(debet);
        sb.append(", credit=").append(credit);
        sb.append(", address=").append(address.toString());
        sb.append(", time=").append(time.toString());
        sb.append('}');
        return sb.toString();
    }
}
