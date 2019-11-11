/*
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized
 * by MyEclipse Hibernate tool integration.
 *
 * Created Thu Aug 23 16:46:04 CST 2007 by MyEclipse Hibernate Tool.
 */
package com.ksd.zzw.entity;

import java.io.Serializable;

public class Address implements Serializable {

    private static final long serialVersionUID = -884436909205017326L;
    private int hashValue = 0;
    private Integer id;
    private String username;
    private String name;
    private String sex;
    private String mobile;
    private String email;
    private String qq;
    private String company;
    private String address;
    private String postcode;

    public Address() {
    }

    public Address(Integer id) {
        this.setId(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.hashValue = 0;
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return this.qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return this.postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public boolean equals(Object rhs) {
        if (rhs == null)
            return false;
        if (!(rhs instanceof Address))
            return false;
        Address that = (Address) rhs;
        if (this.getId() == null || that.getId() == null)
            return false;
        return (this.getId().equals(that.getId()));
    }

    public int hashCode() {
        if (this.hashValue == 0) {
            int result = 17;
            int idValue = this.getId() == null ? 0 : this.getId().hashCode();
            result = result * 37 + idValue;
            this.hashValue = result;
        }
        return this.hashValue;
    }
}