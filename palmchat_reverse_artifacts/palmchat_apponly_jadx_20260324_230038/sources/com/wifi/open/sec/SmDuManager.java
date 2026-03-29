package com.wifi.open.sec;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import cn.shuzilm.core.Listener;
import cn.shuzilm.core.Main;
import com.lantern.auth.server.WkParams;
import com.wifi.open.sec.SmDuManager;
import defpackage.rb3;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class SmDuManager {
    private static final String DU_API_KEY = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJ0bEDHbLdclI8N5TSWg1BUQ7S8N+nP4PdtBNqWaZpBoCFfSdun3upGSBccvXIhoMszwjNv5nBaMphqrfumtR9UCAwEAAQ==";
    private static String sChannel;
    private static Context sContext;
    private static String sOptMsg;
    private static AtomicReference<String> dudid = new AtomicReference<>(null);
    private static AtomicReference<String> duLabel = new AtomicReference<>(null);
    private static AtomicBoolean isInit = new AtomicBoolean(false);
    private static CountDownLatch initLock = new CountDownLatch(1);
    private static AtomicBoolean _initied = new AtomicBoolean(false);
    private static boolean needInit = true;

    private SmDuManager() {
    }

    public static void Get(StringCallback stringCallback) {
        if (isNeedInit() && stringCallback != null) {
            getDeviceIdAsync(stringCallback);
        }
    }

    public static void addInitCallback(final StringCallback stringCallback) {
        Log.i("WKDu", "addInitCallback start1");
        try {
            new Thread(new Runnable() { // from class: ef5
                @Override // java.lang.Runnable
                public final void run() {
                    SmDuManager.lambda$addInitCallback$4(stringCallback);
                }
            }).start();
        } catch (Throwable unused) {
        }
    }

    public static String getDeviceId() {
        return dudid.get();
    }

    private static void getDeviceIdAsync(final StringCallback stringCallback) {
        Log.i("WKDu", "getDeviceIdAsync start1");
        String str = dudid.get();
        if (TextUtils.isEmpty(str)) {
            try {
                new Thread(new Runnable() { // from class: ff5
                    @Override // java.lang.Runnable
                    public final void run() {
                        SmDuManager.lambda$getDeviceIdAsync$2(stringCallback);
                    }
                }).start();
            } catch (Throwable unused) {
            }
        } else {
            Log.i("WKDu", "getDeviceIdAsync start2");
            if (stringCallback != null) {
                stringCallback.callback(str);
            }
        }
    }

    private static void getDuIDImp(StringCallback stringCallback) {
        Log.i("WKDuInfo", "getQueryID_start  callback =" + stringCallback + "sChannel=" + sChannel);
        String queryID = Main.getQueryID(sContext, sChannel, sOptMsg, true);
        Log.i("WKDuInfo", "getQueryID_handler end " + queryID + " callback =" + stringCallback);
        if (!TextUtils.isEmpty(queryID)) {
            dudid.set(queryID);
        }
        if (stringCallback != null) {
            stringCallback.callback(queryID);
        }
    }

    public static String getDuLabel() {
        return duLabel.get();
    }

    public static void getDuLabelAsync(final StringCallback stringCallback) {
        Log.i("WKDu", "getDuLabelAsync start1");
        String str = duLabel.get();
        if (TextUtils.isEmpty(str)) {
            try {
                new Thread(new Runnable() { // from class: hf5
                    @Override // java.lang.Runnable
                    public final void run() {
                        SmDuManager.lambda$getDuLabelAsync$3(stringCallback);
                    }
                }).start();
            } catch (Throwable unused) {
            }
        } else {
            Log.i("WKDu", "getDuLabelAsync start2");
            if (stringCallback != null) {
                stringCallback.callback(str);
            }
        }
    }

    private static void getDuLabelImp(final StringCallback stringCallback) {
        Log.i("WKDuInfo", "getDeviceLabel_handler start callback =" + stringCallback);
        Main.getDeviceLabel(0, new Listener() { // from class: com.wifi.open.sec.SmDuManager.2
            @Override // cn.shuzilm.core.Listener
            public void handler(String str) {
                Log.i("WKDuInfo", "getDeviceLabel_handler result=" + str + " callback =" + stringCallback);
                if (!TextUtils.isEmpty(str)) {
                    SmDuManager.duLabel.set(str);
                }
                StringCallback stringCallback2 = stringCallback;
                if (stringCallback2 != null) {
                    stringCallback2.callback(str);
                }
            }
        });
        Log.i("WKDuInfo", "getDeviceLabel_handler end");
    }

    public static void init(Context context, String str, String str2) {
        if (isNeedInit() && !_initied.getAndSet(true)) {
            initImp(context, str, str2);
        }
    }

    private static void initImp(final Context context, String str, String str2) {
        if (isInit.getAndSet(true)) {
            return;
        }
        sChannel = rb3.c(str);
        sOptMsg = str2;
        sContext = context;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: if5
            @Override // java.lang.Runnable
            public final void run() {
                SmDuManager.lambda$initImp$1(context);
            }
        });
    }

    public static void initOnReady(Context context, String str, String str2) {
        needInit = true;
        init(context, str, str2);
        Get(new StringCallback() { // from class: com.wifi.open.sec.SmDuManager.1
            @Override // com.wifi.open.sec.StringCallback
            public final void callback(String str3) {
                TextUtils.isEmpty(str3);
            }
        });
    }

    public static boolean isNeedInit() {
        return needInit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$addInitCallback$4(StringCallback stringCallback) {
        try {
            Log.i("WKDu", "addInitCallback start2");
            initLock.await();
            Log.i("WKDu", "addInitCallback start3");
            synchronized (SmDuManager.class) {
                Log.i("WKDu", "addInitCallback start4");
                if (stringCallback != null) {
                    stringCallback.callback(null);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getDeviceIdAsync$2(StringCallback stringCallback) {
        try {
            Log.i("WKDu", "getDeviceIdAsync start3");
            initLock.await();
            Log.i("WKDu", "getDeviceIdAsync start3.4");
            synchronized (SmDuManager.class) {
                Log.i("WKDu", "getDeviceIdAsync start3.5");
                String str = dudid.get();
                if (TextUtils.isEmpty(str)) {
                    Log.i("WKDu", "getDeviceIdAsync start4");
                    getDuIDImp(stringCallback);
                } else {
                    if (stringCallback != null) {
                        stringCallback.callback(str);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getDuLabelAsync$3(StringCallback stringCallback) {
        try {
            Log.i("WKDu", "getDuLabelAsync start3");
            initLock.await();
            Log.i("WKDu", "getDuLabelAsync start3.4");
            synchronized (SmDuManager.class) {
                Log.i("WKDu", "getDuLabelAsync start3.5");
                String str = duLabel.get();
                if (TextUtils.isEmpty(str)) {
                    Log.i("WKDu", "getDuLabelAsync start4");
                    getDuLabelImp(stringCallback);
                } else {
                    if (stringCallback != null) {
                        stringCallback.callback(str);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initImp$0() {
        try {
            synchronized (SmDuManager.class) {
                if (TextUtils.isEmpty(dudid.get())) {
                    Log.i("WKDu", "init start2");
                    getDuIDImp(null);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initImp$1(Context context) {
        try {
            Log.i("WKDu", "init start1");
            Main.init(context, DU_API_KEY, false);
            Main.setConfig(WkParams.IMEI, "1");
            Main.setConfig("cdlmt", "1");
            Main.setConfig("pkglist", "1");
            Main.setConfig("wifi", "1");
            initLock.countDown();
            Log.i("WKDu", "init start1.1");
            new Thread(new Runnable() { // from class: gf5
                @Override // java.lang.Runnable
                public final void run() {
                    SmDuManager.lambda$initImp$0();
                }
            }).start();
        } catch (Throwable unused) {
        }
    }

    public static void setNeedInit(boolean z) {
        needInit = z;
    }
}
