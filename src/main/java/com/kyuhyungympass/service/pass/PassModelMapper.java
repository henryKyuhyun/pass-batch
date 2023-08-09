package com.kyuhyungympass.service.pass;


import com.kyuhyungympass.repository.pass.BulkPassEntity;
import com.kyuhyungympass.repository.pass.BulkPassStatus;
import com.kyuhyungympass.repository.pass.PassEntity;
import com.kyuhyungympass.repository.pass.PassStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PassModelMapper {

    PassModelMapper INSTANCE = Mappers.getMapper(PassModelMapper.class);

    @Mapping(target = "packageName", source = "packageEntity.packageName")
    Pass map(PassEntity passEntity);

    List<Pass> map(List<PassEntity> passEntities);


}