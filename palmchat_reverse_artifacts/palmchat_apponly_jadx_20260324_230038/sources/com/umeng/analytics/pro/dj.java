package com.umeng.analytics.pro;

import com.umeng.analytics.pro.da;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class dj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f10932a = Integer.MAX_VALUE;

    public static void a(int i) {
        f10932a = i;
    }

    public static void a(dg dgVar, byte b) throws cn {
        a(dgVar, b, f10932a);
    }

    public static void a(dg dgVar, byte b, int i) throws cn {
        if (i > 0) {
            int i2 = 0;
            switch (b) {
                case 2:
                    dgVar.t();
                    return;
                case 3:
                    dgVar.u();
                    return;
                case 4:
                    dgVar.y();
                    return;
                case 5:
                case 7:
                case 9:
                default:
                    return;
                case 6:
                    dgVar.v();
                    return;
                case 8:
                    dgVar.w();
                    return;
                case 10:
                    dgVar.x();
                    return;
                case 11:
                    dgVar.A();
                    return;
                case 12:
                    dgVar.j();
                    while (true) {
                        byte b2 = dgVar.l().b;
                        if (b2 == 0) {
                            dgVar.k();
                            return;
                        } else {
                            a(dgVar, b2, i - 1);
                            dgVar.m();
                        }
                    }
                    break;
                case 13:
                    dd ddVarN = dgVar.n();
                    while (i2 < ddVarN.c) {
                        int i3 = i - 1;
                        a(dgVar, ddVarN.f10928a, i3);
                        a(dgVar, ddVarN.b, i3);
                        i2++;
                    }
                    dgVar.o();
                    return;
                case 14:
                    dk dkVarR = dgVar.r();
                    while (i2 < dkVarR.b) {
                        a(dgVar, dkVarR.f10933a, i - 1);
                        i2++;
                    }
                    dgVar.s();
                    return;
                case 15:
                    dc dcVarP = dgVar.p();
                    while (i2 < dcVarP.b) {
                        a(dgVar, dcVarP.f10927a, i - 1);
                        i2++;
                    }
                    dgVar.q();
                    return;
            }
        } else {
            throw new cn("Maximum skip depth exceeded");
        }
    }

    public static di a(byte[] bArr, di diVar) {
        if (bArr[0] > 16) {
            return new da.a();
        }
        return (bArr.length <= 1 || (bArr[1] & ByteCompanionObject.MIN_VALUE) == 0) ? diVar : new da.a();
    }
}
