package com.example.featureflag.change_repository_example.infra.adapter.out.oracle.mapper;

import com.example.featureflag.change_repository_example.infra.adapter.out.oracle.entity.WoEntityFTFPTIXXX1;
import com.example.featureflag.change_repository_example.domain.Wo;

public class WoEntityToDomainFTFPTIXXX1 {
    private WoEntityToDomainFTFPTIXXX1() {
        //construtor privado para esconder o construtor público padrão e utilizar somente métodos estasticos
    }

    public static Wo execute(WoEntityFTFPTIXXX1 woEntityFTFPTIXXX1) {
        return Wo.builder()
                .businessId(woEntityFTFPTIXXX1.getBusinessId())
                .newProp(woEntityFTFPTIXXX1.getNewProp())
                .build();
    }
}
