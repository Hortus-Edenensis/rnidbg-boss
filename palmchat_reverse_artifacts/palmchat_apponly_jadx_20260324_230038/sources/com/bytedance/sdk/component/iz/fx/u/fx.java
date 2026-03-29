package com.bytedance.sdk.component.iz.fx.u;

import com.huawei.hms.framework.common.ContainerUtils;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx<K, V> {
    private int b;
    private int fx;
    private int iz;
    private int n;
    private int nr;
    private int pn;
    private final LinkedHashMap<K, SoftReference<V>> u;
    private int x;

    public fx(int i) {
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
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.fx), Integer.valueOf(this.x), Integer.valueOf(this.n), Integer.valueOf(i2 != 0 ? (i * 100) / i2 : 0));
    }

    public final V u(K k) {
        V v;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            SoftReference<V> softReference = this.u.get(k);
            if (softReference != null) {
                v = softReference.get();
                if (v != null) {
                    this.x++;
                    return v;
                }
                this.u.remove(k);
            } else {
                v = null;
            }
            this.n++;
            V vNr = nr(k);
            if (vNr == null) {
                return null;
            }
            synchronized (this) {
                this.pn++;
                SoftReference<V> softReferencePut = this.u.put(k, new SoftReference<>(vNr));
                if (softReferencePut != null) {
                    v = softReferencePut.get();
                }
                if (v != null) {
                    this.u.put(k, softReferencePut);
                } else {
                    this.nr += fx(k, vNr);
                }
            }
            if (v != null) {
                return v;
            }
            u(this.fx);
            return vNr;
        }
    }

    public V nr(K k) {
        return null;
    }

    public final V u(K k, V v) {
        V v2;
        if (k != null && v != null) {
            synchronized (this) {
                this.b++;
                this.nr += fx(k, v);
                SoftReference<V> softReferencePut = this.u.put(k, new SoftReference<>(v));
                if (softReferencePut != null) {
                    v2 = softReferencePut.get();
                    if (v2 != null) {
                        this.nr -= fx(k, v2);
                    }
                } else {
                    v2 = null;
                }
            }
            u(this.fx);
            return v2;
        }
        throw new NullPointerException("key == null || value == null");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0052, code lost:
    
        com.bytedance.sdk.component.utils.k.nr("LruCache", "oom maybe occured, clear cache. size= " + r3.nr + ", maxSize: " + r4);
        r3.nr = 0;
        r3.u.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0078, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u(int i) {
        while (true) {
            synchronized (this) {
                if (this.nr < 0 || (this.u.isEmpty() && this.nr != 0)) {
                    break;
                }
                if (this.nr <= i) {
                    return;
                }
                Map.Entry<K, SoftReference<V>> next = this.u.entrySet().iterator().next();
                if (next == null) {
                    return;
                }
                K key = next.getKey();
                SoftReference<V> value = next.getValue();
                this.u.remove(key);
                if (value != null) {
                    this.nr -= fx(key, value.get());
                }
                this.iz++;
            }
        }
    }

    public final void u() {
        u(-1);
    }
}
