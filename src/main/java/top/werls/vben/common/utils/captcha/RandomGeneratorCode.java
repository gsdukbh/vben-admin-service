package top.werls.vben.common.utils.captcha;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serial;

/**
 * @author leejiawei
 * @version TODO
 * @since on  2021/9/28
 */
public class RandomGeneratorCode extends AbstractGenerator {


    @Serial
    private static final long serialVersionUID = 180047700083964814L;

    /**
     * 构造，使用字母+数字做为基础
     *
     * @param count 生成验证码长度
     */
    public RandomGeneratorCode(int count) {
        super(count);
    }

    /**
     * 构造
     *
     * @param baseStr 基础字符集合，用于随机获取字符串的字符集合
     * @param length  生成验证码长度
     */
    public RandomGeneratorCode(String baseStr, int length) {
        super(baseStr, length);
    }

    /**
     * 生成验证码
     *
     * @return 验证码
     */
    @Override
    public String generate() {
        return RandomStringUtils.random(this.length, this.baseStr);
    }

    private static String randomString(String baseString, int length) {
        if (StringUtils.isEmpty(baseString)) {
            return "";
        }
        final StringBuilder sb = new StringBuilder(length);

        if (length < 1) {
            length = 1;
        }
        int baseLength = baseString.length();
        for (int i = 0; i < length; i++) {
            int number = RandomUtils.nextInt(0, baseLength);
            sb.append(baseString.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 验证用户输入的字符串是否与生成的验证码匹配<br>
     * 用户通过实现此方法定义验证码匹配方式
     *
     * @param code          生成的随机验证码
     * @param userInputCode 用户输入的验证码
     * @return 是否验证通过
     */
    @Override
    public boolean verify(String code, String userInputCode) {
        if (StringUtils.isNotBlank(userInputCode)) {
            return StringUtils.equalsIgnoreCase(code, userInputCode);
        }
        return false;
    }
}
