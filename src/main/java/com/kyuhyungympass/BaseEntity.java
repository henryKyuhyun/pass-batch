package com.kyuhyungympass;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @CreatedDate    //entity가 생성되서 저장될떄 자동저장된다는의미
    @Column(updatable = false,nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate       // 변경할때 업데이트하게된다
    private LocalDateTime modifiedAt;

}
