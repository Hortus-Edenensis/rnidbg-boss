package com.opos.cmn.an.e.d;

import android.content.Context;
import android.content.SharedPreferences;
import com.opos.cmn.an.d.b;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f7742a;

    public a(Context context, String str, int i) {
        this.f7742a = null;
        if (context == null || b.a(str)) {
            return;
        }
        this.f7742a = context.getSharedPreferences(str, i);
    }

    public long a(String str, long j) {
        SharedPreferences sharedPreferences;
        if (b.a(str) || (sharedPreferences = this.f7742a) == null) {
            return j;
        }
        try {
            return sharedPreferences.getLong(str, j);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("SPEngine", "getLong", e);
            return j;
        }
    }

    public Map<String, ?> a() {
        SharedPreferences sharedPreferences = this.f7742a;
        if (sharedPreferences != null) {
            return sharedPreferences.getAll();
        }
        return null;
    }

    public void a(String str) {
        SharedPreferences sharedPreferences;
        if (b.a(str) || (sharedPreferences = this.f7742a) == null) {
            return;
        }
        try {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.remove(str);
            editorEdit.commit();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("SPEngine", "removeAndCommit", e);
        }
    }

    public void a(String str, Object obj) {
        SharedPreferences sharedPreferences;
        if (b.a(str) || obj == null || (sharedPreferences = this.f7742a) == null) {
            return;
        }
        try {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (a(editorEdit, str, obj)) {
                editorEdit.apply();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("SPEngine", "putAndApply", e);
        }
    }

    private boolean a(SharedPreferences.Editor editor, String str, Object obj) {
        if (editor == null || b.a(str) || obj == null || this.f7742a == null) {
            return false;
        }
        try {
            if (obj instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Float) {
                editor.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Integer) {
                editor.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                editor.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                editor.putString(str, (String) obj);
            } else {
                if (!(obj instanceof Set)) {
                    return false;
                }
                editor.putStringSet(str, (Set) obj);
            }
            return true;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("SPEngine", "put", e);
            return false;
        }
    }

    public boolean a(String str, boolean z) {
        SharedPreferences sharedPreferences;
        if (b.a(str) || (sharedPreferences = this.f7742a) == null) {
            return z;
        }
        try {
            return sharedPreferences.getBoolean(str, z);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("SPEngine", "getBoolean", e);
            return z;
        }
    }
}
