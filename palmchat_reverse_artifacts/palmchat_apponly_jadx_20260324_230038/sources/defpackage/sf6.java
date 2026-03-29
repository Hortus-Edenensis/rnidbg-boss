package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class sf6 extends ArrayList<rf6> {
    public int a(Class<?> cls) {
        int size = size();
        for (int i = 0; i < size; i++) {
            Class<?> cls2 = get(i).f20461a;
            if (cls2 == cls || cls2.isAssignableFrom(cls)) {
                return i;
            }
        }
        return -1;
    }
}
