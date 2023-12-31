package com.kyuhyungympass.repository.statistics;

import com.kyuhyungympass.repository.booking.BookingEntity;
import com.kyuhyungympass.repository.booking.BookingStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@Table(name = "statistics")
public class StatisticsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer statisticsSeq;
    private LocalDateTime statisticsAt;

    private int allCount;
    private int attendedCount;
    private int cancelledCount;

    public static StatisticsEntity create(final BookingEntity bookingEntity){
        StatisticsEntity statisticsEntity = new StatisticsEntity();
        statisticsEntity.setStatisticsAt(bookingEntity.getCancelledAt());
        statisticsEntity.setAllCount(1);
        if(bookingEntity.isAttended()){
            statisticsEntity.setAllCount(1);
        }
        if(BookingStatus.CANCELLED.equals(bookingEntity.getStatus())){
            statisticsEntity.setCancelledCount(1);
        }
        return statisticsEntity;
    }

    public void add(final BookingEntity bookingEntity){
        this.allCount++;
        if(bookingEntity.isAttended()){
            this.attendedCount++;
        }
        if(BookingStatus.CANCELLED.equals(bookingEntity.getStatus())){
            this.cancelledCount++;
        }
    }
}
