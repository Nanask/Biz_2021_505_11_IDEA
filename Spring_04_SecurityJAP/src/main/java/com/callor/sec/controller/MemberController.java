package com.callor.sec.controller;

import com.callor.sec.models.UserDetailsVO;
import com.callor.sec.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

//    @Qualifier("memServiceV1") 여러개의 서비스가 있다는 가정하에 여기에 서비스를 부착시켜라
    public MemberController(@Qualifier("memServiceV1") MemberService memberService) {
        this.memberService = memberService;
    }

    // login form을 열기위한 URL
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "member/login";
    }

    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public String join() {
        return "member/join";
    }

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public String join(UserDetailsVO userVO) {

        log.debug("회원가입:{}", userVO.toString());
        memberService.insert(userVO);
        return "member/join";
    }
    @ResponseBody
    @RequestMapping(value = "/idcheck", method = RequestMethod.GET)
    public UserDetails idCheck(String username) {
        /**
         * service(dao) findById(username) 으로 조회를 하여
         * 결과를 바로 return 할 수 있다
         *
         * 이미 데이터가 있으면 회원정보가 return
         * 그렇지 않으면 null 값이 자동으로 return 될 것이다.
         *
         * Dao를 사용한다면, 밑에 코드로도 사용가능하다.
         * return sService.findById(username)
         */
//        return "nana";

//        if(username.equalsIgnoreCase("nana")){
//            return "FAIL";
//        }else {
//            return null;
//        }

        // 조회한 ID가 있으면 findById가 return, 없으면 null
        return memberService.findById(username);
    }


}
