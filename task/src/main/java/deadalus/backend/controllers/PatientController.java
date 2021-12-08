package deadalus.backend.controllers;

import deadalus.backend.dtos.PatientPayload;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import deadalus.backend.services.PatientService;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping("/{patientId}")
    @ApiOperation(value = "${patient.get}")
    public ResponseEntity<PatientPayload> transferedPatient(@PathVariable String patientId) {
        PatientPayload result = patientService.getPayload(patientId);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    @ApiOperation(value = "${patient.create}")
    public ResponseEntity<PatientPayload> transferFhirPatient(@RequestBody final PatientPayload patientPayload) {
        PatientPayload result = patientService.savePayload(patientPayload);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{patientId}")
    @ApiOperation(value = "${patient.update}")
    public ResponseEntity<PatientPayload> updateFhirPatient(@PathVariable String patientId,
                                                        @RequestBody final PatientPayload patientPayload) {
        PatientPayload result = patientService.updatePayload(patientId, patientPayload);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{patientId}")
    @ApiOperation(value = "${patient.delete}")
    public ResponseEntity<Object> deleteFhirPatient(@PathVariable String patientId) {
        patientService.deletePayload(patientId);
        return ResponseEntity.noContent().build();
    }

}
