package defpackage;

import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class fs {
    public static boolean a(List list, int i) {
        return !b(list) && i >= 0 && i <= list.size();
    }

    public static boolean b(Collection collection) {
        return collection == null || collection.size() == 0;
    }
}
