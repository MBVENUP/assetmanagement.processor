package com.sprint1.assetmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.assetmanagementsystem.exception.NotFoundException;
import com.sprint1.assetmanagementsystem.model.Asset;
import com.sprint1.assetmanagementsystem.model.Maintain;
import com.sprint1.assetmanagementsystem.model.Shipment;
import com.sprint1.assetmanagementsystem.repository.AssetManagementRepository;
import com.sprint1.assetmanagementsystem.repository.MaintainRepository;
import com.sprint1.assetmanagementsystem.repository.ShipmentRepository;

@Service
public class AssetImplementation implements AssetService {
	@Autowired
	AssetManagementRepository assetRepository;
	@Autowired
	UserImplementation userImplimenation;
	@Autowired
	MaintainRepository maintainRepository;
	@Autowired
	ShipmentRepository shipmentRepository;
	@Autowired
	ReportImplementation reportimplementation;

	@Override
	// Creating Asset
	public Asset createAsset(Asset asset) throws NotFoundException {
		int shipmentId = asset.getShipmentId();
		if (shipmentRepository.existsById(shipmentId)) {
			Shipment shipment = shipmentRepository.getById(shipmentId);
			asset.setShipment(shipment);
			Maintain maintain1 = new Maintain();
			Maintain maintain2 = maintain1.maintanenceDetails(asset);
			asset.setMaintain(maintain2);
			maintainRepository.save(maintain2);
			return assetRepository.save(asset);
			
		} else {
			throw new NotFoundException(
					"shipment with the id" + shipmentId + "is not present. Try with an alternate shipment Id");
		}

	}

	// Displaying Asset
	public List<Asset> viewAsset() throws NotFoundException {

		List<Asset> assetList = assetRepository.findAll();
		if (!assetList.isEmpty()) {
			return assetList;
		} else {
			throw new NotFoundException("There is no asset");
		}

	}

	@Override
	// Deleting Assets
	public boolean deleteAsset(int id) throws NotFoundException {

		if (assetRepository.existsById(id)) {
			assetRepository.deleteById(id);
			return true;
		} else {
			throw new NotFoundException("Element with id " + id + "is not found");
		}

	}

	// Updating Asset
	public boolean updateAsset(Asset asset)  {

		if (assetRepository.existsById(asset.getAssetId())) {

			int shipmentId = asset.getShipmentId();
			Shipment shipment = shipmentRepository.getById(shipmentId);
			asset.setShipment(shipment);
			assetRepository.save(asset);
			reportimplementation.updateMaintain(asset);
			return true;
		}
		return false;

	}

	// Finding Asset
	public Asset searchAsset(int id) throws NotFoundException {

		if (assetRepository.existsById(id)) {
			return assetRepository.findById(id).get();
			
		} else {
			throw new NotFoundException("User with  Id " + id + "is not found");
		}

	}

}
