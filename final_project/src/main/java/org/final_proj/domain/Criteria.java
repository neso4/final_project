package org.final_proj.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Criteria {
	private int pageNum;
	private int amount;
	private String keyword;
	
	public Criteria () {
		this(1, 10);
	}

	public  Criteria(int pageNum, int amount) {
		this.pageNum =pageNum;
		this.amount =amount;
	}
	
}
