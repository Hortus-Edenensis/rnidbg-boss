package com.xiaomi.push;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class id {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f11646a = Integer.MAX_VALUE;

    public static void a(ia iaVar, byte b) {
        a(iaVar, b, f11646a);
    }

    public static void a(ia iaVar, byte b, int i) throws hu {
        if (i <= 0) {
            throw new hu("Maximum skip depth exceeded");
        }
        int i2 = 0;
        switch (b) {
            case 2:
                iaVar.mo637a();
                return;
            case 3:
                iaVar.a();
                return;
            case 4:
                iaVar.mo624a();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                iaVar.mo634a();
                return;
            case 8:
                iaVar.mo625a();
                return;
            case 10:
                iaVar.mo626a();
                return;
            case 11:
                iaVar.mo633a();
                return;
            case 12:
                iaVar.mo631a();
                while (true) {
                    byte b2 = iaVar.mo627a().f11640a;
                    if (b2 == 0) {
                        iaVar.f();
                        return;
                    } else {
                        a(iaVar, b2, i - 1);
                        iaVar.g();
                    }
                }
                break;
            case 13:
                hz hzVarMo629a = iaVar.mo629a();
                while (i2 < hzVarMo629a.f838a) {
                    int i3 = i - 1;
                    a(iaVar, hzVarMo629a.f11642a, i3);
                    a(iaVar, hzVarMo629a.b, i3);
                    i2++;
                }
                iaVar.h();
                return;
            case 14:
                ie ieVarMo630a = iaVar.mo630a();
                while (i2 < ieVarMo630a.f842a) {
                    a(iaVar, ieVarMo630a.f11647a, i - 1);
                    i2++;
                }
                iaVar.j();
                return;
            case 15:
                hy hyVarMo628a = iaVar.mo628a();
                while (i2 < hyVarMo628a.f837a) {
                    a(iaVar, hyVarMo628a.f11641a, i - 1);
                    i2++;
                }
                iaVar.i();
                return;
        }
    }
}
