package top.werls.vben.common.utils.captcha;

import java.io.Serial;

/**
 * @author leejiawei
 * @version TODO
 * @since on  2021/9/28
 */
public abstract class AbstractGenerator implements CodeGenerator {
    @Serial
    private static final long serialVersionUID = 8685744597154953479L;

    /**
     * 用于随机选的数字
     */
    public static final String BASE_NUMBER = "0123456789";
    /**
     * 用于随机选的字符
     */
    public static final String BASE_CHAR = "abcdefghijklmnopqrstuvwxyz";
    /**
     * 基础字符集合，用于随机获取字符串的字符集合
     */
    protected final String baseStr;
    /**
     * 验证码长度
     */
    protected final int length;


    /**
     * 构造，使用字母+数字做为基础
     *
     * @param count 生成验证码长度
     */
    public AbstractGenerator(int count) {
        this(BASE_NUMBER + BASE_CHAR, count);
    }

    /**
     * 构造
     *
     * @param baseStr 基础字符集合，用于随机获取字符串的字符集合
     * @param length  生成验证码长度
     */
    public AbstractGenerator(String baseStr, int length) {
        this.baseStr = baseStr;
        this.length = length;
    }

    /**
     * 获取长度验证码
     *
     * @return 验证码长度
     */
    public int getLength() {
        return this.length;
    }
}
