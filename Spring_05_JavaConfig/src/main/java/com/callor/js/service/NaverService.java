package com.callor.js.service;

import com.callor.js.models.BookVO;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.List;

// 공통적으로 사용하기 위하여 <T> 로 표기
public abstract class NaverService<T> {

    public static final String NAVER_BOOK_URL = "https://openapi.naver.com/v1/search/book.json";
//    private final String NAVER_BOOK_URL = "https://openapi.naver.com/v1/search/book.json";

    // 필수적으로 생성할 method
    // queryURL은 중복되기 때문에 이걸 그대로 사용하고
    public String queryURL(String search) throws UnsupportedEncodingException {
        String searchUTF8 = URLEncoder.encode(search, "UTF-8");
        StringBuilder queryURL = new StringBuilder();
        queryURL.append(NAVER_BOOK_URL);
        queryURL.append(String.format("?query=%s", searchUTF8));
        return queryURL.toString();
    }

    // 선택적으로 사용할 method
    // abstract를 사용함으로서 나머지는 알아서 만들어서 사용하라는 읨

    public abstract String getJsonString(String queryString) throws IOException;
    public abstract List<T> naverList(String queryString) throws URISyntaxException;
}
