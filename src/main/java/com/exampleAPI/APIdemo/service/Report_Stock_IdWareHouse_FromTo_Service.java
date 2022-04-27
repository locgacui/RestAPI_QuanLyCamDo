package com.exampleAPI.APIdemo.service;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampleAPI.APIdemo.model.Report_Stock_IdWareHouse_FromTo;
import com.exampleAPI.APIdemo.repository.Report_Stock_IdWareHouse_FromTo_Repository;

@Service
public class Report_Stock_IdWareHouse_FromTo_Service {

	@Autowired
	private Report_Stock_IdWareHouse_FromTo_Repository report_Stock_IdWareHouse_FromTo_Repository;
	
	@Autowired
	@PersistenceContext
	private EntityManager em;
	
//	public List Report_Stock_IdWareHouse_FromTo(int idWarehouse, String dateFrom, String dateTo)
//	{
//		return em.createNamedStoredProcedureQuery("Report_Stock_IdWareHouse_FromTo").setParameter("@IdWarehouse", idWarehouse)
//																					.setParameter("@DateFrom", dateFrom)
//																					.setParameter("@DateTo", dateTo)
//																					.getResultList();
//	}
}
