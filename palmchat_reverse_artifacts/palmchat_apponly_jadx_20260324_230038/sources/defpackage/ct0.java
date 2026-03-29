package defpackage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ct0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16909a;
    public int b;
    public String c;
    public String d;
    public String e;
    public String f;
    public int g;
    public boolean h;
    public boolean i;
    public boolean j;
    public String k;
    public String l;
    public String m;
    public String n;
    public List<bt0> o;
    public final List<gt0> p = new ArrayList();
    public il2 q;
    public File r;

    public synchronized void a(gt0 gt0Var) {
        this.p.add(gt0Var);
    }

    public synchronized void b(gt0 gt0Var) {
        this.p.remove(gt0Var);
    }
}
