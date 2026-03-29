package com.kwad.sdk.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bpea.entry.common.DataType;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class o {
    public static boolean a(Context context, CharSequence charSequence, CharSequence charSequence2) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(charSequence2)) {
                    ((ClipboardManager) context.getSystemService(DataType.CLIPBOARD)).setPrimaryClip(ClipData.newPlainText(charSequence, charSequence2));
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
