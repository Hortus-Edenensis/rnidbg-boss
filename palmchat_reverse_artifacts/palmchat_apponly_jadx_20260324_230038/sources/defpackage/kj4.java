package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.e0;
import com.google.android.exoplayer2.source.i;
import defpackage.oc;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface kj4 {

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void Z(oc.a aVar, String str);

        void b0(oc.a aVar, String str, boolean z);

        void f(oc.a aVar, String str);

        void i(oc.a aVar, String str, String str2);
    }

    void a(oc.a aVar);

    void b(oc.a aVar, int i);

    void c(oc.a aVar);

    void d(oc.a aVar);

    String e(e0 e0Var, i.b bVar);

    void f(a aVar);

    @Nullable
    String getActiveSessionId();
}
