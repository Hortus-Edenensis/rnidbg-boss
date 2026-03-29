package com.zm.fda.Z0O00;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class Z25O0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f16676a;

    public Z25O0(Context context, String str, int i) {
        this.f16676a = context.getSharedPreferences(str, i);
    }

    public void a(String str, long j) {
        SharedPreferences.Editor editorEdit = this.f16676a.edit();
        editorEdit.putLong(str, j);
        editorEdit.apply();
    }

    public void b(String str, String str2) {
        SharedPreferences.Editor editorEdit = this.f16676a.edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }

    public int c(String str) {
        return this.f16676a.getInt(str, 0);
    }

    public long d(String str) {
        return this.f16676a.getLong(str, 0L);
    }

    public String e(String str) {
        return this.f16676a.getString(str, "");
    }

    public void f(String str) {
        SharedPreferences.Editor editorEdit = this.f16676a.edit();
        editorEdit.remove(str);
        editorEdit.apply();
    }

    public void a(Map<String, Object> map) {
        SharedPreferences.Editor editorEdit = this.f16676a.edit();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj instanceof Integer) {
                editorEdit.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof String) {
                editorEdit.putString(str, (String) obj);
            } else if (obj instanceof Boolean) {
                editorEdit.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Long) {
                editorEdit.putLong(str, ((Long) obj).longValue());
            }
        }
        editorEdit.apply();
    }

    public void b(String str, boolean z) {
        SharedPreferences.Editor editorEdit = this.f16676a.edit();
        editorEdit.putBoolean(str, z);
        editorEdit.apply();
    }

    public void b(String str, int i) {
        SharedPreferences.Editor editorEdit = this.f16676a.edit();
        editorEdit.putInt(str, i);
        editorEdit.apply();
    }

    public boolean b(String str) {
        return this.f16676a.getBoolean(str, false);
    }

    public String a(String str, String str2) {
        return this.f16676a.getString(str, str2);
    }

    public String a(String str) {
        return this.f16676a.getString(str, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
    }

    public boolean a(String str, boolean z) {
        return this.f16676a.getBoolean(str, z);
    }

    public int a(String str, int i) {
        return this.f16676a.getInt(str, i);
    }

    public void a() {
        SharedPreferences.Editor editorEdit = this.f16676a.edit();
        editorEdit.clear();
        editorEdit.apply();
    }
}
