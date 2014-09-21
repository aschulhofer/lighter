package at.woodstick.lighter.testutils;

import org.powermock.api.mockito.PowerMockito;

import android.database.sqlite.SQLiteDatabase;

public class DataBaseTestUtils {
	
	public static SQLiteDatabase createDatabaseMock() {
		SQLiteDatabase database = PowerMockito.mock(SQLiteDatabase.class);
		
		return database;
	}
}
