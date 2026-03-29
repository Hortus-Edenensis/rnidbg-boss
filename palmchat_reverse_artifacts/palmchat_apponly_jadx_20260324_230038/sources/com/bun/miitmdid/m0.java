package com.bun.miitmdid;

import android.content.Context;
import com.bun.lib.MsaIdInterface;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class m0 extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f4924a;
    public String b;
    public j0 c;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements k0 {
        public a() {
        }

        @Override // com.bun.miitmdid.k0
        public native void a(MsaIdInterface msaIdInterface);
    }

    public m0(Context context) {
        p0.c("ZteProvider", "ZteProvider(Context)");
        this.f4924a = context;
        this.b = context.getPackageName();
        try {
            if (context.getPackageManager().getPackageInfo("com.mdid.msa", 0) == null) {
                p0.d("ZteProvider", "Constructor: getPackageInfo is null");
                throw new NullPointerException("Constructor: getPackageInfo is null");
            }
        } catch (Exception unused) {
            p0.d("ZteProvider", "Constructor: MsaService not found");
        }
        try {
            j0.a(this.f4924a, this.b);
            p0.c("ZteProvider", "Constructor: MsaService start success");
        } catch (Exception e) {
            p0.b("ZteProvider", "Constructor: MsaService start Exception: " + e.getMessage());
        }
    }

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public void doStart() {
        p0.c("ZteProvider", "doStart()");
        try {
            this.f4924a = checkContext(this.f4924a);
            doAsyncCallBefore();
            j0 j0Var = new j0(this.f4924a, new a());
            this.c = j0Var;
            j0Var.a(this.b);
            p0.c("ZteProvider", "doStart: BindService success");
            doAsyncCallAfter();
        } catch (Exception e) {
            p0.d("ZteProvider", "doStart: Exception: " + e.getMessage());
            cleanCache();
            onSupportCache();
        }
    }

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public void shutDown() {
        j0 j0Var = this.c;
        if (j0Var != null) {
            j0Var.e();
        }
    }
}
