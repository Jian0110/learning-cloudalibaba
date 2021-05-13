package com.springcloud.entity;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user_account")
@Builder
public class UserAccount {
    /**
     * 账户ID
     */
    @Id
    private Long id;

    /**
     * 用户编码
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 余额
     */
    private BigDecimal balance;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    public UserAccount(Long id, String userId, BigDecimal balance, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.balance = balance;
        this.updateTime = updateTime;
    }

    public UserAccount() {
        super();
    }

    /**
     * 获取账户ID
     *
     * @return id - 账户ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置账户ID
     *
     * @param id 账户ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户编码
     *
     * @return user_id - 用户编码
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户编码
     *
     * @param userId 用户编码
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取余额
     *
     * @return balance - 余额
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * 设置余额
     *
     * @param balance 余额
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}