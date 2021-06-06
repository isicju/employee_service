/*
 * This file is generated by jOOQ.
 */
package com.example.demo.dao.jooq.tables.records;


import com.example.demo.dao.jooq.tables.Countries;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;
import org.jooq.types.UInteger;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CountriesRecord extends UpdatableRecordImpl<CountriesRecord> implements Record3<String, String, UInteger> {

    private static final long serialVersionUID = 159186316;

    /**
     * Setter for <code>hr.countries.country_id</code>.
     */
    public void setCountryId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>hr.countries.country_id</code>.
     */
    public String getCountryId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>hr.countries.country_name</code>.
     */
    public void setCountryName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>hr.countries.country_name</code>.
     */
    public String getCountryName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>hr.countries.region_id</code>.
     */
    public void setRegionId(UInteger value) {
        set(2, value);
    }

    /**
     * Getter for <code>hr.countries.region_id</code>.
     */
    public UInteger getRegionId() {
        return (UInteger) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<String, String, UInteger> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<String, String, UInteger> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Countries.COUNTRIES.COUNTRY_ID;
    }

    @Override
    public Field<String> field2() {
        return Countries.COUNTRIES.COUNTRY_NAME;
    }

    @Override
    public Field<UInteger> field3() {
        return Countries.COUNTRIES.REGION_ID;
    }

    @Override
    public String component1() {
        return getCountryId();
    }

    @Override
    public String component2() {
        return getCountryName();
    }

    @Override
    public UInteger component3() {
        return getRegionId();
    }

    @Override
    public String value1() {
        return getCountryId();
    }

    @Override
    public String value2() {
        return getCountryName();
    }

    @Override
    public UInteger value3() {
        return getRegionId();
    }

    @Override
    public CountriesRecord value1(String value) {
        setCountryId(value);
        return this;
    }

    @Override
    public CountriesRecord value2(String value) {
        setCountryName(value);
        return this;
    }

    @Override
    public CountriesRecord value3(UInteger value) {
        setRegionId(value);
        return this;
    }

    @Override
    public CountriesRecord values(String value1, String value2, UInteger value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CountriesRecord
     */
    public CountriesRecord() {
        super(Countries.COUNTRIES);
    }

    /**
     * Create a detached, initialised CountriesRecord
     */
    public CountriesRecord(String countryId, String countryName, UInteger regionId) {
        super(Countries.COUNTRIES);

        set(0, countryId);
        set(1, countryName);
        set(2, regionId);
    }
}