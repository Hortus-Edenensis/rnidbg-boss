package defpackage;

import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000¨\u0006\u0004"}, d2 = {"", "e", "Lzb4;", "a", "zx-jvm"}, k = 2, mv = {1, 4, 0})
public final class ac4 {
    public static final zb4 a(Throwable th, Throwable th2) {
        if (th instanceof InvocationTargetException) {
            Throwable targetException = ((InvocationTargetException) th).getTargetException();
            Intrinsics.checkExpressionValueIsNotNull(targetException, "targetException");
            return a(targetException, th2);
        }
        String localizedMessage = th.getLocalizedMessage();
        Intrinsics.checkExpressionValueIsNotNull(localizedMessage, "localizedMessage");
        return new zb4(localizedMessage, th, null, 4, null);
    }

    public static /* synthetic */ zb4 b(Throwable th, Throwable th2, int i, Object obj) {
        if ((i & 1) != 0) {
            th2 = null;
        }
        return a(th, th2);
    }
}
