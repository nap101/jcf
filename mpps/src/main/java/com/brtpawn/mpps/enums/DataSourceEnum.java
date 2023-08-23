package com.brtpawn.mpps.enums;

/**
 * Created by Administrator on 2019-10-29.
 */
public enum DataSourceEnum {

    db1("典当业务数据库"), db2("短信发送库");
    private String value;
    DataSourceEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
