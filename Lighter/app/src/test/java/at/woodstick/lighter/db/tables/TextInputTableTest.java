package at.woodstick.lighter.db.tables;

import android.database.sqlite.SQLiteDatabase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore({"android.database.sqlite.*"})
@PrepareForTest({SQLiteDatabase.class})
public class TextInputTableTest {

    /**
     * Bootstrap PowerMock using a JUnit Rule instead of using PowerMockRunner and the RunWith
     * annotation. This allows the use of other JUnit runners.
     */
//    @Rule
//    public PowerMockRule rule = new PowerMockRule();

    @Test
    public void shouldRun() {

        SQLiteDatabase database = PowerMockito.mock(SQLiteDatabase.class);

        Mockito.when(database.rawQuery("", null)).thenReturn(null);

        TextInputTable.onCreate(database);

        Mockito.verify(database).rawQuery("", null);


//        SQLiteDatabase database = PowerMock.createMock(SQLiteDatabase.class);
//
//        EasyMock.expect(database.rawQuery("", null)).andReturn(null);
//
//        EasyMock.replay(database);
//
//        TextInputTable.onCreate(database);
//
//        EasyMock.verify();
    }

}
