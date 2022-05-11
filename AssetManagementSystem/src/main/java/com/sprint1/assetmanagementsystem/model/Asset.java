package com.sprint1.assetmanagementsystem.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Asset {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "asset_id", length = 10)
	private int assetId;
	@Column(name = "user_name", length = 25)
	@NotEmpty(message = "should not be empty")
	private String userName;
	@NonNull
	@Size(min = 2, message = " Name should have atleast 2 characters")
	@Column(name = "asset_Manufacturer", length = 25)
	private String assetManufacturer;
	@Column(name = "asset_model", length = 25)
//@NotEmpty(message = "should not be empty")
	private String assetModel;
	@Column(name = "asset_type", length = 25)
//@NotEmpty(message = "should not be empty")
	private String assetType;
	@Column(name = "asset_status", length = 25)
	private String assetStatus;

	@Column(name = "asset_Movement_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate assetMovementDate;
	@Column(name = "expected_delivery_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate expectedDeliveryDate;

	@Column(name = "asset_source_location", length = 25)
	private String assetSourceLocation;
	@Column(name = "asset_destination_location", length = 25)
	private String assetDestinationLocation;
	@Column(name = "shipment_id", length = 10)
	private int shipmentId;

	@OneToOne
	private Shipment shipment;
	@JsonIgnore
	@OneToOne(mappedBy = "asset", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private Maintain maintain;

	public int getAssetId() {
		return assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAssetManufacturer() {
		return assetManufacturer;
	}

	public void setAssetManufacturer(String assetManufacturer) {
		this.assetManufacturer = assetManufacturer;
	}

	public String getAssetModel() {
		return assetModel;
	}

	public void setAssetModel(String assetModel) {
		this.assetModel = assetModel;
	}

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public String getAssetStatus() {
		return assetStatus;
	}

	public void setAssetStatus(String assetStatus) {
		this.assetStatus = assetStatus;
	}

	public LocalDate getAssetMovementDate() {
		return assetMovementDate;
	}

	public void setAssetMovementDate(LocalDate assetMovementDate) {
		this.assetMovementDate = assetMovementDate;
	}

	public LocalDate getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(LocalDate expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	public String getAssetSourceLocation() {
		return assetSourceLocation;
	}

	public void setAssetSourceLocation(String assetSourceLocation) {
		this.assetSourceLocation = assetSourceLocation;
	}

	public String getAssetDestinationLocation() {
		return assetDestinationLocation;
	}

	public void setAssetDestinationLocation(String assetDestinationLocation) {
		this.assetDestinationLocation = assetDestinationLocation;
	}

	public int getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(int shipmentId) {
		this.shipmentId = shipmentId;
	}

	public Shipment getShipment() {
		return shipment;
	}

	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}

	public Maintain getMaintain() {
		return maintain;
	}

	public void setMaintain(Maintain maintain) {
		this.maintain = maintain;
	}

}
