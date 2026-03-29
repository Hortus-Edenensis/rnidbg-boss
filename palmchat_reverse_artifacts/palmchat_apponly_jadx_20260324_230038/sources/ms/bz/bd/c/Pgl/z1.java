package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.ss.android.ttvecamera.TELogUtils;
import kotlin.jvm.internal.ByteCompanionObject;
import okio.Utf8;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f19355a;

    public z1(Context context) {
        this.f19355a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005e A[EXC_TOP_SPLITTER, PHI: r1
      0x005e: PHI (r1v6 java.lang.String) = (r1v2 java.lang.String), (r1v8 java.lang.String) binds: [B:9:0x0053, B:15:0x0067] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String a() {
        Cursor cursorQuery = this.f19355a.getContentResolver().query(Uri.parse((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "394ff5", new byte[]{33, 52, 73, 6, 92, 44, 36, 66, 42, 121, 33, 52, 74, 92, 79, 43, 38, 23, 43, 32, 47, 40, 9, 59, 93, 18, 34, 23, 115, Utf8.REPLACEMENT_BYTE, 38, 62, 85, 93, 112, 38, 53, 22, 113, Utf8.REPLACEMENT_BYTE, 36, 50, 66, 0, 112, 38, ByteCompanionObject.MAX_VALUE, 55, 68, TELogUtils.DEBUG_LEVEL_V, 6})), null, null, null, null);
        String string = null;
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToNext()) {
                    string = cursorQuery.getString(cursorQuery.getColumnIndex((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "10dc69", new byte[]{54, 51, 27, 2, 12})));
                }
            } finally {
                try {
                } finally {
                    try {
                        cursorQuery.close();
                    } catch (Throwable unused) {
                    }
                }
            }
            if (cursorQuery != null) {
            }
        } else if (cursorQuery != null) {
        }
        return string;
    }
}
