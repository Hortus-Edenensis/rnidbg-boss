package com.zm.fda.Z2500.Z0O00.ZZ00Z;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.huawei.openalliance.ad.constant.be;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class Z200O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16690a;
    public int b;
    public int c;
    public float d;

    public Z200O(Context context) {
        if (context != null) {
            try {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                this.f16690a = displayMetrics.widthPixels;
                this.b = displayMetrics.heightPixels;
                this.c = displayMetrics.densityDpi;
                this.d = displayMetrics.density;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            jSONObject.put("width", this.f16690a);
            jSONObject.put("height", this.b);
            jSONObject.put("densityDpi", this.c);
            jSONObject.put(be.ar, this.d);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
