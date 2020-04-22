package com.dlerroan.osworks.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

public class Problem {
	
	private Integer status;
	private LocalDateTime dateTime;
	private String title;
	private List<Field> field;
	
	public static class Field {
		
		private String name;
		private String message;
		
		public Field(String name, String message) {
			super();
			this.name = name;
			this.message = message;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Field> getField() {
		return field;
	}
	public void setField(List<Field> field) {
		this.field = field;
	}
	
	
}
