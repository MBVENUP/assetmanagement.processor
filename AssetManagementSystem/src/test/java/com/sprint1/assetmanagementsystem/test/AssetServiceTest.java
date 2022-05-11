package com.sprint1.assetmanagementsystem.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
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
import com.sprint1.assetmanagementsystem.model.Asset;
import com.sprint1.assetmanagementsystem.model.Maintain;
import com.sprint1.assetmanagementsystem.model.Shipment;
import com.sprint1.assetmanagementsystem.repository.AssetManagementRepository;
import com.sprint1.assetmanagementsystem.repository.MaintainRepository;
import com.sprint1.assetmanagementsystem.repository.ShipmentRepository;
import com.sprint1.assetmanagementsystem.service.AssetService;
import com.sprint1.assetmanagementsystem.service.ReportImplementation;

@SpringBootTest
class AssetServiceTest {

	@Autowired
	AssetService assetService;

	@Autowired
	ReportImplementation reportimplementation;

	@MockBean
	AssetManagementRepository assetRepo;

	Asset a;

	@MockBean
	ShipmentRepository shipmentRepo;

	@MockBean
	MaintainRepository maintainRepository;

	@BeforeEach
	public void setUp() throws Exception {
		a = getAsset();
	}

	private Asset getAsset() {
		Asset a1 = new Asset();

		a1.setAssetId(150);
		a1.setUserName("Venu");
		a1.setAssetManufacturer("Lenovo");
		a1.setAssetModel("Thinkpad");
		a1.setAssetType("Laptop");
		a1.setAssetStatus("delivered");
		a1.setAssetMovementDate(LocalDate.of(2022, 04, 01));
		a1.setExpectedDeliveryDate(LocalDate.of(2022, 04, 05));
		a1.setAssetSourceLocation("Bengaluru");
		a1.setAssetDestinationLocation("Mysuru");
		a1.setShipmentId(148);

		Shipment s1 = new Shipment();

		s1.setShipmentCompanyName("Amazon");
		s1.setShipmentState("Karnataka");
		s1.setShipmentCountry("India");
		s1.setSubLocation("Bengaluru");
		s1.setShipmentId(148);
		a1.setShipment(s1);

		return a1;
	}

	@Test
	void testCreateAsset() throws NotFoundException, NoAccessException, LoginException {

		Shipment s1 = new Shipment();

		s1.setShipmentCompanyName("Amazon");
		s1.setShipmentState("Karnataka");
		s1.setShipmentCountry("India");
		s1.setSubLocation("Bengaluru");
		s1.setShipmentId(148);

		Maintain maintain1 = new Maintain();
		Maintain maintain2 = maintain1.maintanenceDetails(a);

		Mockito.when(shipmentRepo.existsById(148)).thenReturn(true);
		Mockito.when(shipmentRepo.getById(148)).thenReturn(s1);
		Mockito.when(maintainRepository.save(maintain2)).thenReturn(maintain2);
		Mockito.when(assetRepo.save(a)).thenReturn(a);
		assertThat(assetService.createAsset(a)).isEqualTo(a);
	}

	@Test
	void testViewAsset() throws NotFoundException {
		List<Asset> assetList = new ArrayList<>();
		Asset a2 = new Asset();
		a2.setAssetId(101);
		a2.setUserName("Venu");
		a2.setAssetManufacturer("Lenovo");
		a2.setAssetModel("Thinkpad");
		a2.setAssetType("Laptop");
		a2.setAssetStatus("delivered");
		a2.setAssetMovementDate(LocalDate.of(2022, 04, 01));
		a2.setExpectedDeliveryDate(LocalDate.of(2022, 04, 05));
		a2.setAssetSourceLocation("Bengaluru");
		a2.setAssetDestinationLocation("Mysuru");
		assetList.add(a);
		assetList.add(a2);

		Mockito.when(assetRepo.findAll()).thenReturn(assetList);
		assertThat(assetService.viewAsset()).isEqualTo(assetList);
	}

	@Test
	void testSearchAsset() throws NotFoundException {

		Optional<Asset> a2 = Optional.of(a);
		Mockito.when(assetRepo.findById(a.getAssetId())).thenReturn(a2);
		Mockito.when(assetRepo.existsById(150)).thenReturn(true);
		assertThat(assetService.searchAsset(150)).isEqualTo(a);
	}

	@Test
	void testDeleteAsset() throws NotFoundException, NoAccessException, LoginException {
		Mockito.when(assetRepo.existsById(Mockito.anyInt())).thenReturn(true);
		assertThat(assetService.deleteAsset(Mockito.anyInt())).isTrue();
	}

	@Test
	void testUpdateAsset() {

		Shipment s1 = new Shipment();

		s1.setShipmentCompanyName("Amazon");
		s1.setShipmentState("Karnataka");
		s1.setShipmentCountry("India");
		s1.setSubLocation("Bengaluru");
		s1.setShipmentId(148);

		Mockito.when(assetRepo.existsById(150)).thenReturn(true);
		Mockito.when(shipmentRepo.getById(148)).thenReturn(s1);
		Mockito.when(assetRepo.save(a)).thenReturn(a);
		assertEquals(true, assetService.updateAsset(a));
	}
}