package com.exampleAPI.APIdemo.model;

import java.sql.Date;

import javax.persistence.*;

@Entity
@NamedStoredProcedureQueries({
//@NamedStoredProcedureQuery(name = "getAllBlogs",procedureName = "getAllBlogs"),

		@NamedStoredProcedureQuery(name = "Report_Stock_IdWareHouse_FromTo", procedureName = "Report_Stock_IdWareHouse_FromTo", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "@IdWarehouse", type = Integer.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "@DateFrom", type = String.class),
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "@DateTo", type = String.class) }) })

public class Report_Stock_IdWareHouse_FromTo {

	public Report_Stock_IdWareHouse_FromTo() {
	}

	public Report_Stock_IdWareHouse_FromTo(int idItem, String codeItem, String nameItem, String nameUnit, int tkdk,
			int nktk, int xktk, int tkck) {
		super();
		this.idItem = idItem;
		this.codeItem = codeItem;
		this.nameItem = nameItem;
		this.nameUnit = nameUnit;
		this.tkdk = tkdk;
		this.nktk = nktk;
		this.xktk = xktk;
		this.tkck = tkck;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iditem")
	private int idItem;

	@Column(name = "codeitem")
	private String codeItem;

	@Column(name = "nameitem")
	private String nameItem;

	@Column(name = "nameunit")
	private String nameUnit;

	@Column(name = "tkdk")
	private int tkdk;

	@Column(name = "nktk")
	private int nktk;

	@Column(name = "xktk")
	private int xktk;

	@Column(name = "tkck")
	private int tkck;

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public String getCodeItem() {
		return codeItem;
	}

	public void setCodeItem(String codeItem) {
		this.codeItem = codeItem;
	}

	public String getNameItem() {
		return nameItem;
	}

	public void setNameItem(String nameItem) {
		this.nameItem = nameItem;
	}

	public String getNameUnit() {
		return nameUnit;
	}

	public void setNameUnit(String nameUnit) {
		this.nameUnit = nameUnit;
	}

	public int getTkdk() {
		return tkdk;
	}

	public void setTkdk(int tkdk) {
		this.tkdk = tkdk;
	}

	public int getNktk() {
		return nktk;
	}

	public void setNktk(int nktk) {
		this.nktk = nktk;
	}

	public int getXktk() {
		return xktk;
	}

	public void setXktk(int xktk) {
		this.xktk = xktk;
	}

	public int getTkck() {
		return tkck;
	}

	public void setTkck(int tkck) {
		this.tkck = tkck;
	}

}
