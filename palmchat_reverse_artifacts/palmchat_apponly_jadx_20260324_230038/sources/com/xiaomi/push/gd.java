package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class gd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile gd f11597a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Context f495a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Map<String, ge> f496a = new HashMap();

    private gd(Context context) {
        this.f495a = context;
    }

    public static gd a(Context context) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]:mContext is null, TinyDataManager.getInstance(Context) failed.");
            return null;
        }
        if (f11597a == null) {
            synchronized (gd.class) {
                if (f11597a == null) {
                    f11597a = new gd(context);
                }
            }
        }
        return f11597a;
    }

    public void a(ge geVar, String str) {
        if (geVar == null) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]: please do not add null mUploader to TinyDataManager.");
        } else if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]: can not add a provider from unkown resource.");
        } else {
            m483a().put(str, geVar);
        }
    }

    public ge a() {
        ge geVar = this.f496a.get("UPLOADER_PUSH_CHANNEL");
        if (geVar != null) {
            return geVar;
        }
        ge geVar2 = this.f496a.get("UPLOADER_HTTP");
        if (geVar2 != null) {
            return geVar2;
        }
        return null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Map<String, ge> m483a() {
        return this.f496a;
    }

    public boolean a(gj gjVar, String str) {
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.m74a("pkgName is null or empty, upload ClientUploadDataItem failed.");
            return false;
        }
        if (com.xiaomi.push.service.az.a(gjVar, false)) {
            return false;
        }
        if (TextUtils.isEmpty(gjVar.d())) {
            gjVar.f(com.xiaomi.push.service.az.a());
        }
        gjVar.g(str);
        com.xiaomi.push.service.ba.a(this.f495a, gjVar);
        return true;
    }
}
