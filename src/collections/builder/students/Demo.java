package collections.builder.students;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        Students student = new Students()
                .with(x -> {
                    x.setId(1);
                    x.setFirstName("Richard");
                    x.setLastName("Wagner");
                    x.setPhone("095-333-23-32");
                })
                .with(x -> x.setAddress(
                        new Address()
                        .setCity("Kharkiv")
                        .setStreet("Street")
                        .setHouse(20)
                        .setFlat(1)
                ))
                .with(x -> x.setFaculty(
                        new Faculty()
                        .setFaculty("Computer science")
                        .setCourse(2)
                        .setGroup(2)
                ))
                .create();
        System.out.println(student.toString());
        List<Students> list = Stream.of(student)
        .filter(x -> x.getFaculty().getFaculty().equals("Computer science"))
        .peek(x -> System.out.println(x.getFirstName()))
        .collect(Collectors.toList());
        System.out.println("Size=" + list.size());
    }
}
