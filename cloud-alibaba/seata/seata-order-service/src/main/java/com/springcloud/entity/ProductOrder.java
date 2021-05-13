package com.springcloud.entity;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "product_order")
@Builder
@Data
public class ProductOrder {
    /**
     * 订单ID
     */
    @Id
    private Integer id;

    /**
     * 商品ID
     */
    @Column(name = "product_id")
    private Long productId;

    /**
     * 账号
     */
    @Column(name = "account_id")
    private Long accountId;

    /**
     * 实际支付金额
     */
    @Column(name = "pay_amount")
    private BigDecimal payAmount;

    /**
     * 创建订单时间
     */
    @Column(name = "create_time")
    private Date createTime;

    public ProductOrder(Integer id, Long productId,  Long accountId,BigDecimal payAmount, Date createTime) {
        this.id = id;
        this.productId = productId;
        this.productId = productId;
        this.accountId = accountId;
        this.payAmount = payAmount;
        this.createTime = createTime;
    }

    public ProductOrder() {
        super();
    }

    /**
     * 获取订单ID
     *
     * @return id - 订单ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置订单ID
     *
     * @param id 订单ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取商品ID
     *
     * @return product_id - 商品ID
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * 设置商品ID
     *
     * @param productId 商品ID
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * 获取实际支付金额
     *
     * @return pay_amount - 实际支付金额
     */
    public BigDecimal getPayAmount() {
        return payAmount;
    }

    /**
     * 设置实际支付金额
     *
     * @param payAmount 实际支付金额
     */
    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * 获取创建订单时间
     *
     * @return create_time - 创建订单时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    /**
     * 设置创建订单时间
     *
     * @param createTime 创建订单时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}