package com.lantern.auth.provider;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.lantern.auth.app.FunDC;
import com.lantern.auth.app.WkSDKManager;
import com.lantern.auth.core.BLCallback;
import com.lantern.auth.core.BLLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class ClientLoginManager {
    private static final String AUTHORITY = "com.snda.wifilocating.loginProvider";
    public static final String FUN_TYPE_CODE = "code";
    public static final String FUN_TYPE_MOBILE = "mobile";
    private static final Uri LOGIN_GET_CODE_URI = Uri.parse("content://com.snda.wifilocating.loginProvider/code");
    public static final String WK_LOGIN_GET_CODE_ACTION = "com.lantern.auth.action.CODE";
    public static final String WK_LOGIN_GET_CODE_ACTION_SUB = "com.lantern.auth.action.CODE.sub";
    public static final String WK_LOGIN_GET_CODE_MOBILE = "com.lantern.auth.action.MOBILE";
    public static final String WK_LOGIN_GET_PROFILE_ACTION_SUB = "com.lantern.auth.action.MOBILE.sub";
    private Context mContext;
    private Handler mHandler;
    private String mSid;
    private boolean isTimeout = false;
    private String funType = "";
    private BLCallback mBLCallBack = null;
    private Runnable mTimeoutRunable = new Runnable() { // from class: com.lantern.auth.provider.ClientLoginManager.1
        @Override // java.lang.Runnable
        public void run() {
            synchronized (ClientLoginManager.class) {
                ClientLoginManager.this.isTimeout = true;
                ClientLoginManager.funDC(FunDC.ID_AUTH_1081, ClientLoginManager.this.funType, ClientLoginManager.this.mSid);
                ClientLoginManager.this.runCallback(13, null, null);
            }
        }
    };
    private BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: com.lantern.auth.provider.ClientLoginManager.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            JSONObject jSONObject;
            int i = 0;
            BLLog.d("transf receive " + intent.getAction(), new Object[0]);
            synchronized (ClientLoginManager.class) {
                ClientLoginManager.this.unRegistReceiver();
                if (ClientLoginManager.this.isTimeout) {
                    return;
                }
                ClientLoginManager.this.mHandler.removeCallbacks(ClientLoginManager.this.mTimeoutRunable);
                String stringExtra = intent.getStringExtra("transf_info");
                BLLog.d("transf_info " + stringExtra, new Object[0]);
                if (!TextUtils.isEmpty(stringExtra)) {
                    i = 1;
                    if (ClientLoginManager.WK_LOGIN_GET_PROFILE_ACTION_SUB.equals(intent.getAction())) {
                        try {
                            jSONObject = new JSONObject(stringExtra);
                        } catch (JSONException e) {
                            BLLog.e(e);
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put("mobile", stringExtra);
                            } catch (JSONException unused) {
                                BLLog.e(e);
                            }
                            jSONObject = jSONObject2;
                        }
                        ClientLoginManager.this.runCallback(1, null, jSONObject);
                        return;
                    }
                }
                ClientLoginManager.this.runCallback(i, stringExtra, null);
            }
        }
    };

    public ClientLoginManager(String str) {
        this.mSid = "";
        BLLog.d("new constructor", new Object[0]);
        this.mHandler = new Handler();
        this.mContext = WkSDKManager.getContext();
        BLLog.d("new constructor mContext " + this.mContext, new Object[0]);
        this.mSid = str;
    }

    public static void funDC(int i, String str, String str2) {
        HashMap<String, String> mapGenExt = FunDC.genExt("funType", str);
        mapGenExt.put("sid", str2);
        FunDC.onEventById(i, mapGenExt);
    }

    private void registReceiver(String str) {
        try {
            unRegistReceiver();
        } catch (Exception e) {
            BLLog.e(e);
        }
        this.mContext.registerReceiver(this.mReceiver, new IntentFilter(str));
        BLLog.d("registerReceiver", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runCallback(final int i, final String str, final Object obj) {
        this.mHandler.post(new Runnable() { // from class: com.lantern.auth.provider.ClientLoginManager.3
            @Override // java.lang.Runnable
            public void run() {
                ClientLoginManager.this.unRegistReceiver();
                if (1 == i) {
                    ClientLoginManager.funDC(FunDC.ID_AUTH_1080, ClientLoginManager.this.funType, ClientLoginManager.this.mSid);
                } else {
                    ClientLoginManager.funDC(FunDC.ID_AUTH_1079, ClientLoginManager.this.funType, ClientLoginManager.this.mSid);
                }
                if (ClientLoginManager.this.mBLCallBack != null) {
                    ClientLoginManager.this.mBLCallBack.run(i, str, obj);
                }
                ClientLoginManager.this.mBLCallBack = null;
                ClientLoginManager.this.mHandler = null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runFail() {
        funDC(FunDC.ID_AUTH_1085, this.funType, this.mSid);
        this.mHandler.removeCallbacks(this.mTimeoutRunable);
        runCallback(0, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unRegistReceiver() {
        try {
            if (this.mReceiver != null) {
                BLLog.d("call unRegisterReceiver", new Object[0]);
                this.mContext.unregisterReceiver(this.mReceiver);
            }
        } catch (Exception unused) {
        }
    }

    public void getMobileNumber(long j, BLCallback bLCallback) {
        BLLog.d("call getMobileNumber", new Object[0]);
        this.funType = "mobile";
        this.mBLCallBack = bLCallback;
        registReceiver(WK_LOGIN_GET_PROFILE_ACTION_SUB);
        BLLog.d("registerReceiver finish", new Object[0]);
        Intent intent = new Intent("com.snda.wifilocating.auth.Transf");
        intent.putExtra("thirdPackage", this.mContext.getPackageName());
        intent.putExtra("thirdAppId", WkSDKManager.getAppId());
        intent.putExtra("getDetail", true);
        intent.setPackage("com.snda.wifilocating");
        intent.addFlags(402653184);
        try {
            this.mContext.startActivity(intent);
            this.mHandler.postDelayed(this.mTimeoutRunable, j);
            BLLog.d("startActivity wifi activity and  postDelay runnable", new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            funDC(FunDC.ID_AUTH_1084, this.funType, this.mSid);
            this.mHandler.removeCallbacks(this.mTimeoutRunable);
            runCallback(0, null, null);
        }
    }

    public void getcode(long j, final String str, BLCallback bLCallback) {
        this.funType = "code";
        if (TextUtils.isEmpty(str)) {
            Log.e("BLLog", "scope is empty");
            str = "BASE";
        }
        this.mBLCallBack = bLCallback;
        registReceiver(WK_LOGIN_GET_CODE_ACTION_SUB);
        try {
            this.mHandler.postDelayed(this.mTimeoutRunable, j);
            new Thread(new Runnable() { // from class: com.lantern.auth.provider.ClientLoginManager.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Cursor cursorQuery = ClientLoginManager.this.mContext.getContentResolver().query(ClientLoginManager.LOGIN_GET_CODE_URI, null, null, new String[]{WkSDKManager.getAppId(), ClientLoginManager.this.mContext.getPackageName(), str}, null);
                        if (cursorQuery != null) {
                            cursorQuery.close();
                            return;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    synchronized (ClientLoginManager.class) {
                        if (ClientLoginManager.this.mHandler != null && !ClientLoginManager.this.isTimeout) {
                            ClientLoginManager.this.mHandler.post(new Runnable() { // from class: com.lantern.auth.provider.ClientLoginManager.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ClientLoginManager.this.runFail();
                                }
                            });
                        }
                    }
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
            runFail();
        }
    }
}
