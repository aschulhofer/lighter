package at.woodstick.lighter.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import at.woodstick.lighter.db.tables.UserStoryTable;
import at.woodstick.lighter.entities.UserStory;

public class UserStoryTableManager {

	private DatabaseHelper databaseHelper;
	private SQLiteDatabase database;
	
	public UserStoryTableManager(DatabaseHelper databaseHelper) {
		this.databaseHelper = databaseHelper;
	}

	private void openConnection() {
		database = databaseHelper.getWritableDatabase();
	}
	
	private void closeConnection() {
		databaseHelper.close();
		database = null;
	}
	
	public UserStory createUserStory(String title) {
		
		UserStory userStory = null;
		
		openConnection();
		
		ContentValues values = new ContentValues();
		values.put(UserStoryTable.COLUMN_TITLE, title);
		
		long id = database.insert(
			UserStoryTable.TABLE_NAME, 
			null, 
			values
		);
		
		if(id != -1) {
			userStory = new UserStory(id, title);
		}
		
		closeConnection();
		
		return userStory; 
	}
	
}
