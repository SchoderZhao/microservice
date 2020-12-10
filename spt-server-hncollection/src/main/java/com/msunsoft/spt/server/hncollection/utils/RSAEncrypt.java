package com.msunsoft.spt.server.hncollection.utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.net.URLDecoder;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

public class RSAEncrypt {
    private static Map<Integer, String> keyMap = new HashMap<Integer, String>();  //用于封装随机产生的公钥与私钥

    public static final String privateKeyString = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALWlJrMB6Isddnu4" +
            "SDU93R/J5LSOH2ZLpeC8eFFPLSJt2j1AElgYwIgD/BmZmfSx1bV2KH6wbh2wPNaA" +
            "SfUAI5NZ2PllzKvFql20nho2lH8wHJRI53spH3UKePYj0pfhYq/pkLrSyGROVoct" +
            "h690lsjxS/zfEtyboVcRmQkKdFrFAgMBAAECgYBDNDoQKpmVtq3ackDM6fmAxFqI" +
            "brixSTWy4ygEtS12unvvA2CGFYpOCGNiOVEblhwCShgLX00uUMEBf29dZNLEFt3D" +
            "7lXRUSzdseNDOUnReuwiwYlhYFU3u6PVFK8geqllNRsslI36cZjmiyiO5JQ+cFwi" +
            "iRHgKtp+46uBJVDIIQJBAOBfkCeEB0Gq0JR5bEMpSaf4WAIcn3NLYTsgVbHK1IeR" +
            "87KliVEYsJ8qoKEqkq/7cJ9if2oHZMOBO2Arw8JCuV0CQQDPP8GHPgOvgYAnAaWX" +
            "+baFjxNIgw3dI+J5UEc+9YRilySFuDuyq2pU6wJz1h39xDRM2/oXoj6aAXNP7hdA" +
            "QUiJAkEAv3HqvzzRMD++byFXtcqR1Wd6OHsRtj94PAnv9J7bTr3DEQhbrT2C3pxx" +
            "qHJ57Px+8RALJX4fhQ1Mi1dsVeG25QJAK9u1K9au1vxTz21kysWYn6kIjqbVT0Ah" +
            "1ERt31/7tRWBMB8t2wC1juTw7uyYCjT0UHOY+FloYBUAfyDGoN1v6QJALf2+mE6l" +
            "0ZBijoRkSYjybnffBD8DmOKt/TTf8uFCfaLw0NABqAxBSyqzk1o0nu5ZUQ0b8sJZ" +
            "Yg6CnBqrxWz56Q==";
    public static final String publicKeyString = "MIICXAIBAAKBgQC1pSazAeiLHXZ7uEg1Pd0fyeS0jh9mS6XgvHhRTy0ibdo9QBJYGMCIA/wZmZn0sdW1dih+sG4dsDzWgEn1ACOTWdj5ZcyrxapdtJ4aNpR/MByUSOd7KR91Cnj2I9KX4WKv6ZC60shkTlaHLYevdJbI8Uv83xLcm6FXEZkJCnRaxQIDAQABAoGAQzQ6ECqZlbat2nJAzOn5gMRaiG64sUk1suMoBLUtdrp77wNghhWKTghjYjlRG5YcAkoYC19NLlDBAX9vXWTSxBbdw+5V0VEs3bHjQzlJ0XrsIsGJYWBVN7uj1RSvIHqpZTUbLJSN+nGY5osojuSUPnBcIokR4CrafuOrgSVQyCECQQDgX5AnhAdBqtCUeWxDKUmn+FgCHJ9zS2E7IFWxytSHkfOypYlRGLCfKqChKpKv+3CfYn9qB2TDgTtgK8PCQrldAkEAzz/Bhz4Dr4GAJwGll/m2hY8TSIMN3SPieVBHPvWEYpckhbg7sqtqVOsCc9Yd/cQ0TNv6F6I+mgFzT+4XQEFIiQJBAL9x6r880TA/vm8hV7XKkdVnejh7EbY/eDwJ7/Se2069wxEIW609gt6ccahyeez8fvEQCyV+H4UNTItXbFXhtuUCQCvbtSvWrtb8U89tZMrFmJ+pCI6m1U9AIdREbd9f+7UVgTAfLdsAtY7k8O7smAo09FBzmPhZaGAVAH8gxqDdb+kCQC39vphOpdGQYo6EZEmI8m533wQ/A5jirf003/LhQn2i8NDQAagMQUsqs5NaNJ7uWVENG/LCWWIOgpwaq8Vs+ek=";
    /*public static void main(String[] args) throws Exception {
        //生成公钥和私钥
        genKeyPair();
        //加密字符串
        String message = "df723820";
        System.out.println("随机生成的公钥为:" + keyMap.get(0));
        System.out.println("随机生成的私钥为:" + keyMap.get(1));
        String messageEn = encrypt(message,keyMap.get(0));
        System.out.println(message + "\t加密后的字符串为:" + messageEn);
        String messageDe = decrypt(messageEn,keyMap.get(1));
        System.out.println("还原后的字符串为:" + messageDe);
    }*/

    /**
     * 随机生成密钥对
     * @throws NoSuchAlgorithmException
     */
    public static void genKeyPair() throws NoSuchAlgorithmException {
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        // 初始化密钥对生成器，密钥大小为96-1024位
        keyPairGen.initialize(1024,new SecureRandom());
        // 生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();   // 得到私钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  // 得到公钥
        //String publicKeyString = new String(Base64.encodeBase64(publicKey.getEncoded()));
//        String publicKeyString = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC1pSazAeiLHXZ7uEg1Pd0fyeS0jh9mS6XgvHhRTy0ibdo9QBJYGMCIA/wZmZn0sdW1dih+sG4dsDzWgEn1ACOTWdj5ZcyrxapdtJ4aNpR/MByUSOd7KR91Cnj2I9KX4WKv6ZC60shkTlaHLYevdbI8Uv83xLcm6FXEZkJCnRaxQIDAQAB";
//        String privateKeyString = "MIICXAIBAAKBgQC1pSazAeiLHXZ7uEg1Pd0fyeS0jh9mS6XgvHhRTy0ibdo9QBJYGMCIA/wZmZn0sdW1dih+sG4dsDzWgEn1ACOTWdj5ZcyrxapdtJ4aNpR/MByUSOd7KR91Cnj2I9KX4WKv6ZC60shkTlaHLYevdJbI8Uv83xLcm6FXEZkJCnRaxQIDAQABAoGAQzQ6ECqZlbat2nJAzOn5gMRaiG64sUk1suMoBLUtdrp77wNghhWKTghjYjlRG5YcAkoYC19NLlDBAX9vXWTSxBbdw+5V0VEs3bHjQzlJ0XrsIsGJYWBVN7uj1RSvIHqpZTUbLJSN+nGY5osojuSUPnBcIokR4CrafuOrgSVQyCECQQDgX5AnhAdBqtCUeWxDKUmn+FgCHJ9zS2E7IFWxytSHkfOypYlRGLCfKqChKpKv+3CfYn9qB2TDgTtgK8PCQrldAkEAzz/Bhz4Dr4GAJwGll/m2hY8TSIMN3SPieVBHPvWEYpckhbg7sqtqVOsCc9Yd/cQ0TNv6F6I+mgFzT+4XQEFIiQJBAL9x6r880TA/vm8hV7XKkdVnejh7EbY/eDwJ7/Se2069wxEIW609gt6ccahyeez8fvEQCyV+H4UNTItXbFXhtuUCQCvbtSvWrtb8U89tZMrFmJ+pCI6m1U9AIdREbd9f+7UVgTAfLdsAtY7k8O7smAo09FBzmPhZaGAVAH8gxqDdb+kCQC39vphOpdGQYo6EZEmI8m533wQ/A5jirf003/LhQn2i8NDQAagMQUsqs5NaNJ7uWVENG/LCWWIOgpwaq8Vs+ek=";
        // 得到私钥字符串
        //String privateKeyString = new String(Base64.encodeBase64((privateKey.getEncoded())));
        // 将公钥和私钥保存到Map
//        keyMap.put(0,publicKeyString);  //0表示公钥
//        keyMap.put(1,privateKeyString);  //1表示私钥
    }
    /**
     * RSA公钥加密
     *
     * @param str
     *            加密字符串
     * @param publicKey
     *            公钥
     * @return 密文
     * @throws Exception
     *             加密过程中的异常信息
     */
    public static String encrypt(String str, String publicKey ) throws Exception {
        //base64编码的公钥
        byte[] decoded = Base64.decodeBase64(publicKey.getBytes("UTF-8"));
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        //RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        //加密后的为字符节类型，要转换成String类型
        byte[] bytes = Base64.encodeBase64(cipher.doFinal(str.getBytes("UTF-8")));
        //字符节类型转String类型
        String outStr=new String(bytes);
        return outStr;
    }

    /**
     * RSA私钥解密
     *
     * @param stri
     *            加密字符串
     *            私钥
     * @return 明文
     * @throws Exception
     *             解密过程中的异常信息
     */
    public static String decrypt(String stri) throws Exception {
        String str = URLDecoder.decode(stri, "utf-8");
        System.out.println("str===="+str);
        //64位解码加密后的字符串
        byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
        //base64编码的私钥
        byte[] decoded = Base64.decodeBase64(privateKeyString.getBytes("UTF-8"));
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        byte[] outStr = cipher.doFinal(inputByte);
        String strs = new String(outStr);
        return strs;
    }
    public static String bytesToString(byte[] encrytpByte) {
        String result = "";
        for (Byte bytes : encrytpByte) {
            result += bytes.toString() + " ";
        }
        return result;
    }



}
