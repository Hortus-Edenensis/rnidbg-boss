package defpackage;

import android.os.Bundle;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class f13 implements an2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f17410a;

    public f13() {
        this(null);
    }

    @Override // defpackage.an2
    public int type() {
        return 1;
    }

    @Override // defpackage.an2
    public void unserialize(Bundle bundle) {
        this.f17410a = bundle.getString("_lxtextobject_text");
    }

    public f13(String str) {
        this.f17410a = str;
    }
}
