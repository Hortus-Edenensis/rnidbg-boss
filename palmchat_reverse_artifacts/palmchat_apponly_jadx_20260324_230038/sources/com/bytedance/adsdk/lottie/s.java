package com.bytedance.adsdk.lottie;

import com.huawei.hms.framework.common.ContainerUtils;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class s<K, V> {
    private int b;
    private int fx;
    private int iz;
    private int n;
    private int nr;
    private int pn;
    private final LinkedHashMap<K, V> u;
    private int x;

    public s(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.fx = i;
        this.u = new LinkedHashMap<>(0, 0.75f, true);
    }

    private int fx(K k, V v) {
        int iNr = nr(k, v);
        if (iNr >= 0) {
            return iNr;
        }
        throw new IllegalStateException("Negative size: " + k + ContainerUtils.KEY_VALUE_DELIMITER + v);
    }

    public int nr(K k, V v) {
        return 1;
    }

    public final synchronized String toString() {
        int i;
        int i2;
        i = this.x;
        i2 = this.n + i;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.fx), Integer.valueOf(this.x), Integer.valueOf(this.n), Integer.valueOf(i2 != 0 ? (i * 100) / i2 : 0));
    }

    public void u(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        synchronized (this) {
            this.fx = i;
        }
        nr(i);
    }

    public V nr(K k) {
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x006c, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void nr(int i) {
        while (true) {
            synchronized (this) {
                if (this.nr >= 0 && (!this.u.isEmpty() || this.nr == 0)) {
                    if (this.nr <= i || this.u.isEmpty()) {
                        break;
                    }
                    Map.Entry<K, V> next = this.u.entrySet().iterator().next();
                    K key = next.getKey();
                    V value = next.getValue();
                    this.u.remove(key);
                    this.nr -= fx(key, value);
                    this.iz++;
                } else {
                    break;
                }
            }
        }
    }

    public final V u(K k) {
        V vPut;
        if (k != null) {
            synchronized (this) {
                V v = this.u.get(k);
                if (v != null) {
                    this.x++;
                    return v;
                }
                this.n++;
                V vNr = nr(k);
                if (vNr == null) {
                    return null;
                }
                synchronized (this) {
                    this.pn++;
                    vPut = this.u.put(k, vNr);
                    if (vPut != null) {
                        this.u.put(k, vPut);
                    } else {
                        this.nr += fx(k, vNr);
                    }
                }
                if (vPut != null) {
                    return vPut;
                }
                nr(this.fx);
                return vNr;
            }
        }
        throw new NullPointerException("key == null");
    }

    public final V u(K k, V v) {
        V vPut;
        if (k != null && v != null) {
            synchronized (this) {
                this.b++;
                this.nr += fx(k, v);
                vPut = this.u.put(k, v);
                if (vPut != null) {
                    this.nr -= fx(k, vPut);
                }
            }
            nr(this.fx);
            return vPut;
        }
        throw new NullPointerException("key == null || value == null");
    }
}
