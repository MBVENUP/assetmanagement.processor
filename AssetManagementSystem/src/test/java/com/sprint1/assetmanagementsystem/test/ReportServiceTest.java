package com.sprint1.assetmanagementsystem.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sprint1.assetmanagementsystem.exception.NotFoundException;
import com.sprint1.assetmanagementsystem.model.Maintain;
import com.sprint1.assetmanagementsystem.repository.MaintainRepository;
import com.sprint1.assetmanagementsystem.service.ReportImplementation;
import com.sprint1.assetmanagementsystem.service.ReportService;

@SpringBootTest
class ReportServiceTest {
	@Autowired
	ReportService reportService;
	@Autowired
	ReportImplementation reportImpl;
	@MockBean
	MaintainRepository maintainRepo;
	private Maintain a1;

	@BeforeEach
	public void setUp() throws Exception {
		a1 = new Maintain();
		a1.setMaintenanceId(1);
		a1.setUserName("Shada");
		a1.setAssetType("Laptop");
		a1.setAssetManufacturer("Lenovo");
		a1.setAssetModel("Thinkpad");
		a1.setAssetSourceLocation("Bengaluru");
		a1.setAssetDestinationLocation("Mysuru");
		a1.setAssetStatus("delivered");
		a1.setAssetMovementDate(LocalDate.of(2022, 04, 01));
		a1.setShipmentCompanyName("tata");
		a1.setShipmentSubLocation("7th cross, Pani");
		a1.setShipmentCompanyState("Karnataka");
		a1.setShipmentCompanyCountry("India");
	}

	@Test
	void testviewMaintain() throws NotFoundException {
		List<Maintain> maintainList = new ArrayList<>();
		Maintain a2 = new Maintain();
		a2.setMaintenanceId(1);
		a2.setUserName("Shada");
		a2.setAssetType("Laptop");
		a2.setAssetManufacturer("Lenovo");
		a2.setAssetModel("Thinkpad");
		a2.setAssetSourceLocation("Bengaluru");
		a2.setAssetDestinationLocation("Mysuru");
		a2.setAssetStatus("delivered");
		a2.setAssetMovementDate(LocalDate.of(2022, 04, 01));
		a2.setShipmentCompanyName("tata");
		a2.setShipmentSubLocation("7th cross, Pani");
		a2.setShipmentCompanyState("Karnataka");
		a2.setShipmentCompanyCountry("India");
		maintainList.add(a1);
		maintainList.add(a2);
		Mockito.when(maintainRepo.findAll()).thenReturn(maintainList);
		assertThat(reportService.viewMaintain()).isEqualTo(maintainList);
	}
}
