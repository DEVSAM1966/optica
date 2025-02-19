package com.minka.optica.mapper;

import com.minka.optica.dataholders.OptometriesDh;
import com.minka.optica.dto.OptometriesDto;
import com.minka.optica.entities.Optometries;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface OptometriesMapper {

  Optometries asEntity(OptometriesDh optometriesDh);

  OptometriesDto asDto(Optometries optometries);

  List<Optometries> asEntityList(List<OptometriesDh> optometriesDhList);

  List<OptometriesDto> asDtoList(List<Optometries> optometriesList);
  
}
