package part2.ex2.students;

public class Address {
    private String city;
    private String street;
    private int house;
    private int flat;

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Address setStreet(String street) {
        this.street = street;
        return this;
    }

    public int getHouse() {
        return house;
    }

    public Address setHouse(int house) {
        this.house = house;
        return this;
    }

    public int getFlat() {
        return flat;
    }

    public Address setFlat(int flat) {
        this.flat = flat;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("city='").append(city).append('\'');
        sb.append(", street='").append(street).append('\'');
        sb.append(", house=").append(house);
        sb.append(", flat=").append(flat);
        return sb.toString();
    }
}
