package part2.ex2.phone;

import part2.ex2.Builder;

public class Demo {
    public static void main(String[] args) {
        Address address = Builder.of(Address::new)
                .with(Address::setCountry,"Ukraine")
                .with(Address::setCity,"Kharkov")
                .with(Address::setStreet,"Nauki")
                .with(Address::setHouse,121)
                .with(Address::setFlat,8).build();
        Time time = Builder.of(Time::new)
                .with(Time::setUrban,200.45)
                .with(Time::setIntercity, 12.00).build();
        Phone phone = Builder.of(Phone::new)
                .with(Phone::setId, 1)
                .with(Phone::setFirstName,"Tom")
                .with(Phone::setLastName,"Soer")
                .with(Phone::setCreditNumber,100012)
                .with(Phone::setDebet,122.35)
                .with(Phone::setCredit,200.00)
                .with(Phone::setAddress,address)
                .with(Phone::setTime,time).build();
        System.out.println(phone.toString());
    }
}
