package com.example.raindrop;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
    MainActivity activity;

    @Before
    public void setUp()  {
        activity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .start()
                .resume()
                .get();
    }

    @Test
     public void mClickButton_shouldStartLoginActivity() {
        activity.findViewById(R.id.button).performClick();
        assert(Robolectric.buildActivity(LoginActivity.class).get() != null);
    }


}
