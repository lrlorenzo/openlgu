package com.openlgu.resident.dto;

import java.time.LocalDate;
import java.util.UUID;

public class ResidentResponse {

    private UUID id;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthDate;
    private String address;
    private String region;
    private String province_huc;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    public String getRegion() {
        return region;
    }

    public void setProvince_huc(String province_huc) {
        this.province_huc = province_huc;
    }
    public String getProvince_huc() {
        return province_huc;
    }
    @Override
    public String toString() {
        return "ResidentResponse [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", middleName="
                + middleName + ", birthDate=" + birthDate + ", address=" + address + ", region=" + region + ", province_huc=" + province_huc + "]";
    }   
    

}
