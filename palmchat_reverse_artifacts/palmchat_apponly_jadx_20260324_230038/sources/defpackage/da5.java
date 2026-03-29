package defpackage;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.reflect.TypeToken;
import com.zenmen.listui.list.BaseNetListBean;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.d;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.R$string;
import com.zenmen.square.mvp.model.bean.Media;
import com.zenmen.square.mvp.model.bean.SquareFeed;
import com.zenmen.square.support.SquareSingleton;
import defpackage.ei5;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class da5 extends tb4<SquareFeed> {
    public String i;
    public Bundle j;
    public boolean k = true;
    public long l = System.currentTimeMillis() / 100;
    public ArrayList<Long> m = new ArrayList<>();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ei5<BaseNetListBean<SquareFeed>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f17005a;
        public final /* synthetic */ int b;
        public final /* synthetic */ ir c;

        public a(boolean z, int i, ir irVar) {
            this.f17005a = z;
            this.b = i;
            this.c = irVar;
        }

        @Override // defpackage.ei5
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BaseNetListBean<SquareFeed> handle(JSONObject jSONObject) {
            return da5.this.I(jSONObject);
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [T, java.util.List] */
        @Override // defpackage.ei5
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(BaseNetListBean<SquareFeed> baseNetListBean) {
            if (baseNetListBean.isSuccess()) {
                SquareFeed squareFeed = da5.this.f20952a.size() > 0 ? (SquareFeed) da5.this.f20952a.get(0) : null;
                Parcelable parcelable = baseNetListBean.data;
                if (parcelable == null || ((List) parcelable).size() <= 0) {
                    da5.this.g = false;
                } else {
                    Iterator it = ((List) baseNetListBean.data).iterator();
                    int i = 1;
                    while (it.hasNext()) {
                        SquareFeed squareFeed2 = (SquareFeed) it.next();
                        if (squareFeed == null || squareFeed.id != squareFeed2.id) {
                            squareFeed2.page = this.b;
                            squareFeed2.pos = i;
                            squareFeed2.reqId = baseNetListBean.requestId;
                            i++;
                        } else {
                            it.remove();
                        }
                    }
                    if (this.f17005a) {
                        da5.this.f20952a = (List) baseNetListBean.data;
                    } else {
                        da5.this.f20952a.addAll((Collection) baseNetListBean.data);
                    }
                }
            } else {
                da5 da5Var = da5.this;
                da5Var.d = da5Var.e;
            }
            baseNetListBean.data = da5.this.f20952a;
            this.c.a(baseNetListBean);
            da5.this.c = 2;
        }

        @Override // defpackage.ei5
        public JSONObject genRequestParams() {
            JSONObject jSONObjectB = this.f17005a ? da5.this.b() : da5.this.a();
            if (this.f17005a) {
                aw awVarB = aw.b(jSONObjectB);
                if (da5.this.k) {
                    da5.this.k = false;
                } else {
                    awVarB.e = false;
                }
                ei5.a.a(jSONObjectB, awVarB);
            }
            return jSONObjectB;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends TypeToken<BaseNetListBean<SquareFeed>> {
        public b() {
        }
    }

    public da5(int i, String str, Bundle bundle) {
        this.i = str;
        this.h = i;
        this.j = bundle;
    }

    public final JSONObject C(boolean z) {
        ContactInfoItem contactInfoItemA;
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
            jSONObject.put("page", z ? 0 : this.d);
            String strE = v4.e(c.b());
            if (!TextUtils.isEmpty(strE) && (contactInfoItemA = dn0.a(strE)) != null) {
                jSONObject.put("sex", contactInfoItemA.getGender());
            }
            jSONObject.put("pageKey", this.l);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public final void D(int i) {
        LogUtil.i("ShowPagerListModel", "cacheItem " + i);
        try {
            SquareFeed squareFeed = (SquareFeed) this.f20952a.get(i);
            if (squareFeed != null) {
                Iterator<Media> it = squareFeed.mediaList.iterator();
                while (it.hasNext()) {
                    Glide.with(c.b()).load2(it.next().url).diskCacheStrategy(DiskCacheStrategy.DATA).priority(Priority.LOW).preload();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.i("ShowPagerListModel", "cacheItem error", e);
        }
    }

    public final int E() {
        int iMax = Math.max(1, Math.min(F(), 4));
        LogUtil.i("ShowPagerListModel", "getCurrentCacheSize " + iMax);
        return iMax;
    }

    public final int F() {
        long jB = ir5.b();
        Iterator<Long> it = this.m.iterator();
        float f = 0.0f;
        while (it.hasNext()) {
            if (it.next().longValue() >= jB - 2000) {
                f += 1.0f;
            }
        }
        int iRound = Math.round(f / 2.0f);
        LogUtil.i("ShowPagerListModel", "getCurrentRate" + iRound);
        return iRound;
    }

    public void G(boolean z, ir<BaseNetListBean<SquareFeed>> irVar) {
        this.f = xn3.a();
        int i = this.d;
        this.e = i;
        int i2 = i + 1;
        this.d = i2;
        bi5.l(this.i, new a(z, i2, irVar), this.d, this.f);
    }

    public void H(int i) {
        this.m.add(Long.valueOf(ir5.b()));
        List<T> list = this.f20952a;
        if (list == 0 || list.size() <= 0) {
            return;
        }
        int iE = E();
        for (int i2 = 2; i2 <= iE; i2++) {
            int i3 = i2 + i;
            if (i3 >= this.f20952a.size()) {
                return;
            }
            D(i3);
        }
    }

    public BaseNetListBean<SquareFeed> I(JSONObject jSONObject) {
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
        return !hx3.m(c.b()) ? k(c.b().getString(R$string.square_network_error)) : C(false);
    }

    @Override // defpackage.om2
    public JSONObject b() {
        return C(true);
    }

    @Override // defpackage.tb4, defpackage.om2
    public void f(ir<BaseNetListBean<SquareFeed>> irVar) {
        super.f(irVar);
        G(true, irVar);
    }

    @Override // defpackage.tb4
    public boolean h() {
        return true;
    }

    @Override // defpackage.tb4
    public void o(ir<BaseNetListBean<SquareFeed>> irVar) {
        G(false, irVar);
    }
}
