package com.doctor.doctorregistration.controllers;

import com.doctor.doctorregistration.models.DoctorDetails;
import com.doctor.doctorregistration.models.RegistrationResponse;
import com.doctor.doctorregistration.repositories.DoctorDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
public class DoctorDetailsController {

    @Autowired
    private DoctorDetailsRepository doctorDetailsRepository;

    @RequestMapping(value = "/registerDoctor", method = RequestMethod.POST)
    public ResponseEntity<RegistrationResponse> registerDoctor(@RequestBody DoctorDetails doctorDetails) {
            doctorDetailsRepository.save(doctorDetails);
            RegistrationResponse registrationResponse = new RegistrationResponse();
            registrationResponse.setDoctorId(doctorDetails.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(registrationResponse);
    }



}
