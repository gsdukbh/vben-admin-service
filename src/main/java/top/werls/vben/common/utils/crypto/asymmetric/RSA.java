package top.werls.vben.common.utils.crypto.asymmetric;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;

/**
 * @author Jiawei Lee
 * @version TODO
 * @since on  2022/6/17
 */
public class RSA {

    public static final String RSA_ALGORITHM = "RSA";

    public static final String RSA_ECB_PKCS1_PADDING = "RSA/ECB/PKCS1Padding";

    public static final String RSA_ECB_NO_PADDING = "RSA/ECB/NoPadding";

    public static final String RSA_NONE_NO_PADDING = "RSA/None/NoPadding";

    private  static final String RSA_SHA512_WITH_RSA = "SHA512withRSA";

    /**
     * 加密
     *
     * @param publicKey 公钥
     * @param data      待加密数据
     * @return 加密后的数据
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data, RSAPublicKey publicKey) throws Exception {
        return encrypt(data, publicKey, RSA_ALGORITHM);
    }

    public static byte[] encrypt(String data, RSAPublicKey publicKey) throws Exception {
        return encrypt(data.getBytes(StandardCharsets.UTF_8), publicKey, RSA_ALGORITHM);
    }

    public static String encryptToBase64(byte[] data, RSAPublicKey publicKey) throws Exception {
        return Base64.getEncoder().encodeToString(encrypt(data, publicKey));
    }

    public static String encryptToBase64(String data, RSAPublicKey publicKey) throws Exception {
        return Base64.getEncoder().encodeToString(encrypt(data, publicKey));
    }

    public static byte[] encrypt(byte[] data, RSAPrivateKey privateKey) throws Exception {
        return encrypt(data, privateKey, RSA_ALGORITHM);
    }

    public static byte[] encrypt(String data, RSAPrivateKey privateKey) throws Exception {
        return encrypt(data.getBytes(StandardCharsets.UTF_8), privateKey, RSA_ALGORITHM);
    }

    public static String encryptToBase64(byte[] data, RSAPrivateKey privateKey) throws Exception {
        return Base64.getEncoder().encodeToString(encrypt(data, privateKey));
    }

    public static String encryptToBase64(String data, RSAPrivateKey privateKey) throws Exception {
        return Base64.getEncoder().encodeToString(encrypt(data, privateKey));
    }


    /**
     * 加密
     *
     * @param data       待加密数据
     * @param privateKey 私钥
     * @param algorithm  算法
     * @throws NoSuchPaddingException    {@link  Cipher#getInstance(String)}}
     * @throws NoSuchAlgorithmException  {@link  Cipher#getInstance(String)}}
     * @throws InvalidKeyException       {@link  Cipher#init(int, java.security.Key)}}
     * @throws BadPaddingException       {@link  Cipher#doFinal(byte[])}}
     * @throws IllegalBlockSizeException {@link  Cipher#doFinal(byte[])}}
     */
    public static byte[] encrypt(byte[] data, RSAPrivateKey privateKey, String algorithm) throws NoSuchPaddingException,
            NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }


    /**
     * 加密
     *
     * @param data      data
     * @param publicKey 公钥
     * @param algorithm 算法
     * @return encrypt data
     * @throws NoSuchPaddingException    {@link  Cipher#getInstance(String)}}
     * @throws NoSuchAlgorithmException  {@link  Cipher#getInstance(String)}}
     * @throws InvalidKeyException       {@link  Cipher#init(int, java.security.Key)}}
     * @throws BadPaddingException       {@link  Cipher#doFinal(byte[])}}
     * @throws IllegalBlockSizeException {@link  Cipher#doFinal(byte[])}}
     */
    public static byte[] encrypt(byte[] data, RSAPublicKey publicKey, String algorithm) throws NoSuchPaddingException,
            NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    public static byte[] decrypt(byte[] data, RSAPrivateKey privateKey) throws Exception {
        return decrypt(data, privateKey, RSA_ALGORITHM);
    }

    public static byte[] decrypt(String data, RSAPrivateKey publicKey) throws Exception {
        return decrypt(data.getBytes(StandardCharsets.UTF_8), publicKey, RSA_ALGORITHM);
    }


    public static byte[] decryptByBase64(String data, RSAPrivateKey privateKey) throws Exception {
        return decrypt(Base64.getDecoder().decode(data), privateKey);
    }

    public static byte[] decrypt(byte[] data, RSAPublicKey publicKey) throws Exception {
        return decrypt(data, publicKey, RSA_ALGORITHM);
    }

    public static byte[] decrypt(String data, RSAPublicKey publicKey) throws Exception {
        return decrypt(data.getBytes(StandardCharsets.UTF_8), publicKey, RSA_ALGORITHM);
    }


    public static byte[]  decryptByBase64(String data, RSAPublicKey publicKey) throws Exception {
        return decrypt(Base64.getDecoder().decode(data), publicKey);
    }


    public static byte[] decrypt(byte[] data, RSAPrivateKey privateKey, String algorithm) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    public static byte[] decrypt(byte[] data, RSAPublicKey publicKey, String algorithm) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }


    public static byte[] sign(byte[] data, RSAPrivateKey privateKey) throws Exception {
        return sign(data, privateKey, RSA_SHA512_WITH_RSA);
    }

    public static byte[] sign(String data, RSAPrivateKey privateKey) throws Exception {
        return sign(data.getBytes(StandardCharsets.UTF_8), privateKey);
    }

    public static String signToBase64(byte[] data, RSAPrivateKey privateKey) throws Exception {
        return Base64.getEncoder().encodeToString(sign(data, privateKey));
    }

    public static String signToBase64(String data, RSAPrivateKey privateKey) throws Exception {
        return Base64.getEncoder().encodeToString(sign(data, privateKey));
    }

    public static  byte[] sign(byte[] data, RSAPrivateKey privateKey, String algorithm) throws Exception {
        Signature signature = Signature.getInstance(algorithm);
        signature.initSign(privateKey);
        signature.update(data);
        return signature.sign();
    }

    public static boolean verify(byte[] data, byte[] sign,PublicKey publicKey) throws Exception {
        Signature signature = Signature.getInstance(RSA_SHA512_WITH_RSA);
        signature.initVerify(publicKey);
        signature.update(data);
        return signature.verify(sign);
    }
}
