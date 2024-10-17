package com.example.featureflag.change_repository_example.infra.adapter.out.oracle.implementation;

import com.example.featureflag.change_repository_example.infra.adapter.out.oracle.entity.WoEntityFTFPTIXXX1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOracleRepositoryFTFFenixImpl extends JpaRepository<WoEntityFTFPTIXXX1, String> {
    WoEntityFTFPTIXXX1 retrieveWorkOrderByBusinessId(String businessId);

    WoEntityFTFPTIXXX1 retrieveWorkOrderByWorkId(String businessId);

}