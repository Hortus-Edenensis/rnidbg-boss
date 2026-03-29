package com.zenmen.palmchat.maintab.msgTopEntrance;

import androidx.annotation.Keep;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class LocalSavedConfig {
    public List<FuncItem> currentConfig;
    public String originConfig;

    private Set<String> build(List<FuncItem> list) {
        HashSet hashSet = new HashSet();
        Iterator<FuncItem> it = list.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().source);
        }
        return hashSet;
    }

    public boolean canUse(List<FuncItem> list) {
        List<FuncItem> list2 = this.currentConfig;
        if (list2 == null || list == null) {
            return false;
        }
        return build(list2).equals(build(list));
    }
}
