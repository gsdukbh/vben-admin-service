package top.werls.vben;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.keygen.Base64StringKeyGenerator;
import top.werls.vben.common.utils.crypto.asymmetric.RSA;
import top.werls.vben.common.utils.crypto.symmetric.DES;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;
import java.util.Base64;

@SpringBootTest
class VbenApplicationTests {
    @Value("${env.jwt.privateKey}")
    private RSAPrivateKey key;
    @Value("${env.jwt.publicKey}")
    private RSAPublicKey publicKey;

    @Test
    void contextLoads() throws Exception {

        String msg = "hello";

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] cipherText = cipher.doFinal(msg.getBytes());
        System.out.println(Arrays.toString(cipherText));

        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] plainText = cipher.doFinal(cipherText);
        System.out.println(new String(plainText));


        var b = RSA.encrypt(msg, publicKey);
        System.out.println(Arrays.toString(b));
        var c = RSA.decrypt(b, key);
        System.out.println(new String(c));

        System.out.println(Arrays.toString(DES.generateKey()));
    }

}
