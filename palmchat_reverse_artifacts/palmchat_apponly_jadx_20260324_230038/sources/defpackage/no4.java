package defpackage;

import androidx.exifinterface.media.ExifInterface;
import com.kuaishou.weapon.p0.t;
import com.qq.gdt.action.ActionUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B:\b\u0016\u0012\u0006\u0010\u001e\u001a\u00028\u0000\u0012'\u0010\u001f\u001a#\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\u0004\u0012\u00020\u00110\u0016j\b\u0012\u0004\u0012\u00028\u0000`\u0017¢\u0006\u0002\b\u0013¢\u0006\u0004\b \u0010!R\u0016\u0010\u0005\u001a\u00028\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004RZ\u0010\u000f\u001aF\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eRP\u0010\u0015\u001a<\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0012¢\u0006\u0002\b\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u000eR;\u0010\u001a\u001a'\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0017¢\u0006\u0002\b\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00028\u00008F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u001c\"\u0004\b\r\u0010\u001d¨\u0006\""}, d2 = {"Lno4;", ExifInterface.GPS_DIRECTION_TRUE, "", "a", "Ljava/lang/Object;", "_v", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "cur", "next", "", "Lcom/zenmen/palmchat/zx/jvm/PropertyChaningProc;", t.l, "Lkotlin/jvm/functions/Function2;", "_changing", "pre", "", "Lcom/zenmen/palmchat/zx/jvm/PropertyChangedProc;", "Lkotlin/ExtensionFunctionType;", "c", "_changed", "Lkotlin/Function1;", "Lcom/zenmen/palmchat/zx/jvm/PropertyChanged2Proc;", "d", "Lkotlin/jvm/functions/Function1;", "_changed2", ActionUtils.PAYMENT_AMOUNT, "()Ljava/lang/Object;", "(Ljava/lang/Object;)V", "v", "changed2", "<init>", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "zx-jvm"}, k = 1, mv = {1, 4, 0})
public class no4<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public T _v;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public Function2<? super no4<T>, ? super T, Boolean> _changing;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public Function2<? super no4<T>, ? super T, Unit> _changed;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public Function1<? super no4<T>, Unit> _changed2;

    public no4(T t, Function1<? super no4<T>, Unit> function1) {
        this._v = t;
        this._changed2 = function1;
    }

    public final T a() {
        return this._v;
    }

    public final void b(T t) {
        Function2<? super no4<T>, ? super T, Boolean> function2 = this._changing;
        if (function2 == null) {
            if (!Intrinsics.areEqual(this._v, t)) {
                T t2 = this._v;
                this._v = t;
                Function2<? super no4<T>, ? super T, Unit> function22 = this._changed;
                if (function22 != null) {
                    function22.mo5invoke(this, t2);
                }
                Function1<? super no4<T>, Unit> function1 = this._changed2;
                if (function1 != null) {
                    function1.invoke(this);
                    return;
                }
                return;
            }
            return;
        }
        if (function2 == null) {
            Intrinsics.throwNpe();
        }
        if (function2.mo5invoke(this, t).booleanValue()) {
            T t3 = this._v;
            this._v = t;
            Function2<? super no4<T>, ? super T, Unit> function23 = this._changed;
            if (function23 != null) {
                function23.mo5invoke(this, t3);
            }
            Function1<? super no4<T>, Unit> function12 = this._changed2;
            if (function12 != null) {
                function12.invoke(this);
            }
        }
    }
}
