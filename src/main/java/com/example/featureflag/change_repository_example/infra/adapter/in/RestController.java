package com.example.featureflag.change_repository_example.infra.adapter.in;

import com.example.featureflag.change_repository_example.infra.adapter.in.dto.WoSwagger;
import com.example.featureflag.change_repository_example.infra.adapter.in.dto.WoSwaggerFTFPTIXXX1;
import com.example.featureflag.change_repository_example.infra.adapter.in.mapper.WoDomainToSwagger;
import com.example.featureflag.change_repository_example.infra.adapter.in.mapper.WoDomainToSwaggerFTFPTIXXX1;
import com.example.featureflag.change_repository_example.common.FeatureFlagGateway;
import com.example.featureflag.change_repository_example.infra.adapter.out.oracle.WoRepositoryB2c;
import com.example.featureflag.change_repository_example.domain.Wo;
import com.example.featureflag.change_repository_example.application.port.in.CreateWoUseCaseV1;
import com.example.featureflag.change_repository_example.application.port.in.CreateWoUseCaseV2;
import com.example.featureflag.change_repository_example.common.JacksonMapper;
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

    FeatureFlagGateway featureFlagGatewayAdapterOut;
    WoRepositoryB2c woRepositoryB2c;

    @Autowired
    public RestController(FeatureFlagGateway featureFlagGatewayAdapterOut,
                          WoRepositoryB2c woRepositoryB2c) {
        this.featureFlagGatewayAdapterOut = featureFlagGatewayAdapterOut;
        this.woRepositoryB2c = woRepositoryB2c;
    }
    @PostMapping("/createWorkOrder")
    public ResponseEntity<Object> retrieveWorkOrder(@RequestHeader(value = "flow", required = false) String flow,
                                                    @RequestBody String payload) {
        log.info("POST /createWorkOrder/" + payload);

        if (featureFlagGatewayAdapterOut.isFtfPtiXxx1()) {
            WoSwaggerFTFPTIXXX1 woSwaggerFTFPTIXXX1 =  JacksonMapper.loadObjectsFromFile(payload, WoSwaggerFTFPTIXXX1.class);
            Wo woResponse = new CreateWoUseCaseV2(woRepositoryB2c, featureFlagGatewayAdapterOut.isFtfPtiXxx1()).executeFtfFenix(woSwaggerFTFPTIXXX1);
            WoSwaggerFTFPTIXXX1 woSwaggerResponse = WoDomainToSwaggerFTFPTIXXX1.execute(woResponse);
            return ResponseEntity.ok().body(woSwaggerResponse);
        }

        WoSwagger woSwagger = JacksonMapper.loadObjectsFromFile(payload, WoSwagger.class);
        Wo woResponse = new CreateWoUseCaseV1(woRepositoryB2c, featureFlagGatewayAdapterOut.isFtfPtiXxx1()).execute(woSwagger);
        WoSwagger woSwaggerResponse = WoDomainToSwagger.execute(woResponse);
        return ResponseEntity.ok().body(woSwaggerResponse);
    }
}
