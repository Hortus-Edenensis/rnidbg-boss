package defpackage;

import android.app.Activity;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.square.fragment.squareguide.QueryGuidePopupResult;
import com.zenmen.square.fragment.squareguide.SquareTieziYunyingGuideDialog;
import defpackage.q05;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class lj5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f19012a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public QueryGuidePopupResult g;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends go2<LXBaseNetBean<QueryGuidePopupResult>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19013a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ q05.e c;

        /* JADX INFO: renamed from: lj5$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1243a extends HashMap<String, Object> {
            public C1243a() {
                put("type", 2);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends HashMap<String, Object> {
            public b() {
                put("type", 1);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c extends HashMap<String, Object> {
            public c() {
                put("type", 0);
            }
        }

        public a(String str, HashMap map, q05.e eVar) {
            this.f19013a = str;
            this.b = map;
            this.c = eVar;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, this.f19013a, this.b);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<QueryGuidePopupResult> lXBaseNetBean, Exception exc) {
            QueryGuidePopupResult queryGuidePopupResult;
            if (!z) {
                q05.a("postguide_request", 0, new c());
            } else if (lXBaseNetBean == null || !lXBaseNetBean.isSuccess() || (queryGuidePopupResult = lXBaseNetBean.data) == null) {
                q05.a("postguide_request", 0, new b());
            } else {
                lj5.this.g = queryGuidePopupResult;
                q05.a("postguide_request", 0, new C1243a());
            }
            q05.e eVar = this.c;
            if (eVar != null) {
                eVar.a(lXBaseNetBean);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static lj5 f19018a = new lj5(null);
    }

    public /* synthetic */ lj5(a aVar) {
        this();
    }

    public static lj5 c() {
        return c.f19018a;
    }

    public void a(Activity activity, q05.e<LXBaseNetBean<QueryGuidePopupResult>> eVar) {
        if (q05.p()) {
            return;
        }
        this.g = null;
        zw4.e(new a(nl0.z + "/square.query.guide.popup.v1", new HashMap(), eVar));
    }

    public void b() {
        if (this.g == null || q05.p()) {
            return;
        }
        String str = nl0.z + "/square.exposure.guide.popup.v1";
        HashMap map = new HashMap();
        map.put("cfgId", Long.valueOf(this.g.id));
        zw4.e(new b(str, map));
    }

    public long d() {
        try {
            return q05.f("postguide").optLong("postguidenew_fre", 1800L);
        } catch (Exception e) {
            e.printStackTrace();
            return 1800L;
        }
    }

    public void e(Activity activity, String str) {
        List<String> list;
        if (this.g == null || !c().d || (list = this.g.triggerPositionList) == null) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next())) {
                c().d = false;
                SquareTieziYunyingGuideDialog squareTieziYunyingGuideDialog = new SquareTieziYunyingGuideDialog(activity, this.g);
                squareTieziYunyingGuideDialog.v(0.9f);
                squareTieziYunyingGuideDialog.x(2);
                squareTieziYunyingGuideDialog.show();
                return;
            }
        }
    }

    public lj5() {
        this.f19012a = -1;
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends go2<LXBaseNetBean<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19017a;
        public final /* synthetic */ HashMap b;

        public b(String str, HashMap map) {
            this.f19017a = str;
            this.b = map;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, this.f19017a, this.b);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<String> lXBaseNetBean, Exception exc) {
        }
    }
}
