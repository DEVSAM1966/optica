package com.minka.optica.services.optometries;

import com.minka.optica.dataholders.OptometriesDh;
import com.minka.optica.dto.OptometriesDto;
import java.util.List;

public interface OptometriesService {

  OptometriesDto save(OptometriesDh optometriesDh);

  OptometriesDto findById(Long id);

  List<OptometriesDto> findAll();

  List<OptometriesDto> findByOptometrist(String valor);

  List<OptometriesDto> findByDischargeDate(String valor);

  OptometriesDto updateById(Long id, OptometriesDh optometriesDh);

  Boolean deleteById(Long id);

}
