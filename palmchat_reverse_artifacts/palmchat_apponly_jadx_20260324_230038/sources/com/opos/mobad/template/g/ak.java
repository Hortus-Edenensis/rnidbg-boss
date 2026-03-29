package com.opos.mobad.template.g;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ak {
    public static boolean a(com.opos.mobad.template.d.b bVar) {
        try {
            String str = bVar.J.get("EXT_PARAM_KEY_AUTO_PLAY");
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            return Boolean.parseBoolean(str);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("NativeTemplateUtils", "getIsAutoPlay", e);
            return true;
        }
    }
}
