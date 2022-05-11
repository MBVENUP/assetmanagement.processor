package com.sprint1.assetmanagementsystem.service;

import java.util.List;

import com.sprint1.assetmanagementsystem.exception.NotFoundException;
import com.sprint1.assetmanagementsystem.model.Shipment;

public interface ShipmentService {
	public Shipment createShipment(Shipment shipment) throws NotFoundException;

	public List<Shipment> viewShipment() throws NotFoundException;

	public Shipment getShipmentById(int shipmentId) throws NotFoundException;

	public String deleteShipment(int shipmentId) throws NotFoundException;
}
