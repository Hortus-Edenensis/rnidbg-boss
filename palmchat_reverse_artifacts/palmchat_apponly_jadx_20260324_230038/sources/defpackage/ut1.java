package defpackage;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.gson.reflect.TypeToken;
import com.zenmen.listui.list.BaseNetListBean;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.d;
import com.zenmen.square.R$string;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.support.SquareSingleton;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ut1 extends tb4<SquareFeed> {
    public String i;
    public Bundle j;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ei5<BaseNetListBean<SquareFeed>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21286a;
        public final /* synthetic */ ir b;

        public a(int i, ir irVar) {
            this.f21286a = i;
            this.b = irVar;
        }

        @Override // defpackage.ei5
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BaseNetListBean<SquareFeed> handle(JSONObject jSONObject) {
            return ut1.this.A(jSONObject);
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [T, java.util.List] */
        @Override // defpackage.ei5
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(BaseNetListBean<SquareFeed> baseNetListBean) {
            if (baseNetListBean.isSuccess()) {
                SquareFeed squareFeed = ut1.this.f20952a.size() > 0 ? (SquareFeed) ut1.this.f20952a.get(0) : null;
                Parcelable parcelable = baseNetListBean.data;
                if (parcelable == null || ((List) parcelable).size() <= 0) {
                    ut1.this.g = false;
                } else {
                    Iterator it = ((List) baseNetListBean.data).iterator();
                    int i = 1;
                    while (it.hasNext()) {
                        SquareFeed squareFeed2 = (SquareFeed) it.next();
                        if (squareFeed == null || squareFeed.id != squareFeed2.id) {
                            squareFeed2.page = this.f21286a;
                            squareFeed2.pos = i;
                            squareFeed2.reqId = baseNetListBean.requestId;
                            i++;
                        } else {
                            it.remove();
                        }
                    }
                    ut1.this.f20952a.addAll((Collection) baseNetListBean.data);
                }
            } else {
                ut1 ut1Var = ut1.this;
                ut1Var.d = ut1Var.e;
            }
            baseNetListBean.data = ut1.this.f20952a;
            this.b.a(baseNetListBean);
            ut1.this.c = 2;
        }

        @Override // defpackage.ei5
        public JSONObject genRequestParams() {
            return ut1.this.a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends TypeToken<BaseNetListBean<SquareFeed>> {
        public b() {
        }
    }

    public ut1(int i, String str, Bundle bundle) {
        this.i = str;
        this.h = i;
        this.j = bundle;
    }

    public BaseNetListBean<SquareFeed> A(JSONObject jSONObject) {
        Parcelable parcelable;
        BaseNetListBean<SquareFeed> baseNetListBeanCreateDefaultBean = BaseNetListBean.createDefaultBean(jSONObject, new b().getType());
        if (baseNetListBeanCreateDefaultBean != null && baseNetListBeanCreateDefaultBean.isSuccess() && (parcelable = baseNetListBeanCreateDefaultBean.data) != null) {
            for (SquareFeed squareFeed : (List) parcelable) {
                ContactInfoItem contactInfoItemB = dn0.b(squareFeed.exid);
                String nameForShow = contactInfoItemB != null ? contactInfoItemB.getNameForShow() : null;
                if (!TextUtils.isEmpty(nameForShow)) {
                    squareFeed.nickname = nameForShow;
                }
                squareFeed.reqId = baseNetListBeanCreateDefaultBean.requestId;
                SquareSingleton.getInstance().checkUpdate(squareFeed);
            }
        }
        return baseNetListBeanCreateDefaultBean;
    }

    @Override // defpackage.om2
    public JSONObject a() {
        if (!hx3.m(c.b())) {
            return k(c.b().getString(R$string.square_network_error));
        }
        JSONObject jSONObject = new JSONObject();
        try {
            LocationEx locationExI = d.g().i(86400000L);
            if (locationExI != null) {
                jSONObject.put("longitude", locationExI.getLongitude() + "");
                jSONObject.put("latitude", locationExI.getLatitude() + "");
                if (locationExI.getCityCode() != null) {
                    jSONObject.put("cityCode", locationExI.getCityCode());
                }
            }
            jSONObject.put("reqId", this.f);
            jSONObject.put("page", this.d);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    @Override // defpackage.tb4
    public void o(ir<BaseNetListBean<SquareFeed>> irVar) {
        this.f = xn3.a();
        int i = this.d;
        this.e = i;
        int i2 = i + 1;
        this.d = i2;
        bi5.l(this.i, new a(i2, irVar), this.d, this.f);
    }

    public SquareFeed z() {
        List<T> list = this.f20952a;
        if (list != 0 && list.size() > 0) {
            for (int size = this.f20952a.size() - 1; size >= 0; size--) {
                SquareFeed squareFeed = (SquareFeed) this.f20952a.get(size);
                if (squareFeed.isNormalFeed()) {
                    return squareFeed;
                }
            }
        }
        return new SquareFeed();
    }
}
