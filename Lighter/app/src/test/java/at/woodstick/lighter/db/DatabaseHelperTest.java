package at.woodstick.lighter.db;

import android.content.Context;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(RobolectricTestRunner.class)
public class DatabaseHelperTest {

    private DatabaseHelper databaseHelper;

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

    @Ignore("not yet implemented")
    @Test
    public void shouldCreateDatabase() {
        //TODO: find a way to test onCreate
    }

    @Ignore("not yet implemented")
    @Test
    public void shouldUpdateDatabase() {
        //TODO: find a way to test onUpdate
    }
}
