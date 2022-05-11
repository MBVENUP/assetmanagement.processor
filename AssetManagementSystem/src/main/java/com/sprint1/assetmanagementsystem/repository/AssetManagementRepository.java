package com.sprint1.assetmanagementsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sprint1.assetmanagementsystem.model.Asset;

@Repository
public interface AssetManagementRepository extends JpaRepository<Asset, Integer> {

	@Query(value = "select * from asset a where a.shipment_shipmentId=:id", nativeQuery = true)
	public Optional<Asset> getAssetbyShipmentId(@Param("id") int id);

}
