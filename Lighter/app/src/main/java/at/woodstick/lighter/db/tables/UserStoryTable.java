package at.woodstick.lighter.db.tables;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class UserStoryTable implements BaseColumns {

	public static final String TABLE_NAME = "user_story";
	public static final String COLUMN_TITLE = "user_story_title";
	
	private static final String CREATE_TABLE_QUERY = 
		"CREATE TABLE " + TABLE_NAME + " ("
		+ _ID + " INTEGER PRIMARY KEY"
		+ ", " + COLUMN_TITLE + " TEXT NOT NULL"
		+ ", user_story_created_at INTEGER NOT NULL"
		+ ")";
	
	private static final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;	
	
	public static void onCreate(SQLiteDatabase database) {
		database.execSQL(CREATE_TABLE_QUERY);
	}
	
	public static void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		database.execSQL(DROP_TABLE_QUERY);
		onCreate(database);
		
	}
}
