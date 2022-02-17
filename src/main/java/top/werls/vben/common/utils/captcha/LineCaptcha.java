package top.werls.vben.common.utils.captcha;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Serial;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author leejiawei
 * @version TODO
 * @since on  2021/9/28
 */
public class LineCaptcha extends AbstractCaptcha {

    @Serial
    private static final long serialVersionUID = 8691294460763091089L;


    /**
     * 构造，默认5位验证码，150条干扰线
     *
     * @param width  图片宽
     * @param height 图片高
     */
    public LineCaptcha(int width, int height) {
        this(width, height, 5, 150);
    }

    /**
     * 构造
     *
     * @param width     图片宽
     * @param height    图片高
     * @param codeCount 字符个数
     * @param lineCount 干扰线条数
     */
    public LineCaptcha(int width, int height, int codeCount, int lineCount) {
        super(width, height, codeCount, lineCount);
    }

    @Override
    public Image createImage(String code) {
        // 图像buffer
        final BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
        final Graphics2D g = image.createGraphics();
        g.setColor(this.background != null ? this.background : Color.WHITE);
        // 干扰线
        drawInterfere(g);

        // 字符串
        drawString(g, code);

        return image;
    }

    /**
     * 绘制字符串
     *
     * @param g    {@link Graphics}画笔
     * @param code 验证码
     */
    private void drawString(Graphics2D g, String code) {
        // 指定透明度
        if (null != this.textAlpha) {
            g.setComposite(this.textAlpha);
        }
        // 抗锯齿
        if (g != null) {
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            // 创建字体
            g.setFont(font);
            // 文字高度（必须在设置字体后调用）
            int midY = getCenterY(g, height);
            final int len = code.length();
            int charWidth = width / len;
            for (int i = 0; i < len; i++) {
                g.drawString(String.valueOf(code.charAt(i)), i * charWidth, midY);
            }
        }

    }

    public static int getCenterY(Graphics g, int backgroundHeight) {
        // 获取允许文字最小高度
        FontMetrics metrics = null;
        try {
            metrics = g.getFontMetrics();
        } catch (Exception e) {
            // 某些情况下会抛出IndexOutOfBoundsException，
            e.printStackTrace();
            throw e;
        }
        int y;
        if (null != metrics) {
            y = (backgroundHeight - metrics.getHeight()) / 2 + metrics.getAscent();
        } else {
            y = backgroundHeight / 3;
        }
        return y;
    }

    /**
     * 绘制干扰线
     *
     * @param g {@link Graphics2D}画笔
     */
    private void drawInterfere(Graphics2D g) {
        final ThreadLocalRandom random = ThreadLocalRandom.current();
        // 干扰线
        for (int i = 0; i < this.interfereCount; i++) {
            int xs = random.nextInt(width);
            int ys = random.nextInt(height);
            int xe = xs + random.nextInt(width / 8);
            int ye = ys + random.nextInt(height / 8);
            Color tem = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            g.setColor(tem);
            g.drawLine(xs, ys, xe, ye);
        }
    }
}
