package defpackage;

import defpackage.pl5;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class k73 extends pl5 implements Serializable, i73 {
    private static final long serialVersionUID = 7249069246863182397L;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.c = 0;
        this.f20048a = null;
        this.b = objectInputStream.readLong();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(b());
    }

    @Override // defpackage.i73
    public long b() {
        long j = this.b;
        pl5.b[] bVarArr = this.f20048a;
        if (bVarArr != null) {
            for (pl5.b bVar : bVarArr) {
                if (bVar != null) {
                    j += bVar.f20049a;
                }
            }
        }
        return j;
    }

    @Override // defpackage.i73
    public void c(long j) {
        int length;
        pl5.b bVar;
        pl5.b[] bVarArr = this.f20048a;
        if (bVarArr == null) {
            long j2 = this.b;
            if (q(j2, j2 + j)) {
                return;
            }
        }
        int[] iArr = pl5.d.get();
        boolean zA = true;
        if (iArr != null && bVarArr != null && (length = bVarArr.length) >= 1 && (bVar = bVarArr[(length - 1) & iArr[0]]) != null) {
            long j3 = bVar.f20049a;
            zA = bVar.a(j3, j3 + j);
            if (zA) {
                return;
            }
        }
        v(j, iArr, zA);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return b();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return b();
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) b();
    }

    @Override // java.lang.Number
    public long longValue() {
        return b();
    }

    @Override // defpackage.i73
    public void o() {
        c(1L);
    }

    @Override // defpackage.pl5
    public final long t(long j, long j2) {
        return j + j2;
    }

    public String toString() {
        return Long.toString(b());
    }
}
