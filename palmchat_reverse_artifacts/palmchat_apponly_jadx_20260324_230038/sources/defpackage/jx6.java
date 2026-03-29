package defpackage;

import android.content.Context;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class jx6 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f18530a;
    public final /* synthetic */ List b;
    public final /* synthetic */ k27 c;

    public jx6(k27 k27Var, Context context, List list) {
        this.c = k27Var;
        this.f18530a = context;
        this.b = list;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.c(this.f18530a, this.b, true);
    }
}
