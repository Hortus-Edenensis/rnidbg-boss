package com.opos.mobad.o;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.bytedance.bpea.entry.common.DataType;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {
    public static void a(Context context, String str) {
        try {
            ((ClipboardManager) context.getSystemService(DataType.CLIPBOARD)).setPrimaryClip(ClipData.newPlainText(str, str));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("ClipboardUtils", "clip copy fail", e);
        }
    }
}
