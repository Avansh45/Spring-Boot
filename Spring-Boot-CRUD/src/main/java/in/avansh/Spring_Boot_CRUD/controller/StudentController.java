package in.avansh.Spring_Boot_CRUD.controller;

import in.avansh.Spring_Boot_CRUD.entity.Student;
import in.avansh.Spring_Boot_CRUD.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping()
    public ResponseEntity<Student> createStudent(@RequestBody Student student){

        Student createdStudent = studentService.createStudent(student);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdStudent);
    }

    @GetMapping("/get")
    public ResponseEntity<Student> getStudent(@RequestParam Long id){

        Student student = studentService.getStudent(id);

        if(student == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(student);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudents(){

        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestParam Long id, @RequestBody Student student){

        Student updatedStudent = studentService.updateStudent(id,student);

        if(updatedStudent == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudent(@RequestParam Long id){

        Boolean isDeleted = studentService.deleteStudent(id);

        if(!isDeleted) return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Student not found");

        return ResponseEntity.ok("Student deleted successfully");
    }

    @PatchMapping("/delete-soft")
    public ResponseEntity<String> deleteStudentSoftly(@RequestParam Long id){

        Boolean isDeletedSoftly = studentService.deleteStudentSoftly(id);

        if(!isDeletedSoftly) return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Student not found");

        return ResponseEntity.ok("Student deleted(Softly) successfully");

    }
}
