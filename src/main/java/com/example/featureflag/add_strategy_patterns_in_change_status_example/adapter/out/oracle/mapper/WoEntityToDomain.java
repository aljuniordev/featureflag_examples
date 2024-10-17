package com.example.featureflag.add_strategy_patterns_in_change_status_example.adapter.out.oracle.mapper;

import com.example.featureflag.add_strategy_patterns_in_change_status_example.adapter.out.oracle.entity.WoEntity;
import com.example.featureflag.add_strategy_patterns_in_change_status_example.domain.Wo;

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
