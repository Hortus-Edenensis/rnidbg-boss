package defpackage;

import java.text.DecimalFormat;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class la1 extends h96 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DecimalFormat f18946a;
    public int b;

    public la1(int i) {
        j(i);
    }

    @Override // defpackage.h96
    public String f(float f) {
        return this.f18946a.format(f);
    }

    public void j(int i) {
        this.b = i;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append("0");
        }
        this.f18946a = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }
}
