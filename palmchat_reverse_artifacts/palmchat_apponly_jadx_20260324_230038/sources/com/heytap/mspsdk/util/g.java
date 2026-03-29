package com.heytap.mspsdk.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.heytap.mspsdk.log.MspLog;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f6414a = true;
    private SharedPreferences b;
    private SharedPreferences.Editor c = null;

    public g(Context context, String str, int i) {
        this.b = context.getApplicationContext().getSharedPreferences(str, i);
    }

    @SuppressLint({"CommitPrefEdits"})
    public g a(String str) {
        if (!f6414a && this.b == null) {
            throw new AssertionError();
        }
        if (this.c == null) {
            this.c = this.b.edit();
        }
        this.c.remove(str);
        return this;
    }

    @SuppressLint({"CommitPrefEdits"})
    public g b(String str, Object obj) {
        if (!f6414a && this.b == null) {
            throw new AssertionError();
        }
        if (this.c == null) {
            this.c = this.b.edit();
        }
        if (obj instanceof Boolean) {
            this.c.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            this.c.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Integer) {
            this.c.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            this.c.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Set) {
            this.c.putStringSet(str, (Set) obj);
        } else {
            this.c.putString(str, (String) obj);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T a(String str, T t) {
        if (!f6414a && this.b == null) {
            throw new AssertionError();
        }
        Object objValueOf = t instanceof Boolean ? Boolean.valueOf(this.b.getBoolean(str, ((Boolean) t).booleanValue())) : t instanceof Float ? Float.valueOf(this.b.getFloat(str, ((Float) t).floatValue())) : t instanceof Integer ? Integer.valueOf(this.b.getInt(str, ((Integer) t).intValue())) : t instanceof Long ? Long.valueOf(this.b.getLong(str, ((Long) t).longValue())) : t instanceof Set ? this.b.getStringSet(str, (Set) t) : this.b.getString(str, (String) t);
        return objValueOf == null ? t : (T) objValueOf;
    }

    public void b() {
        SharedPreferences.Editor editor = this.c;
        if (editor != null) {
            editor.apply();
        }
    }

    public Map<String, Object> a() {
        if (!f6414a && this.b == null) {
            throw new AssertionError();
        }
        try {
            return this.b.getAll();
        } catch (Exception e) {
            MspLog.e("SharedPreferencesHelper", e.getMessage());
            return null;
        }
    }
}
