package com.example.featureflag.domain_rules_example.port.out;

import com.example.featureflag.domain_rules_example.domain.Wo;

public interface WoRepositoryB2cPortOut {
    Wo retrieveWorkOrderByBusinessId(String businessId);

    Wo retrieveWorkOrderByWorkId(String businessId);
}
