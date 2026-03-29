package defpackage;

import com.google.gson.reflect.TypeToken;
import com.zenmen.listui.list.BaseNetBean;
import com.zenmen.listui.list.BaseNetListBean;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.d;
import com.zenmen.square.mvp.model.bean.InteractMessageResp;
import com.zenmen.square.mvp.model.bean.SquareInteractBean;
import com.zenmen.square.mvp.model.bean.SquareInteractDetail;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class xt2 extends xi5 {
    public long e;
    public int f;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ei5<BaseNetListBean<SquareInteractBean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f22046a;
        public final /* synthetic */ ir b;

        /* JADX INFO: renamed from: xt2$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1288a extends TypeToken<BaseNetBean<InteractMessageResp>> {
            public C1288a() {
            }
        }

        public a(boolean z, ir irVar) {
            this.f22046a = z;
            this.b = irVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [T, java.util.ArrayList] */
        @Override // defpackage.ei5
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BaseNetListBean<SquareInteractBean> handle(JSONObject jSONObject) {
            BaseNetBean baseNetBeanCreateDefault = BaseNetBean.createDefault(jSONObject, new C1288a().getType());
            BaseNetListBean<SquareInteractBean> baseNetListBean = new BaseNetListBean<>();
            baseNetListBean.resultCode = baseNetBeanCreateDefault.resultCode;
            baseNetListBean.errorMsg = baseNetBeanCreateDefault.errorMsg;
            baseNetListBean.data = new ArrayList();
            if (baseNetBeanCreateDefault.isSuccess()) {
                T t = baseNetBeanCreateDefault.data;
                if (((InteractMessageResp) t).singleNoticeRespDOList != null && ((InteractMessageResp) t).singleNoticeRespDOList.size() > 0) {
                    for (SquareInteractDetail squareInteractDetail : ((InteractMessageResp) baseNetBeanCreateDefault.data).singleNoticeRespDOList) {
                        ContactInfoItem contactInfoItemB = dn0.b(squareInteractDetail.exFromUid);
                        if (contactInfoItemB != null) {
                            if (!contactInfoItemB.getIsStranger()) {
                                squareInteractDetail.isFriend = true;
                            }
                            squareInteractDetail.nickname = contactInfoItemB.getNameForShow();
                        }
                        SquareInteractBean squareInteractBean = new SquareInteractBean();
                        squareInteractBean.ifAggregation = false;
                        squareInteractBean.singleInteract = squareInteractDetail;
                        ((List) baseNetListBean.data).add(squareInteractBean);
                    }
                    if (!((InteractMessageResp) baseNetBeanCreateDefault.data).ifHasMore) {
                        SquareInteractBean squareInteractBean2 = new SquareInteractBean();
                        squareInteractBean2.bottomTips = "已加载全部";
                        ((List) baseNetListBean.data).add(squareInteractBean2);
                    }
                }
            }
            return baseNetListBean;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [T, java.util.List<com.zenmen.square.mvp.model.bean.SquareInteractBean>] */
        @Override // defpackage.ei5
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(BaseNetListBean<SquareInteractBean> baseNetListBean) {
            if (baseNetListBean.isSuccess()) {
                if (this.f22046a) {
                    xt2.this.c.clear();
                }
                xt2.this.c.addAll((Collection) baseNetListBean.data);
            }
            baseNetListBean.data = xt2.this.c;
            this.b.a(baseNetListBean);
        }

        @Override // defpackage.ei5
        public JSONObject genRequestParams() {
            return xt2.this.m(this.f22046a);
        }
    }

    public xt2(long j, int i) {
        this.e = j;
        this.f = i;
    }

    @Override // defpackage.xi5
    public JSONObject m(boolean z) {
        long j;
        HashMap map = new HashMap();
        if (z) {
            j = 0;
        } else {
            j = this.c.get(r6.size() - 1).singleInteract.version;
        }
        map.put("id", Long.valueOf(this.e));
        map.put("noticeType", Integer.valueOf(this.f));
        map.put("version", Long.valueOf(j));
        LocationEx locationExI = d.g().i(86400000L);
        if (locationExI != null) {
            map.put("longitude", locationExI.getLongitude() + "");
            map.put("latitude", locationExI.getLatitude() + "");
        }
        return new JSONObject(map);
    }

    @Override // defpackage.xi5
    public void n(boolean z, ir<BaseNetListBean<SquareInteractBean>> irVar) {
        bi5.p("square.single.notice.list.v8", new a(z, irVar));
    }
}
