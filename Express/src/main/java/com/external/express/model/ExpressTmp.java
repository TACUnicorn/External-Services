package com.external.express.model;

import com.alibaba.fastjson.JSON;

import java.sql.Timestamp;

/**
 * @author Create by xuantang
 * @date on 1/10/18
 */
public class ExpressTmp {
    private String fromUser;
    private String fromUserPhone;
    private String toUser;
    private String toUserPhone;
    private String source;
    private String destination;

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getFromUserPhone() {
        return fromUserPhone;
    }

    public void setFromUserPhone(String fromUserPhone) {
        this.fromUserPhone = fromUserPhone;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getToUserPhone() {
        return toUserPhone;
    }

    public void setToUserPhone(String toUserPhone) {
        this.toUserPhone = toUserPhone;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
