package com.example.featureflag.change_swagger_example.port.out;

import com.example.featureflag.change_swagger_example.domain.Wo;

public interface WoRepositoryB2cPortOut {
    Wo retrieveWorkOrderByBusinessId(String businessId);

    Wo retrieveWorkOrderByWorkId(String businessId);
}
