package com.bytedance.sdk.openadsdk.core.ja.u;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.jk.x;
import com.bytedance.sdk.component.utils.gi;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.ja.nr.fx;
import com.bytedance.sdk.openadsdk.core.ja.nr.pn;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.pb.jk;
import com.bytedance.sdk.openadsdk.core.qq.s;
import com.bytedance.sdk.openadsdk.my.b;
import com.bytedance.sdk.openadsdk.my.pn;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import defpackage.ll7;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f5286a;
    private static final String fx;
    private static long n;
    private static final String nr;
    private static final nr pn;
    private static final String u;
    private static final HashMap<String, String> x;
    private FileOutputStream b;
    private Function<SparseArray<Object>, Object> iz;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.ja.u.nr$nr, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C0262nr extends Exception {
        private final int u;

        public C0262nr(int i, String str) {
            super(str);
            this.u = i;
        }

        public int u() {
            return this.u;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5287a;
        public String b;
        public String fx;
        public String iz;
        public int jk;
        public int n;
        public int nr;
        public String pn;
        public String t;
        public String u;
        public boolean x;

        private u() {
        }

        public String toString() {
            try {
                return new JSONObject().put("package_name", this.u).put("version_code", this.nr).put("sign", this.pn).put("max_version", this.f5287a).put("min_version", this.n).put("is_revert", this.x).put("md5", this.iz).put("plugin_file", this.t).toString();
            } catch (JSONException unused) {
                return "";
            }
        }

        public boolean u() {
            return TextUtils.equals(this.u, "com.byted.mixed");
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        String str = File.separator;
        sb.append(str);
        sb.append("next");
        u = sb.toString();
        nr = str + "tmp";
        fx = str + "conf";
        pn = new nr();
        x = new HashMap<>();
    }

    private nr() {
    }

    private static File b(Context context) {
        return new File(fx(context), nr);
    }

    private static File fx(Context context) {
        return com.bytedance.sdk.openadsdk.api.plugin.nr.u(context, "tt_pangle_bykv_file", 0);
    }

    private static File iz(Context context) {
        return new File(fx(context), fx);
    }

    private static File pn(Context context) {
        return new File(fx(context), u);
    }

    private static int b(u uVar) {
        int iNr;
        if (u(uVar)) {
            iNr = 7232;
        } else {
            if (!n.o().wq().has(uVar.u)) {
                return 0;
            }
            JSONObject jSONObjectOptJSONObject = n.o().wq().optJSONObject(uVar.u);
            iNr = jSONObjectOptJSONObject != null ? nr(jSONObjectOptJSONObject.optString(PluginConstants.KEY_PLUGIN_VERSION)) : 0;
        }
        return iNr;
    }

    private static boolean fx(u uVar) {
        if (u(uVar)) {
            return 7232 == uVar.nr;
        }
        JSONObject jSONObjectOptJSONObject = n.o().wq().optJSONObject(uVar.u);
        return (jSONObjectOptJSONObject != null ? nr(jSONObjectOptJSONObject.optString(PluginConstants.KEY_PLUGIN_VERSION)) : 0) == uVar.nr;
    }

    private void nr(Context context) {
        FileOutputStream fileOutputStream = this.b;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception unused) {
            }
        }
        File fileB = b(context);
        if (fileB.exists()) {
            for (File file : fileB.listFiles()) {
                try {
                    if (!"update.lock".equals(file.getName())) {
                        file.delete();
                    }
                } catch (Exception unused2) {
                }
            }
        }
    }

    public static nr u() {
        return pn;
    }

    public void u(final JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        final Context applicationContext = dw.getContext().getApplicationContext();
        x.nr(new a("updatePlugin") { // from class: com.bytedance.sdk.openadsdk.core.ja.u.nr.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    nr.this.u(applicationContext, (List<u>) nr.fx(jSONArray));
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<u> fx(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                u uVar = new u();
                uVar.u = u(jSONObjectOptJSONObject.optString("package_name"));
                uVar.nr = jSONObjectOptJSONObject.optInt("version_code");
                uVar.fx = jSONObjectOptJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
                uVar.b = jSONObjectOptJSONObject.optString(WfConstant.EXTRA_KEY_DOWNLOAD_URL);
                uVar.pn = jSONObjectOptJSONObject.optString("sign");
                uVar.n = nr(jSONObjectOptJSONObject.optString("min_version"));
                uVar.f5287a = nr(jSONObjectOptJSONObject.optString("max_version"));
                uVar.jk = jSONObjectOptJSONObject.optInt("plugin_update_network", -2);
                arrayList.add(uVar);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean u(Context context, int i, String str) {
        int iU = n.o().z().u(str);
        if (n.o().wi()) {
            return u(iU);
        }
        if (i == -1) {
            i = iU;
        } else if (i != 1 && i != 2 && i != 3) {
            if (i == 4 || i == 5) {
                return false;
            }
            if (iU == 3) {
                i = 1;
            }
        }
        return u(i);
    }

    private boolean nr(u uVar, int i) {
        u(uVar);
        return (i == 21 || i == 18) ? false : true;
    }

    private static boolean nr(u uVar) {
        int iNr;
        JSONObject jSONObjectOptJSONObject;
        if (u(uVar)) {
            iNr = d.fx;
        } else {
            iNr = (!n.o().wq().has(uVar.u) || (jSONObjectOptJSONObject = n.o().wq().optJSONObject(uVar.u)) == null) ? 0 : nr(jSONObjectOptJSONObject.optString("sdk_version"));
        }
        return iNr >= uVar.n && iNr <= uVar.f5287a;
    }

    private boolean u(int i) {
        if (i != 1) {
            if (i == 3 || i == 4 || i == 5) {
                return false;
            }
        } else if (!o.b(dw.getContext())) {
            return false;
        }
        return true;
    }

    public void u(Function<SparseArray<Object>, Object> function) {
        this.iz = function;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final Context context, List<u> list) {
        synchronized ("__tt_pl_up_lock__") {
            try {
                try {
                } catch (Exception e) {
                    s.u().u("", 7232, 0, "", 14, e.getMessage(), 0L, false);
                }
                if (u(context)) {
                    list.size();
                    final CountDownLatch countDownLatch = new CountDownLatch(list.size());
                    for (final u uVar : list) {
                        x.nr(new a("pl download") { // from class: com.bytedance.sdk.openadsdk.core.ja.u.nr.2
                            @Override // java.lang.Runnable
                            public void run() throws Exception {
                                nr.this.u(context, uVar, false);
                                countDownLatch.countDown();
                            }
                        });
                    }
                    countDownLatch.await();
                }
            } finally {
                nr(context);
            }
        }
    }

    private static boolean nr(int i) {
        File fileU = com.bytedance.sdk.openadsdk.api.plugin.nr.u(dw.getContext());
        if (fileU == null) {
            return false;
        }
        return new File(fileU.getParent() + "/pangle_p/com.byted.pangle/version-" + i).exists();
    }

    public static String nr() {
        String str;
        String strU = com.bytedance.sdk.openadsdk.core.ja.nr.nr.u();
        if ("arm64-v8a".equals(strU)) {
            str = "@64";
        } else if ("armeabi-v7a".equals(strU)) {
            str = "@32";
        } else {
            str = "armeabi".equals(strU) ? "@armeabi" : "";
        }
        return "com.byted.live.lite" + str;
    }

    private static int nr(String str) {
        if (str != null) {
            try {
                return Integer.parseInt(str.replace(".", ""));
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    private boolean u(Context context) {
        try {
            File fileB = b(context);
            if (!fileB.exists()) {
                fileB.mkdirs();
            }
            File file = new File(fileB, "update.lock");
            if (!file.exists()) {
                file.createNewFile();
            }
            if (!file.exists()) {
                return false;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            this.b = fileOutputStream;
            FileLock fileLockTryLock = fileOutputStream.getChannel().tryLock();
            if (fileLockTryLock != null && fileLockTryLock.isValid()) {
                return true;
            }
            this.b.close();
            return false;
        } catch (Throwable unused) {
            FileOutputStream fileOutputStream2 = this.b;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused2) {
                }
            }
            return false;
        }
    }

    private static boolean u(u uVar) {
        return "com.byted.pangle".equals(uVar.u);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(Context context, u uVar, boolean z) throws Exception {
        String str;
        int i;
        boolean z2;
        int iU;
        try {
            if (!u(context, uVar.jk, uVar.u)) {
                str = n.o().z() + ":" + uVar.jk;
                z2 = false;
                iU = 0;
                i = 20;
            } else {
                try {
                    iU = u(context, b(context), uVar, z);
                    str = "";
                    i = iU;
                    z2 = true;
                } catch (C0262nr e) {
                    e = e;
                    int iU2 = e.u();
                    String message = e.getMessage();
                    u(uVar.u, 1004);
                    str = message;
                    i = iU2;
                    z2 = false;
                    iU = 0;
                }
            }
        } catch (C0262nr e2) {
            e = e2;
        }
        s.u().u(uVar.u, u(uVar) ? 7232 : 0, uVar.nr, uVar.b, i, str, f5286a - n, z);
        if (z2) {
            u(uVar, iU);
        }
    }

    private void u(u uVar, int i) {
        SparseArray<Object> sparseArrayNr;
        PluginValueSet pluginValueSetA;
        if (this.iz == null || !nr(uVar, i)) {
            return;
        }
        SparseArray<Object> sparseArrayNr2 = b.u().u(2, uVar.toString()).u(3, uVar.u).nr();
        boolean z = i == 6 || i == 10 || i == 16;
        SparseArray<Object> sparseArrayNr3 = pn.u().u(z).u(z ? 0 : 1004).u(sparseArrayNr2).nr();
        try {
            if (com.bytedance.sdk.openadsdk.my.fx.b.u(d.fx)) {
                sparseArrayNr = b.u(sparseArrayNr3).u(1).u(SparseArray.class).nr();
            } else {
                sparseArrayNr = b.u().u(1).u(SparseArray.class).u(-99999979, sparseArrayNr3).nr();
            }
            Object objApply = this.iz.apply(sparseArrayNr);
            if (objApply instanceof SparseArray) {
                pluginValueSetA = ll7.j((SparseArray) objApply).a();
            } else {
                pluginValueSetA = (com.bytedance.sdk.openadsdk.my.fx.b.u(d.fx) && (objApply instanceof PluginValueSet)) ? (PluginValueSet) objApply : null;
            }
            if (pluginValueSetA == null || !pluginValueSetA.booleanValue(4) || uVar.t == null) {
                return;
            }
            HashMap<String, String> map = x;
            map.put(uVar.u, new File(uVar.t).getName());
            u(uVar.u, uVar.fx);
            map.values();
        } catch (Exception e) {
            k.u("PluginUpdater", "Download pl done, but install error:" + e.getMessage());
        }
    }

    private static void u(String str, String str2) {
        if (str == null) {
            return;
        }
        n.o().u(str, str2);
    }

    private int u(Context context, File file, u uVar, boolean z) throws Exception {
        com.bytedance.sdk.component.a.nr nrVarU;
        String str;
        if (uVar != null) {
            try {
                if (!TextUtils.isEmpty(uVar.b)) {
                    if (TextUtils.isEmpty(uVar.u)) {
                        return 12;
                    }
                    if (!u(uVar) && !n.o().wq().has(uVar.u)) {
                        return 17;
                    }
                    if (fx(uVar)) {
                        return 18;
                    }
                    if (nr(uVar.nr)) {
                        return 21;
                    }
                    if (!nr(uVar)) {
                        return 19;
                    }
                    File fileIz = iz(context);
                    if (!fileIz.exists()) {
                        fileIz.mkdirs();
                    }
                    boolean z2 = true;
                    if (u(uVar) && d.fx >= uVar.nr) {
                        String str2 = "-" + com.bytedance.sdk.component.utils.x.nr(uVar.u) + "-" + d.fx + "-" + d.fx;
                        int i = d.fx;
                        uVar.f5287a = i;
                        uVar.n = i;
                        uVar.x = true;
                        u(new File(fileIz, str2 + ".conf"), uVar);
                        return 10;
                    }
                    if (TextUtils.isEmpty(uVar.pn) && !uVar.u()) {
                        return 1;
                    }
                    String strNr = com.bytedance.sdk.component.utils.x.nr(uVar.u);
                    StringBuilder sb = new StringBuilder();
                    String strNr2 = com.bytedance.sdk.component.utils.x.nr(uVar.pn);
                    if (!TextUtils.isEmpty(strNr2)) {
                        sb.append(strNr2);
                        sb.append("-");
                    }
                    sb.append(strNr);
                    sb.append("-");
                    sb.append(uVar.n);
                    sb.append("-");
                    sb.append(uVar.f5287a);
                    String string = sb.toString();
                    File filePn = pn(context);
                    if (!filePn.exists()) {
                        filePn.mkdirs();
                    }
                    File file2 = new File(filePn, string + (uVar.u() ? ".dex.zip" : com.huawei.hms.ads.dynamicloader.b.b));
                    if (file2.exists()) {
                        uVar.iz = com.bytedance.sdk.component.utils.x.u(file2);
                        uVar.t = file2.getAbsolutePath();
                        return 16;
                    }
                    if (file2.getName().equals(x.get(uVar.u))) {
                        return 21;
                    }
                    s.u().u(uVar.u, u(uVar) ? 7232 : 0, uVar.nr, uVar.b, 7, "", 0L, z);
                    File file3 = new File(file, string);
                    n = System.currentTimeMillis();
                    if (jk.u(uVar.u)) {
                        nrVarU = u(com.bytedance.sdk.openadsdk.core.gi.pn.u().nr().u(uVar.b, file.getAbsolutePath(), string), uVar.u);
                    } else {
                        com.bytedance.sdk.component.a.nr.nr nrVarB = com.bytedance.sdk.openadsdk.core.gi.pn.u().nr().b();
                        nrVarB.u(uVar.b);
                        nrVarB.u(file.getAbsolutePath(), string);
                        nrVarU = nrVarB.u();
                    }
                    if (nrVarU != null && nrVarU.a()) {
                        f5286a = System.currentTimeMillis();
                        if (!file3.exists()) {
                            return 13;
                        }
                        u(filePn, strNr);
                        u(fileIz, strNr);
                        if (!file3.renameTo(file2)) {
                            return 5;
                        }
                        File file4 = new File(fileIz, file3.getName() + ".conf");
                        uVar.iz = com.bytedance.sdk.component.utils.x.u(file2);
                        uVar.t = file2.getAbsolutePath();
                        if (uVar.nr >= b(uVar)) {
                            z2 = false;
                        }
                        uVar.x = z2;
                        return u(file4, uVar) ? 6 : 15;
                    }
                    if (nrVarU != null) {
                        str = nrVarU.nr() + " : " + nrVarU.fx();
                    } else {
                        str = "no response";
                    }
                    throw new C0262nr(9, str);
                }
            } catch (Exception e) {
                u(context, uVar);
                if (e instanceof C0262nr) {
                    throw e;
                }
                String message = e.getMessage();
                try {
                    message = Log.getStackTraceString(e);
                } catch (Throwable unused) {
                }
                throw new C0262nr(14, message);
            }
        }
        return 2;
    }

    private static com.bytedance.sdk.component.a.nr u(final com.bytedance.sdk.component.a.nr.nr nrVar, final String str) throws C0262nr {
        try {
            return (com.bytedance.sdk.component.a.nr) new pn.u(new Callable<com.bytedance.sdk.component.a.nr>() { // from class: com.bytedance.sdk.openadsdk.core.ja.u.nr.3
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public com.bytedance.sdk.component.a.nr call() {
                    return nrVar.u();
                }
            }, new pn.nr<com.bytedance.sdk.component.a.nr>() { // from class: com.bytedance.sdk.openadsdk.core.ja.u.nr.4
                @Override // com.bytedance.sdk.openadsdk.core.ja.nr.pn.nr
                public boolean u(com.bytedance.sdk.component.a.nr nrVar2) {
                    if (gi.u(dw.getContext(), 0L) == 0 || nrVar2 == null) {
                        return false;
                    }
                    Throwable thU = nrVar2.u();
                    return thU != null ? com.bytedance.sdk.openadsdk.core.ja.nr.pn.u(thU) : com.bytedance.sdk.openadsdk.core.ja.nr.pn.u(nrVar2.nr());
                }

                @Override // com.bytedance.sdk.openadsdk.core.ja.nr.pn.nr
                public boolean u(Exception exc) {
                    if (gi.u(dw.getContext(), 0L) == 0) {
                        return false;
                    }
                    return exc instanceof NullPointerException;
                }
            }).u(jk.nr(str)).u().u();
        } catch (Exception e) {
            String message = e.getMessage();
            try {
                message = Log.getStackTraceString(e);
            } catch (Throwable unused) {
            }
            throw new C0262nr(14, message);
        }
    }

    private void u(final Context context, final u uVar) {
        if (jk.u(uVar.u) && gi.u(dw.getContext(), 0L) == 0) {
            fx.u().u(new fx.nr() { // from class: com.bytedance.sdk.openadsdk.core.ja.u.nr.5
                @Override // com.bytedance.sdk.openadsdk.core.ja.nr.fx.nr
                public void u() throws Exception {
                    nr.this.u(context, uVar, true);
                }
            });
        }
    }

    private static boolean u(File file, u uVar) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(uVar.toString());
            fileWriter.close();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    private static void u(File file, final String str) {
        file.listFiles(new FilenameFilter() { // from class: com.bytedance.sdk.openadsdk.core.ja.u.nr.6
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str2) {
                if (str2 == null || !str2.contains(str)) {
                    return false;
                }
                new File(file2, str2).delete();
                return false;
            }
        });
    }

    public static String u(String str) {
        return ("com.byted.live.lite@64".equals(str) || "com.byted.live.lite@32".equals(str) || "com.byted.live.lite@armeabi".equals(str)) ? "com.byted.live.lite" : str;
    }

    public void u(String str, int i) {
        SparseArray<Object> sparseArrayNr;
        if (this.iz == null) {
            return;
        }
        SparseArray<Object> sparseArrayNr2 = com.bytedance.sdk.openadsdk.my.pn.u().u(false).u(i).u(b.u().u(3, str).nr()).nr();
        int i2 = d.fx;
        if (i2 < 7000 && i2 >= 6800) {
            sparseArrayNr = b.u(sparseArrayNr2).u(1).u(Void.class).nr();
        } else {
            sparseArrayNr = b.u().u(1).u(Void.class).u(-99999979, sparseArrayNr2).nr();
        }
        this.iz.apply(sparseArrayNr);
    }
}
