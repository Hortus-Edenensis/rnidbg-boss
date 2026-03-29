package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class jv {
    private static final String[] Code = {"com.huawei.openalliance.ad.views.reward", "com.huawei.openalliance.ad.activity", "com.huawei.openalliance.ad.utils", "com.huawei.openalliance.ad.views", "com.huawei.openalliance.ad.views.dsa", "java.lang.reflect", "com.android.internal.os", "android.app", "android.os", "android.view", "com.android.internal.policy", "dalvik.system", "java.lang", "com.huawei.hms.ads.uiengine.views.template", "com.huawei.hms.ads", "com.android.tools.profiler.support.event", "huawei.android.widget", "android.widget", "androidx.recyclerview.widget", "android.app.servertransaction", "com.huawei.hms.ads.uiengine.remote"};
    public static final long V = 100;
    protected db B;
    protected jv C;
    protected Context I;
    protected AdContentData Z;

    public jv() {
    }

    public jv(Context context, AdContentData adContentData) {
        this.I = context;
        this.Z = adContentData;
        this.B = new db();
    }

    public void Code(jv jvVar) {
        this.C = jvVar;
    }

    public abstract boolean Code();

    public static boolean Code(View view) {
        if (view != null) {
            return !(view.getContext() instanceof Activity) || com.huawei.openalliance.ad.utils.bg.V((Activity) view.getContext());
        }
        return false;
    }

    public static boolean Code(StackTraceElement stackTraceElement) {
        if (stackTraceElement == null || TextUtils.isEmpty(stackTraceElement.toString()) || TextUtils.isEmpty(stackTraceElement.getClassName())) {
            return true;
        }
        String strI = com.huawei.openalliance.ad.utils.bc.I(stackTraceElement.getFileName(), stackTraceElement.getClassName());
        if (TextUtils.isEmpty(strI)) {
            return false;
        }
        int i = 0;
        while (true) {
            String[] strArr = Code;
            if (i >= strArr.length) {
                return false;
            }
            if (strI.equals(strArr[i])) {
                return true;
            }
            i++;
        }
    }
}
