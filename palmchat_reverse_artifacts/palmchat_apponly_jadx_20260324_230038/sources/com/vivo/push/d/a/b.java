package com.vivo.push.d.a;

import android.text.TextUtils;
import com.vivo.push.restructure.request.a.a.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class b implements com.vivo.push.restructure.request.a.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b.a<b> f11220a = new c();
    private String b;
    private List<com.vivo.push.d.b> c;
    private int d;

    public b(String str, List<com.vivo.push.d.b> list, int i) {
        new ArrayList();
        this.b = str;
        this.d = i;
        this.c = list;
    }

    @Override // com.vivo.push.restructure.request.a.a.b
    public final void a(com.vivo.push.restructure.request.a.a.a aVar) {
        aVar.a(this.b);
        aVar.a(this.d);
        aVar.a(this.c);
    }

    public final List<String> a() {
        ArrayList arrayList = new ArrayList();
        Iterator<com.vivo.push.d.b> it = this.c.iterator();
        while (it.hasNext()) {
            String strB = it.next().b();
            if (!TextUtils.isEmpty(strB)) {
                arrayList.add(strB);
            }
        }
        return arrayList;
    }

    public b(com.vivo.push.restructure.request.a.a.a aVar) throws JSONException {
        this.c = new ArrayList();
        this.b = aVar.c();
        this.d = aVar.a();
        aVar.a(com.vivo.push.d.b.f11221a, this.c);
    }
}
