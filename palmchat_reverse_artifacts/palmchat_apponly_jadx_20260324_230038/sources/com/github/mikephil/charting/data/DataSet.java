package com.github.mikephil.charting.data;

import com.github.mikephil.charting.data.Entry;
import defpackage.cq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class DataSet<T extends Entry> extends cq<T> {
    public List<T> r;
    public float s;
    public float t;
    public float u;
    public float v;

    /* JADX INFO: compiled from: SearchBox */
    public enum Rounding {
        UP,
        DOWN,
        CLOSEST
    }

    public DataSet(List<T> list, String str) {
        super(str);
        this.s = -3.4028235E38f;
        this.t = Float.MAX_VALUE;
        this.u = -3.4028235E38f;
        this.v = Float.MAX_VALUE;
        this.r = list;
        if (list == null) {
            this.r = new ArrayList();
        }
        f0();
    }

    @Override // defpackage.kl2
    public T C0(float f, float f2, Rounding rounding) {
        int iB1 = b1(f, f2, rounding);
        if (iB1 > -1) {
            return this.r.get(iB1);
        }
        return null;
    }

    @Override // defpackage.kl2
    public float I() {
        return this.u;
    }

    @Override // defpackage.kl2
    public int K0() {
        return this.r.size();
    }

    @Override // defpackage.kl2
    public float S() {
        return this.s;
    }

    @Override // defpackage.kl2
    public float W() {
        return this.t;
    }

    public void Y0(T t) {
        if (t == null) {
            return;
        }
        Z0(t);
        a1(t);
    }

    public void Z0(T t) {
        if (t.getX() < this.v) {
            this.v = t.getX();
        }
        if (t.getX() > this.u) {
            this.u = t.getX();
        }
    }

    public void a1(T t) {
        if (t.getY() < this.t) {
            this.t = t.getY();
        }
        if (t.getY() > this.s) {
            this.s = t.getY();
        }
    }

    @Override // defpackage.kl2
    public int b(Entry entry) {
        return this.r.indexOf(entry);
    }

    public int b1(float f, float f2, Rounding rounding) {
        int i;
        T t;
        List<T> list = this.r;
        if (list == null || list.isEmpty()) {
            return -1;
        }
        int size = this.r.size() - 1;
        int i2 = 0;
        while (i2 < size) {
            int i3 = (i2 + size) / 2;
            float x = this.r.get(i3).getX() - f;
            int i4 = i3 + 1;
            float x2 = this.r.get(i4).getX() - f;
            float fAbs = Math.abs(x);
            float fAbs2 = Math.abs(x2);
            if (fAbs2 >= fAbs) {
                if (fAbs >= fAbs2) {
                    double d = x;
                    if (d < 0.0d) {
                        if (d < 0.0d) {
                        }
                    }
                }
                size = i3;
            }
            i2 = i4;
        }
        if (size == -1) {
            return size;
        }
        float x3 = this.r.get(size).getX();
        if (rounding == Rounding.UP) {
            if (x3 < f && size < this.r.size() - 1) {
                size++;
            }
        } else if (rounding == Rounding.DOWN && x3 > f && size > 0) {
            size--;
        }
        if (Float.isNaN(f2)) {
            return size;
        }
        while (size > 0 && this.r.get(size - 1).getX() == x3) {
            size--;
        }
        float y = this.r.get(size).getY();
        loop2: while (true) {
            i = size;
            do {
                size++;
                if (size >= this.r.size()) {
                    break loop2;
                }
                t = this.r.get(size);
                if (t.getX() != x3) {
                    break loop2;
                }
            } while (Math.abs(t.getY() - f2) >= Math.abs(y - f2));
            y = f2;
        }
        return i;
    }

    public void c1(List<T> list) {
        this.r = list;
        P0();
    }

    public String d1() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder sb = new StringBuilder();
        sb.append("DataSet, label: ");
        sb.append(getLabel() == null ? "" : getLabel());
        sb.append(", entries: ");
        sb.append(this.r.size());
        sb.append("\n");
        stringBuffer.append(sb.toString());
        return stringBuffer.toString();
    }

    @Override // defpackage.kl2
    public void f0() {
        List<T> list = this.r;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.s = -3.4028235E38f;
        this.t = Float.MAX_VALUE;
        this.u = -3.4028235E38f;
        this.v = Float.MAX_VALUE;
        Iterator<T> it = this.r.iterator();
        while (it.hasNext()) {
            Y0(it.next());
        }
    }

    @Override // defpackage.kl2
    public T h(int i) {
        return this.r.get(i);
    }

    @Override // defpackage.kl2
    public void o(float f, float f2) {
        List<T> list = this.r;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.s = -3.4028235E38f;
        this.t = Float.MAX_VALUE;
        int iB1 = b1(f2, Float.NaN, Rounding.UP);
        for (int iB12 = b1(f, Float.NaN, Rounding.DOWN); iB12 <= iB1; iB12++) {
            a1(this.r.get(iB12));
        }
    }

    @Override // defpackage.kl2
    public T o0(float f, float f2) {
        return (T) C0(f, f2, Rounding.CLOSEST);
    }

    @Override // defpackage.kl2
    public List<T> p(float f) {
        ArrayList arrayList = new ArrayList();
        int size = this.r.size() - 1;
        int i = 0;
        while (true) {
            if (i > size) {
                break;
            }
            int i2 = (size + i) / 2;
            T t = this.r.get(i2);
            if (f == t.getX()) {
                while (i2 > 0 && this.r.get(i2 - 1).getX() == f) {
                    i2--;
                }
                int size2 = this.r.size();
                while (i2 < size2) {
                    T t2 = this.r.get(i2);
                    if (t2.getX() != f) {
                        break;
                    }
                    arrayList.add(t2);
                    i2++;
                }
            } else if (f > t.getX()) {
                i = i2 + 1;
            } else {
                size = i2 - 1;
            }
        }
        return arrayList;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(d1());
        for (int i = 0; i < this.r.size(); i++) {
            stringBuffer.append(this.r.get(i).toString() + " ");
        }
        return stringBuffer.toString();
    }

    @Override // defpackage.kl2
    public float y() {
        return this.v;
    }
}
