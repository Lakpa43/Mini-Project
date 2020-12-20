package com.Lakpa.StudentManagementSystem.Controller;

import com.Lakpa.StudentManagementSystem.Model.Student;
import com.Lakpa.StudentManagementSystem.Repository.StudentRepository;
import com.Lakpa.StudentManagementSystem.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/get")
    List<Student> getStudent() {
        return studentRepository.findAll();
    }

    @GetMapping("/get/{id}")
    Optional<Student> getOneStudent(@PathVariable(value = "id") Integer id) {
        return studentRepository.findById(id);
    }

    @PostMapping("/post")
    Student postStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PutMapping("/update/{id}")
    Student updateStudent(@PathVariable(value = "id") Integer id, @RequestBody Student updatedStudent) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Not Found", id, "student"));
        student.setId(updatedStudent.getId());
        student.setFirstName(updatedStudent.getFirstName());
        student.setLastName(updatedStudent.getLastName());
        student.setCourse(updatedStudent.getCourse());
        student.setFee(updatedStudent.getFee());
        return studentRepository.save(updatedStudent);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Student> deleteStudent(@PathVariable(value = "id") Integer id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Not Found", id, "student"));
        studentRepository.delete(student);
        return ResponseEntity.ok().build();
    }
}
