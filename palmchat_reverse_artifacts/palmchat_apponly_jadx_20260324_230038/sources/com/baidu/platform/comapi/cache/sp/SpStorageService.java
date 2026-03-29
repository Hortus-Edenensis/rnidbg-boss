package com.baidu.platform.comapi.cache.sp;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.mapapi.JNIInitializer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class SpStorageService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, a> f4133a = new HashMap();
    private SpStorageConfig b;
    private a c;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SharedPreferences f4134a;
        private SharedPreferences.Editor b;

        public a(SharedPreferences sharedPreferences) {
            this.f4134a = sharedPreferences;
        }
    }

    private SpStorageService(SpStorageConfig spStorageConfig) {
        if (JNIInitializer.getCachedContext() == null) {
            return;
        }
        this.b = spStorageConfig;
        String storageName = spStorageConfig.getStorageName();
        if (!spStorageConfig.isCacheModel()) {
            this.c = new a(JNIInitializer.getCachedContext().getSharedPreferences(storageName, 0));
            return;
        }
        Map<String, a> map = f4133a;
        a aVar = map.get(storageName);
        if (aVar != null) {
            this.c = aVar;
            return;
        }
        a aVar2 = new a(JNIInitializer.getCachedContext().getSharedPreferences(storageName, 0));
        this.c = aVar2;
        map.put(storageName, aVar2);
    }

    public static SpStorageService a(SpStorageConfig spStorageConfig) {
        if (TextUtils.isEmpty(spStorageConfig.getStorageName())) {
            throw new IllegalArgumentException();
        }
        return new SpStorageService(spStorageConfig);
    }

    public void b(String str, int i) {
        synchronized (this.b) {
            a();
            this.c.b.putInt(str, i).apply();
        }
    }

    public int a(String str, int i) {
        int i2;
        synchronized (this.b) {
            i2 = this.c.f4134a.getInt(str, i);
        }
        return i2;
    }

    public void b(String str, float f) {
        synchronized (this.b) {
            a();
            this.c.b.putFloat(str, f).apply();
        }
    }

    public float a(String str, float f) {
        float f2;
        synchronized (this.b) {
            f2 = this.c.f4134a.getFloat(str, f);
        }
        return f2;
    }

    public void b(String str, long j) {
        synchronized (this.b) {
            a();
            this.c.b.putLong(str, j).apply();
        }
    }

    public long a(String str, long j) {
        long j2;
        synchronized (this.b) {
            j2 = this.c.f4134a.getLong(str, j);
        }
        return j2;
    }

    public void b(String str, boolean z) {
        synchronized (this.b) {
            a();
            this.c.b.putBoolean(str, z).apply();
        }
    }

    public boolean a(String str, boolean z) {
        boolean z2;
        synchronized (this.b) {
            z2 = this.c.f4134a.getBoolean(str, z);
        }
        return z2;
    }

    public String a(String str, String str2) {
        String string;
        synchronized (this.b) {
            string = this.c.f4134a.getString(str, str2);
        }
        return string;
    }

    public void b(String str, String str2) {
        synchronized (this.b) {
            a();
            this.c.b.putString(str, str2).apply();
        }
    }

    public void a(String str) {
        synchronized (this.b) {
            a();
            this.c.b.remove(str).apply();
        }
    }

    private void a() {
        synchronized (this.b) {
            a aVar = this.c;
            if (aVar.b != null) {
                return;
            }
            aVar.b = aVar.f4134a.edit();
        }
    }
}
