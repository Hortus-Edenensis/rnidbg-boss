package defpackage;

import androidx.exifinterface.media.ExifInterface;
import com.kuaishou.weapon.p0.t;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0005\u001a\u00028\u0001¢\u0006\u0004\b\u000b\u0010\nR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\rR \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\r¨\u0006\u0012"}, d2 = {"Lss;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", t.f7496a, "v", "", t.l, "(Ljava/lang/Object;Ljava/lang/Object;)V", "a", "(Ljava/lang/Object;)Ljava/lang/Object;", "c", "", "Ljava/util/Map;", "map", "pam", "<init>", "()V", "zx-jvm"}, k = 1, mv = {1, 4, 0})
public final class ss<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Map<K, V> map = new LinkedHashMap();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final Map<V, K> pam = new LinkedHashMap();

    public final V a(K k) {
        return this.map.get(k);
    }

    public final void b(K k, V v) {
        this.map.put(k, v);
        this.pam.put(v, k);
        if (!(this.map.size() == this.pam.size())) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public final K c(V v) {
        return this.pam.get(v);
    }
}
