package com.bytedance.sdk.openadsdk.core.n;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.dw;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    public static String u(String str) {
        String strQq = dw.nr().qq();
        if (TextUtils.isEmpty(strQq)) {
            return "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/".concat(String.valueOf(str));
        }
        return strQq + str;
    }
}
