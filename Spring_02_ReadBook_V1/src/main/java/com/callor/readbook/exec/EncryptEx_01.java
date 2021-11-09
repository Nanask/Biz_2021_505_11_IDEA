package com.callor.readbook.exec;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncryptEx_01 {


    public static void main(String[] args) {

        //    암호화를 도와주는 코드
        StandardPBEStringEncryptor pbe = new StandardPBEStringEncryptor();

        String name = "Korea";
        String salt = "!Biz1234";
//        암호화 알고리즘?
//        PBE를 사용할껀데 암호화 방식을 MD5AndDES로 사용하겠다.
//        SHA-128, SHA-256, SHA-512, SHA-1024 를 이용해서 암호화하는 거래요
        String encPolicy = "PBEWithMD5AndDES";

        //        salt와 encPolicy를 통하여 Korea라는 단어를 암호화 시키겠다.
        pbe.setAlgorithm(encPolicy);
        pbe.setPassword(salt);

        String encText = pbe.encrypt(name);
        System.out.println(encText);

        // 암호화를 시킨 것을 복원시킨 것
        // 알고리즘은 몰라도 된대..
        String planText = pbe.decrypt(encText);
        System.out.println(planText);

        // 푸는 방식이 개 복잡한데 이렇게만 사용하면 salt만 알고 있으면 암호화를 풀 수 있대


    }
}
