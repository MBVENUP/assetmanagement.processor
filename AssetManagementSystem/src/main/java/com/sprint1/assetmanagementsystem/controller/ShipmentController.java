package com.sprint1.assetmanagementsystem.controller;

import java.util.List;

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

import com.sprint1.assetmanagementsystem.exception.NotFoundException;
import com.sprint1.assetmanagementsystem.model.Shipment;
import com.sprint1.assetmanagementsystem.service.ShipmentImplementation;

@RestController
@CrossOrigin
public class ShipmentController {
	// Creating Logger Object
	Logger logger = org.slf4j.LoggerFactory.getLogger(ShipmentController.class);
	@Autowired
	ShipmentImplementation shipmentImplementation;

	// Creating and Saving Shipments
	@PostMapping(path = "/createShipment")
	public ResponseEntity<String> createShipment(@RequestBody Shipment shipment) throws NotFoundException {
		Shipment shipmentObj = shipmentImplementation.createShipment(shipment);
		logger.info("Shipment Created");
		return new ResponseEntity<>(
				shipmentObj.getShipmentCompanyName() + " is registered with the Id " + shipmentObj.getShipmentId(),
				HttpStatus.CREATED);

	}

	// Updating Shipments
	@PutMapping(path = "/UpdateShipment")
	public String updateShipment(@RequestBody Shipment shipment) throws NotFoundException {
		shipmentImplementation.updateShipment(shipment);
		return "Updated Successfully";
	}

	// Displaying Shipments
	@GetMapping(path = "/viewShipment")
	public List<Shipment> viewShipment() throws NotFoundException {
		List<Shipment> listOfShipment = shipmentImplementation.viewShipment();
		for (Shipment shipment : listOfShipment) {
			logger.info(
					"ShipmentId: {}, ShipmentCompanyName: {}, ShipmentState: {}, ShipmentCountry: {}, SSubLocation: {}",
					shipment.getShipmentId(), shipment.getShipmentCompanyName(), shipment.getShipmentState(),
					shipment.getShipmentCountry(), shipment.getSubLocation());
		}
		return listOfShipment;
	}

	// Finding Shipments
	@GetMapping(path = "/searchShipment/{id}")
	public Shipment getShipmentById(@PathVariable int id) throws NotFoundException {

		return shipmentImplementation.getShipmentById(id);
	}

	@DeleteMapping(path = "/deleteShipment/{id}")
	public String deleteShipmentbyId(@PathVariable int id) throws NotFoundException {
		return shipmentImplementation.deleteShipment(id);
	}
}
