package defpackage;

import com.google.gson.reflect.TypeToken;
import com.zenmen.listui.list.BaseNetBean;
import com.zenmen.listui.list.BaseNetListBean;
import com.zenmen.square.mvp.model.bean.NestTopicResp;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class gw3 extends au4 {
    public long E;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends TypeToken<BaseNetBean<NestTopicResp>> {
        public a() {
        }
    }

    public gw3(String str, long j, int i) {
        super(str, i);
        this.E = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [T, java.util.List<com.zenmen.square.mvp.model.bean.SquareFeed>] */
    @Override // defpackage.au4, defpackage.yt1
    public BaseNetListBean<SquareFeed> O(JSONObject jSONObject, boolean z) {
        BaseNetBean baseNetBeanCreateDefault = BaseNetBean.createDefault(jSONObject, new a().getType());
        BaseNetListBean<SquareFeed> baseNetListBean = new BaseNetListBean<>();
        baseNetListBean.resultCode = baseNetBeanCreateDefault.resultCode;
        baseNetListBean.errorMsg = baseNetBeanCreateDefault.errorMsg;
        T t = baseNetBeanCreateDefault.data;
        if (t != 0) {
            baseNetListBean.data = ((NestTopicResp) t).feeds;
        }
        if (baseNetBeanCreateDefault.isSuccess() && z) {
            ((NestTopicResp) baseNetBeanCreateDefault.data).feeds = null;
            an1.c().l(baseNetBeanCreateDefault.data);
        }
        return baseNetListBean;
    }

    @Override // defpackage.au4, defpackage.om2
    public JSONObject a() {
        JSONObject jSONObjectA = super.a();
        try {
            jSONObjectA.put("topicId", this.E);
            jSONObjectA.put("index", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObjectA;
    }

    @Override // defpackage.au4, defpackage.om2
    public JSONObject b() {
        JSONObject jSONObjectB = super.b();
        try {
            jSONObjectB.put("topicId", this.E);
            jSONObjectB.put("index", 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObjectB;
    }
}
