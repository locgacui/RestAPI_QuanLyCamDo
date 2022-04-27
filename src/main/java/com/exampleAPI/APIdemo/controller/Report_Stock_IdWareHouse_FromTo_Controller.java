package com.exampleAPI.APIdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exampleAPI.APIdemo.repository.Report_Stock_IdWareHouse_FromTo_Repository;
import com.exampleAPI.APIdemo.service.Report_Stock_IdWareHouse_FromTo_Service;
import com.exampleAPI.APIdemo.model.Report_Stock_IdWareHouse_FromTo;

@RestController
@RequestMapping("/api/sp/v1")
public class Report_Stock_IdWareHouse_FromTo_Controller {
	
	@Autowired
	Report_Stock_IdWareHouse_FromTo_Service report_Stock_IdWareHouse_FromTo_Service;
	
	@Autowired
	Report_Stock_IdWareHouse_FromTo_Repository report_Stock_IdWareHouse_FromTo_Repository;
	
	@GetMapping("/Report_Stock_IdWareHouse_FromTo")
	public List<Report_Stock_IdWareHouse_FromTo> Report_Stock_IdWareHouse_FromTo(@RequestParam(value =  "IdWarehouse", defaultValue = "0") int idWarehouse
												, @RequestParam(value =  "DateFrom", defaultValue = "2020-04-17") String dateFrom
												, @RequestParam(value =  "DateTo", defaultValue = "2022-04-17") String dateTo)
	{ 
		return report_Stock_IdWareHouse_FromTo_Repository.Report_Stock_IdWareHouse_FromTo(idWarehouse, dateFrom, dateTo);
		//return report_Stock_IdWareHouse_FromTo_Service.Report_Stock_IdWareHouse_FromTo(idWarehouse, dateFrom, dateTo);
	}
}
