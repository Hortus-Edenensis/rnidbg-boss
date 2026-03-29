package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ah extends iw4 {
    public boolean l;

    public ah(String str) {
        super(str);
    }

    public static ah b(String str, String str2, String str3) {
        ah ahVar = new ah("LX_SERVICE_ACCOUNT");
        ahVar.f18275a = str;
        ahVar.d = str2;
        ahVar.h = str3;
        return ahVar;
    }

    public static ah c(String str, String str2) {
        ah ahVar = new ah("LX_APP_STATE");
        ahVar.f18275a = str;
        ahVar.d = str2;
        return ahVar;
    }

    @Override // defpackage.iw4
    public Map<String, String> a(String str) {
        Map<String, String> mapA = super.a(str);
        mapA.put("preload", this.l ? "1" : "0");
        return mapA;
    }
}
