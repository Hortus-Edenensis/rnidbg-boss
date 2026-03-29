package com.zenmen.media.player;

import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class LogWrapper {
    public static void log(int i, String str, String str2) {
        HashMap map = new HashMap();
        map.put("action", str);
        map.put("detail", str2);
        if (i == 0) {
            LogUtil.i(str, 3, (HashMap<String, Object>) map, (Throwable) null);
            return;
        }
        if (i == 1) {
            LogUtil.d(str, 3, (HashMap<String, Object>) map, (Throwable) null);
            return;
        }
        if (i == 2) {
            LogUtil.e(str, 3, (HashMap<String, Object>) map, (Throwable) null);
            return;
        }
        if (i == 3) {
            LogUtil.w(str, 3, (HashMap<String, Object>) map, (Throwable) null);
        } else if (i != 4) {
            LogUtil.i(str, 3, (HashMap<String, Object>) map, (Throwable) null);
        } else {
            LogUtil.v(str, 3, (HashMap<String, Object>) map, (Throwable) null);
        }
    }
}
