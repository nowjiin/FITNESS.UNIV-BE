package com.hecto.fitnessuniv.entity;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "mentor_profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MentorProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserEntity user;

    @Column(name = "exercises", columnDefinition = "TEXT")
    private String exercises;

    @Column(name = "regions", columnDefinition = "TEXT")
    private String regions;

    private String gender;
    private String rate;
    private String details;
    private String university;
    private String major;
    private String studentId;
    private String enrollmentStatus;
    private String certifications;

    // Setters that convert List<String> to comma-separated String
    public void setExercises(List<String> exercises) {
        this.exercises = String.join(",", exercises);
    }

    public void setRegions(List<String> regions) {
        this.regions = String.join(",", regions);
    }

    // Getters that convert comma-separated String to List<String>
    public List<String> getExercises() {
        return Arrays.asList(exercises.split(","));
    }

    public List<String> getRegions() {
        return Arrays.asList(regions.split(","));
    }
}
