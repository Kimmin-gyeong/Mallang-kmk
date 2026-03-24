package com.smhrd.malang.dto.persona;

import lombok.Getter;

@Getter
public class PersonaUpdateRequestDto {//update용 dto는 request dto와 분리하래서 새로만듦..
    private String personaName;
}
