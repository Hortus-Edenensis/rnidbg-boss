package com.bytedance.sdk.openadsdk.core.live.pn;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.my;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.zenmen.palmchat.ad.view.AdView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    public static boolean u(bc bcVar) {
        if (bcVar == null) {
            return false;
        }
        return u(bcVar.kv());
    }

    public static boolean u(my myVar) {
        if (myVar == null) {
            return false;
        }
        String strNr = myVar.nr();
        if (TextUtils.isEmpty(strNr)) {
            return false;
        }
        return strNr.startsWith("snssdk2329") || strNr.startsWith("snssdk1128");
    }

    public static boolean u(String str) {
        if (str == null) {
            return false;
        }
        if (str.startsWith("snssdk1128")) {
            return jp.u(AdView.DOUYIN);
        }
        if (str.startsWith("snssdk2329")) {
            return jp.u(AdView.DOUYIN_LITE);
        }
        return false;
    }
}
