package com.ss.android.downloadlib.x;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.k;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class l {

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private static l u = new l();
    }

    public static l u() {
        return u.u;
    }

    public void nr(String str, String str2, String str3) {
        k.nr("[TTDownloaderLogger]", ((TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? "" : String.format("sdk:%s.%s:", str, str2)) + str3);
    }

    private l() {
    }

    public void u(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String.format("sdk:%s.%s:", str, str2);
    }
}
