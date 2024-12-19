package com.raghu.exceptionhandling;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ErrorMessage {

	private int statusCode;
	private String descritpion;
	//@JsonFormat(pattern = "MM-dd-yyyy HH:mm:ss")
	private LocalDateTime localDateTime;
	private String status;

}
