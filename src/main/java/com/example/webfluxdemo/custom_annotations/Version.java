package com.example.webfluxdemo.custom_annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
// Target.CLASS is default
@interface Version {

  String value() default "0.0";

}


