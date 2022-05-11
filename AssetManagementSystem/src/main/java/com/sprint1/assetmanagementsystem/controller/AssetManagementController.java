package com.sprint1.assetmanagementsystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.assetmanagementsystem.model.Asset;
import com.sprint1.assetmanagementsystem.service.AssetImplementation;

@RestController
//@RequestMapping(path="/asset")
@CrossOrigin
public class AssetManagementController {
	public static final String MESSAGE = "Asset with the ID";
	// Creating logger Object
	Logger logger = org.slf4j.LoggerFactory.getLogger(AssetManagementController.class);
	@Autowired
	AssetImplementation assetImplementation;

	// Creating and saving Asset
	@PostMapping(path = "/createAsset")
	public ResponseEntity<String> createAsset(@Valid @RequestBody Asset asset) {
		Asset savedAsset = assetImplementation.createAsset(asset);
		logger.info("Asset Created");
		return new ResponseEntity<>(MESSAGE + savedAsset.getAssetId() + "is created", HttpStatus.CREATED);
	}

	// Displaying Assets
	@GetMapping(path = "/viewAsset")
	public ResponseEntity<List<Asset>> viewAsset() {
		List<Asset> listOfAsset = assetImplementation.viewAsset();
		for (Asset asset : listOfAsset) {
			logger.info("AssetId: {}, AssetManufacturer: {}, ShipmentId: {}, ShipmentCompanyName: {} ",
					asset.getAssetId(), asset.getAssetManufacturer(), asset.getShipment().getShipmentId(),
					asset.getShipment().getShipmentCompanyName());
		}
		return new ResponseEntity<>(listOfAsset, HttpStatus.OK);
	}

	// Removing Assets
	@DeleteMapping(path = "/deleteAsset/{id}")
	public ResponseEntity<String> deleteAsset(@PathVariable int id) {
		boolean assetRemoved = assetImplementation.deleteAsset(id);
		logger.info("Asset Deleted");
		ResponseEntity<String> response = new ResponseEntity<>(MESSAGE + id + "is deleted", HttpStatus.OK);
		if (assetRemoved) {
			return response;
		}
		return null;
	}

	// Updating Assets
	@PutMapping(path = "/updateAsset")
	public String updateAsset(@RequestBody Asset asset) {
		boolean assetUpdated = assetImplementation.updateAsset(asset);
		logger.info("Asset Updated");

		if (assetUpdated) {
			return MESSAGE + asset.getAssetId() + "is updated";
		}
		return "Not updated";
	}

	// Finding Assets
	@GetMapping(path = "/searchAsset/{id}")
	public Asset getAssetById(@PathVariable int id) {

		return assetImplementation.searchAsset(id);
	}

}
