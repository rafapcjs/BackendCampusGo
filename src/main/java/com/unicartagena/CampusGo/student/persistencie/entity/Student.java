package com.unicartagena.CampusGo.student.persistencie.entity;

import com.unicartagena.CampusGo.commons.entities.BaseEntity;
import com.unicartagena.CampusGo.user.persistencie.entities.UserEntity;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "students")
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student extends BaseEntity {


    @OneToOne
    @MapsId
    @JoinColumn(name = "id_user")
    private UserEntity user;
}