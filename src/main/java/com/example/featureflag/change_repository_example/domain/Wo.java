package com.example.featureflag.change_repository_example.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Getter
@Builder
public class Wo {

    private String businessId;
    private String newProp;

    public void rulesCreateWo(boolean isFtfFenix) {
        if (isFtfFenix) {
            this.rulesCreateWoV2();
        }

        this.rulesCreateWoV1();
    }

    private void rulesCreateWoV1() {
        log.info("execute rules!");
    }

    private void rulesCreateWoV2() {
        log.info("Is FtfFenix");
        if ("test".equals(this.getNewProp())) {
            log.info("New Prop is teste");
        }
    }

}
