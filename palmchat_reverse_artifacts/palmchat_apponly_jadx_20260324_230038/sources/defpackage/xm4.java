package defpackage;

import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.basics.Cert;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0018\u0010\n\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\t¨\u0006\r"}, d2 = {"Lxm4;", "", "Lcom/bytedance/bpea/basics/Cert;", "cert", "Ld00;", "certContext", "Lo50;", "a", "Lc00;", "Lc00;", "certChecker", "<init>", "()V", "common-entry_release"}, k = 1, mv = {1, 4, 0})
public final class xm4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static c00 certChecker;
    public static final xm4 b = new xm4();

    static {
        Object obj;
        try {
            Class<?> cls = Class.forName("com.bytedance.bpea.core.checker.CertCheckerProvider");
            Field getInstance = cls.getDeclaredField("INSTANCE");
            Intrinsics.checkExpressionValueIsNotNull(getInstance, "getInstance");
            getInstance.setAccessible(true);
            Object obj2 = getInstance.get(null);
            Field getChecker = cls.getDeclaredField("CHECKER");
            Intrinsics.checkExpressionValueIsNotNull(getChecker, "getChecker");
            getChecker.setAccessible(true);
            obj = getChecker.get(obj2);
        } catch (Throwable unused) {
        }
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.bytedance.bpea.basics.CertChecker");
        }
        certChecker = (c00) obj;
        if (certChecker != null) {
            jo.f18442a.a("checker working");
        } else {
            jo.f18442a.a("checker not work");
        }
    }

    public final o50 a(Cert cert, d00 certContext) throws BPEAException {
        c00 c00Var = certChecker;
        if (c00Var == null) {
            return null;
        }
        c00Var.a(cert, certContext);
        return null;
    }
}
