package com.example.featureflag.add_strategy_patterns_in_change_status_example.port.in;

import com.example.featureflag.add_strategy_patterns_in_change_status_example.adapter.in.dto.WoSwaggerFTFPTIXXX1;
import com.example.featureflag.add_strategy_patterns_in_change_status_example.domain.Wo;
import com.example.featureflag.add_strategy_patterns_in_change_status_example.port.out.WoRepositoryB2cPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@AllArgsConstructor
public class CreateWoUseCaseV2 {

    WoRepositoryB2cPortOut woRepositoryB2cPortOut;
    final boolean isFtfFenix;

    public Wo executeFtfFenix(WoSwaggerFTFPTIXXX1 woSwaggerFTFPTIXXX1) {
        if (isFtfFenix) {
            log.info("Is FtfFenix");
            Wo wo = woRepositoryB2cPortOut.retrieveWorkOrderByBusinessId(woSwaggerFTFPTIXXX1.getBusinessId());
            wo.rulesCreateWo(isFtfFenix);
            return wo;
        } else {
            throw new UnsupportedOperationException("Função não desenvolvida.");
        }
    }
}
