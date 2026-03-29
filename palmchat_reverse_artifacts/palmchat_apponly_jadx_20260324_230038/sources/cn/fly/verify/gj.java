package cn.fly.verify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import cn.fly.verify.fq;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class gj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile gj f2394a;
    private BroadcastReceiver b;
    private final ConcurrentHashMap<String, a> c = new ConcurrentHashMap<>();
    private volatile long d = 0;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();
    }

    private gj() {
        this.b = null;
        if (Cdo.c() || Cdo.d()) {
            this.b = new BroadcastReceiver() { // from class: cn.fly.verify.gj.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    gj.a().a(context, intent);
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(dx.a("029bcIbabhcbbgbadb0cdg]dbddbgcdbgdbchcicjciefbfeidhcjcfgbef"));
            eg.a(this.b, intentFilter);
        }
    }

    public static gj a() {
        if (f2394a == null) {
            synchronized (gj.class) {
                if (f2394a == null) {
                    f2394a = new gj();
                }
            }
        }
        return f2394a;
    }

    public void a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            if (!dx.a("029bc^babhcbbgbadb.cdgTdbddbgcdbgdbchcicjciefbfeidhcjcfgbef").equals(intent.getAction()) || intent.getParcelableExtra(dx.a("011cdg[ddcbbhbjcg5c+cdcb")) == null) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.d > 2000) {
                this.d = jCurrentTimeMillis;
                bq.a().d(2500L, new gh() { // from class: cn.fly.verify.gj.2
                    @Override // cn.fly.verify.gh
                    public void a() {
                        if (Cdo.i()) {
                            fq.a(ax.g()).d(true).a(new fq.a() { // from class: cn.fly.verify.gj.2.1
                                @Override // cn.fly.verify.fq.a
                                public void a(fq.b bVar) {
                                    HashMap<String, Object> mapK = bVar.k(new int[0]);
                                    if (mapK == null) {
                                        return;
                                    }
                                    String str = (String) mapK.get("ssmt");
                                    String str2 = (String) mapK.get("bsmt");
                                    en.a().a("[MCM] cdi " + str + " bcdi " + str2 + " len " + gj.a().c.size(), new Object[0]);
                                    if (TextUtils.isEmpty(str2) && (TextUtils.isEmpty(str) || dx.a("014 gcbeAcNbj_cWcbddUcAgddfdfbgbage").equalsIgnoreCase(str))) {
                                        return;
                                    }
                                    TreeMap treeMap = new TreeMap();
                                    treeMap.put("ssmt", str);
                                    treeMap.put("bsmt", str2);
                                    String strB = fr.b(new JSONObject(treeMap).toString());
                                    String strB2 = bv.a().b(bv.i, (String) null);
                                    if (strB2 == null || !strB2.equals(strB)) {
                                        Iterator it = gj.this.c.values().iterator();
                                        while (it.hasNext()) {
                                            ((a) it.next()).a();
                                        }
                                    }
                                }
                            });
                        }
                    }
                });
            }
        } catch (Throwable th) {
            en.a().a(th);
        }
    }

    public void a(String str, a aVar) {
        if (aVar == null || str == null || this.c.containsKey(str)) {
            return;
        }
        this.c.put(str, aVar);
    }
}
