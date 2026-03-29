package defpackage;

import androidx.exifinterface.media.ExifInterface;
import com.qq.gdt.action.ActionUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0017\u0010\u0011J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0016\u0010\u0006\u001a\u0004\u0018\u00018\u00008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0005R\u0018\u0010\b\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR(\u0010\r\u001a\u0004\u0018\u00018\u00002\b\u0010\r\u001a\u0004\u0018\u00018\u00008V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0015\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0002\u0010\u0014¨\u0006\u0018"}, d2 = {"Lsw;", ExifInterface.GPS_DIRECTION_TRUE, "Lb;", "", "g", "Ljava/lang/Object;", "_origin", "c", "_value", "", "d", "Z", "_dirty", ActionUtils.PAYMENT_AMOUNT, "i", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "a", "()Z", "(Z)V", "dirty", "v", "<init>", "zx-jvm"}, k = 1, mv = {1, 4, 0})
public class sw<T> extends b<T> {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final T _origin;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public T _value;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public boolean _dirty;

    public sw(T t) {
        this._origin = t;
        this._value = t;
    }

    @Override // defpackage.pk2
    public boolean a() {
        a.d(this, 0L, 1, null);
        return this._dirty;
    }

    @Override // defpackage.pk2
    public void b(boolean z) {
        a.d(this, 0L, 1, null);
        this._dirty = z;
    }

    @Override // defpackage.b
    public void g() {
        this._value = this._origin;
        this._dirty = false;
    }

    public T i() {
        a.d(this, 0L, 1, null);
        return this._value;
    }

    @Override // defpackage.pk2
    public void setValue(T t) {
        h(null);
        if (!Intrinsics.areEqual(this._value, t)) {
            this._value = t;
            this._dirty = true;
        }
    }

    public /* synthetic */ sw(Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : obj);
    }
}
