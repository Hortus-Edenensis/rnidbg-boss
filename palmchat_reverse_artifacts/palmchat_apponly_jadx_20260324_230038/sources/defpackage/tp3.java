package defpackage;

import com.kuaishou.weapon.p0.t;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001c\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\r\u001a\u00060\u000bj\u0002`\fH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0002R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Ltp3;", "Lzb3;", "Lua1;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "isDispatchNeeded", "", "parallelism", "Llq0;", "limitedParallelism", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "g", "", "toString", "i", "", "a", "Ljava/lang/Throwable;", "cause", t.l, "Ljava/lang/String;", "errorHint", "d", "()Lzb3;", "immediate", "<init>", "(Ljava/lang/Throwable;Ljava/lang/String;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class tp3 extends zb3 implements ua1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Throwable cause;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final String errorHint;

    public tp3(Throwable th, String str) {
        this.cause = th;
        this.errorHint = str;
    }

    @Override // defpackage.lq0
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public Void dispatch(CoroutineContext context, Runnable block) {
        i();
        throw new KotlinNothingValueException();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Void i() {
        String str;
        if (this.cause == null) {
            cc3.d();
            throw new KotlinNothingValueException();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Module with the Main dispatcher had failed to initialize");
        String str2 = this.errorHint;
        if (str2 != null) {
            str = ". " + str2;
            if (str == null) {
                str = "";
            }
        }
        sb.append(str);
        throw new IllegalStateException(sb.toString(), this.cause);
    }

    @Override // defpackage.lq0
    public boolean isDispatchNeeded(CoroutineContext context) {
        i();
        throw new KotlinNothingValueException();
    }

    @Override // defpackage.zb3, defpackage.lq0
    public lq0 limitedParallelism(int parallelism) {
        i();
        throw new KotlinNothingValueException();
    }

    @Override // defpackage.zb3, defpackage.lq0
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Dispatchers.Main[missing");
        if (this.cause != null) {
            str = ", cause=" + this.cause;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(']');
        return sb.toString();
    }

    @Override // defpackage.zb3
    public zb3 d() {
        return this;
    }
}
