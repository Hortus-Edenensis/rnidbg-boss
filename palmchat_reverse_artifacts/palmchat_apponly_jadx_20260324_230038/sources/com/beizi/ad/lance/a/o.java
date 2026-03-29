package com.beizi.ad.lance.a;

import android.content.Context;
import androidx.core.content.ContextCompat;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class o {
    public static boolean a(Context context) {
        return ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.j) == 0 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.i) == 0;
    }
}
