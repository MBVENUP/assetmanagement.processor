package com.sprint1.assetmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.assetmanagementsystem.model.Asset;
import com.sprint1.assetmanagementsystem.model.Maintain;
import com.sprint1.assetmanagementsystem.repository.MaintainRepository;

@Service
public class ReportImplementation implements ReportService {

	@Autowired
	MaintainRepository maintainrepository;

	public List<Maintain> viewMaintain() {
		return maintainrepository.findAll();
	}
	public void updateMaintain(Asset asset) {
		maintainrepository.updateMaintain(asset.getAssetId(),asset.getAssetModel(),asset.getAssetType(),asset.getAssetManufacturer(),asset.getAssetMovementDate(),asset.getAssetStatus(),asset.getAssetSourceLocation(),asset.getAssetDestinationLocation(),asset.getUserName(),asset.getShipment().getShipmentCompanyName(),asset.getShipment().getSubLocation(),asset.getShipment().getShipmentState(),asset.getShipment().getShipmentCountry());
		}
}
