package in.avansh.Spring_Boot_CRUD.service;

import in.avansh.Spring_Boot_CRUD.entity.Student;
import in.avansh.Spring_Boot_CRUD.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    public Student createStudent(Student studentReq){

        Student studentResp = studentRepository.save(studentReq);

        return studentResp;

    }

    public Student getStudent(Long id){

        Optional<Student> requestedStudent = studentRepository.findById(id);

        return requestedStudent.orElse(null);
    }

    public List<Student> getAllStudents(){

        return studentRepository.findAll();
    }

    public Student updateStudent(Long id,Student requestedStudent){

        Optional<Student> existingStudent = studentRepository.findById(id);
        if(existingStudent.isEmpty()){
            return null;
        }

        Student studentToSave = existingStudent.get();

        studentToSave.setName(requestedStudent.getName());
        studentToSave.setAge(requestedStudent.getAge());
        studentToSave.setEmail(requestedStudent.getEmail());
        studentToSave.setRollNo(requestedStudent.getRollNo());
        studentToSave.setSubject(requestedStudent.getSubject());

        return studentRepository.save(studentToSave);

    }

    public Boolean deleteStudent(Long id){

        boolean isStudentExists = studentRepository.existsById(id);
        if(!isStudentExists) return false;
        studentRepository.deleteById(id);
        return true;
    }
}
