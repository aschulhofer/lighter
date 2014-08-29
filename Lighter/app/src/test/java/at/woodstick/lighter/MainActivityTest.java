package at.woodstick.lighter;

import android.widget.TextView;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import at.woodstick.lighter.MainActivity;
import org.robolectric.Robolectric;
import org.robolectric.util.ActivityController;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    @Test
    public void shouldHaveHelloWorldText() {
        MainActivity activity = Robolectric.buildActivity(MainActivity.class).create().start().resume().get();

        TextView helloWorldLabel = (TextView) activity.findViewById(R.id.tf_hello_world);

        Assert.assertNotNull("TextView hello world is null", helloWorldLabel);

        String expectedLabelText = activity.getString(R.string.hello_world);

        Assert.assertNotNull("TextView text is null", helloWorldLabel.getText());

        String helloWorldLabelText = helloWorldLabel.getText().toString();

        Assert.assertEquals("TextView not containing right text", expectedLabelText, helloWorldLabelText);
    }

}
