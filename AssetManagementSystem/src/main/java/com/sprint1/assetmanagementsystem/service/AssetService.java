package com.sprint1.assetmanagementsystem.service;

import java.util.List;

import com.sprint1.assetmanagementsystem.exception.NotFoundException;
import com.sprint1.assetmanagementsystem.model.Asset;

public interface AssetService {

	public Asset createAsset(Asset asset) throws NotFoundException;

	public List<Asset> viewAsset() throws NotFoundException;

	public boolean deleteAsset(int assetId) throws NotFoundException;

	public boolean updateAsset(Asset asset);

	public Asset searchAsset(int id) throws NotFoundException;

}
