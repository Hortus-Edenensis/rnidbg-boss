package defpackage;

import android.os.Bundle;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class i13 implements an2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f18083a;
    public String b;
    public String c;

    @Override // defpackage.an2
    public int type() {
        return 2;
    }

    @Override // defpackage.an2
    public void unserialize(Bundle bundle) {
        this.b = bundle.getString("_lxwebpageobject_extInfo");
        this.f18083a = bundle.getString("_lxwebpageobject_webpageUrl");
        this.c = bundle.getString("_lxwebpageobject_canvaspagexml");
    }
}
