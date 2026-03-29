package com.bytedance.sdk.component.x.nr.u;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.keva.Keva;
import com.bytedance.keva.KevaBuilder;
import com.bytedance.keva.KevaMonitor;
import com.bytedance.sdk.component.b.nr.fx;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements fx {
    private Keva u;
    private static final Map<String, fx> nr = new HashMap();
    private static volatile boolean fx = false;
    private static volatile boolean b = true;

    private u(String str, boolean z, int i) {
        if (i != 1) {
            nr(str, z);
        } else {
            u(str, z);
        }
    }

    private void nr(String str, boolean z) {
        if (z) {
            this.u = Keva.getRepoSync(str, 1);
        } else {
            this.u = Keva.getRepoSync(str, 0);
        }
    }

    public static fx u(Context context, String str, boolean z, int i) {
        if (!b) {
            return null;
        }
        try {
            if (!fx) {
                fx = u(context);
            }
            if (TextUtils.isEmpty(str)) {
                str = "tt_ad_sdk_keva";
            }
            if (!b) {
                return null;
            }
            Map<String, fx> map = nr;
            fx uVar = map.get(str);
            if (uVar == null) {
                uVar = new u(str, z, i);
                if (b) {
                    map.put(str, uVar);
                }
            }
            if (b) {
                return uVar;
            }
            return null;
        } catch (Throwable unused) {
            b = false;
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void clear() {
        this.u.clear();
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public boolean contains(String str) {
        return this.u.contains(str);
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
        return this.u.getAll();
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.u.getBoolean(str, z);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return this.u.getFloat(str, f);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public int getInt(String str, int i) {
        return this.u.getInt(str, i);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.u.getLong(str, j);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public String getString(String str, String str2) {
        return this.u.getString(str, str2);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return this.u.getStringSet(str, set);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void put(String str, int i) {
        this.u.storeInt(str, i);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void remove(String str) {
        this.u.erase(str);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public long get(String str, long j) {
        return getLong(str, j);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void put(String str, long j) {
        this.u.storeLong(str, j);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public float get(String str, float f) {
        return getFloat(str, f);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void put(String str, float f) {
        this.u.storeFloat(str, f);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public boolean get(String str, boolean z) {
        return getBoolean(str, z);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void put(String str, boolean z) {
        this.u.storeBoolean(str, z);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public String get(String str, String str2) {
        return getString(str, str2);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void put(String str, String str2) {
        this.u.storeString(str, str2);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public Set<String> get(String str, Set<String> set) {
        return getStringSet(str, set);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void put(String str, Set<String> set) {
        this.u.getStringSet(str, set);
    }

    private static boolean u(Context context) {
        if (context == null) {
            return false;
        }
        KevaBuilder kevaBuilder = KevaBuilder.getInstance();
        kevaBuilder.setMonitor(new KevaMonitor() { // from class: com.bytedance.sdk.component.x.nr.u.u.1
        });
        kevaBuilder.setContext(context);
        return true;
    }

    private void u(String str, boolean z) {
        if (z) {
            this.u = Keva.getRepo(str, 1);
        } else {
            this.u = Keva.getRepo(str, 0);
        }
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
