package com.exampleAPI.APIdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity

@NamedStoredProcedureQueries({

		@NamedStoredProcedureQuery(name = "List_Account", procedureName = "List_Account") })

@Table(name = "account")
public class Account {

	public Account() {
	}

	public Account(Long id, String userName, String password, String idEmployee) {
		this.id = id;
		this.userName = userName.trim();
		this.password = password.trim();
		this.IdEmployee = idEmployee.trim();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "username", nullable = false)
	private String userName;

	public String getUserName() {
		return userName.trim();
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "password")
	private String password;

	public String getPassword() {
		return password.trim();
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "Idemployee")
	private String IdEmployee;

	public String getIdEmployee() {
		return IdEmployee.trim();
	}

	public void setIdEmployee(String idEmployee) {
		this.IdEmployee = idEmployee;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", userName=" + userName + ", password=" + password + "]";
	}
}
