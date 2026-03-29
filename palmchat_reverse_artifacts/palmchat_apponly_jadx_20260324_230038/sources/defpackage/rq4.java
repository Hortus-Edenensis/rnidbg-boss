package defpackage;

import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.zenmen.palmchat.chat.gift.quicksend.QuickSendVo;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import defpackage.b05;
import defpackage.q05;
import defpackage.rq4;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class rq4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f20547a;
    public static rq4 b;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends TypeToken<List<QuickSendVo>> {
        public a() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends TypeToken<List<QuickSendVo>> {
        public b() {
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(nl0.z);
        sb.append(p05.c() ? "/vas.im.quick.detail.v2" : "/vas.im.quick.detail.v1");
        f20547a = sb.toString();
        b = new rq4();
    }

    public static rq4 l() {
        return b;
    }

    public static /* synthetic */ Object n(String str, String str2) {
        return "getFromLocal: domain=" + str + ", hasConfig=" + str2;
    }

    public static /* synthetic */ Object o() {
        return "getFromLocal: parsed  items from local";
    }

    public static /* synthetic */ Object p(Exception exc) {
        return "getFromLocal: parse error " + exc.getMessage();
    }

    public static /* synthetic */ Object q() {
        return "getFromLocal: no local config,不管了";
    }

    public static /* synthetic */ Object r(String str, long j, long j2, long j3) {
        return "updateConfig: domain=" + str + ", lastRequestTime=" + j + ", currentTime=" + j2 + ", timeDiff=" + j3 + ", interval=1800000";
    }

    public static /* synthetic */ Object s() {
        return "updateConfig: requesting from server";
    }

    public static /* synthetic */ Object t() {
        return "updateConfig: within interval, getting from local";
    }

    public final List<QuickSendVo> j() {
        ArrayList arrayList = new ArrayList();
        String strN = SPUtil.f14322a.n(SPUtil.SCENE.GIFT_QUICKSEND, k86.a("key_quick_send_gift_config"), "");
        if (TextUtils.isEmpty(strN)) {
            return arrayList;
        }
        try {
            return (List) az2.b(strN, new a().getType());
        } catch (Exception e) {
            e.printStackTrace();
            return arrayList;
        }
    }

    public final void k(final String str, q05.e<List<QuickSendVo>> eVar) {
        final Exception e;
        List<QuickSendVo> list;
        ArrayList arrayList = new ArrayList();
        final String strN = SPUtil.f14322a.n(SPUtil.SCENE.GIFT_QUICKSEND, k86.a("key_quick_send_gift_config_" + str), "");
        b05.c(new b05.a() { // from class: nq4
            @Override // b05.a
            public final Object getValue() {
                return rq4.n(str, strN);
            }
        });
        if (TextUtils.isEmpty(strN)) {
            b05.c(new b05.a() { // from class: qq4
                @Override // b05.a
                public final Object getValue() {
                    return rq4.q();
                }
            });
            return;
        }
        try {
            list = (List) az2.b(strN, new b().getType());
        } catch (Exception e2) {
            e = e2;
            list = arrayList;
        }
        try {
            b05.c(new b05.a() { // from class: oq4
                @Override // b05.a
                public final Object getValue() {
                    return rq4.o();
                }
            });
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            b05.c(new b05.a() { // from class: pq4
                @Override // b05.a
                public final Object getValue() {
                    return rq4.p(e);
                }
            });
        }
        if (eVar != null) {
            eVar.a(list);
        }
    }

    public List<QuickSendVo> m() {
        new ArrayList();
        return j();
    }

    public final void u(String str) {
        SPUtil.f14322a.t(SPUtil.SCENE.GIFT_QUICKSEND, k86.a("key_quick_send_gift_config"), str);
    }

    public final void v(String str, String str2) {
        SPUtil.f14322a.t(SPUtil.SCENE.GIFT_QUICKSEND, k86.a("key_quick_send_gift_config_" + str), str2);
    }

    public void w() {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.GIFT_QUICKSEND;
        if (Math.abs(ir5.b() - sPUtil.i(scene, k86.a("key_quick_send_gift_config_request_time"), 0L)) > 1800000) {
            sPUtil.t(scene, k86.a("key_quick_send_gift_config_request_time"), Long.valueOf(ir5.b()));
            zw4.f(f20547a, 1, new JSONObject(), new d());
        }
    }

    public void x(final String str, q05.e<List<QuickSendVo>> eVar) {
        String str2 = "key_quick_send_gift_config_request_time_" + str;
        final long jI = SPUtil.f14322a.i(SPUtil.SCENE.GIFT_QUICKSEND, k86.a(str2), 0L);
        final long jB = ir5.b();
        final long jAbs = Math.abs(jB - jI);
        b05.c(new b05.a() { // from class: kq4
            @Override // b05.a
            public final Object getValue() {
                return rq4.r(str, jI, jB, jAbs);
            }
        });
        if (jAbs <= 1800000) {
            b05.c(new b05.a() { // from class: mq4
                @Override // b05.a
                public final Object getValue() {
                    return rq4.t();
                }
            });
            k(str, eVar);
        } else {
            b05.c(new b05.a() { // from class: lq4
                @Override // b05.a
                public final Object getValue() {
                    return rq4.s();
                }
            });
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("domain", str);
            } catch (Exception unused) {
            }
            zw4.f(f20547a, 1, jSONObject, new c(str, str2, eVar));
        }
    }

    public void y(String str, ArrayList<QuickSendVo> arrayList) {
        v(str, (arrayList == null || arrayList.size() <= 0) ? "" : az2.c(arrayList));
    }

    public void z(ArrayList<QuickSendVo> arrayList) {
        u((arrayList == null || arrayList.size() <= 0) ? "" : az2.c(arrayList));
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends yw4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f20550a;
        public final /* synthetic */ String b;
        public final /* synthetic */ q05.e c;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends TypeToken<List<QuickSendVo>> {
            public a() {
            }
        }

        public c(String str, String str2, q05.e eVar) {
            this.f20550a = str;
            this.b = str2;
            this.c = eVar;
        }

        public static /* synthetic */ Object d(yy2 yy2Var) {
            StringBuilder sb = new StringBuilder();
            sb.append("updateConfig onSuccess: isSuccess=");
            sb.append(yy2Var.f22300a);
            sb.append(", hasData=");
            sb.append(yy2Var.d != null);
            return sb.toString();
        }

        public static /* synthetic */ Object e() {
            return "updateConfig: got itemList, saving config";
        }

        public static /* synthetic */ Object f(List list) {
            StringBuilder sb = new StringBuilder();
            sb.append("updateConfig: callback with ");
            sb.append(list != null ? list.size() : 0);
            sb.append(" items");
            return sb.toString();
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, final yy2 yy2Var) {
            JSONObject jSONObject2;
            b05.c(new b05.a() { // from class: sq4
                @Override // b05.a
                public final Object getValue() {
                    return rq4.c.d(yy2Var);
                }
            });
            try {
                if (yy2Var.f22300a && (jSONObject2 = yy2Var.d) != null && jSONObject2.has("itemList")) {
                    String string = yy2Var.d.optJSONArray("itemList").toString();
                    b05.c(new b05.a() { // from class: tq4
                        @Override // b05.a
                        public final Object getValue() {
                            return rq4.c.e();
                        }
                    });
                    rq4.this.v(this.f20550a, string);
                    SPUtil.f14322a.t(SPUtil.SCENE.GIFT_QUICKSEND, k86.a(this.b), Long.valueOf(ir5.b()));
                    if (this.c != null) {
                        final List list = (List) az2.b(string, new a().getType());
                        b05.c(new b05.a() { // from class: uq4
                            @Override // b05.a
                            public final Object getValue() {
                                return rq4.c.f(list);
                            }
                        });
                        this.c.a(list);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends yw4 {
        public d() {
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            JSONObject jSONObject2;
            try {
                if (yy2Var.f22300a && (jSONObject2 = yy2Var.d) != null && jSONObject2.has("itemList")) {
                    rq4.this.u(yy2Var.d.optJSONArray("itemList").toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
        }
    }
}
