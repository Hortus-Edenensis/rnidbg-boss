package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.huawei.hms.ads.fh;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class o {
    private static final String B = "ProviderUtil";
    private static final String C = "result";
    public static final String Code = "com.huawei.hms.contentprovider";
    public static final String I = "dc_shared";
    private static final int S = -1;
    public static final String V = "com.huawei.hms.ads.dc.shared";
    public static final String Z = "content://com.huawei.hms.contentprovider/com.huawei.hms.ads.dc.shared/dc_shared";

    public static int Code(Context context) {
        if (context == null) {
            return -1;
        }
        Cursor cursorV = null;
        try {
            cursorV = z.V(context, Uri.parse(Z));
            if (cursorV != null && cursorV.moveToFirst()) {
                fh.V(B, "cursor is valid");
                return cursorV.getInt(cursorV.getColumnIndexOrThrow("result"));
            }
        } finally {
            try {
            } finally {
            }
        }
        return -1;
    }
}
