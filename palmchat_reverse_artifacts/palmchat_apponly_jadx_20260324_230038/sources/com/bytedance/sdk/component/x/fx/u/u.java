package com.bytedance.sdk.component.x.fx.u;

import android.content.SharedPreferences;
import android.text.TextUtils;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements com.bytedance.sdk.component.b.nr.fx {
    private static final Map<String, com.bytedance.sdk.component.b.nr.fx> nr = new ConcurrentHashMap();
    private String u;

    private u(String str) {
        this.u = str;
    }

    public static com.bytedance.sdk.component.b.nr.fx u(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_sdk_multi_sp";
        }
        Map<String, com.bytedance.sdk.component.b.nr.fx> map = nr;
        com.bytedance.sdk.component.b.nr.fx fxVar = map.get(str);
        if (fxVar != null) {
            return fxVar;
        }
        u uVar = new u(str);
        map.put(str, uVar);
        return uVar;
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void clear() {
        nr.u(this.u);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public boolean contains(String str) {
        return nr.u(this.u, str);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return null;
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public int get(String str, int i) {
        return getInt(str, i);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return nr.nr(this.u);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return nr.u(this.u, str, z);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return nr.u(this.u, str, f);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public int getInt(String str, int i) {
        return nr.u(this.u, str, i);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public long getLong(String str, long j) {
        return nr.u(this.u, str, j);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public String getString(String str, String str2) {
        return nr.nr(this.u, str, str2);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return nr.nr(this.u, str, set);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void put(String str, int i) {
        nr.u(this.u, str, Integer.valueOf(i));
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void remove(String str) {
        nr.nr(this.u, str);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public long get(String str, long j) {
        return getLong(str, j);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void put(String str, long j) {
        nr.u(this.u, str, Long.valueOf(j));
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public float get(String str, float f) {
        return getFloat(str, f);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void put(String str, float f) {
        nr.u(this.u, str, Float.valueOf(f));
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public boolean get(String str, boolean z) {
        return getBoolean(str, z);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void put(String str, boolean z) {
        nr.u(this.u, str, Boolean.valueOf(z));
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public String get(String str, String str2) {
        return getString(str, str2);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void put(String str, String str2) {
        nr.u(this.u, str, str2);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public Set<String> get(String str, Set<String> set) {
        return getStringSet(str, set);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void put(String str, Set<String> set) {
        nr.u(this.u, str, set);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void apply() {
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void applySync() {
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }
}
