package com.openlgu.resident.entity;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("resident")
public class Resident {
    @Id
    private UUID id;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthDate;
    private String address;

    private String region;
    private String city;
    private String barangay;
    private String province_huc;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getCity(){
        return city;
    }

    public void setBarangay(String barangay){
        this.barangay = barangay;
    }

    public String getBarangay(){
        return barangay;
    }
    
    public String getProvince_huc() {
        return province_huc;
    }

    public void setProvince_huc(String province_huc) {
        this.province_huc = province_huc;
    }

    @Override
    public String toString() {
        return "Resident [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", middleName="
                + middleName + ", birthDate=" + birthDate + ", address=" + address + ", region=" + region + ", city=" + city + ", barangay=" + barangay + ", province_huc=" + province_huc + "]";
    }

}
