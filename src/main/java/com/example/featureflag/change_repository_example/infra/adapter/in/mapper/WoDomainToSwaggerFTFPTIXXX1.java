package com.example.featureflag.change_repository_example.infra.adapter.in.mapper;

import com.example.featureflag.change_repository_example.infra.adapter.in.dto.WoSwaggerFTFPTIXXX1;
import com.example.featureflag.change_repository_example.domain.Wo;

public class WoDomainToSwaggerFTFPTIXXX1 {
    private WoDomainToSwaggerFTFPTIXXX1() {
        //construtor privado para esconder o construtor público padrão e utilizar somente métodos estasticos
    }

    public static WoSwaggerFTFPTIXXX1 execute(Wo wo) {
        return WoSwaggerFTFPTIXXX1.builder()
                .businessId(wo.getBusinessId())
                .newProp(wo.getNewProp())
                .build();
    }
}
