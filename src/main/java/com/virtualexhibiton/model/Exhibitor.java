package com.virtualexhibiton.model;

import jakarta.persistence.*;
import lombok.*;


import java.util.Set;

@Data
@Builder
@Entity
@Table(name = "exhibitor")
@AllArgsConstructor
@NoArgsConstructor
public class Exhibitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "contact_person")
    private String contactPerson;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne(mappedBy = "exhibitor")
    private Stall stall;

    // Other fields and methods...
}
