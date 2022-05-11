package com.sprint1.assetmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.assetmanagementsystem.exception.NotFoundException;
import com.sprint1.assetmanagementsystem.model.Shipment;
import com.sprint1.assetmanagementsystem.repository.AssetManagementRepository;
import com.sprint1.assetmanagementsystem.repository.ShipmentRepository;

@Service
public class ShipmentImplementation implements ShipmentService {
	public static final String MESSAGE = "Element with given Id is not available";
	@Autowired
	ShipmentRepository shipmentrepository;
	@Autowired
	UserImplementation userImplemenation1;
	@Autowired
	AssetManagementRepository assetrepository;

	@Override
	public Shipment createShipment(Shipment shipment) throws NotFoundException {

		
		if (shipment != null) {
			return shipmentrepository.save(shipment);
		} else {
			throw new NotFoundException("Enter proper values");
		}

	}

	public List<Shipment> viewShipment() throws NotFoundException {

		List<Shipment> shipmentList = shipmentrepository.findAll();
		if (!shipmentList.isEmpty()) {
			return shipmentList;
		} else {
			throw new NotFoundException("There is no asset");
		}

	}

	public Shipment getShipmentById(int id) throws NotFoundException {

		if (shipmentrepository.existsById(id)) {

			return shipmentrepository.findById(id).get();
			
		} else {
			throw new NotFoundException(MESSAGE);
		}

	}

	public String updateShipment(Shipment shipment) throws NotFoundException {
		if (shipment != null) {
			shipmentrepository.updateShipment(shipment.getShipmentId(), shipment.getShipmentCompanyName(),
					shipment.getSubLocation(), shipment.getShipmentState(), shipment.getShipmentCountry());
			return "updated successfully";
		} else {
			throw new NotFoundException(MESSAGE);
		}
	}

	@Override
	public String deleteShipment(int shipmentId) throws NotFoundException {

		if (shipmentrepository.existsById(shipmentId)) {
			shipmentrepository.deleteById(shipmentId);
			return "shipment with " + shipmentId + " is deleted";
		} else {
			throw new NotFoundException(MESSAGE);
		}

	}
}