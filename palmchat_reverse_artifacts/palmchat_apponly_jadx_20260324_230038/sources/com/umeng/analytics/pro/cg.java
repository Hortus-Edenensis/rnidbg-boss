package com.umeng.analytics.pro;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class cg extends cn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f10905a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static final int g = 6;
    public static final int h = 7;
    private static final dl j = new dl("TApplicationException");
    private static final db k = new db("message", (byte) 11, 1);
    private static final db l = new db("type", (byte) 8, 2);
    private static final long m = 1;
    protected int i;

    public cg() {
        this.i = 0;
    }

    public int a() {
        return this.i;
    }

    public void b(dg dgVar) throws cn {
        dgVar.a(j);
        if (getMessage() != null) {
            dgVar.a(k);
            dgVar.a(getMessage());
            dgVar.c();
        }
        dgVar.a(l);
        dgVar.a(this.i);
        dgVar.c();
        dgVar.d();
        dgVar.b();
    }

    public static cg a(dg dgVar) throws cn {
        dgVar.j();
        String strZ = null;
        int iW = 0;
        while (true) {
            db dbVarL = dgVar.l();
            byte b2 = dbVarL.b;
            if (b2 == 0) {
                dgVar.k();
                return new cg(iW, strZ);
            }
            short s = dbVarL.c;
            if (s != 1) {
                if (s != 2) {
                    dj.a(dgVar, b2);
                } else if (b2 == 8) {
                    iW = dgVar.w();
                } else {
                    dj.a(dgVar, b2);
                }
            } else if (b2 == 11) {
                strZ = dgVar.z();
            } else {
                dj.a(dgVar, b2);
            }
            dgVar.m();
        }
    }

    public cg(int i) {
        this.i = i;
    }

    public cg(int i, String str) {
        super(str);
        this.i = i;
    }

    public cg(String str) {
        super(str);
        this.i = 0;
    }
}
