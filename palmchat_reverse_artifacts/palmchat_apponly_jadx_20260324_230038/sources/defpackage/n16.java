package defpackage;

import defpackage.vy5;
import java.util.ArrayList;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.b;
import org.jsoup.nodes.f;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public abstract class n16 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b10 f19414a;
    public yy5 b;
    public Document c;
    public ArrayList<f> d;
    public String e;
    public vy5 f;
    public jc4 g;
    public kc4 h;
    public vy5.g i = new vy5.g();
    public vy5.f j = new vy5.f();

    public f a() {
        int size = this.d.size();
        if (size > 0) {
            return this.d.get(size - 1);
        }
        return null;
    }

    public abstract kc4 b();

    public void c(String str, String str2, jc4 jc4Var, kc4 kc4Var) {
        e96.k(str, "String input must not be null");
        e96.k(str2, "BaseURI must not be null");
        this.c = new Document(str2);
        this.h = kc4Var;
        this.f19414a = new b10(str);
        this.g = jc4Var;
        this.b = new yy5(this.f19414a, jc4Var);
        this.d = new ArrayList<>(32);
        this.e = str2;
    }

    public Document d(String str, String str2, jc4 jc4Var, kc4 kc4Var) {
        c(str, str2, jc4Var, kc4Var);
        i();
        return this.c;
    }

    public abstract boolean e(vy5 vy5Var);

    public boolean f(String str) {
        vy5 vy5Var = this.f;
        vy5.f fVar = this.j;
        return vy5Var == fVar ? e(new vy5.f().z(str)) : e(fVar.l().z(str));
    }

    public boolean g(String str) {
        vy5 vy5Var = this.f;
        vy5.g gVar = this.i;
        return vy5Var == gVar ? e(new vy5.g().z(str)) : e(gVar.l().z(str));
    }

    public boolean h(String str, b bVar) {
        vy5 vy5Var = this.f;
        vy5.g gVar = this.i;
        if (vy5Var == gVar) {
            return e(new vy5.g().F(str, bVar));
        }
        gVar.l();
        this.i.F(str, bVar);
        return e(this.i);
    }

    public void i() {
        vy5 vy5VarU;
        do {
            vy5VarU = this.b.u();
            e(vy5VarU);
            vy5VarU.l();
        } while (vy5VarU.f21560a != vy5.i.EOF);
    }
}
