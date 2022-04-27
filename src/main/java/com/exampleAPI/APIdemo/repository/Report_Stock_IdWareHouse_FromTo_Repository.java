package com.exampleAPI.APIdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.exampleAPI.APIdemo.model.Report_Stock_IdWareHouse_FromTo;

@Repository
public interface Report_Stock_IdWareHouse_FromTo_Repository extends JpaRepository<Report_Stock_IdWareHouse_FromTo, Integer> {

	@Query(value = "EXEC dbo.Report_Stock_IdWareHouse_FromTo @IdWarehouse = :idWarehouse,"
			+ "@DateFrom = :dateFrom,"
			+ "@DateTo = :dateTo"
			,nativeQuery = true)
	List<Report_Stock_IdWareHouse_FromTo> Report_Stock_IdWareHouse_FromTo(@Param("idWarehouse") int idWarehouse, @Param("dateFrom") String dateFrom, @Param("dateTo") String dateTo);
}
