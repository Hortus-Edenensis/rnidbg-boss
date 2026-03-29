package com.lantern.auth.app;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import com.lantern.auth.core.BLCallback;
import com.lantern.auth.core.BLLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class SMSReceiver {
    private static final String SIGN_NAME = "连尚网络";
    private BLCallback callback;
    private Context context;
    private BroadcastReceiver smsReceiver = new BroadcastReceiver() { // from class: com.lantern.auth.app.SMSReceiver.1
        @Override // android.content.BroadcastReceiver
        @SuppressLint({"NewApi"})
        public void onReceive(Context context, Intent intent) {
            try {
                StringBuilder sb = new StringBuilder();
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    for (Object obj : (Object[]) extras.get("pdus")) {
                        sb.append((Build.VERSION.SDK_INT < 23 ? SmsMessage.createFromPdu((byte[]) obj) : SmsMessage.createFromPdu((byte[]) obj, intent.getStringExtra("format"))).getMessageBody());
                    }
                    BLLog.d("sms content is " + ((Object) sb), new Object[0]);
                    if (sb.toString().contains(SMSReceiver.SIGN_NAME)) {
                        String yzmFromSms = SMSReceiver.getYzmFromSms(sb.toString());
                        if (SMSReceiver.this.callback != null) {
                            FunDC.onEventById(FunDC.ID_AUTH_1066);
                            SMSReceiver.this.callback.run(1, yzmFromSms, yzmFromSms);
                        }
                    } else {
                        FunDC.onEventById(FunDC.ID_AUTH_1067);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            abortBroadcast();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static String getYzmFromSms(String str) {
        try {
            Matcher matcher = Pattern.compile("\\d{6}").matcher(str);
            if (matcher.find()) {
                return matcher.group();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void startListener(Context context, BLCallback bLCallback) {
        try {
            this.context = context;
            this.callback = bLCallback;
            IntentFilter intentFilter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
            intentFilter.setPriority(99999);
            context.registerReceiver(this.smsReceiver, intentFilter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopListener() {
        try {
            this.context.unregisterReceiver(this.smsReceiver);
            this.context = null;
            this.callback = null;
        } catch (Exception unused) {
        }
    }
}
