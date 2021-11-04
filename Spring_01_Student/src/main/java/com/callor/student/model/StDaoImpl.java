package com.callor.student.model;

import com.callor.student.repository.StDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StDaoImpl implements StDao {

    private final String[] stNames = {"고은결", "노소연", "박은빈", "김영진", "나나"};

    private final Random RND = new Random();

    // 원래 selectAll() 밖에 생성을 했었는데, 계속 리스트가 추가되는 현상이 발생
    // 그래서 밑에 selectAll() 안에 생성을 해줌
//   private final List<StudentVO> stList = new ArrayList();

    public List<StudentVO> findAll() {
        return null;
    }

    @Override
    public List<StudentVO> selectAll() {

        // method내에게 생성을 해주는 것이 좋다
        final List<StudentVO> stList = new ArrayList();

        for(int i = 0 ; i < 10 ; i++)  {
            String stNum = String.format("2021%04d", i+1);
            String stName = stNames[RND.nextInt(stNames.length)];

//            학번만들기
            StudentVO vo = StudentVO.builder()
                    .st_num(stNum)
                    .st_name(stName)
                    .st_dept("컴퓨터공학")
                    .st_address("광주광역시 신안동 478-67")
                    .st_grade((RND.nextInt(4)+ 1) + "")
                    .st_tel(String.format("062-%04d-%04d",
                            RND.nextInt(9999) + 1,
                            RND.nextInt(9999) + 1
                            )
                    ).build();
            stList.add(vo);
        }
        return stList;
    }

    @Override
    public StudentVO findById() {
        return null;
    }

    @Override
    public void insert(StudentVO VO) {

    }

    @Override
    public void update(StudentVO VO) {

    }

    @Override
    public void delete(String st_num) {

    }
}
