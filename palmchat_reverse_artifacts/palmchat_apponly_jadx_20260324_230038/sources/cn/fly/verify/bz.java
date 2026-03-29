package cn.fly.verify;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import cn.fly.verify.ce;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class bz extends ce {
    public bz(Context context) {
        super(context);
    }

    @Override // cn.fly.verify.ce
    public Intent a() {
        Intent intent = new Intent(ec.b("030b.dcceec!c9egcfegecceegWcVecVcbh<chdc@d%ecdkfjfjfgdidicgejdhej"));
        intent.setComponent(new ComponentName(ec.b("029b<dcceec$cLegcfegecceeg0c@ecdicfZiifeVce4edhc:cicjejdhej"), ec.b("053bZdcceec.c@egcfegecceeg6cTecdicf]iifeUceRedhc,cicjejdhejecdicfViife0ceSedhc%cicjejdhejdiAe'ciccchYbe")));
        return intent;
    }

    @Override // cn.fly.verify.ce
    public ce.b a(IBinder iBinder) {
        ce.b bVar = new ce.b();
        bVar.b = a(ec.b("004Zdc+cSchcb"), iBinder, ec.b("047b=dcceec8c egcfegecceegJc:ecdicf,iifeUce(edhc:cicjejdhejecdhejchcbdkchcbJf^dh@dheNcide.cbe"), 3, new String[0]);
        bVar.f2144a = a(ec.b("011HchegdicfXii0dcci:heAcb"), iBinder, ec.b("047bPdcceec$c6egcfegecceegDc'ecdicfQiifeHce@edhc7cicjejdhejecdhejchcbdkchcbUfXdh<dheLcide]cbe"), 1) != 0;
        return bVar;
    }
}
