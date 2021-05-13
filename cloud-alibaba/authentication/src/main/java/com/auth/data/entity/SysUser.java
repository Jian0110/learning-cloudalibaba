package com.auth.data.entity;

import javax.persistence.*;

@Table(name = "sys_user")
public class SysUser {
    @Id
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 身份
     */
    private String roles;

    public SysUser(Long id, String name, String address, String username, String password, String roles) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public SysUser() {
        super();
    }

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取联系地址
     *
     * @return address - 联系地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置联系地址
     *
     * @param address 联系地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取账号
     *
     * @return username - 账号
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置账号
     *
     * @param username 账号
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取身份
     *
     * @return roles - 身份
     */
    public String getRoles() {
        return roles;
    }

    /**
     * 设置身份
     *
     * @param roles 身份
     */
    public void setRoles(String roles) {
        this.roles = roles == null ? null : roles.trim();
    }
}