package at.woodstick.lighter.db;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.easymock.PowerMock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import at.woodstick.lighter.db.tables.UserStoryTable;
import static at.woodstick.lighter.testutils.DataBaseTestUtils.createDatabaseMock;

@RunWith(RobolectricTestRunner.class)
@PowerMockIgnore({"org.mockito.*", "org.robolectric.*", "android.*"})
@PrepareForTest({UserStoryTable.class})
public class DatabaseHelperTest {

    private DatabaseHelper databaseHelper;

    /**
     * Bootstrap PowerMock using a JUnit Rule instead of using PowerMockRunner and the RunWith
     * annotation. This allows the use of other JUnit runners.
     */
    @Rule
    public PowerMockRule rule = new PowerMockRule();
    
    @Before
    public void setUp() {
        Context context = Robolectric.application;
        databaseHelper = new DatabaseHelper(context);
    }

    @After
    public void tearDown() {
        databaseHelper.close();
        databaseHelper = null;
    }

    @Test
    public void shouldCreateNewInstanceOfDatabaseHelper() {
        String databaseName = databaseHelper.getDatabaseName();
        String expectedDatabaseName = DatabaseHelper.DATABASE_NAME;

        assertThat(databaseName).isEqualTo(expectedDatabaseName);
    }

    @Test
    public void shouldHaveTheCorrectVersion() {
        int databaseVersion = databaseHelper.getVersion();
        int expectedDatabaseVersion = DatabaseHelper.DATABASE_VERSION;

        assertThat(databaseVersion).isEqualTo(expectedDatabaseVersion);
    }

    @Test
    public void shouldCreateDatabase() throws Exception {
    	SQLiteDatabase database = createDatabaseMock();
    	
    	PowerMockito.mockStatic(UserStoryTable.class);
    	
    	PowerMockito.doNothing().when(UserStoryTable.class, "onCreate", database);
    	
    	databaseHelper.onCreate(database);
    	
    	PowerMockito.verifyStatic();
    	UserStoryTable.onCreate(database);
    }

    @Test
    public void shouldUpdateDatabase() throws Exception {
    	SQLiteDatabase database = createDatabaseMock();
    	int dummyOldVersion = 1;
    	int dummyNewVersion = 1;
    	
    	PowerMockito.mockStatic(UserStoryTable.class);
    	
    	PowerMockito.doNothing().when(UserStoryTable.class, "onUpgrade", database, dummyOldVersion, dummyNewVersion);
    	
    	databaseHelper.onUpgrade(database, dummyOldVersion, dummyNewVersion);
    	
    	PowerMockito.verifyStatic();
    	UserStoryTable.onUpgrade(database, dummyOldVersion, dummyNewVersion);
    }
}
