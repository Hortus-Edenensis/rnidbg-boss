package defpackage;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.ads.ContentClassification;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.internal.UndeliveredElementException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B9\u0012\u0006\u0010!\u001a\u00020\u0016\u0012\u0006\u0010$\u001a\u00020\"\u0012 \u0010?\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0013\u0018\u00010=j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`>¢\u0006\u0004\b@\u0010AJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010#R\u0018\u0010)\u001a\u00060%j\u0002`&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010 R\u0014\u00102\u001a\u00020\u000f8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u00104\u001a\u00020\u000f8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b3\u00101R\u0014\u00106\u001a\u00020\u000f8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b5\u00101R\u0014\u00108\u001a\u00020\u000f8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b7\u00101R\u0014\u00109\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u00101R\u0014\u0010<\u001a\u00020:8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b.\u0010;¨\u0006B"}, d2 = {"Lnh;", ExifInterface.LONGITUDE_EAST, "Ly0;", "element", "", "v", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lj55;", LogUtil.VALUE_SEND, "e", "(Lj55;)Ljava/lang/Object;", "N", "()Ljava/lang/Object;", "Ltt4;", "receive", "", "F", "(Ltt4;)Z", "wasClosed", "", ContentClassification.AD_CONTENT_CLASSIFICATION_J, "(Z)V", "", "currentSize", "Lyp5;", ExifInterface.LATITUDE_SOUTH, "(I)Lyp5;", "Q", "(ILjava/lang/Object;)V", "R", "(I)V", "d", "I", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "f", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "", "g", "[Ljava/lang/Object;", "buffer", "h", "head", WkAdxAdConfigMg.DSP_NAME_GDT, "()Z", "isBufferAlwaysEmpty", "H", "isBufferEmpty", "s", "isBufferAlwaysFull", "t", "isBufferFull", "isClosedForReceive", "", "()Ljava/lang/String;", "bufferDebugString", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class nh<E> extends y0<E> {

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final int capacity;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final BufferOverflow onBufferOverflow;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final ReentrantLock lock;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public Object[] buffer;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public int head;
    private volatile /* synthetic */ int size;

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public nh(int i, BufferOverflow bufferOverflow, Function1<? super E, Unit> function1) {
        super(function1);
        this.capacity = i;
        this.onBufferOverflow = bufferOverflow;
        if (!(i >= 1)) {
            throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + i + " was specified").toString());
        }
        this.lock = new ReentrantLock();
        Object[] objArr = new Object[Math.min(i, 8)];
        ArraysKt___ArraysJvmKt.fill$default(objArr, z0.f22308a, 0, 0, 6, (Object) null);
        this.buffer = objArr;
        this.size = 0;
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
        return this.size == 0;
    }

    @Override // defpackage.y0
    public boolean I() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return super.I();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // defpackage.y0
    public void J(boolean wasClosed) {
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i = this.size;
            UndeliveredElementException undeliveredElementExceptionC = null;
            for (int i2 = 0; i2 < i; i2++) {
                Object obj = this.buffer[this.head];
                if (function1 != null && obj != z0.f22308a) {
                    undeliveredElementExceptionC = C1503w74.c(function1, obj, undeliveredElementExceptionC);
                }
                Object[] objArr = this.buffer;
                int i3 = this.head;
                objArr[i3] = z0.f22308a;
                this.head = (i3 + 1) % objArr.length;
            }
            this.size = 0;
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            super.J(wasClosed);
            if (undeliveredElementExceptionC != null) {
                throw undeliveredElementExceptionC;
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
            int i = this.size;
            if (i == 0) {
                Object objK = k();
                if (objK == null) {
                    objK = z0.d;
                }
                return objK;
            }
            Object[] objArr = this.buffer;
            int i2 = this.head;
            Object obj = objArr[i2];
            j55 j55Var = null;
            objArr[i2] = null;
            this.size = i - 1;
            Object element = z0.d;
            boolean z = false;
            if (i == this.capacity) {
                j55 j55Var2 = null;
                while (true) {
                    j55 j55VarA = A();
                    if (j55VarA == null) {
                        j55Var = j55Var2;
                        break;
                    }
                    Intrinsics.checkNotNull(j55VarA);
                    if (j55VarA.A(null) != null) {
                        element = j55VarA.getElement();
                        j55Var = j55VarA;
                        z = true;
                        break;
                    }
                    j55VarA.B();
                    j55Var2 = j55VarA;
                }
            }
            if (element != z0.d && !(element instanceof fd0)) {
                this.size = i;
                Object[] objArr2 = this.buffer;
                objArr2[(this.head + i) % objArr2.length] = element;
            }
            this.head = (this.head + 1) % this.buffer.length;
            Unit unit = Unit.INSTANCE;
            if (z) {
                Intrinsics.checkNotNull(j55Var);
                j55Var.x();
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void Q(int currentSize, E element) {
        if (currentSize < this.capacity) {
            R(currentSize);
            Object[] objArr = this.buffer;
            objArr[(this.head + currentSize) % objArr.length] = element;
        } else {
            Object[] objArr2 = this.buffer;
            int i = this.head;
            objArr2[i % objArr2.length] = null;
            objArr2[(currentSize + i) % objArr2.length] = element;
            this.head = (i + 1) % objArr2.length;
        }
    }

    public final void R(int currentSize) {
        Object[] objArr = this.buffer;
        if (currentSize >= objArr.length) {
            int iMin = Math.min(objArr.length * 2, this.capacity);
            Object[] objArr2 = new Object[iMin];
            for (int i = 0; i < currentSize; i++) {
                Object[] objArr3 = this.buffer;
                objArr2[i] = objArr3[(this.head + i) % objArr3.length];
            }
            ArraysKt___ArraysJvmKt.fill((yp5[]) objArr2, z0.f22308a, currentSize, iMin);
            this.buffer = objArr2;
            this.head = 0;
        }
    }

    public final yp5 S(int currentSize) {
        if (currentSize < this.capacity) {
            this.size = currentSize + 1;
            return null;
        }
        int i = a.$EnumSwitchMapping$0[this.onBufferOverflow.ordinal()];
        if (i == 1) {
            return z0.c;
        }
        if (i == 2) {
            return z0.b;
        }
        if (i == 3) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // defpackage.q1
    public Object e(j55 send) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return super.e(send);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // defpackage.q1
    public String h() {
        return "(buffer:capacity=" + this.capacity + ",size=" + this.size + ')';
    }

    @Override // defpackage.q1
    public final boolean s() {
        return false;
    }

    @Override // defpackage.q1
    public final boolean t() {
        return this.size == this.capacity && this.onBufferOverflow == BufferOverflow.SUSPEND;
    }

    @Override // defpackage.q1
    public Object v(E element) {
        vt4<E> vt4VarZ;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i = this.size;
            fd0<?> fd0VarK = k();
            if (fd0VarK != null) {
                return fd0VarK;
            }
            yp5 yp5VarS = S(i);
            if (yp5VarS != null) {
                return yp5VarS;
            }
            if (i == 0) {
                do {
                    vt4VarZ = z();
                    if (vt4VarZ != null) {
                        if (vt4VarZ instanceof fd0) {
                            this.size = i;
                            return vt4VarZ;
                        }
                        Intrinsics.checkNotNull(vt4VarZ);
                    }
                } while (vt4VarZ.e(element, null) == null);
                this.size = i;
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
                vt4VarZ.d(element);
                return vt4VarZ.a();
            }
            Q(i, element);
            return z0.b;
        } finally {
            reentrantLock.unlock();
        }
    }
}
