package part2.ex2.customer;

import java.util.Objects;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private long creditNumber;
    private long account;

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

    public long getCreditNumber() {
        return creditNumber;
    }

    public void setCreditNumber(long creditNumber) {
        this.creditNumber = creditNumber;
    }

    public long getAccount() {
        return account;
    }

    public void setAccount(long account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                creditNumber == customer.creditNumber &&
                account == customer.account &&
                firstName.equals(customer.firstName) &&
                lastName.equals(customer.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, creditNumber, account);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", creditNumber=").append(creditNumber);
        sb.append(", account=").append(account);
        sb.append('}');
        return sb.toString();
    }

    public static class Builder{
        private Customer customer;

        public Builder(){
            customer = new Customer();
        }


        public Builder withID(int id){
            customer.id = id;
            return this;
        }
        public Builder withName(String name){
            customer.firstName = name;
            return this;
        }
        public Builder withLastName(String lastName){
            customer.lastName = lastName;
            return this;
        }
        public Builder withCreditNumber(long creditNumber){
            customer.creditNumber = creditNumber;
            return this;
        }
        public Builder withAccount(long account){
            customer.account = account;
            return this;
        }
        public Customer build(){
            return customer;
        }
    }
}
