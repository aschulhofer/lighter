package at.woodstick.lighter.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import at.woodstick.lighter.db.tables.UserStoryTable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "lighter.db";
    public static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public int getVersion() {
        return getReadableDatabase().getVersion();
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
    	UserStoryTable.onCreate(database);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
    	UserStoryTable.onUpgrade(database, oldVersion, newVersion);
    }
}
