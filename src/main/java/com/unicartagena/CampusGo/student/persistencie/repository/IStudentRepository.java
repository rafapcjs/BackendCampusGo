package com.unicartagena.CampusGo.student.persistencie.repository;

import com.unicartagena.CampusGo.student.persistencie.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
}
