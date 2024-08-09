package co.istad.jpa_small_crud.service.serviceImpl;

import co.istad.jpa_small_crud.exception.CustomerNotFoundException;
import co.istad.jpa_small_crud.model.Student;
import co.istad.jpa_small_crud.model.StudentRequest;
import co.istad.jpa_small_crud.repository.StudentRepository;
import co.istad.jpa_small_crud.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;


    @Override
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    @Override
    public Student insertStudent(StudentRequest studentRequest) {
        Student  student = new Student();
        student.setName(studentRequest.getName());
        student.setAge(String.valueOf(studentRequest.getAge()));
        student.setPayment(studentRequest.getPayment());
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(StudentRequest studentRequest, Integer id){
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new CustomerNotFoundException("id is not found : " + id)
        );
        student.setName(studentRequest.getName());
        student.setAge(String.valueOf(studentRequest.getAge()));
        student.setPayment(studentRequest.getPayment());
       return studentRepository.save(student);
    }

    @Override
    public Optional<Student> getStudentById(Integer id) {
        return Optional.ofNullable(studentRepository.findById(id).orElseThrow(
                () -> new CustomerNotFoundException("Product is not found !")
        ));
//        return studentRepository.findById(id);
    }

    @Override
    public Student deleteStudentById(Integer id){
//        Student student = studentRepository.findById(id).orElseThrow(
//                () -> new CustomerNotFoundException("Student id is not found")
//        );
//         studentRepository.deleteById(id);
//         return student;

        Optional<Student> deleteStudent = getStudentById(id);
        if(deleteStudent.isEmpty()){
            throw new CustomerNotFoundException("Student id is not found");
        }
        Student student = deleteStudent.get();
        studentRepository.deleteById(id);
        return student;

    }


}
