package org.smartframework.cloud.examples.mall.order.entity.base;

import javax.persistence.Column;
import javax.persistence.Table;

import org.smartframework.cloud.starter.mybatis.common.mapper.entity.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * 运单信息
 *
 * @author liyulin
 * @date 2019-11-09
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Table(name = "t_order_delivery_info")
public class OrderDeliveryInfoEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

    /** 所属订单（t_order_bill表f_id） */
    @Column(name = "t_order_bill_id")     
	private Long orderBillId;
	
    /** 购买的商品id（demo_product库t_product_info表f_id） */
    @Column(name = "t_product_info_id")     
	private Long productInfoId;
	
    /** 商品名称 */
    @Column(name = "f_product_name")     
	private String productName;
	
    /** 商品购买价格（单位：万分之一元） */
    @Column(name = "f_price")     
	private Long price;
	
    /** 购买数量 */
    @Column(name = "f_buy_count")     
	private Integer buyCount;
	
	/** 表字段名 */
	public enum Columns {
	    /** 所属订单（t_order_bill表f_id） */
		orderBillId,
	    /** 购买的商品id（demo_product库t_product_info表f_id） */
		productInfoId,
	    /** 商品名称 */
		productName,
	    /** 商品购买价格（单位：万分之一元） */
		price,
	    /** 购买数量 */
		buyCount;
	}

}