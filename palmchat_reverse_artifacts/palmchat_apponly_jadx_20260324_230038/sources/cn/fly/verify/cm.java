package cn.fly.verify;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import cn.fly.verify.ce;
import cn.fly.verify.fq;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class cm extends ce {
    public cm(Context context) {
        super(context);
    }

    private void f() {
        try {
            Intent intent = new Intent();
            intent.setClassName(ba.a("012eUgffhhffhfefkfehffhhjIf"), ba.a("033eBgffhhffhfefkfehffhhjCfThfhj(h'flfffk1eh;hfjehj(fMke?iTglSh0flfffkFeh"));
            intent.setAction(ba.a("032eSgffhhfhgfi3gIhffhhjHf%hf8fek2fkgfBg1hfhj>kf7flUk,hfhj;hZflfffk!eh"));
            intent.putExtra(ba.a("025e(gffhhfhgfi!gNhffhhj3fMhf!lfAfl]f=fhhf0l^fngg5gfLfh:h"), this.b);
            intent.putExtra(ba.a("026e]gffhhfhgfiWgGhffhhj8f+hfNlf2fl+f^fhhfflfiYg_fk(g?hj(hk"), true);
            this.f2142a.startService(intent);
        } catch (Throwable th) {
            en.a().a(th);
        }
    }

    @Override // cn.fly.verify.ce
    public Intent a() {
        f();
        Intent intent = new Intent();
        intent.setClassName(ba.a("012e0gffhhffhfefkfehffhhj?f"), ba.a("033eIgffhhffhfefkfehffhhj:f!hfhjPh9flfffkPeh=hfjehjMf.gkfeglFh[flfffk+eh"));
        intent.setAction(ba.a("033e6gffhhfhgfi>gKhffhhj[fAhf.fekUfkgfSg[hfhgfkSgTfe.k[gfhfhjJh7flfffkCeh"));
        intent.putExtra(ba.a("025eIgffhhfhgfiMg(hffhhjUfWhfTlf5fl;fSfhhf'l+fnggCgf%fhTh"), this.b);
        return intent;
    }

    @Override // cn.fly.verify.ce
    public ce.b a(IBinder iBinder) {
        ce.b bVar = new ce.b();
        bVar.f2144a = true;
        bVar.b = a(ba.a("0047gfMfRfkfe"), iBinder, ba.a("026e>gffhhfhgfi,g*hf^i[fkhghfjehj_fUgkfegk5gkh_flgh2feh"), 3, new String[0]);
        final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        fq.a(this.f2142a).c(ba.a("012e:gffhhffhfefkfehffhhj4f"), 0).a(new fq.a() { // from class: cn.fly.verify.cm.1
            @Override // cn.fly.verify.fq.a
            public void a(fq.b bVar2) {
                LinkedBlockingQueue linkedBlockingQueue2;
                Boolean bool;
                if (bVar2.l(new int[0]) == null) {
                    linkedBlockingQueue2 = linkedBlockingQueue;
                    bool = Boolean.FALSE;
                } else {
                    linkedBlockingQueue2 = linkedBlockingQueue;
                    bool = Boolean.TRUE;
                }
                linkedBlockingQueue2.offer(bool);
            }
        });
        try {
            Boolean bool = (Boolean) linkedBlockingQueue.poll(120L, TimeUnit.MILLISECONDS);
            if (bool != null) {
                bVar.f2144a = bool.booleanValue();
            }
        } catch (Throwable unused) {
        }
        return bVar;
    }
}
