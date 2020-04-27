package com.dlerroan.osworks.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.dlerroan.osworks.domain.model.ServiceOrderStatus;

public class RepresentationServiceOrderModel {
	
	private Long id;
	private String nameClient;
	private String description;
	private BigDecimal price;
	private ServiceOrderStatus status;
	private OffsetDateTime openedDate;
	private OffsetDateTime closedDate;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNameClient() {
		return nameClient;
	}
	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public ServiceOrderStatus getStatus() {
		return status;
	}
	public void setStatus(ServiceOrderStatus status) {
		this.status = status;
	}
	public OffsetDateTime getOpenedDate() {
		return openedDate;
	}
	public void setOpenedDate(OffsetDateTime openedDate) {
		this.openedDate = openedDate;
	}
	public OffsetDateTime getClosedDate() {
		return closedDate;
	}
	public void setClosedDate(OffsetDateTime closedDate) {
		this.closedDate = closedDate;
	}

}
