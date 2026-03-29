package com.amap.api.col.p0002sl;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.amap.api.maps2d.AMapException;
import com.amap.api.maps2d.model.TileProvider;
import com.efs.sdk.base.Constants;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class cf extends bs<ArrayList<cb>, ArrayList<cb>> {
    private aw c;
    private TileProvider d;

    public cf(ArrayList<cb> arrayList, TileProvider tileProvider) {
        super(arrayList);
        this.c = null;
        this.d = tileProvider;
        a(gc.a(ba.f2628a));
        a(5000);
        b(50000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0002sl.bs
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public ArrayList<cb> a_() {
        ArrayList<cb> arrayList = new ArrayList<>();
        Iterator it = ((ArrayList) ((bs) this).b).iterator();
        while (it.hasNext()) {
            arrayList.add(new cb((cb) it.next()));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0002sl.bs
    public final byte[] b() throws AMapException {
        TileProvider tileProvider = this.d;
        return tileProvider != null ? tileProvider.getTile(((cb) ((ArrayList) ((bs) this).b).get(0)).b, ((cb) ((ArrayList) ((bs) this).b).get(0)).c, ((cb) ((ArrayList) ((bs) this).b).get(0)).d).data : super.b();
    }

    @Override // com.amap.api.col.p0002sl.id
    public final Map<String, String> d() {
        HashMap map = new HashMap();
        map.put("User-Agent", "AMAP_SDK_Android_2DMap_6.0.0");
        map.put(HttpHeaders.ACCEPT_ENCODING, Constants.CP_GZIP);
        map.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", "6.0.0", "2dmap"));
        map.put("X-INFO", fu.a(ba.f2628a));
        map.put("key", fr.f(ba.f2628a));
        map.put("logversion", "2.1");
        return map;
    }

    @Override // com.amap.api.col.p0002sl.id
    public final Map<String, String> e() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0002sl.id
    public final String f() {
        int i = ((cb) ((ArrayList) ((bs) this).b).get(0)).b;
        int i2 = ((cb) ((ArrayList) ((bs) this).b).get(0)).c;
        int i3 = ((cb) ((ArrayList) ((bs) this).b).get(0)).d;
        if (z.i == 0 && i3 > 9 && !cs.a(i, i2, i3)) {
            Locale locale = Locale.US;
            bg.a();
            return String.format(locale, bg.d(), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i2));
        }
        int iPow = (int) Math.pow(2.0d, ((cb) ((ArrayList) ((bs) this).b).get(0)).d);
        int i4 = ((cb) ((ArrayList) ((bs) this).b).get(0)).b;
        if (i4 >= iPow) {
            i4 -= iPow;
        } else if (i4 < 0) {
            i4 += iPow;
        }
        String strA = this.c.j.a(i4, i2, i3);
        if (TextUtils.isEmpty(z.h)) {
            strA = strA + a(strA);
        }
        ((cb) ((ArrayList) ((bs) this).b).get(0)).a();
        return strA;
    }

    public final void a(aw awVar) {
        this.c = awVar;
    }

    private int a(byte[] bArr, cb cbVar) {
        aw awVar;
        bj bjVar;
        ad adVar;
        int i = -1;
        if (cbVar == null || bArr == null || (awVar = this.c) == null || (bjVar = awVar.n) == null) {
            return -1;
        }
        try {
            int iA = bjVar.a(null, bArr, false, cbVar.b());
            if (iA < 0) {
                return -1;
            }
            try {
                a(cbVar, iA);
                aw awVar2 = this.c;
                if (awVar2 == null || !awVar2.f) {
                    return iA;
                }
                byte[] bArrA = a(awVar2.n.a(iA));
                aw awVar3 = this.c;
                if (awVar3 == null || (adVar = awVar3.o) == null) {
                    return iA;
                }
                adVar.a(bArrA, cbVar);
                return iA;
            } catch (Throwable th) {
                th = th;
                i = iA;
                ct.a(th, "TileServerHandler", "saveImgToMemory");
                return i;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.p0002sl.bs
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ArrayList<cb> a(byte[] bArr) throws AMapException {
        int i;
        T t = ((bs) this).b;
        ArrayList<cb> arrayList = null;
        if (t != 0 && bArr != null) {
            try {
                int size = ((ArrayList) t).size();
                for (int i2 = 0; i2 < size; i2++) {
                    cb cbVar = (cb) ((ArrayList) ((bs) this).b).get(i2);
                    if (a(bArr, cbVar) < 0) {
                        if (arrayList == null) {
                            arrayList = new ArrayList<>();
                        }
                        cb cbVar2 = new cb(cbVar);
                        if (this.c.h && (i = cbVar2.d) > 9 && !cs.a(cbVar2.b, cbVar2.c, i)) {
                            cbVar2.i = true;
                        }
                        arrayList.add(cbVar2);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }

    private static byte[] a(Bitmap bitmap) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            ct.a(th, "TileServerHandler", "Bitmap2Bytes");
            return null;
        }
    }

    private void a(cb cbVar, int i) {
        aw awVar;
        bw<cb> bwVar;
        cb cbVar2;
        if (cbVar == null || i < 0 || (awVar = this.c) == null || (bwVar = awVar.p) == null) {
            return;
        }
        synchronized (awVar) {
            int size = bwVar.size();
            int i2 = 0;
            while (true) {
                if (i2 < size) {
                    if (i2 < bwVar.size() && (cbVar2 = bwVar.get(i2)) != null && cbVar2.equals(cbVar)) {
                        cbVar2.h = i;
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
        }
    }

    private static String a(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(str) && !str.startsWith(bg.a().c())) {
            stringBuffer.append("&key=");
            stringBuffer.append(fr.f(ba.f2628a));
        }
        stringBuffer.append("&channel=amapapi");
        return stringBuffer.toString();
    }
}
