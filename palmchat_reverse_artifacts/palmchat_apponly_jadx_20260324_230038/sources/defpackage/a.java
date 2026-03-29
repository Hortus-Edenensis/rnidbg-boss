package defpackage;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0007\u001a\u00020\u00062\f\b\u0002\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H&J\u0017\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"La;", ExifInterface.GPS_DIRECTION_TRUE, "Lpk2;", "", "Lcom/zenmen/palmchat/zx/jvm/TimeStampValue;", "now", "", "c", "v", "", "e", "(Ljava/lang/Object;)V", "f", "()Z", "notDirty", "<init>", "()V", "zx-jvm"}, k = 1, mv = {1, 4, 0})
public abstract class a<T> implements pk2<T> {
    public static /* synthetic */ boolean d(a aVar, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkExpiredOrReleased");
        }
        if ((i & 1) != 0) {
            j = vx5.a();
        }
        return aVar.c(j);
    }

    public abstract boolean c(long now);

    public final void e(T v) {
        setValue(v);
        b(true);
    }

    public final boolean f() {
        return !a();
    }
}
