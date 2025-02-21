package com.minka.optica.controllers;

import com.minka.optica.dataholders.OptometriesDh;
import com.minka.optica.dto.OptometriesDto;
import com.minka.optica.services.optometries.OptometriesService;
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
@RequestMapping("/optometrias")
@RequiredArgsConstructor
public class OptometriesController {

  @NonNull
  private OptometriesService optometriesService;

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<OptometriesDto> create(@Validated @RequestBody final OptometriesDh optometriesDh) {
    return ResponseEntity.ok(this.optometriesService.save(optometriesDh));
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<OptometriesDto> findById(@Validated @PathVariable final Long id) {
    return ResponseEntity.ok(this.optometriesService.findById(id));
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<OptometriesDto>> findAll() {
    return ResponseEntity.ok(this.optometriesService.findAll());
  }

  @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<OptometriesDto> updateById(@Validated @PathVariable final Long id, @Validated @RequestBody final OptometriesDh optometriesDh) {
    return ResponseEntity.ok(this.optometriesService.updateById(id, optometriesDh));
  }

  @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Boolean> deleteById(@Validated @PathVariable final Long id) {
    return ResponseEntity.ok(this.optometriesService.deleteById(id));
  }

}
