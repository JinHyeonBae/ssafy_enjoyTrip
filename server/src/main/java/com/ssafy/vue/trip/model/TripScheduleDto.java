package com.ssafy.vue.trip.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * 
 * 	schehdule_id int PRIMARY KEY NOT NULL,
	user_id varchar(200) NOT NULL,
    title varchar(50) NULL DEFAULT "나의 여행계획",
	memo varchar(255) NULL DEFAULT "",
    content text NULL,
    start_date date default (current_date),
    end_date date DEFAULT (current_date) 
    
      userId: userId.value,
      title: title.value,
      memo: memo.value,
      start_date: startDate.value,
      end_date: destDate.value,
      content: getIndexes(),
 * 
 * 
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TripScheduleDto {
	
	String user_id;
	String title;
	String memo;
	Integer sido;
	Integer gugun;
	Integer typeInfo;
	String content;
	String start_date;
	String end_date;

	@Override
	public String toString() {
		return "TripScheduleDto{" +
				"user_id='" + user_id + '\'' +
				", title='" + title + '\'' +
				", memo='" + memo + '\'' +
				", sido=" + sido +
				", gugun=" + gugun +
				", typeInfo=" + typeInfo +
				", content='" + content + '\'' +
				", start_date='" + start_date + '\'' +
				", end_date='" + end_date + '\'' +
				'}';
	}



}

