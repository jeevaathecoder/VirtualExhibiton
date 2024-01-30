package com.virtualexhibiton.model;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;



@Data
@Builder
@Entity
@Table(name = "stall")
@AllArgsConstructor
@NoArgsConstructor
public class Stall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stall_name")
    private String stallName;

    @Column(name = "stall_description")
    private String stallDescription;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "video_url")
    private String videoUrl;

    @Column(name = "brochure_url")
    private String brochureUrl;

    @OneToOne
    @JoinColumn(name = "exhibitor_id")
    private Exhibitor exhibitor;

    // Other fields and methods...
}

