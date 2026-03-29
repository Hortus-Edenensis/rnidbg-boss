package defpackage;

import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.zenmen.listui.list.BaseNetBean;
import com.zenmen.listui.list.BaseNetListBean;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.square.R$string;
import com.zenmen.square.bean.req.FeedsReqBean;
import com.zenmen.square.mvp.model.bean.RecommendResp;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class au4 extends yt1 {
    public long B;
    public String C;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends TypeToken<BaseNetBean<RecommendResp>> {
        public a() {
        }
    }

    public au4(String str, int i) {
        super(str, i);
    }

    @Override // defpackage.yt1
    public boolean E() {
        return true;
    }

    @Override // defpackage.yt1
    public String I() {
        return "recommend";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v16, types: [T, java.util.List<com.zenmen.square.mvp.model.bean.SquareFeed>] */
    @Override // defpackage.yt1
    public BaseNetListBean<SquareFeed> O(JSONObject jSONObject, boolean z) {
        BaseNetBean baseNetBeanCreateDefault = BaseNetBean.createDefault(jSONObject, new a().getType());
        BaseNetListBean<SquareFeed> baseNetListBean = new BaseNetListBean<>();
        baseNetListBean.resultCode = baseNetBeanCreateDefault.resultCode;
        baseNetListBean.errorMsg = baseNetBeanCreateDefault.errorMsg;
        T t = baseNetBeanCreateDefault.data;
        if (t != 0) {
            baseNetListBean.data = ((RecommendResp) t).feeds;
        }
        if (baseNetListBean.data != null) {
            int iK = gi5.k();
            i25 i25VarN = gi5.n();
            if (iK >= 0 && iK < ((List) baseNetListBean.data).size()) {
                ((SquareFeed) ((List) baseNetListBean.data).get(iK)).showPraiseGuide = true;
            }
            if (i25VarN.c() && i25VarN.b() <= ((List) baseNetListBean.data).size()) {
                ((SquareFeed) ((List) baseNetListBean.data).get(i25VarN.b() - 1)).guideSayHiText = i25VarN.a();
            }
        }
        try {
            BaseNetListBean<SquareFeed> baseNetListBeanO = super.O(new JSONObject(az2.c(baseNetListBean)), z);
            if (baseNetListBeanO == null) {
                return baseNetListBean;
            }
            if (baseNetBeanCreateDefault.isSuccess()) {
                T t2 = baseNetBeanCreateDefault.data;
                this.x = ((RecommendResp) t2).resVersion;
                if (z) {
                    this.w = ((RecommendResp) t2).resVersion;
                }
                if (t2 != 0 && ((RecommendResp) t2).discussionalTopics != null && ((RecommendResp) t2).discussionalTopics.list != null && ((RecommendResp) t2).discussionalTopics.list.size() > 0 && z) {
                    SquareFeed squareFeed = new SquareFeed();
                    squareFeed.custom = true;
                    T t3 = baseNetBeanCreateDefault.data;
                    squareFeed.discussionalTopics = ((RecommendResp) t3).discussionalTopics.list;
                    squareFeed.recommendTopicTitle = ((RecommendResp) t3).discussionalTopics.recommendTopicTitle;
                    squareFeed.recommendTopicIcon = ((RecommendResp) t3).discussionalTopics.recommendTopicIcon;
                    squareFeed.sid = this.C;
                    V(squareFeed, ((RecommendResp) t3).discussionalTopics.index, (List) baseNetListBeanO.data);
                }
            }
            return baseNetListBeanO;
        } catch (JSONException e) {
            e.printStackTrace();
            return new BaseNetListBean<>();
        }
    }

    public JSONObject T(boolean z) {
        ContactInfoItem contactInfoItemA;
        if (!hx3.m(c.b())) {
            return m(c.b().getString(R$string.square_network_error));
        }
        FeedsReqBean feedsReqBean = new FeedsReqBean();
        String strE = v4.e(c.b());
        if (!TextUtils.isEmpty(strE) && (contactInfoItemA = dn0.a(strE)) != null) {
            feedsReqBean.sex = contactInfoItemA.getGender();
        }
        if (!z || this.v) {
            feedsReqBean.unreadActivities = new ArrayList();
        } else {
            feedsReqBean.unreadActivities = U();
        }
        if (z || this.B == 0) {
            this.B = System.currentTimeMillis() / 100;
        }
        feedsReqBean.pageKey = this.B + "";
        feedsReqBean.page = this.r;
        feedsReqBean.reqId = this.t;
        if (this.d != null) {
            feedsReqBean.latitude = this.d.getLatitude() + "";
            feedsReqBean.longitude = this.d.getLongitude() + "";
            feedsReqBean.cityCode = this.d.getCityCode();
        }
        feedsReqBean.pandaValueLx62476 = WkAdxAdConfigMg.DSP_NAME_CSJ;
        try {
            return new JSONObject(az2.c(feedsReqBean));
        } catch (JSONException e) {
            e.printStackTrace();
            return m("请求失败");
        }
    }

    public List<FeedsReqBean.UnReadFeedBean> U() {
        ArrayList arrayList = new ArrayList();
        try {
            for (SquareFeed squareFeed : this.m) {
                if (squareFeed.isNormalFeed()) {
                    long j = squareFeed.id;
                    if (j > 0 && !this.z.contains(Long.valueOf(j))) {
                        FeedsReqBean.UnReadFeedBean unReadFeedBean = new FeedsReqBean.UnReadFeedBean();
                        unReadFeedBean.feedId = squareFeed.id;
                        unReadFeedBean.exid = squareFeed.exid;
                        arrayList.add(unReadFeedBean);
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return arrayList;
    }

    public final void V(SquareFeed squareFeed, int i, List<SquareFeed> list) {
        if (list != null) {
            if (i <= 0) {
                list.add(list.size(), squareFeed);
                return;
            }
            int i2 = 0;
            int i3 = 0;
            while (i2 < list.size() && (list.get(i2).custom || (i3 = i3 + 1) != i)) {
                i2++;
            }
            list.add(i2, squareFeed);
        }
    }

    @Override // defpackage.om2
    public JSONObject a() {
        return T(false);
    }

    @Override // defpackage.om2
    public JSONObject b() {
        return T(true);
    }

    @Override // defpackage.br
    public boolean t() {
        return true;
    }

    @Override // defpackage.yt1, defpackage.br
    public boolean u() {
        return false;
    }

    public au4(String str, int i, String str2) {
        super(str, i);
        this.C = str2;
    }
}
