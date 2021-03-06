package org.smartframework.cloud.examples.basic.rpc.user.response.base;

import java.util.Date;

import org.smartframework.cloud.common.pojo.vo.BaseEntityRespVO;
import org.smartframework.cloud.mask.MaskLog;
import org.smartframework.cloud.mask.MaskRule;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder
@ApiModel(description = "用户信息")
public class UserInfoBaseRespVO extends BaseEntityRespVO {

	private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "手机号")
    @MaskLog(MaskRule.MOBILE)
	private String mobile;
	
    @ApiModelProperty(value = "昵称")
	private String nickName;
	
    @ApiModelProperty(value = "真实姓名")
    @MaskLog(MaskRule.NAME)
	private String realName;
	
    @ApiModelProperty(value = "性别=={\"1\":\"男\",\"2\":\"女\",\"3\":\"未知\"}")
	private Byte sex;
	
    @ApiModelProperty(value = "出生年月")
	private Date birthday;
	
    @ApiModelProperty(value = "头像")
	private String profileImage;
	
    @ApiModelProperty(value = "所在平台=={\"1\":\"app\",\"2\":\"web后台\",\"3\":\"微信\"}")
	private Byte channel;
	
}