package defpackage;

import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.kuaishou.weapon.p0.g;
import com.wifi.ad.core.config.EventParams;
import com.zenmen.find.ConditionHelper;
import com.zenmen.find.bean.DriftInfo;
import com.zenmen.listui.list.BaseNetBean;
import com.zenmen.listui.list.BaseNetListBean;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.square.R$string;
import com.zenmen.square.bean.UserrecommendTabs230414Config;
import com.zenmen.square.mvp.model.bean.NearByBean;
import com.zenmen.square.mvp.model.bean.NearByResp;
import com.zenmen.square.util.conf.MapFinderConfig;
import defpackage.b05;
import defpackage.ei5;
import defpackage.gu3;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class gu3 extends br<NearByBean> {
    public static final String C = "findfriend" + File.separator + "cache";
    public km2 p;
    public String q;
    public String r;
    public String s;
    public String t;
    public int u;
    public long v;
    public boolean x;
    public boolean y;
    public List<NearByBean> l = new ArrayList();
    public int m = 0;
    public int n = 0;
    public boolean o = true;
    public long w = 0;
    public boolean z = false;
    public String A = "";
    public Integer B = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {
        public a() {
            put("requestId", gu3.this.r);
            put(EventParams.KEY_CT_SDK_POSITION, gu3.this.B);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ei5<BaseNetListBean<NearByBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f17810a = false;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ String d;
        public final /* synthetic */ UserrecommendTabs230414Config e;
        public final /* synthetic */ ir f;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends TypeToken<BaseNetBean<NearByResp>> {
            public a() {
            }
        }

        /* JADX INFO: renamed from: gu3$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1202b extends HashMap<String, Object> {
            public C1202b() {
                put("requestId", gu3.this.r);
                put(EventParams.KEY_CT_SDK_POSITION, gu3.this.B);
                put("impr_id", gu3.this.A);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class c extends HashMap<String, Object> {
            public c() {
                put("requestId", gu3.this.r);
                put(EventParams.KEY_CT_SDK_POSITION, gu3.this.B);
                put("impr_id", gu3.this.A);
                put("useCache", 0);
                put("initialRequestId", "");
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class d extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ BaseNetListBean f17814a;

            public d(BaseNetListBean baseNetListBean) {
                this.f17814a = baseNetListBean;
                put("requestId", gu3.this.r);
                put(EventParams.KEY_CT_SDK_POSITION, gu3.this.B);
                put("failCode", Integer.valueOf(baseNetListBean.extCode));
                put("failReason", baseNetListBean.extMsg);
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class e extends HashMap<String, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ BaseNetListBean f17815a;

            public e(BaseNetListBean baseNetListBean) {
                this.f17815a = baseNetListBean;
                put("requestId", gu3.this.r);
                put(EventParams.KEY_CT_SDK_POSITION, gu3.this.B);
                put("failCode", Integer.valueOf(baseNetListBean.resultCode));
                put("failReason", baseNetListBean.errorMsg);
            }
        }

        public b(boolean z, boolean z2, String str, UserrecommendTabs230414Config userrecommendTabs230414Config, ir irVar) {
            this.b = z;
            this.c = z2;
            this.d = str;
            this.e = userrecommendTabs230414Config;
            this.f = irVar;
        }

        public static /* synthetic */ Object c(JSONObject jSONObject) {
            return "请求前参数======>" + jSONObject;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v17, types: [T, java.util.List<com.zenmen.square.mvp.model.bean.NearByBean>] */
        @Override // defpackage.ei5
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BaseNetListBean<NearByBean> handle(JSONObject jSONObject) {
            BaseNetBean baseNetBeanCreateDefault = BaseNetBean.createDefault(jSONObject, new a().getType());
            BaseNetListBean<NearByBean> baseNetListBean = new BaseNetListBean<>();
            baseNetListBean.resultCode = baseNetBeanCreateDefault.resultCode;
            baseNetListBean.errorMsg = baseNetBeanCreateDefault.errorMsg;
            if (baseNetBeanCreateDefault.isSuccess()) {
                T t = baseNetBeanCreateDefault.data;
                if (t != 0) {
                    if (((NearByResp) t).needVip && this.b) {
                        an1.c().l(baseNetBeanCreateDefault.data);
                    }
                    if ("A".equals(bj5.b().a().Q("LX-74314")) || !this.e.mapfinder.show_Switch) {
                        if (gu3.this.f == 49) {
                            an1.c().l(((NearByResp) baseNetBeanCreateDefault.data).getDriftBean(this.f17810a));
                        }
                    } else if (gu3.this.f == 113) {
                        an1.c().l(((NearByResp) baseNetBeanCreateDefault.data).getDriftBean(this.f17810a));
                    }
                    ?? r1 = ((NearByResp) baseNetBeanCreateDefault.data).nearbyList;
                    baseNetListBean.data = r1;
                    if (r1 != 0 && ((List) r1).size() > 0) {
                        gu3.this.w = 0L;
                        int i = 1;
                        for (NearByBean nearByBean : (List) baseNetListBean.data) {
                            nearByBean.reqId = baseNetBeanCreateDefault.requestId;
                            gu3 gu3Var = gu3.this;
                            nearByBean.from = gu3Var.f;
                            nearByBean.page = gu3Var.m + 1;
                            nearByBean.pos = i;
                            gu3 gu3Var2 = gu3.this;
                            nearByBean.refresh_id = gu3Var2.s;
                            long j = gu3Var2.w;
                            if (j == 0) {
                                gu3Var2.w = nearByBean.updateTime;
                            } else {
                                long j2 = nearByBean.updateTime;
                                if (j2 > 0 && j2 < j) {
                                    gu3Var2.w = j2;
                                }
                            }
                            i++;
                        }
                        for (int i2 = 0; i2 < ((List) baseNetListBean.data).size(); i2++) {
                            if (((NearByBean) ((List) baseNetListBean.data).get(i2)).isSuperExpose()) {
                                gu3.D(gu3.this, ((NearByBean) ((List) baseNetListBean.data).get(i2)).imprId);
                                if (i2 != ((List) baseNetListBean.data).size() - 1) {
                                    gu3.D(gu3.this, ",");
                                }
                            }
                        }
                    }
                }
                String str = gu3.this.r;
                gu3 gu3Var3 = gu3.this;
                qj5.R(str, gu3Var3.f, gu3Var3.t);
            }
            return baseNetListBean;
        }

        /* JADX WARN: Removed duplicated region for block: B:44:0x0138  */
        /* JADX WARN: Type inference failed for: r0v44, types: [T, java.util.List<com.zenmen.square.mvp.model.bean.NearByBean>] */
        /* JADX WARN: Type inference failed for: r0v53, types: [T, java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r0v8, types: [T, java.util.List<com.zenmen.square.mvp.model.bean.NearByBean>] */
        @Override // defpackage.ei5
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPostExecute(BaseNetListBean<NearByBean> baseNetListBean) {
            qv1 qv1VarY = null;
            if (baseNetListBean.isSuccess()) {
                if (gu3.this.B != null) {
                    b05.d("showimpr_idStr====》" + gu3.this.A);
                    zn6.j("boost_buyer_request_success", null, new C1202b());
                    if (!TextUtils.isEmpty(gu3.this.A)) {
                        zn6.j("boost_buyer_show", null, new c());
                    }
                }
                if (baseNetListBean.data == null) {
                    baseNetListBean.data = new ArrayList();
                }
                Object obj = baseNetListBean.data;
                if (obj != null && ((List) obj).size() > 0) {
                    gu3.this.f1558a = ((List) baseNetListBean.data).size();
                    int i = gu3.this.f;
                    if (i == 48) {
                        qv1VarY = zt4.y();
                    } else if (i == 49) {
                        qv1VarY = du3.y();
                    }
                    if (this.b) {
                        gu3.this.l.clear();
                        gu3.this.l.addAll((Collection) baseNetListBean.data);
                        gu3.this.K();
                        if (gu3.this.o) {
                            gu3.this.o = false;
                            if (qv1VarY != null) {
                                qv1VarY.f(0);
                            }
                        } else if (qv1VarY != null) {
                            qv1VarY.h();
                        }
                    } else {
                        int size = gu3.this.l.size();
                        gu3.this.l.addAll((Collection) baseNetListBean.data);
                        gu3.this.K();
                        if (qv1VarY != null) {
                            qv1VarY.f(size);
                        }
                    }
                    baseNetListBean.data = gu3.this.l;
                } else if (!this.b && gu3.this.l.size() > 0) {
                    if (!gu3.this.l.get(r0.size() - 1).isBottomGuide) {
                        if (!gu3.this.l.get(r0.size() - 1).isBottomTip()) {
                            NearByBean nearByBean = new NearByBean();
                            nearByBean.bottomTips = "我也是有底线的";
                            nearByBean.isBottomGuide = !gu3.this.Q();
                            gu3.this.l.add(nearByBean);
                            gu3 gu3Var = gu3.this;
                            gu3Var.m = gu3Var.n;
                        }
                    }
                } else if (this.b) {
                    gu3.this.l.clear();
                }
            } else {
                gu3 gu3Var2 = gu3.this;
                gu3Var2.m = gu3Var2.n;
                if (baseNetListBean.extCode == 0) {
                    zn6.j("boost_buyer_request_fail", null, new e(baseNetListBean));
                } else if (gu3.this.B != null) {
                    zn6.j("boost_buyer_request_fail", null, new d(baseNetListBean));
                }
            }
            baseNetListBean.data = gu3.this.l;
            this.f.a(baseNetListBean);
            gu3.this.c = 2;
        }

        @Override // defpackage.ei5
        public JSONObject genRequestParams() {
            aw awVarB;
            final JSONObject jSONObjectB = this.b ? gu3.this.b() : gu3.this.a();
            if (jSONObjectB != null) {
                try {
                    if (this.c) {
                        jSONObjectB.put("pullAiVirtual", 1);
                    } else {
                        jSONObjectB.put("pullAiVirtual", 0);
                    }
                    if (!"A".equals(this.d) && this.e.mapfinder.show_Switch) {
                        int i = gu3.this.f;
                        if (i == 49) {
                            jSONObjectB.put("drift", false);
                        } else if (i == 113) {
                            jSONObjectB.put("drift", true);
                            jSONObjectB.put("pullAiVirtual", 0);
                            DriftInfo driftInfo = ConditionHelper.getInstance().getDriftInfo();
                            jSONObjectB.put("driftScene", driftInfo != null ? driftInfo.driftScene : 0);
                        }
                    }
                } catch (Exception unused) {
                }
            }
            String str = gu3.this.r;
            int i2 = gu3.this.m + 1;
            gu3 gu3Var = gu3.this;
            qj5.Q(str, i2, gu3Var.f, gu3Var.s, gu3Var.u, gu3Var.t, jSONObjectB.toString());
            this.f17810a = jSONObjectB.optBoolean("drift", false);
            if (this.b) {
                awVarB = aw.b(jSONObjectB);
                List<NearByBean> list = gu3.this.l;
                if (list != null && list.size() > 0) {
                    awVarB.e = false;
                }
            } else {
                awVarB = null;
            }
            b05.c(new b05.a() { // from class: hu3
                @Override // b05.a
                public final Object getValue() {
                    return gu3.b.c(jSONObjectB);
                }
            });
            ei5.a.a(jSONObjectB, awVarB);
            return jSONObjectB;
        }
    }

    public gu3(int i, String str) {
        this.f = i;
        this.q = str;
    }

    public static /* synthetic */ String D(gu3 gu3Var, Object obj) {
        String str = gu3Var.A + obj;
        gu3Var.A = str;
        return str;
    }

    public final void K() {
        MapFinderConfig.RecommendEntry recommendEntry;
        if (!this.z && this.f == 48) {
            MapFinderConfig mapFinderConfigG = gi5.g();
            int i = (mapFinderConfigG == null || (recommendEntry = mapFinderConfigG.pagelffriend_recommend_cardentry) == null) ? -1 : recommendEntry.order;
            if (i == -1 || this.l.size() < i) {
                return;
            }
            NearByBean nearByBean = new NearByBean();
            nearByBean.isMapFindGuideItem = true;
            this.l.add(i, nearByBean);
            this.z = true;
        }
    }

    public boolean L() {
        return this.x;
    }

    public JSONObject O(boolean z) {
        ContactInfoItem contactInfoItemA;
        int i = !z ? this.m : 0;
        if (!hx3.m(c.b()) && !z) {
            try {
                Thread.sleep(200L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return m(c.b().getString(R$string.square_network_error));
        }
        HashMap map = new HashMap();
        String strE = v4.e(c.b());
        if (!TextUtils.isEmpty(strE) && (contactInfoItemA = dn0.a(strE)) != null) {
            map.put("gender", Integer.valueOf(contactInfoItemA.getGender()));
            map.put("age", Integer.valueOf(contactInfoItemA.getAgeInt()));
        }
        LocationEx locationEx = this.d;
        if (locationEx != null) {
            map.put("longitude", Double.valueOf(locationEx.getLongitude()));
            map.put("latitude", Double.valueOf(this.d.getLatitude()));
            map.put("localCityCode", this.d.getCityCode());
        } else if (u()) {
            if (!"lbs.square.nearby.pull.v9".equals(this.q) || !a46.p()) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                return m("获取位置信息失败");
            }
            s(0);
            map.put("needServerLocate", 1);
        }
        if (z || this.v == 0) {
            this.v = System.currentTimeMillis() / 100;
        }
        map.put("index", Integer.valueOf(i));
        map.put("pageNo", Integer.valueOf(i + 1));
        map.put("pageKey", this.v + "");
        map.put("taichiGroup2", "A");
        map.put("productId", Integer.valueOf(bj5.b().a().f()));
        map.put("taichiGroupLx66032", bj5.b().a().T("LX-66344", "A"));
        return new JSONObject(map);
    }

    public void P(int i, NearByBean nearByBean) {
        if (this.p != null) {
            this.l.add(i, nearByBean);
            this.p.e(i, nearByBean);
        }
    }

    public final boolean Q() {
        return this.f == 48 ? ConditionHelper.getInstance().getRecommendCond().isDefaultCond() : ConditionHelper.getInstance().getNearByCond().isDefaultCond();
    }

    public boolean R() {
        return this.y;
    }

    public void S(boolean z) {
        this.x = z;
    }

    public void T(boolean z) {
        this.y = z;
    }

    public void U(km2 km2Var) {
        this.p = km2Var;
    }

    public void V(String str) {
        this.t = str;
        this.u = 0;
    }

    @Override // defpackage.om2
    public JSONObject a() {
        JSONObject jSONObjectO = O(false);
        ConditionHelper.getInstance().getNearByCond().mergeParams(jSONObjectO);
        ConditionHelper.getInstance().getDriftInfo().mergeParams(jSONObjectO);
        return jSONObjectO;
    }

    @Override // defpackage.om2
    public JSONObject b() {
        JSONObject jSONObjectO = O(true);
        ConditionHelper.getInstance().getNearByCond().mergeParams(jSONObjectO);
        ConditionHelper.getInstance().getDriftInfo().mergeParams(jSONObjectO);
        return jSONObjectO;
    }

    @Override // defpackage.om2
    public void d(ir<BaseNetListBean<NearByBean>> irVar) {
        b05.d("NearByListModel==>loadMoreData()");
        x(false, irVar);
    }

    @Override // defpackage.om2
    public List<NearByBean> e() {
        return this.l;
    }

    @Override // defpackage.om2
    public void f(ir<BaseNetListBean<NearByBean>> irVar) {
        b05.d("NearByListModel==>refreshData()");
        x(true, irVar);
    }

    @Override // defpackage.ar
    public boolean i() {
        return false;
    }

    @Override // defpackage.br
    public boolean t() {
        return true;
    }

    @Override // defpackage.br
    public boolean u() {
        return t();
    }

    @Override // defpackage.br
    public boolean v() {
        if (this.h || !tg4.b(c.b(), g.g)) {
            return !p() && l();
        }
        l();
        return true;
    }

    @Override // defpackage.br
    public void w(boolean z, ir<BaseNetListBean<NearByBean>> irVar) {
        boolean zY;
        String strQ = bj5.b().a().Q("LX-74314");
        UserrecommendTabs230414Config userrecommendTabs230414Config = UserrecommendTabs230414Config.getUserrecommendTabs230414Config();
        int i = this.m;
        this.n = i;
        if (z) {
            this.s = UUID.randomUUID().toString().replace("-", "");
            this.u++;
            this.m = 0;
            this.z = false;
        } else {
            this.m = i + 1;
        }
        this.r = xn3.a();
        this.B = null;
        int i2 = this.f;
        if (i2 == 48) {
            this.B = 1;
        } else if (i2 == 49) {
            this.B = 2;
        }
        if (z) {
            zY = bj5.b().a().Y(this.f == 49 ? "findFriend_nearby" : "findFriend_recommend");
        } else {
            zY = false;
        }
        if (this.B != null) {
            zn6.j("boost_buyer_request_start", null, new a());
        }
        this.A = "";
        vj5.f(this.q, new b(z, zY, strQ, userrecommendTabs230414Config, irVar), this.m, this.r);
    }

    @Override // defpackage.om2
    public void destroy() {
    }

    @Override // defpackage.om2
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public void c(int i, NearByBean nearByBean) {
    }

    @Override // defpackage.om2
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public void g(int i, NearByBean nearByBean) {
    }
}
