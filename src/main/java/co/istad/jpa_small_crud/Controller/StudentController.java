package co.istad.jpa_small_crud.Controller;

import co.istad.jpa_small_crud.model.Student;
import co.istad.jpa_small_crud.model.StudentRequest;
import co.istad.jpa_small_crud.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<?> getAllStudent(){
        List<Student> students = studentService.getAllStudent();
        return ResponseEntity.ok(students);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Integer id){
        Optional<Student> student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }


    @PostMapping
    public ResponseEntity<?> createStudent(@Valid @RequestBody StudentRequest studentRequest
    ){
        Student student = studentService.insertStudent(studentRequest);
        return ResponseEntity.ok(student);
    }


    @PutMapping("{id}")
    public ResponseEntity<?> updateStudent(@RequestBody StudentRequest studentRequest, @PathVariable Integer id){
        Student student = studentService.updateStudent(studentRequest, id);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id){
        Student student = studentService.deleteStudentById(id);
        return ResponseEntity.ok(student);
    }
}
