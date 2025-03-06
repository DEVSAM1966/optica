package com.minka.optica.controllers;

import com.minka.optica.dataholders.PatientsDh;
import com.minka.optica.dto.PatientsDto;
import com.minka.optica.services.patients.PatientsService;
import java.util.List;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PatientsController {

  @NonNull
  private PatientsService patientsService;

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PatientsDto> create(@Validated @RequestBody final PatientsDh patientsDh) {
    return ResponseEntity.ok(this.patientsService.save(patientsDh));
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PatientsDto> findById(@Validated @PathVariable final Long id){
    return ResponseEntity.ok(this.patientsService.findById(id));
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<PatientsDto>> findAll() {
    return ResponseEntity.ok(this.patientsService.findAll());
  }

  @GetMapping(value = "/findbydni/{valor}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<PatientsDto>> findByDni(@Validated @PathVariable final String valor) {
    return ResponseEntity.ok(this.patientsService.findByDni(valor));
  }

  @GetMapping(value = "/findbyname/{valor}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<PatientsDto>> findByName(@Validated @PathVariable final String valor) {
    return ResponseEntity.ok(this.patientsService.findByName(valor));
  }

  @GetMapping(value = "/findbyphone/{valor}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<PatientsDto>> findByPhone(@Validated @PathVariable final String valor) {
    return ResponseEntity.ok(this.patientsService.findByPhone(valor));
  }

  @GetMapping(value = "/findbyemail/{valor}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<PatientsDto>> findByEmail(@Validated @PathVariable final String valor) {
    return ResponseEntity.ok(this.patientsService.findByEmail(valor));
  }

  @GetMapping(value = "/findbydischargedate/{valor}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<PatientsDto>> findByDischargeDate(@Validated @PathVariable final String valor) {
    return ResponseEntity.ok(this.patientsService.findByDischargeDate(valor));
  }

  @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PatientsDto> updateById(@Validated @PathVariable final Long id, @Validated @RequestBody final PatientsDh patientsDh) {
    return ResponseEntity.ok(this.patientsService.updateById(id, patientsDh));
  }


  @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Boolean> deleteById(@Validated @PathVariable final Long id) {
    return ResponseEntity.ok(this.patientsService.deleteById(id));
  }
}
