package at.woodstick.lighter.db.tables;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import android.database.sqlite.SQLiteDatabase;
import static at.woodstick.lighter.testutils.DataBaseTestUtils.createDatabaseMock;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore({"android.database.sqlite.*"})
@PrepareForTest({SQLiteDatabase.class})
public class UserStoryTableTest {
	
	private static final String TABLE_NAME = "user_story";
	private static final String CREATE_TABLE_STATEMENT = "CREATE TABLE " + TABLE_NAME + " (_id INTEGER PRIMARY KEY, user_story_title TEXT NOT NULL, user_story_created_at INTEGER NOT NULL)";
	
	@Test
	public void shouldCreateUserStoryTable(){
		SQLiteDatabase database = createDatabaseMock();
		
		
		Mockito.doNothing().when(database).execSQL(CREATE_TABLE_STATEMENT);

        UserStoryTable.onCreate(database);

        Mockito.verify(database).execSQL(CREATE_TABLE_STATEMENT);
	}
	
	@Test
	public void shouldDropTableAndRecreateOnUpgrade() {
		SQLiteDatabase database = createDatabaseMock();

		int dummyNewVersion = 1;
		int dummyOldVersion = 1;
		String dropTableStatement = "DROP TABLE IF EXISTS " + TABLE_NAME;
		
		Mockito.doNothing().when(database).execSQL(dropTableStatement);
		Mockito.doNothing().when(database).execSQL(CREATE_TABLE_STATEMENT);
		
		UserStoryTable.onUpgrade(database, dummyOldVersion, dummyNewVersion);
		
		Mockito.verify(database).execSQL(dropTableStatement);
		Mockito.verify(database).execSQL(CREATE_TABLE_STATEMENT);
	}

}
