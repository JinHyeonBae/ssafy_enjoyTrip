package com.ssafy.vue.trip.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SidoDto {

    Integer sido_code;
    String sido_name;

    public SidoDto(int sido_code, String sido_name){
        this.sido_code = sido_code;
        this.sido_name = sido_name;
    }
}
