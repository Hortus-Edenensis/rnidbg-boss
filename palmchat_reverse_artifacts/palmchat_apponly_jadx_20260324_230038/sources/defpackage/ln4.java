package defpackage;

import androidx.exifinterface.media.ExifInterface;
import com.qq.gdt.action.ActionUtils;
import defpackage.l55;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001d\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014R\u0014\u0010\r\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lln4;", ExifInterface.LONGITUDE_EAST, "Lm00;", "Lmn4;", "", ActionUtils.PAYMENT_AMOUNT, "D0", "(Lkotlin/Unit;)V", "", "cause", "", "handled", "z0", "isActive", "()Z", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "Ll00;", "channel", "<init>", "(Lkotlin/coroutines/CoroutineContext;Ll00;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class ln4<E> extends m00<E> implements mn4<E> {
    public ln4(CoroutineContext coroutineContext, l00<E> l00Var) {
        super(coroutineContext, l00Var, true, true);
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: D0, reason: merged with bridge method [inline-methods] */
    public void A0(Unit value) {
        l55.a.a(C0(), null, 1, null);
    }

    @Override // defpackage.a1, defpackage.oy2, defpackage.cy2
    public boolean isActive() {
        return super.isActive();
    }

    @Override // defpackage.a1
    public void z0(Throwable cause, boolean handled) {
        if (C0().o(cause) || handled) {
            return;
        }
        oq0.a(get$context(), cause);
    }
}
