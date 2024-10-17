package com.example.featureflag.domain_rules_example.infra.adapter.out.oracle;

import com.example.featureflag.domain_rules_example.infra.adapter.out.oracle.implementation.JpaOracleRepositoryImpl;
import com.example.featureflag.domain_rules_example.infra.adapter.out.oracle.entity.WoEntity;
import com.example.featureflag.domain_rules_example.infra.adapter.out.oracle.mapper.WoEntityToDomain;
import com.example.featureflag.domain_rules_example.domain.Wo;
import com.example.featureflag.domain_rules_example.application.port.out.WoRepositoryB2cPortOut;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Log4j2
@Repository
public class WoRepositoryB2c implements WoRepositoryB2cPortOut {

    final JpaOracleRepositoryImpl jpaOracleRepositoryImpl;

    @Autowired
    public WoRepositoryB2c(JpaOracleRepositoryImpl jpaOracleRepositoryImpl) {
        this.jpaOracleRepositoryImpl = jpaOracleRepositoryImpl;
    }

    @Override
    public Wo retrieveWorkOrderByBusinessId(String businessId) {
        WoEntity res = jpaOracleRepositoryImpl.retrieveWorkOrderByBusinessId(businessId);
        return WoEntityToDomain.execute(res);
    }

    @Override
    public Wo retrieveWorkOrderByWorkId(String businessId) {
        WoEntity res = jpaOracleRepositoryImpl.retrieveWorkOrderByWorkId(businessId);
        return WoEntityToDomain.execute(res);
    }

}