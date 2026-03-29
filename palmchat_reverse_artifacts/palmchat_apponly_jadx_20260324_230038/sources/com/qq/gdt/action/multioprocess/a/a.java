package com.qq.gdt.action.multioprocess.a;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f10544a;
    private List<b> b = new ArrayList();

    public static a a() {
        if (f10544a == null) {
            synchronized (a.class) {
                if (f10544a == null) {
                    f10544a = new a();
                    f10544a.a(new c());
                }
            }
        }
        return f10544a;
    }

    public String b() {
        Iterator<b> it = this.b.iterator();
        while (it.hasNext()) {
            String strA = it.next().a();
            if (!TextUtils.isEmpty(strA)) {
                return strA;
            }
        }
        return null;
    }

    private void a(b bVar) {
        this.b.add(bVar);
    }
}
