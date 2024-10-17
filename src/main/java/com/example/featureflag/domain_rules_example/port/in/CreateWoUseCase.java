package com.example.featureflag.domain_rules_example.port.in;

import com.example.featureflag.domain_rules_example.adapter.in.dto.WoSwagger;
import com.example.featureflag.domain_rules_example.domain.Wo;
import com.example.featureflag.domain_rules_example.port.out.WoRepositoryB2cPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@AllArgsConstructor
public class CreateWoUseCase {

    WoRepositoryB2cPortOut woRepositoryB2cPortOut;
    final boolean isFtfFenix;

    public Wo execute(WoSwagger woSwagger) {
        Wo wo = woRepositoryB2cPortOut.retrieveWorkOrderByBusinessId(woSwagger.getBusinessId());
        wo.rulesCreateWo(isFtfFenix);
        return wo;
    }

}
