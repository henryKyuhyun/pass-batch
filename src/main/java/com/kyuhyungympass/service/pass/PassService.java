package com.kyuhyungympass.service.pass;

import com.kyuhyungympass.repository.pass.PassEntity;
import com.kyuhyungympass.repository.pass.PassRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassService {

    private final PassRepository passRepository;

    public PassService(PassRepository passRepository){this.passRepository=passRepository;}

    public List<Pass> getPasses(final String userId){
//       userId를 조건으로 pass를 조회, 이떄 PackageSeq에 맞는 package 정보도 필요
        final List<PassEntity> passEntities = passRepository.findByUserId(userId);
        return PassModelMapper.INSTANCE.map(passEntities);
    }
}
