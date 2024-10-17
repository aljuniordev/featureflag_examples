package com.example.featureflag.add_strategy_patterns_in_change_status_example.application.port.out;

import com.example.featureflag.add_strategy_patterns_in_change_status_example.domain.Wo;

public interface WoRepositoryB2cPortOut {
    Wo retrieveWorkOrderByBusinessId(String businessId);

    Wo retrieveWorkOrderByWorkId(String businessId);
}
