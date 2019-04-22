package com.bxia.bookstore.mapper;

import com.bxia.bookstore.domain.User;
import com.bxia.bookstore.enums.Gender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testSave(){
        int count = userMapper.insert(User.builder().username("jack")
                .password("123456").gender(Gender.MALE).age(27).phoneNumber("18008258751").build());
        assertEquals(1, count);
    }
}