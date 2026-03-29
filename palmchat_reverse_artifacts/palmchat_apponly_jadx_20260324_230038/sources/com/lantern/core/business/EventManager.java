package com.lantern.core.business;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import com.cxpt.core.event.configuration.service.ConfigService;
import com.igexin.sdk.PushConsts;
import com.lantern.core.business.SaveHandler;
import com.lantern.core.database.DataStoreManager;
import com.lantern.core.database.SqliteDataStore;
import com.lantern.core.log.MyLog;
import com.lantern.core.network.NEPublicMangers;
import com.wifi.ad.core.p001const.WifiNestConst;
import defpackage.cn1;
import defpackage.hn1;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class EventManager implements SaveHandler.SaveListener, SqliteDataStore.IDbErrListener {
    private static final int DURATION = 900000;
    private static final int MSG_FETCH_CONFIG = 1;
    private static final int MSG_RESUME_UPLOAD = 0;
    public static String PACKAGE_NAME;
    private final Context mContext;
    private NetworkCallbackImpl mNetworkCallback;
    private final IPubParams mPubParams;
    private final SaveHandler mSaveHandler;
    private final SendHandler mSendHandler;
    private final MyLog myLog;
    private final boolean openDBErr;
    private int openType;

    /* JADX INFO: compiled from: SearchBox */
    @TargetApi(21)
    public class NetworkCallbackImpl extends ConnectivityManager.NetworkCallback {
        private NetworkCallbackImpl() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(@NonNull Network network) {
            super.onAvailable(network);
            EventManager.this.scheduler();
            Log.i("CX_EVENT", "EventManager 检测到网络可用");
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(@NonNull Network network) {
            super.onLost(network);
            Log.i("CX_EVENT", "EventManager 检测到网络不可用");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @SuppressLint({"HandlerLeak"})
    public class SchedulerHandler extends Handler {
        private final WeakReference<EventManager> eventManager;

        public SchedulerHandler(EventManager eventManager) {
            this.eventManager = new WeakReference<>(eventManager);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (this.eventManager.get() == null) {
                return;
            }
            int i = message.what;
            if (i == 0) {
                hn1.a("yyhuang", "定时触发上报");
                EventManager.this.scheduler();
                sendEmptyMessageDelayed(0, 900000L);
            } else {
                if (i != 1) {
                    return;
                }
                EventManager.this.startConfigService();
                sendEmptyMessageDelayed(1, 3600000L);
            }
        }

        public void resume() {
            if (hasMessages(0)) {
                removeMessages(0);
            }
            sendEmptyMessage(0);
        }

        public void resumeConfig() {
            if (hasMessages(1)) {
                removeMessages(1);
            }
            sendEmptyMessage(1);
        }

        public void stop() {
            removeMessages(0);
        }
    }

    public EventManager(Context context, IPubParams iPubParams) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        PACKAGE_NAME = applicationContext.getPackageName();
        Log.i("#81062:::", "MDA.." + PACKAGE_NAME);
        this.mPubParams = iPubParams;
        cn1.b(iPubParams.getProcessName());
        this.openDBErr = iPubParams.openDbError();
        NEPublicMangers.getInstance().setPubParams(iPubParams);
        this.myLog = new MyLog(applicationContext, iPubParams);
        DataStoreManager dataStoreManager = new DataStoreManager(applicationContext);
        dataStoreManager.setDBErrListener(this);
        SaveHandler saveHandler = new SaveHandler(applicationContext, dataStoreManager, iPubParams);
        this.mSaveHandler = saveHandler;
        saveHandler.setSaveListener(this);
        this.mSendHandler = new SendHandler(applicationContext, dataStoreManager);
        SchedulerHandler schedulerHandler = new SchedulerHandler(this);
        schedulerHandler.resume();
        schedulerHandler.resumeConfig();
        registerReceiver();
        registerNetwork();
    }

    private void registerNetwork() {
        if (this.mNetworkCallback != null) {
            return;
        }
        this.mNetworkCallback = new NetworkCallbackImpl();
        try {
            NetworkRequest networkRequestBuild = new NetworkRequest.Builder().build();
            ConnectivityManager connectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
            if (connectivityManager != null) {
                connectivityManager.registerNetworkCallback(networkRequestBuild, this.mNetworkCallback);
                hn1.a("yyhuang", "Register ConnectivityManager");
            }
        } catch (Throwable th) {
            Log.e("CX_EVENT", "EventManager registerNetwork, ex:" + th.getMessage());
        }
    }

    private void registerReceiver() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
            intentFilter.addAction(PushConsts.ACTION_BROADCAST_USER_PRESENT);
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            this.mContext.registerReceiver(new BroadcastReceiver() { // from class: com.lantern.core.business.EventManager.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    hn1.a("yyhuang", "收到消息触发上报 action = " + intent.getAction());
                    EventManager.this.scheduler();
                }
            }, intentFilter);
        } catch (Throwable th) {
            Log.e("CX_EVENT", "EventManager registerReceiver, ex:" + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startConfigService() {
        try {
            this.mContext.startService(new Intent(this.mContext, (Class<?>) ConfigService.class));
        } catch (Throwable th) {
            Log.e("CX_EVENT", "EventManager startConfigService, ex:" + th.getMessage());
        }
    }

    public void addEvent(String str, String str2, String str3) {
        EventInfo eventInfo = new EventInfo();
        eventInfo.setEventId(str);
        eventInfo.setExtra(str3);
        eventInfo.setSource(str2);
        eventInfo.setCreateDateTime(System.currentTimeMillis());
        this.mSaveHandler.addEvent(eventInfo, this.openType);
        MyLog.event("", "add eventId = " + str);
    }

    @Override // com.lantern.core.database.SqliteDataStore.IDbErrListener
    public void dbError(String str) {
        if (this.openDBErr) {
            EventInfo eventInfo = new EventInfo();
            eventInfo.setEventId("dberror");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(WifiNestConst.OtherConst.KEY_MSG, str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            eventInfo.setExtra(jSONArray.toString());
            eventInfo.setCreateDateTime(System.currentTimeMillis());
            this.mSaveHandler.addDbError(eventInfo);
        }
    }

    public int getForceDnsIpv6() {
        IPubParams iPubParams = this.mPubParams;
        if (iPubParams == null) {
            return 0;
        }
        return iPubParams.getIpv6Config();
    }

    @Override // com.lantern.core.business.SaveHandler.SaveListener
    public void saveSuccess(Event event) {
        if (event.getLevel() == 1 || event.getLevel() == 2) {
            hn1.a("yyhuang", "收到事件[event：" + event.getEventId() + "，level：" + event.getLevel() + "]触发上报");
            this.mSendHandler.resume();
        }
    }

    public void scheduler() {
        SendHandler sendHandler = this.mSendHandler;
        if (sendHandler != null) {
            sendHandler.resume();
        }
    }

    public void sendImd() {
        this.mSendHandler.resume();
    }

    @Override // com.lantern.core.business.SaveHandler.SaveListener
    public void sendOnce(Event event) {
        this.mSendHandler.sendOnce(event);
    }

    public void setOpenType(int i) {
        this.openType = i;
    }

    public void uploadFiles() {
        this.myLog.upload();
    }

    @Override // com.lantern.core.business.SaveHandler.SaveListener
    public void saveFail(Event event) {
    }
}
