package defpackage;

import com.amap.api.col.p0002sl.hb;
import com.kuaishou.weapon.p0.t;
import com.umeng.analytics.pro.bd;
import com.zenmen.palmchat.zx.jvm.LOG_LEVEL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b,\u0010-J\u0010\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\b\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\t\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002R\"\u0010\u0012\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017RE\u0010\"\u001a%\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018j\u0004\u0018\u0001`\u001c8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!RE\u0010%\u001a%\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018j\u0004\u0018\u0001`\u001c8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!RE\u0010(\u001a%\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018j\u0004\u0018\u0001`\u001c8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b \u0010\u001d\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!RE\u0010+\u001a%\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0018j\u0004\u0018\u0001`\u001c8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b)\u0010\u001d\u001a\u0004\b*\u0010\u001f\"\u0004\b)\u0010!¨\u0006."}, d2 = {"Ln63;", "", "v", "", t.l, "", "tag", "c", "d", t.f7496a, "Lzb4;", "a", "Lcom/zenmen/palmchat/zx/jvm/LOG_LEVEL;", "Lcom/zenmen/palmchat/zx/jvm/LOG_LEVEL;", "getLevel", "()Lcom/zenmen/palmchat/zx/jvm/LOG_LEVEL;", "i", "(Lcom/zenmen/palmchat/zx/jvm/LOG_LEVEL;)V", "level", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", hb.j, "(Ljava/lang/String;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", bd.b, "Lcom/zenmen/palmchat/zx/jvm/LoggerProcType;", "Lkotlin/jvm/functions/Function1;", "getImpDebug$zx_jvm", "()Lkotlin/jvm/functions/Function1;", "e", "(Lkotlin/jvm/functions/Function1;)V", "impDebug", "getImpInfo$zx_jvm", "g", "impInfo", "getImpWarn$zx_jvm", "h", "impWarn", "f", "getImpFatal$zx_jvm", "impFatal", "<init>", "()V", "zx-jvm"}, k = 1, mv = {1, 4, 0})
public final class n63 {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public static Function1<? super zb4, Unit> impDebug;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public static Function1<? super zb4, Unit> impInfo;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public static Function1<? super zb4, Unit> impWarn;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public static Function1<? super zb4, Unit> impFatal;
    public static final n63 g = new n63();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static LOG_LEVEL level = LOG_LEVEL.INFO;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public static String tag = t63.b();

    public final zb4 a(Object v) {
        zb4 zb4VarB = v instanceof Throwable ? ac4.b((Throwable) v, null, 1, null) : new zb4(String.valueOf(v), null, null, 4, null);
        zb4VarB.g(tag);
        zb4VarB.f(level);
        return zb4VarB;
    }

    public final void b(Object v) {
        LOG_LEVEL log_level = level;
        LOG_LEVEL log_level2 = LOG_LEVEL.DEBUG;
        if (log_level.compareTo(log_level2) > 0) {
            return;
        }
        zb4 zb4VarA = a(v);
        zb4VarA.f(log_level2);
        Function1<? super zb4, Unit> function1 = impDebug;
        if (function1 == null) {
            t63.a(zb4VarA);
            return;
        }
        if (function1 == null) {
            Intrinsics.throwNpe();
        }
        function1.invoke(zb4VarA);
    }

    public final void c(String tag2, Object v) {
        LOG_LEVEL log_level = level;
        LOG_LEVEL log_level2 = LOG_LEVEL.DEBUG;
        if (log_level.compareTo(log_level2) > 0) {
            return;
        }
        zb4 zb4VarA = a(v);
        zb4VarA.f(log_level2);
        zb4VarA.g(zb4VarA.getTag() + '|' + tag2);
        Function1<? super zb4, Unit> function1 = impDebug;
        if (function1 == null) {
            t63.a(zb4VarA);
            return;
        }
        if (function1 == null) {
            Intrinsics.throwNpe();
        }
        function1.invoke(zb4VarA);
    }

    public final void d(Object v) {
        LOG_LEVEL log_level = level;
        LOG_LEVEL log_level2 = LOG_LEVEL.INFO;
        if (log_level.compareTo(log_level2) > 0) {
            return;
        }
        zb4 zb4VarA = a(v);
        zb4VarA.f(log_level2);
        Function1<? super zb4, Unit> function1 = impInfo;
        if (function1 == null) {
            t63.a(zb4VarA);
            return;
        }
        if (function1 == null) {
            Intrinsics.throwNpe();
        }
        function1.invoke(zb4VarA);
    }

    public final void e(Function1<? super zb4, Unit> function1) {
        impDebug = function1;
    }

    public final void f(Function1<? super zb4, Unit> function1) {
        impFatal = function1;
    }

    public final void g(Function1<? super zb4, Unit> function1) {
        impInfo = function1;
    }

    public final void h(Function1<? super zb4, Unit> function1) {
        impWarn = function1;
    }

    public final void i(LOG_LEVEL log_level) {
        level = log_level;
    }

    public final void j(String str) {
        tag = str;
    }

    public final void k(Object v) {
        LOG_LEVEL log_level = level;
        LOG_LEVEL log_level2 = LOG_LEVEL.WARN;
        if (log_level.compareTo(log_level2) > 0) {
            return;
        }
        zb4 zb4VarA = a(v);
        zb4VarA.f(log_level2);
        Function1<? super zb4, Unit> function1 = impWarn;
        if (function1 == null) {
            t63.a(zb4VarA);
            return;
        }
        if (function1 == null) {
            Intrinsics.throwNpe();
        }
        function1.invoke(zb4VarA);
    }
}
