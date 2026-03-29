package defpackage;

import android.os.Parcelable;
import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.zenmen.listui.list.BaseNetBean;
import com.zenmen.listui.list.BaseNetListBean;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.mvp.model.bean.DeleteResBean;
import com.zenmen.square.mvp.model.bean.DislikeResp;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.mvp.model.bean.SquareFeedEvent;
import com.zenmen.square.support.SquareSingleton;
import com.zenmen.square.topic.bean.TopicListBean;
import com.zenmen.square.vip.VipEnterConfig;
import defpackage.bi5;
import defpackage.xt1;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class yt1 extends br<SquareFeed> implements xt1.a {
    public static final String A = "square" + File.separator + "cache";
    public km2 l;
    public String n;
    public String o;
    public String p;
    public int q;
    public String t;
    public xt1 u;
    public List<SquareFeed> m = new ArrayList();
    public int r = 1;
    public int s = 1;
    public boolean v = true;
    public long w = 0;
    public long x = -100;
    public HashSet<Long> y = new HashSet<>();
    public Set<Long> z = new HashSet();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ei5<BaseNetBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SquareFeed f22267a;

        /* JADX INFO: renamed from: yt1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1296a extends TypeToken<BaseNetBean> {
            public C1296a() {
            }
        }

        public a(SquareFeed squareFeed) {
            this.f22267a = squareFeed;
        }

        @Override // defpackage.ei5
        public JSONObject genRequestParams() {
            HashMap map = new HashMap();
            map.put("feedId", Long.valueOf(this.f22267a.id));
            return new JSONObject(map);
        }

        @Override // defpackage.ei5
        public BaseNetBean handle(JSONObject jSONObject) {
            return BaseNetBean.createDefault(jSONObject, new C1296a().getType());
        }

        @Override // defpackage.ei5
        public void onPostExecute(BaseNetBean baseNetBean) {
            if (yt1.this.l == null) {
                return;
            }
            if (!baseNetBean.isSuccess()) {
                yt1.this.l.d(baseNetBean.getErrMsg());
                qj5.q(this.f22267a, 2, yt1.this.f);
                return;
            }
            qj5.q(this.f22267a, 1, yt1.this.f);
            SquareFeedEvent squareFeedEvent = new SquareFeedEvent();
            squareFeedEvent.eventType = 3;
            squareFeedEvent.feed = this.f22267a;
            an1.c().l(squareFeedEvent);
            fi5 fi5Var = new fi5();
            fi5Var.f17534a = this.f22267a;
            ds0.a().b(fi5Var);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ei5<BaseNetBean<DeleteResBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f22269a;
        public final /* synthetic */ int b;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends TypeToken<BaseNetBean<DeleteResBean>> {
            public a() {
            }
        }

        public b(long j, int i) {
            this.f22269a = j;
            this.b = i;
        }

        @Override // defpackage.ei5
        public JSONObject genRequestParams() {
            HashMap map = new HashMap();
            map.put("version", Long.valueOf(this.f22269a));
            map.put("type", Integer.valueOf(this.b));
            return new JSONObject(map);
        }

        @Override // defpackage.ei5
        public BaseNetBean<DeleteResBean> handle(JSONObject jSONObject) {
            BaseNetBean<DeleteResBean> baseNetBeanCreateDefault = BaseNetBean.createDefault(jSONObject, new a().getType());
            if (!baseNetBeanCreateDefault.isSuccess()) {
                return baseNetBeanCreateDefault;
            }
            yt1 yt1Var = yt1.this;
            DeleteResBean deleteResBean = baseNetBeanCreateDefault.data;
            yt1Var.w = deleteResBean.version;
            if (deleteResBean.resIds != null && deleteResBean.resIds.size() > 0) {
                baseNetBeanCreateDefault.data.targetDelResIds = new HashSet<>();
                Iterator<Long> it = baseNetBeanCreateDefault.data.resIds.iterator();
                while (it.hasNext()) {
                    long jLongValue = it.next().longValue();
                    if (yt1.this.y.contains(Long.valueOf(jLongValue))) {
                        baseNetBeanCreateDefault.data.targetDelResIds.add(Long.valueOf(jLongValue));
                        yt1.this.y.remove(Long.valueOf(jLongValue));
                    }
                }
            }
            return baseNetBeanCreateDefault;
        }

        @Override // defpackage.ei5
        public void onPostExecute(BaseNetBean<DeleteResBean> baseNetBean) {
            if (baseNetBean.isSuccess()) {
                DeleteResBean deleteResBean = baseNetBean.data;
                if (deleteResBean.targetDelResIds == null || deleteResBean.targetDelResIds.isEmpty()) {
                    return;
                }
                qj5.r(baseNetBean.data.targetDelResIds);
                int i = 0;
                while (i < yt1.this.m.size()) {
                    try {
                        SquareFeed squareFeed = yt1.this.m.get(i);
                        if (baseNetBean.data.targetDelResIds.contains(Long.valueOf(squareFeed.id))) {
                            yt1.this.m.remove(i);
                            yt1.this.l.b(i, squareFeed);
                            i--;
                        }
                        i++;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements ei5<BaseNetBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SquareFeed f22271a;
        public final /* synthetic */ int b;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends TypeToken<BaseNetBean> {
            public a() {
            }
        }

        public c(SquareFeed squareFeed, int i) {
            this.f22271a = squareFeed;
            this.b = i;
        }

        @Override // defpackage.ei5
        public JSONObject genRequestParams() {
            HashMap map = new HashMap();
            map.put("feedId", Long.valueOf(this.f22271a.id));
            map.put("exFeedUid", this.f22271a.exid);
            map.put("random", System.currentTimeMillis() + "");
            return new JSONObject(map);
        }

        @Override // defpackage.ei5
        public BaseNetBean handle(JSONObject jSONObject) {
            return BaseNetBean.createDefault(jSONObject, new a().getType());
        }

        @Override // defpackage.ei5
        public void onPostExecute(BaseNetBean baseNetBean) {
            if (yt1.this.l == null) {
                return;
            }
            if (baseNetBean.isSuccess()) {
                SquareFeed squareFeed = this.f22271a;
                boolean z = squareFeed.ifLike;
                if (z) {
                    squareFeed.likeNums--;
                } else {
                    squareFeed.likeNums++;
                }
                squareFeed.ifLike = !z;
                yt1.this.l.c(this.b, squareFeed);
                SquareFeedEvent squareFeedEvent = new SquareFeedEvent();
                squareFeedEvent.eventType = 2;
                squareFeedEvent.feed = this.f22271a;
                an1.c().l(squareFeedEvent);
                return;
            }
            int i = baseNetBean.resultCode;
            if (i == 1008) {
                SquareFeed squareFeed2 = this.f22271a;
                squareFeed2.likeNums++;
                squareFeed2.ifLike = true;
                yt1.this.l.c(this.b, squareFeed2);
                return;
            }
            if (i != 1012) {
                if (i != 1006) {
                }
                yt1.this.l.d(baseNetBean.getErrMsg());
            } else {
                SquareFeed squareFeed3 = this.f22271a;
                squareFeed3.likeNums--;
                squareFeed3.ifLike = false;
                yt1.this.l.c(this.b, squareFeed3);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d extends TypeToken<BaseNetListBean<SquareFeed>> {
        public d() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements ei5<BaseNetListBean<SquareFeed>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f22274a;
        public final /* synthetic */ int b;
        public final /* synthetic */ ir c;

        public e(boolean z, int i, ir irVar) {
            this.f22274a = z;
            this.b = i;
            this.c = irVar;
        }

        @Override // defpackage.ei5
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BaseNetListBean<SquareFeed> handle(JSONObject jSONObject) {
            return yt1.this.O(jSONObject, this.f22274a);
        }

        /* JADX WARN: Type inference failed for: r0v29, types: [T, java.util.List<com.zenmen.square.mvp.model.bean.SquareFeed>] */
        /* JADX WARN: Type inference failed for: r0v71, types: [T, java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r1v4, types: [T, java.util.List<com.zenmen.square.mvp.model.bean.SquareFeed>] */
        @Override // defpackage.ei5
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(BaseNetListBean<SquareFeed> baseNetListBean) {
            ma3.a("onPostExecute " + yt1.this.t, new Object[0]);
            if (baseNetListBean.isSuccess()) {
                Parcelable parcelable = baseNetListBean.data;
                if (parcelable != null && ((List) parcelable).size() > 0) {
                    int i = 1;
                    for (SquareFeed squareFeed : (List) baseNetListBean.data) {
                        squareFeed.page = this.b;
                        squareFeed.pos = i;
                        squareFeed.reqId = baseNetListBean.requestId;
                        i++;
                    }
                    yt1.this.f1558a = ((List) baseNetListBean.data).size();
                }
                qj5.z(yt1.this.t, (List) baseNetListBean.data);
                if (this.f22274a) {
                    List<SquareFeed> list = yt1.this.m;
                    if (list == null || list.size() == 0) {
                        qj5.C(yt1.this.f, 1);
                    }
                    int i2 = yt1.this.f;
                    Parcelable parcelable2 = baseNetListBean.data;
                    qj5.x(i2, (parcelable2 == null || ((List) parcelable2).size() <= 0) ? 0 : 1, 1);
                    if (baseNetListBean.data == null) {
                        baseNetListBean.data = new ArrayList();
                    }
                    yt1 yt1Var = yt1.this;
                    List<SquareFeed> list2 = (List) baseNetListBean.data;
                    yt1Var.m = list2;
                    if (yt1Var.f == 1 && list2.size() > 0 && !yt1.this.m.get(0).isHeadTopic) {
                        VipEnterConfig.BaseVipConfig baseVipConfigB = com.zenmen.square.vip.a.c().b();
                        List<TopicListBean.Topic> listJ = xj5.h().j();
                        if (baseVipConfigB == null || TextUtils.isEmpty(baseVipConfigB.bannerBg) || TextUtils.isEmpty(baseVipConfigB.bannerUrl) || !(baseVipConfigB.priority == 1 || listJ == null || listJ.isEmpty())) {
                            SquareFeed squareFeed2 = new SquareFeed();
                            squareFeed2.isHeadTopic = true;
                            yt1.this.m.add(0, squareFeed2);
                        } else {
                            SquareFeed squareFeed3 = new SquareFeed();
                            squareFeed3.vipBannerBg = baseVipConfigB.bannerBg;
                            squareFeed3.vipBannerUrl = baseVipConfigB.bannerUrl;
                            squareFeed3.urlType = baseVipConfigB.urlType;
                            squareFeed3.isVipBanner = true;
                            yt1.this.m.add(0, squareFeed3);
                        }
                    }
                    if (yt1.this.f == 74) {
                        SquareSingleton.getInstance().getMessageCountManager().A(false);
                    }
                    if (yt1.this.f == 73) {
                        SquareSingleton.getInstance().getMessageCountManager().F(false);
                        SquareSingleton.getInstance().getMessageCountManager().E(false);
                    }
                    yt1 yt1Var2 = yt1.this;
                    if (yt1Var2.v) {
                        yt1Var2.v = false;
                        int i3 = yt1Var2.f;
                        if (i3 == 1) {
                            wh5.p(0);
                        } else if (i3 == 2) {
                            wh5.m(0);
                        } else if (i3 == 73) {
                            wh5.n(0);
                        } else if (i3 == 74) {
                            wh5.o(0);
                        }
                    } else {
                        int i4 = yt1Var2.f;
                        if (i4 == 1) {
                            wh5.x();
                        } else if (i4 == 2) {
                            wh5.u();
                        } else if (i4 == 73) {
                            wh5.v();
                        } else if (i4 == 74) {
                            wh5.w();
                        }
                    }
                } else {
                    Parcelable parcelable3 = baseNetListBean.data;
                    if (parcelable3 != null && ((List) parcelable3).size() > 0) {
                        int size = yt1.this.m.size();
                        yt1.this.m.addAll((Collection) baseNetListBean.data);
                        int i5 = yt1.this.f;
                        if (i5 == 1) {
                            wh5.p(size);
                        } else if (i5 == 2) {
                            wh5.m(size);
                        } else if (i5 == 73) {
                            wh5.n(size);
                        } else if (i5 == 74) {
                            wh5.o(size);
                        }
                    } else if (yt1.this.m.size() > 0) {
                        List<SquareFeed> list3 = yt1.this.m;
                        if (TextUtils.isEmpty(list3.get(list3.size() - 1).bottomTips)) {
                            SquareFeed squareFeed4 = new SquareFeed();
                            squareFeed4.bottomTips = "我也是有底线的";
                            yt1.this.m.add(squareFeed4);
                        }
                    }
                    baseNetListBean.data = yt1.this.m;
                }
                if (!this.f22274a) {
                    yt1.this.F();
                }
            } else {
                if (this.f22274a) {
                    List<SquareFeed> list4 = yt1.this.m;
                    if (list4 == null || list4.size() == 0) {
                        qj5.C(yt1.this.f, 0);
                    }
                    qj5.x(yt1.this.f, 0, 2);
                }
                yt1 yt1Var3 = yt1.this;
                baseNetListBean.data = yt1Var3.m;
                yt1Var3.r = yt1Var3.s;
            }
            this.c.a(baseNetListBean);
            yt1.this.c = 2;
        }

        @Override // defpackage.ei5
        public JSONObject genRequestParams() {
            ma3.a("genRequestParams " + yt1.this.t, new Object[0]);
            return this.f22274a ? yt1.this.b() : yt1.this.a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends TypeToken<ArrayList<SquareFeed>> {
        public f() {
        }
    }

    public yt1(String str, int i) {
        this.n = str;
        this.f = i;
        this.u = new xt1(this);
        an1.c().p(this.u);
        if (E()) {
            File file = new File(K());
            if (file.exists()) {
                return;
            }
            file.mkdirs();
        }
    }

    public void A(long j) {
        this.z.add(Long.valueOf(j));
    }

    @Override // defpackage.om2
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public void c(int i, SquareFeed squareFeed) {
        bi5.d(new a(squareFeed));
    }

    @Override // defpackage.om2
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public void g(int i, SquareFeed squareFeed) {
        if (squareFeed != null && squareFeed.adKey != null) {
            i = H(i, squareFeed);
            LogUtil.d("", "qqqSquareFeed deleteNative position " + i);
        }
        if (i >= this.m.size() || i < 0) {
            return;
        }
        this.m.remove(i);
        this.l.b(i, squareFeed);
    }

    public void D(int i, SquareFeed squareFeed, int i2, bi5.b<BaseNetBean<DislikeResp>> bVar) {
        bi5.m(bVar, squareFeed, i2);
    }

    public boolean E() {
        return false;
    }

    public final void F() {
        long j = this.x;
        if (j <= 0) {
            return;
        }
        long j2 = this.w;
        if (j <= j2) {
            return;
        }
        L(j2, 0);
    }

    public long G() {
        List<SquareFeed> list = this.m;
        if (list == null || list.size() <= 0) {
            return 0L;
        }
        for (int size = this.m.size() - 1; size >= 0; size--) {
            SquareFeed squareFeed = this.m.get(size);
            if (squareFeed.isNormalFeed()) {
                return squareFeed.version;
            }
        }
        return 0L;
    }

    public final int H(int i, SquareFeed squareFeed) {
        if (squareFeed != null) {
            try {
                if (this.m != null) {
                    for (int i2 = 0; i2 < this.m.size(); i2++) {
                        if (this.m.get(i2) == squareFeed) {
                            return i2;
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return i;
    }

    public String I() {
        return "";
    }

    public String J() {
        return K() + File.separator + I();
    }

    public String K() {
        String strE = v4.e(com.zenmen.palmchat.c.b());
        StringBuilder sb = new StringBuilder();
        sb.append(com.zenmen.palmchat.c.b().getFilesDir().getAbsolutePath());
        String str = File.separator;
        sb.append(str);
        sb.append(A);
        sb.append(str);
        sb.append(strE);
        return sb.toString();
    }

    public void L(long j, int i) {
        bi5.p("resource.del.get.v1", new b(j, i));
    }

    public void M(int i, SquareFeed squareFeed) {
        if (this.l != null) {
            this.m.add(i, squareFeed);
            this.l.e(i, squareFeed);
        }
    }

    public void N() {
        if (E()) {
            File file = new File(J());
            try {
                List<SquareFeed> list = (List) az2.b(ga3.f(file, "UTF-8"), new f().getType());
                if (list != null) {
                    this.m = list;
                    this.l.g(list);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                try {
                    if (file.exists()) {
                        file.delete();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public BaseNetListBean<SquareFeed> O(JSONObject jSONObject, boolean z) {
        String str;
        String str2;
        String str3;
        List<SquareFeed> list;
        BaseNetListBean<SquareFeed> baseNetListBeanCreateDefaultBean = BaseNetListBean.createDefaultBean(jSONObject, new d().getType());
        if (baseNetListBeanCreateDefaultBean != null && baseNetListBeanCreateDefaultBean.isSuccess() && baseNetListBeanCreateDefaultBean.data != null) {
            if (z || (list = this.m) == null || list.size() <= 0) {
                str = "";
                str2 = "";
                str3 = str2;
            } else {
                List<SquareFeed> list2 = this.m;
                str = list2.get(list2.size() - 1).month;
                List<SquareFeed> list3 = this.m;
                str2 = list3.get(list3.size() - 1).day;
                List<SquareFeed> list4 = this.m;
                str3 = list4.get(list4.size() - 1).year;
            }
            if (z) {
                this.y.clear();
            }
            for (SquareFeed squareFeed : (List) baseNetListBeanCreateDefaultBean.data) {
                ContactInfoItem contactInfoItemB = dn0.b(squareFeed.exid);
                String nameForShow = contactInfoItemB != null ? contactInfoItemB.getNameForShow() : null;
                if (!TextUtils.isEmpty(nameForShow)) {
                    squareFeed.nickname = nameForShow;
                }
                String[] strArrI = cy5.i(squareFeed.createTime);
                squareFeed.year = strArrI[0];
                String str4 = strArrI[1];
                squareFeed.month = str4;
                squareFeed.day = strArrI[2];
                squareFeed.showBigDate = (TextUtils.equals(str4, str) && TextUtils.equals(squareFeed.day, str2) && TextUtils.equals(squareFeed.year, str3)) ? false : true;
                str = squareFeed.month;
                str2 = squareFeed.day;
                str3 = squareFeed.year;
                squareFeed.reqId = baseNetListBeanCreateDefaultBean.requestId;
                if (this.f == 1) {
                    this.y.add(Long.valueOf(squareFeed.id));
                }
                SquareSingleton.getInstance().checkUpdate(squareFeed);
            }
            if (E()) {
                int i = this.f;
                if (i == 1) {
                    if (((List) baseNetListBeanCreateDefaultBean.data).size() >= 5) {
                        Q(az2.c(baseNetListBeanCreateDefaultBean.data));
                    }
                } else if (i == 74 && z && ((List) baseNetListBeanCreateDefaultBean.data).size() > 0) {
                    Q(az2.c(baseNetListBeanCreateDefaultBean.data));
                }
            }
        }
        return baseNetListBeanCreateDefaultBean;
    }

    public void P(int i, SquareFeed squareFeed, int i2) {
        int i3 = this.f;
        qj5.d0(squareFeed, i3, i3, i2);
        bi5.c(squareFeed.ifLike, new c(squareFeed, i));
    }

    public void Q(String str) {
        if (E()) {
            ga3.g(new File(J()).getAbsolutePath(), str, "UTF-8");
        }
    }

    public void R(km2 km2Var) {
        this.l = km2Var;
    }

    public void S(String str) {
        this.p = str;
        this.q = 0;
    }

    public void Y0(SquareFeedEvent squareFeedEvent) {
        SquareFeed squareFeed;
        if (this.m == null || (squareFeed = squareFeedEvent.feed) == null) {
            return;
        }
        if (squareFeedEvent.eventType == 4) {
            int i = this.f;
            if (i == 6 || i == 7) {
                M(0, squareFeed);
                return;
            }
            return;
        }
        for (int i2 = 0; i2 < this.m.size(); i2++) {
            SquareFeed squareFeed2 = this.m.get(i2);
            long j = squareFeed2.id;
            SquareFeed squareFeed3 = squareFeedEvent.feed;
            if (j == squareFeed3.id) {
                int i3 = squareFeedEvent.eventType;
                if (i3 == 2) {
                    if (squareFeed2.mergeByNewUpdate(squareFeed3)) {
                        this.l.c(i2, squareFeed2);
                    }
                } else if (i3 == 3) {
                    this.m.remove(squareFeed2);
                    this.l.b(i2, squareFeed2);
                    if (this.m.size() == 1 && !TextUtils.isEmpty(this.m.get(0).bottomTips)) {
                        this.l.b(0, this.m.remove(0));
                        return;
                    }
                } else {
                    continue;
                }
            }
        }
    }

    @Override // defpackage.om2
    public void d(ir<BaseNetListBean<SquareFeed>> irVar) {
        x(false, irVar);
    }

    @Override // defpackage.om2
    public void destroy() {
        an1.c().r(this.u);
    }

    @Override // defpackage.om2
    public List<SquareFeed> e() {
        return this.m;
    }

    @Override // defpackage.om2
    public void f(ir<BaseNetListBean<SquareFeed>> irVar) {
        x(true, irVar);
    }

    @Override // defpackage.ar
    public boolean i() {
        return false;
    }

    @Override // defpackage.br
    public boolean u() {
        return false;
    }

    @Override // defpackage.br
    public void w(boolean z, ir<BaseNetListBean<SquareFeed>> irVar) {
        if (z) {
            this.o = UUID.randomUUID().toString().replace("-", "");
            this.q++;
            this.s = this.r;
            this.r = 1;
        } else {
            int i = this.r;
            this.s = i;
            this.r = i + 1;
        }
        String strA = xn3.a();
        this.t = strA;
        qj5.y(strA, this.r, this.f, this.o, this.q, this.p);
        bi5.l(this.n, new e(z, this.r, irVar), this.r, this.t);
    }
}
