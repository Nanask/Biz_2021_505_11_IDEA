package com.callor.js.service.impl;

import com.callor.js.models.BookVO;
import com.callor.js.models.NaverResLayout;
import com.callor.js.service.NaverService;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.*;
import java.util.Collections;
import java.util.List;

/**
 * abstract(추상) 클래스
 * 일반 클래스와 인터페이스의 기능을 결합한 클래스
 * 인터페이스 처럼 구현되지 않은 프로토 타입의 method를 가지면서
 * 일부는 자체적으로 구현된 method 도 포함하는 클래스
 *
 * 인터페이스
 * 클래스를 만들기 위한 설계도 역할
 * method 의 프로토 타입만 있고 실제 구현된 코드는 없다
 */

@Slf4j
@Service("naverServiceV1")
@PropertySource("classpath:naver.properties")
public  class NaverServiceImplV1 extends NaverService<BookVO> {

    // 프로퍼티에 등록되어 있는 변수값을 불러오겟다!
    @Value("${naver.client_id}")
    private String naver_client_id;
    @Value("${naver.client_secret}")
    private String naver_client_secret;

    @Autowired
    private StandardPBEStringEncryptor encryptor;

//    private final String NAVER_BOOK_URL = "https://openapi.naver.com/v1/search/book.json";

//    public  String queryURL(String search) throws UnsupportedEncodingException {
//        String searchUTF8 = URLEncoder.encode(search, "UTF-8");
//        StringBuilder queryURL = new StringBuilder();
//        queryURL.append(NAVER_BOOK_URL);
//        queryURL.append(String.format("?query=%s", searchUTF8));
//        return queryURL.toString();
//    }

    // naver
    public String getJsonString(String queryString) throws IOException {

        URL url = new URL(queryString);
        HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();

        httpCon.setRequestMethod("GET");


//        httpCon.setRequestProperty("X-Naver-Client-Id", naver_client_id);
//        httpCon.setRequestProperty("X-Naver-Client-Secret", naver_client_secret);



        httpCon.setRequestProperty("X-Naver-Client-Id", encryptor.decrypt(naver_client_id));
        httpCon.setRequestProperty("X-Naver-Client-Secret", encryptor.decrypt(naver_client_secret));

        log.debug("id : {}",naver_client_id);
        log.debug("id : {}", encryptor.decrypt(naver_client_id));

        InputStreamReader is = null;

        int httpStatusCode = httpCon.getResponseCode();

        // 정상일 경우는 input을 연결, 에러일 경우는 Error 연결
        if(httpStatusCode == 200) {
            is = new InputStreamReader(httpCon.getInputStream(), "UTF-8");
        }else {
            is = new InputStreamReader(httpCon.getErrorStream(), "UTF-8");
        }

        BufferedReader buffer = new BufferedReader(is);
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String reader = buffer.readLine();
            if(reader == null) break;

            stringBuffer.append(reader);

        }
        return  stringBuffer.toString();

    }

    /**
     * RestTemplate 를 사용하여 naver 도서정보 가져오기
     * @param queryString
     * @return
     */
    @Override
    public List<BookVO> naverList(String queryString) throws URISyntaxException {

        /**
         * VO 클래스를 Wrapping 하여 API 데이터 가져오기
         */
        RestTemplate restTemp = new RestTemplate();
        ResponseEntity<NaverResLayout> restList = null;

        URI restURI = new URI(queryString);

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", encryptor.decrypt(naver_client_id));
        headers.set("X-Naver-Client-Secret", encryptor.decrypt(naver_client_secret));

        // API에서 XML, JSON 데이터를 한가지 URL로 요청하는 경우 수신한 데이터 Type을 지정해주기
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // 설정된 header 정보를 Http 포로토콜에 담기
        HttpEntity<String> httpEntity = new HttpEntity<String>("parameters", headers);

        restList = restTemp.exchange(restURI, HttpMethod.GET, httpEntity, NaverResLayout.class);
        return restList.getBody().getItems();
    }
}
