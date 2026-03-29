package defpackage;

import androidx.exifinterface.media.ExifInterface;
import defpackage.v53;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmField;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0012\u001a\u00028\u0000\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0014\u0010\u000b\u001a\u00020\u00072\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u001a\u0010\u0012\u001a\u00028\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00138\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lm55;", ExifInterface.LONGITUDE_EAST, "Lj55;", "Lv53$b;", "otherOp", "Lyp5;", "A", "", "x", "Lfd0;", "closed", "z", "", "toString", "d", "Ljava/lang/Object;", "y", "()Ljava/lang/Object;", "pollResult", "Laz;", "e", "Laz;", "cont", "<init>", "(Ljava/lang/Object;Laz;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class m55<E> extends j55 {

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final E pollResult;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @JvmField
    public final az<Unit> cont;

    /* JADX WARN: Multi-variable type inference failed */
    public m55(E e, az<? super Unit> azVar) {
        this.pollResult = e;
        this.cont = azVar;
    }

    @Override // defpackage.j55
    public yp5 A(v53.b otherOp) {
        if (this.cont.k(Unit.INSTANCE, null) == null) {
            return null;
        }
        return cz.f16950a;
    }

    @Override // defpackage.v53
    public String toString() {
        return pv0.a(this) + '@' + pv0.b(this) + '(' + getElement() + ')';
    }

    @Override // defpackage.j55
    public void x() {
        this.cont.j(cz.f16950a);
    }

    @Override // defpackage.j55
    /* JADX INFO: renamed from: y */
    public E getElement() {
        return this.pollResult;
    }

    @Override // defpackage.j55
    public void z(fd0<?> closed) {
        az<Unit> azVar = this.cont;
        Result.Companion companion = Result.INSTANCE;
        azVar.resumeWith(Result.m840constructorimpl(ResultKt.createFailure(closed.F())));
    }
}
