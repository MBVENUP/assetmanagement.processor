package com.sprint1.assetmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.assetmanagementsystem.model.Shipment;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {
	@Modifying
	@Transactional
	@Query(value = "update shipment set shipmentCompanyName=:company,subLocation=:location,shipmentState=:state,shipmentCountry=:country where shipment_id=:id", nativeQuery = true)
	public void updateShipment(@Param("id") int id, @Param("company") String companyName,
			@Param("location") String location, @Param("state") String state, @Param("country") String country);

}
