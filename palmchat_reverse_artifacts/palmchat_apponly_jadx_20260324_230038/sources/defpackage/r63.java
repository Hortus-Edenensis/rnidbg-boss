package defpackage;

import android.util.Log;
import android.widget.Toast;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.zenmen.palmchat.zx.core.Application;
import com.zenmen.palmchat.zx.jvm.DATETIME_FORMAT;
import com.zenmen.palmchat.zx.jvm.LOG_LEVEL;
import defpackage.q63;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\"\u0016\u0010\u0007\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0001\u0010\u0006¨\u0006\b"}, d2 = {"", "a", "", "msg", t.l, "", "Z", "__logger_attached", "zx-core_release"}, k = 2, mv = {1, 4, 0})
public final class r63 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f20398a;

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lzb4;", o.f, "", "a", "(Lzb4;)V"}, k = 3, mv = {1, 4, 0})
    public static final class a extends Lambda implements Function1<zb4, Unit> {
        public static final a b = new a();

        public a() {
            super(1);
        }

        public final void a(zb4 zb4Var) {
            Log.d(zb4Var.getTag(), '[' + zb4Var.getTime().a(DATETIME_FORMAT.LOG) + "] " + zb4Var.getMessage());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(zb4 zb4Var) {
            a(zb4Var);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lzb4;", o.f, "", "a", "(Lzb4;)V"}, k = 3, mv = {1, 4, 0})
    public static final class b extends Lambda implements Function1<zb4, Unit> {
        public static final b b = new b();

        public b() {
            super(1);
        }

        public final void a(zb4 zb4Var) {
            Log.i(zb4Var.getTag(), '[' + zb4Var.getTime().a(DATETIME_FORMAT.LOG) + "] " + zb4Var.getMessage());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(zb4 zb4Var) {
            a(zb4Var);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lzb4;", o.f, "", "a", "(Lzb4;)V"}, k = 3, mv = {1, 4, 0})
    public static final class c extends Lambda implements Function1<zb4, Unit> {
        public static final c b = new c();

        public c() {
            super(1);
        }

        public final void a(zb4 zb4Var) {
            Log.w(zb4Var.getTag(), '[' + zb4Var.getTime().a(DATETIME_FORMAT.LOG) + "] " + zb4Var.getMessage());
            Throwable exception = zb4Var.getException();
            if (exception != null) {
                exception.printStackTrace();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(zb4 zb4Var) {
            a(zb4Var);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lzb4;", o.f, "", "a", "(Lzb4;)V"}, k = 3, mv = {1, 4, 0})
    public static final class d extends Lambda implements Function1<zb4, Unit> {
        public static final d b = new d();

        public d() {
            super(1);
        }

        public final void a(zb4 zb4Var) {
            Log.e(zb4Var.getTag(), '[' + zb4Var.getTime().a(DATETIME_FORMAT.LOG) + "] " + zb4Var.getMessage());
            if (ol0.e.b()) {
                r63.b(zb4Var.getMessage());
            }
            Throwable exception = zb4Var.getException();
            if (exception != null) {
                exception.printStackTrace();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(zb4 zb4Var) {
            a(zb4Var);
            return Unit.INSTANCE;
        }
    }

    public static final void a() {
        if (f20398a) {
            return;
        }
        f20398a = true;
        ol0 ol0Var = ol0.e;
        if (ol0Var.b()) {
            n63.g.i(LOG_LEVEL.DEBUG);
        } else {
            n63.g.i(LOG_LEVEL.FATAL);
        }
        n63.g.j("Zx" + StringsKt__StringsJVMKt.capitalize(ol0Var.a()));
        q63.Companion aVar = q63.INSTANCE;
        aVar.a(a.b);
        aVar.c(b.b);
        aVar.d(c.b);
        aVar.b(d.b);
    }

    public static final void b(String str) {
        if (ol0.e.c()) {
            return;
        }
        Toast.makeText(Application.INSTANCE.b(), str, str.length() > 32 ? 1 : 0).show();
    }
}
