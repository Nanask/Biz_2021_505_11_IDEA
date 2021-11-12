package com.callor.sec.exec;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class BCrypt_01 {

    public static void main(String[] args) {

        /**
         * 암호화, 복호화
         *
         * 보안과 관련된 용어 중 "인가"
         * username, password 를 입력받아
         * 정상적인 사용자 username password 인지 검사하고
         * 접속을 허가하는 절차
         *
         * 양방향 암호를 이용한 보안
         * jasypt 를 이용한 암호화 방법
         * 이때, username 은 보통 문자열로 구성하지만
         * password 는 가급적 노출되지 않도록 "암호화(encrypt)"를 한다.
         *
         * 암호화 된 password 를 DB에 저장하고 저장된 암호화 된 password를 다시 "복호화"하여
         * 로그인 정보와 비교한다.
         *
         * 단방향 암호화를 이용한 보안
         * PasswordEncoder(BCryptPasswordEncoder 로 구현)
         * 회원가입을 할 때 비번을 암호화 하여 저장을 하고
         *
         * 로그인을 할 때
         * DB 에서 회원정보를 SELECT 한 후
         * login 을 통해 전달된 Password 와 비교를 하는데
         *
         * DB에 저장된 Password 를 복호화 하지 않고
         * login 을 통해 전달된 Password 를 다시 암호화 하여
         * 두 값을 비교한다.
         * 암호화는 가능하나 복호화가 불가하다.
         */
        PasswordEncoder pass = new BCryptPasswordEncoder(4);
        String password = "12345";
        String encPassword = "$2a$04$ZKQ0/Wn8yep2IwPKKrd//OA1GPN0MIHyhBq30ov.If2DVqOWeuyli";

        String bcPassword = pass.encode(password);
        System.out.println("생성된문자열: " + bcPassword);
        System.out.println("문자열의 길이: " + bcPassword.length());

        // matches(rowPassword, encPassword)
        boolean loginOk = pass.matches(password, encPassword);

        if(loginOk) {
            System.out.println("맞습니다");
        }else {
            System.out.println("틀립니다");
        }
    }
}
