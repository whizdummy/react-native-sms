
package com.reactlibrary;

import android.telephony.SmsManager;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;


public class RNSmsModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public RNSmsModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
    return "RNSms";
  }

    @ReactMethod
    public void sendMessage(String stringPatientNumber, String stringMessage) {
        String number = stringPatientNumber;
        String message = stringMessage;
        number = removeSpaceDash(number);
        String firstCharacter = "";
        if (number.length() > 0) {
            firstCharacter = number.substring(0, 1);
            if (number.length() == 10 && firstCharacter.equals("9")) {
                number = "0" + number;
            }
            firstCharacter = number.substring(0, 1);
        }
        Boolean sendSms = false;
        if (number.length() == 11 && firstCharacter.equals("0")) {
            number = number.substring(1);
            number = new String("+63").concat(number);
            sendSms = true;
        } else if (number.length() == 13 && firstCharacter.equals("+")) {
            sendSms = true;
        }
        if (sendSms) {
            try {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(number, null, message, null, null);
                Log.e("SMS", "Sent to " + number);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Log.e("SMS", "Error with moile number.");
        }
    }

    private String removeSpaceDash(String number) {
        number.replaceAll("[\\s\\-]", "");
        return number;
    }
}