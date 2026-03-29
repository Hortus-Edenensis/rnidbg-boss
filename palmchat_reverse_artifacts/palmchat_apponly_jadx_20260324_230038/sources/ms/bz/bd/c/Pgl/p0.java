package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import java.util.HashMap;
import java.util.Map;
import ms.bz.bd.c.Pgl.pblz;
import ms.bz.bd.c.Pgl.q0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class p0 implements q0.pgla {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f19319a;
    public final Context b;
    public final pblv c;

    public p0(pblv pblvVar, Context context, long j) {
        if (context == null) {
            throw new NullPointerException("context could not be null");
        }
        this.c = pblvVar;
        this.b = context.getApplicationContext();
        this.f19319a = j;
    }

    @Override // ms.bz.bd.c.Pgl.q0.pgla
    public final Map<String, String> a(String str, byte[] bArr) {
        HashMap map = new HashMap();
        if (str != null && str.length() != 0) {
            long j = this.f19319a;
            SparseArray<pblz.pgla> sparseArray = pblz.f19343a;
            String[] strArr = (String[]) com.volcengine.mobsecBiz.matrix.pgla.a(33554438, 0, j, str, bArr);
            if (strArr != null && strArr.length % 2 == 0) {
                for (int i = 0; i < strArr.length; i += 2) {
                    String str2 = strArr[i];
                    String str3 = strArr[i + 1];
                    if (str2 != null && str3 != null) {
                        map.put(str2, str3);
                    }
                }
            }
        }
        return map;
    }

    @Override // ms.bz.bd.c.Pgl.q0.pgla
    public final void b(String str) {
        if (this.f19319a == -1 || TextUtils.isEmpty(str)) {
            return;
        }
        long j = this.f19319a;
        Context context = this.b;
        SparseArray<pblz.pgla> sparseArray = pblz.f19343a;
        com.volcengine.mobsecBiz.matrix.pgla.a(InputDeviceCompat.SOURCE_HDMI, 0, j, str, context);
    }

    @Override // ms.bz.bd.c.Pgl.q0.pgla
    public final void c(String str) {
        this.c.c = str;
        long j = this.f19319a;
        if (j != -1) {
            Context context = this.b;
            SparseArray<pblz.pgla> sparseArray = pblz.f19343a;
            com.volcengine.mobsecBiz.matrix.pgla.a(33554434, 0, j, str, context);
        }
    }
}
