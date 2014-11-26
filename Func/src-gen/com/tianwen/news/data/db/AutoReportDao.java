package com.tianwen.news.data.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.tianwen.news.data.db.AutoReport;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table AUTO_REPORT.
*/
public class AutoReportDao extends AbstractDao<AutoReport, Long> {

    public static final String TABLENAME = "AUTO_REPORT";

    /**
     * Properties of entity AutoReport.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property StockName = new Property(1, String.class, "stockName", false, "STOCK_NAME");
        public final static Property StockCode = new Property(2, String.class, "stockCode", false, "STOCK_CODE");
        public final static Property FileName = new Property(3, String.class, "fileName", false, "FILE_NAME");
        public final static Property Date = new Property(4, Long.class, "date", false, "DATE");
    };


    public AutoReportDao(DaoConfig config) {
        super(config);
    }
    
    public AutoReportDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'AUTO_REPORT' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'STOCK_NAME' TEXT," + // 1: stockName
                "'STOCK_CODE' TEXT," + // 2: stockCode
                "'FILE_NAME' TEXT NOT NULL ," + // 3: fileName
                "'DATE' INTEGER);"); // 4: date
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'AUTO_REPORT'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, AutoReport entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String stockName = entity.getStockName();
        if (stockName != null) {
            stmt.bindString(2, stockName);
        }
 
        String stockCode = entity.getStockCode();
        if (stockCode != null) {
            stmt.bindString(3, stockCode);
        }
        stmt.bindString(4, entity.getFileName());
 
        Long date = entity.getDate();
        if (date != null) {
            stmt.bindLong(5, date);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public AutoReport readEntity(Cursor cursor, int offset) {
        AutoReport entity = new AutoReport( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // stockName
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // stockCode
            cursor.getString(offset + 3), // fileName
            cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4) // date
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, AutoReport entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setStockName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setStockCode(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setFileName(cursor.getString(offset + 3));
        entity.setDate(cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(AutoReport entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(AutoReport entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
