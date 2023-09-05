package com.springboot.RestAPI.controller;
import com.springboot.RestAPI.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(1,"Ravi","Chandola");
        //return new ResponseEntity<>(student,HttpStatus.OK);
        return ResponseEntity.ok()
                .header("custom-header","ramesh")
                .body(student);
    }
@GetMapping("students")
    public ResponseEntity <List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Ram","Srivastav"));
        students.add(new Student(2,"Girish","Srivastav"));
        students.add(new Student(3,"Nimish","Srivastav"));
        students.add(new Student(4,"Dakshita","Srivastav"));
        return ResponseEntity.ok(students);
    }
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVar(@PathVariable("id") int studentId,
                                  @PathVariable("first-name") String firstName,
                                  @PathVariable("last-name") String lastName
                                  ){
        Student student = new Student(studentId,firstName,lastName);
        return ResponseEntity.ok(student);
    }

    //Spring Boot Rest API with Request Param
    //localhost:8081/students/query?id=2&firstName=Ravi&lastName=Chandola
    @GetMapping("students/query")
    public ResponseEntity <Student> studentRequestParam(@RequestParam int id,@RequestParam String firstName,@RequestParam String lastName){
        Student student = new Student(id,firstName,lastName);
        return ResponseEntity.ok(student);
    }

    //Spring Boot Rest API that handles HTTP Post Request
    //@PostMapping and @RequestBody
    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }

    //Updating the REST API
    @PutMapping("students/{id}/update")
    public ResponseEntity<Student> updateStatus(@RequestBody Student student,@PathVariable("id") int studentId){
        return new ResponseEntity.ok(student);
    }

    //Deleting the REST API
    @DeleteMapping("students/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        return ResponseEntity.ok("Student deleted Successfully!");
    }
}
