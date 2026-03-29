package defpackage;

import android.content.Context;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class m87 implements k47 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k47 f19163a;

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static m87 f19164a = new m87();
    }

    public m87() {
    }

    public static m87 b() {
        return b.f19164a;
    }

    @Override // defpackage.k47
    public void a(@NonNull Context context, @NonNull u17 u17Var) {
        c(context);
        this.f19163a.a(context, u17Var);
    }

    public final void c(Context context) {
        if (this.f19163a != null) {
            return;
        }
        this.f19163a = fc7.a(context) ? new v17() : new ka7();
    }
}
