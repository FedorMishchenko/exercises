package collections.builder.students;

import java.util.function.Consumer;

public class Students {
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private Address address;
    private Faculty faculty;

    public Students(int id, String firstName,
                    String lastName, String phone
                    ,Address address, Faculty faculty) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.faculty = faculty;
    }

    public Students() {

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Students with(
            Consumer<Students> builderFunction) {
        builderFunction.accept(this);
        return this;
    }

    public Students create() {
        return new Students(
                id, firstName,lastName,phone,address,faculty);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", phone=").append(phone);
        sb.append(", address=").append(address.toString());
        sb.append(", faculty=").append(faculty.toString());
        return sb.toString();
    }
}
