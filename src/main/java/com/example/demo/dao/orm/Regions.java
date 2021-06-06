package com.example.demo.dao.orm;

import javax.persistence.*;

@Entity
@Table(name = "regions")
public class Regions {
    private Integer regionId;
    private String regionName;

    @Id
    @Column(name = "region_id", nullable = false)
    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    @Basic
    @Column(name = "region_name", nullable = true, length = 25)
    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Regions regions = (Regions) o;

        if (regionId != null ? !regionId.equals(regions.regionId) : regions.regionId != null) return false;
        if (regionName != null ? !regionName.equals(regions.regionName) : regions.regionName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = regionId != null ? regionId.hashCode() : 0;
        result = 31 * result + (regionName != null ? regionName.hashCode() : 0);
        return result;
    }
}
