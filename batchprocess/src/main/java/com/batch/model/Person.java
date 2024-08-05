package com.batch.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_batch")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nationality;
    private String city;
    private double latitude;
    private double longitude;
    private String gender;
    private String ethnicGroup;
    private int age;
    private double englishGrade;
    private double mathGrade;
    private double sciencesGrade;
    private double languageGrade;
    private double portfolioRating;
    private double coverLetterRating;
    private double refLetterRating;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEthnicGroup() {
		return ethnicGroup;
	}
	public void setEthnicGroup(String ethnicGroup) {
		this.ethnicGroup = ethnicGroup;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getEnglishGrade() {
		return englishGrade;
	}
	public void setEnglishGrade(double englishGrade) {
		this.englishGrade = englishGrade;
	}
	public double getMathGrade() {
		return mathGrade;
	}
	public void setMathGrade(double mathGrade) {
		this.mathGrade = mathGrade;
	}
	public double getSciencesGrade() {
		return sciencesGrade;
	}
	public void setSciencesGrade(double sciencesGrade) {
		this.sciencesGrade = sciencesGrade;
	}
	public double getLanguageGrade() {
		return languageGrade;
	}
	public void setLanguageGrade(double languageGrade) {
		this.languageGrade = languageGrade;
	}
	public double getPortfolioRating() {
		return portfolioRating;
	}
	public void setPortfolioRating(double portfolioRating) {
		this.portfolioRating = portfolioRating;
	}
	public double getCoverLetterRating() {
		return coverLetterRating;
	}
	public void setCoverLetterRating(double coverLetterRating) {
		this.coverLetterRating = coverLetterRating;
	}
	public double getRefLetterRating() {
		return refLetterRating;
	}
	public void setRefLetterRating(double refLetterRating) {
		this.refLetterRating = refLetterRating;
	}

    // Constructors, getters, and setters
    
}

