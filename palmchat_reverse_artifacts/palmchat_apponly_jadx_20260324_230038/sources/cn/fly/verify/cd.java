package cn.fly.verify;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import cn.fly.verify.ce;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class cd extends ce {
    public cd(Context context) {
        super(context);
    }

    @Override // cn.fly.verify.ce
    public Intent a() {
        Intent intent = new Intent(ba.a("036eNgffhhffigffefkhjhfgf5lhgIfe'hCfffkRehHhfiiinijgjgkhmglfjglijikilgkimij"));
        intent.setPackage(ba.a("015e+gffhhfHj6fiMf6hh5hCfkhf2j^hhfkfe"));
        return intent;
    }

    @Override // cn.fly.verify.ce
    public ce.b a(IBinder iBinder) throws Throwable {
        String strA = ba.a("053e5gffhhffigffefkhjhfgf[lhgXfe@h'fffk)eh?hfQfIfkfe!iFhfiiAlhgEhm;hCfffkSeh+gkfe hgkCfkghfk3h5flgl)h9flfffkDeh");
        ce.b bVar = new ce.b();
        bVar.b = a(ba.a("004KgfOf)fkfe"), iBinder, strA, 1, new String[0]);
        a(ba.a("0244fkhjhefkfhfk*k$gnfegmflVfe+fnfk-g,ggijAgf]hg,ih=fe"), iBinder, strA, 2);
        bVar.f2144a = !TextUtils.isEmpty(bVar.b);
        return bVar;
    }
}
