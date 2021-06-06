/*
 * This file is generated by jOOQ.
 */
package com.example.demo.dao.jooq.tables;


import com.example.demo.dao.jooq.Hr;
import com.example.demo.dao.jooq.Indexes;
import com.example.demo.dao.jooq.Keys;
import com.example.demo.dao.jooq.tables.records.LocationsRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;
import org.jooq.types.UInteger;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Locations extends TableImpl<LocationsRecord> {

    private static final long serialVersionUID = 1832047415;

    /**
     * The reference instance of <code>hr.locations</code>
     */
    public static final Locations LOCATIONS = new Locations();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LocationsRecord> getRecordType() {
        return LocationsRecord.class;
    }

    /**
     * The column <code>hr.locations.location_id</code>.
     */
    public final TableField<LocationsRecord, UInteger> LOCATION_ID = createField(DSL.name("location_id"), org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false).identity(true), this, "");

    /**
     * The column <code>hr.locations.street_address</code>.
     */
    public final TableField<LocationsRecord, String> STREET_ADDRESS = createField(DSL.name("street_address"), org.jooq.impl.SQLDataType.VARCHAR(40).defaultValue(org.jooq.impl.DSL.inline("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>hr.locations.postal_code</code>.
     */
    public final TableField<LocationsRecord, String> POSTAL_CODE = createField(DSL.name("postal_code"), org.jooq.impl.SQLDataType.VARCHAR(12).defaultValue(org.jooq.impl.DSL.inline("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>hr.locations.city</code>.
     */
    public final TableField<LocationsRecord, String> CITY = createField(DSL.name("city"), org.jooq.impl.SQLDataType.VARCHAR(30).nullable(false), this, "");

    /**
     * The column <code>hr.locations.state_province</code>.
     */
    public final TableField<LocationsRecord, String> STATE_PROVINCE = createField(DSL.name("state_province"), org.jooq.impl.SQLDataType.VARCHAR(25).defaultValue(org.jooq.impl.DSL.inline("NULL", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>hr.locations.country_id</code>.
     */
    public final TableField<LocationsRecord, String> COUNTRY_ID = createField(DSL.name("country_id"), org.jooq.impl.SQLDataType.CHAR(2).nullable(false), this, "");

    /**
     * Create a <code>hr.locations</code> table reference
     */
    public Locations() {
        this(DSL.name("locations"), null);
    }

    /**
     * Create an aliased <code>hr.locations</code> table reference
     */
    public Locations(String alias) {
        this(DSL.name(alias), LOCATIONS);
    }

    /**
     * Create an aliased <code>hr.locations</code> table reference
     */
    public Locations(Name alias) {
        this(alias, LOCATIONS);
    }

    private Locations(Name alias, Table<LocationsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Locations(Name alias, Table<LocationsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> Locations(Table<O> child, ForeignKey<O, LocationsRecord> key) {
        super(child, key, LOCATIONS);
    }

    @Override
    public Schema getSchema() {
        return Hr.HR;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.LOCATIONS_COUNTRY_ID);
    }

    @Override
    public Identity<LocationsRecord, UInteger> getIdentity() {
        return Keys.IDENTITY_LOCATIONS;
    }

    @Override
    public UniqueKey<LocationsRecord> getPrimaryKey() {
        return Keys.KEY_LOCATIONS_PRIMARY;
    }

    @Override
    public List<UniqueKey<LocationsRecord>> getKeys() {
        return Arrays.<UniqueKey<LocationsRecord>>asList(Keys.KEY_LOCATIONS_PRIMARY);
    }

    @Override
    public List<ForeignKey<LocationsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<LocationsRecord, ?>>asList(Keys.LOCATIONS_IBFK_1);
    }

    public Countries countries() {
        return new Countries(this, Keys.LOCATIONS_IBFK_1);
    }

    @Override
    public Locations as(String alias) {
        return new Locations(DSL.name(alias), this);
    }

    @Override
    public Locations as(Name alias) {
        return new Locations(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Locations rename(String name) {
        return new Locations(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Locations rename(Name name) {
        return new Locations(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<UInteger, String, String, String, String, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}