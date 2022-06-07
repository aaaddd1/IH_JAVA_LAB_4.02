package com.ironhack.lab2.repository;

import com.ironhack.lab2.models.Doctor;
import com.ironhack.lab2.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    public List<Patient> findByDateOfBirthBetween(Date min, Date max);

    @Query(value = "SELECT * FROM patient  JOIN doctor ON doctor.id = patient.admitted_by WHERE department = :department ", nativeQuery = true)
    public List<Patient> findAllPatientByDepartament(@Param("department") String department);

}
