package com.example.featureflag.change_swagger_example.infra.adapter.out.oracle.implementation;

import com.example.featureflag.change_swagger_example.infra.adapter.out.oracle.entity.WoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOracleRepositoryImpl extends JpaRepository<WoEntity, String> {
    WoEntity retrieveWorkOrderByBusinessId(String businessId);

    WoEntity retrieveWorkOrderByWorkId(String businessId);

}