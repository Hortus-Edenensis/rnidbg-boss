package cn.fly.verify;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import cn.fly.verify.ce;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class cg extends ce {
    public cg(Context context) {
        super(context);
    }

    @Override // cn.fly.verify.ce
    public Intent a() {
        Intent intent = new Intent();
        intent.setClassName(ec.b("023b>dcceecfbcfcheccb<eKccch7be]chcbegMeOciccch@be"), ec.b("039bDdcceecfbcfcheccbRe2ccchCbe$chcbegKeEciccch8be?ecejWeKccchTbePchcbdiWeTciccch4be"));
        return intent;
    }

    @Override // cn.fly.verify.ce
    public long c() {
        return 3000L;
    }

    @Override // cn.fly.verify.ce
    public ce.b a(IBinder iBinder) {
        String strB = ec.b("042b=dcceecfbcfcheccbOe6ccch;be7chcbegBeCciccchIbePecdhejDe-ccch-beJchcbdhYdheTcide-cbe");
        ce.b bVar = new ce.b();
        bVar.b = a(ec.b("0045dc>c6chcb"), iBinder, strB, 1, new String[0]);
        bVar.f2144a = a(ec.b("009Qegcf]iiRdcci he[cb"), iBinder, strB, 3) != 0;
        return bVar;
    }
}
