package com.unicartagena.CampusGo.teacher.persistencie.entity;

import com.unicartagena.CampusGo.commons.entities.BaseEntity;
import com.unicartagena.CampusGo.user.persistencie.entities.UserEntity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "teacher")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher extends BaseEntity {


    @OneToOne
    @MapsId
    @JoinColumn(name = "id_user")
    private UserEntity user;
}