package top.werls.vben.common.utils.captcha;

/**
 * 验证码
 * @author leejiawei
 * @version TODO
 * @since on  2021/9/28
 */
public class CaptchaUtil {

    /**
     * 创建线干扰的验证码，默认5位验证码，150条干扰线
     *
     * @param width  图片宽
     * @param height 图片高
     * @return {@link LineCaptcha}
     */
    public static LineCaptcha createLineCaptcha(int width, int height) {
        return new LineCaptcha(width, height);
    }

    /**
     * 创建线干扰的验证码
     *
     * @param width     图片宽
     * @param height    图片高
     * @param codeCount 字符个数
     * @param lineCount 干扰线条数
     * @return {@link LineCaptcha}
     */
    public static LineCaptcha createLineCaptcha(int width, int height, int codeCount, int lineCount) {
        return new LineCaptcha(width, height, codeCount, lineCount);
    }
}
