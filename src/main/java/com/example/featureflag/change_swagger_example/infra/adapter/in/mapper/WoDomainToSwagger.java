package com.example.featureflag.change_swagger_example.infra.adapter.in.mapper;

import com.example.featureflag.change_swagger_example.infra.adapter.in.dto.WoSwagger;
import com.example.featureflag.change_swagger_example.domain.Wo;

public class WoDomainToSwagger {
    private WoDomainToSwagger() {
        //construtor privado para esconder o construtor público padrão e utilizar somente métodos estasticos
    }

    public static WoSwagger execute(Wo wo) {
        return WoSwagger.builder()
                .businessId(wo.getBusinessId())
                .build();
    }
}
