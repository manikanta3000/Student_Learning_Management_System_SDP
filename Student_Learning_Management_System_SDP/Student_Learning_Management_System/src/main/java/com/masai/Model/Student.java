package com.masai.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
    @NotNull
	private String name;
    @NotNull
//    @Column(unique = true)
	private String email;
    @NotNull
//    @Size(min = 10,max = 10,message = "Phone number should be not less than or more than 10")
//    @Column(unique = true)
	private int phone;
//	private int class;
//  private String section;
//  private int rollNo;  
	

}


