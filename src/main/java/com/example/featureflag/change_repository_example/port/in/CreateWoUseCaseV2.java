package com.example.featureflag.change_repository_example.port.in;

import com.example.featureflag.change_repository_example.adapter.in.dto.WoSwagger;
import com.example.featureflag.change_repository_example.adapter.in.dto.WoSwaggerFTFPTIXXX1;
import com.example.featureflag.change_repository_example.domain.Wo;
import com.example.featureflag.change_repository_example.port.out.WoRepositoryB2cPortOut;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@AllArgsConstructor
public class CreateWoUseCaseV2 {

    WoRepositoryB2cPortOut woRepositoryB2cPortOut;
    final boolean isFtfFenix;

    public Wo execute(WoSwagger woSwagger) {
        Wo wo = woRepositoryB2cPortOut.retrieveWorkOrderByBusinessId(woSwagger.getBusinessId());
        wo.rulesCreateWo(false);
        return wo;
    }

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
