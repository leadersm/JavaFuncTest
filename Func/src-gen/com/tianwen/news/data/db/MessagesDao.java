package com.tianwen.news.data.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.tianwen.news.data.db.Messages;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table MESSAGES.
*/
public class MessagesDao extends AbstractDao<Messages, String> {

    public static final String TABLENAME = "MESSAGES";

    /**
     * Properties of entity Messages.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, String.class, "id", true, "ID");
        public final static Property FromAccount = new Property(1, String.class, "fromAccount", false, "FROM_ACCOUNT");
        public final static Property FromName = new Property(2, String.class, "fromName", false, "FROM_NAME");
        public final static Property Content = new Property(3, String.class, "content", false, "CONTENT");
        public final static Property Date = new Property(4, Long.class, "date", false, "DATE");
        public final static Property AutoShow = new Property(5, Integer.class, "autoShow", false, "AUTO_SHOW");
        public final static Property Type = new Property(6, Integer.class, "type", false, "TYPE");
    };


    public MessagesDao(DaoConfig config) {
        super(config);
    }
    
    public MessagesDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'MESSAGES' (" + //
                "'ID' TEXT PRIMARY KEY NOT NULL ," + // 0: id
                "'FROM_ACCOUNT' TEXT," + // 1: fromAccount
                "'FROM_NAME' TEXT," + // 2: fromName
                "'CONTENT' TEXT," + // 3: content
                "'DATE' INTEGER," + // 4: date
                "'AUTO_SHOW' INTEGER," + // 5: autoShow
                "'TYPE' INTEGER);"); // 6: type
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'MESSAGES'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Messages entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getId());
 
        String fromAccount = entity.getFromAccount();
        if (fromAccount != null) {
            stmt.bindString(2, fromAccount);
        }
 
        String fromName = entity.getFromName();
        if (fromName != null) {
            stmt.bindString(3, fromName);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(4, content);
        }
 
        Long date = entity.getDate();
        if (date != null) {
            stmt.bindLong(5, date);
        }
 
        Integer autoShow = entity.getAutoShow();
        if (autoShow != null) {
            stmt.bindLong(6, autoShow);
        }
 
        Integer type = entity.getType();
        if (type != null) {
            stmt.bindLong(7, type);
        }
    }

    /** @inheritdoc */
    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.getString(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Messages readEntity(Cursor cursor, int offset) {
        Messages entity = new Messages( //
            cursor.getString(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // fromAccount
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // fromName
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // content
            cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4), // date
            cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5), // autoShow
            cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6) // type
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Messages entity, int offset) {
        entity.setId(cursor.getString(offset + 0));
        entity.setFromAccount(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setFromName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setContent(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setDate(cursor.isNull(offset + 4) ? null : cursor.getLong(offset + 4));
        entity.setAutoShow(cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5));
        entity.setType(cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(Messages entity, long rowId) {
        return entity.getId();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(Messages entity) {
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
