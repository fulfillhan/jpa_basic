package hello.jpaBasic.practice02.domain;

import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;
@Embeddable // 값 타입을 정의하는 곳에 표시
public class Period {

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    // 객체 타입은 immutable 해야 한다.  set타입 제거
    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }
}
