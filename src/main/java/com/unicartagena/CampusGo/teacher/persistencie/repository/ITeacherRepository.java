package com.unicartagena.CampusGo.teacher.persistencie.repository;


import com.unicartagena.CampusGo.teacher.persistencie.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeacherRepository extends JpaRepository<Teacher, Long> {
}
