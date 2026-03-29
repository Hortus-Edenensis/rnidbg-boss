package com.zenmen.palmchat.wallet;

import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class WalletAllowsResp {
    public List<String> allowHosts;
    public List<String> allowMethods;

    public static boolean isAllow(String str, String str2, List<Pattern> list) {
        if (list == null) {
            return true;
        }
        Iterator<Pattern> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().matcher(str2).find()) {
                return true;
            }
        }
        return false;
    }

    public List<Pattern> getAllowsPattern() {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.allowMethods.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(Pattern.compile(it.next()));
            } catch (PatternSyntaxException unused) {
            }
        }
        return arrayList;
    }
}
