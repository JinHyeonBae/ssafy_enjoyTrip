package com.ssafy.vue.trip.model;

import java.util.List;

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
public class TripScheduleDto {
	
	String user_id;
	String title;
	String memo;
	String content;
	String start_date;
	String end_date;
	
	
	public TripScheduleDto(String user_id, String title, String memo, String content, String start_date,
			String end_date) {
		super();
		this.user_id = user_id;
		this.title = title;
		this.memo = memo;
		this.content = content;
		this.start_date = start_date;
		this.end_date = end_date;
	}

}

