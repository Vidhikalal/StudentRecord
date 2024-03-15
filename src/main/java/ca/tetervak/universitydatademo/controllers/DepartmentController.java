package ca.tetervak.universitydatademo.controllers;

import ca.tetervak.universitydatademo.domain.Department;
import ca.tetervak.universitydatademo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    DepartmentRepository departmentRepository;
    @PutMapping("/{id}")
    public String putDepartment(@RequestBody Department department, @PathVariable Integer id){
        department.setId(id);
        departmentRepository.save(department);
        return "Total Records:" + departmentRepository.count();
    }
    @PutMapping("/department")
    public String putDepartmentList(@RequestBody List<Department> departmentList){
        departmentRepository.saveAll(departmentList);
        return "Ok";

    }
    @GetMapping
    public List<Department> getAllDepartments(){
        List<Department>departmentList=new ArrayList<>();
        departmentRepository.findAll().forEach(departmentList::add);

        return departmentList;
    }
}
