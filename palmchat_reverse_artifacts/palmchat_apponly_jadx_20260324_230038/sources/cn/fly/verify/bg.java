package cn.fly.verify;

import cn.fly.verify.fq;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class bg extends bh {
    public bg() {
        super(dx.a("002Odcdf"), 0L, dx.a("005[dcdfcc*bh"), 86400L, bh.a(dx.a("002Odcdf"), (Long) 0L));
    }

    private void m() {
        fq.a(ax.g()).d().e().n().L().a(new fq.a() { // from class: cn.fly.verify.bg.1
            @Override // cn.fly.verify.fq.a
            public void a(fq.b bVar) {
                int i;
                int iIntValue;
                int i2;
                int i3;
                int i4;
                int i5;
                int i6;
                int i7;
                int iIntValue2;
                HashMap<String, Object> map;
                try {
                    i = Integer.parseInt(bVar.d());
                } catch (Throwable unused) {
                    i = -1;
                }
                if (bVar.n() != null) {
                    HashMap map2 = (HashMap) bVar.n();
                    if (((Integer) fz.a(map2.get(dx.a("016.eibabdPb]ei<dee$dacb1abg]bgcb$c")), -1)).intValue() == 1) {
                        int iIntValue3 = ((Integer) fz.a(map2.get(dx.a("003ebg")), -1)).intValue();
                        int iIntValue4 = ((Integer) fz.a(map2.get(dx.a("003e.cbJc")), -1)).intValue();
                        int iIntValue5 = ((Integer) fz.a(map2.get(dx.a("003Sdcbgba")), -1)).intValue();
                        int iIntValue6 = ((Integer) fz.a(map2.get(dx.a("003,dfbgba")), -1)).intValue();
                        i4 = iIntValue4;
                        i5 = iIntValue5;
                        i6 = iIntValue6;
                        i7 = -1;
                        i2 = -1;
                        i3 = iIntValue3;
                        iIntValue2 = ((Integer) fz.a(map2.get(dx.a("003c bgba")), -1)).intValue();
                        iIntValue = -1;
                    } else {
                        int iIntValue7 = ((Integer) fz.a(map2.get(dx.a("003h dfOa")), -1)).intValue();
                        int iIntValue8 = ((Integer) fz.a(map2.get(dx.a("003eba")), -1)).intValue();
                        iIntValue = ((Integer) fz.a(map2.get(dx.a("004adee")), -1)).intValue();
                        i2 = iIntValue8;
                        i3 = -1;
                        i4 = -1;
                        i5 = -1;
                        i6 = -1;
                        i7 = iIntValue7;
                        iIntValue2 = -1;
                    }
                    if (i == -1 || i2 == -1 || iIntValue == -1) {
                        map = null;
                    } else {
                        map = new HashMap<>();
                        map.put(dx.a("003eba"), Integer.valueOf(i2));
                        map.put(dx.a("004adee"), Integer.valueOf(iIntValue));
                        if (i7 != -1) {
                            map.put(dx.a("003hEdf^a"), Integer.valueOf(i7));
                        }
                    }
                    if (i != -1 && i5 != -1 && i6 != -1 && iIntValue2 != -1) {
                        if (map == null) {
                            map = new HashMap<>();
                        }
                        map.put(dx.a("003Kdcbgba"), Integer.valueOf(i5));
                        map.put(dx.a("003Cdfbgba"), Integer.valueOf(i6));
                        map.put(dx.a("003c$bgba"), Integer.valueOf(iIntValue2));
                        if (i3 != -1) {
                            map.put(dx.a("003ebg"), Integer.valueOf(i3));
                        }
                        if (i4 != -1) {
                            map.put(dx.a("003e<cbEc"), Integer.valueOf(i4));
                        }
                    }
                    if (map != null) {
                        map.put(dx.a("007ab0bhbhbg[d0bh"), Integer.valueOf(i));
                        map.put(dx.a("009RdfbgbdcbAhcb8bdZd"), bVar.e());
                        ArrayList<HashMap<String, Object>> arrayListK = bVar.K();
                        if (arrayListK != null && arrayListK.size() > 0) {
                            map.put(dx.a("006cdb3bhdcbi"), arrayListK);
                        }
                        bg.this.a("BSIOMT", map, true);
                    }
                }
            }
        });
    }

    @Override // cn.fly.verify.bh
    public void a() {
        m();
    }
}
