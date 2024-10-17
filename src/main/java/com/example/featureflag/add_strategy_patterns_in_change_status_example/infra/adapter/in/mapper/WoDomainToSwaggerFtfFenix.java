package com.example.featureflag.add_strategy_patterns_in_change_status_example.infra.adapter.in.mapper;

import com.example.featureflag.add_strategy_patterns_in_change_status_example.infra.adapter.in.dto.WoSwaggerFTFPTIXXX1;
import com.example.featureflag.add_strategy_patterns_in_change_status_example.domain.Wo;

public class WoDomainToSwaggerFtfFenix {
    private WoDomainToSwaggerFtfFenix() {
        //construtor privado para esconder o construtor público padrão e utilizar somente métodos estasticos
    }

    public static WoSwaggerFTFPTIXXX1 execute(Wo wo) {
        return WoSwaggerFTFPTIXXX1.builder()
                .businessId(wo.getBusinessId())
                .newProp(wo.getNewProp())
                .build();
    }
}
