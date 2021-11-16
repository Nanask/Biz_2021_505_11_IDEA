package com.callor.sec.service.auth;

import com.callor.sec.models.UserDetailsVO;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 로그인을 수행하는 절차의 일부를 가로채서
 * Custom 하기
 *
 */

@Service("authenticationProvider")
public class AuthProviderImpl implements AuthenticationProvider {
    /**
     * 사용자 이름, 비밀번호 검증 등을 자체적으로 수행하는 코드
     *  Spring security 에서 제공하는 기본 Provider를 가로채서 코드를 수행한다.
     *
     *  정상적으로 로그인이 수행되면(username, password 검증 완료)
     *  반드시 UsernamePasswordAuthenticationToken 객체를 return 해야 한다
     *  이 객체에는 username, password, Roles 정보가 포함되어야 한다
     *
     */

    private final LoginService loginService;
    private final PasswordEncoder passwordEncoder;

    public AuthProviderImpl(LoginService loginService, PasswordEncoder passwordEncoder) {
        this.loginService = loginService;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

//        String 으로 형변환 시켜줘야 함
//        login.jsp에서 POST로 전달받은 username, password
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        // 로그인 한 사용자 정보를 DB로 부터 가져오기
        // loadUserByUsername() method 에서는
// DB로 부터 findById()를 수행하여
//        사용자 정보를 fetch 하고, username 을 검증한 상태이다다
       UserDetailsVO userVO = (UserDetailsVO) loginService.loadUserByUsername(username);

//       원래 오류가 날 경우 badException 만 나오다 보니, 세심하게 나오게 하고 싶어서 custom함
       // 사용자 정보를 한단계씩 검증하기
        if(!userVO.isEnabled()) {
            throw new DisabledException(username);
        }
        if(!userVO.isAccountNonExpired()) {
            throw new AccountExpiredException(username);
        }
        if(!userVO.isAccountNonLocked()) {
            throw new LockedException(username);
        }
        if(!userVO.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException(username);
        }
        if (passwordEncoder.matches(password, userVO.getPassword())) {

            throw  new BadCredentialsException(username);
        }
//        토큰을 생성해주기
        return new UsernamePasswordAuthenticationToken(username,password, userVO.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
