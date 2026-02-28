package nimblix.in.HealthCareHub.controller;

import lombok.RequiredArgsConstructor;
import nimblix.in.HealthCareHub.request.PatientRegistrationRequest;
import nimblix.in.HealthCareHub.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping("/register")
    public String registerPatient(@RequestBody PatientRegistrationRequest request) {
        return patientService.registerPatient(request);
    }

    @GetMapping("/getPatientDetails/{patientId}/{hospitalId}")
    public ResponseEntity<?> getPatientDetails(@PathVariable Long patientId,
                                               @PathVariable Long hospitalId) {
        return patientService.getPatientDetails(patientId, hospitalId);
    }

    @PutMapping("/updatePatientDetails")
    public String updatePatientDetails(@RequestBody PatientRegistrationRequest request) {
        return patientService.updatePatientDetails(request);
    }

    @DeleteMapping("/deletePatientDetails")
    public String deletePatientDetails(@RequestParam Long patientId) {
        return patientService.deletePatientDetails(patientId);
    }
}