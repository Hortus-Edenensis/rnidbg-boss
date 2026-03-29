package defpackage;

import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class yp3 {
    public static Integer[] h = new Integer[64];
    public String c;
    public int d;
    public String e;
    public boolean g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap f22248a = new HashMap();
    public HashMap b = new HashMap();
    public int f = Integer.MAX_VALUE;

    static {
        int i = 0;
        while (true) {
            Integer[] numArr = h;
            if (i >= numArr.length) {
                return;
            }
            numArr[i] = Integer.valueOf(i);
            i++;
        }
    }

    public yp3(String str, int i) {
        this.c = str;
        this.d = i;
    }

    public static Integer g(int i) {
        if (i >= 0) {
            Integer[] numArr = h;
            if (i < numArr.length) {
                return numArr[i];
            }
        }
        return Integer.valueOf(i);
    }

    public void a(int i, String str) {
        b(i);
        Integer numG = g(i);
        String strD = d(str);
        this.f22248a.put(strD, numG);
        this.b.put(numG, strD);
    }

    public void b(int i) {
        if (i < 0 || i > this.f) {
            throw new IllegalArgumentException(this.c + " " + i + "is out of range");
        }
    }

    public String c(int i) {
        b(i);
        String str = (String) this.b.get(g(i));
        if (str != null) {
            return str;
        }
        String string = Integer.toString(i);
        if (this.e == null) {
            return string;
        }
        return this.e + string;
    }

    public final String d(String str) {
        int i = this.d;
        return i == 2 ? str.toUpperCase() : i == 3 ? str.toLowerCase() : str;
    }

    public void e(int i) {
        this.f = i;
    }

    public void f(boolean z) {
        this.g = z;
    }
}
