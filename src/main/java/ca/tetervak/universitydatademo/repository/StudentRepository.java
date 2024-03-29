package ca.tetervak.universitydatademo.repository;

import ca.tetervak.universitydatademo.domain.Person;
import ca.tetervak.universitydatademo.domain.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * DataSource Management for the Students at the University.
 *
 * Created by maryellenbowman
 */
public interface StudentRepository extends CrudRepository<Student, Integer>{
    //Simple Query Methods
    @Query("Select s from Student s")
    List<Student>findAllStudent();
    List<Student> findByFullTime(boolean fullTime);
    List<Student> findByAge(Integer age);
    List<Student> findByAttendeeLastName(String last);

    //Query Methods with Clauses and Expressions
    Student findByAttendeeFirstNameAndAttendeeLastName(String firstName, String lastName);
    Student findByAttendee(Person person);
    List<Student> findByAgeGreaterThan(int minimumAge);
    List<Student> findByAgeLessThan(int maximumAge);
    List<Student> findByAttendeeLastNameIgnoreCase(String lastName);
    List<Student> findByAttendeeLastNameLike(String likeString);
    Student findFirstByOrderByAttendeeLastNameAsc();
    Student findTopByOrderByAgeDesc();
    List<Student> findTop3ByOrderByAgeDesc();
}
