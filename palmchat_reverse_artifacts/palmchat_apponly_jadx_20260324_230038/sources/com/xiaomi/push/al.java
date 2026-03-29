package com.xiaomi.push;

import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
class al implements ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11413a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Class<?> f117a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Object f118a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Method f119a = null;
    private Method b = null;
    private Method c = null;
    private Method d = null;

    public al(Context context) {
        this.f11413a = context;
        a(context);
    }

    private void a(Context context) {
        try {
            Class<?> clsA = C1401r.a(context, "com.android.id.impl.IdProviderImpl");
            this.f117a = clsA;
            this.f118a = clsA.newInstance();
            this.b = this.f117a.getMethod("getOAID", Context.class);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("miui load class error", e);
        }
    }

    @Override // com.xiaomi.push.ai
    /* JADX INFO: renamed from: a */
    public boolean mo161a() {
        return (this.f117a == null || this.f118a == null) ? false : true;
    }

    @Override // com.xiaomi.push.ai
    /* JADX INFO: renamed from: a */
    public String mo160a() {
        return a(this.f11413a, this.b);
    }

    private String a(Context context, Method method) {
        Object obj = this.f118a;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(obj, context);
            if (objInvoke != null) {
                return (String) objInvoke;
            }
            return null;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("miui invoke error", e);
            return null;
        }
    }
}
