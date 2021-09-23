package com.example.study.springaws.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HelloResponseDtoTest {
    
    @Test
    public void 롬복테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertEquals(name, dto.getName());
        assertEquals(amount, dto.getAmount());
    }

}
