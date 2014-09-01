package at.woodstick.lighter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;
import at.woodstick.lighter.MainActivity;


/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class at.woodstick.lighter.MainActivityTest \
 * at.woodstick.lighter.tests/android.test.InstrumentationTestRunner
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private Activity mActivity;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        mActivity = getActivity();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();

        mActivity = null;
    }

    public void testHelloWorldLabel() {
        TextView helloWorldLabel = (TextView) mActivity.findViewById(R.id.tf_hello_world);

        assertNotNull("TextView hello world is null", helloWorldLabel);
        assertNotNull("TextView text is null", helloWorldLabel.getText());

        String expectedLabelText = mActivity.getString(R.string.hello_world);
        String helloWorldLabelText = helloWorldLabel.getText().toString();

        assertEquals("TextView not containing right text", expectedLabelText, helloWorldLabelText);
    }
}
