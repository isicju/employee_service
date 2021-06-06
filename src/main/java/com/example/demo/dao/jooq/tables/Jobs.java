/*
 * This file is generated by jOOQ.
 */
package com.example.demo.dao.jooq.tables;


import com.example.demo.dao.jooq.Hr;
import com.example.demo.dao.jooq.Keys;
import com.example.demo.dao.jooq.tables.records.JobsRecord;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row4;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Jobs extends TableImpl<JobsRecord> {

    private static final long serialVersionUID = -1719513576;

    /**
     * The reference instance of <code>hr.jobs</code>
     */
    public static final Jobs JOBS = new Jobs();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JobsRecord> getRecordType() {
        return JobsRecord.class;
    }

    /**
     * The column <code>hr.jobs.job_id</code>.
     */
    public final TableField<JobsRecord, String> JOB_ID = createField(DSL.name("job_id"), org.jooq.impl.SQLDataType.VARCHAR(10).nullable(false), this, "");

    /**
     * The column <code>hr.jobs.job_title</code>.
     */
    public final TableField<JobsRecord, String> JOB_TITLE = createField(DSL.name("job_title"), org.jooq.impl.SQLDataType.VARCHAR(35).nullable(false), this, "");

    /**
     * The column <code>hr.jobs.min_salary</code>.
     */
    public final TableField<JobsRecord, Integer> MIN_SALARY = createField(DSL.name("min_salary"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.inline("NULL", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>hr.jobs.max_salary</code>.
     */
    public final TableField<JobsRecord, Integer> MAX_SALARY = createField(DSL.name("max_salary"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.inline("NULL", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * Create a <code>hr.jobs</code> table reference
     */
    public Jobs() {
        this(DSL.name("jobs"), null);
    }

    /**
     * Create an aliased <code>hr.jobs</code> table reference
     */
    public Jobs(String alias) {
        this(DSL.name(alias), JOBS);
    }

    /**
     * Create an aliased <code>hr.jobs</code> table reference
     */
    public Jobs(Name alias) {
        this(alias, JOBS);
    }

    private Jobs(Name alias, Table<JobsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Jobs(Name alias, Table<JobsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> Jobs(Table<O> child, ForeignKey<O, JobsRecord> key) {
        super(child, key, JOBS);
    }

    @Override
    public Schema getSchema() {
        return Hr.HR;
    }

    @Override
    public UniqueKey<JobsRecord> getPrimaryKey() {
        return Keys.KEY_JOBS_PRIMARY;
    }

    @Override
    public List<UniqueKey<JobsRecord>> getKeys() {
        return Arrays.<UniqueKey<JobsRecord>>asList(Keys.KEY_JOBS_PRIMARY);
    }

    @Override
    public Jobs as(String alias) {
        return new Jobs(DSL.name(alias), this);
    }

    @Override
    public Jobs as(Name alias) {
        return new Jobs(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Jobs rename(String name) {
        return new Jobs(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Jobs rename(Name name) {
        return new Jobs(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<String, String, Integer, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}