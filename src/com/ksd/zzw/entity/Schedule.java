/*
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized
 * by MyEclipse Hibernate tool integration.
 *
 * Created Tue Aug 28 18:29:29 CST 2007 by MyEclipse Hibernate Tool.
 */
package com.ksd.zzw.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * A class that represents a row in the schedule table.
 * You can customize the behavior of this class by editing the class, {@link Schedule()}.
 * WARNING: DO NOT EDIT THIS FILE. This is a generated file that is synchronized
 * by MyEclipse Hibernate tool integration.
 */
public class Schedule implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1904241081386206145L;
	private int hashValue = 0;
    private Integer id;
    private String username;
    private Date scheduleTime;


    private String plan;

    public Schedule() {
    }

    public Schedule(Integer id) {
        this.setId(id);
    }

    public int getHashValue() {
        return hashValue;
    }

    public void setHashValue(int hashValue) {
        this.hashValue = hashValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(Date scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public boolean equals(Object rhs) {
        if (rhs == null)
            return false;
        if (!(rhs instanceof Schedule))
            return false;
        Schedule that = (Schedule) rhs;
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
