package ms.bz.bd.c.Pgl;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.ss.android.ttvecamera.TELogUtils;
import com.umeng.analytics.pro.dn;
import okio.Utf8;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f19308a;

    public c1(Context context) {
        this.f19308a = context;
    }

    public final String a() {
        Uri uri = Uri.parse((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f85748", new byte[]{116, 53, 72, 87, dn.l, 33, 113, 67, 43, 40, 116, 52, 8, 77, 30, 45, 108, 24, 42, 110, 115, Utf8.REPLACEMENT_BYTE, 72, 87, 2, 59, 124, 86, 109, 99, 114, 52, 82, 74, TELogUtils.DEBUG_LEVEL_V, 54}));
        try {
            int i = Build.VERSION.SDK_INT;
            try {
                ContentProviderClient contentProviderClientAcquireContentProviderClient = this.f19308a.getContentResolver().acquireContentProviderClient(uri);
                Bundle bundleCall = contentProviderClientAcquireContentProviderClient.call((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "89d78c", new byte[]{46, 62, 3, 108, 38, 93, TELogUtils.DEBUG_LEVEL_V}), null, null);
                contentProviderClientAcquireContentProviderClient.release();
                if (bundleCall.getInt((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "59021a", new byte[]{39, 52, 71, 67}), -1) == 0) {
                    return bundleCall.getString((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "9a9f2f", new byte[]{33, 103}));
                }
                bundleCall.getString((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5d8064", new byte[]{41, 99, 88, 87, 8, 36, 51}));
                return null;
            } catch (Exception unused) {
                return null;
            }
        } catch (Exception unused2) {
        }
    }
}
