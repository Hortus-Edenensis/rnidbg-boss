package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import com.xiaomi.push.bw;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class bt extends bw.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11453a;

    public bt(String str, ContentValues contentValues, String str2) {
        super(str, contentValues);
        this.f11453a = str2;
    }

    public static bt a(Context context, String str, gj gjVar) {
        byte[] bArrA = hp.a(gjVar);
        if (bArrA == null || bArrA.length <= 0) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 0);
        contentValues.put("messageId", "");
        contentValues.put("messageItemId", gjVar.d());
        contentValues.put("messageItem", bArrA);
        contentValues.put("appId", bn.a(context).b());
        contentValues.put("packageName", bn.a(context).m215a());
        contentValues.put("createTimeStamp", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("uploadTimestamp", (Integer) 0);
        return new bt(str, contentValues, "a job build to insert message to db");
    }
}
