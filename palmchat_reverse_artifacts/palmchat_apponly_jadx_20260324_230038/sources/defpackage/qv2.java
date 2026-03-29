package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class qv2 {
    public static Object a(Context context, String str, Object obj) {
        try {
            return nv2.a(context, str, obj);
        } catch (Throwable th) {
            k63.n("JCommonPresenter", "jcommon call failed:" + th.getMessage());
            return null;
        }
    }
}
