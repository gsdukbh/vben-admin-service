package top.werls.springboottemplate.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author leee
 */
@Data
@Schema(description = "返回结果")
public class ResultData<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "返回码")
    private int code;
    @Schema(description = "返回信息")
    private String message;
    @Schema(description = "返回数据")
    private T data;

    @Schema(description = "时间戳")
    private Long timeStamp;

    public ResultData() {
    }

    public ResultData(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timeStamp = System.currentTimeMillis();
    }

    public ResultData(int code, String message) {
        this.code = code;
        this.message = message;
        this.timeStamp = System.currentTimeMillis();
    }

    public static <T> ResultData<T> success() {
        return new ResultData<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage());
    }

    public static <T> ResultData<T> success(T data) {
        return new ResultData<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    public static <T> ResultData<T> success(String message) {
        return new ResultData<>(ResultCode.SUCCESS.getCode(), message);
    }

    public static <T> ResultData<T> success(String message, T data) {
        return new ResultData<>(ResultCode.SUCCESS.getCode(), message, data);
    }

    public static <T> ResultData<T> fail() {
        return new ResultData<>(ResultCode.FAIL.getCode(), ResultCode.FAIL.getMessage());
    }

    public static <T> ResultData<T> fail(T data) {
        return new ResultData<>(ResultCode.FAIL.getCode(), ResultCode.FAIL.getMessage(), data);
    }

    public static <T> ResultData<T> fail(String message) {
        return new ResultData<>(ResultCode.FAIL.getCode(), message);
    }

    public static <T> ResultData<T> fail(String message, T data) {
        return new ResultData<>(ResultCode.FAIL.getCode(), message, data);
    }

    public static <T> ResultData<T> notFound() {
        return new ResultData<>(ResultCode.NOT_FOUND.getCode(), ResultCode.NOT_FOUND.getMessage());
    }

    public static <T> ResultData<T> notFound(T data) {
        return new ResultData<>(ResultCode.NOT_FOUND.getCode(), ResultCode.NOT_FOUND.getMessage(), data);
    }

    public static <T> ResultData<T> notFound(String message) {
        return new ResultData<>(ResultCode.NOT_FOUND.getCode(), message);
    }

    public static <T> ResultData<T> notFound(String message, T data) {
        return new ResultData<>(ResultCode.NOT_FOUND.getCode(), message, data);
    }

    public static <T> ResultData<T> notLogin() {
        return new ResultData<>(ResultCode.NOT_LOGIN.getCode(), ResultCode.NOT_LOGIN.getMessage());
    }

    public static <T> ResultData<T> notLogin(T data) {
        return new ResultData<>(ResultCode.NOT_LOGIN.getCode(), ResultCode.NOT_LOGIN.getMessage(), data);
    }

    public static <T> ResultData<T> notLogin(String message) {
        return new ResultData<>(ResultCode.NOT_LOGIN.getCode(), message);
    }

    public static <T> ResultData<T> notLogin(String message, T data) {
        return new ResultData<>(ResultCode.NOT_LOGIN.getCode(), message, data);
    }

    public static <T> ResultData<T> notAuth() {
        return new ResultData<>(ResultCode.NOT_AUTH.getCode(), ResultCode.NOT_AUTH.getMessage());
    }

    public static <T> ResultData<T> notAuth(T data) {
        return new ResultData<>(ResultCode.NOT_AUTH.getCode(), ResultCode.NOT_AUTH.getMessage(), data);
    }

    public static <T> ResultData<T> notAuth(String message) {
        return new ResultData<>(ResultCode.NOT_AUTH.getCode(), message);
    }

    public static <T> ResultData<T> notAuth(String message, T data) {
        return new ResultData<>(ResultCode.NOT_AUTH.getCode(), message, data);
    }

    public static <T> ResultData<T> paramError() {
        return new ResultData<>(ResultCode.PARAM_ERROR.getCode(), ResultCode.PARAM_ERROR.getMessage());
    }

    public static <T> ResultData<T> paramError(T data) {
        return new ResultData<>(ResultCode.PARAM_ERROR.getCode(), ResultCode.PARAM_ERROR.getMessage(), data);
    }

    public static <T> ResultData<T> paramError(String message) {
        return new ResultData<>(ResultCode.PARAM_ERROR.getCode(), message);
    }

    public static <T> ResultData<T> systemError() {
        return new ResultData<>(ResultCode.SYSTEM_ERROR.getCode(), ResultCode.SYSTEM_ERROR.getMessage());
    }

    public static <T> ResultData<T> systemError(T data) {
        return new ResultData<>(ResultCode.SYSTEM_ERROR.getCode(), ResultCode.SYSTEM_ERROR.getMessage(), data);
    }

    public static <T> ResultData<T> systemError(String message) {
        return new ResultData<>(ResultCode.SYSTEM_ERROR.getCode(), message);
    }

    public static <T> ResultData<T> systemError(String message, T data) {
        return new ResultData<>(ResultCode.SYSTEM_ERROR.getCode(), message, data);
    }


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


}
