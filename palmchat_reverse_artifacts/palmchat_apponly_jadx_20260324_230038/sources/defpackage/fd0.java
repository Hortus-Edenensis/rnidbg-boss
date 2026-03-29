package defpackage;

import androidx.exifinterface.media.ExifInterface;
import com.qq.gdt.action.ActionUtils;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import defpackage.v53;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.channels.ClosedReceiveChannelException;
import kotlinx.coroutines.channels.ClosedSendChannelException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u000e\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0011\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J!\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00028\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u0010\u001a\u00020\b2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0014R\u0011\u0010\u0018\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0019\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0001\u0010\u0017R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001b¨\u0006!"}, d2 = {"Lfd0;", ExifInterface.LONGITUDE_EAST, "Lj55;", "Lvt4;", "Lv53$b;", "otherOp", "Lyp5;", "A", "", "x", ActionUtils.PAYMENT_AMOUNT, "e", "(Ljava/lang/Object;Lv53$b;)Lyp5;", "d", "(Ljava/lang/Object;)V", "closed", "z", "", "toString", "", "Ljava/lang/Throwable;", "closeCause", "F", "()Ljava/lang/Throwable;", "sendException", "receiveException", WkAdxAdConfigMg.DSP_NAME_CSJ, "()Lfd0;", "offerResult", "D", "pollResult", "<init>", "(Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class fd0<E> extends j55 implements vt4<E> {

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @JvmField
    public final Throwable closeCause;

    public fd0(Throwable th) {
        this.closeCause = th;
    }

    @Override // defpackage.j55
    public yp5 A(v53.b otherOp) {
        return cz.f16950a;
    }

    public final Throwable E() {
        Throwable th = this.closeCause;
        return th == null ? new ClosedReceiveChannelException("Channel was closed") : th;
    }

    public final Throwable F() {
        Throwable th = this.closeCause;
        return th == null ? new ClosedSendChannelException("Channel was closed") : th;
    }

    @Override // defpackage.vt4
    public yp5 e(E value, v53.b otherOp) {
        return cz.f16950a;
    }

    @Override // defpackage.v53
    public String toString() {
        return "Closed@" + pv0.b(this) + '[' + this.closeCause + ']';
    }

    @Override // defpackage.vt4
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public fd0<E> a() {
        return this;
    }

    @Override // defpackage.j55
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public fd0<E> y() {
        return this;
    }

    @Override // defpackage.j55
    public void x() {
    }

    @Override // defpackage.vt4
    public void d(E value) {
    }

    @Override // defpackage.j55
    public void z(fd0<?> closed) {
    }
}
