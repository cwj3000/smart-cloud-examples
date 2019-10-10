package org.smartframework.cloud.examples.basic.service.user.test.cases.integration.api;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.smartframework.cloud.common.pojo.dto.Resp;
import org.smartframework.cloud.common.pojo.enums.ReturnCodeEnum;
import org.smartframework.cloud.examples.basic.service.rpc.user.response.base.UserInfoBaseRespBody;
import org.smartframework.cloud.examples.basic.service.user.config.UserRedisConfig;
import org.smartframework.cloud.examples.basic.service.user.test.data.UserInfoData;
import org.smartframework.cloud.starter.common.business.LoginCache;
import org.smartframework.cloud.starter.common.business.ReqContextHolder;
import org.smartframework.cloud.starter.common.business.security.LoginRedisConfig;
import org.smartframework.cloud.starter.common.business.security.util.ReqHttpHeadersUtil;
import org.smartframework.cloud.starter.redis.component.RedisComponent;
import org.smartframework.cloud.starter.test.AbstractIntegrationTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.TypeReference;

@Rollback
@Transactional
public class UserInfoApiControllerIntegrationTest extends AbstractIntegrationTest {

	@Autowired
	private UserInfoData userInfoData;
	@Autowired
	private RedisComponent redisComponent;

	@Test
	public void testQuery() throws Exception {
		ReqContextHolder.clearLoginCache();
		
		Long userId = 1L;
		userInfoData.insertTestData(userId);
		
		// 构造请求参数
		LoginCache loginCache = new LoginCache();
		String token = ReqHttpHeadersUtil.generateToken();
		loginCache.setToken(token);
		loginCache.setUserId(userId);

		String tokenRedisKey = LoginRedisConfig.getTokenRedisKey(token);
		redisComponent.setObject(tokenRedisKey, loginCache, UserRedisConfig.NON_LOGIN_TOKEN_EXPIRE_MILLIS);
		

		Resp<UserInfoBaseRespBody> result = super.getWithHeaders("/api/identity/user/userInfo/query", null, token,
				new TypeReference<Resp<UserInfoBaseRespBody>>() {
				});

		Assertions.assertThat(result).isNotNull();
		Assertions.assertThat(result.getHead()).isNotNull();
		Assertions.assertThat(result.getHead().getCode()).isEqualTo(ReturnCodeEnum.SUCCESS.getCode());
		Assertions.assertThat(result.getBody()).isNotNull();
	}

}