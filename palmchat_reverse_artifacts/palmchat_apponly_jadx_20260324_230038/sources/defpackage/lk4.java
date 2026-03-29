package defpackage;

import androidx.exifinterface.media.ExifInterface;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0003\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\t\u0010\bR\u001c\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u000e¨\u0006\u0013"}, d2 = {"Llk4;", ExifInterface.GPS_DIRECTION_TRUE, "", "a", "()Ljava/lang/Object;", "instance", "", "c", "(Ljava/lang/Object;)Z", t.l, "", "[Ljava/lang/Object;", "mPool", "", "I", "mPoolSize", "maxPoolSize", "<init>", "(I)V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public class lk4<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Object[] mPool;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public int mPoolSize;

    public lk4(int i) {
        if (!(i > 0)) {
            throw new IllegalArgumentException("The max pool size must be > 0".toString());
        }
        this.mPool = new Object[i];
    }

    public T a() {
        int i = this.mPoolSize;
        if (i <= 0) {
            return null;
        }
        int i2 = i - 1;
        Object[] objArr = this.mPool;
        T t = (T) objArr[i2];
        objArr[i2] = null;
        this.mPoolSize = i - 1;
        return t;
    }

    public final boolean b(T instance) {
        int i = this.mPoolSize;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.mPool[i2] == instance) {
                return true;
            }
        }
        return false;
    }

    public boolean c(T instance) {
        if (!(!b(instance))) {
            throw new IllegalStateException("Already in the pool!".toString());
        }
        int i = this.mPoolSize;
        Object[] objArr = this.mPool;
        if (i >= objArr.length) {
            return false;
        }
        objArr[i] = instance;
        this.mPoolSize = i + 1;
        return true;
    }
}
