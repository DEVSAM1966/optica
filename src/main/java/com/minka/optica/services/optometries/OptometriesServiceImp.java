package com.minka.optica.services.optometries;

import com.minka.optica.dataholders.OptometriesDh;
import com.minka.optica.dto.OptometriesDto;
import com.minka.optica.entities.Optometries;
import com.minka.optica.mapper.OptometriesMapper;
import com.minka.optica.repository.OptometriesRepository;
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
      throw new RuntimeException("GET - There are no optometries in the database for the id: " + id);
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
  public OptometriesDto updateById(final Long id, final OptometriesDh optometriesDh) {
    final Optometries optometries = this.optometriesMapper.asEntity(optometriesDh);
    final Optional<Optometries> existOptomeries = this.optometriesRepository.findById(id);

    if (optometriesDh.getIdOptometry() != id) {
      log.warn("PUT - Parameters are incorrect for field idOptometry: " + optometriesDh.getIdOptometry() + " is different at is: " + id);
    }

    if (existOptomeries.isPresent()) {
      final Optometries optometriesSaved = this.optometriesRepository.save(optometries);
      final OptometriesDto optometriesDto = this.optometriesMapper.asDto(optometriesSaved);
      return optometriesDto;
    } else {
      throw new RuntimeException("PUT - There is no optometries in the database with the id: " + id);
    }
  }

  @Override
  public Boolean deleteById(final Long id) {
    final Optional<Optometries> existOptometries = this.optometriesRepository.findById(id);
    if (existOptometries.isPresent()) {
      this.optometriesRepository.deleteById(id);
      return true;
    } else {
      throw new RuntimeException("DELETE - There is no optometries in the database with the id: " + id);
    }
  }

}
