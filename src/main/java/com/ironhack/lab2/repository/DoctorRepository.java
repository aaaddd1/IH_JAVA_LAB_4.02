package com.ironhack.lab2.repository;

import com.ironhack.lab2.enums.Status;
import com.ironhack.lab2.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    public Optional<Doctor> findById(Long id);

    public List<Doctor> findByStatus(Status status);

    public List<Doctor> findByDepartment(String department);
}
