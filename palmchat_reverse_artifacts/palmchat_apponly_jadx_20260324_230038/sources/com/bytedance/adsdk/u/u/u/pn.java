package com.bytedance.adsdk.u.u.u;

import android.text.TextUtils;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class pn {
    int b;
    int iz;
    int pn;
    int x;

    public void nr(com.bytedance.adsdk.u.u.nr.u uVar) throws IOException {
        int iB = uVar.b();
        u(uVar);
        int iB2 = iB - uVar.b();
        int i = this.b;
        if (iB2 > i) {
            throw new IOException("Out of chunk area");
        }
        if (iB2 < i) {
            uVar.u(i - iB2);
        }
    }

    public void u(com.bytedance.adsdk.u.u.nr.u uVar) throws IOException {
    }

    public static int u(String str) {
        if (TextUtils.isEmpty(str) || str.length() != 4) {
            return -1159790593;
        }
        return ((str.charAt(3) & 255) << 24) | (str.charAt(0) & 255) | ((str.charAt(1) & 255) << 8) | ((str.charAt(2) & 255) << 16);
    }
}
