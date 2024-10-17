package com.example.featureflag.domain_rules_example.infra.adapter.in;

import com.example.featureflag.domain_rules_example.infra.adapter.in.dto.WoSwagger;
import com.example.featureflag.domain_rules_example.infra.adapter.in.mapper.WoDomainToSwagger;
import com.example.featureflag.domain_rules_example.infra.adapter.out.feature_flag.FeatureFlagAdapterOut;
import com.example.featureflag.domain_rules_example.infra.adapter.out.oracle.WoRepositoryB2c;
import com.example.featureflag.domain_rules_example.domain.Wo;
import com.example.featureflag.domain_rules_example.application.port.in.CreateWoUseCase;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@Log4j2
@RequestMapping("")
public class RestController {

    FeatureFlagAdapterOut featureFlagAdapterOut;
    WoRepositoryB2c woRepositoryB2c;

    @Autowired
    public RestController(FeatureFlagAdapterOut featureFlagAdapterOut,
                          WoRepositoryB2c woRepositoryB2c) {
        this.featureFlagAdapterOut = featureFlagAdapterOut;
        this.woRepositoryB2c = woRepositoryB2c;
    }

    @PostMapping("/createWorkOrder")
    public ResponseEntity<Object> retrieveWorkOrder(@RequestHeader(value = "flow", required = false) String flow,
                                                    @RequestBody WoSwagger payload) {
        log.info("POST /createWorkOrder/" + payload);

        Wo woResponse = new CreateWoUseCase(woRepositoryB2c, featureFlagAdapterOut.isFtfPtiXxx1()).execute(payload);
        WoSwagger woSwaggerResponse = WoDomainToSwagger.execute(woResponse);
        return ResponseEntity.ok().body(woSwaggerResponse);
    }
}
