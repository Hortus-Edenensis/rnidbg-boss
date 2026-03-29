package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.text.SimpleDateFormat;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class bz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f11462a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static SimpleDateFormat f181a;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        f181a = simpleDateFormat;
        f11462a = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static gj a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        gj gjVar = new gj();
        gjVar.d("category_push_stat");
        gjVar.a("push_sdk_stat_channel");
        gjVar.a(1L);
        gjVar.b(str);
        gjVar.a(true);
        gjVar.b(System.currentTimeMillis());
        gjVar.g(bn.a(context).m215a());
        gjVar.e("com.xiaomi.xmsf");
        gjVar.f("");
        gjVar.c("push_stat");
        return gjVar;
    }
}
