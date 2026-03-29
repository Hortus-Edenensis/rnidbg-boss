package com.opos.mobad.o;

import android.text.TextUtils;
import com.zenmen.palmchat.peoplematch.bean.PeopleMatchCardBean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c {
    public static boolean a() {
        return a("quickEngine");
    }

    private static boolean a(String str) {
        try {
            return TextUtils.equals(PeopleMatchCardBean.RECOMMEND_TYPE_NORMAL, str);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("MobadTypeUtils", "checkMobadType() fail", e);
            return false;
        }
    }
}
