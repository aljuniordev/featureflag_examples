package com.example.featureflag.add_strategy_patterns_in_change_status_example.domain;

import com.example.featureflag.add_strategy_patterns_in_change_status_example.domain.status_rules.StatusCanceled;
import com.example.featureflag.add_strategy_patterns_in_change_status_example.domain.status_rules.StatusNotDone;
import com.example.featureflag.add_strategy_patterns_in_change_status_example.domain.status_rules.StatusStarted;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Getter
@Builder
public class Wo {

    private String businessId;
    private String status;
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

        this.calculatesNewStatus();
    }

    private void calculatesNewStatus() {
        if ("started".equals(this.status)) {
            new StatusStarted().execute();
            return;
        } else if ("notdone".equals(this.status)) {
            new StatusNotDone().execute();
            return;
        } else if ("canceled".equals(this.status)) {
            new StatusCanceled().execute();
            return;
        }
        throw new UnsupportedOperationException("Função não desenvolvida.");
    }
}
