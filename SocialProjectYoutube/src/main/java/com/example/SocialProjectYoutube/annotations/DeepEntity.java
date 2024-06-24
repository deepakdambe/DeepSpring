package com.example.SocialProjectYoutube.annotations;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;


@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
@Documented
//@Setter
public @interface DeepEntity  {



}
