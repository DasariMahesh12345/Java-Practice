package com.emr.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="allergy_new")
public class AllergyModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="id")
	private int id;
	
	@Column(name="dam_concept_id")
	private String damConceptId;
	
	@Column(name="dam_concept_id_desc")
	private String damConceptIdDesc;
	
	@Column(name="dam_concept_id_type")
	private int damConceptIdType;
	
	@Column(name="dam_alrgn_grp_desc")
	private String damAlrgnGrpDesc;
	
	@Column(name="allergy_desc")
	private String allergyDesc;

	@Column(name="snomed_code")
	private String snomedCode;
	
	@Column(name="snomed_concept")
	private String snomedConcept;
	
	@Column(name="data_source")
	private String dataSource;
	
	@Column(name="version_state")
	private String versionState;
	
	@Column(name="status")
	private String status;
	
	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="modified_by")
	private String modifiedBy;
	
	@Column(name="modified_date")
	private Date modifiedDate;
	
	@Column(name="org_ref_id")
	private Integer orgRefId;
	
	@Column(name="ref_id")
	private Integer refId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDamConceptId() {
		return damConceptId;
	}

	public void setDamConceptId(String damConceptId) {
		this.damConceptId = damConceptId;
	}

	public String getDamConceptIdDesc() {
		return damConceptIdDesc;
	}

	public void setDamConceptIdDesc(String damConceptIdDesc) {
		this.damConceptIdDesc = damConceptIdDesc;
	}

	public int getDamConceptIdType() {
		return damConceptIdType;
	}

	public void setDamConceptIdType(int damConceptIdType) {
		this.damConceptIdType = damConceptIdType;
	}

	public String getDamAlrgnGrpDesc() {
		return damAlrgnGrpDesc;
	}

	public void setDamAlrgnGrpDesc(String damAlrgnGrpDesc) {
		this.damAlrgnGrpDesc = damAlrgnGrpDesc;
	}

	public String getAllergyDesc() {
		return allergyDesc;
	}

	public void setAllergyDesc(String allergyDesc) {
		this.allergyDesc = allergyDesc;
	}

	public String getSnomedCode() {
		return snomedCode;
	}

	public void setSnomedCode(String snomedCode) {
		this.snomedCode = snomedCode;
	}

	public String getSnomedConcept() {
		return snomedConcept;
	}

	public void setSnomedConcept(String snomedConcept) {
		this.snomedConcept = snomedConcept;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getVersionState() {
		return versionState;
	}

	public void setVersionState(String versionState) {
		this.versionState = versionState;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Integer getOrgRefId() {
		return orgRefId;
	}

	public void setOrgRefId(Integer orgRefId) {
		this.orgRefId = orgRefId;
	}

	public Integer getRefId() {
		return refId;
	}

	public void setRefId(Integer refId) {
		this.refId = refId;
	}

	
	
}
