package ca.tetervak.universitydatademo.controllers;

import ca.tetervak.universitydatademo.domain.Student;
import ca.tetervak.universitydatademo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")

public class StudentController {

    @Autowired
    StudentRepository studentRepository;


    @PutMapping("/{id}")
    public String putIndividualStudent(@RequestBody Student student, @PathVariable Integer id){
        student.setStudentId(id);
        studentRepository.save(student);
        return "Total Records:" + studentRepository.count();
    }
    @PutMapping("/student")
    public String putStudentList(@RequestBody List<Student> studentList){
        studentRepository.saveAll(studentList);
        return "Ok";

    }

    @GetMapping()
    public List<Student>getAllStudents(){
//        List<Student>studentList=new ArrayList<>();
//        studentRepository.findAll().forEach(studentList::add);
////        Iterable<Student>studentIterable=studentRepository.findAll();
//        return studentList;
        return studentRepository.findAllStudent();

    }


}
