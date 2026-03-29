package com.bytedance.pangle.plugin;

import android.content.pm.PackageInfo;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.b.nr;
import com.bytedance.pangle.iz.iz;
import com.bytedance.pangle.jk;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.u.u;
import com.bytedance.pangle.util.a;
import com.bytedance.pangle.util.mv;
import com.bytedance.pangle.util.n;
import com.huawei.openalliance.ad.constant.az;
import com.huawei.openalliance.ad.constant.x;
import com.qiniu.android.collect.ReportItem;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    private static final jk u = jk.u();

    /* JADX INFO: Access modifiers changed from: private */
    public static String a(File file, String str, int i, StringBuffer stringBuffer) throws u {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strNr = com.bytedance.pangle.pn.fx.nr(str, i);
        try {
            try {
                n.u(file.getAbsolutePath(), strNr);
                return strNr;
            } catch (Exception e) {
                u(com.bytedance.pangle.b.nr.pn, nr.u.q, str, i, -1L, null);
                u.u(1100, -6, str, i, e);
                throw new u("安装包拷贝失败", e);
            }
        } finally {
            stringBuffer.append("copyApk cost:");
            stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
            stringBuffer.append(x.aQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void iz(File file, String str, int i, StringBuffer stringBuffer) throws u {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                StringBuilder sb = new StringBuilder();
                if (com.bytedance.pangle.n.pn.u(file.getAbsolutePath(), str, sb)) {
                } else {
                    throw new RuntimeException("安装包签名校验失败[1]:".concat(String.valueOf(sb)));
                }
            } catch (Exception e) {
                u(com.bytedance.pangle.b.nr.pn, nr.u.dw, str, i, -1L, Log.getStackTraceString(e));
                u.u(1100, -3, str, i, e);
                throw new u(e.getMessage(), e);
            }
        } finally {
            stringBuffer.append("checkSignature cost:");
            stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
            stringBuffer.append(x.aQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean jk(File file, String str, int i, StringBuffer stringBuffer) throws u {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                if (a.fx()) {
                    com.bytedance.pangle.iz.x.u(file, str, i);
                    com.bytedance.pangle.iz.nr.u(Zeus.getAppApplication()).edit().putInt(str, i).apply();
                    iz.u();
                } else if (a.n()) {
                    String strFx = com.bytedance.pangle.pn.fx.fx(str, i);
                    String strNr = com.bytedance.pangle.pn.fx.nr(str, i);
                    StringBuilder sb = new StringBuilder();
                    sb.append(strFx);
                    String str2 = File.separator;
                    sb.append(str2);
                    sb.append(com.bytedance.pangle.iz.nr.u(strNr));
                    String string = sb.toString();
                    if (com.bytedance.pangle.iz.nr.u(strNr, strFx + str2 + com.bytedance.pangle.iz.nr.u(strNr)) && com.bytedance.pangle.iz.nr.u(string)) {
                        stringBuffer.append("dexOpt1 cost:");
                        stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
                        stringBuffer.append(x.aQ);
                        return true;
                    }
                }
                stringBuffer.append("dexOpt1 cost:");
                stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
                stringBuffer.append(x.aQ);
                return false;
            } catch (Exception e) {
                u(com.bytedance.pangle.b.nr.pn, nr.u.z, str, i, -1L, null);
                throw new u("dexOpt1失败", e);
            }
        } catch (Throwable th) {
            stringBuffer.append("dexOpt1 cost:");
            stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
            stringBuffer.append(x.aQ);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(File file, String str, int i, StringBuffer stringBuffer) throws u {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 4096);
                PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 4096);
                List listAsList = Arrays.asList(packageInfo.requestedPermissions);
                String[] strArr = packageArchiveInfo.requestedPermissions;
                if (strArr != null && strArr.length > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (String str2 : packageArchiveInfo.requestedPermissions) {
                        if (!listAsList.contains(str2)) {
                            arrayList.add(str2);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        ZeusLogger.w("PluginInstaller", "The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)));
                        if (GlobalParam.getInstance().checkPermission()) {
                            throw new u("The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)));
                        }
                    }
                }
            } catch (Exception e) {
                u(com.bytedance.pangle.b.nr.pn, nr.u.c, str, i, -1L, null);
                u.u(1100, -4, str, i, e);
                throw new u("安装包权限校验失败", e);
            }
        } finally {
            stringBuffer.append("checkPermissions cost:");
            stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
            stringBuffer.append(x.aQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, List<ZipEntry>> x(File file, String str, int i, StringBuffer stringBuffer) throws u {
        String str2 = "插件包包含so不符合宿主ABI类型";
        if (!GlobalParam.getInstance().checkMatchHostAbi()) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                com.bytedance.pangle.util.pn<Boolean, Map<String, List<ZipEntry>>> pnVarU = com.bytedance.pangle.pn.nr.u(file);
                boolean zBooleanValue = pnVarU.u.booleanValue();
                Map<String, List<ZipEntry>> map = pnVarU.nr;
                if (zBooleanValue) {
                    return map;
                }
                throw new u(str2);
            } catch (Exception e) {
                u(com.bytedance.pangle.b.nr.pn, nr.u.gi, str, i, -1L, null);
                u.u(1100, -5, str, i, e);
                throw new u(str2, e);
            }
        } finally {
            stringBuffer.append("checkMatchHostAbi cost:");
            stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
            stringBuffer.append(x.aQ);
        }
        stringBuffer.append("checkMatchHostAbi cost:");
        stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
        stringBuffer.append(x.aQ);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u extends IOException {
        private u(String str) {
            super(str);
        }

        private u(String str, Throwable th) {
            super(str, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fx(String str, int i) throws u {
        try {
            if (a.x() || a.a()) {
                mv.u().fx(str, i, false);
                com.bytedance.pangle.iz.nr.u(Zeus.getAppApplication()).edit().putInt(str, i).apply();
                iz.u();
            }
        } catch (Exception e) {
            u(com.bytedance.pangle.b.nr.pn, nr.u.z, str, i, -1L, null);
            throw new u("dexOpt2失败", e);
        }
    }

    private static void nr(String str, int i) {
        int iNr = mv.u().nr(str, i, az.ah);
        int iNr2 = mv.u().nr(str, i, "load");
        int removeApkEntryFlag = GlobalParam.getInstance().getRemoveApkEntryFlag(str);
        if (iNr > 3 || iNr2 > 3) {
            removeApkEntryFlag = 0;
        }
        mv.u().u(str, i, removeApkEntryFlag);
        mv.u().b(str, i, false);
    }

    public static boolean u(final File file, final String str, final int i) {
        final StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("useOpt;");
        final boolean[] zArr = {false};
        try {
            jk jkVar = u;
            jkVar.u(1000, 0, str, i, null);
            com.bytedance.pangle.log.u uVarU = com.bytedance.pangle.log.u.u(ZeusLogger.TAG_INSTALL, "PluginInstaller", "install:".concat(String.valueOf(str)));
            u(com.bytedance.pangle.b.nr.b, nr.u.sx, str, i, -1L, null);
            nr(str, i);
            com.bytedance.pangle.util.x.u(com.bytedance.pangle.pn.fx.u(str, i));
            com.bytedance.pangle.u.u.u(false, new u.InterfaceC0201u() { // from class: com.bytedance.pangle.plugin.fx.1
                @Override // com.bytedance.pangle.u.u.InterfaceC0201u
                public void u() throws Throwable {
                    fx.iz(file, str, i, stringBuffer);
                }
            }, new u.InterfaceC0201u() { // from class: com.bytedance.pangle.plugin.fx.2
                @Override // com.bytedance.pangle.u.u.InterfaceC0201u
                public void u() throws Throwable {
                    final Map mapX = fx.x(file, str, i, stringBuffer);
                    fx.n(file, str, i, stringBuffer);
                    fx.nr(fx.a(file, str, i, stringBuffer), str, i, stringBuffer);
                    if (a.n() || a.fx()) {
                        final boolean[] zArr2 = {false};
                        com.bytedance.pangle.u.u.u(false, new u.InterfaceC0201u() { // from class: com.bytedance.pangle.plugin.fx.2.1
                            @Override // com.bytedance.pangle.u.u.InterfaceC0201u
                            public void u() throws Throwable {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                fx.nr(str, i, (Map<String, List<ZipEntry>>) mapX, stringBuffer);
                            }
                        }, new u.InterfaceC0201u() { // from class: com.bytedance.pangle.plugin.fx.2.2
                            @Override // com.bytedance.pangle.u.u.InterfaceC0201u
                            public void u() throws Throwable {
                                boolean[] zArr3 = zArr2;
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                zArr3[0] = fx.jk(file, str, i, stringBuffer);
                            }
                        });
                        zArr[0] = fx.nr(str, i, zArr2[0], stringBuffer);
                    } else {
                        fx.nr(str, i, (Map<String, List<ZipEntry>>) mapX, stringBuffer);
                        zArr[0] = fx.nr(str, i, false, stringBuffer);
                        fx.fx(str, i);
                    }
                }
            });
            com.bytedance.pangle.util.x.u(file);
            u(com.bytedance.pangle.b.nr.pn, nr.u.bg, str, i, uVarU.u(), stringBuffer.toString());
            uVarU.u("success");
            jkVar.u(1100, 0, str, i, null);
            return true;
        } catch (Throwable th) {
            if (th instanceof u) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str + " install failed.", th);
            } else {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str + " install failed unknown error.", th);
                u(com.bytedance.pangle.b.nr.pn, nr.u.bq, str, i, -1L, stringBuffer.toString());
                u.u(1100, -1, str, i, th);
            }
            if (zArr[0]) {
                mv.u().u(str, i, az.ah);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean nr(String str, int i, boolean z, StringBuffer stringBuffer) {
        int iA = mv.u().a(str, i);
        boolean z2 = (iA & 1) != 0;
        boolean z3 = (iA & 2) != 0;
        if (!z2 && !z3) {
            stringBuffer.append("removeEntry skip;");
            return false;
        }
        boolean z4 = z && z2;
        String strNr = com.bytedance.pangle.pn.fx.nr(str, i);
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zU = com.bytedance.pangle.util.nr.nr.u(strNr, z4, z3, str, i, 1);
        stringBuffer.append("removeEntry cost:");
        stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
        stringBuffer.append(x.aQ);
        return zU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nr(String str, String str2, int i, StringBuffer stringBuffer) throws u {
        long jCurrentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        int iU = new com.bytedance.pangle.res.u.fx().u(new File(str), false, sb);
        stringBuffer.append(iU == 100 ? "modifyRes" : "noModifyRes");
        stringBuffer.append(" cost:");
        stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
        stringBuffer.append(x.aQ);
        if (iU == 100 || iU == 200) {
            return;
        }
        String string = sb.toString();
        u(com.bytedance.pangle.b.nr.pn, nr.u.d, str2, i, -1L, string);
        u.u(1100, -2, str2, i, null);
        throw new u("modifyRes failed. result = " + iU + ", errorLog = " + string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nr(String str, int i, Map<String, List<ZipEntry>> map, StringBuffer stringBuffer) throws u {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                com.bytedance.pangle.pn.nr.u(new File(com.bytedance.pangle.pn.fx.nr(str, i)), new File(com.bytedance.pangle.pn.fx.b(str, i)), str, map);
            } catch (Exception e) {
                u(com.bytedance.pangle.b.nr.pn, nr.u.qq, str, i, -1L, com.bytedance.pangle.log.nr.u((Object) e));
                u.u(1100, -7, str, i, e);
                throw new u("安装包动态库拷贝失败", e);
            }
        } finally {
            stringBuffer.append("copySo cost:");
            stringBuffer.append(System.currentTimeMillis() - jCurrentTimeMillis);
            stringBuffer.append(x.aQ);
        }
    }

    public static void u(String str, int i, @NonNull String str2, int i2, long j, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt(ReportItem.RequestKeyStatusCode, com.bytedance.pangle.log.nr.u(Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.nr.u(str2));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.nr.u(Integer.valueOf(i2)));
            jSONObject3.putOpt("duration", Integer.valueOf(com.bytedance.pangle.log.nr.nr(Long.valueOf(j))));
            jSONObject2.putOpt("message", com.bytedance.pangle.log.nr.u(str3));
        } catch (JSONException e) {
            com.bytedance.sdk.openadsdk.api.iz.u(e);
        }
        com.bytedance.pangle.b.nr.u().u(str, jSONObject, jSONObject3, jSONObject2);
    }
}
