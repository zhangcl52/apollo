package com.hunter.common.constant;

/**
 * 错误码
 * Created by lianjia on 2016/6/15.
 */
public enum ErrorCodeEnum {
    //参数错误("4****")
    PARAM_REQUIRED("40001", "必填参数【%s】为空"),
    SIGN("40002", "签名验证失败"),
    AUTHORITY("40003", "无权限做此操作"),
    DECRYPT("40004", "解密失败"),
    INVALID_CALLER("40005", "非法调用方"),
    PARAM_PARSE("40006", "参数解析失败"),


    //数据库错误("5****")
    DATA_TABLE_ERR("50000", "数据库错误:%s"),
    NO_ROW("50010", "数据库中没有对应的记录【%s】"),
    HAS_ROW("50011", "数据库中没有对应的记录【%s】"),


    //网络问题("6****")
    NETWORK_ERROR("60000", "网络出错"),
    INVOKE_TIMEOUT("60001", "网络连接超时,亲再试一次"),

    //服务器错误("8****")
    SERVER("80000", "服务器异常"),
    UPLOAD_FAIL("80101", "上传失败，请重新上传"),
    UPLOAD_TYPE("80102", "文件类型只允许上传【%s】"),
    UPLOAD_SIZE("80103", "文件大小不可超过【%s】M"),

    //服务器-操作(8**2**)
    REPEAT_ACTION("800201", "已【%s】,不能重复操作"),
    INCORRECT_PASSWORD("800202", "%s:你的密码不正确,请重试");

    private final String code;
    private final String message;

    ErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
