package defpackage;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.gson.reflect.TypeToken;
import com.zenmen.listui.list.BaseNetBean;
import com.zenmen.listui.list.BaseNetListBean;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.friendcircle.netdao.NetResponseData;
import com.zenmen.palmchat.greendao.model.Feed;
import com.zenmen.square.R$string;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class wq3 extends tb4<Feed> {
    public String i;
    public Bundle j;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ei5<BaseNetListBean<Feed>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ir f21781a;

        public a(ir irVar) {
            this.f21781a = irVar;
        }

        @Override // defpackage.ei5
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BaseNetListBean<Feed> handle(JSONObject jSONObject) {
            return wq3.this.w(jSONObject);
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [T, java.util.List] */
        @Override // defpackage.ei5
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(BaseNetListBean<Feed> baseNetListBean) {
            if (baseNetListBean.isSuccess()) {
                Parcelable parcelable = baseNetListBean.data;
                if (parcelable == null || ((List) parcelable).size() <= 0) {
                    wq3.this.g = false;
                } else {
                    Iterator it = ((List) baseNetListBean.data).iterator();
                    while (it.hasNext()) {
                        ((Feed) it.next()).reqId = baseNetListBean.requestId;
                    }
                    wq3.this.f20952a.addAll((Collection) baseNetListBean.data);
                }
            }
            baseNetListBean.data = wq3.this.f20952a;
            this.f21781a.a(baseNetListBean);
            wq3.this.c = 2;
        }

        @Override // defpackage.ei5
        public JSONObject genRequestParams() {
            return wq3.this.a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends TypeToken<BaseNetBean<NetResponseData>> {
        public b() {
        }
    }

    public wq3(int i, String str, Bundle bundle) {
        this.i = str;
        this.h = i;
        this.j = bundle;
    }

    @Override // defpackage.om2
    public JSONObject a() {
        return !hx3.m(c.b()) ? k(c.b().getString(R$string.square_network_error)) : new JSONObject();
    }

    @Override // defpackage.tb4
    public void o(ir<BaseNetListBean<Feed>> irVar) {
        bi5.p(this.i, new a(irVar));
    }

    public Feed v() {
        List<T> list = this.f20952a;
        if (list != 0 && list.size() > 0) {
            for (int size = this.f20952a.size() - 1; size >= 0; size--) {
                Feed feed = (Feed) this.f20952a.get(size);
                if (feed.getFeedType() == 2 || feed.getFeedType() == 3) {
                    return feed;
                }
            }
        }
        return new Feed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [T, java.util.List<com.zenmen.palmchat.greendao.model.Feed>] */
    public BaseNetListBean<Feed> w(JSONObject jSONObject) {
        BaseNetBean baseNetBeanCreateDefault = BaseNetBean.createDefault(jSONObject, new b().getType());
        if (baseNetBeanCreateDefault == null) {
            return null;
        }
        BaseNetListBean<Feed> baseNetListBean = new BaseNetListBean<>();
        baseNetListBean.resultCode = baseNetBeanCreateDefault.resultCode;
        baseNetListBean.errorMsg = baseNetBeanCreateDefault.errorMsg;
        T t = baseNetBeanCreateDefault.data;
        if (t != 0) {
            baseNetListBean.data = ((NetResponseData) t).feeds;
        }
        return baseNetListBean;
    }
}
