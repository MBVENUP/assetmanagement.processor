package com.sprint1.assetmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.assetmanagementsystem.model.Maintain;
import com.sprint1.assetmanagementsystem.service.ReportImplementation;

@RestController
@CrossOrigin
public class ReportController {
	@Autowired
	ReportImplementation reportImplementation;

	@GetMapping(path = "/viewMaintain")
	public List<Maintain> viewMaintainRecords() {
		return reportImplementation.viewMaintain();
	}
}
