package com.example.xts.greendaodemo.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.exam.bean.DataBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DATA_BEAN".
*/
public class DataBeanDao extends AbstractDao<DataBean, String> {

    public static final String TABLENAME = "DATA_BEAN";

    /**
     * Properties of entity DataBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, int.class, "id", false, "ID");
        public final static Property Title = new Property(1, String.class, "title", true, "TITLE");
        public final static Property Price_info = new Property(2, float.class, "price_info", false, "PRICE_INFO");
        public final static Property Scene_pic_url = new Property(3, String.class, "scene_pic_url", false, "SCENE_PIC_URL");
        public final static Property Subtitle = new Property(4, String.class, "subtitle", false, "SUBTITLE");
        public final static Property Isok = new Property(5, boolean.class, "isok", false, "ISOK");
    }


    public DataBeanDao(DaoConfig config) {
        super(config);
    }
    
    public DataBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DATA_BEAN\" (" + //
                "\"ID\" INTEGER NOT NULL ," + // 0: id
                "\"TITLE\" TEXT PRIMARY KEY NOT NULL ," + // 1: title
                "\"PRICE_INFO\" REAL NOT NULL ," + // 2: price_info
                "\"SCENE_PIC_URL\" TEXT," + // 3: scene_pic_url
                "\"SUBTITLE\" TEXT," + // 4: subtitle
                "\"ISOK\" INTEGER NOT NULL );"); // 5: isok
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DATA_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DataBean entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(2, title);
        }
        stmt.bindDouble(3, entity.getPrice_info());
 
        String scene_pic_url = entity.getScene_pic_url();
        if (scene_pic_url != null) {
            stmt.bindString(4, scene_pic_url);
        }
 
        String subtitle = entity.getSubtitle();
        if (subtitle != null) {
            stmt.bindString(5, subtitle);
        }
        stmt.bindLong(6, entity.getIsok() ? 1L: 0L);
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DataBean entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(2, title);
        }
        stmt.bindDouble(3, entity.getPrice_info());
 
        String scene_pic_url = entity.getScene_pic_url();
        if (scene_pic_url != null) {
            stmt.bindString(4, scene_pic_url);
        }
 
        String subtitle = entity.getSubtitle();
        if (subtitle != null) {
            stmt.bindString(5, subtitle);
        }
        stmt.bindLong(6, entity.getIsok() ? 1L: 0L);
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1);
    }    

    @Override
    public DataBean readEntity(Cursor cursor, int offset) {
        DataBean entity = new DataBean( //
            cursor.getInt(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // title
            cursor.getFloat(offset + 2), // price_info
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // scene_pic_url
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // subtitle
            cursor.getShort(offset + 5) != 0 // isok
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DataBean entity, int offset) {
        entity.setId(cursor.getInt(offset + 0));
        entity.setTitle(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setPrice_info(cursor.getFloat(offset + 2));
        entity.setScene_pic_url(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setSubtitle(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setIsok(cursor.getShort(offset + 5) != 0);
     }
    
    @Override
    protected final String updateKeyAfterInsert(DataBean entity, long rowId) {
        return entity.getTitle();
    }
    
    @Override
    public String getKey(DataBean entity) {
        if(entity != null) {
            return entity.getTitle();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(DataBean entity) {
        return entity.getTitle() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}