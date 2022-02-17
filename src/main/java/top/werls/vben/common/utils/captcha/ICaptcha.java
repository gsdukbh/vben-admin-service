package top.werls.vben.common.utils.captcha;

import java.io.OutputStream;
import java.io.Serializable;

/**
 * @author leejiawei
 * @version TODO
 * @since on  2021/9/28
 */
public interface ICaptcha extends Serializable {
    /**
     * 创建 验证码
     */
    void createCode();

    /**
     * 获取验证码
     *
     * @return 图片的验证码
     */
    String getCode();

    /**
     * 验证 code与图片是否一致
     *
     * @param code 验证码
     * @return 正确返回ture，否则false
     */
    Boolean validation(String code);

    /**
     * 输出到目标
     * @param out 输出流
     */
    void write(OutputStream out);
}
