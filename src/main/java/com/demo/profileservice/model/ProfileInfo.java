package com.demo.profileservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class ProfileInfo {
    long id;
    Date date;
}
