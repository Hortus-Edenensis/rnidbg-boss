package com.lantern.auth.onekey;

import android.content.Context;
import com.lantern.auth.onekey.helper.CMHelper;
import com.lantern.auth.onekey.helper.CTHelper;
import com.lantern.auth.onekey.helper.CUHelper;
import com.lantern.auth.onekey.helper.MobHelper;
import com.lantern.auth.onekey.helper.OneKeyHelper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class HelperFactory {
    private static CMHelper cmHelper;
    private static CTHelper ctHelper;
    private static CUHelper cuHelper;
    private static MobHelper mobHelper;

    public static synchronized OneKeyHelper createHelper(int i, Context context) {
        if (i == 1) {
            if (cmHelper == null) {
                cmHelper = new CMHelper(context);
            }
            return cmHelper;
        }
        if (i == 4) {
            if (cuHelper == null) {
                cuHelper = new CUHelper(context);
            }
            return cuHelper;
        }
        if (i != 8) {
            if (mobHelper == null) {
                mobHelper = new MobHelper(context);
            }
            return mobHelper;
        }
        if (ctHelper == null) {
            ctHelper = new CTHelper(context);
        }
        return ctHelper;
    }
}
