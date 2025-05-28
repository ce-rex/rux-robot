package com.example.ruxtest4;

import android.os.Handler;
import android.os.RemoteException;
import android.view.MotionEvent;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.leitianpai.robotsdk.RobotService;
import com.leitianpai.robotsdk.callback.SensorCallback;
import com.leitianpai.robotsdk.commandlib.Light;
import com.leitianpai.robotsdk.message.ActionMessage;
import com.leitianpai.robotsdk.message.AntennaLightMessage;

public class MainActivity extends AppCompatActivity {

    RobotService mRobotService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 1,step 1
        mRobotService = RobotService.getInstance(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        (new Handler()).postDelayed(this::switchLedsToBlue, 5000);
    }

    SensorCallback callback = new SensorCallback() {
        @Override
        public void onTapResponse() {
            // Callback interface triggered by a single tap on the head.
            mRobotService.robotPlayTTs("Hello, I'm Rux. How are you?");
        }

        @Override
        public void onDoubleTapResponse() {
            // Callback interface triggered by two consecutive taps on the head
        }

        @Override
        public void onLongPressResponse() {
            // Callback interface triggered by a long press on the head.
        }

        @Override
        public void onFallBackend() {
            // Triggered when a cliff is detected in front.
        }

        @Override
        public void onFallForward() {
            // Triggered when a cliff is detected behind.
        }

        @Override
        public void onFallRight() {
            // Triggered when a cliff is detected on the left side.
        }

        @Override
        public void onFallLeft() {
            // Triggered when a cliff is detected on the right side.
        }

        @Override
        public void onTof() {
            // Triggered when an obstacle is detected.
        }
    };

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            //2, step 2

            mRobotService.robotPlayTTs("Hello, I'm Rux. How are you?");

            mRobotService.robotOpenMotor();  //makes a very high noise
            //mRobotService.robotCloseMotor();  //light only blinks for a split second
            AntennaLightMessage alMessage = new AntennaLightMessage();
            alMessage.set(Light.RED);
            mRobotService.robotAntennaLight(alMessage);
            mRobotService.robotCloseMotor();  //light only blinks for a split second

            mRobotService.robotStartExpression("h0003");

            mRobotService.robotControlSound("a0003");

            ActionMessage mMessage = new ActionMessage();
            mMessage.set(
                    63, // number: Robot action number, refer to the robot action number.
                    2, // speed: Robot execution speed.
                    3); // stepNum: Robot step count.

            // Start executing the action.
            mRobotService.robotActionCommand(mMessage);

// Unbind the RobotService.
            mRobotService.unbindService();
            // mRobotService.robotCloseAntennaLight();

            // Turn on the sensor power
            mRobotService.robotOpenSensor();

            // Register the callback to the sensor service
            try {
                mRobotService.robotRegisterSensorCallback(callback);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }

        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mRobotService != null)
            mRobotService.unbindService();
    }

    public void switchLedsToBlue(){
        ////2, step 2
        mRobotService.robotOpenMotor();

        AntennaLightMessage alMessage = new AntennaLightMessage();
        alMessage.set(Light.BLUE);
        mRobotService.robotAntennaLight(alMessage);

        mRobotService.robotCloseMotor();
    }
}