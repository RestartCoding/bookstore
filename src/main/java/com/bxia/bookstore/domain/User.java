package com.bxia.bookstore.domain;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.bxia.bookstore.enums.Gender;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@TableName("t_user")
public class User {

    @TableId
    private Integer id;

    @NotBlank(message = "username not be blank")
    private String username;

    @NotBlank(message = "password not be blank")
    private String password;

    @Range(max = 100, message = "age is range 0 to 100")
    private Integer age;

    @EnumValue
    private Gender gender;

    private String phoneNumber;
}
