package com.lantern.core.database;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class PubSharedPref {
    private SharedPreferences mSP;

    public PubSharedPref(Context context, String str, int i) {
        this.mSP = context.getSharedPreferences(str, i);
    }

    public void clear() {
        SharedPreferences.Editor editorEdit = this.mSP.edit();
        editorEdit.clear();
        editorEdit.apply();
    }

    public String readArrayString(String str) {
        return this.mSP.getString(str, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
    }

    public boolean readBoolean(String str) {
        return this.mSP.getBoolean(str, false);
    }

    public int readInt(String str) {
        return this.mSP.getInt(str, 0);
    }

    public long readLong(String str) {
        return this.mSP.getLong(str, 0L);
    }

    public String readString(String str) {
        return this.mSP.getString(str, "");
    }

    public void removeByKey(String str) {
        SharedPreferences.Editor editorEdit = this.mSP.edit();
        editorEdit.remove(str);
        editorEdit.apply();
    }

    public void write(String str, String str2) {
        SharedPreferences.Editor editorEdit = this.mSP.edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }

    public boolean readBoolean(String str, boolean z) {
        return this.mSP.getBoolean(str, z);
    }

    public int readInt(String str, int i) {
        return this.mSP.getInt(str, i);
    }

    public String readString(String str, String str2) {
        return this.mSP.getString(str, str2);
    }

    public void write(String str, boolean z) {
        SharedPreferences.Editor editorEdit = this.mSP.edit();
        editorEdit.putBoolean(str, z);
        editorEdit.apply();
    }

    public void write(String str, int i) {
        SharedPreferences.Editor editorEdit = this.mSP.edit();
        editorEdit.putInt(str, i);
        editorEdit.apply();
    }

    public void write(String str, long j) {
        SharedPreferences.Editor editorEdit = this.mSP.edit();
        editorEdit.putLong(str, j);
        editorEdit.apply();
    }

    public void write(Map<String, Object> map) {
        SharedPreferences.Editor editorEdit = this.mSP.edit();
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
}
