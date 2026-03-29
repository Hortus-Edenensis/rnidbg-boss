package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.provider.FontsContractCompat;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.a.n;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.u.u;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class nr {
    private static u fx = null;
    private static fx nr = null;
    private static final String u = "nr";

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements Callable<Boolean> {
        private final long b;
        private final Handler fx;
        private final InterfaceC0857nr nr;
        private final Context u;

        public b(Handler handler, Context context, InterfaceC0857nr interfaceC0857nr, long j) {
            this.u = context;
            this.nr = interfaceC0857nr;
            this.fx = handler;
            this.b = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            InterfaceC0857nr interfaceC0857nr;
            try {
                interfaceC0857nr = this.nr;
            } catch (Throwable unused) {
            }
            if (interfaceC0857nr != null) {
                long j = this.b;
                if (j > 0 && j <= 10000) {
                    Context context = this.u;
                    boolean zU = context != null ? interfaceC0857nr.u(context) : false;
                    Message messageObtain = Message.obtain();
                    if (zU) {
                        messageObtain.what = 2;
                        this.fx.sendMessage(messageObtain);
                    } else {
                        messageObtain.what = 1;
                        this.fx.sendMessageDelayed(messageObtain, this.b);
                    }
                    return Boolean.FALSE;
                }
            }
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface fx {
        void u(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.u uVar);
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.appdownloader.nr$nr, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0857nr {
        boolean u(@NonNull Context context);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class pn implements n.u {
        private static int nr;
        public static int u;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f10598a = false;
        private final Intent b;
        private final Context fx;
        private final Handler iz;
        private Future<Boolean> n;
        private final InterfaceC0857nr pn;
        private final long x;

        public pn(Context context, Intent intent, int i, InterfaceC0857nr interfaceC0857nr, long j) {
            this.fx = context;
            this.b = intent;
            nr = i;
            this.pn = interfaceC0857nr;
            this.iz = new com.ss.android.socialbase.downloader.a.n(Looper.getMainLooper(), this);
            this.x = j;
        }

        @Override // com.ss.android.socialbase.downloader.a.n.u
        public void u(Message message) {
            if (message != null) {
                int i = message.what;
                if (i == 1) {
                    long j = this.x;
                    if (j <= 0 || j > 10000) {
                        return;
                    }
                    u = 1;
                    this.n = com.ss.android.socialbase.downloader.downloader.fx.l().submit(new b(this.iz, this.fx, this.pn, this.x));
                    return;
                }
                if (i == 2) {
                    u = 2;
                    this.iz.removeMessages(2);
                    this.iz.removeMessages(1);
                    Future<Boolean> future = this.n;
                    if (future != null) {
                        future.cancel(true);
                    }
                    if (!this.f10598a && (Build.VERSION.SDK_INT < 29 || com.ss.android.socialbase.downloader.u.u.u().nr())) {
                        Intent intent = this.b;
                        if (intent != null) {
                            nr.nr(this.fx, intent);
                        } else {
                            DownloadInfo downloadInfo = Downloader.getInstance(this.fx).getDownloadInfo(nr);
                            if (downloadInfo != null && downloadInfo.isDownloadOverStatus()) {
                                com.ss.android.socialbase.appdownloader.fx.nr(this.fx, nr, false);
                            }
                        }
                        this.f10598a = true;
                    }
                    nr.nr(nr, this.b == null, nr.u(this.fx));
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u implements u.InterfaceC0886u {
        private JSONObject fx;
        private final int nr;
        private final pn u;

        public u(Context context, Intent intent, int i, JSONObject jSONObject, InterfaceC0857nr interfaceC0857nr) {
            this.fx = jSONObject;
            int iOptInt = jSONObject.optInt("query_interval", 1000);
            this.nr = iOptInt;
            this.u = new pn(context, intent, i, interfaceC0857nr, iOptInt);
        }

        @Override // com.ss.android.socialbase.downloader.u.u.InterfaceC0886u
        public void fx() {
            int iOptInt = this.fx.optInt("time_out_second", 20);
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            this.u.iz.sendMessage(messageObtain);
            if (iOptInt <= 0 || iOptInt >= 60) {
                return;
            }
            Message messageObtain2 = Message.obtain();
            messageObtain2.what = 2;
            this.u.iz.sendMessageDelayed(messageObtain2, iOptInt * 1000);
        }

        @Override // com.ss.android.socialbase.downloader.u.u.InterfaceC0886u
        public void nr() {
            if (!this.u.f10598a) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 2;
                this.u.iz.sendMessage(messageObtain);
            }
            com.ss.android.socialbase.downloader.u.u.u().nr(this);
            u unused = nr.fx = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "install_non_market_apps", 1) > 0;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 26)
    public static boolean pn(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return context.getPackageManager().canRequestPackageInstalls();
        } catch (Throwable unused) {
            return true;
        }
    }

    private static void b(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception unused) {
        }
        com.ss.android.socialbase.downloader.downloader.fx.cj().nr(i, "guide_auth_dialog_show", jSONObject2);
    }

    public static void fx(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception unused) {
        }
        com.ss.android.socialbase.downloader.downloader.fx.cj().nr(i, "guide_auth_open_setting", jSONObject2);
    }

    private static boolean nr(Context context, @NonNull DownloadInfo downloadInfo, JSONObject jSONObject, @NonNull com.ss.android.socialbase.appdownloader.u uVar) {
        if (context != null && jSONObject != null) {
            String savePath = downloadInfo.getSavePath();
            if (TextUtils.isEmpty(savePath)) {
                return false;
            }
            uVar.b = MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM;
            com.ss.android.socialbase.appdownloader.u.u uVarU = com.ss.android.socialbase.appdownloader.u.b.u(context, MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, jSONObject, downloadInfo);
            if (uVarU != null && uVarU.u()) {
                Intent intentNr = uVarU.nr();
                if (intentNr == null) {
                    return false;
                }
                if (!u(new File(savePath), downloadInfo, jSONObject)) {
                    uVar.nr = 6;
                } else {
                    if (nr(context, intentNr)) {
                        uVar.nr = 0;
                        return true;
                    }
                    uVar.nr = 1;
                }
                return false;
            }
            uVar.nr = 3;
        }
        return false;
    }

    public static boolean u(Context context, DownloadInfo downloadInfo, Intent intent, boolean z) {
        JSONArray jSONArrayPn = com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId()).pn("ah_plans");
        if (jSONArrayPn == null) {
            return false;
        }
        int length = jSONArrayPn.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayPn.optJSONObject(i);
            if (com.ss.android.socialbase.appdownloader.iz.u.u(jSONObjectOptJSONObject) && u(context, downloadInfo, intent, jSONObjectOptJSONObject, z)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0171 A[PHI: r15
      0x0171: PHI (r15v13 com.ss.android.socialbase.appdownloader.u) = 
      (r15v2 com.ss.android.socialbase.appdownloader.u)
      (r15v8 com.ss.android.socialbase.appdownloader.u)
      (r15v14 com.ss.android.socialbase.appdownloader.u)
     binds: [B:98:0x016f, B:88:0x0147, B:60:0x00e7] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean u(Context context, DownloadInfo downloadInfo, Intent intent, JSONObject jSONObject, boolean z) {
        com.ss.android.socialbase.downloader.n.u uVarU;
        com.ss.android.socialbase.appdownloader.u uVarU2;
        boolean zU;
        boolean z2 = false;
        if (jSONObject != null && downloadInfo != null) {
            com.ss.android.socialbase.appdownloader.u uVar = new com.ss.android.socialbase.appdownloader.u();
            String strOptString = jSONObject.optString("type");
            if (!TextUtils.isEmpty(strOptString)) {
                uVarU = com.ss.android.socialbase.downloader.n.u.u(downloadInfo);
                uVar.u = strOptString;
                strOptString.hashCode();
                switch (strOptString) {
                    case "plan_a":
                    case "plan_e":
                        if (!downloadInfo.isSavePathRedirected()) {
                            uVar.nr = downloadInfo.getAntiHijackErrorCode(-1);
                        } else {
                            uVarU2 = u(jSONObject, uVarU);
                            if (uVarU2.nr != 0) {
                                uVar = uVarU2;
                            } else if (strOptString.equals("plan_f") && TextUtils.isEmpty(downloadInfo.getDBJsonString("file_content_uri"))) {
                                uVar.nr = downloadInfo.getAntiHijackErrorCode(10);
                            } else {
                                zU = u(context, downloadInfo, jSONObject, uVar);
                                z2 = zU;
                            }
                        }
                        if (z2) {
                            downloadInfo.getTempCacheData().put("ah_attempt", uVar.u());
                        }
                        if (nr != null) {
                            downloadInfo.getTempCacheData().put(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, intent);
                            nr.u(downloadInfo, uVar);
                            break;
                        }
                        break;
                    case "plan_b":
                        uVarU2 = u(jSONObject, uVarU);
                        if (uVarU2.nr == 0) {
                            if (!downloadInfo.isSavePathRedirected()) {
                                uVar.nr = downloadInfo.getAntiHijackErrorCode(-1);
                            } else {
                                zU = nr(context, downloadInfo, jSONObject, uVar);
                                z2 = zU;
                            }
                        }
                        if (z2) {
                        }
                        if (nr != null) {
                        }
                        break;
                    case "plan_c":
                        if (Build.VERSION.SDK_INT >= 26 || com.ss.android.socialbase.appdownloader.iz.pn.fx()) {
                            if ((jSONObject.optInt("enable_for_all", 0) == 1) || z) {
                                if (!(jSONObject.optInt("show_unknown_source_on_startup") == 1)) {
                                    zU = u(context, intent, jSONObject, downloadInfo.getId(), uVar);
                                    z2 = zU;
                                }
                            }
                        }
                        if (z2) {
                        }
                        if (nr != null) {
                        }
                        break;
                    case "plan_d":
                        uVar.u = "plan_d";
                        if (!com.ss.android.socialbase.appdownloader.iz.pn.b()) {
                            uVar.nr = 2;
                        } else {
                            try {
                                com.ss.android.socialbase.appdownloader.fx.u(context, intent);
                                uVar.nr = 0;
                                z2 = true;
                            } catch (Throwable th) {
                                uVar.nr = 4;
                                uVar.fx = th.toString();
                            }
                        }
                        if (z2) {
                        }
                        if (nr != null) {
                        }
                        break;
                    case "plan_f":
                        break;
                    case "plan_g":
                        uVarU2 = nr(jSONObject, uVarU);
                        if (uVarU2.nr == 0) {
                            zU = u(context, downloadInfo, jSONObject, uVar, uVarU);
                            z2 = zU;
                            if (z2) {
                            }
                            if (nr != null) {
                            }
                        }
                        uVar = uVarU2;
                        if (z2) {
                        }
                        if (nr != null) {
                        }
                        break;
                    case "plan_h":
                        String strU = com.ss.android.socialbase.appdownloader.iz.fx.u(uVarU.fx("bh"), uVarU.fx("s"));
                        com.ss.android.socialbase.appdownloader.u uVarU3 = u(jSONObject, strU, context, uVarU);
                        if (uVarU3.nr != 0) {
                            uVar = uVarU3;
                        } else {
                            String packageName = context.getPackageName();
                            if (com.ss.android.socialbase.appdownloader.iz.u.u(com.ss.android.socialbase.downloader.n.u.nr(), context, strU)) {
                                try {
                                    com.ss.android.socialbase.appdownloader.fx.u(context, intent);
                                    uVar.nr = 0;
                                    z2 = true;
                                } catch (Throwable th2) {
                                    try {
                                        uVar.nr = 1;
                                        uVar.fx = th2.toString();
                                    } finally {
                                        com.ss.android.socialbase.appdownloader.iz.u.u(com.ss.android.socialbase.downloader.n.u.nr(), context, packageName);
                                    }
                                }
                            } else {
                                uVar.nr = 11;
                            }
                        }
                        if (z2) {
                        }
                        if (nr != null) {
                        }
                        break;
                    default:
                        if (z2) {
                        }
                        if (nr != null) {
                        }
                        break;
                }
            }
        }
        return z2;
    }

    public static com.ss.android.socialbase.appdownloader.u nr(JSONObject jSONObject, com.ss.android.socialbase.downloader.n.u uVar) {
        com.ss.android.socialbase.appdownloader.u uVar2 = new com.ss.android.socialbase.appdownloader.u();
        if (jSONObject == null) {
            return uVar2;
        }
        uVar2.u = jSONObject.optString("type");
        uVar2.pn = "vbi";
        if (com.ss.android.socialbase.appdownloader.u.b.u(com.ss.android.socialbase.downloader.downloader.fx.oa(), "vbi", jSONObject, uVar)) {
            uVar2.nr = 0;
        } else {
            u(uVar2, 3);
        }
        return uVar2;
    }

    public static void nr(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception unused) {
        }
        com.ss.android.socialbase.downloader.downloader.fx.cj().nr(i, "guide_auth_dialog_cancel", jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nr(int i, boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        int i2 = 1;
        try {
            jSONObject.put("scene", z ? 1 : 2);
            if (!z2) {
                i2 = 2;
            }
            jSONObject.put(FontsContractCompat.Columns.RESULT_CODE, i2);
        } catch (Exception unused) {
        }
        com.ss.android.socialbase.downloader.downloader.fx.cj().nr(i, "guide_auth_result", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean nr(Context context, Intent intent) {
        return u(context, intent, true);
    }

    private static boolean u(Context context, @NonNull DownloadInfo downloadInfo, JSONObject jSONObject, @NonNull com.ss.android.socialbase.appdownloader.u uVar, com.ss.android.socialbase.downloader.n.u uVar2) {
        boolean zNr;
        String strOptString = jSONObject.optString("type");
        uVar.u = strOptString;
        Intent intentNr = com.ss.android.socialbase.appdownloader.u.b.u(context, "vbi", jSONObject, downloadInfo).nr();
        StringBuilder sb = new StringBuilder();
        try {
            zNr = nr(context, intentNr);
        } catch (Throwable th) {
            sb.append(strOptString);
            sb.append(" startActivity failed : ");
            sb.append(u(th));
            u(uVar, 1);
            zNr = false;
        }
        if (!zNr) {
            uVar.fx = sb.toString();
        } else {
            uVar.nr = 0;
        }
        return true;
    }

    private static boolean u(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, com.ss.android.socialbase.appdownloader.u uVar) {
        String str;
        boolean z;
        if (context != null && jSONObject != null) {
            String strOptString = jSONObject.optString("device_plans");
            uVar.pn = strOptString;
            if (!TextUtils.isEmpty(strOptString)) {
                String[] strArrSplit = strOptString.split(",");
                String savePath = downloadInfo.getSavePath();
                if (TextUtils.isEmpty(savePath)) {
                    return false;
                }
                File file = new File(savePath);
                StringBuilder sb = new StringBuilder();
                int length = strArrSplit.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        str = null;
                        z = false;
                        break;
                    }
                    str = strArrSplit[i];
                    com.ss.android.socialbase.appdownloader.u.u uVarU = com.ss.android.socialbase.appdownloader.u.b.u(context, str, jSONObject, downloadInfo);
                    if (uVarU != null) {
                        Intent intentNr = uVarU.nr();
                        if (intentNr != null) {
                            if (u(file, downloadInfo, jSONObject)) {
                                z = true;
                                try {
                                    u(context, intentNr, false);
                                    break;
                                } catch (Throwable th) {
                                    sb.append(str);
                                    sb.append(" startActivity failed : ");
                                    sb.append(u(th));
                                    u(uVar, 1);
                                }
                            } else {
                                u(uVar, 6);
                                sb.append(str);
                                sb.append(" createDescFile failed! ");
                            }
                        } else {
                            u(uVar, 3);
                            sb.append(str);
                            sb.append(" resolveActivity failed! ");
                        }
                    }
                    sb.append("  ");
                    i++;
                }
                if (!z) {
                    uVar.fx = sb.toString();
                } else {
                    uVar.b = str;
                    uVar.nr = 0;
                }
                return z;
            }
        }
        return false;
    }

    public static int u(@NonNull com.ss.android.socialbase.downloader.n.u uVar) {
        if (!(uVar.b("download_dir") != null ? !TextUtils.isEmpty(r0.optString("dir_name")) : false)) {
            return 5;
        }
        if (!com.ss.android.socialbase.downloader.n.u.fx().u("get_download_info_by_list")) {
            return 4;
        }
        JSONArray jSONArrayPn = uVar.pn("ah_plans");
        int i = -1;
        if (jSONArrayPn != null) {
            int length = jSONArrayPn.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayPn.optJSONObject(i2);
                if (com.ss.android.socialbase.appdownloader.iz.u.u(jSONObjectOptJSONObject)) {
                    String strOptString = jSONObjectOptJSONObject.optString("type");
                    if (!"plan_a".equals(strOptString) && !"plan_b".equals(strOptString) && !"plan_e".equals(strOptString) && !"plan_f".equals(strOptString)) {
                        if ("plan_d".equalsIgnoreCase(strOptString) || "plan_h".equalsIgnoreCase(strOptString) || ("plan_g".equalsIgnoreCase(strOptString) && (i = nr(jSONObjectOptJSONObject, uVar).nr) == 0)) {
                            return 0;
                        }
                    } else {
                        i = u(jSONObjectOptJSONObject, uVar).nr;
                        if (i == 0) {
                            return 0;
                        }
                    }
                }
            }
        }
        return i;
    }

    @NonNull
    public static com.ss.android.socialbase.appdownloader.u u(JSONObject jSONObject, com.ss.android.socialbase.downloader.n.u uVar) {
        com.ss.android.socialbase.appdownloader.u uVar2 = new com.ss.android.socialbase.appdownloader.u();
        if (jSONObject == null) {
            return uVar2;
        }
        String strOptString = jSONObject.optString("type");
        uVar2.u = strOptString;
        if ("plan_b".equals(strOptString)) {
            uVar2.pn = MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM;
            if (com.ss.android.socialbase.appdownloader.u.b.u(com.ss.android.socialbase.downloader.downloader.fx.oa(), MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, jSONObject, uVar)) {
                uVar2.nr = 0;
                return uVar2;
            }
            u(uVar2, 3);
        } else {
            String strOptString2 = jSONObject.optString("device_plans");
            uVar2.pn = strOptString2;
            if (!TextUtils.isEmpty(strOptString2)) {
                for (String str : strOptString2.split(",")) {
                    if (com.ss.android.socialbase.appdownloader.u.b.u(com.ss.android.socialbase.downloader.downloader.fx.oa(), str, jSONObject, uVar)) {
                        uVar2.nr = 0;
                        return uVar2;
                    }
                    u(uVar2, 3);
                }
            }
        }
        return uVar2;
    }

    public static com.ss.android.socialbase.appdownloader.u u(JSONObject jSONObject, String str, Context context, com.ss.android.socialbase.downloader.n.u uVar) {
        com.ss.android.socialbase.appdownloader.u uVar2 = new com.ss.android.socialbase.appdownloader.u();
        if (jSONObject != null && com.ss.android.socialbase.appdownloader.iz.pn.fx()) {
            uVar2.u = jSONObject.optString("type");
            if (uVar.u(com.igexin.push.core.b.ad, 0) == 1) {
                uVar2.nr = 0;
                return uVar2;
            }
            if (u(context)) {
                uVar2.nr = 2;
            } else if (com.ss.android.socialbase.appdownloader.iz.u.u(str) != null) {
                uVar2.nr = 0;
            } else {
                uVar2.nr = 9;
            }
        }
        return uVar2;
    }

    private static void u(com.ss.android.socialbase.appdownloader.u uVar, int i) {
        int i2 = uVar.nr;
        if (i2 != -1) {
            uVar.nr = (i2 * 10) + i;
        } else {
            uVar.nr = i;
        }
    }

    private static boolean u(File file, DownloadInfo downloadInfo, @NonNull JSONObject jSONObject) {
        if (file == null) {
            return false;
        }
        String path = file.getPath();
        JSONObject jSONObjectB = com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId()).b("download_dir");
        File file2 = null;
        String strOptString = jSONObjectB != null ? jSONObjectB.optString("ins_desc") : null;
        if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString)) {
            file2 = new File(path + File.separator + strOptString);
        }
        if (file2 == null) {
            return true;
        }
        try {
            if (!file2.createNewFile()) {
                return true;
            }
            file2.deleteOnExit();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean u(Context context, @Nullable Intent intent, JSONObject jSONObject, int i, @Nullable com.ss.android.socialbase.appdownloader.u uVar) {
        if (context != null && jSONObject != null) {
            long jOptLong = jSONObject.optLong("jump_interval", 0L);
            if (jOptLong <= 0) {
                return false;
            }
            SharedPreferences sharedPreferencesNr = com.bytedance.sdk.openadsdk.api.plugin.nr.nr(context, "sp_ah_config", 0);
            if ((System.currentTimeMillis() - sharedPreferencesNr.getLong("last_jump_unknown_source_time", 0L)) / 60000 >= jOptLong && !u(context)) {
                sharedPreferencesNr.edit().putLong("last_jump_unknown_source_time", System.currentTimeMillis()).apply();
                if (jSONObject.optInt("show_unknown_source_dialog", 0) == 1) {
                    Intent intent2 = new Intent(context, (Class<?>) JumpUnknownSourceActivity.class);
                    intent2.addFlags(268435456);
                    intent2.putExtra(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, intent);
                    intent2.putExtra(com.igexin.push.core.b.Y, jSONObject.toString());
                    intent2.putExtra("id", i);
                    try {
                        if (u(context, intent2, false)) {
                            b(i, jSONObject);
                        }
                        return true;
                    } catch (Throwable th) {
                        if (uVar != null) {
                            uVar.nr = 1;
                            uVar.fx = "tryShowUnknownSourceDialog" + u(th);
                        }
                        return false;
                    }
                }
                if (u(context, intent, i, jSONObject)) {
                    fx(i, jSONObject);
                }
                return true;
            }
        }
        return false;
    }

    public static boolean u(Context context, @Nullable Intent intent, int i, JSONObject jSONObject) {
        try {
            if (com.ss.android.socialbase.appdownloader.iz.pn.fx() && Build.VERSION.SDK_INT < 26 && !b(context)) {
                com.ss.android.socialbase.appdownloader.u.iz izVar = new com.ss.android.socialbase.appdownloader.u.iz(context);
                if (izVar.u()) {
                    u(context, intent, i, jSONObject, new InterfaceC0857nr() { // from class: com.ss.android.socialbase.appdownloader.nr.1
                        @Override // com.ss.android.socialbase.appdownloader.nr.InterfaceC0857nr
                        public boolean u(@NonNull Context context2) {
                            return nr.b(context2);
                        }
                    });
                    return nr(context, izVar.nr());
                }
            } else if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26 && !pn(context)) {
                com.ss.android.socialbase.appdownloader.u.nr nrVar = new com.ss.android.socialbase.appdownloader.u.nr(context);
                if (nrVar.u()) {
                    u(context, intent, i, jSONObject, new InterfaceC0857nr() { // from class: com.ss.android.socialbase.appdownloader.nr.2
                        @Override // com.ss.android.socialbase.appdownloader.nr.InterfaceC0857nr
                        public boolean u(@NonNull Context context2) {
                            return nr.pn(context2);
                        }
                    });
                    return nr(context, nrVar.nr());
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean u(Context context) {
        if (context == null) {
            return true;
        }
        if (com.ss.android.socialbase.appdownloader.iz.pn.fx() && Build.VERSION.SDK_INT < 26) {
            return b(context);
        }
        if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26) {
            return pn(context);
        }
        return true;
    }

    public static boolean u() {
        return pn.u == 1;
    }

    public static void u(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception unused) {
        }
        com.ss.android.socialbase.downloader.downloader.fx.cj().nr(i, "guide_auth_dialog_confirm", jSONObject2);
    }

    private static void u(Context context, Intent intent, int i, JSONObject jSONObject, InterfaceC0857nr interfaceC0857nr) {
        if (fx != null) {
            com.ss.android.socialbase.downloader.u.u.u().nr(fx);
            fx = null;
        }
        fx = new u(context, intent, i, jSONObject, interfaceC0857nr);
        com.ss.android.socialbase.downloader.u.u.u().u(fx);
    }

    public static boolean u(Context context, Intent intent, boolean z) {
        if (context == null || intent == null) {
            return false;
        }
        if (z) {
            try {
                intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
                context.startActivity(intent);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        context.startActivity(intent);
        return true;
    }

    public static String u(Throwable th) {
        String string = th.toString();
        return string.length() > 800 ? string.substring(0, 500) : string;
    }

    public static void u(fx fxVar) {
        nr = fxVar;
    }
}
