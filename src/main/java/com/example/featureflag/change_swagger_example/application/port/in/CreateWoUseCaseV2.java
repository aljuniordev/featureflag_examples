package com.example.featureflag.change_swagger_example.application.port.in;

import com.example.featureflag.change_swagger_example.application.port.out.WoRepositoryB2cPortOut;
import com.example.featureflag.change_swagger_example.infra.adapter.in.dto.WoSwaggerFTFPTIXXX1;
import com.example.featureflag.change_swagger_example.domain.Wo;
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
