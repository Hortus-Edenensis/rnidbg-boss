package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.core.content.FileProvider;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.dutexplorer.tmapcloak;
import com.bytedance.pangle.annotations.ForbidWrapParam;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.kwad.sdk.api.KsAdSDK;
import com.qq.e.comm.managers.status.SDKStatus;
import com.tencent.matrix.trace.config.SharePluginInfo;
import defpackage.ll7;
import j$.util.function.Function$CC;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import kotlin.Result;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class fx implements Function<SparseArray<Object>, Object> {
    private static AtomicBoolean iz;
    private static Boolean nr;
    private static int u;
    private com.bytedance.sdk.openadsdk.ats.iz x;
    private final h fx = new h();
    private volatile boolean b = false;
    private AtomicBoolean pn = new AtomicBoolean(false);

    public fx(Bundle bundle) {
        if (bundle == null || !bundle.containsKey(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER)) {
            return;
        }
        Serializable serializable = bundle.getSerializable(PluginConstants.KEY_PL_UPDATE_EVENT_LISTENER);
        if (serializable instanceof Function) {
            com.bytedance.sdk.openadsdk.core.ja.u.nr.u().u((Function<SparseArray<Object>, Object>) serializable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean iz() {
        if (nr == null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                nr = Boolean.TRUE;
            } catch (Throwable unused) {
                nr = Boolean.FALSE;
            }
        }
        return nr.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int pn() {
        if (u == 0) {
            try {
                try {
                    int i = FileProvider.c;
                    u = 1;
                } catch (Throwable unused) {
                    u = -1;
                }
            } catch (Throwable unused2) {
                int i2 = FileProvider.c;
                u = 2;
            }
        }
        return u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String x() {
        try {
            Class.forName("com.unity3d.player.UnityPlayer");
            try {
                Class.forName("com.bytedance.android.NativeAdManager");
                return MediationConstant.ADN_UNITY;
            } catch (Throwable unused) {
                return "unity_pure";
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    public Map<String, Object> nr() {
        com.bytedance.sdk.openadsdk.ats.iz izVar = this.x;
        if (izVar == null) {
            return null;
        }
        return izVar.u();
    }

    private void nr(@ForbidWrapParam com.bytedance.sdk.openadsdk.my.fx.fx.u uVar) {
        if (n.o().su()) {
            com.bytedance.sdk.openadsdk.gi.u.nr.u(uVar);
        }
    }

    private static void u(com.bytedance.sdk.openadsdk.my.fx.fx.u uVar, boolean z) {
        if (u(uVar)) {
            com.bytedance.sdk.openadsdk.tools.nr.fx(1, z ? "1" : "0");
            u(uVar.t());
            com.bytedance.sdk.openadsdk.tools.nr.nr(2, uVar.u());
            try {
                Thread.currentThread().getContextClassLoader().loadClass("com.bytedance.sdk.openadsdk.core.GlobalInfo");
                com.bytedance.sdk.openadsdk.tools.nr.fx(2, "0");
            } catch (Exception unused) {
                com.bytedance.sdk.openadsdk.tools.nr.fx(2, "1");
            }
            com.bytedance.sdk.openadsdk.tools.nr.nr(0, d.b);
        }
    }

    private void nr(@ForbidWrapParam PluginValueSet pluginValueSet) {
        try {
            Boolean bool = (Boolean) pluginValueSet.objectValue(14, Boolean.class);
            if (bool != null) {
                d.nr = bool.booleanValue();
            }
        } catch (Exception unused) {
        }
    }

    private void nr(@ForbidWrapParam com.bytedance.sdk.openadsdk.my.fx.fx.u uVar, @ForbidWrapParam PluginValueSet pluginValueSet) {
        if (uVar == null) {
            return;
        }
        String strNr = uVar.nr();
        if (strNr == null || strNr.isEmpty()) {
            strNr = com.bytedance.sdk.openadsdk.core.n.u.nr(dw.getContext());
        }
        n.o().u((Function<SparseArray<Object>, Object>) pluginValueSet.objectValue(16, Function.class));
        n.o().b(strNr);
        n.o().fx(uVar.u());
        n.o().fx(uVar.fx());
        n.o().pn(uVar.b());
        n.o().iz(uVar.pn());
        n.o().nr(uVar.iz());
        n.o().pn(uVar.s());
        n.o().b(uVar.x());
        n.o().u(uVar.a());
        n.o().iz(uVar.k());
        n.o().u(uVar.t());
        if (d.fx >= 5500) {
            n.o().b(uVar.mv());
            n.o().u(uVar.l());
        } else {
            n.o().b(pluginValueSet.intValue(7));
            n.o().u(pluginValueSet.intValue(8));
        }
        if (u(uVar)) {
            com.bytedance.sdk.component.utils.k.nr();
            com.bytedance.sdk.openadsdk.tools.nr.nr();
            com.ss.android.socialbase.downloader.fx.u.u(2);
        }
    }

    private static void u(com.bytedance.sdk.openadsdk.my.fx.fx.b bVar) {
        String str;
        if (bVar == null || bVar.mv()) {
            bVar = n.u;
        }
        com.bytedance.sdk.openadsdk.tools.nr.fx(19, bVar.mv() ? "1" : "0");
        com.bytedance.sdk.openadsdk.tools.nr.fx(7, String.valueOf(bVar.u() ? 1 : 0));
        com.bytedance.sdk.openadsdk.my.fx.fx.fx fxVarA = bVar.a();
        String strTrim = "";
        if (fxVarA != null) {
            str = fxVarA.u() + "," + fxVarA.nr();
        } else {
            str = "";
        }
        com.bytedance.sdk.openadsdk.tools.nr.fx(8, str);
        com.bytedance.sdk.openadsdk.tools.nr.fx(9, String.valueOf(bVar.fx() ? 1 : 0));
        String strJk = bVar.jk();
        com.bytedance.sdk.openadsdk.tools.nr.fx(10, strJk != null ? strJk.trim() : "");
        com.bytedance.sdk.openadsdk.tools.nr.fx(11, String.valueOf(bVar.b() ? 1 : 0));
        com.bytedance.sdk.openadsdk.tools.nr.fx(12, String.valueOf(bVar.pn() ? 1 : 0));
        com.bytedance.sdk.openadsdk.tools.nr.fx(17, String.valueOf(bVar.nr() ? 1 : 0));
        if (d.fx >= 4600) {
            com.bytedance.sdk.openadsdk.tools.nr.fx(22, String.valueOf(bVar.iz() ? 1 : 0));
        }
        if (d.fx >= 7000) {
            com.bytedance.sdk.openadsdk.tools.nr.fx(24, String.valueOf(bVar.n() ? 1 : 0));
        }
        String strT = bVar.t();
        com.bytedance.sdk.openadsdk.tools.nr.fx(18, strT != null ? strT.trim() : "");
        try {
            if (bVar.l() != null) {
                strTrim = bVar.l().trim();
            }
            com.bytedance.sdk.openadsdk.tools.nr.fx(13, strTrim);
        } catch (Exception unused) {
            com.bytedance.sdk.component.utils.k.u("Get oaid from controller failed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(@ForbidWrapParam final Context context, final long j, final long j2, final long j3, final q qVar, final boolean z, final com.bytedance.sdk.openadsdk.my.fx.fx.u uVar, final String str, final int i, @ForbidWrapParam final PluginValueSet pluginValueSet, @ForbidWrapParam final com.bytedance.sdk.openadsdk.core.pb.x xVar) {
        bg.fx();
        if (dw.nr().ju()) {
            com.bytedance.sdk.openadsdk.core.qq.s.u().nr(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.fx.6
                @Override // com.bytedance.sdk.openadsdk.t.u.u
                public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                    boolean zDw = n.o().dw();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", j);
                    jSONObject.put("is_async", z);
                    jSONObject.put("is_multi_process", uVar.jk());
                    jSONObject.put("is_debug", fx.u(uVar));
                    jSONObject.put("is_activate_init", zDw);
                    jSONObject.put("is_plugin", d.u());
                    jSONObject.put("has_kotlin", fx.iz());
                    jSONObject.put("use_mediation", uVar.k());
                    jSONObject.put("is_androidx", fx.pn());
                    jSONObject.put("host_abi", com.bytedance.sdk.openadsdk.core.ja.nr.nr.u());
                    jSONObject.put("minSdkVersion", jp.b(context));
                    jSONObject.put("targetSdkVersion", jp.fx(context));
                    jSONObject.put("ttvideo_plugin_config", true);
                    jSONObject.put("ttvideo_can_use", d.b());
                    jSONObject.put("is_keva_init_success", com.bytedance.sdk.openadsdk.core.y.bf.nr());
                    jSONObject.put(CrashHianalyticsData.THREAD_NAME, str);
                    jSONObject.put("thread_priority", i);
                    jSONObject.put("is_boost", com.bytedance.sdk.openadsdk.core.b.u.b());
                    jSONObject.put("opt_config", String.valueOf(xVar));
                    jSONObject.put("page_size", com.bytedance.sdk.openadsdk.core.y.gi.kj());
                    n.o().nr(false);
                    Object objObjectValue = pluginValueSet.objectValue(9, Object.class);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("main_cost", j);
                    jSONObject2.put("callback_cost", j2);
                    jSONObject2.put("total_cost", j3);
                    if (objObjectValue != null) {
                        jSONObject2.put("plugin", objObjectValue);
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    qVar.u(jSONObject3, 20L);
                    jSONObject2.put("init", jSONObject3);
                    jSONObject.put(SharePluginInfo.ISSUE_COST, jSONObject2);
                    if (!uVar.k()) {
                        try {
                            Object objInvoke = Class.forName("com.baidu.mobads.sdk.api.AdSettings").getMethod("getSDKVersion", new Class[0]).invoke(null, new Object[0]);
                            if (objInvoke instanceof String) {
                                jSONObject.put("baidu_version", objInvoke);
                            }
                        } catch (Throwable unused) {
                        }
                        try {
                            Object objInvoke2 = SDKStatus.class.getMethod("getIntegrationSDKVersion", new Class[0]).invoke(null, new Object[0]);
                            if (objInvoke2 instanceof String) {
                                jSONObject.put("gdt_version", objInvoke2);
                            }
                        } catch (Throwable unused2) {
                        }
                        try {
                            AtomicBoolean atomicBoolean = KsAdSDK.sHasInit;
                            Object objInvoke3 = KsAdSDK.class.getMethod("getSDKVersion", new Class[0]).invoke(null, new Object[0]);
                            if (objInvoke3 instanceof String) {
                                jSONObject.put("ks_version", objInvoke3);
                            }
                        } catch (Throwable unused3) {
                        }
                    }
                    Object objX = fx.this.x();
                    if (objX != null) {
                        jSONObject.put("develop_type", objX);
                    }
                    com.bytedance.sdk.openadsdk.core.qq.u.nr nrVarNr = com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u("pangle_sdk_init").nr(jSONObject.toString());
                    StringBuilder sb = new StringBuilder();
                    sb.append(j2);
                    return nrVarNr.pn(sb.toString());
                }
            }, "pangle_sdk_init");
        }
    }

    public static boolean u(com.bytedance.sdk.openadsdk.my.fx.fx.u uVar) {
        AtomicBoolean atomicBoolean = iz;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        boolean z = uVar.n() && com.bytedance.sdk.openadsdk.core.y.n.u();
        iz = new AtomicBoolean(z);
        return z;
    }

    public boolean u() {
        return this.b;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u(final Context context, @ForbidWrapParam final PluginValueSet pluginValueSet, @ForbidWrapParam final com.bytedance.sdk.openadsdk.core.bc.fx fxVar) {
        com.bytedance.sdk.openadsdk.core.bc.fx fxVar2;
        SparseArray<Object> sparseArray;
        long jElapsedRealtime;
        String name;
        int priority;
        try {
            if (pluginValueSet != null) {
                try {
                    sparseArray = pluginValueSet.sparseArray();
                } catch (Throwable th) {
                    th = th;
                    fxVar2 = fxVar;
                    u(fxVar2, th);
                    u(new com.bytedance.sdk.openadsdk.my.fx.fx.u(pluginValueSet == null ? pluginValueSet.sparseArray() : new SparseArray<>()), this.b);
                }
            } else {
                sparseArray = new SparseArray<>();
            }
            final com.bytedance.sdk.openadsdk.my.fx.fx.u uVar = new com.bytedance.sdk.openadsdk.my.fx.fx.u(sparseArray);
            dw.u(context);
            try {
                jElapsedRealtime = pluginValueSet.longValue(1, SystemClock.elapsedRealtime());
            } catch (Exception unused) {
                jElapsedRealtime = SystemClock.elapsedRealtime();
            }
            if (jElapsedRealtime == 0) {
                jElapsedRealtime = SystemClock.elapsedRealtime();
            }
            final long j = jElapsedRealtime;
            final q qVarU = q.u("duration");
            Thread threadCurrentThread = Thread.currentThread();
            try {
                name = pluginValueSet.stringValue(2, threadCurrentThread.getName());
            } catch (Exception unused2) {
                name = threadCurrentThread.getName();
            }
            final String str = name;
            try {
                priority = pluginValueSet.intValue(3, threadCurrentThread.getPriority());
            } catch (Exception unused3) {
                priority = threadCurrentThread.getPriority();
            }
            final int i = priority;
            nr(pluginValueSet);
            n.o().k();
            if (this.b) {
                u(fxVar);
                return;
            }
            u(uVar, pluginValueSet);
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            u(pluginValueSet);
            qVarU.u("init_thread_cost", SystemClock.elapsedRealtime() - jElapsedRealtime2);
            long jElapsedRealtime3 = SystemClock.elapsedRealtime();
            if (d.nr) {
                com.bytedance.sdk.openadsdk.ats.fx.u("device_info");
            }
            qVarU.u("init_autoservice_cost", SystemClock.elapsedRealtime() - jElapsedRealtime3);
            final long jElapsedRealtime4 = SystemClock.elapsedRealtime() - j;
            qVarU.nr("sync_cost");
            com.bytedance.sdk.component.jk.t.nr.l().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.fx.1
                @Override // java.lang.Runnable
                public void run() {
                    qVarU.nr("async_wait_cost");
                    if (fx.this.u(context, uVar, fxVar, qVarU)) {
                        qVarU.nr("async_done_cost");
                        long jElapsedRealtime5 = SystemClock.elapsedRealtime() - j;
                        qVarU.u();
                        fx.this.u(context, jElapsedRealtime4, jElapsedRealtime5, SystemClock.elapsedRealtime() - j, qVarU, true, uVar, str, i, pluginValueSet, dw.nr().jc());
                    }
                }
            });
            com.bytedance.sdk.component.jk.x.u(-1);
            com.bytedance.sdk.openadsdk.u.nr.nr.u();
            com.bytedance.sdk.component.jk.x.nr(new com.bytedance.sdk.component.jk.a("init Async") { // from class: com.bytedance.sdk.openadsdk.core.fx.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (fx.this.pn.get()) {
                            return;
                        }
                        fx.this.pn.set(true);
                        iz.u();
                        com.bytedance.sdk.openadsdk.core.y.t.fx();
                        com.bytedance.sdk.openadsdk.u.u.u.u(false);
                        com.bytedance.sdk.openadsdk.k.nr.u(context);
                        com.bytedance.sdk.openadsdk.k.nr.nr();
                        com.bytedance.sdk.openadsdk.core.miniapp.u.u().registerReceiver(context);
                        com.bytedance.sdk.openadsdk.core.k.fx.pn().iz();
                    } catch (Throwable unused4) {
                    }
                }
            });
            bg.u = true;
        } catch (Throwable th2) {
            th = th2;
            fxVar2 = fxVar;
            u(fxVar2, th);
            u(new com.bytedance.sdk.openadsdk.my.fx.fx.u(pluginValueSet == null ? pluginValueSet.sparseArray() : new SparseArray<>()), this.b);
        }
    }

    private void u(@ForbidWrapParam com.bytedance.sdk.openadsdk.core.bc.fx fxVar, Throwable th) {
        if (fxVar != null) {
            message = th != null ? th.getMessage() : null;
            if (message == null) {
                message = "init error";
            }
            fxVar.u(1, com.bytedance.sdk.openadsdk.my.pn.u().u(false).u(4000).u(message).nr());
            com.bytedance.sdk.component.utils.k.u("TTAdSdk", " init fail, msg = ", message);
        }
        if (d.fx < 7300) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("message", message);
                Boolean bool = Boolean.TRUE;
                jSONObject.putOpt("is_plugin", bool);
                jSONObject.putOpt("api", bool);
                jSONObject.putOpt("install_version", 7232);
                jSONObject.putOpt("code", 4000);
                com.bytedance.sdk.openadsdk.core.qq.s.u().u("init", jSONObject, th);
            } catch (Throwable unused) {
            }
        }
        this.b = false;
    }

    private void u(@ForbidWrapParam PluginValueSet pluginValueSet) {
        try {
            com.bytedance.sdk.openadsdk.core.xg.u.u();
        } catch (Exception unused) {
        }
    }

    private void u(com.bytedance.sdk.openadsdk.core.bc.fx fxVar) {
        com.bytedance.sdk.openadsdk.core.fx.u.u();
        if (fxVar != null) {
            fxVar.u(8001, com.bytedance.sdk.openadsdk.my.pn.u().u(true).u(com.bytedance.sdk.openadsdk.my.b.u().u(20, com.bytedance.sdk.component.jk.t.nr.a()).u(23, nr()).nr()).nr());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u(@ForbidWrapParam Context context, @ForbidWrapParam com.bytedance.sdk.openadsdk.my.fx.fx.u uVar, @ForbidWrapParam com.bytedance.sdk.openadsdk.core.bc.fx fxVar, q qVar) {
        if (this.b) {
            u(fxVar);
            return false;
        }
        try {
            if (com.bytedance.sdk.openadsdk.core.b.u.fx()) {
                if (!tmapcloak.loadLibSuccess) {
                    u(fxVar, new Exception("load maparmor fail"));
                    return false;
                }
                qVar.nr("maparmor_load_cost");
            }
            u(context, uVar, qVar);
            this.b = true;
            nr(uVar);
            u(context, uVar);
            qVar.nr("async_init_cost");
            com.bytedance.sdk.component.b.u uVarNr = com.bytedance.sdk.openadsdk.core.y.kj.nr();
            if (uVarNr != null) {
                uVarNr.initPglCryptUtils();
            }
            qVar.nr("armor_load_cost");
            com.bytedance.sdk.component.utils.k.nr("TTAdSdk", "Init done finish: 7232");
            u(fxVar);
        } catch (Throwable th) {
            u(fxVar, th);
        }
        u(uVar, this.b);
        return true;
    }

    private void u(@ForbidWrapParam Context context, @ForbidWrapParam com.bytedance.sdk.openadsdk.my.fx.fx.u uVar, q qVar) {
        try {
            if (u(uVar)) {
                com.bytedance.sdk.openadsdk.core.y.bq.u();
                com.bykv.vk.openvk.component.video.api.iz.fx.u();
                com.bytedance.sdk.component.a.u.u();
                com.bytedance.sdk.openadsdk.tools.nr.nr();
            }
        } catch (Throwable unused) {
        }
        qVar.nr("debug_set_cost");
        com.bytedance.sdk.openadsdk.core.multipro.b.u(context);
        qVar.nr("web_dir_cost");
        com.bytedance.sdk.component.a.fx.u.u((ThreadPoolExecutor) com.bytedance.sdk.component.jk.x.u());
        qVar.nr("thread_pool_cost");
        com.bykv.vk.openvk.component.video.api.fx.u(uVar.jk());
        if (uVar.jk()) {
            com.bytedance.sdk.openadsdk.core.multipro.nr.u();
            n.o().bf();
        } else {
            com.bytedance.sdk.openadsdk.core.multipro.nr.nr();
        }
        qVar.nr("multi_cost");
        com.bykv.vk.openvk.component.video.api.fx.u(context, null);
        com.bykv.vk.openvk.component.video.u.u.u(context);
        qVar.nr("video_config_cost");
        bg.pn();
        qVar.nr("dyna_init_cost");
        com.bytedance.sdk.openadsdk.core.y.kj.fx();
        qVar.nr("armor_init_cost");
    }

    private void u(@ForbidWrapParam com.bytedance.sdk.openadsdk.my.fx.fx.u uVar, @ForbidWrapParam PluginValueSet pluginValueSet) {
        nr(uVar, pluginValueSet);
        bg.b();
        com.bytedance.sdk.openadsdk.core.qq.nr.nr();
        try {
            com.bytedance.sdk.openadsdk.core.ugeno.pn.u();
        } catch (Throwable unused) {
        }
        if (uVar.jk()) {
            com.bytedance.sdk.openadsdk.core.y.bf.u();
        }
        com.bytedance.sdk.openadsdk.core.fx.fx.u().u(uVar.jk());
    }

    private void u(@ForbidWrapParam final Context context, @ForbidWrapParam final com.bytedance.sdk.openadsdk.my.fx.fx.u uVar) {
        com.bytedance.sdk.component.jk.x.u(new com.bytedance.sdk.component.jk.a("init sync") { // from class: com.bytedance.sdk.openadsdk.core.fx.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.core.l.a.pn();
                    com.bytedance.sdk.openadsdk.core.pb.t tVarNr = dw.nr();
                    if (!tVarNr.xx()) {
                        synchronized (tVarNr) {
                            if (!tVarNr.xx()) {
                                tVarNr.u();
                            }
                        }
                    }
                    fx.this.u(uVar.jk(), context, true, 10000L);
                    com.bytedance.sdk.component.utils.jk.u().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.fx.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (n.o().ja()) {
                                return;
                            }
                            com.bytedance.sdk.openadsdk.k.nr.fx();
                        }
                    }, 120000L);
                    com.bykv.vk.openvk.component.video.api.fx.u(com.bytedance.sdk.openadsdk.core.gi.pn.u().nr().iz());
                    com.bytedance.sdk.openadsdk.core.qq.nr.u(context, uVar.jk());
                    com.bytedance.sdk.openadsdk.core.l.nr.fx();
                    bf.fx();
                    com.bykv.vk.openvk.component.video.u.u.u(com.bytedance.sdk.openadsdk.gi.jk.u(0));
                    if (tVarNr.o()) {
                        final com.bykv.vk.openvk.component.video.api.u.nr nrVarU = com.bytedance.sdk.openadsdk.gi.jk.u(1);
                        com.bytedance.sdk.component.jk.x.nr(new com.bytedance.sdk.component.jk.a("preloadTTVideo") { // from class: com.bytedance.sdk.openadsdk.core.fx.3.2
                            @Override // java.lang.Runnable
                            public void run() {
                                com.bytedance.sdk.component.l.nr.nr.u(context, nrVarU.b(), 52428800, com.bytedance.sdk.openadsdk.gi.jk.nr(), com.bytedance.sdk.openadsdk.gi.jk.fx(), fx.u(uVar), new com.bytedance.sdk.component.l.nr.fx() { // from class: com.bytedance.sdk.openadsdk.core.fx.3.2.1
                                    @Override // com.bytedance.sdk.component.l.nr.fx
                                    public void u(String str, JSONObject jSONObject) {
                                        iz.u().u(str, jSONObject);
                                    }
                                });
                            }
                        });
                    }
                    com.bytedance.sdk.openadsdk.core.y.t.t();
                    bg.u(context);
                    com.bytedance.sdk.component.jk.x.u(true);
                    com.bytedance.sdk.component.jk.x.u(new com.bytedance.sdk.openadsdk.core.qq.nr.u());
                    com.bytedance.sdk.openadsdk.core.dislike.nr.u();
                    com.bytedance.sdk.openadsdk.core.y.t.u(context);
                    com.bytedance.sdk.openadsdk.u.nr.nr.fx(context);
                    com.bytedance.sdk.openadsdk.core.y.t.iz(context);
                    com.bytedance.sdk.openadsdk.l.b.u(context);
                    if (Build.VERSION.SDK_INT >= 29) {
                        try {
                            com.bytedance.sdk.component.utils.c.u();
                            com.bytedance.sdk.component.utils.o.u(new com.bytedance.sdk.openadsdk.gi.pn());
                        } catch (Exception unused) {
                        }
                    }
                    com.bytedance.sdk.openadsdk.core.y.s.u();
                    com.bytedance.sdk.openadsdk.core.y.n.u(uVar);
                    com.bytedance.sdk.openadsdk.core.y.kj.u();
                    com.bytedance.sdk.openadsdk.core.xw.u.u().u(context);
                    com.bytedance.sdk.openadsdk.core.y.xg.u();
                    com.bytedance.sdk.openadsdk.core.d.nr.u();
                } catch (Throwable unused2) {
                }
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final boolean z, @ForbidWrapParam final Context context, final boolean z2, long j) {
        com.bytedance.sdk.component.utils.jk.u().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.fx.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.live.nr.u();
                if (!z || com.bytedance.sdk.component.utils.bq.u(context)) {
                    com.bytedance.sdk.openadsdk.core.pb.n.u(dw.nr()).fx();
                }
                if (z2) {
                    com.bytedance.sdk.openadsdk.core.qq.nr.b();
                }
            }
        }, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(@ForbidWrapParam final Context context, final long j, final long j2, final long j3, final q qVar, final boolean z, final com.bytedance.sdk.openadsdk.my.fx.fx.u uVar, final String str, final int i, @ForbidWrapParam final PluginValueSet pluginValueSet, @ForbidWrapParam final com.bytedance.sdk.openadsdk.core.pb.x xVar) {
        com.bytedance.sdk.component.utils.jk.u().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.fx.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    fx.this.nr(context, j, j2, j3, qVar, z, uVar, str, i, pluginValueSet, xVar);
                } catch (Throwable unused) {
                }
            }
        }, 5000L);
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetA = ll7.j(sparseArray).a();
        switch (pluginValueSetA.intValue(-99999987)) {
            case -999002:
                return Boolean.valueOf(u());
            case -999001:
                u((Context) pluginValueSetA.objectValue(-998000, Context.class), pluginValueSetA, new com.bytedance.sdk.openadsdk.core.bc.fx((Function) pluginValueSetA.objectValue(15, Function.class)));
                return null;
            case -999000:
                return this.fx;
            default:
                return null;
        }
    }
}
