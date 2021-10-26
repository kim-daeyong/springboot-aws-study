package com.example.study.springaws.domain;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@Getter
@MappedSuperclass // jpa entity 클래스들이 상속할 경우 field 들을 컬럼으로 인식하도록 함
@EntityListeners(AuditingEntityListener.class) // 이 클래스에 Auditing 기능 추가
public class BaseTimeEntity {

    @CreatedDate // 생성될때
    private LocalDateTime createdDate;

    @LastModifiedDate // entity의 값이 변경될때 자동 저장
    private LocalDateTime modifiedDate;
}
