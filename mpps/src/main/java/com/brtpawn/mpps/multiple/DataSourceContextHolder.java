package com.brtpawn.mpps.multiple;

import com.brtpawn.mpps.enums.DataSourceEnum;

/**
 * Created by Administrator on 2019-10-29.
 */
public class DataSourceContextHolder {
    private static final ThreadLocal contextHolder = new ThreadLocal<>();
    /**
     * 设置数据源
     * @param dataSourceEnum
     */
    public static void setDataSource(DataSourceEnum dataSourceEnum) {
        contextHolder.set(dataSourceEnum.getValue());
    }
    /**
     * 取得当前数据源
     * @return
     */
    public static String getDataSource() {
        return (String) contextHolder.get();
    }
    /**
     * 清除上下文数据
     */
    public static void clearDataSource() {
        contextHolder.remove();
    }
}