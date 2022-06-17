package top.werls.vben.common.utils.crypto.asymmetric;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Jiawei Lee
 * @version TODO
 * @since on  2022/6/17
 */
@SpringBootTest
class RSATest {

    @Value("${env.jwt.privateKey}")
    private RSAPrivateKey key;
    @Value("${env.jwt.publicKey}")
    private RSAPublicKey publicKey;
    static final String msg = "hello";

    @Test
    void encrypt() {
        try {
            byte[] b = RSA.encrypt(msg, publicKey);
            System.out.println(Arrays.toString(b));

            byte[] c = RSA.encrypt(msg, key);
            System.out.println(Arrays.toString(c));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void encryptToBase64() {
        try {
            String s = RSA.encryptToBase64(msg, publicKey);
            System.out.println(s);

            String s1 = RSA.encryptToBase64(msg, key);
            System.out.println(s1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void decrypt() {
        try {
            byte[] b = RSA.encrypt(msg, publicKey);
            var a = RSA.decrypt(b, key);
            System.out.println(new String(a));

            byte[] c = RSA.encrypt(msg, key);
            var d = RSA.decrypt(c, publicKey);
            System.out.println(new String(d));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void decryptByBase64() {
        try {

            String s = RSA.encryptToBase64(msg, publicKey);
            var a = RSA.decryptByBase64(s, key);
            System.out.println(new String(a));

            String s1 = RSA.encryptToBase64(msg, key);
            var d = RSA.decryptByBase64(s1, publicKey);
            System.out.println(new String(d));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void sign() {
        try {
            byte[] b = RSA.sign(msg, key);
            System.out.println(Arrays.toString(b));

            String sign= RSA.signToBase64(msg, key);
            System.out.println(sign);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    void verify() {
        try {
            byte[] b = RSA.sign(msg, key);
            boolean a = RSA.verify(msg.getBytes(), b, publicKey);
            System.out.println(a);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}