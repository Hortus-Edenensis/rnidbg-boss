package defpackage;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0005\"\u001a\u0010\u0004\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0001\u0010\u0003¨\u0006\u0005"}, d2 = {"", "a", "Z", "()Z", "ANDROID_DETECTED", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class jt1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f18495a = false;

    static {
        Object objM840constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM840constructorimpl = Result.m840constructorimpl(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM840constructorimpl = Result.m840constructorimpl(ResultKt.createFailure(th));
        }
        Result.m847isSuccessimpl(objM840constructorimpl);
    }

    public static final boolean a() {
        return f18495a;
    }
}
