package com.example.featureflag.change_repository_example.infra.adapter.out.oracle;

import com.example.featureflag.change_repository_example.common.FeatureFlagGateway;
import com.example.featureflag.change_repository_example.infra.adapter.out.oracle.entity.WoEntity;
import com.example.featureflag.change_repository_example.infra.adapter.out.oracle.entity.WoEntityFTFPTIXXX1;
import com.example.featureflag.change_repository_example.infra.adapter.out.oracle.implementation.JpaOracleRepositoryFTFFenixImpl;
import com.example.featureflag.change_repository_example.infra.adapter.out.oracle.implementation.JpaOracleRepositoryImpl;
import com.example.featureflag.change_repository_example.infra.adapter.out.oracle.mapper.WoEntityToDomain;
import com.example.featureflag.change_repository_example.infra.adapter.out.oracle.mapper.WoEntityToDomainFTFPTIXXX1;
import com.example.featureflag.change_repository_example.domain.Wo;
import com.example.featureflag.change_repository_example.application.port.out.WoRepositoryB2cPortOut;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Log4j2
@Repository
public class WoRepositoryB2c implements WoRepositoryB2cPortOut {

    final FeatureFlagGateway featureFlagGatewayAdapterOut;
    final JpaOracleRepositoryImpl jpaOracleRepositoryImpl;
    final JpaOracleRepositoryFTFFenixImpl jpaOracleRepositoryFTFFenix;

    @Autowired
    public WoRepositoryB2c(FeatureFlagGateway featureFlagGatewayAdapterOut,
                           JpaOracleRepositoryImpl jpaOracleRepositoryImpl,
                           JpaOracleRepositoryFTFFenixImpl jpaOracleRepositoryFTFFenix) {
        this.featureFlagGatewayAdapterOut = featureFlagGatewayAdapterOut;
        this.jpaOracleRepositoryImpl = jpaOracleRepositoryImpl;
        this.jpaOracleRepositoryFTFFenix = jpaOracleRepositoryFTFFenix;
    }

    @Override
    public Wo retrieveWorkOrderByBusinessId(String businessId) {
        if (featureFlagGatewayAdapterOut.isFtfPtiXxx1()) {
            WoEntityFTFPTIXXX1 res = jpaOracleRepositoryFTFFenix.retrieveWorkOrderByBusinessId(businessId);
            return WoEntityToDomainFTFPTIXXX1.execute(res);
        } else {
            WoEntity res = jpaOracleRepositoryImpl.retrieveWorkOrderByBusinessId(businessId);
            return WoEntityToDomain.execute(res);
        }
    }

    @Override
    public Wo retrieveWorkOrderByWorkId(String businessId) {
        if (featureFlagGatewayAdapterOut.isFtfPtiXxx1()) {
            WoEntityFTFPTIXXX1 res = jpaOracleRepositoryFTFFenix.retrieveWorkOrderByWorkId(businessId);
            return WoEntityToDomainFTFPTIXXX1.execute(res);
        } else {
            WoEntity res = jpaOracleRepositoryImpl.retrieveWorkOrderByWorkId(businessId);
            return WoEntityToDomain.execute(res);
        }
    }

}