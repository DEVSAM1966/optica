package com.minka.optica.services.optometries;

import com.minka.optica.dataholders.OptometriesDh;
import com.minka.optica.dto.OptometriesDto;
import com.minka.optica.entities.Optometries;
import com.minka.optica.exceptions.BdNotFoundException;
import com.minka.optica.exceptions.BdNotSaveException;
import com.minka.optica.exceptions.DischargeDateException;
import com.minka.optica.mapper.OptometriesMapper;
import com.minka.optica.parser.Parser;
import com.minka.optica.repository.OptometriesRepository;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.env.ConfigTreePropertySource.Option;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Slf4j
@Service
@RequiredArgsConstructor
public class OptometriesServiceImp implements OptometriesService{

  @NonNull
  private final OptometriesRepository optometriesRepository;

  @NonNull
  private final OptometriesMapper optometriesMapper;

  @Override
  public OptometriesDto save(final OptometriesDh optometriesDh) {
    Parser.Evaluator(optometriesDh, "POST");

    final Optometries optometries = this.optometriesMapper.asEntity(optometriesDh);
    final Optometries optometriesSaved = this.optometriesRepository.save(optometries);
    final OptometriesDto optometriesDto = this.optometriesMapper.asDto(optometriesSaved);
    return optometriesDto;
  }

  @Override
  public OptometriesDto findById(final Long id) {
    final Optional<Optometries> optometriesOptional = this.optometriesRepository.findById(id);
    if (optometriesOptional.isPresent()) {
      final OptometriesDto optometriesDto = this.optometriesMapper.asDto(optometriesOptional.get());
      return optometriesDto;
    } else {
      throw new BdNotFoundException("GET - There are no optometries in the database for the id: " + id);
    }
  }

  @Override
  public List<OptometriesDto> findAll() {
    final List<Optometries> optometriesList =(List<Optometries>) this.optometriesRepository.findAll();
    if (CollectionUtils.isEmpty(optometriesList)) {
      log.warn("Findall - There are no optometries in the database");
      return Collections.emptyList();
    } else {
      final List<OptometriesDto> optometriesDtoList = this.optometriesMapper.asDtoList(optometriesList);
      return optometriesDtoList;
    }
  }

  @Override
  public List<OptometriesDto> findByOptometrist(final String valor) {
    final List<Optometries> optometriesList =(List<Optometries>) this.optometriesRepository.findByOptometrist(valor);
    if (CollectionUtils.isEmpty(optometriesList)) {
      log.warn("FindByOptometrist - There are no optometries in the database");
      return Collections.emptyList();
    } else {
      final List<OptometriesDto> optometriesDtoList = this.optometriesMapper.asDtoList(optometriesList);
      return optometriesDtoList;
    }
  }

  @Override
  public List<OptometriesDto> findByDischargeDate(final String valor) {
    final List<Optometries> optometriesList =(List<Optometries>) this.optometriesRepository.findByDischargeDate(valor);
    if (CollectionUtils.isEmpty(optometriesList)) {
      log.warn("FindByDischargeDate - There are no optometries in the database");
      return Collections.emptyList();
    } else {
      final List<OptometriesDto> optometriesDtoList = this.optometriesMapper.asDtoList(optometriesList);
      return optometriesDtoList;
    }
  }

  @Override
  public OptometriesDto updateById(final Long id, final OptometriesDh optometriesDh) {
    Parser.Evaluator(optometriesDh, "PUT");

    final Optometries optometries = this.optometriesMapper.asEntity(optometriesDh);
    final Optional<Optometries> existOptomeries = this.optometriesRepository.findById(id);

    if (optometriesDh.getIdOptometry() != id) {
      throw new BdNotSaveException("PUT - Parameters are incorrect for field idOptometry: " + optometriesDh.getIdOptometry() + " is different at is: " + id);
    }

    if (existOptomeries.isPresent()) {
      final Optometries optometriesSaved = this.optometriesRepository.save(optometries);
      final OptometriesDto optometriesDto = this.optometriesMapper.asDto(optometriesSaved);
      return optometriesDto;
    } else {
      throw new BdNotFoundException("PUT - There is no optometries in the database with the id: " + id);
    }
  }

  @Override
  public Boolean deleteById(final Long id) {
    final Optional<Optometries> existOptometries = this.optometriesRepository.findById(id);
    if (existOptometries.isPresent()) {
      Optometries optometry = existOptometries.get();

      // Validar si dischargeDate es nulo o vacio
      String dischargeDate = optometry.getDischargeDate();
      if (dischargeDate == null || dischargeDate.trim().isEmpty()) {
        throw new DischargeDateException("The field dischargeDate is null or empty for the optometry ID: " + id);
      }

      // Convertir String a LofechacalDate
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      LocalDate fecha = LocalDate.parse(optometry.getDischargeDate(), formatter);

      // Fecha actual
      LocalDate fechaActual = LocalDate.now();

      // Calcular la diferencia en días
      long diferenciaDias = ChronoUnit.DAYS.between(fecha, fechaActual);

      // Resultado
      System.out.println("Delete of optometry. Difference in days: " + diferenciaDias);

      // Calcular la diferencia
      Period periodo = Period.between(fecha, fechaActual);

      if (diferenciaDias > 1826) {
        this.optometriesRepository.deleteById(id);
        return true;
      }
      return false;
    } else {
      throw new BdNotFoundException("DELETE - There is no optometries in the database with the id: " + id);
    }
  }

}
