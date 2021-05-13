package com.springcloud.entity;

import lombok.Builder;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "repo")
@Builder
public class Repo {
    /**
     * 商品ID
     */
    @Id
    private Long id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 库存量
     */
    private Integer amount;

    /**
     * 价格
     */
    private BigDecimal price;

    public Repo(Long id, String name, Integer amount, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public Repo() {
        super();
    }

    /**
     * 获取商品ID
     *
     * @return id - 商品ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置商品ID
     *
     * @param id 商品ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取商品名称
     *
     * @return name - 商品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置商品名称
     *
     * @param name 商品名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取库存量
     *
     * @return amount - 库存量
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * 设置库存量
     *
     * @param amount 库存量
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * 获取价格
     *
     * @return price - 价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置价格
     *
     * @param price 价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}