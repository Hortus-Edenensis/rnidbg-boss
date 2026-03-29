package com.zenmen.palmchat.crash;

import android.text.TextUtils;
import androidx.annotation.Keep;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class CrashWhiteListConfig {
    public boolean enable;
    public List<WhiteListItem> whitelist;

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class WhiteListItem {
        public List<String> flags;
        public String tag;

        public String match(String str) {
            boolean z;
            List<String> list = this.flags;
            if (list != null && list.size() > 0) {
                Iterator<String> it = this.flags.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    if (!str.contains(it.next())) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    return this.tag;
                }
            }
            return null;
        }
    }

    public String match(String str) {
        List<WhiteListItem> list = this.whitelist;
        if (list != null && list.size() > 0 && str != null) {
            Iterator<WhiteListItem> it = this.whitelist.iterator();
            while (it.hasNext()) {
                String strMatch = it.next().match(str);
                if (!TextUtils.isEmpty(strMatch)) {
                    return strMatch;
                }
            }
        }
        return null;
    }
}
