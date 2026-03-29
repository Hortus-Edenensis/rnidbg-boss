package com.bytedance.sdk.component.x.fx;

import android.content.SharedPreferences;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b implements com.bytedance.sdk.component.b.nr.fx {
    SharedPreferences u;

    public b(SharedPreferences sharedPreferences) {
        this.u = sharedPreferences;
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void clear() {
        try {
            this.u.edit().clear().apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public boolean contains(String str) {
        return this.u.contains(str);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.u.edit();
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public int get(String str, int i) {
        try {
            return this.u.getInt(str, i);
        } catch (Exception unused) {
            return i;
        }
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        try {
            return this.u.getAll();
        } catch (Exception unused) {
            return Collections.emptyMap();
        }
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        try {
            return this.u.getBoolean(str, z);
        } catch (Exception unused) {
            return z;
        }
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        try {
            return this.u.getFloat(str, f);
        } catch (Exception unused) {
            return f;
        }
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public int getInt(String str, int i) {
        try {
            return this.u.getInt(str, i);
        } catch (Exception unused) {
            return i;
        }
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public long getLong(String str, long j) {
        try {
            return this.u.getLong(str, j);
        } catch (Exception unused) {
            return j;
        }
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public String getString(String str, String str2) {
        try {
            return this.u.getString(str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        try {
            return this.u.getStringSet(str, set);
        } catch (Exception unused) {
            return set;
        }
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void put(String str, int i) {
        try {
            this.u.edit().putInt(str, i).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.u.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void remove(String str) {
        try {
            this.u.edit().remove(str).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.u.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public long get(String str, long j) {
        try {
            return this.u.getLong(str, j);
        } catch (Exception unused) {
            return j;
        }
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void put(String str, long j) {
        try {
            this.u.edit().putLong(str, j).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public float get(String str, float f) {
        try {
            return this.u.getFloat(str, f);
        } catch (Exception unused) {
            return f;
        }
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void put(String str, float f) {
        try {
            this.u.edit().putFloat(str, f).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public boolean get(String str, boolean z) {
        try {
            return this.u.getBoolean(str, z);
        } catch (Exception unused) {
            return z;
        }
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void put(String str, boolean z) {
        try {
            this.u.edit().putBoolean(str, z).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public String get(String str, String str2) {
        try {
            return this.u.getString(str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void put(String str, String str2) {
        try {
            this.u.edit().putString(str, str2).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public Set<String> get(String str, Set<String> set) {
        try {
            return this.u.getStringSet(str, set);
        } catch (Exception unused) {
            return set;
        }
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void put(String str, Set<String> set) {
        try {
            this.u.edit().putStringSet(str, set).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void apply() {
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void applySync() {
    }
}
