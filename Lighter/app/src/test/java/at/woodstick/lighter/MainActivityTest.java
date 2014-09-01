package at.woodstick.lighter;

import android.widget.TextView;

import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import at.woodstick.lighter.MainActivity;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    @Test
    public void shouldHaveHelloWorldText() {
        MainActivity activity = Robolectric.buildActivity(MainActivity.class).create().start().resume().get();

        TextView helloWorldLabel = (TextView) activity.findViewById(R.id.tf_hello_world);

        Assert.assertNotNull("TextView hello world is null", helloWorldLabel);
        Assert.assertNotNull("TextView text is null", helloWorldLabel.getText());

        String expectedLabelText = activity.getString(R.string.hello_world);
        String helloWorldLabelText = helloWorldLabel.getText().toString();

        Assert.assertEquals("TextView not containing right text", expectedLabelText, helloWorldLabelText);
    }

}
