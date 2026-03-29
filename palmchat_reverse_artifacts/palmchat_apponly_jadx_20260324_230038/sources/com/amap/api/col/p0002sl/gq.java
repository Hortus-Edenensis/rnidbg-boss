package com.amap.api.col.p0002sl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class gq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f2839a = ge.c("SU2hhcmVkUHJlZmVyZW5jZUFkaXU");
    private static gq f;
    private List<String> b;
    private String c;
    private final Context d;
    private final Handler e;

    private gq(Context context) {
        this.d = context.getApplicationContext();
        if (Looper.myLooper() == null) {
            this.e = new a(Looper.getMainLooper(), this);
        } else {
            this.e = new a(this);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<gq> f2841a;

        public a(gq gqVar) {
            this.f2841a = new WeakReference<>(gqVar);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Object obj;
            gq gqVar = this.f2841a.get();
            if (gqVar == null || message == null || (obj = message.obj) == null) {
                return;
            }
            gqVar.a((String) obj, message.what);
        }

        public a(Looper looper, gq gqVar) {
            super(looper);
            this.f2841a = new WeakReference<>(gqVar);
        }
    }

    public final void b(String str) {
        List<String> list = this.b;
        if (list != null) {
            list.clear();
            this.b.add(str);
        }
        a(str, 273);
    }

    public static gq a(Context context) {
        if (f == null) {
            synchronized (gq.class) {
                if (f == null) {
                    f = new gq(context);
                }
            }
        }
        return f;
    }

    public final void a(String str) {
        this.c = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(final String str, final int i) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            new Thread() { // from class: com.amap.api.col.2sl.gq.1
                @Override // java.lang.Thread, java.lang.Runnable
                public final void run() {
                    String strB = gw.b(str);
                    if (TextUtils.isEmpty(strB)) {
                        return;
                    }
                    if ((i & 1) > 0) {
                        try {
                            if (Build.VERSION.SDK_INT < 23 || Settings.System.canWrite(gq.this.d)) {
                                Settings.System.putString(gq.this.d.getContentResolver(), gq.this.c, strB);
                            }
                        } catch (Exception unused) {
                        }
                    }
                    if ((i & 16) > 0) {
                        gs.a(gq.this.d, gq.this.c, strB);
                    }
                    if ((i & 256) > 0) {
                        SharedPreferences.Editor editorEdit = gq.this.d.getSharedPreferences(gq.f2839a, 0).edit();
                        editorEdit.putString(gq.this.c, strB);
                        editorEdit.apply();
                    }
                }
            }.start();
            return;
        }
        String strB = gw.b(str);
        if (!TextUtils.isEmpty(strB)) {
            if ((i & 1) > 0) {
                try {
                    if (Build.VERSION.SDK_INT >= 23) {
                        Settings.System.putString(this.d.getContentResolver(), this.c, strB);
                    } else {
                        Settings.System.putString(this.d.getContentResolver(), this.c, strB);
                    }
                } catch (Exception unused) {
                }
            }
            if ((i & 16) > 0) {
                gs.a(this.d, this.c, strB);
            }
            if ((i & 256) > 0) {
                SharedPreferences.Editor editorEdit = this.d.getSharedPreferences(f2839a, 0).edit();
                editorEdit.putString(this.c, strB);
                editorEdit.apply();
            }
        }
    }
}
