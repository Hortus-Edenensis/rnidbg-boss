package defpackage;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0004\b\b\u0010\u0006J!\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00028\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lzi;", ExifInterface.GPS_DIRECTION_TRUE, "Ld84;", "", "decision", "e", "(Ljava/lang/Object;)Ljava/lang/Object;", "affected", "g", "failure", "", "d", "(Ljava/lang/Object;Ljava/lang/Object;)V", "c", "", "f", "()J", "opSequence", "a", "()Lzi;", "atomicOp", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class zi<T> extends d84 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f22431a = AtomicReferenceFieldUpdater.newUpdater(zi.class, Object.class, "_consensus");
    private volatile /* synthetic */ Object _consensus = yi.f22203a;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.d84
    public final Object c(Object affected) {
        Object objE = this._consensus;
        if (objE == yi.f22203a) {
            objE = e(g(affected));
        }
        d(affected, objE);
        return objE;
    }

    public abstract void d(T affected, Object failure);

    public final Object e(Object decision) {
        Object obj = this._consensus;
        Object obj2 = yi.f22203a;
        return obj != obj2 ? obj : p1.a(f22431a, this, obj2, decision) ? decision : this._consensus;
    }

    public long f() {
        return 0L;
    }

    public abstract Object g(T affected);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.d84
    public zi<?> a() {
        return this;
    }
}
