package com.emr.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name= "icd10codes")
public class IcdModel {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id")
	private int id;

    @Column(name = "version_state")
    private String versionState;

    @Column(name = "ref_id")
    private  Integer refId;

    @Column(name = "original_ref_id")
    private  Integer originalRefId;

    @Column(name = "modified_by")
    private  String modifiedBy;
    
    @Column(name = "created_by")
    private  String createdBy;
    
    @UpdateTimestamp
    @Column(name = "modified_date")
    private  Date modifiedDate;
    
    @CreationTimestamp
    @Column(name = "created_date")
    private  Date createdDate;
    
	@Column(name = "icd_order")
	private String icdOrder;
	
	@Column(name = "icd_code")
	private String icdCode;
	
	@Column(name = "icd_id")
	private int icdId;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "short_desc")
	private String shortDesc;
	
	@Column(name = "med_desc")
	private String medDesc;
	
	@Column(name = "long_desc")
	private String longDesc;

	@Column(name = "retired")
	private String retired;
	
	@Column(name = "retired_on")
	private String retiredOn;
	
	@Column(name = "retired_reason")
	private String retiredReason;
	
	@Column(name ="parent_id")
	private Integer parentId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVersionState() {
		return versionState;
	}

	public void setVersionState(String versionState) {
		this.versionState = versionState;
	}

	public Integer getRefId() {
		return refId;
	}

	public void setRefId(Integer refId) {
		this.refId = refId;
	}

	public Integer getOriginalRefId() {
		return originalRefId;
	}

	public void setOriginalRefId(Integer originalRefId) {
		this.originalRefId = originalRefId;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getIcdOrder() {
		return icdOrder;
	}

	public void setIcdOrder(String icdOrder) {
		this.icdOrder = icdOrder;
	}

	public String getIcdCode() {
		return icdCode;
	}

	public void setIcdCode(String icdCode) {
		this.icdCode = icdCode;
	}

	public int getIcdId() {
		return icdId;
	}

	public void setIcdId(int icdId) {
		this.icdId = icdId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getMedDesc() {
		return medDesc;
	}

	public void setMedDesc(String medDesc) {
		this.medDesc = medDesc;
	}

	public String getLongDesc() {
		return longDesc;
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}

	public String getRetired() {
		return retired;
	}

	public void setRetired(String retired) {
		this.retired = retired;
	}

	public String getRetiredOn() {
		return retiredOn;
	}

	public void setRetiredOn(String retiredOn) {
		this.retiredOn = retiredOn;
	}

	public String getRetiredReason() {
		return retiredReason;
	}

	public void setRetiredReason(String retiredReason) {
		this.retiredReason = retiredReason;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	
}
