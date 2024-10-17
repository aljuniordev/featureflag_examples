package com.example.featureflag.change_repository_example.application.port.out;

import com.example.featureflag.change_repository_example.domain.Wo;

public interface WoRepositoryB2cPortOut {
    Wo retrieveWorkOrderByBusinessId(String businessId);

    Wo retrieveWorkOrderByWorkId(String businessId);
}
