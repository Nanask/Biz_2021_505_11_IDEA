package com.callor.sec.service.impl;

import com.callor.sec.models.UserDetailsVO;
import com.callor.sec.repository.MemberDao;
import com.callor.sec.service.MemberService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("memServiceV1")
public class MemberserviceImplV1 implements MemberService {

    // 생성자 주입방식
    private final MemberDao memDao;
//    public MemberserviceImplV1(MemberDao memDao) {
//        this.memDao = memDao;
//    }

    /**
     * security-context.xml에 선언된 bean을 가져와서
     * 와이어드 하여 사용할 준비 하기
     *
     * bean으로 이미 선언이 되었기 때문에
     * final 로 선언하고 생성자에서 주입받기기     */
    private final PasswordEncoder passwordEncoder;

    public MemberserviceImplV1(MemberDao memDao, PasswordEncoder passwordEncoder) {
        this.memDao = memDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserDetailsVO> selectAll() {
        List<UserDetailsVO> memberList = memDao.findAll();
        return memberList;
    }

    @Override
    public UserDetailsVO findById(String username) {

//        옵셔널? 타입이기때문에 끝에 get을 꼭 붙이기
//        JpaRepository 에 선언된 findById(PK)는 Select * From [table] WHERE PK = [pk] SQL 을 실행하고
//        결과를 Optional<UserDetailsVO> type 으로 return 한다
//        Optional 로 감싸진 데이터는 null safe type의 데이터이다
//        null 값으로 뭔가를 검사하려고 하면 문제가 되기 한다
//        그래서 그 문제를
//        결과값.orElse() method를 사용하여
//        결과값이 실제로 null 이면 orElse(리턴값)을 참조하여 그 값을 연산 결과로 return 해준다

//        이러한 원리를 이용하여 findById() 한 결과가 없으면 null 을 return 하도록 만들어준다.

        UserDetailsVO userVO = memDao.findById(username).orElse(null);
        return userVO;
    }

    @Override
    public void insert(UserDetailsVO userDetailsVO) {

        /**
         * BCryptPasswordEncoder : class
         * Spring security 에서 제공하는 PasswordEncoder(BCryptPasswordEncoder) 를 사용하여
         * 사용자의 비밀번호를 암호화 하기
         */
        String encPassword = passwordEncoder.encode(userDetailsVO.getPassword());

        UserDetailsVO saveVO = userDetailsVO.builder()
                        .username(userDetailsVO.getUsername())
                        .password(encPassword)
                        .isAccountNonLocked(true)
                        .isEnabled(true)
                        .isCredentialsNonExpired(true)
                        .isAccountNonExpired(true)
                        .build();


        // db로 전송
        memDao.save(saveVO);
//        memDao.save(userDetailsVO);

    }

    @Override
    public void update(UserDetailsVO userDetailsVO) {

    }

    @Override
    public void delete(String s) {

    }

    @Override
    public List<UserDetailsVO> findByEmail(String email) {
        return null;
    }

    @Override
    public List<UserDetailsVO> findByTel(String tel) {
        return null;
    }

    @Override
    public int userCount() {
        return 0;
    }
}
