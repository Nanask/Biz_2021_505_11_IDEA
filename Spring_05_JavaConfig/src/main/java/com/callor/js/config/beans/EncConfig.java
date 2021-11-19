package com.callor.js.config.beans;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Configuration
// 메세지를 읽어서 빈으로 등록해달라
@Component
@Slf4j
public class EncConfig {

    // 환경변수를 가져와서 config를 설정
    private EnvironmentStringPBEConfig envConfig() {
        EnvironmentStringPBEConfig config
                = new EnvironmentStringPBEConfig();
        config.setAlgorithm("PBEWithMD5AndDES");
        // 환경변수 불러오기
        config.setPasswordEnvName("callor.com");

        log.debug("Callor.com {}", config.getPassword());
        return config;
    }
    //    encryptor를 사용해서 비밀번호를 복호화 시킬 설정
    @Bean("encryptor")
    public StandardPBEStringEncryptor encryptor() {
//    private StandardPBEStringEncryptor encryptor() {
        StandardPBEStringEncryptor encryptor
                = new StandardPBEStringEncryptor();
        encryptor.setConfig(this.envConfig());
        return encryptor;
    }
}
