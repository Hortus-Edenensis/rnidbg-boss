package defpackage;

import java.text.DecimalFormat;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class t31 extends h96 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DecimalFormat f20889a;
    public int b;

    public t31(int i) {
        this.b = i;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append("0");
        }
        this.f20889a = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }

    @Override // defpackage.h96
    public String f(float f) {
        return this.f20889a.format(f);
    }

    public int j() {
        return this.b;
    }
}
