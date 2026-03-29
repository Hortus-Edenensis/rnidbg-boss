package defpackage;

import android.database.ContentObserver;
import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class r77 extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f20411a;
    public int b;
    public f37 c;

    public r77(f37 f37Var, int i, String str) {
        super(null);
        this.c = f37Var;
        this.b = i;
        this.f20411a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        f37 f37Var = this.c;
        if (f37Var != null) {
            f37Var.d(this.b, this.f20411a);
        } else {
            Log.e("VMS_IDLG_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}
