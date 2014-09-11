package at.woodstick.lighter;

import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.After;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import at.woodstick.lighter.MainActivity;
import at.woodstick.lighter.R;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    private MainActivity mainActivity;

    @Before
    public void setUp() {
        mainActivity = Robolectric.buildActivity(MainActivity.class).create().visible().start().resume().get();
    }

    @After
    public void tearDown() {
        mainActivity = null;
    }

    @Test
    public void shouldHaveHelloWorldText() {
        TextView helloWorldLabel = findViewById(R.id.tf_hello_world);

        Assert.assertNotNull("TextView hello world is null", helloWorldLabel);
        Assert.assertNotNull("TextView text is null", helloWorldLabel.getText());

        String expectedLabelText = mainActivity.getString(R.string.hello_world);
        String helloWorldLabelText = helloWorldLabel.getText().toString();

        Assert.assertEquals("TextView not containing right text", expectedLabelText, helloWorldLabelText);
    }

    @Test
    public void shouldHaveButtonTextViewAndInputFieldForDisplayText() {
        TextView inputTextDisplayField = findViewById(R.id.tf_display_text);
        EditText inputField = findViewById(R.id.if_display_text);
        Button inputFieldSubmitButton = findViewById(R.id.btn_display_text);

        Assert.assertNotNull("Display text input field is null", inputField);
        Assert.assertNotNull("Display text field is null", inputTextDisplayField);
        Assert.assertNotNull("Display text button is null", inputFieldSubmitButton);

        // Check input field default text
        Editable inputFieldText = inputField.getText();

        Assert.assertNotNull("Input field text is null", inputFieldText);

        String expectedTextInputField = mainActivity.getString(R.string.if_default_text);
        Assert.assertEquals("TextField not containing right text", expectedTextInputField, inputFieldText.toString());

        // Check button name
        CharSequence buttonText = inputFieldSubmitButton.getText();
        Assert.assertNotNull("Button field text is null", buttonText);

        String expectedButtonText = mainActivity.getString(R.string.btn_default_text_display_button);

        Assert.assertEquals("Button does not display right name", expectedButtonText, buttonText.toString());
    }

    @Test
    public void shouldChangeTextOfDisplayFieldWhenSubmitButtonIsClicked() {
        TextView inputTextDisplayField = findViewById(R.id.tf_display_text);
        EditText inputField = findViewById(R.id.if_display_text);
        Button inputFieldSubmitButton = findViewById(R.id.btn_display_text);

        String expectedText = "test text to display";
        inputField.setText(expectedText);

        inputFieldSubmitButton.performClick();

        Assert.assertEquals("Not the right text after button click", expectedText, inputTextDisplayField.getText().toString());
    }

    private <T> T findViewById(int resId) {
        return (T) mainActivity.findViewById(resId);
    }
}
