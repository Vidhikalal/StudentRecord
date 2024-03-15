package ca.tetervak.universitydatademo.controllers;

import ca.tetervak.universitydatademo.domain.Staff;
import ca.tetervak.universitydatademo.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/staffs")
public class StaffController {
    @Autowired
    StaffRepository staffRepository;
    @PutMapping("/{id}")
    public String putStaff(@RequestBody Staff staff, @PathVariable Integer id){
        staff.setId(id);
        staffRepository.save(staff);
        return "Total Records:" + staffRepository.count();
    }
    @PutMapping("/staff")
    public String putStaffList(@RequestBody List<Staff> staffList){
        staffRepository.saveAll(staffList);
        return "Ok";

    }

    @GetMapping
    public List<Staff> getAllStaff(){
        List<Staff>staffList=new ArrayList<>();
        staffRepository.findAll().forEach(staffList::add);

        return staffList;
    }
}
