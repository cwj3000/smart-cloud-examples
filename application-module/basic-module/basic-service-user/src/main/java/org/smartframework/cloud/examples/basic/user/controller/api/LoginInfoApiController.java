package org.smartframework.cloud.examples.basic.user.controller.api;

import javax.validation.Valid;

import org.smartframework.cloud.api.core.annotation.SmartApiAC;
import org.smartframework.cloud.api.core.enums.SignType;
import org.smartframework.cloud.common.pojo.Base;
import org.smartframework.cloud.common.pojo.vo.RespVO;
import org.smartframework.cloud.examples.basic.rpc.user.request.api.login.CacheDesKeyReqVO;
import org.smartframework.cloud.examples.basic.rpc.user.request.api.login.LoginReqVO;
import org.smartframework.cloud.examples.basic.rpc.user.response.api.login.GetRsaKeyRespVO;
import org.smartframework.cloud.examples.basic.rpc.user.response.api.login.LoginRespVO;
import org.smartframework.cloud.examples.basic.user.service.api.LoginInfoApiService;
import org.smartframework.cloud.starter.core.business.util.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Validated
@Api(tags = "登陆api接口")
@RequestMapping("user/api/loginInfo")
public class LoginInfoApiController {

	@Autowired
	private LoginInfoApiService loginInfoApiService;

	@PostMapping("getRsaKey")
	@ApiOperation("获取rsa key")
	public RespVO<GetRsaKeyRespVO> getRsaKey() {
		return RespUtil.success(loginInfoApiService.generateRsaKey());
	}

	@PostMapping("cacheDesKey")
	@ApiOperation("缓存aes key")
	@SmartApiAC(tokenCheck = false, sign = SignType.ALL, encrypt = true, decrypt = true)
	public RespVO<Base> cacheDesKey(@RequestBody @Valid CacheDesKeyReqVO req) {
		loginInfoApiService.cacheDesKey(req);
		return RespUtil.success();
	}

	@PostMapping("login")
	@ApiOperation("登陆")
	@SmartApiAC(tokenCheck = false, sign = SignType.ALL, encrypt = true, decrypt = true)
	public RespVO<LoginRespVO> login(@RequestBody @Valid LoginReqVO req) {
		return loginInfoApiService.login(req);
	}

}