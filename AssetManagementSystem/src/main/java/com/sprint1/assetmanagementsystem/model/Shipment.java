package com.sprint1.assetmanagementsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Shipment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "shipment_id", length = 10)
	private int shipmentId;
	@Column(name = "shipment_company_name", length = 25)
	@NotEmpty(message = "should not be empty")
	private String shipmentCompanyName;

	@Column(name = "shipment_state", length = 25)
	@NotEmpty(message = "should not be empty")
	private String shipmentState;
	@Column(name = "shipment_country", length = 25)
	@NotEmpty(message = "should not be empty")
	private String shipmentCountry;
	@Column(name = "subLocation", length = 25)
	@NotEmpty(message = "should not be empty")
	private String subLocation;

	public int getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(int shipmentId) {
		this.shipmentId = shipmentId;
	}

	public String getShipmentCompanyName() {
		return shipmentCompanyName;
	}

	public void setShipmentCompanyName(String shipmentCompanyName) {
		this.shipmentCompanyName = shipmentCompanyName;
	}

	public String getShipmentState() {
		return shipmentState;
	}

	public void setShipmentState(String shipmentState) {
		this.shipmentState = shipmentState;
	}

	public String getShipmentCountry() {
		return shipmentCountry;
	}

	public void setShipmentCountry(String shipmentCountry) {
		this.shipmentCountry = shipmentCountry;
	}

	public String getSubLocation() {
		return subLocation;
	}

	public void setSubLocation(String subLocation) {
		this.subLocation = subLocation;
	}

}
