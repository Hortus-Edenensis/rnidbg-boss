package com.igexin.push.a;

import android.app.Activity;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f7070a;

    public static a a() {
        if (f7070a == null) {
            synchronized (a.class) {
                if (f7070a == null) {
                    f7070a = new a();
                }
            }
        }
        return f7070a;
    }

    public static b a(Activity activity) {
        String stringExtra = activity.getIntent().getStringExtra("action");
        if (TextUtils.isEmpty(stringExtra)) {
            activity.finish();
            return null;
        }
        stringExtra.hashCode();
        if (stringExtra.equals("popup")) {
            return new g();
        }
        if (stringExtra.equals("com.igexin.action.notification.click")) {
            return new f();
        }
        activity.finish();
        return null;
    }
}
