package a.a.c.a.b;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class a implements Callable<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f1102a;

    public a(b bVar) {
        this.f1102a = bVar;
    }

    @Override // java.util.concurrent.Callable
    public d call() {
        b bVar = this.f1102a;
        bVar.getClass();
        try {
            d dVarA = bVar.b.a();
            if (dVarA != null) {
                bVar.g = dVarA;
            }
            d dVarA2 = bVar.a(bVar.d, dVarA);
            if (dVarA2 != null) {
                e eVar = bVar.b;
                eVar.getClass();
                eVar.f1107a.edit().putString("oaid", dVarA2.a().toString()).apply();
            }
            if (dVarA2 == null) {
                return dVarA2;
            }
            bVar.g = dVarA2;
            return dVarA2;
        } catch (Exception e) {
            d dVar = bVar.g;
            if (dVar != null) {
                dVar.h = e.getMessage();
            }
            e.getMessage();
            return null;
        }
    }
}
