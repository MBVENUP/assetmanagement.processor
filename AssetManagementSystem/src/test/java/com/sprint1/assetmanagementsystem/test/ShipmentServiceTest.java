package com.sprint1.assetmanagementsystem.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sprint1.assetmanagementsystem.exception.LoginException;
import com.sprint1.assetmanagementsystem.exception.NoAccessException;
import com.sprint1.assetmanagementsystem.exception.NotFoundException;
import com.sprint1.assetmanagementsystem.model.Shipment;
import com.sprint1.assetmanagementsystem.repository.ShipmentRepository;
import com.sprint1.assetmanagementsystem.service.ShipmentImplementation;
import com.sprint1.assetmanagementsystem.service.ShipmentService;

@SpringBootTest
class ShipmentServiceTest {

	@Autowired
	ShipmentService shipmentService;

	@Autowired
	ShipmentImplementation shipmentImpl;

	@MockBean
	ShipmentRepository shipmentRepo;

	Shipment s1;

	@BeforeEach
	void init() {
		s1 = new Shipment();

		s1.setShipmentId(10);
		s1.setShipmentCompanyName("Amazon");
		s1.setShipmentState("Karnataka");
		s1.setShipmentCountry("India");
		s1.setSubLocation("Bangalore");

	}

	@Test
	void testcreateShipment() throws NotFoundException {
		Mockito.when(shipmentRepo.save(s1)).thenReturn(s1);
		assertThat(shipmentService.createShipment(s1)).isEqualTo(s1);
	}

	@Test
	void testViewShipment() throws NotFoundException, LoginException {
		List<Shipment> shipmentList = new ArrayList<>();
		Shipment s2 = new Shipment();

		s2.setShipmentId(11);
		s2.setShipmentCompanyName("Zepton");
		s2.setShipmentState("Karnataka");
		s2.setShipmentCountry("India");
		s2.setSubLocation("Bangalore");
		shipmentList.add(s1);
		shipmentList.add(s2);

		Mockito.when(shipmentRepo.findAll()).thenReturn(shipmentList);
		assertThat(shipmentService.viewShipment()).isEqualTo(shipmentList);
	}

	@Test
	void testGetShipmentById() throws NotFoundException, LoginException {
		Optional<Shipment> s2 = Optional.of(s1);
		Mockito.when(shipmentRepo.findById(s1.getShipmentId())).thenReturn(s2);
		Mockito.when(shipmentRepo.existsById(s1.getShipmentId())).thenReturn(true);
		assertThat(shipmentService.getShipmentById(s1.getShipmentId())).isEqualTo(s1);
	}

	@Test
	void testUpdateShipment() throws NotFoundException {
		Mockito.when(shipmentRepo.existsById(s1.getShipmentId())).thenReturn(true);
		Mockito.when(shipmentRepo.save(s1)).thenReturn(s1);
		assertThat(shipmentImpl.updateShipment(s1)).isEqualTo("updated successfully");
	}

	@Test
	void testDeleteShipment() throws NotFoundException, NoAccessException, LoginException {
		Mockito.when(shipmentRepo.existsById(Mockito.anyInt())).thenReturn(true);
		assertThat(shipmentService.deleteShipment(Mockito.anyInt())).isEqualTo("shipment with 0 is deleted");
	}
}
