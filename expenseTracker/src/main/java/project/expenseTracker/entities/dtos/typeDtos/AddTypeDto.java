package project.expenseTracker.entities.dtos.typeDtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class AddTypeDto {

	@JsonIgnore
	private int id;
	private String name;
}
