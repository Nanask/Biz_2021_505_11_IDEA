package com.callor.sec.service.auth;

import com.callor.sec.models.UserDetailsVO;
import com.callor.sec.repository.MemberDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * security에서 login 서버를 수행하는 방법이 다양하다
 *
 * DB와 연동을 하여 로그인을 수행하는는  비교적 쉬운 방법으로
 * UserDetailService 를 상속받아 클래스를 만들고 수행한다.
 * */

@Slf4j
@Service("loginService")
public class LoginService implements UserDetailsService {

    private final String encPassword = "$2a$04$ZKQ0/Wn8yep2IwPKKrd//OA1GPN0MIHyhBq30ov.If2DVqOWeuyli";
    private final MemberDao memberDao;

    public LoginService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //1. Dao에서  사용자 정보 가져오기

//       username으로 member table에서 findById(username) 등을 수행하여
//       User 정보를 가져온다
        UserDetailsVO userVO = UserDetailsVO.builder()
                .username("callor")
                .password(encPassword)
                .isAccountNonExpired(true)
                .isEnabled(false)
                .isCredentialsNonExpired(true)
                .isAccountNonLocked(true)
                .build();
//        UserDetailsVO userVO = memberDao.findById(username).get();
//       2. dao 에서 받은 사용자 정보가 없으면
//        즉, username에 저장된 사용자 이름이 DB에 없으면
//        강제로 exception을 발생하여 security 에게 알려준다.
        if(userVO == null) {
            log.debug("{} username 없음", username);

            throw new UsernameNotFoundException(username + "사용자 없음");
        }

//        가상코드
//        security에 내장된 코드 가 이런식일 것이다!
//        try {
//            UserDetails vo = loadUserByUsername("callor");
//            // 비밀번호를 검사하는 코드가 내장되어 있을 것이다.
//        }catch (UsernameNotFoundException e) {
//            //redirect "/member/login?error=xxx";
//        }

       return userVO;
    }


}
