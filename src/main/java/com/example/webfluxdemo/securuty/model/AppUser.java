package com.example.webfluxdemo.securuty.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("app_user")
//@Data
public record AppUser(
    @Id @Column("USR_ID") Integer id,
    @Column("USR_NAME") String username,
    @Column("USR_PASSWORD") String password,
    @Column("USR_AUTHORITY") String authority
) {

}
