package org.smartframework.cloud.examples.api.ac.core.configure;

import org.smartframework.cloud.examples.api.ac.core.listener.UploadApiMetaListener;
import org.smartframework.cloud.examples.api.ac.core.properties.ApiAcProperties;
import org.smartframework.cloud.examples.support.rpc.gateway.ApiMetaRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(ApiAcProperties.class)
// eureka关闭时不上传
@ConditionalOnProperty(name = "eureka.client.enabled", havingValue = "true")
public class ApiAcAutoConfigure {
	
	@Autowired
	@Bean
	public UploadApiMetaListener UploadApiMetaListener(ApiMetaRpc apiMetaRpc, ApiAcProperties apiAcProperties) {
		return new UploadApiMetaListener(apiMetaRpc, apiAcProperties);
	}
	
}