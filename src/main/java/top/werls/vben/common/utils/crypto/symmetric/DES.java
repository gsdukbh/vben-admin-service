package top.werls.vben.common.utils.crypto.symmetric;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;

/**
 * @author Jiawei Lee
 * @version TODO
 * @since on  2022/6/17
 */
public class DES {

    public static final String DES_ALGORITHM = "DES";

    public static final String DES_ECB_PKCS5_PADDING = "DES/ECB/PKCS5Padding";

    public static final String DES_ECB_NO_PADDING = "DES/ECB/NoPadding";

    public static final String DES_NONE_NO_PADDING = "DES/None/NoPadding";


    /**
     * 生成 DES 算法密钥
     *
     * @return byte[]
     * @throws NoSuchAlgorithmException null algorithm name
     */
    public static byte[] generateKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(DES_ALGORITHM);
        //must be equal to 56
        keyGenerator.init(56);
        SecretKey secretKey = keyGenerator.generateKey();
        return secretKey.getEncoded();
    }

    /**
     * DES加密
     *
     * @param encodedKey generateKey生成的密钥
     * @param dataBytes  byte[]形式的待加密数据
     * @return byte[] 加密后的数据
     * @throws Exception
     */
    public static byte[] encrypt(byte[] encodedKey, byte[] dataBytes) throws Exception {
        SecretKey secretKey = new SecretKeySpec(encodedKey, DES_ALGORITHM);
        Cipher cipher = Cipher.getInstance(DES_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(dataBytes);
    }

    /**
     * DES解密
     *
     * @param encodedKey    generateDESKey生成的密钥
     * @param encryptedData byte[]形式的待解密数据
     * @return byte[]
     * @throws Exception
     */
    public static byte[] decrypt(byte[] encodedKey, byte[] encryptedData) throws Exception {
        SecretKey secretKey = new SecretKeySpec(encodedKey, DES_ALGORITHM);
        Cipher cipher = Cipher.getInstance(DES_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(encryptedData);
    }
}
