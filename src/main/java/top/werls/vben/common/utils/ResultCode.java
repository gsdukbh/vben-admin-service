package top.werls.vben.common.utils;

/**
 * @author Jiawei Lee
 * @version TODO
 * @since on  2022/6/17
 */
public enum ResultCode {
    /**
     * 成功
     */
    SUCCESS(200, "成功"),
    FAIL(503, "失败"),
    /**
     * 404 未找到
     */
    NOT_FOUND(404, "未找到"),

    /**
     * 未登录
     */
    NOT_LOGIN(401, "未登录"),

    /**
     * 未授权
     */
    NOT_AUTH(403, "未授权"),

    /**
     * 参数错误
     */
    PARAM_ERROR(400, "参数错误"),

    /**
     * 系统错误
     */
    SYSTEM_ERROR(500, "系统错误");

    private int code;
    private String message;


    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    ResultCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
