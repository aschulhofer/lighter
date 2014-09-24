package at.woodstick.lighter.db;

import static at.woodstick.lighter.testutils.DataBaseTestUtils.createDatabaseMock;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.robolectric.RobolectricTestRunner;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import at.woodstick.lighter.db.tables.UserStoryTable;
import at.woodstick.lighter.entities.UserStory;

@RunWith(RobolectricTestRunner.class)
@PowerMockIgnore({"org.mockito.*", "org.robolectric.*", "android.*"})
@PrepareForTest({SQLiteDatabase.class, DatabaseHelper.class})
public class UserStoryTableManagerTest {

	private UserStoryTableManager tableManager;
	private SQLiteDatabase databaseMock;
	private DatabaseHelper databaseHelperMock;
	
	@Test
	public void shouldCreateUserStory() {
		String testTitle = "testStory 1";
		long testId = 1;
		ContentValues values = new ContentValues();
		values.put(UserStoryTable.COLUMN_TITLE, testTitle);
		
		Mockito.when(databaseHelperMock.getWritableDatabase()).thenReturn(databaseMock);
		Mockito.when(databaseMock.insert(UserStoryTable.TABLE_NAME, null, values)).thenReturn(testId);
		Mockito.doNothing().when(databaseHelperMock).close();
				
		UserStory story = tableManager.createUserStory(testTitle);
		
		Mockito.verify(databaseHelperMock).getWritableDatabase();
		Mockito.verify(databaseMock).insert(UserStoryTable.TABLE_NAME, null, values);
		Mockito.verify(databaseHelperMock).close();
		
		assertThat(story.getId()).isEqualTo(testId);
		assertThat(story.getTitle()).isEqualTo(testTitle);
	}
	
	@Before
	public void setUp() {
		databaseMock = createDatabaseMock();
		databaseHelperMock = Mockito.mock(DatabaseHelper.class);
		
		tableManager = new UserStoryTableManager(databaseHelperMock);
	}
	
	@After
	public void tearDown() {
		databaseHelperMock = null;
		databaseMock = null;
		tableManager = null;
	}
}
