package com.hunter.common.constant;

/**
 * 错误码
 * Created by lianjia on 2016/6/15.
 */
public enum ErrorCodeEnum {
    PARAM_REQUIRED("40001", "必填参数【%s】为空"),
    SIGN("40002", "签名验证失败"),
    AUTHORITY("40003", "无权限做此操作"),
    DECRYPT("40004", "解密失败"),
    INVALID_CALLER("40005", "非法调用方"),
    PARAM_PARSE("40006", "参数解析失败"),
    UPLOAD_TYPE("40007", "文件类型只允许上传【%s】"),
    UPLOAD_SIZE("40008", "文件大小不可超过【%s】M"),
    NO_ROW("40009", "数据库中没有对应的记录【%s】"),
    NO_ROLE("40010", "该用户还没有被分配角色【%s】"),
    REPEAT_ACTION("40011", "已【%s】,不能重复操作"),
    INCORRECT_PASSWORD("40012", "%s:你的密码不正确,请重试"),
    STATUS_CHANGE("40013", "订单状态%s,不允许提交"),
    EHR_NO_EXIST("40014", "EHR中不存在该用户%s"),

    SERVER("50000", "服务器异常"),
    QUERY_DATA("50001", "查询数据错误:%s"),
    INVOKE_TIMEOUT("50002", "网络连接超时,亲再试一次"),
    UPLOAD_FAIL("50003", "上传失败，请重新上传");

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
