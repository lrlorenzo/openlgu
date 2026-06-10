package com.openlgu.psgc.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("psgc")
public class Psgc {
	@Id
	private String id;
	private String name;
	private String correspondenceCode;
	private String geographicLevel;
	private String cityClass;
	private String incomeClassification;
	private String urbanRural;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCorrespondenceCode() {
		return correspondenceCode;
	}

	public void setCorrespondenceCode(String correspondenceCode) {
		this.correspondenceCode = correspondenceCode;
	}

	public String getGeographicLevel() {
		return geographicLevel;
	}

	public void setGeographicLevel(String geographicLevel) {
		this.geographicLevel = geographicLevel;
	}

	public String getCityClass() {
		return cityClass;
	}

	public void setCityClass(String cityClass) {
		this.cityClass = cityClass;
	}

	public String getIncomeClassification() {
		return incomeClassification;
	}

	public void setIncomeClassification(String incomeClassification) {
		this.incomeClassification = incomeClassification;
	}

	public String getUrbanRural() {
		return urbanRural;
	}

	public void setUrbanRural(String urbanRural) {
		this.urbanRural = urbanRural;
	}

}
