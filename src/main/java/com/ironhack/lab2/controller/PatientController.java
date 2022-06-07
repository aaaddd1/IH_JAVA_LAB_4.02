package com.ironhack.lab2.controller;

import com.ironhack.lab2.enums.Status;
import com.ironhack.lab2.models.Patient;
import com.ironhack.lab2.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @GetMapping("patient/find-all")
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    @GetMapping("patient/find-all-date/")
    public List<Patient> getAllPatientByDate(@RequestParam Date min, @RequestParam Date max) {
        return patientRepository.findByDateOfBirthBetween(min, max);
    }

    @GetMapping("patient/find-all-department/{department}")
    public List<Patient> getAllPatientByDepartment(@PathVariable String department) {
        return patientRepository.findAllPatientByDepartament(department);
    }

    @GetMapping("patient/find-all-status/off")
    public List<Patient> getAllPatientByStatusOff() {
        ArrayList<Patient> result = new ArrayList<>();
        for (Patient patient : patientRepository.findAll()) {
            if (patient.getAdmittedBy().getStatus().equals(Status.OFF)) {
                result.add(patient);

            }
        }
        return result;
    }


}
