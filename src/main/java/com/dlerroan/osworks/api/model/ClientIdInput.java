package com.dlerroan.osworks.api.model;

import javax.validation.constraints.NotNull;

public class ClientIdInput {
	
	@NotNull
	private Long Id;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

}
