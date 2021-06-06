package com.example.demo.dao.orm;

import javax.persistence.*;

@Entity
@Table(name = "locations")
public class Locations {
    private Integer locationId;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String stateProvince;
    private String countryId;

    @Id
    @Column(name = "location_id", nullable = false)
    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    @Basic
    @Column(name = "street_address", nullable = true, length = 40)
    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    @Basic
    @Column(name = "postal_code", nullable = true, length = 12)
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Basic
    @Column(name = "city", nullable = false, length = 30)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "state_province", nullable = true, length = 25)
    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    @Basic
    @Column(name = "country_id", nullable = false, length = 2)
    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Locations locations = (Locations) o;

        if (locationId != null ? !locationId.equals(locations.locationId) : locations.locationId != null) return false;
        if (streetAddress != null ? !streetAddress.equals(locations.streetAddress) : locations.streetAddress != null)
            return false;
        if (postalCode != null ? !postalCode.equals(locations.postalCode) : locations.postalCode != null) return false;
        if (city != null ? !city.equals(locations.city) : locations.city != null) return false;
        if (stateProvince != null ? !stateProvince.equals(locations.stateProvince) : locations.stateProvince != null)
            return false;
        if (countryId != null ? !countryId.equals(locations.countryId) : locations.countryId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = locationId != null ? locationId.hashCode() : 0;
        result = 31 * result + (streetAddress != null ? streetAddress.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (stateProvince != null ? stateProvince.hashCode() : 0);
        result = 31 * result + (countryId != null ? countryId.hashCode() : 0);
        return result;
    }
}
