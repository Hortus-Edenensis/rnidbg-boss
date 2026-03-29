package defpackage;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001f\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096Aø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lnt4;", ExifInterface.GPS_DIRECTION_TRUE, "Lmk5;", "", "Lfy1;", "collector", "", "a", "(Lfy1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcy2;", "Lcy2;", "job", "flow", "<init>", "(Lmk5;Lcy2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class nt4<T> implements mk5<T>, dy1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final cy2 job;
    public final /* synthetic */ mk5<T> b;

    /* JADX WARN: Multi-variable type inference failed */
    public nt4(mk5<? extends T> mk5Var, cy2 cy2Var) {
        this.job = cy2Var;
        this.b = mk5Var;
    }

    @Override // defpackage.q75, defpackage.dy1
    public Object a(fy1<? super T> fy1Var, Continuation<?> continuation) {
        return this.b.a(fy1Var, continuation);
    }
}
