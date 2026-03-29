package defpackage;

import android.app.Application;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0007\"\"\u0010\u0006\u001a\u00020\u00008\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0001\u0010\u0003\"\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Landroid/app/Application;", "a", "Landroid/app/Application;", "()Landroid/app/Application;", t.l, "(Landroid/app/Application;)V", "__shared", "zx-core_release"}, k = 2, mv = {1, 4, 0})
public final class hh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Application f17956a;

    public static final Application a() {
        Application application = f17956a;
        if (application == null) {
            Intrinsics.throwUninitializedPropertyAccessException("__shared");
        }
        return application;
    }

    public static final void b(Application application) {
        f17956a = application;
    }
}
