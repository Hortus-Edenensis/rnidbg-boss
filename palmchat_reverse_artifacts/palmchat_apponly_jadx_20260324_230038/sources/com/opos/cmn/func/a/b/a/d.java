package com.opos.cmn.func.a.b.a;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f7939a = "";

    public static String a(Context context) {
        return TextUtils.isEmpty(f7939a) ? com.opos.cmn.biz.a.d.a(context) : f7939a;
    }
}
