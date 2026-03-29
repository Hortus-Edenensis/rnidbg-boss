package defpackage;

import android.os.Bundle;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class t03 implements an2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f20882a;
    public String b;

    @Override // defpackage.an2
    public int type() {
        return 3;
    }

    @Override // defpackage.an2
    public void unserialize(Bundle bundle) {
        this.f20882a = bundle.getByteArray("_lximageobject_imageData");
        this.b = bundle.getString("_lximageobject_imagePath");
    }
}
