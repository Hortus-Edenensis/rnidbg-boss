package cn.fly.verify;

import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class da {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f2172a;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        Object a(String str, ArrayList<Object> arrayList);
    }

    public da(a aVar) {
        this.f2172a = aVar;
    }

    public Object a(String str, ArrayList<Object> arrayList) {
        a aVar = this.f2172a;
        if (aVar == null) {
            return null;
        }
        return aVar.a(str, arrayList);
    }
}
