package com.example.michaeltu.cmbtest;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiCollection;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static java.lang.Thread.sleep;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private static final String PACKAGE
            = "cmb.pb";
    private static final int LAUNCH_TIMEOUT = 5000;
    private static final int CLICK_TIMEOUT = 2000;

    private static final String STRING_TO_BE_TYPED = "UiAutomator";
    private UiDevice mDevice;

    @Before
    public void initial(){
        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
//
//        // Start from the home screen
//        mDevice.pressHome();
//
//        // Wait for launcher
//        final String launcherPackage = mDevice.getLauncherPackageName();
//        assertThat(launcherPackage, notNullValue());
//        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)),
//                LAUNCH_TIMEOUT);
//
//        // Launch the app
//        Context context = InstrumentationRegistry.getContext();
//        final Intent intent = context.getPackageManager()
//                .getLaunchIntentForPackage(PACKAGE);
//        // Clear out any previous instances
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        context.startActivity(intent);
//
//        // Wait for the app to appear
//        mDevice.wait(Until.hasObject(By.pkg(PACKAGE).depth(0)),
//                LAUNCH_TIMEOUT);
    }

    @Test
    public void clickIncomeStatement(){
        try {

            new UiObject(new UiSelector().text("收支明细")).click();


//            UiCollection dummyList = new UiCollection(new UiSelector().resourceId("cmb.pb:id/gGridView").index(3));
//            dummyList.click();





//            mDevice.findObject(new UiSelector().packageName(PACKAGE).resourceId("cmb.pb:id/ivtoptoolsqr1")).click();
//
//            mDevice.wait(Until.hasObject(By.pkg(PACKAGE).depth(0)), CLICK_TIMEOUT);
//
//            mDevice.findObject(new UiSelector().packageName(PACKAGE).resourceId("cmb.pb:id/img_pay_code")).click();
//
////            mDevice.wait(Until.hasObject(By.pkg(PACKAGE).depth(0)), 15000);

            sleep(1500);

            Log.i("test99", "exists "+mDevice.findObject(new UiSelector().packageName(PACKAGE).resourceId("cmb.pb:id/vGestureContentView")).exists());
            if(mDevice.findObject(new UiSelector().packageName(PACKAGE).resourceId("cmb.pb:id/vGestureContentView")).exists()) {

                Point p1 = new Point();
                Point p2 = new Point();
                Point p3 = new Point();

                p1.x = 235;
                p1.y = 726;
                p2.x = 240;
                p2.y = 1324;
                p3.x = 838;
                p3.y = 1324;

                Point[] p = {p1, p2, p3};

                mDevice.swipe(p, 20);

                sleep(3000);

            }

            mDevice.wait(Until.findObject(By.clazz(WebView.class)), timeOut);

            new UiObject(new UiSelector().textContains("支付宝")).click();

            sleep(3000);

//            UiObject mUiObject = mDevice.findObject(new UiSelector()
//                    .instance(0)
//                    .className(View.class));
//            String content = mUiObject.getText();
//            Log.i("test99", "content "+content);

            UiObject detailObject = new UiObject(new UiSelector().className(WebView.class))
                    .getChild(new UiSelector().index(0))
                    .getChild(new UiSelector().index(0))
                    .getChild(new UiSelector().index(0))
                    .getChild(new UiSelector().index(0))
                    .getChild(new UiSelector().index(0));

            int cnt = detailObject.getChildCount();
            Log.i("test99", "cnt "+cnt);


            UiObject amountObject = detailObject.getChild(new UiSelector().index(0)).getChild(new UiSelector().index(0)).getChild(new UiSelector().index(0));
            UiObject totalAmountObject = detailObject.getChild(new UiSelector().index(0)).getChild(new UiSelector().index(1)).getChild(new UiSelector().index(0));
            UiObject cardNumberObject = new UiObject(new UiSelector().className(WebView.class)).getChild(new UiSelector().textContains("交易卡号")).getFromParent(new UiSelector().index(1));
            UiObject storeObject =      new UiObject(new UiSelector().className(WebView.class)).getChild(new UiSelector().textContains("商户")).getFromParent(new UiSelector().index(1));
            UiObject timeObject =       new UiObject(new UiSelector().className(WebView.class)).getChild(new UiSelector().textContains("交易时间")).getFromParent(new UiSelector().index(1));


            Log.i("test99", "amount "+amountObject.getText());
            Log.i("test99", "totalAmountObject "+totalAmountObject.getText());
            Log.i("test99", "storeObject "+storeObject.getText());
            Log.i("test99", "cardNumberObject "+cardNumberObject.getText());
            Log.i("test99", "timeObject "+timeObject.getText());

//            UiObject listview = mDevice.findObject(new UiSelector().className(android.webkit.WebView.class));
//            listview.waitForExists(timeOut);
//            listview.click();

        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
            Log.i("test99", "UiObjectNotFoundException "+e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    final int timeOut = 3000;

//    @Test
//    public void useAppContext() throws Exception {
//        // Context of the app under test.
//        Context appContext = InstrumentationRegistry.getTargetContext();
//
//        assertEquals(BASIC_SAMPLE_PACKAGE, appContext.getPackageName());
//    }
}
