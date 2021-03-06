package org.smartframework.cloud.examples.mall.rpc.product.request.rpc;


import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.smartframework.cloud.common.pojo.Base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ApiModel(description="根据ids查询商品信息请求参数")
public class QryProductByIdsReqVO extends Base {

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "商品id", required = true)
	@NotEmpty
	private List<Long> ids;

}