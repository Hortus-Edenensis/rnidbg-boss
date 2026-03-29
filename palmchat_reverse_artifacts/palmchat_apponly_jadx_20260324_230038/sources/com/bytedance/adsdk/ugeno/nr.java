package com.bytedance.adsdk.ugeno;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.adsdk.ugeno.fx.k;
import com.bytedance.adsdk.ugeno.iz.n;
import com.bytedance.adsdk.ugeno.swiper.Swiper;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.umeng.analytics.pro.dn;
import com.zenmen.palmchat.peoplematch.bean.PeopleMatchCardBean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class nr extends com.bytedance.adsdk.ugeno.nr.u<Swiper> {
    private com.bytedance.adsdk.ugeno.nr.fx ec;
    private boolean fn;
    private float gb;
    private String gl;
    private float hm;
    private boolean hs;
    private int ic;
    private float iq;
    private int je;
    private String ki;
    private float pq;
    private boolean te;
    private float ti;
    private JSONArray wj;
    private float wu;

    public nr(Context context) {
        super(context);
        this.hs = true;
        this.te = true;
        this.ti = 0.0f;
        this.gb = 2000.0f;
        this.gl = PeopleMatchCardBean.RECOMMEND_TYPE_NORMAL;
        this.fn = true;
        this.je = Color.parseColor("#666666");
        this.ic = Color.parseColor("#ffffff");
    }

    @Override // com.bytedance.adsdk.ugeno.nr.u, com.bytedance.adsdk.ugeno.nr.fx
    public void nr() {
        super.nr();
        JSONArray jSONArray = this.wj;
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        ((Swiper) this.pn).b((int) this.pq).pn((int) this.hm).iz((int) this.wu).fx(this.fn).nr(this.ic).fx(this.je).nr(this.gl).b(this.hs).u(this.iq).u(this.te).u((int) this.gb).fx(this.fn);
        for (int i = 0; i < this.wj.length(); i++) {
            k kVar = new k(this.nr);
            kVar.u(this.i);
            com.bytedance.adsdk.ugeno.nr.fx<View> fxVarNr = kVar.nr(this.ec.d(), null);
            kVar.nr(this.wj.optJSONObject(i));
            ((Swiper) this.pn).u(fxVarNr);
        }
        if (this.te) {
            ((Swiper) this.pn).nr();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void u(JSONObject jSONObject) {
    }

    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public View u() {
        Swiper swiper = new Swiper(this.nr);
        this.pn = swiper;
        swiper.u((fx) this);
        return this.pn;
    }

    @Override // com.bytedance.adsdk.ugeno.nr.u
    public void u(com.bytedance.adsdk.ugeno.nr.fx fxVar) {
        this.ec = fxVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.bytedance.adsdk.ugeno.nr.fx
    public void u(String str, String str2) {
        super.u(str, str2);
        if (TextUtils.isEmpty(str)) {
        }
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1657957217:
                if (str.equals("delayStart")) {
                    b = 0;
                }
                break;
            case -1575751020:
                if (str.equals("indicatorColor")) {
                    b = 1;
                }
                break;
            case -1453344127:
                if (str.equals("nextMargin")) {
                    b = 2;
                }
                break;
            case -1306084975:
                if (str.equals("effect")) {
                    b = 3;
                }
                break;
            case -962590849:
                if (str.equals(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION)) {
                    b = 4;
                }
                break;
            case -711999985:
                if (str.equals("indicator")) {
                    b = 5;
                }
                break;
            case -202057851:
                if (str.equals("previousMargin")) {
                    b = 6;
                }
                break;
            case 3327652:
                if (str.equals("loop")) {
                    b = 7;
                }
                break;
            case 109641799:
                if (str.equals("speed")) {
                    b = 8;
                }
                break;
            case 857882560:
                if (str.equals("pageCount")) {
                    b = 9;
                }
                break;
            case 1097821469:
                if (str.equals("pageMargin")) {
                    b = 10;
                }
                break;
            case 1196931001:
                if (str.equals("indicatorSelectedColor")) {
                    b = 11;
                }
                break;
            case 1439562083:
                if (str.equals("autoplay")) {
                    b = 12;
                }
                break;
            case 1788817256:
                if (str.equals("dataList")) {
                    b = dn.k;
                }
                break;
        }
        switch (b) {
            case 0:
                this.ti = com.bytedance.adsdk.ugeno.iz.fx.u(str2, 0.0f);
                break;
            case 1:
                this.je = com.bytedance.adsdk.ugeno.iz.u.u(str2);
                break;
            case 2:
                this.wu = n.u(this.nr, com.bytedance.adsdk.ugeno.iz.fx.u(str2, 0.0f));
                break;
            case 3:
                this.gl = str2;
                break;
            case 4:
                this.ki = str2;
                break;
            case 5:
                this.fn = com.bytedance.adsdk.ugeno.iz.fx.u(str2, true);
                break;
            case 6:
                this.hm = n.u(this.nr, com.bytedance.adsdk.ugeno.iz.fx.u(str2, 0.0f));
                break;
            case 7:
                this.hs = com.bytedance.adsdk.ugeno.iz.fx.u(str2, true);
                break;
            case 8:
                this.gb = com.bytedance.adsdk.ugeno.iz.fx.u(str2, 500.0f);
                break;
            case 9:
                this.iq = com.bytedance.adsdk.ugeno.iz.fx.u(str2, 1.0f);
                break;
            case 10:
                this.pq = n.u(this.nr, com.bytedance.adsdk.ugeno.iz.fx.u(str2, 0.0f));
                break;
            case 11:
                this.ic = com.bytedance.adsdk.ugeno.iz.u.u(str2);
                break;
            case 12:
                this.te = com.bytedance.adsdk.ugeno.iz.fx.u(str2, true);
                break;
            case 13:
                this.wj = com.bytedance.adsdk.ugeno.iz.nr.u(str2, (JSONArray) null);
                break;
        }
    }
}
