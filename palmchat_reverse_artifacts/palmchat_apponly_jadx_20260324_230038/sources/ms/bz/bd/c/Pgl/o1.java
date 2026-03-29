package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.ss.android.ttvecamera.TELogUtils;
import com.umeng.analytics.pro.dn;
import java.util.ArrayList;
import java.util.List;
import okio.Utf8;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class o1 {
    public static o1 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f19318a;
    public ArrayList b = new ArrayList();

    public o1(Context context) {
        this.f19318a = null;
        this.f19318a = context;
    }

    public static o1 f(Context context) {
        if (c == null) {
            synchronized (o1.class) {
                if (c == null) {
                    c = new o1(context);
                }
            }
        }
        return c;
    }

    public final void a() {
        byte b;
        int i;
        int iB;
        int iE;
        try {
            b = pble.c() != null ? (byte) 1 : (byte) 0;
        } catch (Throwable unused) {
            b = -1;
        }
        if (b != 1) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e0dead", new byte[]{119, 58, 18, 18, 85, 51, 96, 20, 33, 54, 124, 16, 22, 5, 74, 118, 116, 8, 6, 33, 117, 38, 2, 2, 109, 103, 116, 24, 59, 50, 52, 59, 25, 81, 92, 114, 101, 26, 50, 39, 123, 39, 25, 21});
            return;
        }
        try {
            synchronized (this) {
                iB = b();
                iE = e();
            }
            i = (iB * 10000) + iE;
        } catch (Exception unused2) {
            i = -10001;
        }
        Integer numValueOf = Integer.valueOf(i);
        if (numValueOf == null) {
            return;
        }
        this.b.add(numValueOf);
        try {
            int size = this.b.size();
            if (size > 20) {
                ArrayList arrayList = new ArrayList(this.b.subList(size - 10, size));
                this.b.clear();
                this.b = arrayList;
            }
        } catch (Throwable unused3) {
        }
    }

    public final int b() {
        Intent intentRegisterReceiver = this.f19318a.registerReceiver(null, new IntentFilter((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "48312d", new byte[]{36, 52, 68, 87, 2, 122, 51, 87, 107, 111, 49, Utf8.REPLACEMENT_BYTE, 78, 81, 67, 114, 52, dn.k, 107, 110, 43, 116, 98, 100, 57, 71, 18, 43, 91, 94, 6, 18, 97, 107, 42, 86, 19})));
        if (intentRegisterReceiver == null) {
            return -1;
        }
        return intentRegisterReceiver.getIntExtra((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fbe7de", new byte[]{103, 108, 3, 68, 92, 119, 97}), -1);
    }

    public final int c() {
        Intent intentRegisterReceiver = this.f19318a.registerReceiver(null, new IntentFilter((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "bf23bd", new byte[]{114, 106, 69, 85, 82, 122, 101, 9, 106, 109, 103, 97, 79, 83, 19, 114, 98, 83, 106, 108, 125, 42, 99, 102, 105, 71, 68, 117, 90, 92, 80, 76, 96, 105, 122, 86, 69})));
        if (intentRegisterReceiver == null) {
            return -1;
        }
        int intExtra = intentRegisterReceiver.getIntExtra((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "273b56", new byte[]{48, 33, 65, 2, TELogUtils.DEBUG_LEVEL_V, 50}), -1);
        return (intExtra == 2 || intExtra == 5) ? 1 : 0;
    }

    public final synchronized int[] d() {
        int size = this.b.size();
        if (size <= 0) {
            return new int[0];
        }
        if (size == 1) {
            return new int[]{((Integer) this.b.get(0)).intValue()};
        }
        try {
            ArrayList arrayList = this.b;
            int i = size - 10;
            if (i <= 0) {
                i = 0;
            }
            List listSubList = arrayList.subList(i, size);
            int[] iArr = new int[listSubList.size()];
            for (int i2 = 0; i2 < listSubList.size(); i2++) {
                iArr[i2] = ((Integer) listSubList.get(i2)).intValue();
            }
            return iArr;
        } catch (Throwable unused) {
            return new int[0];
        }
    }

    public final int e() {
        if (this.f19318a.registerReceiver(null, new IntentFilter((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5f83e2", new byte[]{37, 106, 79, 85, 85, 44, 50, 9, 96, 109, 48, 97, 69, 83, 20, 36, 53, 83, 96, 108, 42, 42, 105, 102, 110, 17, 19, 117, 80, 92, 7, 76, 106, 105, 125, 0, 18}))) == null) {
            return -1;
        }
        return Math.round(((r0.getIntExtra((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0d702a", new byte[]{45, 99, 82, 65, 1}), -1) / r0.getIntExtra((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "19a0e1", new byte[]{51, 56, 19, 72, 95}), -1)) * 100.0f) * 10.0f) / 10;
    }
}
