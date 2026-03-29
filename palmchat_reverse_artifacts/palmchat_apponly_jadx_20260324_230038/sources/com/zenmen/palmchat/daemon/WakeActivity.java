package com.zenmen.palmchat.daemon;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.BaseActionBarActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ac1;
import defpackage.jo6;
import defpackage.m5;
import defpackage.vt0;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class WakeActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f13880a;
    public static int b;

    public static void b() {
        LogUtil.d("logdaemon", "WakeActivity: onApplicationCreate");
        f13880a = SystemClock.elapsedRealtime();
    }

    public static void c() throws Throwable {
        FileWriter fileWriter;
        File externalFilesDir;
        boolean zA = jo6.a("LX-16260", false);
        FileWriter fileWriter2 = null;
        File file = (AppContext.getContext() == null || (externalFilesDir = AppContext.getContext().getExternalFilesDir(null)) == null) ? null : new File(externalFilesDir, "LX-16260");
        if (!zA) {
            if (file == null || !file.exists()) {
                return;
            }
            file.delete();
            return;
        }
        if (file == null || file.exists()) {
            return;
        }
        try {
            if (file.createNewFile()) {
                try {
                    try {
                        fileWriter = new FileWriter(file);
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    fileWriter.write(String.valueOf(System.currentTimeMillis()));
                    fileWriter.flush();
                    fileWriter.close();
                } catch (Exception e2) {
                    e = e2;
                    fileWriter2 = fileWriter;
                    e.printStackTrace();
                    if (fileWriter2 != null) {
                        fileWriter2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileWriter2 = fileWriter;
                    if (fileWriter2 != null) {
                        fileWriter2.close();
                    }
                    throw th;
                }
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public int a() {
        return 0;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        LogUtil.d("logdaemon", "WakeActivity: onCreate begin");
        m5.c(this, bundle);
        super.onCreate(bundle);
        int i = b + 1;
        b = i;
        boolean z = i <= 1 && SystemClock.elapsedRealtime() - f13880a < 3000;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("active", !z);
            jSONObject.put("wakeTime", SystemClock.elapsedRealtime() - f13880a);
            jSONObject.put("manufacturer", ac1.f1194a);
            jSONObject.put(MediationConstant.KEY_USE_POLICY_PAGE_ID, a());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtil.uploadInfoImmediate("ar20", null, null, jSONObject.toString());
        vt0.d().n(BaseActionBarActivity.EXTRA_KEY_FROM_WIFI);
        Window window = getWindow();
        window.setGravity(85);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = 1;
        attributes.height = 1;
        attributes.x = 0;
        attributes.y = 0;
        window.setAttributes(attributes);
        finish();
        LogUtil.d("logdaemon", "WakeActivity: onCreate end");
    }
}
