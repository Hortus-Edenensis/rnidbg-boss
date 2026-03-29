package defpackage;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.ads.ContentClassification;
import com.qq.gdt.action.ActionUtils;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.UndeliveredElementException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B)\u0012 \u0010(\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n\u0018\u00010&j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`'¢\u0006\u0004\b)\u0010*J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0014J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0014J\u0016\u0010\u000e\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0014J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002R\u0018\u0010\u0015\u001a\u00060\u0011j\u0002`\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\b8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\b8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\b8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001aR\u0014\u0010!\u001a\u00020\b8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001aR\u0014\u0010%\u001a\u00020\"8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006+"}, d2 = {"Lgm0;", ExifInterface.LONGITUDE_EAST, "Ly0;", "element", "", "v", "(Ljava/lang/Object;)Ljava/lang/Object;", "N", "", "wasClosed", "", ContentClassification.AD_CONTENT_CLASSIFICATION_J, "Ltt4;", "receive", "F", "Lkotlinx/coroutines/internal/UndeliveredElementException;", "Q", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "d", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "e", "Ljava/lang/Object;", ActionUtils.PAYMENT_AMOUNT, WkAdxAdConfigMg.DSP_NAME_GDT, "()Z", "isBufferAlwaysEmpty", "H", "isBufferEmpty", "s", "isBufferAlwaysFull", "t", "isBufferFull", "", "h", "()Ljava/lang/String;", "bufferDebugString", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class gm0<E> extends y0<E> {

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final ReentrantLock lock;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public Object value;

    public gm0(Function1<? super E, Unit> function1) {
        super(function1);
        this.lock = new ReentrantLock();
        this.value = z0.f22308a;
    }

    @Override // defpackage.y0
    public boolean F(tt4<? super E> receive) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return super.F(receive);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // defpackage.y0
    public final boolean G() {
        return false;
    }

    @Override // defpackage.y0
    public final boolean H() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.value == z0.f22308a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // defpackage.y0
    public void J(boolean wasClosed) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            UndeliveredElementException undeliveredElementExceptionQ = Q(z0.f22308a);
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            super.J(wasClosed);
            if (undeliveredElementExceptionQ != null) {
                throw undeliveredElementExceptionQ;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // defpackage.y0
    public Object N() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object obj = this.value;
            yp5 yp5Var = z0.f22308a;
            if (obj != yp5Var) {
                this.value = yp5Var;
                Unit unit = Unit.INSTANCE;
                return obj;
            }
            Object objK = k();
            if (objK == null) {
                objK = z0.d;
            }
            return objK;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final UndeliveredElementException Q(Object element) {
        Function1<E, Unit> function1;
        Object obj = this.value;
        UndeliveredElementException undeliveredElementExceptionD = null;
        if (obj != z0.f22308a && (function1 = this.onUndeliveredElement) != null) {
            undeliveredElementExceptionD = C1503w74.d(function1, obj, null, 2, null);
        }
        this.value = element;
        return undeliveredElementExceptionD;
    }

    @Override // defpackage.q1
    public String h() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return "(value=" + this.value + ')';
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // defpackage.q1
    public final boolean s() {
        return false;
    }

    @Override // defpackage.q1
    public final boolean t() {
        return false;
    }

    @Override // defpackage.q1
    public Object v(E element) {
        vt4<E> vt4VarZ;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            fd0<?> fd0VarK = k();
            if (fd0VarK != null) {
                return fd0VarK;
            }
            if (this.value == z0.f22308a) {
                do {
                    vt4VarZ = z();
                    if (vt4VarZ != null) {
                        if (vt4VarZ instanceof fd0) {
                            return vt4VarZ;
                        }
                        Intrinsics.checkNotNull(vt4VarZ);
                    }
                } while (vt4VarZ.e(element, null) == null);
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
                vt4VarZ.d(element);
                return vt4VarZ.a();
            }
            UndeliveredElementException undeliveredElementExceptionQ = Q(element);
            if (undeliveredElementExceptionQ == null) {
                return z0.b;
            }
            throw undeliveredElementExceptionQ;
        } finally {
            reentrantLock.unlock();
        }
    }
}
