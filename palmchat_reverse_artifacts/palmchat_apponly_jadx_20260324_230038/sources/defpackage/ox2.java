package defpackage;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ox2 {
    public static List<rx2> a(String str, String str2, String str3, int i) {
        List<rx2> arrayList;
        rx2 rx2Var = new rx2();
        rx2Var.f20619a = str2;
        rx2Var.b = str3;
        if (str == null || TextUtils.isEmpty(str)) {
            arrayList = null;
        } else {
            arrayList = mx2.f(str);
            p63.a("JWakePackageHelper", "cache cmd wakeTargets:" + arrayList);
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size() - 1;
            while (true) {
                if (size >= 0) {
                    if (arrayList.get(size).f20619a.equals(str2) && arrayList.get(size).b.equals(str3)) {
                        arrayList.remove(size);
                        break;
                    }
                    size--;
                } else {
                    break;
                }
            }
        }
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        if (i == 1) {
            arrayList.add(rx2Var);
        }
        return arrayList;
    }
}
