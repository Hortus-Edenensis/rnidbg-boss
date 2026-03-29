package cn.fly.verify;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import cn.fly.verify.ce;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class cj extends ce {
    public cj(Context context) {
        super(context);
    }

    @Override // cn.fly.verify.ce
    public Intent a() {
        Intent intent = new Intent();
        intent.setClassName(ed.a("035c eddffdfh-d8dffhdgPe+eefdUde?dcdjeddidcfddc(f$dddiVcfRdidcfh!fLdjdddiWcf"), ed.a("051c4eddffdfhYd9dffhdgHeOeefdCde(dcdjeddidcfddc'fUdddiHcf'didcfhDf1djdddiDcf4fdfkZf;dddi'cfMeidcej-f6djdddiDcf"));
        return intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    @Override // cn.fly.verify.ce
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ce.b a(IBinder iBinder) {
        boolean z;
        if (iBinder != null) {
            try {
            } catch (Throwable th) {
                en.a().a(th);
            }
            z = iBinder.queryLocalInterface(ed.a("052c(eddffdfh+dRdffhdg)e4eefd^deLdcdjeddidcfddcFf.dddi$cf2didcfh2f^djdddi.cf?fdeifk=fHdddiWcf eidcej1f%djdddi cf")) != null;
        }
        ce.b bVar = new ce.b();
        bVar.f2144a = z;
        bVar.b = a(ed.a("004!ed.d:didc"), iBinder, ed.a("052c>eddffdfhWdJdffhdg,eJeefd4de%dcdjeddidcfddc+fXdddi?cf2didcfhJf-djdddi5cfLfdeifkCf>dddiOcf]eidcej%fOdjdddiCcf"), 1, new String[0]);
        return bVar;
    }
}
