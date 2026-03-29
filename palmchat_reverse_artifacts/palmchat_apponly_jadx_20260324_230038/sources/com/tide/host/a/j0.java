package com.tide.host.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.oplus.tbl.exoplayer2.Renderer;
import com.tide.protocol.config.TideWholeConfig;
import com.tide.protocol.host.model.PluginEvent;
import com.tide.protocol.host.model.PluginEventType;
import com.tide.protocol.host.model.PluginInfo;
import com.tide.protocol.host.model.PluginUpdateInfo;
import com.tide.protocol.transfer.TideEventBus;
import com.tide.protocol.util.TdFileUtils;
import com.tide.protocol.util.TdLogUtils;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile j0 f10792a;

    public static j0 a() {
        if (f10792a == null) {
            synchronized (j0.class) {
                if (f10792a == null) {
                    f10792a = new j0();
                }
            }
        }
        return f10792a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:158:0x03c1 A[Catch: all -> 0x04b4, TryCatch #14 {, blocks: (B:4:0x0009, B:6:0x0028, B:9:0x0030, B:11:0x003e, B:14:0x004a, B:71:0x016e, B:95:0x01ae, B:156:0x03a8, B:158:0x03c1, B:160:0x03c7, B:161:0x03d7, B:91:0x01a3, B:98:0x01ca, B:99:0x01cd, B:100:0x01ce, B:181:0x0417, B:146:0x033a, B:148:0x0355, B:152:0x037a, B:151:0x036b, B:185:0x0457, B:187:0x048a, B:189:0x0495, B:89:0x0190), top: B:223:0x0009, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x03d7 A[Catch: all -> 0x04b4, TRY_LEAVE, TryCatch #14 {, blocks: (B:4:0x0009, B:6:0x0028, B:9:0x0030, B:11:0x003e, B:14:0x004a, B:71:0x016e, B:95:0x01ae, B:156:0x03a8, B:158:0x03c1, B:160:0x03c7, B:161:0x03d7, B:91:0x01a3, B:98:0x01ca, B:99:0x01cd, B:100:0x01ce, B:181:0x0417, B:146:0x033a, B:148:0x0355, B:152:0x037a, B:151:0x036b, B:185:0x0457, B:187:0x048a, B:189:0x0495, B:89:0x0190), top: B:223:0x0009, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0180 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:221:0x040c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:238:? A[Catch: all -> 0x018a, SYNTHETIC, TRY_LEAVE, TryCatch #9 {all -> 0x018a, blocks: (B:69:0x0169, B:85:0x0189, B:84:0x0186, B:80:0x0180), top: B:214:0x0075, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:240:? A[Catch: all -> 0x0417, SYNTHETIC, TRY_LEAVE, TryCatch #17 {all -> 0x0417, blocks: (B:179:0x0415, B:178:0x0412, B:174:0x040c), top: B:221:0x040c, inners: #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0169 A[Catch: all -> 0x018a, TRY_ENTER, TRY_LEAVE, TryCatch #9 {all -> 0x018a, blocks: (B:69:0x0169, B:85:0x0189, B:84:0x0186, B:80:0x0180), top: B:214:0x0075, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x016e A[Catch: all -> 0x04b4, DONT_GENERATE, TRY_ENTER, TRY_LEAVE, TryCatch #14 {, blocks: (B:4:0x0009, B:6:0x0028, B:9:0x0030, B:11:0x003e, B:14:0x004a, B:71:0x016e, B:95:0x01ae, B:156:0x03a8, B:158:0x03c1, B:160:0x03c7, B:161:0x03d7, B:91:0x01a3, B:98:0x01ca, B:99:0x01cd, B:100:0x01ce, B:181:0x0417, B:146:0x033a, B:148:0x0355, B:152:0x037a, B:151:0x036b, B:185:0x0457, B:187:0x048a, B:189:0x0495, B:89:0x0190), top: B:223:0x0009, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01a9 A[PHI: r16
      0x01a9: PHI (r16v6 com.tide.protocol.host.model.PluginInfo) = (r16v5 com.tide.protocol.host.model.PluginInfo), (r16v16 com.tide.protocol.host.model.PluginInfo) binds: [B:92:0x01a7, B:72:0x0172] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01ac  */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r10v29 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v30 */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r10v5, types: [long] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r2v69 */
    /* JADX WARN: Type inference failed for: r2v70 */
    /* JADX WARN: Type inference failed for: r2v71 */
    /* JADX WARN: Type inference failed for: r2v72, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v73 */
    /* JADX WARN: Type inference failed for: r2v74 */
    /* JADX WARN: Type inference failed for: r2v75 */
    /* JADX WARN: Type inference failed for: r2v76, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v78 */
    /* JADX WARN: Type inference failed for: r2v79, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v80 */
    /* JADX WARN: Type inference failed for: r2v81 */
    /* JADX WARN: Type inference failed for: r2v82 */
    /* JADX WARN: Type inference failed for: r2v83 */
    /* JADX WARN: Type inference failed for: r2v84 */
    /* JADX WARN: Type inference failed for: r2v85 */
    /* JADX WARN: Type inference failed for: r2v86 */
    /* JADX WARN: Type inference failed for: r2v87 */
    /* JADX WARN: Type inference failed for: r2v88 */
    /* JADX WARN: Type inference failed for: r2v89 */
    /* JADX WARN: Type inference failed for: r2v90 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void a(Context context, String str, PluginInfo pluginInfo, o oVar) {
        ?? r10;
        Throwable th;
        ?? r102;
        long jCurrentTimeMillis;
        Context context2;
        PluginInfo pluginInfoA;
        int i;
        String str2;
        InputStream inputStream;
        boolean z;
        InputStream inputStreamOpen;
        ?? r2;
        Throwable th2;
        PluginInfo pluginInfo2;
        PluginInfo pluginInfo3;
        boolean z2;
        ?? r22;
        ?? r23;
        ?? r24;
        InputStream inputStream2;
        ?? r25 = context;
        synchronized (this) {
            TideWholeConfig.getInstance().savePluginStartInitTime(str);
            e0.a().onEvent("td_plugin_init", str, new d0(str).b);
            if (r25 != 0 && !TextUtils.isEmpty(str)) {
                String randomID = TdFileUtils.getRandomID();
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                boolean z3 = false;
                InputStream inputStreamOpen2 = null;
                inputStreamOpen2 = null;
                pluginInfo = null;
                pluginInfo = null;
                pluginInfo = null;
                pluginInfo = null;
                PluginInfo pluginInfo4 = null;
                if (pluginInfo != null && TdFileUtils.isFileExist(pluginInfo.getPluginPath())) {
                    e0.a().onEvent("td_unzip_start", str, new r0(str, randomID, -1, "asset").b);
                    try {
                    } catch (Throwable unused) {
                        z = false;
                        try {
                            n0.a(str, randomID, -1, "asset", System.currentTimeMillis() - jCurrentTimeMillis2, 0, 11004);
                            if (z) {
                            }
                            TdLogUtils.log("TdPluginInfoManager", "get plugin info from local cache by plugin Name ok,info:" + pluginInfoA);
                            context2 = context;
                            str2 = str;
                            i = -1;
                            a(context2, pluginInfoA);
                            a(pluginInfoA);
                            p0.a(t0.b, str2, i);
                            TideEventBus.publish(new PluginEvent(PluginEventType.CHECK_SUCCESS, oVar.f10796a));
                            if (pluginInfoA == null) {
                            }
                            return;
                        } finally {
                            if (z) {
                                g0.a(pluginInfo4);
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            inputStreamOpen = context.getAssets().open(str);
                        } catch (IOException e) {
                            e.printStackTrace();
                            inputStreamOpen = null;
                            if (inputStreamOpen == null) {
                            }
                            TdLogUtils.log("TdPluginInfoManager", "get plugin info from local cache by plugin Name ok,info:" + pluginInfoA);
                            context2 = context;
                            str2 = str;
                            i = -1;
                            a(context2, pluginInfoA);
                            a(pluginInfoA);
                            p0.a(t0.b, str2, i);
                            TideEventBus.publish(new PluginEvent(PluginEventType.CHECK_SUCCESS, oVar.f10796a));
                            if (pluginInfoA == null) {
                                TdLogUtils.error("HostManager", "Plugin load failed:  ".concat("pluginInfo or tideHostApp is null"));
                                TideEventBus.publish(new PluginEvent(PluginEventType.CHECK_FAILED, oVar.f10796a));
                                new m0().checkUpdate(oVar.f10796a);
                            }
                            return;
                        }
                        if (inputStreamOpen == null) {
                        }
                        TdLogUtils.log("TdPluginInfoManager", "get plugin info from local cache by plugin Name ok,info:" + pluginInfoA);
                        context2 = context;
                        str2 = str;
                        i = -1;
                    } else {
                        inputStreamOpen = null;
                        try {
                        } catch (Throwable unused2) {
                            z = z3;
                            n0.a(str, randomID, -1, "asset", System.currentTimeMillis() - jCurrentTimeMillis2, 0, 11004);
                            if (z || !g0.a(pluginInfo4)) {
                            }
                            TdLogUtils.log("TdPluginInfoManager", "get plugin info from local cache by plugin Name ok,info:" + pluginInfoA);
                            context2 = context;
                            str2 = str;
                            i = -1;
                            a(context2, pluginInfoA);
                            a(pluginInfoA);
                            p0.a(t0.b, str2, i);
                            TideEventBus.publish(new PluginEvent(PluginEventType.CHECK_SUCCESS, oVar.f10796a));
                            if (pluginInfoA == null) {
                            }
                            return;
                        }
                        if (inputStreamOpen == null) {
                            try {
                                inputStream2 = inputStreamOpen;
                                try {
                                    n0.a(str, randomID, -1, "asset", System.currentTimeMillis() - jCurrentTimeMillis2, 0, Renderer.MSG_SURFACE_VIEW_DESTROY);
                                    TdLogUtils.error("TdPluginInfoManager", "Asset 覆盖 Failed to get InputStream from Asset ");
                                    r24 = inputStream2;
                                    z2 = false;
                                    r23 = r24;
                                    if (r23 != 0) {
                                        r23.close();
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    th2 = th;
                                    r2 = inputStream2;
                                    z3 = false;
                                    r22 = r2;
                                    if (r22 == 0) {
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                inputStream2 = inputStreamOpen;
                            }
                        } else {
                            InputStream inputStream3 = inputStreamOpen;
                            try {
                                PluginInfo pluginInfoA2 = g0.a(r25, inputStream3, str);
                                try {
                                    if (pluginInfoA2 == null) {
                                        try {
                                            pluginInfo2 = pluginInfoA2;
                                            r25 = inputStream3;
                                            n0.a(str, randomID, -1, "asset", System.currentTimeMillis() - jCurrentTimeMillis2, 0, Renderer.MSG_ENABLE_VIDEO_RENDER_STUCK_DETECTOR);
                                            TdLogUtils.error("TdPluginInfoManager", "Asset 覆盖 Failed to get plugin info from file ");
                                            pluginInfo4 = pluginInfo2;
                                            r24 = r25;
                                            z2 = false;
                                            r23 = r24;
                                            if (r23 != 0) {
                                            }
                                        } catch (Throwable th5) {
                                            th = th5;
                                            pluginInfo2 = pluginInfoA2;
                                            r25 = inputStream3;
                                            th2 = th;
                                            pluginInfo4 = pluginInfo2;
                                            r2 = r25;
                                            z3 = false;
                                            r22 = r2;
                                            if (r22 == 0) {
                                            }
                                        }
                                    } else {
                                        pluginInfo2 = pluginInfoA2;
                                        r25 = inputStream3;
                                        if (pluginInfo2.getPluginVCode() > pluginInfo.getPluginVCode()) {
                                            TdLogUtils.log("TdPluginInfoManager", "Asset 覆盖 执行替换 ");
                                            if (!g0.a(r25, pluginInfo2.getPluginPath())) {
                                                n0.a(str, randomID, pluginInfo2.getPluginVCode(), "asset", System.currentTimeMillis() - jCurrentTimeMillis2, 0, 11003);
                                                TdFileUtils.deleteFile(pluginInfo2.getPluginPath());
                                                TdLogUtils.error("TdPluginInfoManager", "Asset 覆盖 Failed to save file from InputStream  ");
                                                r25 = r25;
                                            } else {
                                                try {
                                                    pluginInfo2.setPluginFrom("asset");
                                                    try {
                                                        TdLogUtils.log("TdPluginInfoManager", "Asset 覆盖 升级成功  ");
                                                        int pluginVCode = pluginInfo2.getPluginVCode();
                                                        pluginInfo3 = pluginInfo2;
                                                        try {
                                                            n0.a(str, randomID, pluginVCode, "asset", System.currentTimeMillis() - jCurrentTimeMillis2, 1, -1);
                                                            pluginInfo4 = pluginInfo3;
                                                            z2 = true;
                                                            r23 = r25;
                                                            if (r23 != 0) {
                                                            }
                                                        } catch (Throwable th6) {
                                                            th = th6;
                                                            th2 = th;
                                                            pluginInfo4 = pluginInfo3;
                                                            z3 = true;
                                                            r22 = r25;
                                                            if (r22 == 0) {
                                                                try {
                                                                    r22.close();
                                                                    throw th2;
                                                                } catch (Throwable th7) {
                                                                    th2.addSuppressed(th7);
                                                                    throw th2;
                                                                }
                                                            }
                                                            throw th2;
                                                        }
                                                    } catch (Throwable th8) {
                                                        th = th8;
                                                        pluginInfo3 = pluginInfo2;
                                                    }
                                                } catch (Throwable th9) {
                                                    th = th9;
                                                    pluginInfo2 = pluginInfo2;
                                                    th2 = th;
                                                    pluginInfo4 = pluginInfo2;
                                                    r2 = r25;
                                                    z3 = false;
                                                    r22 = r2;
                                                    if (r22 == 0) {
                                                    }
                                                }
                                            }
                                        } else {
                                            n0.a(str, randomID, pluginInfo2.getPluginVCode(), "asset", System.currentTimeMillis() - jCurrentTimeMillis2, 1, -1);
                                            r25 = r25;
                                        }
                                        pluginInfo4 = pluginInfo2;
                                        r24 = r25;
                                        z2 = false;
                                        r23 = r24;
                                        if (r23 != 0) {
                                        }
                                    }
                                } catch (Throwable th10) {
                                    th = th10;
                                }
                            } catch (Throwable th11) {
                                r2 = inputStream3;
                                th2 = th11;
                            }
                        }
                        TdLogUtils.log("TdPluginInfoManager", "get plugin info from local cache by plugin Name ok,info:" + pluginInfoA);
                        context2 = context;
                        str2 = str;
                        i = -1;
                    }
                } else {
                    e0.a().onEvent("td_unzip_start", str, new r0(str, randomID, -1, "asset").b);
                    long jCurrentTimeMillis3 = System.currentTimeMillis();
                    TdLogUtils.log("TdPluginInfoManager", "get plugin info from local cache by plugin Name is null or plugin path is null");
                    try {
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                inputStreamOpen2 = context.getAssets().open(str);
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        InputStream inputStream4 = inputStreamOpen2;
                        try {
                            jCurrentTimeMillis = System.currentTimeMillis();
                            TdLogUtils.log("TdPluginInfoManager", "getStreamFromAsset duration " + (jCurrentTimeMillis - jCurrentTimeMillis3));
                        } catch (Throwable th12) {
                            th = th12;
                            r10 = inputStream4;
                        }
                        if (inputStream4 == null) {
                            try {
                                inputStream = inputStream4;
                                try {
                                    n0.a(str, randomID, -1, "asset", System.currentTimeMillis() - jCurrentTimeMillis2, 0, Renderer.MSG_SURFACE_VIEW_DESTROY);
                                    TdLogUtils.error("TdPluginInfoManager", "Failed to get InputStream from Asset asset File inputStream fail");
                                    TdLogUtils.error("HostManager", "Plugin load failed:  ".concat("Failed to get InputStream from Asset asset File inputStream fail"));
                                    TideEventBus.publish(new PluginEvent(PluginEventType.CHECK_FAILED, oVar.f10796a));
                                    new m0().checkUpdate(oVar.f10796a);
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    return;
                                } catch (Throwable th13) {
                                    th = th13;
                                    th = th;
                                    r102 = inputStream;
                                    if (r102 != 0) {
                                    }
                                }
                            } catch (Throwable th14) {
                                th = th14;
                                inputStream = inputStream4;
                            }
                        } else {
                            context2 = context;
                            pluginInfoA = g0.a(context2, inputStream4, str);
                            long jCurrentTimeMillis4 = System.currentTimeMillis();
                            ?? sb = new StringBuilder("getPluginInfoFromFile duration ");
                            ?? r103 = jCurrentTimeMillis4 - jCurrentTimeMillis;
                            try {
                                sb.append(r103);
                                TdLogUtils.log("TdPluginInfoManager", sb.toString());
                            } catch (Throwable th15) {
                                th = th15;
                                r103 = inputStream4;
                            }
                            try {
                                try {
                                    if (pluginInfoA == null) {
                                        n0.a(str, randomID, -1, "asset", System.currentTimeMillis() - jCurrentTimeMillis2, 0, Renderer.MSG_ENABLE_VIDEO_RENDER_STUCK_DETECTOR);
                                        TdLogUtils.error("TdPluginInfoManager", "Failed to get plugin info from file asset pluginInfo is empty");
                                        TdLogUtils.error("HostManager", "Plugin load failed:  ".concat("Failed to get plugin info from file asset pluginInfo is empty"));
                                        TideEventBus.publish(new PluginEvent(PluginEventType.CHECK_FAILED, oVar.f10796a));
                                        new m0().checkUpdate(oVar.f10796a);
                                        inputStream4.close();
                                        return;
                                    }
                                    if (!g0.a(inputStream4, pluginInfoA.getPluginPath())) {
                                        n0.a(str, randomID, pluginInfoA.getPluginVCode(), "asset", System.currentTimeMillis() - jCurrentTimeMillis2, 0, 11003);
                                        TdFileUtils.deleteFile(pluginInfoA.getPluginPath());
                                        TdLogUtils.error("TdPluginInfoManager", "Failed to save file from InputStream save asset plugin is fail");
                                        TdLogUtils.error("HostManager", "Plugin load failed:  ".concat("Failed to save file from InputStream save asset plugin is fail"));
                                        TideEventBus.publish(new PluginEvent(PluginEventType.CHECK_FAILED, oVar.f10796a));
                                        new m0().checkUpdate(oVar.f10796a);
                                        inputStream4.close();
                                        return;
                                    }
                                    TdLogUtils.log("TdPluginInfoManager", "saveFileAfterHeader duration " + (System.currentTimeMillis() - jCurrentTimeMillis4));
                                    pluginInfoA.setPluginFrom("asset");
                                    inputStream4.close();
                                    i = -1;
                                    n0.a(str, randomID, pluginInfoA.getPluginVCode(), "asset", System.currentTimeMillis() - jCurrentTimeMillis2, 1, -1);
                                    if (!g0.a(pluginInfoA)) {
                                        p0.a(t0.b, str, -1);
                                        if (!p0.a(context2, str, "plugin_info")) {
                                            SharedPreferences.Editor editorEdit = context2.getSharedPreferences(str, 0).edit();
                                            editorEdit.putString("plugin_info", "");
                                            editorEdit.commit();
                                        }
                                        TdLogUtils.error("TdPluginInfoManager", "plugin file is not valid");
                                        TdLogUtils.error("HostManager", "Plugin load failed:  ".concat("plugin file is not valid"));
                                        TideEventBus.publish(new PluginEvent(PluginEventType.CHECK_FAILED, oVar.f10796a));
                                        new m0().checkUpdate(oVar.f10796a);
                                        return;
                                    }
                                    str2 = str;
                                } catch (Throwable unused3) {
                                    n0.a(str, randomID, -1, "asset", System.currentTimeMillis() - jCurrentTimeMillis2, 0, 11004);
                                    TdLogUtils.error("TdPluginInfoManager", "Error handling plugin InputStream unzip file throwable");
                                    TdLogUtils.error("HostManager", "Plugin load failed:  ".concat("Error handling plugin InputStream unzip file throwable"));
                                    TideEventBus.publish(new PluginEvent(PluginEventType.CHECK_FAILED, oVar.f10796a));
                                    new m0().checkUpdate(oVar.f10796a);
                                    return;
                                }
                            } catch (Throwable th16) {
                                th = th16;
                                r10 = r103;
                                th = th;
                                r102 = r10;
                                if (r102 != 0) {
                                }
                            }
                            r10 = r103;
                            th = th;
                            r102 = r10;
                            if (r102 != 0) {
                                try {
                                    try {
                                        r102.close();
                                        throw th;
                                    } catch (Throwable th17) {
                                        th.addSuppressed(th17);
                                        throw th;
                                    }
                                } catch (Throwable unused4) {
                                    n0.a(str, randomID, -1, "asset", System.currentTimeMillis() - jCurrentTimeMillis2, 0, 11004);
                                    TdLogUtils.error("TdPluginInfoManager", "Error handling plugin InputStream unzip file throwable");
                                    TdLogUtils.error("HostManager", "Plugin load failed:  ".concat("Error handling plugin InputStream unzip file throwable"));
                                    TideEventBus.publish(new PluginEvent(PluginEventType.CHECK_FAILED, oVar.f10796a));
                                    new m0().checkUpdate(oVar.f10796a);
                                    return;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable unused5) {
                    }
                }
                a(context2, pluginInfoA);
                a(pluginInfoA);
                p0.a(t0.b, str2, i);
                TideEventBus.publish(new PluginEvent(PluginEventType.CHECK_SUCCESS, oVar.f10796a));
                if (pluginInfoA == null && oVar.c.f10781a != null) {
                    oVar.b.a(pluginInfoA);
                    new m0().checkUpdate(oVar.f10796a);
                } else {
                    TdLogUtils.error("HostManager", "Plugin load failed:  ".concat("pluginInfo or tideHostApp is null"));
                    TideEventBus.publish(new PluginEvent(PluginEventType.CHECK_FAILED, oVar.f10796a));
                    new m0().checkUpdate(oVar.f10796a);
                }
                return;
            }
            TdLogUtils.error("HostManager", "Plugin load failed:  ".concat("context or pluginName is empty"));
            TideEventBus.publish(new PluginEvent(PluginEventType.CHECK_FAILED, oVar.f10796a));
            new m0().checkUpdate(oVar.f10796a);
            TdLogUtils.error("TdPluginInfoManager", "loadPlugin failed, context or pluginName is empty,load fail!");
            e0.a().onEvent("td_plugin_init_result", str, new k0(str, TideWholeConfig.getInstance().getPluginFrom(str), System.currentTimeMillis() - (str != null ? TideWholeConfig.getInstance().getPluginStartTime(str) : 0L), 0, 10001).b);
        }
    }

    public static void a(Context context, PluginInfo pluginInfo) {
        if (context != null && pluginInfo != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("pgn", pluginInfo.getPluginName());
                jSONObject.put("pan", pluginInfo.getPackageName());
                jSONObject.put("pgp", pluginInfo.getPluginPath());
                jSONObject.put("vc", pluginInfo.getPluginVCode());
                jSONObject.put("hvc", pluginInfo.getHostVCode());
                jSONObject.put("fvc", pluginInfo.getFrameVCode());
                jSONObject.put("md5", pluginInfo.getMd5());
                jSONObject.put("loadTime", pluginInfo.getLoadTime());
                jSONObject.put("from", pluginInfo.getPluginFrom());
            } catch (JSONException e) {
                TdLogUtils.error("TdStringUtils", "pluginInfoToJson " + e.getMessage());
            }
            String string = jSONObject.toString();
            String pluginName = pluginInfo.getPluginName();
            if (!TextUtils.isEmpty(pluginName) && !TextUtils.isEmpty(string)) {
                TdLogUtils.log("TdPluginInfoManager", pluginInfo.toString());
                if (p0.a(context, pluginName, "plugin_info")) {
                    return;
                }
                SharedPreferences.Editor editorEdit = context.getSharedPreferences(pluginName, 0).edit();
                editorEdit.putString("plugin_info", string);
                editorEdit.commit();
                return;
            }
            TdLogUtils.error("TdPluginInfoManager", "pluginName or pluginString is null");
            return;
        }
        TdLogUtils.error("TdPluginInfoManager", "context or pluginInfo is null");
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0161 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[Catch: all -> 0x016c, SYNTHETIC, TRY_LEAVE, TryCatch #5 {all -> 0x016c, blocks: (B:31:0x00b3, B:61:0x016a, B:60:0x0167, B:38:0x00fe, B:44:0x0141, B:48:0x0155, B:56:0x0161), top: B:79:0x0064, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void a(PluginUpdateInfo pluginUpdateInfo, String str) {
        String str2;
        InputStream fileByteStream;
        InputStream inputStream;
        Throwable th;
        if (pluginUpdateInfo == null) {
            TdLogUtils.error("TdPluginInfoManager", "save download file pluginInfo is null!");
            return;
        }
        int pluginVersionCode = TideWholeConfig.getInstance().getPluginVersionCode(pluginUpdateInfo.pluginName);
        TideWholeConfig.getInstance().getHostVersionCode(pluginUpdateInfo.pluginName);
        TideWholeConfig.getInstance().getTideFrameCode();
        if (!pluginUpdateInfo.updateForce && pluginUpdateInfo.pluginCode <= pluginVersionCode) {
            TdLogUtils.log("TdPluginInfoManager", "saveUpdatePlugin not force update and code is wrong!");
            TdFileUtils.deleteFile(str);
            return;
        }
        String str3 = pluginUpdateInfo.pluginName;
        String randomID = TdFileUtils.getRandomID();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str4 = pluginUpdateInfo.pluginName;
        e0.a().onEvent("td_unzip_start", str4, new r0(str4, randomID, pluginUpdateInfo.pluginCode, TKDownloadReason.KSAD_TK_NET).b);
        try {
            fileByteStream = TdFileUtils.getFileByteStream(str);
        } catch (Throwable unused) {
            str2 = randomID;
        }
        try {
        } catch (Throwable unused2) {
            n0.a(str3, str2, -1, TKDownloadReason.KSAD_TK_NET, System.currentTimeMillis() - jCurrentTimeMillis, 0, 11004);
            return;
        }
        if (fileByteStream == null) {
            try {
                TdLogUtils.error("TdPluginInfoManager", "saveUpdatePlugin unzip net plugin, asset File inputStream fail");
                n0.a(pluginUpdateInfo.pluginName, randomID, pluginUpdateInfo.pluginCode, TKDownloadReason.KSAD_TK_NET, System.currentTimeMillis() - jCurrentTimeMillis, 0, Renderer.MSG_SURFACE_VIEW_DESTROY);
                if (fileByteStream != null) {
                    fileByteStream.close();
                }
                return;
            } catch (Throwable th2) {
                th = th2;
                inputStream = fileByteStream;
                str2 = randomID;
            }
        } else {
            try {
                PluginInfo pluginInfoA = g0.a(t0.b, fileByteStream, str3);
                try {
                    if (pluginInfoA == null) {
                        TdLogUtils.error("TdPluginInfoManager", "saveUpdatePlugin unzip net plugin, asset pluginInfo is empty");
                        n0.a(str3, randomID, pluginUpdateInfo.pluginCode, TKDownloadReason.KSAD_TK_NET, System.currentTimeMillis() - jCurrentTimeMillis, 0, Renderer.MSG_ENABLE_VIDEO_RENDER_STUCK_DETECTOR);
                        fileByteStream.close();
                        return;
                    }
                    TdLogUtils.log("TdPluginInfoManager", "saveUpdatePlugin SP保存下载的插件版本号 " + pluginInfoA.getPluginVCode());
                    p0.a(t0.b, str3, pluginInfoA.getPluginVCode());
                    if (!g0.a(fileByteStream, pluginInfoA.getPluginPath())) {
                        n0.a(str3, randomID, pluginUpdateInfo.pluginCode, TKDownloadReason.KSAD_TK_NET, System.currentTimeMillis() - jCurrentTimeMillis, 0, 11003);
                        TdFileUtils.deleteFile(str);
                        TdFileUtils.deleteFile(pluginInfoA.getPluginPath());
                        fileByteStream.close();
                        return;
                    }
                    n0.a(str3, randomID, pluginUpdateInfo.pluginCode, TKDownloadReason.KSAD_TK_NET, System.currentTimeMillis() - jCurrentTimeMillis, 1, -1);
                    pluginInfoA.setPluginFrom(TKDownloadReason.KSAD_TK_NET);
                    if (!g0.a(pluginInfoA)) {
                        TdLogUtils.error("TdPluginInfoManager", "saveUpdatePlugin plugin file is not valid");
                        TdLogUtils.log("TdPluginInfoManager", "saveUpdatePlugin SP删除下载的插件版本号 " + pluginInfoA.getPluginVCode());
                        p0.a(t0.b, str3, -1);
                        fileByteStream.close();
                        return;
                    }
                    TdLogUtils.log("TdPluginInfoManager", "saveUpdatePlugin plugin file is valid, save Info to sp");
                    a(t0.b, pluginInfoA);
                    TdFileUtils.deleteFile(str);
                    fileByteStream.close();
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    if (inputStream == null) {
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = fileByteStream;
                str2 = randomID;
            }
            th = th;
        }
        if (inputStream == null) {
            try {
                inputStream.close();
                throw th;
            } catch (Throwable th5) {
                th.addSuppressed(th5);
                throw th;
            }
        }
        throw th;
    }

    public final synchronized PluginInfo a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return TideWholeConfig.getInstance().getPluginInfo(str);
    }

    public final synchronized void a(PluginInfo pluginInfo) {
        if (pluginInfo == null) {
            return;
        }
        if (TextUtils.isEmpty(pluginInfo.getPluginName())) {
            return;
        }
        TideWholeConfig.getInstance().putPluginInfo(pluginInfo.getPluginName(), pluginInfo);
    }
}
