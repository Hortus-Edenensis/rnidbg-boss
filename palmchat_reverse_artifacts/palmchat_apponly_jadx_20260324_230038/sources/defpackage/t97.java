package defpackage;

import android.text.TextUtils;
import android.util.Log;
import com.oplus.log.core.b;
import com.oplus.log.core.d;
import com.oplus.log.core.e;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class t97 implements i87 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.oplus.log.core.a f20935a = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ve7 {
        public a() {
        }

        @Override // defpackage.ve7
        public final void a(String str, int i) {
            Log.i("NLogWriter", "loganProtocolStatus: " + str + "," + i);
        }
    }

    @Override // defpackage.i87
    public final void a() {
        d dVar;
        try {
            b bVar = this.f20935a.f7566a;
            if (bVar == null) {
                throw new RuntimeException("Please initialize Logan first");
            }
            if (TextUtils.isEmpty(bVar.c) || (dVar = bVar.k) == null) {
                return;
            }
            dVar.d();
        } catch (Exception e) {
            if (k17.k()) {
                e.printStackTrace();
            }
        }
    }

    @Override // defpackage.i87
    public final void b(String str, String str2, byte b, int i) {
        try {
            b bVar = this.f20935a.f7566a;
            if (bVar == null) {
                throw new RuntimeException("Please initialize Logan first");
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            e eVar = new e();
            eVar.f7571a = e.a.f7572a;
            kh7 kh7Var = new kh7();
            String name = Thread.currentThread().getName();
            long id = Thread.currentThread().getId();
            kh7Var.f18691a = str;
            kh7Var.c = str2;
            kh7Var.b = b;
            kh7Var.f = System.currentTimeMillis();
            kh7Var.g = i;
            kh7Var.d = id;
            kh7Var.e = name;
            eVar.c = kh7Var;
            if (bVar.f7567a.size() < bVar.h) {
                bVar.f7567a.add(eVar);
                d dVar = bVar.k;
                if (dVar != null) {
                    dVar.b();
                }
            }
        } catch (Exception e) {
            if (k17.k()) {
                e.printStackTrace();
            }
        }
    }

    @Override // defpackage.i87
    public final void c(f47 f47Var) {
        try {
            com.oplus.log.core.a aVar = new com.oplus.log.core.a();
            this.f20935a = aVar;
            aVar.a(f47Var);
            if (k17.k()) {
                this.f20935a.c(new a());
            }
        } catch (Throwable th) {
            if (k17.k()) {
                th.printStackTrace();
            }
        }
    }

    @Override // defpackage.i87
    public final void a(e.b bVar) {
        try {
            this.f20935a.b(bVar);
        } catch (Exception e) {
            if (k17.k()) {
                e.printStackTrace();
            }
        }
    }
}
