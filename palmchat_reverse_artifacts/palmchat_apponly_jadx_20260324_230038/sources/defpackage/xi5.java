package defpackage;

import com.google.gson.reflect.TypeToken;
import com.zenmen.listui.list.BaseNetBean;
import com.zenmen.listui.list.BaseNetListBean;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.d;
import com.zenmen.square.mvp.model.bean.SquareInteractBean;
import com.zenmen.square.mvp.model.bean.SquareInteractDetail;
import com.zenmen.square.mvp.model.bean.SquareInteractNestResp;
import com.zenmen.square.support.SquareSingleton;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class xi5 extends ar<SquareInteractBean> {
    public List<SquareInteractBean> c = new ArrayList();
    public int d = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ei5<BaseNetListBean<SquareInteractBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f21968a;
        public final /* synthetic */ ir b;

        /* JADX INFO: renamed from: xi5$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1286a extends TypeToken<BaseNetBean<SquareInteractNestResp>> {
            public C1286a() {
            }
        }

        public a(boolean z, ir irVar) {
            this.f21968a = z;
            this.b = irVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v9, types: [T, java.util.List<com.zenmen.square.mvp.model.bean.SquareInteractBean>] */
        /* JADX WARN: Type inference failed for: r2v4, types: [T, java.util.ArrayList] */
        @Override // defpackage.ei5
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BaseNetListBean<SquareInteractBean> handle(JSONObject jSONObject) {
            BaseNetBean baseNetBeanCreateDefault = BaseNetBean.createDefault(jSONObject, new C1286a().getType());
            BaseNetListBean<SquareInteractBean> baseNetListBean = new BaseNetListBean<>();
            if (baseNetBeanCreateDefault.isSuccess()) {
                T t = baseNetBeanCreateDefault.data;
                if (t != 0) {
                    ?? r1 = ((SquareInteractNestResp) t).aggregationNoticeRespDOList;
                    baseNetListBean.data = r1;
                    if (r1 != 0 && ((List) r1).size() > 0) {
                        for (SquareInteractBean squareInteractBean : (List) baseNetListBean.data) {
                            List<SquareInteractDetail> list = squareInteractBean.singleNoticeList;
                            if (list != null && list.size() > 0) {
                                SquareInteractDetail squareInteractDetail = squareInteractBean.singleNoticeList.get(0);
                                ContactInfoItem contactInfoItemB = dn0.b(squareInteractDetail.exFromUid);
                                if (contactInfoItemB != null) {
                                    if (!contactInfoItemB.getIsStranger()) {
                                        squareInteractDetail.isFriend = true;
                                    }
                                    squareInteractDetail.nickname = contactInfoItemB.getNameForShow();
                                }
                                squareInteractBean.singleInteract = squareInteractDetail;
                            }
                        }
                    }
                }
                T t2 = baseNetBeanCreateDefault.data;
                if (t2 == 0 || (!((SquareInteractNestResp) t2).ifHasMore && ((SquareInteractNestResp) t2).aggregationNoticeRespDOList != null && ((SquareInteractNestResp) t2).aggregationNoticeRespDOList.size() > 0)) {
                    SquareInteractBean squareInteractBean2 = new SquareInteractBean();
                    squareInteractBean2.bottomTips = "已加载全部";
                    if (baseNetListBean.data == null) {
                        baseNetListBean.data = new ArrayList();
                    }
                    ((List) baseNetListBean.data).add(squareInteractBean2);
                }
            }
            baseNetListBean.errorMsg = baseNetBeanCreateDefault.errorMsg;
            baseNetListBean.resultCode = baseNetBeanCreateDefault.resultCode;
            return baseNetListBean;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [T, java.util.List<com.zenmen.square.mvp.model.bean.SquareInteractBean>] */
        @Override // defpackage.ei5
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(BaseNetListBean<SquareInteractBean> baseNetListBean) {
            if (baseNetListBean.isSuccess()) {
                if (this.f21968a) {
                    xi5.this.c.clear();
                    xi5.this.c.addAll((Collection) baseNetListBean.data);
                } else {
                    xi5.this.c.addAll((Collection) baseNetListBean.data);
                }
                SquareSingleton.getInstance().setLastCommentUnReadCount(0);
                SquareSingleton.getInstance().setLastPraiseUnReadCount(0);
            }
            baseNetListBean.data = xi5.this.c;
            this.b.a(baseNetListBean);
        }

        @Override // defpackage.ei5
        public JSONObject genRequestParams() {
            return this.f21968a ? xi5.this.b() : xi5.this.a();
        }
    }

    @Override // defpackage.om2
    public JSONObject a() {
        return m(false);
    }

    @Override // defpackage.om2
    public JSONObject b() {
        return m(true);
    }

    @Override // defpackage.om2
    public void d(ir<BaseNetListBean<SquareInteractBean>> irVar) {
        n(false, irVar);
    }

    @Override // defpackage.om2
    public List<SquareInteractBean> e() {
        return this.c;
    }

    @Override // defpackage.om2
    public void f(ir<BaseNetListBean<SquareInteractBean>> irVar) {
        n(true, irVar);
    }

    @Override // defpackage.ar
    public boolean i() {
        return false;
    }

    public final SquareInteractBean l() {
        List<SquareInteractBean> list = this.c;
        SquareInteractBean squareInteractBean = null;
        if (list != null && list.size() > 0) {
            for (SquareInteractBean squareInteractBean2 : this.c) {
                if (squareInteractBean == null || (!squareInteractBean.isBottomTip() && squareInteractBean2.version < squareInteractBean.version)) {
                    squareInteractBean = squareInteractBean2;
                }
            }
        }
        return squareInteractBean;
    }

    public JSONObject m(boolean z) {
        boolean z2;
        long j;
        long j2;
        SquareInteractBean squareInteractBeanL;
        HashMap map = new HashMap();
        if (z || (squareInteractBeanL = l()) == null) {
            z2 = false;
            j = 0;
            j2 = 0;
        } else {
            long j3 = squareInteractBeanL.id;
            j2 = squareInteractBeanL.version;
            z2 = squareInteractBeanL.ifAggregation;
            SquareInteractDetail squareInteractDetail = squareInteractBeanL.singleInteract;
            j = j3;
            j = squareInteractDetail != null ? squareInteractDetail.version : 0L;
        }
        map.put("aggregationId", Long.valueOf(j));
        map.put("aggregationVersion", Long.valueOf(j2));
        map.put("ifAggregation", Boolean.valueOf(z2));
        map.put("singleVersion", Long.valueOf(j));
        LocationEx locationExI = d.g().i(86400000L);
        if (locationExI != null) {
            map.put("longitude", locationExI.getLongitude() + "");
            map.put("latitude", locationExI.getLatitude() + "");
        }
        return new JSONObject(map);
    }

    public void n(boolean z, ir<BaseNetListBean<SquareInteractBean>> irVar) {
        bi5.p("square.aggregation.notice.list.v8", new a(z, irVar));
    }

    @Override // defpackage.om2
    public void destroy() {
    }

    @Override // defpackage.om2
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public void c(int i, SquareInteractBean squareInteractBean) {
    }

    @Override // defpackage.om2
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public void g(int i, SquareInteractBean squareInteractBean) {
    }
}
