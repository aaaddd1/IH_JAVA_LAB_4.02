package com.ironhack.lab2.controller;

import com.ironhack.lab2.enums.Status;
import com.ironhack.lab2.models.Doctor;
import com.ironhack.lab2.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoctorController {


    @Autowired
    DoctorRepository doctorRepository;

    @GetMapping("doctor/find-all")
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @GetMapping("doctor/id/{id}")
    public Doctor findDoctorById(@PathVariable long id) {
        if (doctorRepository.findById(id).isPresent()) {
            return doctorRepository.findById(id).get();
        }
        return null;
    }

    @GetMapping("doctor/status/{status}")
    public List<Doctor> findDoctorByStatus(@PathVariable Status status) {
        return doctorRepository.findByStatus(status);
    }

    @GetMapping("doctor/department")
    public List<Doctor> findDoctorByDepartament(@RequestParam String department) {
        return doctorRepository.findByDepartment(department);
    }

}
