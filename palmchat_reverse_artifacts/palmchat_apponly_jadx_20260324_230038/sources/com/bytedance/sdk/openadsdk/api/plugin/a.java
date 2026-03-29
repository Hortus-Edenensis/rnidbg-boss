package com.bytedance.sdk.openadsdk.api.plugin;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginDecodeCallback;
import com.bytedance.pangle.ZeusPluginInstallListener;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.log.IZeusLogger;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import dalvik.system.BaseDexClassLoader;
import defpackage.ji7;
import defpackage.wc7;
import j$.util.function.Function$CC;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a {
    private static volatile BaseDexClassLoader b;
    private static volatile TTPluginListener l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f5191a;
    private static final String u = "next" + File.separator;
    private static final HashMap<String, TTPluginListener> nr = new HashMap<>();
    private static final HashMap<String, Handler> fx = new HashMap<>();
    private static volatile a pn = null;
    private final CountDownLatch iz = new CountDownLatch(1);
    private volatile boolean x = false;
    private volatile String n = "none";
    private JSONObject jk = new JSONObject();
    private EventListener t = null;

    /* JADX INFO: compiled from: SearchBox */
    public static final class nr implements IZeusLogger {
        private nr() {
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void e(String str, String str2, Throwable th) {
            com.bytedance.sdk.openadsdk.api.iz.pn(str, str2, th);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void i(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.iz.fx(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void v(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.iz.u(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void w(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.iz.b(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void w(String str, String str2, Throwable th) {
            com.bytedance.sdk.openadsdk.api.iz.b(str, str2, th);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class u {
        public int b;
        public String fx;
        public int iz;
        public String pn;
        public String x;
        public String u = "";
        public File nr = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5192a = 0;
        public int jk = Integer.MAX_VALUE;
        public List<String> n = null;

        public boolean u() {
            return this.iz == 3;
        }
    }

    private a(Context context) {
        this.f5191a = context.getApplicationContext();
        try {
            GlobalParam.getInstance().closeHookHuaweiOnInit(true);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.iz.b("TTPluginManager", "Unexpected error for closeHookHuaweiOnInit.", th);
        }
        nr(context.getApplicationContext());
        Plugin plugin = Zeus.getPlugin("com.byted.pangle");
        if (plugin != null) {
            plugin.setApiBridge(com.bytedance.sdk.openadsdk.fx.b.u());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        Plugin plugin = Zeus.getPlugin(str, false);
        try {
            if (plugin.mClassLoader != null) {
                TTAdSdk.getAdManager().register(wc7.c(3).f(0, 1).i(1, str).h(2, plugin.mClassLoader).a().sparseArray());
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.iz.nr("TTPluginManager", "initPluginService failed in " + str, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static u pn(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return u(new JSONObject(str));
        } catch (JSONException unused) {
            com.bytedance.sdk.openadsdk.api.iz.pn("TTPluginManager", "Invalid plugin info:" + str);
            return null;
        }
    }

    private static File fx(Context context) {
        return new File(com.bytedance.sdk.openadsdk.api.plugin.nr.u(context, "tt_pangle_bykv_file", 0), u);
    }

    private void nr(Context context) {
        try {
            com.bytedance.pangle.pn.pn.u(new com.bytedance.pangle.iz() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.1
                @Override // com.bytedance.pangle.iz
                public void fx(Runnable runnable) {
                    new Handler(Looper.getMainLooper()).post(runnable);
                }

                @Override // com.bytedance.pangle.iz
                public void nr(Runnable runnable) {
                    com.bytedance.sdk.openadsdk.sx.u.u().fx().execute(runnable);
                }

                @Override // com.bytedance.pangle.iz
                public void u(Runnable runnable) {
                    com.bytedance.sdk.openadsdk.sx.u.u().fx().execute(runnable);
                }
            });
            IZeusReporter iZeusReporter = new IZeusReporter() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.2
                @Override // com.bytedance.pangle.log.IZeusReporter
                public void report(String str, JSONObject jSONObject) {
                    if ("load_finish".equals(str) && jSONObject != null && "com.byted.pangle".endsWith(jSONObject.optString("plugin_package_name"))) {
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("duration", jSONObject.opt("duration"));
                            jSONObject2.put("message", jSONObject.opt("message"));
                            a.this.jk.put("zeus", jSONObject2);
                        } catch (Exception e) {
                            com.bytedance.sdk.openadsdk.api.iz.u(e);
                        }
                    }
                    if (TTAdSdk.isInitSuccess()) {
                        iz.u(str, jSONObject);
                    } else {
                        iz.nr(str, jSONObject);
                    }
                }

                @Override // com.bytedance.pangle.log.IZeusReporter
                public void saveRecord(String str, String str2) {
                    pn.u(str, str2);
                }
            };
            com.bytedance.pangle.pn.pn.u(new com.bytedance.pangle.iz() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.3
                @Override // com.bytedance.pangle.iz
                public void fx(Runnable runnable) {
                    new Handler(Looper.getMainLooper()).post(runnable);
                }

                @Override // com.bytedance.pangle.iz
                public void nr(Runnable runnable) {
                    com.bytedance.sdk.openadsdk.sx.u.u().fx().execute(runnable);
                }

                @Override // com.bytedance.pangle.iz
                public void u(Runnable runnable) {
                    com.bytedance.sdk.openadsdk.sx.u.u().fx().execute(runnable);
                }
            });
            GlobalParam globalParam = GlobalParam.getInstance();
            globalParam.setReporter(iZeusReporter);
            globalParam.setCheckPermission(false);
            globalParam.setDownloadDir(fx(context));
            globalParam.setLogger(new nr());
            globalParam.setSignature("com.byted.pangle", "MIIDfTCCAmWgAwIBAgIEfRwYPjANBgkqhkiG9w0BAQsFADBvMQswCQYDVQQGEwJDTjEQMA4GA1UECBMHQmVpamluZzEQMA4GA1UEBxMHQmVpamluZzESMBAGA1UEChMJQnl0ZURhbmNlMQ8wDQYDVQQLEwZQYW5nbGUxFzAVBgNVBAMTDkNodWFuIFNoYW4gSmlhMB4XDTIxMTEwODA2MjQzOVoXDTQ2MTEwMjA2MjQzOVowbzELMAkGA1UEBhMCQ04xEDAOBgNVBAgTB0JlaWppbmcxEDAOBgNVBAcTB0JlaWppbmcxEjAQBgNVBAoTCUJ5dGVEYW5jZTEPMA0GA1UECxMGUGFuZ2xlMRcwFQYDVQQDEw5DaHVhbiBTaGFuIEppYTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAIBKeRL+4mfCn1SLYv6OemfwwItkjlLPyqOEugkV6lanFTcZgLwEl5LIkL0y28UncPtMX1Mii6DzCdJ/plw7S9+RT/hYDneu339IKWojaU2qai/5FokHlQ0MMnYl5yry00ghVPsl1u+03cQA2ZnjIMiFhrBJpQzHt7IYvq2aEEMBcY8uT7iFoBI848e1mL1joVS2z02C3NliP7ZNARkXH+rTQAlCJulT5IZk+V/PTaKqzgNrkhsKh0/tBmU7m8u79x/xpgGsE19H18AgS4P/9/MDCRe2Z35boZeccaUy2MXCwv3djzUcDk3rRzQPYzdpyyRnrFMuhiKesc5VHgUMs9kCAwEAAaMhMB8wHQYDVR0OBBYEFENENrNWGzc2WhxdvhoMDs57U70zMA0GCSqGSIb3DQEBCwUAA4IBAQAHqDCrmvyBBmIGXwuL1rwS/Qv9ZJIZykBIaNMm+H1IfitCl4yXd9N2n+PjE0UZtxZ21UZOt9wAr+RFiSl5YRXqpt7WLARTy4YW3RiQ+wiL7bshzeSYBoSiC427Bfeq0WjwY0/jHlr8uouppyJOz++6U9hrYX2EW/6UjH5XlWiKQJ6b2ZzPcP8Xpg/TJn4tWvXJP6jw9kRRP2GmMttY78leWQst2QEZILmWJubXRLPj9O+qx2uP9oGTD4sc1vb9hzkOHBIHzGaalqLFbbGaeFpLFHoGTsnOfPTwUVKDZYmxbkcmR1bp7eYOW+nSQNMLn0FjDewZl5l37Sa/gz0WVHon");
            globalParam.setSignature("com.byted.csj.ext", "MIIDezCCAmOgAwIBAgIENkE1KDANBgkqhkiG9w0BAQsFADBtMQswCQYDVQQGEwI4NjEQMA4GA1UECBMHYmVpamluZzEQMA4GA1UEBxMHYmVpamluZzESMBAGA1UEChMJYnl0ZWRhbmNlMRIwEAYDVQQLEwlieXRlZGFuY2UxEjAQBgNVBAMTCWJ5dGVkYW5jZTAgFw0yMjExMDIwODI3MzlaGA8yMDUwMDMyMDA4MjczOVowbTELMAkGA1UEBhMCODYxEDAOBgNVBAgTB2JlaWppbmcxEDAOBgNVBAcTB2JlaWppbmcxEjAQBgNVBAoTCWJ5dGVkYW5jZTESMBAGA1UECxMJYnl0ZWRhbmNlMRIwEAYDVQQDEwlieXRlZGFuY2UwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCc9Z2F3xxOMX1qTXMy2aPmS9OSkqrp8C8bHwS1hkNVR4umKREuqOn73INNo+R706jaCVnlPwxDwWjtX6H74DE4CveivyM9f2wNC3yIyDW+5j7lW/keTQcOlGLDEJQv4O/6FbB/jNU6epjyNaNIZhgZcvTpgaSixbdyHzRTFmvMh+WovdVK/J9LnHOQ+pmPZj7NB6MQRGMUrPEotLHQca3cmnLrnPAaZQaVoaFE9lOt9syyqEuf361SprNIGDtbkJuX3EqV/QOKWFwZX94IS7ZGSvfyCojcD4kaUSbaSoZC7zEuBb7l69g+ZMrJ/v6wkm01wxsNNssUwF7k6Sp0zubbAgMBAAGjITAfMB0GA1UdDgQWBBSxk+gVdDco1dP65hP67qoKNlMEYDANBgkqhkiG9w0BAQsFAAOCAQEAfosExl/AYEbS2xqHBTHa28cvnp/SElUQuzW6aWLqkfk9cxmFSI/euUV3/eB8RN+U2X47Y05u6+XUxTv0tSSEtyXNawm0qWH8jkR4gZY38YqBChKjhea668oT5X3Uocrw7SYXO/BfI8SKPa0uI/U8Cyl3uctbmmq/pPUkd3mKAy+HgyJoThD6K0oyiADlygngUMVTv6Uvid4qPj/bBnxI+LvVeX4l1dxGqWkiafQW9sz+RbFdge3X2XsSH4eo01BsCwOYEv1lHO2FrbAtFNpnIsSqrERdFaAJZ3tlJmg9bA03png8A2AajEjkhaOhduJB8zkSlvHNpoQMIAS9WtkG/w==");
            globalParam.setSignature("com.byted.live.lite", "MIIDSTCCAjGgAwIBAgIEaLy5tzANBgkqhkiG9w0BAQsFADBVMQswCQYDVQQGEwIxMTEMMAoGA1UECBMDMTExMQ4wDAYDVQQHEwUxMTExMTEMMAoGA1UEChMDMTExMQwwCgYDVQQLEwMxMTExDDAKBgNVBAMTAzExMTAeFw0yMDEyMDMxMjQyMTJaFw00NTExMjcxMjQyMTJaMFUxCzAJBgNVBAYTAjExMQwwCgYDVQQIEwMxMTExDjAMBgNVBAcTBTExMTExMQwwCgYDVQQKEwMxMTExDDAKBgNVBAsTAzExMTEMMAoGA1UEAxMDMTExMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA45E52YdkJm4gPCXZq7KDoM1h6pgSswllC/CwDOmh8pDGvX4ROaYP1vr2biRlXMHg7G0iXpxWVdlTtx+4QFd3dC+cGJQk0f6apGo2n2RpMA0zIsSf0VO1a3GjWLei5INo+4RDdciqJ4jfsoqBIjZETRkky+UU4eO/oyrAwOu4KdMln3Bg3u7eHWU4kMFrXxrRruT3Q/9gzlO90yQa0CZPWVDrk6cGJtJwJGhWm+62S3U8D26HE++eGP7ve83QBDGtKqx7HpCAFWUiYBgXGq12H0amQDkKcPcr/EFCaBlombSgkN0t6zBX80m+wcUPC75IBTmMV/DT2dXcgjZ2I1JSCQIDAQABoyEwHzAdBgNVHQ4EFgQUPDyIeKI0KhZFPHyn36gMMIYrpukwDQYJKoZIhvcNAQELBQADggEBAHkl0DoCRwn+XKsDJE+wGMpBBqUDzL6DSOnJx4SNqb7YZZU0ThcDK7jY4If3QRkvMio6ODrVZc2U/m/Tc3VeMk5h2W2UZRUWHNH3k9Xe0720uL20ZeH2Y6IG4L5HG8kIbTbFtX3gJpPG/xAcez+CzyCFLWQAZt1N+csG0syWkXJ0Nryq8VrgSCyCXD1KzFxrOe+65wtu50Vi68Vlbk7BZe/G8Qm0RhKmxq5BPMBJ4uY3be+03Ba5qC//o1XQHOEAjrJKXcN5wqHdFZTkmuxVyIPogZOzx4JlNl0zOrYGDJxp7aZfKF9FkXQyF7x0Ns3mZEtjx/+flXRzAAU9MDhPr/0=");
            Zeus.registerPluginStateListener(new ZeusPluginStateListener() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.4
                @Override // com.bytedance.pangle.ZeusPluginStateListener
                public void onPluginStateChange(String str, int i, Object... objArr) {
                    com.bytedance.sdk.openadsdk.api.iz.nr("TTPluginManager", str + " state changed, " + i);
                    if (i != 9 || TextUtils.equals(str, "com.byted.pangle")) {
                        return;
                    }
                    a.this.b(str);
                }
            });
            Zeus.setDecodeCallback(new ZeusPluginDecodeCallback() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.5
                @Override // com.bytedance.pangle.ZeusPluginDecodeCallback
                public String decode(String str) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        String strOptString = jSONObject.optString("cypher");
                        String strOptString2 = jSONObject.optString("message");
                        if (!TextUtils.equals(strOptString, "3") || TextUtils.isEmpty(strOptString2)) {
                            return null;
                        }
                        return com.bytedance.sdk.openadsdk.api.plugin.fx.nr.nr(strOptString2);
                    } catch (Throwable th) {
                        com.bytedance.sdk.openadsdk.api.iz.nr("TTPluginManager", "dex plugin decode throw error ".concat(String.valueOf(th)));
                        return null;
                    }
                }
            });
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isDexPlugin", 1);
                jSONObject.put("apiVersionCode", 1000);
                jSONObject.put("packageName", "com.byted.mixed");
                jSONObject.put("hostPackageName", "com.byted.pangle");
                jSONObject.put("minPluginVersion", 1000);
                jSONObject.put("maxPluginVersion", 999999999);
                jSONObject.put("internalPath", "");
                jSONObject.put("internalVersionCode", -1);
                jSONObject.put(com.heytap.mcssdk.constant.b.z, "");
                jSONObject.put("appSecretKey", "");
                Zeus.addPackageDexManager("com.byted.mixed", jSONObject);
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.iz.nr("TTPluginManager", "init dex plugin config throw error " + th);
            }
            globalParam.closeBgDex2oat(true);
            Zeus.init((Application) context);
            Zeus.registerPluginInstallListener(new ZeusPluginInstallListener() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.6
                @Override // com.bytedance.pangle.ZeusPluginInstallListener
                public void onPluginInstall(String str, int i, String str2) {
                    if (i == 7) {
                        a.this.nr(str, i);
                        return;
                    }
                    if (i == 6) {
                        a.this.nr(str, i);
                        if (a.this.t == null || !"com.byted.pangle".equals(str)) {
                            com.bytedance.sdk.openadsdk.api.iz.nr("TTPluginManager", "no main pl");
                        } else {
                            a.this.t.onEvent(0, ji7.b().f(true).a());
                        }
                    }
                }
            });
            this.x = true;
        } catch (Throwable th2) {
            com.bytedance.sdk.openadsdk.api.iz.b("TTPluginManager", "Unexpected error for init zeus.", th2);
            this.n = th2.getMessage();
        }
        PluginManager pluginManager = PluginManager.getInstance();
        pluginManager.registerPlugin("{apiVersionCode:7232,packageName:com.byted.pangle,minPluginVersion:7232,internalPath:'',internalVersionCode:7232}");
        pluginManager.registerPlugin("{apiVersionCode:999,packageName:com.byted.csj.ext,minPluginVersion:1000,maxPluginVersion:999999999,internalPath:'',internalVersionCode:-1,appKey:'',appSecretKey:''}");
        pluginManager.registerPlugin("{apiVersionCode:2114,packageName:com.byted.live.lite,minPluginVersion:211400,maxPluginVersion:999999,isSupportLibIsolate:true}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fx(String str, int i) {
        com.bytedance.sdk.openadsdk.api.iz.b("TTPluginManager", "plugin update failed");
        Bundle bundle = new Bundle();
        bundle.putInt("code", i);
        TTPluginListener tTPluginListener = nr.get(str);
        if (tTPluginListener != null) {
            tTPluginListener.onPluginListener(1001, null, null, bundle);
        }
    }

    public static a u(Context context) {
        if (pn == null) {
            synchronized (a.class) {
                if (pn == null) {
                    pn = new a(context);
                }
            }
        }
        return pn;
    }

    private static boolean b(Context context) {
        File fileFx = fx(context);
        return fileFx.exists() && fileFx.listFiles().length != 0;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class fx implements Serializable, Function<SparseArray<Object>, Object> {
        @Override // java.util.function.Function
        public /* synthetic */ Function andThen(Function function) {
            return Function$CC.$default$andThen(this, function);
        }

        public /* synthetic */ Function compose(Function function) {
            return Function$CC.$default$compose(this, function);
        }

        @Override // java.util.function.Function
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public Object apply(SparseArray<Object> sparseArray) {
            if (sparseArray == null) {
                return null;
            }
            ValueSet valueSetA = wc7.k(sparseArray).a();
            int iIntValue = valueSetA.intValue(-99999987);
            SparseArray sparseArray2 = (SparseArray) valueSetA.objectValue(-99999979, SparseArray.class);
            if (sparseArray2 == null) {
                return null;
            }
            ValueSet valueSetA2 = wc7.k(sparseArray2).a();
            return u(iIntValue, ji7.b().c(valueSetA2.intValue(-999900)).e(valueSetA2.stringValue(-999901)).f(valueSetA2.booleanValue(-999903)).d(wc7.k((SparseArray) valueSetA2.objectValue(-999902, SparseArray.class)).a()).a());
        }

        public SparseArray<Object> u(int i, Result result) {
            wc7 wc7VarB = wc7.b();
            if (i == 1) {
                pn.u("plugin_download", "plugin update start");
                ValueSet valueSetValues = result.values();
                if (valueSetValues == null) {
                    pn.u("plugin_download", "valueSet empty");
                    return null;
                }
                String strStringValue = valueSetValues.stringValue(3);
                int iCode = result.code();
                if (result.isSuccess()) {
                    u uVarPn = a.pn(valueSetValues.stringValue(2));
                    if (uVarPn != null && !TextUtils.isEmpty(uVarPn.fx)) {
                        pn.u("plugin_download", "plugin update received: " + uVarPn.fx);
                        com.bytedance.sdk.openadsdk.api.iz.b("TTPluginManager", "plugin update received: " + uVarPn.fx);
                        if (uVarPn.u()) {
                            pn.u("plugin_download", "plugin revert " + uVarPn.fx);
                            Zeus.unInstallPlugin(uVarPn.fx);
                        } else {
                            u(uVarPn);
                            pn.u("plugin_download", "plugin install");
                            if (a.nr(uVarPn)) {
                                wc7VarB.j(4, true);
                            }
                        }
                    } else {
                        pn.u("plugin_download", "plugin update received with invalid config");
                        com.bytedance.sdk.openadsdk.api.iz.b("TTPluginManager", "plugin update received with invalid config");
                        return null;
                    }
                } else {
                    pn.u("plugin_download", "plugin update received failed");
                    com.bytedance.sdk.openadsdk.api.iz.b("TTPluginManager", "plugin update received failed");
                    a.fx(strStringValue, iCode);
                    return null;
                }
            }
            return wc7VarB.a().sparseArray();
        }

        private void u(u uVar) {
            try {
                if (TextUtils.isEmpty(uVar.fx) || !uVar.fx.equals("com.byted.pangle")) {
                    return;
                }
                a.u(TTAppContextHolder.getContext()).nr();
            } catch (Exception unused) {
            }
        }
    }

    public JSONObject u() {
        return this.jk;
    }

    public BaseDexClassLoader u(x xVar, int i) throws Exception {
        boolean z;
        String str;
        if (this.x) {
            boolean zNr = com.bytedance.sdk.openadsdk.api.plugin.fx.fx.nr();
            int i2 = 8;
            if (!Zeus.isPluginInstalled("com.byted.pangle")) {
                if (zNr) {
                    new n(this.f5191a).u();
                }
                if (b(this.f5191a)) {
                    Zeus.installFromDownloadDir();
                }
                try {
                    if (!zNr) {
                        com.bytedance.sdk.openadsdk.api.iz.nr("TTPluginManager", "dont wait pl");
                    } else {
                        com.bytedance.sdk.openadsdk.api.iz.nr("TTPluginManager", "wait start");
                        this.iz.await(i, TimeUnit.MILLISECONDS);
                    }
                    com.bytedance.sdk.openadsdk.api.iz.nr("TTPluginManager", "wait done");
                    xVar.nr("wait_install_cost");
                } catch (Exception unused) {
                    com.bytedance.sdk.openadsdk.api.iz.nr("TTPluginManager", "Install wait time out");
                    throw new b(8, "install wait timeout");
                }
            }
            if (Zeus.isPluginLoaded("com.byted.pangle") || Zeus.loadPlugin("com.byted.pangle")) {
                b = Zeus.getPlugin("com.byted.pangle").mClassLoader;
                z = true;
            } else {
                z = false;
            }
            xVar.nr("get_classloader_cost");
            Zeus.installFromDownloadDir();
            if (b == null) {
                if (this.iz.getCount() != 0) {
                    if (zNr) {
                        i2 = 10;
                        str = "this device does not support arm64-v8a, and install wait time out";
                    } else {
                        str = "install wait time out";
                    }
                    com.bytedance.sdk.openadsdk.api.iz.b("TTPluginManager", "Install wait time out");
                    throw new b(i2, str);
                }
                if (z) {
                    com.bytedance.sdk.openadsdk.api.iz.b("TTPluginManager", "Get null after load");
                    throw new b(9, "Get null after load");
                }
            }
            xVar.nr("get_classloader_done");
            return b;
        }
        com.bytedance.sdk.openadsdk.api.iz.b("TTPluginManager", "Zeus init failed.");
        throw new b(4, this.n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(String str, int i) {
        if ("com.byted.pangle".equals(str) && i == 6) {
            com.bytedance.sdk.openadsdk.api.iz.b("TTPluginManager", "notify to end wait");
            this.iz.countDown();
        }
        u(i == 6, str);
    }

    public static String nr(String str) {
        int installedMaxVer;
        try {
            Plugin plugin = Zeus.getPlugin(str, false);
            if (plugin == null || (installedMaxVer = plugin.getInstalledMaxVer()) <= 0) {
                return null;
            }
            return u(installedMaxVer);
        } catch (Throwable unused) {
            com.bytedance.sdk.openadsdk.api.iz.b("TTPluginManager", "Get local version failed");
            return null;
        }
    }

    public Bundle u(String str, Bundle bundle) {
        String strU = u(str);
        if (!TextUtils.isEmpty(strU)) {
            bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, strU);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(str, bundle);
        Bundle bundle3 = new Bundle();
        bundle3.putBundle(PluginConstants.KEY_PL_CONFIG_INFO, bundle2);
        return bundle3;
    }

    public void nr(TTPluginListener tTPluginListener) {
        String strPackageName = tTPluginListener.packageName();
        Plugin plugin = (Zeus.isPluginInstalled(strPackageName) && (Zeus.isPluginLoaded(strPackageName) || Zeus.loadPlugin(strPackageName))) ? Zeus.getPlugin(strPackageName) : null;
        StringBuilder sb = new StringBuilder("Find plugin:");
        sb.append(plugin != null);
        com.bytedance.sdk.openadsdk.api.iz.nr("TTPluginManager", sb.toString());
        if (plugin != null) {
            u(plugin);
            tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
        } else {
            l = tTPluginListener;
        }
    }

    public static String u(String str) {
        Context context;
        Plugin plugin;
        try {
            if (!Zeus.isPluginInstalled(str, false) || (plugin = Zeus.getPlugin(str, false)) == null) {
                return null;
            }
            return u(plugin.getVersion());
        } finally {
            if (context != null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean nr(u uVar) {
        File file;
        if (uVar != null && (file = uVar.nr) != null) {
            boolean zSyncInstallPlugin = Zeus.syncInstallPlugin(uVar.fx, file.getAbsolutePath());
            u(zSyncInstallPlugin, uVar.fx);
            return zSyncInstallPlugin;
        }
        com.bytedance.sdk.openadsdk.api.iz.b("TTPluginManager", "plugin config is null");
        return false;
    }

    public void nr() {
        EventListener eventListener = this.t;
        if (eventListener != null) {
            eventListener.onEvent(1, ji7.b().f(true).a());
        }
    }

    public void u(final TTPluginListener tTPluginListener) {
        if (!this.x) {
            com.bytedance.sdk.openadsdk.api.iz.b("TTPluginManager", "Zeus init failed.");
            if (tTPluginListener != null) {
                tTPluginListener.onPluginListener(1002, null, null, null);
                return;
            }
            return;
        }
        Handler handlerNr = com.bytedance.sdk.openadsdk.sx.u.u().nr();
        Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.a.7
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.api.iz.nr("TTPluginManager", "Load plugin failed, caused by timeout.");
                tTPluginListener.onPluginListener(1001, null, null, null);
            }
        };
        handlerNr.postDelayed(runnable, 180000L);
        String strPackageName = tTPluginListener.packageName();
        Plugin plugin = (Zeus.isPluginInstalled(strPackageName) && (Zeus.isPluginLoaded(strPackageName) || Zeus.loadPlugin(strPackageName))) ? Zeus.getPlugin(strPackageName) : null;
        StringBuilder sb = new StringBuilder("Find plugin:");
        sb.append(plugin != null);
        com.bytedance.sdk.openadsdk.api.iz.nr("TTPluginManager", sb.toString());
        if (plugin != null) {
            u(plugin);
            handlerNr.removeCallbacks(runnable);
            tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
        } else {
            nr.put(strPackageName, tTPluginListener);
            fx.put(strPackageName, handlerNr);
        }
    }

    private static u u(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        u uVar = new u();
        uVar.fx = jSONObject.optString("package_name");
        uVar.b = jSONObject.optInt("version_code");
        uVar.pn = jSONObject.optString(WfConstant.EXTRA_KEY_DOWNLOAD_URL);
        uVar.x = jSONObject.optString("md5");
        uVar.f5192a = jSONObject.optInt("min_version");
        uVar.jk = jSONObject.optInt("max_version");
        uVar.u = jSONObject.optString("sign");
        uVar.iz = jSONObject.optBoolean("is_revert") ? 3 : 2;
        uVar.nr = new File(jSONObject.optString("plugin_file"));
        return uVar;
    }

    private static void u(Plugin plugin) {
        if (plugin == null) {
            com.bytedance.sdk.openadsdk.api.iz.b("TTPluginManager", "plugin is null.");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("action", 0);
        bundle.putString("plugin_pkg_name", plugin.mPkgName);
        bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, u(plugin.getVersion()));
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager != null) {
            adManager.getExtra(Bundle.class, bundle);
        }
    }

    public static String u(int i) {
        char[] charArray = String.valueOf(i).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            sb.append(charArray[i2]);
            if (i2 < charArray.length - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    private static boolean u(TTPluginListener tTPluginListener, String str) {
        if (tTPluginListener == null || tTPluginListener.packageName() == null) {
            return false;
        }
        return tTPluginListener.packageName().equals(str);
    }

    private static void u(boolean z, String str) {
        HashMap<String, TTPluginListener> map = nr;
        TTPluginListener tTPluginListener = map.get(str);
        StringBuilder sb = new StringBuilder("Install dl plugin ");
        sb.append(str);
        sb.append(z ? " success" : " failed");
        sb.append(", need notify: ");
        sb.append(tTPluginListener != null);
        com.bytedance.sdk.openadsdk.api.iz.nr("TTPluginManager", sb.toString());
        HashMap<String, Handler> map2 = fx;
        Handler handler = map2.get(str);
        if (z) {
            TTPluginListener tTPluginListener2 = l;
            if (!u(tTPluginListener2, str) && (tTPluginListener == null || handler == null)) {
                return;
            }
            if (Zeus.loadPlugin(str)) {
                Plugin plugin = Zeus.getPlugin(str);
                u(plugin);
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                if (tTPluginListener != null) {
                    tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                }
                if (u(tTPluginListener2, str)) {
                    tTPluginListener2.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                    l = null;
                }
            } else {
                com.bytedance.sdk.openadsdk.api.iz.nr("TTPluginManager", "handle installed, load failed");
                fx(str, 1002);
            }
        } else {
            com.bytedance.sdk.openadsdk.api.iz.nr("TTPluginManager", "handle installed failed");
            fx(str, 1003);
        }
        map.remove(str);
        map2.remove(str);
    }

    public static void u(Throwable th) {
        if (th instanceof AbstractMethodError) {
            Zeus.unInstallPlugin("com.byted.pangle");
            com.bytedance.sdk.openadsdk.api.iz.b("TTPluginManager", "AbstractMethodError, rollback to builtin version.");
        }
    }
}
