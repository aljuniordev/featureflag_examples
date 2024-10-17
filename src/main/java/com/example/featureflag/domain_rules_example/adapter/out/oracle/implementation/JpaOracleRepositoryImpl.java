package com.example.featureflag.domain_rules_example.adapter.out.oracle.implementation;

import com.example.featureflag.domain_rules_example.adapter.out.oracle.entity.WoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOracleRepositoryImpl extends JpaRepository<WoEntity, String> {
    WoEntity retrieveWorkOrderByBusinessId(String businessId);

    WoEntity retrieveWorkOrderByWorkId(String businessId);

}