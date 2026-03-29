package defpackage;

import android.database.ContentObserver;
import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class jq2 extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f18478a;
    public int b;
    public iq2 c;

    public jq2(iq2 iq2Var, int i, String str) {
        super(null);
        this.c = iq2Var;
        this.b = i;
        this.f18478a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        iq2 iq2Var = this.c;
        if (iq2Var != null) {
            iq2Var.l(this.b, this.f18478a);
        } else {
            Log.e("VMS_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}
