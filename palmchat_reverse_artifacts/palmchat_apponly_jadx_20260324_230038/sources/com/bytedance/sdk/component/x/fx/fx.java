package com.bytedance.sdk.component.x.fx;

import android.content.SharedPreferences;
import com.bytedance.sdk.component.b.x;
import com.bytedance.sdk.component.jk.jk;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx implements com.bytedance.sdk.component.b.nr.fx {
    private static int nr = 3;
    private static ThreadPoolExecutor u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f5186a;
    private final File b;
    private final File fx;
    private final com.bytedance.sdk.component.x.nr l;
    private volatile boolean n;
    private final boolean s;
    private long t;
    private final Object pn = new Object();
    private final Map<String, Object> iz = new ConcurrentHashMap();
    private Map<String, Object> x = new HashMap();
    private final List<Runnable> jk = new ArrayList();
    private AtomicBoolean mv = new AtomicBoolean(false);

    /* JADX INFO: compiled from: SearchBox */
    public final class u implements SharedPreferences.Editor {
        public u() {
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            fx.this.apply();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            try {
                fx.fx(fx.this);
                fx.this.x.clear();
            } catch (Exception unused) {
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            fx.this.u(str, Boolean.valueOf(z));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f) {
            fx.this.u(str, Float.valueOf(f));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i) {
            fx.this.u(str, Integer.valueOf(i));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            fx.this.u(str, Long.valueOf(j));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            fx.this.u(str, str2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            fx.this.u(str, set);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            fx.this.remove(str);
            return this;
        }
    }

    public fx(File file, com.bytedance.sdk.component.x.u uVar, com.bytedance.sdk.component.x.nr nrVar, boolean z) {
        this.n = false;
        this.s = z;
        File file2 = new File(file.getParent(), file.getName() + ".prop");
        if (file2.exists() && file2.length() > 0) {
            uVar = new com.bytedance.sdk.component.x.fx.u(null);
            file = file2;
        }
        this.fx = file;
        this.b = new File(file.getPath() + ".bak");
        this.n = false;
        uVar = uVar == null ? new com.bytedance.sdk.component.x.fx.u(null) : uVar;
        if (nrVar == null) {
            this.l = new com.bytedance.sdk.component.x.fx.u(null);
        } else {
            this.l = nrVar;
        }
        u(uVar);
    }

    public static /* synthetic */ long fx(fx fxVar) {
        long j = fxVar.f5186a;
        fxVar.f5186a = 1 + j;
        return j;
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void apply() {
        if (!this.n) {
            if (this.mv.compareAndSet(false, true)) {
                u(new Runnable() { // from class: com.bytedance.sdk.component.x.fx.fx.3
                    @Override // java.lang.Runnable
                    public void run() {
                        fx.this.mv.set(false);
                        fx.this.apply();
                    }
                });
            }
        } else if (this.t != this.f5186a && this.mv.compareAndSet(false, true)) {
            fx().execute(new Runnable() { // from class: com.bytedance.sdk.component.x.fx.fx.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Map<String, Object> mapPn = fx.this.pn();
                        if (mapPn != null) {
                            fx.this.l.u(mapPn, fx.this.fx);
                        }
                        fx.this.mv.set(false);
                    } catch (Exception e) {
                        fx.this.u("apply write error", (Throwable) e);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void applySync() {
        if (!this.n) {
            if (this.mv.compareAndSet(false, true)) {
                u(new Runnable() { // from class: com.bytedance.sdk.component.x.fx.fx.5
                    @Override // java.lang.Runnable
                    public void run() {
                        fx.this.mv.set(false);
                        fx.this.applySync();
                    }
                });
            }
        } else if (this.mv.compareAndSet(false, true)) {
            try {
                Map<String, Object> mapPn = pn();
                if (mapPn != null) {
                    this.l.u(mapPn, this.fx);
                }
                this.mv.set(false);
            } catch (Exception e) {
                u("applySync write error", (Throwable) e);
            }
        }
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void clear() {
        if (!this.n) {
            u(new Runnable() { // from class: com.bytedance.sdk.component.x.fx.fx.2
                @Override // java.lang.Runnable
                public void run() {
                    fx.this.iz.clear();
                    synchronized ("SharedPreferencesImpl") {
                        fx.this.x.clear();
                        fx.fx(fx.this);
                    }
                }
            });
            return;
        }
        this.iz.clear();
        synchronized ("SharedPreferencesImpl") {
            this.x.clear();
            this.f5186a++;
        }
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public boolean contains(String str) {
        boolean zContainsKey;
        if (str == null) {
            str = "";
        }
        synchronized (this.pn) {
            nr();
            zContainsKey = this.iz.containsKey(str);
        }
        return zContainsKey;
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public int get(String str, int i) {
        return getInt(str, i);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        Map<String, ?> mapB;
        if (!this.s) {
            return b();
        }
        synchronized (this.pn) {
            nr();
            mapB = b();
        }
        return mapB;
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        boolean zU;
        if (str == null) {
            str = "";
        }
        if (!this.s) {
            return u(str, z);
        }
        synchronized (this.pn) {
            nr();
            zU = u(str, z);
        }
        return zU;
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        float fU;
        if (str == null) {
            str = "";
        }
        if (!this.s) {
            return u(str, f);
        }
        synchronized (this.pn) {
            nr();
            fU = u(str, f);
        }
        return fU;
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public int getInt(String str, int i) {
        int iU;
        if (str == null) {
            str = "";
        }
        if (!this.s) {
            return u(str, i);
        }
        synchronized (this.pn) {
            nr();
            iU = u(str, i);
        }
        return iU;
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public long getLong(String str, long j) {
        long jU;
        if (str == null) {
            str = "";
        }
        if (!this.s) {
            return u(str, j);
        }
        synchronized (this.pn) {
            nr();
            jU = u(str, j);
        }
        return jU;
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public String getString(String str, String str2) {
        String strU;
        if (str == null) {
            str = "";
        }
        if (!this.s) {
            return u(str, str2);
        }
        synchronized (this.pn) {
            nr();
            strU = u(str, str2);
        }
        return strU;
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> setU;
        if (str == null) {
            str = "";
        }
        if (!this.s) {
            return u(str, set);
        }
        synchronized (this.pn) {
            nr();
            setU = u(str, set);
        }
        return setU;
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void put(String str, int i) {
        u(str, Integer.valueOf(i));
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void remove(String str) {
        synchronized ("SharedPreferencesImpl") {
            this.x.put(str, null);
            this.f5186a++;
        }
    }

    private Map<String, ?> b() {
        HashMap map = new HashMap(this.iz);
        map.putAll(this.x);
        return map;
    }

    private static ThreadPoolExecutor fx() {
        ThreadPoolExecutor threadPoolExecutor = u;
        if (threadPoolExecutor != null) {
            return threadPoolExecutor;
        }
        synchronized (fx.class) {
            ThreadPoolExecutor threadPoolExecutor2 = u;
            if (threadPoolExecutor2 != null) {
                return threadPoolExecutor2;
            }
            int i = nr;
            com.bytedance.sdk.component.jk.b.b bVar = new com.bytedance.sdk.component.jk.b.b(i, i, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new jk("SharedPreferencesImpl"));
            u = bVar;
            return bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(com.bytedance.sdk.component.x.u uVar) {
        Map<String, Object> mapU;
        synchronized (this.pn) {
            if (this.n) {
                return;
            }
            if (this.b.exists()) {
                this.fx.delete();
                this.b.renameTo(this.fx);
            }
            try {
                mapU = uVar.u(this.fx);
            } catch (Throwable th) {
                u("loadFromDisk error", th);
                mapU = null;
            }
            synchronized (this.pn) {
                this.n = true;
                if (mapU != null) {
                    try {
                        for (Map.Entry<String, Object> entry : mapU.entrySet()) {
                            Object value = entry.getValue();
                            if (value != null) {
                                String key = entry.getKey();
                                if (key == null) {
                                    key = "";
                                }
                                this.iz.put(key, value);
                            }
                        }
                    } finally {
                        this.pn.notifyAll();
                    }
                }
            }
            synchronized (this.jk) {
                Iterator<Runnable> it = this.jk.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
                this.jk.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> pn() {
        HashMap map;
        synchronized ("SharedPreferencesImpl") {
            map = new HashMap(this.x);
            this.x = new HashMap();
        }
        HashMap map2 = new HashMap(this.iz);
        if (map.isEmpty() && map2.isEmpty()) {
            return map2;
        }
        int i = 0;
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            Object obj = map2.get(str);
            if (value == null) {
                if (obj != null) {
                    map2.remove(str);
                    i++;
                }
            } else if (!value.equals(obj)) {
                map2.put(str, value);
                i++;
            }
        }
        if (i > 0) {
            return map2;
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public long get(String str, long j) {
        return getLong(str, j);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void put(String str, long j) {
        u(str, Long.valueOf(j));
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public float get(String str, float f) {
        return getFloat(str, f);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void put(String str, float f) {
        u(str, Float.valueOf(f));
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public boolean get(String str, boolean z) {
        return getBoolean(str, z);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void put(String str, boolean z) {
        u(str, Boolean.valueOf(z));
    }

    private void u(final com.bytedance.sdk.component.x.u uVar) {
        synchronized (this.pn) {
            this.n = false;
        }
        fx().execute(new Runnable() { // from class: com.bytedance.sdk.component.x.fx.fx.1
            @Override // java.lang.Runnable
            public void run() {
                fx.this.nr(uVar);
            }
        });
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public String get(String str, String str2) {
        return getString(str, str2);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void put(String str, String str2) {
        u(str, str2);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public Set<String> get(String str, Set<String> set) {
        return getStringSet(str, set);
    }

    @Override // com.bytedance.sdk.component.b.nr.fx
    public void put(String str, Set<String> set) {
        u(str, set);
    }

    private String u(String str, String str2) {
        try {
            Object obj = this.x.get(str);
            if (obj == null) {
                obj = this.iz.get(str);
            }
            return obj != null ? String.valueOf(obj) : str2;
        } catch (Exception e) {
            u("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return str2;
        }
    }

    private Set<String> u(String str, Set<String> set) {
        try {
            Set<String> set2 = (Set) this.x.get(str);
            if (set2 == null) {
                set2 = (Set) this.iz.get(str);
            }
            return set2 != null ? set2 : set;
        } catch (Exception e) {
            u("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return set;
        }
    }

    private int u(String str, int i) {
        try {
            Object obj = this.x.get(str);
            if (obj == null) {
                obj = this.iz.get(str);
            }
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            if (obj instanceof Float) {
                return ((Float) obj).intValue();
            }
            return obj != null ? ((Integer) obj).intValue() : i;
        } catch (Exception e) {
            u("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return i;
        }
    }

    private long u(String str, long j) {
        try {
            Long l = (Long) this.x.get(str);
            if (l == null) {
                l = (Long) this.iz.get(str);
            }
            return l != null ? l.longValue() : j;
        } catch (Exception e) {
            u("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return j;
        }
    }

    private void nr() {
        while (!this.n) {
            try {
                this.pn.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    private float u(String str, float f) {
        try {
            Object obj = this.x.get(str);
            if (obj == null) {
                obj = this.iz.get(str);
            }
            if (obj instanceof Integer) {
                return ((Integer) obj).floatValue();
            }
            if (obj instanceof Float) {
                return ((Float) obj).floatValue();
            }
            return obj != null ? ((Float) obj).floatValue() : f;
        } catch (Exception e) {
            u("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return f;
        }
    }

    private boolean u(String str, boolean z) {
        try {
            Boolean bool = (Boolean) this.x.get(str);
            if (bool == null) {
                bool = (Boolean) this.iz.get(str);
            }
            return bool != null ? bool.booleanValue() : z;
        } catch (Exception e) {
            u("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return z;
        }
    }

    @Override // com.bytedance.sdk.component.b.nr.fx, android.content.SharedPreferences
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public u edit() {
        synchronized (this.pn) {
            nr();
        }
        return new u();
    }

    private void u(Runnable runnable) {
        synchronized (this.jk) {
            if (this.n) {
                runnable.run();
            } else {
                this.jk.add(runnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void u(String str, T t) {
        if (str == null) {
            str = "";
        }
        synchronized ("SharedPreferencesImpl") {
            this.x.put(str, t);
            this.f5186a++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, Throwable th) {
        x xVar = (x) com.bytedance.sdk.openadsdk.ats.fx.u("event");
        if (xVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("file", this.fx.getAbsolutePath());
                jSONObject.put("msg", str);
                jSONObject.put("class", "SharedPreferencesImpl");
            } catch (JSONException unused) {
            }
            xVar.onExceptionEvent("kv", jSONObject, th);
        }
    }
}
