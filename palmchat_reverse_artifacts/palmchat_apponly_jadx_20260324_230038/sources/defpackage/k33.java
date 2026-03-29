package defpackage;

import androidx.exifinterface.media.ExifInterface;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import defpackage.q1;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.UndeliveredElementException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B)\u0012 \u0010\u001b\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\r\u001a\u00020\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u000f8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u000f8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"Lk33;", ExifInterface.LONGITUDE_EAST, "Ly0;", "element", "", "v", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lzs2;", "Lj55;", "list", "Lfd0;", "closed", "", "K", "(Ljava/lang/Object;Lfd0;)V", "", WkAdxAdConfigMg.DSP_NAME_GDT, "()Z", "isBufferAlwaysEmpty", "H", "isBufferEmpty", "s", "isBufferAlwaysFull", "t", "isBufferFull", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class k33<E> extends y0<E> {
    public k33(Function1<? super E, Unit> function1) {
        super(function1);
    }

    @Override // defpackage.y0
    public final boolean G() {
        return true;
    }

    @Override // defpackage.y0
    public final boolean H() {
        return true;
    }

    @Override // defpackage.y0
    public void K(Object list, fd0<?> closed) {
        UndeliveredElementException undeliveredElementExceptionC = null;
        if (list != null) {
            if (list instanceof ArrayList) {
                ArrayList arrayList = (ArrayList) list;
                UndeliveredElementException undeliveredElementExceptionC2 = null;
                for (int size = arrayList.size() - 1; -1 < size; size--) {
                    j55 j55Var = (j55) arrayList.get(size);
                    if (j55Var instanceof q1.a) {
                        Function1<E, Unit> function1 = this.onUndeliveredElement;
                        undeliveredElementExceptionC2 = function1 != null ? C1503w74.c(function1, ((q1.a) j55Var).element, undeliveredElementExceptionC2) : null;
                    } else {
                        j55Var.z(closed);
                    }
                }
                undeliveredElementExceptionC = undeliveredElementExceptionC2;
            } else {
                j55 j55Var2 = (j55) list;
                if (j55Var2 instanceof q1.a) {
                    Function1<E, Unit> function12 = this.onUndeliveredElement;
                    if (function12 != null) {
                        undeliveredElementExceptionC = C1503w74.c(function12, ((q1.a) j55Var2).element, null);
                    }
                } else {
                    j55Var2.z(closed);
                }
            }
        }
        if (undeliveredElementExceptionC != null) {
            throw undeliveredElementExceptionC;
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
        vt4<?> vt4VarX;
        do {
            Object objV = super.v(element);
            yp5 yp5Var = z0.b;
            if (objV == yp5Var) {
                return yp5Var;
            }
            if (objV != z0.c) {
                if (objV instanceof fd0) {
                    return objV;
                }
                throw new IllegalStateException(("Invalid offerInternal result " + objV).toString());
            }
            vt4VarX = x(element);
            if (vt4VarX == null) {
                return yp5Var;
            }
        } while (!(vt4VarX instanceof fd0));
        return vt4VarX;
    }
}
