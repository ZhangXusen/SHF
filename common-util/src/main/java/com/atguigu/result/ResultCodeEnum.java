package com.atguigu.result;


/**
 * 统一返回结果状态信息类
 *
 */
public enum ResultCodeEnum {

    SUCCESS(200,"成功"),
    FAIL(201, "失败"),
    PARAM_ERROR(203, "参数错误"),
    DATA_ERROR(204, "数据异常"),
    ILLEGAL_REQUEST(205, "非法请求"),
    REPEAT_SUBMIT(206, "重复提交"),

    LOGIN_AUTH(208, "未登陆"),
    PERMISSION(209, "没有权限"),

    CODE_ERROR(210, "验证码不正确"),
    PHONE_REGISTER_ERROR(210, "手机号已注册"),
    ACCOUNT_ERROR(210, "账号不正确"),
    PASSWORD_ERROR(210, "密码不正确"),
    ACCOUNT_LOCK_ERROR(210, "该账户已被锁定"),
    ;

    private Integer code;

    private String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
