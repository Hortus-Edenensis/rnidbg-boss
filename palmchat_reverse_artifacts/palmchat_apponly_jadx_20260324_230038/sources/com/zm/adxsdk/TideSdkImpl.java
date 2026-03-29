package com.zm.adxsdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tide.host.HostManager;
import com.tide.host.model.TideHostConfig;
import com.tide.protocol.host.model.PluginEvent;
import com.tide.protocol.host.model.PluginEventType;
import com.tide.protocol.report.IFdaReporter;
import com.tide.protocol.transfer.TideEventBus;
import com.zm.adxsdk.TideSdkImpl;
import com.zm.adxsdk.protocol.api.WfConfig;
import com.zm.adxsdk.protocol.api.interfaces.IWfReporter;
import com.zm.adxsdk.protocol.variant.IWfSdk;
import com.zm.adxsdk.protocol.variant.InitCallback;
import com.zm.fda.FobDeviceIdClient;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class TideSdkImpl implements IWfSdk {
    public static final String d = "TideSdkImpl";
    public static volatile TideSdkImpl e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16595a;
    public String b;
    public IWfReporter c;

    public static /* synthetic */ void b() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        HostManager.getInstance().initPlugin("AdxSdk");
        Log.i(d, "initPlugin duration:" + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    public static TideSdkImpl getInstance() {
        if (e == null) {
            synchronized (TideSdkImpl.class) {
                if (e == null) {
                    e = new TideSdkImpl();
                }
            }
        }
        return e;
    }

    @Override // com.zm.adxsdk.protocol.variant.IWfSdk
    public void init(Context context, WfConfig wfConfig, final InitCallback initCallback) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        if (wfConfig != null) {
            TideHostConfig.Builder builder = new TideHostConfig.Builder();
            builder.appId(wfConfig.getAppId()).hostCode(this.f16595a).hostVersion(this.b).pluginName("AdxSdk").reporter(a());
            if (wfConfig.getWfRuntime() != null) {
                String oAid = wfConfig.getWfRuntime().getOAid();
                if (FobDeviceIdClient.checkoutOAID(oAid)) {
                    oAid = FobDeviceIdClient.getOaid();
                }
                if (TextUtils.isEmpty(oAid)) {
                    oAid = "";
                }
                builder.oaId(oAid).androidId(wfConfig.getWfRuntime().getAndroidId()).longitude(wfConfig.getWfRuntime().getLongitude()).latitude(wfConfig.getWfRuntime().getLatitude());
            }
            HostManager.getInstance().setHostConfig(builder.build());
        }
        TideEventBus.subscribe(PluginEvent.class, new TideEventBus.EventListener() { // from class: mx5
            @Override // com.tide.protocol.transfer.TideEventBus.EventListener
            public final void onEvent(Object obj) {
                TideSdkImpl.a(jCurrentTimeMillis, initCallback, (PluginEvent) obj);
            }
        });
        HostManager.getInstance().preload(context, "AdxSdk");
    }

    public void setSdkVersionCode(int i) {
        this.f16595a = i;
    }

    public void setSdkVersionName(String str) {
        this.b = str;
    }

    public void setWfReporter(IWfReporter iWfReporter) {
        this.c = iWfReporter;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class MgJg9 implements IFdaReporter {
        public MgJg9() {
        }

        @Override // com.tide.protocol.report.ITdReport
        public void onEvent(String str) {
            if (TideSdkImpl.this.c != null) {
                TideSdkImpl.this.c.onEvent(str);
            }
        }

        @Override // com.tide.protocol.report.ITdReport
        public void onEvent(String str, Map<String, Object> map) {
            if (TideSdkImpl.this.c != null) {
                TideSdkImpl.this.c.onEvent(str, map);
            }
        }

        @Override // com.tide.protocol.report.ITdReport
        public void onEvent(String str, JSONObject jSONObject) {
            if (TideSdkImpl.this.c != null) {
                TideSdkImpl.this.c.onEvent(str, jSONObject);
            }
        }
    }

    public static /* synthetic */ void a(long j, InitCallback initCallback, PluginEvent pluginEvent) {
        String pluginName = pluginEvent.getPluginName();
        PluginEventType type = pluginEvent.getType();
        if (TextUtils.equals(pluginName, "AdxSdk")) {
            if (type == PluginEventType.LOAD_SUCCESS) {
                new Thread(new Runnable() { // from class: nx5
                    @Override // java.lang.Runnable
                    public final void run() {
                        TideSdkImpl.b();
                    }
                }).start();
                return;
            }
            if (type == PluginEventType.RUN_SUCCESS) {
                Log.i(d, "RUN_SUCCESS duration:" + (System.currentTimeMillis() - j));
                if (initCallback != null) {
                    initCallback.onSuccess();
                    return;
                }
                return;
            }
            if (type == PluginEventType.CHECK_FAILED || type == PluginEventType.LOAD_FAILED || type == PluginEventType.RUN_FAILED) {
                Log.i(d, "LOAD_FAILED duration:" + (System.currentTimeMillis() - j));
                if (initCallback != null) {
                    initCallback.onFailed(0, "");
                }
            }
        }
    }

    public final IFdaReporter a() {
        return new MgJg9();
    }
}
