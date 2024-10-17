package com.example.featureflag.domain_rules_example.adapter.out.oracle.mapper;

import com.example.featureflag.domain_rules_example.adapter.out.oracle.entity.WoEntity;
import com.example.featureflag.domain_rules_example.domain.Wo;

public class WoEntityToDomain {
    private WoEntityToDomain() {
        //construtor privado para esconder o construtor público padrão e utilizar somente métodos estasticos
    }

    public static Wo execute(WoEntity woEntity) {
        return Wo.builder()
                .businessId(woEntity.getBusinessId())
                .build();
    }

}
