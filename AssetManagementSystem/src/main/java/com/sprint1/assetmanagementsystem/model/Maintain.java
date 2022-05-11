package com.sprint1.assetmanagementsystem.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity

public class Maintain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "maintenance_id", length = 10)
	private int maintenanceId;

	@OneToOne(cascade = { CascadeType.ALL })
	private Asset asset;
	@Column(name = "user_name", length = 25)
	private String userName;
	@Column(name = "asset_type", length = 25)
	private String assetType;
	@Column(name = "asset_manufacturer", length = 25)
	private String assetManufacturer;
	@Column(name = "asset_model", length = 25)
	private String assetModel;
	@Column(name = "asset_source_location", length = 25)
	private String assetSourceLocation;
	@Column(name = "asset_destination_location", length = 25)
	private String assetDestinationLocation;
	@Column(name = "asset_status", length = 25)
	private String assetStatus;
	@Column(name = "asset_Movement_date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate assetMovementDate;
	@Column(name = "shipment_company_name", length = 25)
	private String shipmentCompanyName;
	@Column(name = "shipment_sub_location", length = 25)
	private String shipmentSubLocation;
	@Column(name = "shipment_company_state", length = 25)
	private String shipmentCompanyState;
	@Column(name = "shipment_company_country", length = 25)
	private String shipmentCompanyCountry;

	// Default Constructor
	public Maintain() {

	}

	// Fetching asset object values
	public Maintain maintanenceDetails(Asset asset) {
		this.userName = asset.getUserName();
		this.assetType = asset.getAssetType();
		this.assetManufacturer = asset.getAssetManufacturer();
		this.assetModel = asset.getAssetModel();
		this.assetSourceLocation = asset.getAssetSourceLocation();
		this.assetDestinationLocation = asset.getAssetDestinationLocation();
		this.assetStatus = asset.getAssetStatus();
		this.assetMovementDate = asset.getAssetMovementDate();
		this.shipmentCompanyCountry = asset.getShipment().getShipmentCompanyName();
		this.shipmentSubLocation = asset.getShipment().getSubLocation();
		this.shipmentCompanyState = asset.getShipment().getShipmentState();
		this.shipmentCompanyCountry = asset.getShipment().getShipmentCountry();
		this.asset = asset;
		// Creating Maintain object
		return new Maintain(userName, assetType, assetManufacturer, assetModel, assetSourceLocation,
				assetDestinationLocation, assetStatus, assetMovementDate, shipmentCompanyCountry, shipmentSubLocation,
				shipmentCompanyState, shipmentCompanyCountry, asset);
	}

	// Parameterized Constructor

	public Maintain(String userName, String assetType, String assetManufacturer, String assetModel,
			String assetSourceLocation, String assetDestinationLocation, String assetStatus,
			LocalDate assetMovementDate, String shipmentCompanyName, String shipmentSubLocation,
			String shipmentCompanyState, String shipmentCompanyCountry, Asset asset) {
		super();
		this.userName = userName;
		this.assetType = assetType;
		this.assetManufacturer = assetManufacturer;
		this.assetModel = assetModel;
		this.assetSourceLocation = assetSourceLocation;
		this.assetDestinationLocation = assetDestinationLocation;
		this.assetStatus = assetStatus;
		this.assetMovementDate = assetMovementDate;
		this.shipmentCompanyName = shipmentCompanyName;
		this.shipmentSubLocation = shipmentSubLocation;
		this.shipmentCompanyState = shipmentCompanyState;
		this.shipmentCompanyCountry = shipmentCompanyCountry;
		this.asset = asset;
	}

	public int getMaintenanceId() {
		return maintenanceId;
	}

	public void setMaintenanceId(int maintenanceId) {
		this.maintenanceId = maintenanceId;
	}

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
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

	public String getShipmentCompanyName() {
		return shipmentCompanyName;
	}

	public void setShipmentCompanyName(String shipmentCompanyName) {
		this.shipmentCompanyName = shipmentCompanyName;
	}

	public String getShipmentSubLocation() {
		return shipmentSubLocation;
	}

	public void setShipmentSubLocation(String shipmentSubLocation) {
		this.shipmentSubLocation = shipmentSubLocation;
	}

	public String getShipmentCompanyState() {
		return shipmentCompanyState;
	}

	public void setShipmentCompanyState(String shipmentCompanyState) {
		this.shipmentCompanyState = shipmentCompanyState;
	}

	public String getShipmentCompanyCountry() {
		return shipmentCompanyCountry;
	}

	public void setShipmentCompanyCountry(String shipmentCompanyCountry) {
		this.shipmentCompanyCountry = shipmentCompanyCountry;
	}

}
