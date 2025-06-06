package com.davidgomez.agifyapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgifyResponse {

    private String name;
    private Integer age;
    private Integer count;


}
