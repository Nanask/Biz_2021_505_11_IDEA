package com.callor.js.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.callor.js.repository")
// classpath를 통해서 db.properties를 가져옴?
@PropertySource("classpath:db.properties")
public class MyBatisConfig {

    // db.driver를 찾아와라?
    @Value("${db.driver}")
    private String driver;
    @Value("${db.url}")
    private String url;

    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;

    // 환경변수를 가져와서 config를 설정
    private EnvironmentStringPBEConfig envConfig() {
        EnvironmentStringPBEConfig config
                = new EnvironmentStringPBEConfig();
        config.setAlgorithm("PBEWithMD5AndDES");
        // 환경변수 불러오기
        config.setPasswordEnvName("callor.com");
        return config;
    }
//    encryptor를 사용해서 비밀번호를 복호화 시킬 설정
    private StandardPBEStringEncryptor encryptor() {
        StandardPBEStringEncryptor encryptor
                = new StandardPBEStringEncryptor();
        encryptor.setConfig(this.envConfig());
        return encryptor;
    }

    //dataSource
    // 굳이 bean으로 등록할 필요가 없어서 private 로 변경
    private DataSource getDataSource() {
        BasicDataSource ds = new BasicDataSource();
        // 우리가 등록했던 url , username 등을 setter방식으로 저장함
//        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        ds.setUrl("jdbc:mysql://localhost:3306/naraDB");
        ds.setDriverClassName(driver);
        ds.setUrl(url);
//        암호화된것을 decrypt해서 가져오기?
        String planUsername = this.encryptor().decrypt(username);
        String planPassword = this.encryptor().decrypt(password);
        ds.setUsername("root");
        ds.setPassword("!Biz12341234");
        return ds;
    }

    //SqlSessionFactiory
    // 여기는 반드시 시스템에서 사용할 수 있도록 Bean으로 설정한다.
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() {
        SqlSessionFactoryBean sqlBean = new SqlSessionFactoryBean();
        // 위에 만들어놓은 DataSource를 가져오는 것
        sqlBean.setDataSource(this.getDataSource());
        // vo객체들이 있는 곳을 지정
        sqlBean.setTypeAliasesPackage("com.callor.js.models");
        return sqlBean;
    }

    //SqlSessionTemplate
//    시스템에서 sqlSessionFactory를 주입한다.
    // 여기도 반드시 Bean으로 등록한다.
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory factory) {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(factory);
        return sqlSessionTemplate;
    }
}
