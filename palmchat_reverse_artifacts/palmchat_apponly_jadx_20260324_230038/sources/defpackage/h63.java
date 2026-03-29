package defpackage;

import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0018\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0018\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ \u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n¨\u0006\u0010"}, d2 = {"Lh63;", "", "", "tag", "msg", "", "e", "a", "f", t.l, "", "error", "d", "c", "<init>", "()V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public final class h63 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h63 f17877a = new h63();

    public final void a(String tag, String msg) {
        sm2 sm2VarA;
        b15 b15Var = b15.c;
        if (b15Var.b() && (sm2VarA = b15Var.a()) != null) {
            sm2VarA.debug(tag, msg);
        }
    }

    public final void b(String tag, String msg) {
        sm2 sm2VarA;
        b15 b15Var = b15.c;
        if (b15Var.b() && (sm2VarA = b15Var.a()) != null) {
            sm2VarA.a(tag, msg, null);
        }
    }

    public final void c(String tag, String msg, Throwable error) {
        sm2 sm2VarA;
        b15 b15Var = b15.c;
        if (b15Var.b() && (sm2VarA = b15Var.a()) != null) {
            sm2VarA.a(tag, msg, error);
        }
    }

    public final void d(String tag, Throwable error) {
        sm2 sm2VarA;
        b15 b15Var = b15.c;
        if (b15Var.b() && (sm2VarA = b15Var.a()) != null) {
            sm2VarA.a(tag, error.getMessage(), error);
        }
    }

    public final void e(String tag, String msg) {
        sm2 sm2VarA;
        b15 b15Var = b15.c;
        if (b15Var.b() && (sm2VarA = b15Var.a()) != null) {
            sm2VarA.info(tag, msg);
        }
    }

    public final void f(String tag, String msg) {
        sm2 sm2VarA;
        b15 b15Var = b15.c;
        if (b15Var.b() && (sm2VarA = b15Var.a()) != null) {
            sm2VarA.b(tag, msg);
        }
    }
}
