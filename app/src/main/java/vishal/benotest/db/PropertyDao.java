package vishal.benotest.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import vishal.benotest.models.Property;

/**
 * Created by Vishal Gaur on 6/20/2018.
 */

public class PropertyDao {
    private Database mDbHelper = null;

    @Inject
    PropertyDao(Database mDbHelper) {
        this.mDbHelper = mDbHelper;
    }

    public synchronized void savePropertyList(List<Property> propertyList) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        db.beginTransaction();
        for (Property item : propertyList) {
            ContentValues values = new ContentValues();
            values.put(PropertyTable.LANDMARK, item.getLandmark());
            values.put(PropertyTable.CITY, item.getCity());
            values.put(PropertyTable.NAME, item.getName());
            values.put(PropertyTable.REVIEW_COUNT, item.getReviewCount());
            values.put(PropertyTable.PRICE, item.getPrice());
            db.insert(PropertyTable.TABLE_NAME, null, values);
        }
        db.setTransactionSuccessful();
        db.endTransaction();

    }


    public List<Property> getAllProperty() {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        List<Property> list = new ArrayList<>();

        Cursor cursor = db.query(PropertyTable.TABLE_NAME, null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            list.add(getProperty(cursor));
        }
        cursor.close();
        return list;
    }

    private Property getProperty(Cursor cursor) {
        Property beatsItem = new Property();
        beatsItem.setLandmark(DBUtils.getString(cursor, PropertyTable.LANDMARK));
        beatsItem.setCity(DBUtils.getString(cursor, PropertyTable.CITY));
        beatsItem.setName(DBUtils.getString(cursor, PropertyTable.NAME));
        beatsItem.setPrice(DBUtils.getFloat(cursor, PropertyTable.PRICE));
        beatsItem.setReviewCount(DBUtils.getInteger(cursor, PropertyTable.REVIEW_COUNT));
        return beatsItem;
    }

    public void delete(){

    }

}
