package functional_programing_in_action;

import functional_programing_in_action.beans.Person;
import functional_programing_in_action.mockdata.MockData;

import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

public class Tester2 {
    public static void main(String[] args) throws IOException {
       List<Person> people=MockData.getPeople();
       IntStream.range(0,5).forEach(index-> System.out.println(people.get(index)));
       people.stream().limit(5).forEach(System.out::println);
    }
}
