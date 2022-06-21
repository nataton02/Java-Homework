package de.telran.dogs_owners.entity;

import lombok.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "breed")
    private String breed;

    @Column(name = "date_of_Birth")
    private String dateOfBirth;

    @Column(name = "registration_date")
    private String registrationDate;

    @ManyToOne
    @Column(name = "owner")
    private Owner owner;


}
