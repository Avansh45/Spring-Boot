package in.avansh.Spring_Boot_CRUD.repository;

import in.avansh.Spring_Boot_CRUD.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student , Long> {

}
