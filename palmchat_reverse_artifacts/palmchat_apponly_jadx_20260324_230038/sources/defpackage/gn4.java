package defpackage;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR(\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lgn4;", "", "Lno4;", "", "a", "Lno4;", "()Lno4;", "setIS_FOREGROUNDING", "(Lno4;)V", "IS_FOREGROUNDING", "<init>", "()V", "zx-core_release"}, k = 1, mv = {1, 4, 0})
public final class gn4 {
    public static final gn4 b = new gn4();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static no4<Boolean> IS_FOREGROUNDING = new no4<>(Boolean.TRUE, a.b);

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lno4;", "", "", "a", "(Lno4;)V"}, k = 3, mv = {1, 4, 0})
    public static final class a extends Lambda implements Function1<no4<Boolean>, Unit> {
        public static final a b = new a();

        public a() {
            super(1);
        }

        public final void a(no4<Boolean> no4Var) {
            if (no4Var.a().booleanValue()) {
                n63.g.d("切换到前台");
            } else {
                n63.g.d("切换到后台");
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(no4<Boolean> no4Var) {
            a(no4Var);
            return Unit.INSTANCE;
        }
    }

    public final no4<Boolean> a() {
        return IS_FOREGROUNDING;
    }
}
