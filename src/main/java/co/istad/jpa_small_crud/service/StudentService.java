package co.istad.jpa_small_crud.service;

import co.istad.jpa_small_crud.model.Student;
import co.istad.jpa_small_crud.model.StudentRequest;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudent();

    Student insertStudent(StudentRequest studentRequest);

    Student updateStudent(StudentRequest studentRequest, Integer id);

    Optional<Student> getStudentById(Integer id);


    Student deleteStudentById(Integer id);
}
