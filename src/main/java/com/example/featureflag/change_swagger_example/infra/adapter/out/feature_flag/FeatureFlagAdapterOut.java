package com.example.featureflag.change_swagger_example.infra.adapter.out.feature_flag;

import com.opentable.hobknob.client.HobknobClient;
import com.opentable.hobknob.client.HobknobClientFactory;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Log4j2
@Component
public class FeatureFlagAdapterOut {

    HobknobClient client;
    @Value("#{'${featureToggle.etcdHosts}'.split(',')}")
    List<String> etcdHosts;
    @Value("${featureToggle.etcdPort}")
    int etcdPort;
    @Value("${featureToggle.applicationName}")
    String applicationName;
    @Value("${featureToggle.cacheUpdateIntervalMs}")
    int cacheUpdateIntervalMs;
    @Value("${featureToggle.env}")
    String env;
    @Value("${featureToggle.project.fenix}")
    String ftfPtiXxx1;
    @Value("${featureToggle.project.fenix}")
    String ftfPtiXxx2;
    @Value("${featureToggle.project.otherProject}")
    String ftfOtherProject;

    public boolean isFtfPtiXxx1() {
        return this.isFeatureFlagEnabled(ftfPtiXxx1);
    }

    public boolean isFtfPtiXxx2() {
        return this.isFeatureFlagEnabled(ftfPtiXxx2);
    }

    public boolean isFtfOtherProject() {
        return this.isFeatureFlagEnabled(ftfOtherProject);
    }

    private boolean isFeatureFlagEnabled(String featureFlagName) {
        try {
            if (this.client == null) {
                this.client = new HobknobClientFactory().create(etcdHosts, etcdPort, applicationName, cacheUpdateIntervalMs);
            }
            boolean isEnabled = this.client.get(featureFlagName, env);
            log.info("FeatureFlag encontrada. name: {}, env: {}, isEnabled: {}", featureFlagName, env, isEnabled);
            return isEnabled;
        } catch (Exception ex) {
            log.error("Erro ao retornar FeatureFlag. name: {}, env: {}, error: {}", featureFlagName, env, ex.getMessage());
            return false;
        }
    }
}
