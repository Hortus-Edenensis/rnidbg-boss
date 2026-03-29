package com.bytedance.pangle;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.servermanager.MainServerManager;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.t;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class jk {
    private static volatile jk u;
    private boolean nr;
    private final List<ZeusPluginStateListener> fx = new CopyOnWriteArrayList();
    private final List<ZeusPluginEventCallback> b = new ArrayList();
    private final Handler pn = new Handler(Looper.getMainLooper());
    private ZeusPluginDecodeCallback iz = null;
    private Map<String, JSONObject> x = new ConcurrentHashMap();

    private void iz() {
        ProviderInfo[] providerInfoArr;
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_SERVER_MANAGER, "start");
        try {
            PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 8);
            if (packageInfo != null && (providerInfoArr = packageInfo.providers) != null) {
                for (ProviderInfo providerInfo : providerInfoArr) {
                    if (!TextUtils.isEmpty(providerInfo.authority)) {
                        if (providerInfo.authority.contains(Zeus.getAppApplication().getPackageName() + ".pangle.servermanager.")) {
                            String str = (TextUtils.isEmpty(providerInfo.processName) || !providerInfo.processName.contains(":")) ? "main" : providerInfo.processName.split(":")[1];
                            ProviderInfo providerInfo2 = Zeus.getServerManagerHashMap().get(str);
                            if ((providerInfo2 == null || !TextUtils.equals(str, "main") || !TextUtils.equals(providerInfo.name, MainServerManager.class.getName())) && (providerInfo2 == null || !TextUtils.equals(str, "downloader") || TextUtils.isEmpty(providerInfo2.authority) || !providerInfo2.authority.contains("com.bytedance.sdk.openadsdk.adhost"))) {
                                Zeus.getServerManagerHashMap().put(str, providerInfo);
                            }
                        }
                    }
                }
                GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_SERVER_MANAGER, "finish");
                return;
            }
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "initServerManager failed. packageInfo:".concat(String.valueOf(packageInfo)));
        } catch (Exception e) {
            GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_SERVER_MANAGER, "error:".concat(String.valueOf(e)));
            throw new RuntimeException(e);
        }
    }

    private Object[] n() {
        Object[] array;
        synchronized (this.b) {
            array = !this.b.isEmpty() ? this.b.toArray() : null;
        }
        return array == null ? new Object[0] : array;
    }

    public static jk u() {
        if (u == null) {
            synchronized (jk.class) {
                if (u == null) {
                    u = new jk();
                }
            }
        }
        return u;
    }

    private void x() {
        try {
            GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_COMMON, "invoke disableApiWarning");
            FieldUtils.writeField(com.bytedance.pangle.pn.u.u(), "mHiddenApiWarningShown", Boolean.TRUE);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager disableApiWarningShownForAndroidP, true");
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "disableApiWarningShownForAndroidP failed", e);
        }
    }

    public ZeusPluginDecodeCallback b() {
        return this.iz;
    }

    public List<ZeusPluginStateListener> fx() {
        return this.fx;
    }

    public boolean nr() {
        return this.nr;
    }

    public Map<String, JSONObject> pn() {
        return this.x;
    }

    public void nr(ZeusPluginStateListener zeusPluginStateListener) {
        List<ZeusPluginStateListener> list = this.fx;
        if (list != null) {
            list.remove(zeusPluginStateListener);
        }
    }

    public void nr(ZeusPluginEventCallback zeusPluginEventCallback) {
        if (zeusPluginEventCallback == null) {
            return;
        }
        synchronized (this.b) {
            this.b.remove(zeusPluginEventCallback);
        }
    }

    public synchronized void u(Application application) {
        if (this.nr) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager zeus has been inited!");
            return;
        }
        u(3000, 0, null, -1, null);
        Zeus.setAppContext(application);
        GlobalParam globalParam = GlobalParam.getInstance();
        globalParam.init();
        if (application != null) {
            ZeusLogger.setDebug(globalParam.isDebug());
            ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusManager init, context = " + application + ", hParam = " + globalParam);
            com.bytedance.pangle.pn.pn.nr(new Runnable() { // from class: com.bytedance.pangle.jk.1
                @Override // java.lang.Runnable
                public void run() {
                    t.nr();
                }
            });
            if (GlobalParam.getInstance().isPostBgDexOptByInit()) {
                com.bytedance.pangle.iz.iz.u();
            }
            com.bytedance.pangle.b.nr.u().u(new com.bytedance.pangle.b.u() { // from class: com.bytedance.pangle.jk.2
                @Override // com.bytedance.pangle.b.u
                public void u(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
                    com.bytedance.pangle.log.nr.u(str, jSONObject, jSONObject2, jSONObject3);
                }
            });
            if (!globalParam.isCloseFlipped()) {
                nr.u();
            }
            if (com.bytedance.pangle.util.a.o()) {
                com.bytedance.pangle.pn.pn.u(new Runnable() { // from class: com.bytedance.pangle.jk.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_COMMON, "invoke SystemConfig");
                            MethodUtils.invokeStaticMethod(Class.forName("com.android.server.SystemConfig"), "getInstance", new Object[0]);
                        } catch (Throwable th) {
                            GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_ERROR, "invoke SystemConfig error : ".concat(String.valueOf(th)));
                        }
                    }
                });
            }
            if (com.bytedance.pangle.util.a.k()) {
                x();
            }
            iz();
            ContentProviderManager.getInstance().initSystemContentProviderInfo();
            if (!globalParam.closeHookHuaweiOnInit()) {
                Zeus.hookHuaWeiVerifier(application);
            }
            this.nr = true;
            u(ZeusPluginEventCallback.EVENT_FINISH_INITIALIZATION, 0, null, -1, null);
            return;
        }
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_ERROR, "context is null");
        throw new IllegalArgumentException("context must be not null !!!");
    }

    public void u(ZeusPluginStateListener zeusPluginStateListener) {
        this.fx.add(zeusPluginStateListener);
    }

    public void u(ZeusPluginEventCallback zeusPluginEventCallback) {
        if (zeusPluginEventCallback == null) {
            return;
        }
        synchronized (this.b) {
            this.b.add(zeusPluginEventCallback);
        }
    }

    public void u(final int i, final int i2, @Nullable final String str, final int i3, @Nullable final Throwable th) {
        for (final Object obj : n()) {
            this.pn.post(new Runnable() { // from class: com.bytedance.pangle.jk.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ((ZeusPluginEventCallback) obj).onPluginEvent(i, i2, str, i3, th);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public void u(ZeusPluginDecodeCallback zeusPluginDecodeCallback) {
        this.iz = zeusPluginDecodeCallback;
    }
}
