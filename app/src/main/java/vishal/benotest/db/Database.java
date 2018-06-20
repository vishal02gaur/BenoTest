package vishal.benotest.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import javax.inject.Inject;

public class Database extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 1;
    private static final String DB_NAME = "beni.db";
    private static final String INTERNAL_DB_NAME = DB_NAME;
    private static final String EXTERNAL_DB_NAME = "/sdcard/vishal/" + DB_NAME;

    public static final String DATABASE_NAME = INTERNAL_DB_NAME;

    @Inject
    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PropertyTable.getPropertyTableCreateQuery());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
