package com.example.featureflag.add_strategy_patterns_in_change_status_example.port.in;

import com.example.featureflag.add_strategy_patterns_in_change_status_example.adapter.in.dto.WoSwagger;
import com.example.featureflag.add_strategy_patterns_in_change_status_example.domain.Wo;
import com.example.featureflag.add_strategy_patterns_in_change_status_example.port.out.WoRepositoryB2cPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@AllArgsConstructor
public class CreateWoUseCaseV1 {

    WoRepositoryB2cPortOut woRepositoryB2cPortOut;
    final boolean isFtfFenix;

    public Wo execute(WoSwagger woSwagger) {
        Wo wo = woRepositoryB2cPortOut.retrieveWorkOrderByBusinessId(woSwagger.getBusinessId());
        wo.rulesCreateWo(false);
        return wo;
    }
}
