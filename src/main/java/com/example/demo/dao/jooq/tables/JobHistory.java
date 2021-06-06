/*
 * This file is generated by jOOQ.
 */
package com.example.demo.dao.jooq.tables;


import com.example.demo.dao.jooq.Hr;
import com.example.demo.dao.jooq.Indexes;
import com.example.demo.dao.jooq.Keys;
import com.example.demo.dao.jooq.tables.records.JobHistoryRecord;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row5;
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
public class JobHistory extends TableImpl<JobHistoryRecord> {

    private static final long serialVersionUID = -595903632;

    /**
     * The reference instance of <code>hr.job_history</code>
     */
    public static final JobHistory JOB_HISTORY = new JobHistory();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JobHistoryRecord> getRecordType() {
        return JobHistoryRecord.class;
    }

    /**
     * The column <code>hr.job_history.employee_id</code>.
     */
    public final TableField<JobHistoryRecord, UInteger> EMPLOYEE_ID = createField(DSL.name("employee_id"), org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * The column <code>hr.job_history.start_date</code>.
     */
    public final TableField<JobHistoryRecord, LocalDate> START_DATE = createField(DSL.name("start_date"), org.jooq.impl.SQLDataType.LOCALDATE.nullable(false), this, "");

    /**
     * The column <code>hr.job_history.end_date</code>.
     */
    public final TableField<JobHistoryRecord, LocalDate> END_DATE = createField(DSL.name("end_date"), org.jooq.impl.SQLDataType.LOCALDATE.nullable(false), this, "");

    /**
     * The column <code>hr.job_history.job_id</code>.
     */
    public final TableField<JobHistoryRecord, String> JOB_ID = createField(DSL.name("job_id"), org.jooq.impl.SQLDataType.VARCHAR(10).nullable(false), this, "");

    /**
     * The column <code>hr.job_history.department_id</code>.
     */
    public final TableField<JobHistoryRecord, UInteger> DEPARTMENT_ID = createField(DSL.name("department_id"), org.jooq.impl.SQLDataType.INTEGERUNSIGNED.nullable(false), this, "");

    /**
     * Create a <code>hr.job_history</code> table reference
     */
    public JobHistory() {
        this(DSL.name("job_history"), null);
    }

    /**
     * Create an aliased <code>hr.job_history</code> table reference
     */
    public JobHistory(String alias) {
        this(DSL.name(alias), JOB_HISTORY);
    }

    /**
     * Create an aliased <code>hr.job_history</code> table reference
     */
    public JobHistory(Name alias) {
        this(alias, JOB_HISTORY);
    }

    private JobHistory(Name alias, Table<JobHistoryRecord> aliased) {
        this(alias, aliased, null);
    }

    private JobHistory(Name alias, Table<JobHistoryRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> JobHistory(Table<O> child, ForeignKey<O, JobHistoryRecord> key) {
        super(child, key, JOB_HISTORY);
    }

    @Override
    public Schema getSchema() {
        return Hr.HR;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.JOB_HISTORY_DEPARTMENT_ID, Indexes.JOB_HISTORY_JOB_ID);
    }

    @Override
    public List<UniqueKey<JobHistoryRecord>> getKeys() {
        return Arrays.<UniqueKey<JobHistoryRecord>>asList(Keys.KEY_JOB_HISTORY_EMPLOYEE_ID);
    }

    @Override
    public List<ForeignKey<JobHistoryRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<JobHistoryRecord, ?>>asList(Keys.JOB_HISTORY_IBFK_1, Keys.JOB_HISTORY_IBFK_2, Keys.JOB_HISTORY_IBFK_3);
    }

    public Employees employees() {
        return new Employees(this, Keys.JOB_HISTORY_IBFK_1);
    }

    public Jobs jobs() {
        return new Jobs(this, Keys.JOB_HISTORY_IBFK_2);
    }

    public Departments departments() {
        return new Departments(this, Keys.JOB_HISTORY_IBFK_3);
    }

    @Override
    public JobHistory as(String alias) {
        return new JobHistory(DSL.name(alias), this);
    }

    @Override
    public JobHistory as(Name alias) {
        return new JobHistory(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public JobHistory rename(String name) {
        return new JobHistory(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JobHistory rename(Name name) {
        return new JobHistory(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<UInteger, LocalDate, LocalDate, String, UInteger> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
