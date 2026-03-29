package com.bytedance.adsdk.lottie.pn;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class nr {
    private static final String nr;
    private static final String u;

    /* JADX INFO: compiled from: SearchBox */
    public interface u<T> {
        void u(T t);
    }

    static {
        StringBuilder sb = new StringBuilder("tt_derive");
        String str = File.separator;
        sb.append(str);
        sb.append("lottie");
        sb.append(str);
        sb.append("anim_img");
        u = sb.toString();
        nr = "tt_derive" + str + "lottie" + str + "anim_video";
    }

    public static String nr(Context context) {
        return com.bytedance.sdk.component.utils.n.u(context, com.bytedance.sdk.component.adexpress.u.u.u.u().fx().l(), nr).getAbsolutePath();
    }

    public static String u(Context context) {
        return com.bytedance.sdk.component.utils.n.u(context, com.bytedance.sdk.component.adexpress.u.u.u.u().fx().l(), u).getAbsolutePath();
    }

    public static void u(String str, Context context, final u<File> uVar) {
        com.bytedance.sdk.component.a.nr.nr nrVarB;
        if (context == null || TextUtils.isEmpty(str) || (nrVarB = com.bytedance.sdk.component.adexpress.u.u.u.u().fx().b()) == null) {
            return;
        }
        final String strU = u(context);
        final String strNr = com.bytedance.sdk.component.utils.x.nr(str);
        nrVarB.u(str);
        nrVarB.u(strU, strNr);
        nrVarB.u(new com.bytedance.sdk.component.a.u.u() { // from class: com.bytedance.adsdk.lottie.pn.nr.1
            @Override // com.bytedance.sdk.component.a.u.u
            public void u(com.bytedance.sdk.component.a.nr.b bVar, com.bytedance.sdk.component.a.nr nrVar) {
                if (uVar != null) {
                    File file = new File(strU, strNr);
                    if (file.exists()) {
                        uVar.u(file);
                    }
                }
            }

            @Override // com.bytedance.sdk.component.a.u.u
            public void u(com.bytedance.sdk.component.a.nr.b bVar, IOException iOException) {
                if (uVar != null) {
                    iOException.getMessage();
                }
            }
        });
    }
}
