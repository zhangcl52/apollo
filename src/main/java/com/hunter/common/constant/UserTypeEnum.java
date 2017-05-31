package com.hunter.common.constant;/** * @Author zhangcl * @Date 17/5/22  下午11:25 */public enum UserTypeEnum {    ADMIN(1, "管理员"), VIP(2, "vip"), NORMAL(3, "普通用户");    private int code;    private String name;    UserTypeEnum(int code, String name) {        this.code = code;        this.name = name;    }    public int getCode() {        return code;    }    public String getName() {        return name;    }    /**     * 根据name获取id     * @param name     * @return     */    public int getIndexByName(String name) {        for (UserTypeEnum userTypeEnum : UserTypeEnum.values()) {            if(userTypeEnum.getName().equals(name)){                return userTypeEnum.getCode();            }        }        return -1;    }}