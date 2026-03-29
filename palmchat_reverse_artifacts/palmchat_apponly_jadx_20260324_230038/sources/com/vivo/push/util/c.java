package com.vivo.push.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f11300a;
    private String b;
    private volatile SharedPreferences c;
    private HashMap<String, String> d = new HashMap<>();
    private HashMap<String, Long> e = new HashMap<>();
    private HashMap<String, Integer> f = new HashMap<>();
    private HashMap<String, Boolean> g = new HashMap<>();

    public final void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("sharedFileName can't be null");
        }
        this.b = str;
        this.c = context.getSharedPreferences(str, 0);
        this.f11300a = context;
    }

    public final String b(String str, String str2) {
        String string = this.d.get(str);
        if (string != null) {
            return string;
        }
        c();
        if (this.c != null) {
            string = this.c.getString(str, str2);
            if (!TextUtils.isEmpty(string) && !string.equals(str2)) {
                this.d.put(str, string);
            }
        }
        return string;
    }

    public final void c(String str) {
        this.e.remove(str);
        this.f.remove(str);
        this.g.remove(str);
        this.d.remove(str);
        c();
        if (this.c != null) {
            SharedPreferences.Editor editorEdit = this.c.edit();
            if (this.c.contains(str)) {
                editorEdit.remove(str);
                a(editorEdit);
            }
        }
    }

    public final SharedPreferences a() {
        c();
        return this.c;
    }

    public final boolean b(String str) {
        Boolean bool = this.g.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        c();
        Boolean bool2 = Boolean.FALSE;
        if (this.c != null) {
            Boolean boolValueOf = Boolean.valueOf(this.c.getBoolean(str, false));
            if (boolValueOf != null && !boolValueOf.equals(bool2)) {
                this.g.put(str, boolValueOf);
            }
            bool2 = boolValueOf;
        }
        return bool2.booleanValue();
    }

    public final void a(String str, String str2) {
        this.d.put(str, str2);
        c();
        if (this.c != null) {
            SharedPreferences.Editor editorEdit = this.c.edit();
            editorEdit.putString(str, str2);
            a(editorEdit);
        }
    }

    private synchronized void c() {
        if (this.c == null) {
            Context context = this.f11300a;
            if (context != null) {
                this.c = context.getSharedPreferences(this.b, 0);
            } else {
                throw new RuntimeException("SharedPreferences is not init", new Throwable());
            }
        }
    }

    public final void a(String str, int i) {
        this.f.put(str, Integer.valueOf(i));
        c();
        if (this.c != null) {
            SharedPreferences.Editor editorEdit = this.c.edit();
            editorEdit.putInt(str, i);
            a(editorEdit);
        }
    }

    public final int b(String str, int i) {
        Integer numValueOf = this.f.get(str);
        if (numValueOf != null) {
            return numValueOf.intValue();
        }
        c();
        if (this.c != null) {
            numValueOf = Integer.valueOf(this.c.getInt(str, i));
            if (!numValueOf.equals(Integer.valueOf(i))) {
                this.f.put(str, numValueOf);
            }
        }
        return numValueOf.intValue();
    }

    public final void a(String str, long j) {
        this.e.put(str, Long.valueOf(j));
        c();
        if (this.c != null) {
            SharedPreferences.Editor editorEdit = this.c.edit();
            editorEdit.putLong(str, j);
            a(editorEdit);
        }
    }

    public final long b(String str, long j) {
        Long lValueOf = this.e.get(str);
        if (lValueOf != null) {
            return lValueOf.longValue();
        }
        c();
        if (this.c != null) {
            lValueOf = Long.valueOf(this.c.getLong(str, j));
            if (!lValueOf.equals(Long.valueOf(j))) {
                this.e.put(str, lValueOf);
            }
        }
        return lValueOf.longValue();
    }

    public final void a(String str) {
        this.g.put(str, Boolean.TRUE);
        c();
        if (this.c != null) {
            SharedPreferences.Editor editorEdit = this.c.edit();
            editorEdit.putBoolean(str, true);
            a(editorEdit);
        }
    }

    public static void a(SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            editor.apply();
        } else {
            editor.commit();
        }
    }

    public final void b() {
        this.e.clear();
        this.f.clear();
        this.g.clear();
        this.d.clear();
        c();
        if (this.c != null) {
            SharedPreferences.Editor editorEdit = this.c.edit();
            editorEdit.clear();
            a(editorEdit);
        }
    }
}
