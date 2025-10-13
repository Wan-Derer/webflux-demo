package com.example.webfluxdemo.custom_annotations;

// https://hyperskill.org/learn/step/12806

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(Descriptions.class)   // аннотацию можно применять более одного раза
@Documented     // не принимает параметров и включает аннотацию в документации Javadoc
@Inherited      // будет применена ко всем подклассам аннотированного класса
public @interface Description {

  String author();

  String description();

  int version() default 0;
}
