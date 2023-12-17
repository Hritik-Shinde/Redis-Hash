package com.redishash.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer stdId;
	private Integer studentRollNumber;
	private String studentName;
	private String studentAddress;

}
