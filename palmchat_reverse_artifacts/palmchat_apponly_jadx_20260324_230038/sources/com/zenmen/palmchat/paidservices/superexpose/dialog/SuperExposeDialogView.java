package com.zenmen.palmchat.paidservices.superexpose.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import com.afollestad.materialdialogs.MaterialDialog;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.huawei.openalliance.ad.constant.bq;
import com.opensource.svgaplayer.SVGAImageView;
import com.qq.gdt.action.ActionUtils;
import com.wifi.ad.core.helper.AdHelperH5Ad;
import com.wifi.adsdk.utils.LxAdConst;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.giftkit.b;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.LocationScene;
import com.zenmen.palmchat.paidservices.superexpose.SuperExposeCityChoseActivity;
import com.zenmen.palmchat.paidservices.superexpose.a;
import com.zenmen.palmchat.paidservices.superexpose.bean.LbsSquareSuperCityListResult;
import com.zenmen.palmchat.paidservices.superexpose.bean.SuperExposeBuyCardConfig;
import com.zenmen.palmchat.paidservices.superexpose.bean.SuperExposeCardItem;
import com.zenmen.palmchat.paidservices.superexpose.bean.SuperExposeDialogInfo;
import com.zenmen.palmchat.refund.RefundData;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.LXBottomSheetDialog;
import com.zenmen.palmchat.widget.MarqueeTextView;
import defpackage.a46;
import defpackage.ap3;
import defpackage.av4;
import defpackage.az2;
import defpackage.b05;
import defpackage.c15;
import defpackage.cz2;
import defpackage.dn0;
import defpackage.ds0;
import defpackage.go2;
import defpackage.hc2;
import defpackage.hx3;
import defpackage.i53;
import defpackage.ky;
import defpackage.l50;
import defpackage.lu;
import defpackage.m15;
import defpackage.n53;
import defpackage.nl0;
import defpackage.q05;
import defpackage.qm5;
import defpackage.rl0;
import defpackage.ry5;
import defpackage.sd3;
import defpackage.sg4;
import defpackage.sw4;
import defpackage.sy5;
import defpackage.tg4;
import defpackage.tn5;
import defpackage.uc0;
import defpackage.un5;
import defpackage.v4;
import defpackage.wn5;
import defpackage.xn5;
import defpackage.y56;
import defpackage.yo3;
import defpackage.zn6;
import defpackage.zu4;
import defpackage.zw4;
import defpackage.zy4;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.nodes.Document;
import org.xml.sax.XMLReader;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class SuperExposeDialogView extends LXBottomSheetDialog implements View.OnClickListener {
    public SuperExposeCardItem A;
    public boolean B;
    public Boolean C;
    public un5 E;
    public final String F;
    public final String G;
    public List<SuperExposeCardItem> H;
    public String I;
    public List<LbsSquareSuperCityListResult> J;
    public boolean K;
    public boolean L;
    public MarqueeTextView M;
    public boolean N;
    public int O;
    public int P;
    public int Q;
    public MaterialDialog R;
    public ImageView S;
    public TextView T;
    public View U;
    public TextView V;
    public SVGAImageView W;
    public RefundData X;
    public Timer Y;
    public final int Z;
    public int e0;
    public int f0;
    public int g0;
    public ViewGroup h;
    public String h0;
    public Activity i;
    public LinearLayout i0;
    public Context j;
    public LinearLayout j0;
    public ImageView k;
    public LinearLayout k0;
    public ImageView l;
    public TextView l0;
    public TextView m;
    public Handler m0;
    public ImageView n;
    public Handler n0;
    public ImageView o;
    public boolean o0;
    public View p;
    public FrameLayout q;
    public wn5 r;
    public SuperExposeDialogInfo s;
    public int t;
    public int u;
    public String v;
    public String w;
    public int x;
    public boolean y;
    public int z;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends go2<LXBaseNetBean<ArrayList<LbsSquareSuperCityListResult>>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f14813a;
        public final /* synthetic */ HashMap b;
        public final /* synthetic */ boolean c;

        public a(String str, HashMap map, boolean z) {
            this.f14813a = str;
            this.b = map;
            this.c = z;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, this.f14813a, this.b).f(this.c);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<ArrayList<LbsSquareSuperCityListResult>> lXBaseNetBean, Exception exc) {
            SuperExposeDialogView.this.K = false;
            if (q05.o(SuperExposeDialogView.this.i) || !z || lXBaseNetBean == null || lXBaseNetBean.data == null) {
                return;
            }
            SuperExposeCityChoseActivity.I1(SuperExposeDialogView.this.j, SuperExposeDialogView.this.J);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SuperExposeCardItem f14814a;

        public b(SuperExposeCardItem superExposeCardItem) {
            this.f14814a = superExposeCardItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SuperExposeDialogView.this.k0.setBackgroundResource(R.drawable.super_expose_dialog_card_selected);
            LinearLayout linearLayout = SuperExposeDialogView.this.j0;
            if (linearLayout != null) {
                linearLayout.setBackgroundResource(R.drawable.super_expose_dialog_card_unselected);
                SuperExposeDialogView.this.L = false;
            }
            SuperExposeDialogView.this.A = this.f14814a;
            SuperExposeDialogView.this.v = this.f14814a.productId;
            SuperExposeDialogView.this.w = this.f14814a.productId;
            SuperExposeDialogView.this.x = this.f14814a.beanPrice;
            if (TextUtils.isEmpty(this.f14814a.beanText)) {
                return;
            }
            SuperExposeDialogView superExposeDialogView = SuperExposeDialogView.this;
            superExposeDialogView.new y(superExposeDialogView.m, this.f14814a.beanText).b();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SuperExposeCardItem f14815a;

        public c(SuperExposeCardItem superExposeCardItem) {
            this.f14815a = superExposeCardItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (q05.p()) {
                return;
            }
            if (!SuperExposeDialogView.this.L) {
                SuperExposeDialogView.this.j0.setBackgroundResource(R.drawable.super_expose_dialog_card_selected);
                SuperExposeDialogView.this.L = true;
                LinearLayout linearLayout = SuperExposeDialogView.this.k0;
                if (linearLayout != null) {
                    linearLayout.setBackgroundResource(R.drawable.super_expose_dialog_card_unselected);
                }
                SuperExposeDialogView.this.A = this.f14815a;
                SuperExposeDialogView.this.v = this.f14815a.productId;
                SuperExposeDialogView.this.w = this.f14815a.productId;
                SuperExposeDialogView.this.x = this.f14815a.beanPrice;
                if (!TextUtils.isEmpty(this.f14815a.beanText)) {
                    SuperExposeDialogView superExposeDialogView = SuperExposeDialogView.this;
                    superExposeDialogView.new y(superExposeDialogView.m, this.f14815a.beanText).b();
                }
            }
            SuperExposeDialogView.this.q0();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SuperExposeCardItem f14816a;

        public d(SuperExposeCardItem superExposeCardItem) {
            this.f14816a = superExposeCardItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SuperExposeDialogView.this.j0.setBackgroundResource(R.drawable.super_expose_dialog_card_selected);
            SuperExposeDialogView.this.L = true;
            LinearLayout linearLayout = SuperExposeDialogView.this.k0;
            if (linearLayout != null) {
                linearLayout.setBackgroundResource(R.drawable.super_expose_dialog_card_unselected);
            }
            SuperExposeDialogView.this.A = this.f14816a;
            SuperExposeDialogView.this.v = this.f14816a.productId;
            SuperExposeDialogView.this.w = this.f14816a.productId;
            SuperExposeDialogView.this.x = this.f14816a.beanPrice;
            if (TextUtils.isEmpty(this.f14816a.beanText)) {
                return;
            }
            SuperExposeDialogView superExposeDialogView = SuperExposeDialogView.this;
            superExposeDialogView.new y(superExposeDialogView.m, this.f14816a.beanText).b();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f extends go2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f14818a;
        public final /* synthetic */ LocationEx b;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements yo3 {

            /* JADX INFO: renamed from: com.zenmen.palmchat.paidservices.superexpose.dialog.SuperExposeDialogView$f$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class RunnableC1086a implements Runnable {

                /* JADX INFO: renamed from: com.zenmen.palmchat.paidservices.superexpose.dialog.SuperExposeDialogView$f$a$a$a, reason: collision with other inner class name */
                /* JADX INFO: compiled from: SearchBox */
                public class C1087a implements b.m {
                    public C1087a() {
                    }

                    @Override // com.zenmen.palmchat.giftkit.b.m
                    public void call() {
                        if (SuperExposeDialogView.this.A.beanPrice <= com.zenmen.palmchat.giftkit.b.j().g()) {
                            SuperExposeDialogView.this.H0();
                        }
                    }
                }

                public RunnableC1086a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.zenmen.palmchat.giftkit.b.j().r(new C1087a());
                }
            }

            public a() {
            }

            @Override // defpackage.yo3
            public void a(Object obj) {
                if (obj != null) {
                    SuperExposeDialogView.this.C = (Boolean) obj;
                    if (tn5.c() && SuperExposeDialogView.this.C.booleanValue()) {
                        SuperExposeDialogView.this.m0.post(new RunnableC1086a());
                    }
                }
                if (obj != null) {
                    Boolean bool = (Boolean) obj;
                    if (bool.booleanValue()) {
                        SuperExposeDialogView.this.C = bool;
                    }
                }
            }
        }

        public f(int i, LocationEx locationEx) {
            this.f14818a = i;
            this.b = locationEx;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("gender", SuperExposeDialogView.this.w0());
                jSONObject.put("age", SuperExposeDialogView.this.u0());
                jSONObject.put("buyScene", SuperExposeDialogView.this.t);
                jSONObject.put("buyFrom", "app");
                jSONObject.put("buyFrom", "app");
                jSONObject.put("from", SuperExposeDialogView.this.u);
                jSONObject.put("buyPop", this.f14818a);
                if (SuperExposeDialogView.this.A != null) {
                    jSONObject.put("productId", SuperExposeDialogView.this.A.productId);
                }
                LocationEx locationEx = this.b;
                if (locationEx != null) {
                    jSONObject.put("latitude", locationEx.getLatitude());
                    jSONObject.put("longitude", this.b.getLongitude());
                    jSONObject.put("cityCode", this.b.getCityCode());
                }
                if (SuperExposeDialogView.this.f0 != -1) {
                    jSONObject.put("welfareId", SuperExposeDialogView.this.f0);
                }
                if (SuperExposeDialogView.this.g0 != -1) {
                    jSONObject.put("welfareType", SuperExposeDialogView.this.g0);
                }
                if (!SuperExposeDialogView.this.J.isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    ArrayList arrayList = new ArrayList();
                    for (LbsSquareSuperCityListResult lbsSquareSuperCityListResult : SuperExposeDialogView.this.J) {
                        String str = lbsSquareSuperCityListResult.cityCode;
                        if (str != null) {
                            arrayList.add(str);
                            jSONArray.put(lbsSquareSuperCityListResult.cityCode);
                        }
                    }
                    jSONObject.put("selectCityList", jSONArray);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return sw4.c(1, nl0.z + "/lbs.square.super.show.buy.v16", jSONObject).f(true);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean lXBaseNetBean, Exception exc) {
            MaterialDialog materialDialog = SuperExposeDialogView.this.R;
            if (materialDialog != null && materialDialog.isShowing() && this.f14818a == 2) {
                SuperExposeDialogView.this.R.dismiss();
            }
            if (!z) {
                sy5.h(SuperExposeDialogView.this.j, "商品获取失败，请刷新后重试", 1);
                return;
            }
            int i = lXBaseNetBean.resultCode;
            if (i == -1004) {
                ap3.a().z(SuperExposeDialogView.this.j, SuperExposeDialogView.this.u, 601, SuperExposeDialogView.this.w, SuperExposeDialogView.this.x, SuperExposeDialogView.this.z, new a());
                return;
            }
            if (i == 0) {
                if ("tab_find_friend".equals(MainTabsActivity.y2())) {
                    sy5.f(SuperExposeDialogView.this.j, "购买成功", 1).g();
                } else {
                    SuperExposeDialogView.this.G0();
                }
                LogUtil.d("", "InviteMine buy success inviteSuperBuy false");
                ds0.a().b(new xn5(0));
                SuperExposeDialogView.this.dismiss();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends HashMap<String, Object> {
        public g() {
            put("sku", SuperExposeDialogView.this.A.productId);
            put("from", Integer.valueOf(SuperExposeDialogView.this.u));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f14823a;

        /* JADX INFO: compiled from: SearchBox */
        public class a implements a.g {
            public a() {
            }

            @Override // com.zenmen.palmchat.paidservices.superexpose.a.g
            public void onFail(Exception exc) {
                h.this.f14823a.cancel();
            }

            @Override // com.zenmen.palmchat.paidservices.superexpose.a.g
            public void onSuccess() {
                h.this.f14823a.cancel();
                ry5.a("领取成功，快去使用吧");
                SuperExposeDialogView.this.v0();
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public class b extends HashMap<String, Object> {
            public b() {
                put("sku", SuperExposeDialogView.this.A.productId);
                put("from", Integer.valueOf(SuperExposeDialogView.this.u));
                put("clickType", bq.b.V);
            }
        }

        public h(MaterialDialog materialDialog) {
            this.f14823a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            com.zenmen.palmchat.paidservices.superexpose.a.b().e(new a());
            zn6.j("boost_stayPop", "click", new b());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f14826a;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("sku", SuperExposeDialogView.this.A.productId);
                put("from", Integer.valueOf(SuperExposeDialogView.this.u));
                put("clickType", "close");
            }
        }

        public i(MaterialDialog materialDialog) {
            this.f14826a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            this.f14826a.cancel();
            zn6.j("boost_stayPop", "click", new a());
            SuperExposeDialogView.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f14828a;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("sku", SuperExposeDialogView.this.A.productId);
                put("from", Integer.valueOf(SuperExposeDialogView.this.u));
                put("clickType", "close");
            }
        }

        public j(MaterialDialog materialDialog) {
            this.f14828a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            zn6.j("boost_stayPop", "click", new a());
            this.f14828a.cancel();
            SuperExposeDialogView.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements DialogInterface.OnDismissListener {
        public k() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (SuperExposeDialogView.this.r != null) {
                SuperExposeDialogView.this.r.o();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l extends HashMap<String, Object> {
        public l() {
            put("sku", SuperExposeDialogView.this.A.productId);
            put("from", Integer.valueOf(SuperExposeDialogView.this.u));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("sku", SuperExposeDialogView.this.A.productId);
                put("from", Integer.valueOf(SuperExposeDialogView.this.u));
                put("clickType", "buy");
            }
        }

        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            zn6.j("boost_secceedRecharge_guidePop", "click", new a());
            SuperExposeDialogView.this.o0(2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class n implements View.OnClickListener {

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, Object> {
            public a() {
                put("sku", SuperExposeDialogView.this.A.productId);
                put("from", Integer.valueOf(SuperExposeDialogView.this.u));
                put("clickType", "close");
            }
        }

        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            zn6.j("boost_secceedRecharge_guidePop", "click", new a());
            SuperExposeDialogView.this.R.cancel();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class p extends TypeToken<List<LbsSquareSuperCityListResult>> {
        public p() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class q implements View.OnClickListener {
        public q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean zIsSelected = SuperExposeDialogView.this.S.isSelected();
            if (!zIsSelected) {
                SuperExposeDialogView.this.T.setVisibility(8);
            }
            SuperExposeDialogView.this.S.setSelected(!zIsSelected);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class r implements View.OnClickListener {
        public r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a() || SuperExposeDialogView.this.X == null) {
                return;
            }
            av4.h(SuperExposeDialogView.this.i, SuperExposeDialogView.this.u, SuperExposeDialogView.this.t, SuperExposeDialogView.this.y);
            av4.l(SuperExposeDialogView.this.j, az2.c(SuperExposeDialogView.this.X), 2, false);
            SuperExposeDialogView.this.U.setVisibility(8);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class s extends go2<LXBaseNetBean<RefundData>> {
        public s() {
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            map.put("bizType", 0);
            map.put("grant", Boolean.TRUE);
            return sw4.b(1, nl0.z + "/welfare.get", map).f(false);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<RefundData> lXBaseNetBean, Exception exc) {
            RefundData refundData;
            LogUtil.i("RefundManager", "checkSuperRefund info onResult=" + az2.c(lXBaseNetBean));
            if (lXBaseNetBean == null || (refundData = lXBaseNetBean.data) == null) {
                return;
            }
            SuperExposeDialogView.this.M0(refundData);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class v extends TimerTask {
        public v() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            SuperExposeDialogView.this.n0.sendMessage(messageObtain);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class w extends Handler {
        public w(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (message.what != 1) {
                return;
            }
            SuperExposeDialogView.this.e0--;
            if (SuperExposeDialogView.this.e0 < 0) {
                if (SuperExposeDialogView.this.U != null) {
                    SuperExposeDialogView.this.U.setVisibility(8);
                }
                SuperExposeDialogView.this.t0();
                return;
            }
            if (SuperExposeDialogView.this.X != null) {
                SuperExposeDialogView.this.X.expires = SuperExposeDialogView.this.e0;
            }
            if (SuperExposeDialogView.this.V != null) {
                SuperExposeDialogView.this.V.setText(av4.f(SuperExposeDialogView.this.e0));
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class x implements a.f {
        public x() {
        }

        @Override // com.zenmen.palmchat.paidservices.superexpose.a.f
        public void a(SuperExposeDialogInfo superExposeDialogInfo) {
            if (q05.o(SuperExposeDialogView.this.i)) {
                return;
            }
            SuperExposeDialogView superExposeDialogView = SuperExposeDialogView.this;
            superExposeDialogView.N = true;
            superExposeDialogView.E0(superExposeDialogInfo);
        }

        @Override // com.zenmen.palmchat.paidservices.superexpose.a.f
        public void onFail(Exception exc) {
            if (q05.o(SuperExposeDialogView.this.i)) {
                return;
            }
            SuperExposeDialogView superExposeDialogView = SuperExposeDialogView.this;
            superExposeDialogView.N = false;
            SuperExposeDialogView.this.E0((SuperExposeDialogInfo) az2.a(superExposeDialogView.I, SuperExposeDialogInfo.class));
            sy5.h(SuperExposeDialogView.this.j, "商品获取失败，请刷新后重试", 1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class y implements Html.TagHandler {
        public List<y56> d;
        public int e;
        public String f;
        public Context g;
        public TextView h;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f14846a = 0;
        public int b = 0;
        public String i = "myfont";
        public List<Integer> c = new ArrayList();

        public y(TextView textView, String str) {
            this.e = 0;
            this.f = str;
            this.h = textView;
            this.g = textView.getContext();
            this.d = a(str);
            this.e = 0;
        }

        public List<y56> a(String str) {
            Document documentA;
            org.jsoup.nodes.g gVarL;
            try {
                documentA = cz2.a(str);
            } catch (Exception e) {
                e.printStackTrace();
                documentA = null;
            }
            ArrayList arrayList = new ArrayList();
            if (documentA != null) {
                for (org.jsoup.nodes.f fVar : documentA.H0("font")) {
                    y56 y56Var = new y56();
                    y56Var.f(fVar.f("href"));
                    y56Var.e(fVar.f("trigger"));
                    y56Var.d(fVar.f(ActionUtils.METHOD));
                    y56Var.c(fVar.f("compCode"));
                    y56Var.n(fVar.f("color"));
                    HashMap<String, String> mapE = zy4.e(y56Var.b());
                    y56Var.p(mapE.get("page"));
                    y56Var.r(mapE.get("zxAuthenticationed"));
                    y56Var.l(mapE.get("bgColor"));
                    y56Var.o(fVar.f("size"));
                    if (fVar.n() != null && fVar.n().size() == 1 && (gVarL = fVar.l(0)) != null && (gVarL instanceof org.jsoup.nodes.h)) {
                        y56Var.m(((org.jsoup.nodes.h) gVarL).Y());
                    }
                    arrayList.add(y56Var);
                }
            }
            return arrayList;
        }

        public void b() {
            String strReplaceAll = this.f.replaceAll("<font", "<" + this.i).replaceAll("</font>", "</" + this.i + ">");
            this.f = strReplaceAll;
            this.h.setText(Html.fromHtml(strReplaceAll, null, this));
        }

        @Override // android.text.Html.TagHandler
        public void handleTag(boolean z, String str, Editable editable, XMLReader xMLReader) {
            if (str.toLowerCase().equals(str)) {
                if (z) {
                    int length = editable.length();
                    this.f14846a = length;
                    this.c.add(Integer.valueOf(length));
                    return;
                }
                List<y56> list = this.d;
                if (list == null || list.size() <= 0) {
                    return;
                }
                String strH = this.d.get(this.e).h();
                String strI = this.d.get(this.e).i();
                this.b = editable.length();
                this.f14846a = this.c.get(this.e).intValue();
                if (!TextUtils.isEmpty(strI)) {
                    editable.setSpan(new AbsoluteSizeSpan(a46.b(this.g, Integer.parseInt(strI))), this.f14846a, this.b, 33);
                }
                if (!TextUtils.isEmpty(strH)) {
                    editable.setSpan(new ForegroundColorSpan(Color.parseColor(strH)), this.f14846a, this.b, 33);
                }
                this.e++;
            }
        }
    }

    public SuperExposeDialogView(@NonNull Context context, @StyleRes int i2) {
        super(context, i2);
        this.i = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.x = 0;
        this.z = 0;
        this.A = null;
        this.B = false;
        this.C = null;
        this.E = null;
        this.F = "#14CD64";
        this.G = "#222222";
        this.H = new ArrayList();
        this.I = "";
        this.J = new ArrayList();
        this.K = false;
        this.L = false;
        this.N = false;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.X = null;
        this.Y = null;
        this.Z = 1;
        this.e0 = 0;
        this.f0 = -1;
        this.g0 = -1;
        this.h0 = "";
        this.m0 = new Handler(Looper.getMainLooper());
        this.n0 = new w(Looper.getMainLooper());
        ds0.a().c(this);
        setCanceledOnTouchOutside(false);
        super.setOnDismissListener(new k());
        this.h0 = AdHelperH5Ad.INSTANCE.getAdRequestId();
        Context applicationContext = context.getApplicationContext();
        this.j = applicationContext;
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(applicationContext).inflate(R.layout.super_expose_dialog_new_layout, (ViewGroup) null);
        this.h = viewGroup;
        this.S = (ImageView) viewGroup.findViewById(R.id.privacy_iv);
        this.T = (TextView) this.h.findViewById(R.id.pop_tv);
        this.S.setSelected(false);
        this.S.setOnClickListener(new q());
        this.i0 = (LinearLayout) this.h.findViewById(R.id.card_root);
        this.k = (ImageView) this.h.findViewById(R.id.title_img);
        this.l = (ImageView) this.h.findViewById(R.id.sex_img);
        this.m = (TextView) this.h.findViewById(R.id.bug_text);
        this.n = (ImageView) this.h.findViewById(R.id.all_bg_img);
        this.o = (ImageView) this.h.findViewById(R.id.bug_img_bg);
        this.p = this.h.findViewById(R.id.buyButton);
        this.q = (FrameLayout) this.h.findViewById(R.id.roll_loop_layout);
        wn5 wn5Var = new wn5(this.j);
        this.r = wn5Var;
        wn5Var.m(this.q);
        if (context instanceof Activity) {
            this.i = (Activity) context;
        }
        if (w0() == 1) {
            this.l.setImageResource(R.drawable.super_expose_dialog_sex_m_bg);
            this.I = "{\"bubbleList\":[],\"buyCardConfig\":{\"cardList\":[{\"productId\":\"LX001\",\"img\":\"https://storage.lianxinapp.com/mdc/res/v5/1/9ugxnorjls-24-2-23fe3413d445449281e8665879fc1bec-t16fwu\",\"beanPrice\":120,\"buyNum\":1,\"freeNum\":0,\"freeText\":\"\",\"tipText\":\"120连信豆\",\"beanText\":\"<font color='#FFFFFF' size='16'>立即曝光</font><font color='#FFFFFF' size='14'>（120连信豆）</font>\",\"type\":1,\"name\":\"小时卡\",\"desc\":\"将你推荐给附近的帅哥<font color='#14CD64'> 120 </font>分钟，让他主动撩你\",\"remainText\":\"\"},{\"productId\":\"LX004\",\"img\":\"https://storage.lianxinapp.com/mdc/res/v5/1/9ugxnorjls-24-2-8d67a3c3348446cda3211000bdb436e0-t16fx0\",\"beanPrice\":240,\"buyNum\":1,\"freeNum\":0,\"freeText\":\"\",\"tipText\":\"240连信豆\",\"beanText\":\"<font color='#FFFFFF' size='16'>立即曝光</font><font color='#FFFFFF' size='14'>（240连信豆）</font>\",\"type\":3,\"name\":\"定位卡\",\"desc\":\"对指定城市异性曝光，最长<font color='#14CD64'> 24 </font>小时\"}],\"defProductId\":\"LX001\",\"supportPurchaseLocationCard\":false},\"showRetain\":false}";
        } else {
            this.I = "{\"bubbleList\":[],\"buyCardConfig\":{\"cardList\":[{\"productId\":\"LX001\",\"img\":\"https://storage.lianxinapp.com/mdc/res/v5/1/9ugxnorjls-24-2-23fe3413d445449281e8665879fc1bec-t16fwu\",\"beanPrice\":90,\"buyNum\":1,\"freeNum\":0,\"freeText\":\"\",\"tipText\":\"90连信豆\",\"beanText\":\"<font color='#FFFFFF' size='16'>立即曝光</font><font color='#FFFFFF' size='14'>（90连信豆）</font>\",\"type\":1,\"name\":\"小时卡\",\"desc\":\"将你推荐给附近的美女<font color='#14CD64'> 120 </font>分钟，让她主动撩你\",\"remainText\":\"\"},{\"productId\":\"LX004\",\"img\":\"https://storage.lianxinapp.com/mdc/res/v5/1/9ugxnorjls-24-2-8d67a3c3348446cda3211000bdb436e0-t16fx0\",\"beanPrice\":180,\"buyNum\":1,\"freeNum\":0,\"freeText\":\"\",\"tipText\":\"180连信豆\",\"beanText\":\"<font color='#FFFFFF' size='16'>立即曝光</font><font color='#FFFFFF' size='14'>（180连信豆）</font>\",\"type\":3,\"name\":\"定位卡\",\"desc\":\"对指定城市异性曝光，最长<font color='#14CD64'> 24 </font>小时\"}],\"defProductId\":\"LX001\",\"supportPurchaseLocationCard\":false},\"showRetain\":false}";
        }
        this.p.setOnClickListener(this);
        this.h.findViewById(R.id.dialog_close).setOnClickListener(this);
        this.h.findViewById(R.id.bug_info_text2).setOnClickListener(this);
        x0();
    }

    public static boolean z0(int i2) {
        return (i2 == 27 || i2 == 28) ? false : true;
    }

    public final void A0() {
        List list;
        try {
            String str = (String) q05.k("key_super_expose_selected_cities", "");
            if (TextUtils.isEmpty(str) || (list = (List) new Gson().fromJson(str, new p().getType())) == null || list.isEmpty()) {
                return;
            }
            this.J.clear();
            this.J.addAll(list);
            O0();
        } catch (Exception unused) {
        }
    }

    public String B0(String str) {
        return !TextUtils.isEmpty(str) ? str.replace("\n", "<br>") : str;
    }

    public void C0(String str) {
        String strE = v4.e(com.zenmen.palmchat.c.b());
        if (TextUtils.isEmpty(strE) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            LogUtil.d("SuperExposeDialogView", "updateConfig ext " + str);
            JSONObject jSONObject = new JSONObject(str);
            this.O = jSONObject.optInt("stayPop_frequency_totalPv", 0);
            this.P = jSONObject.optInt("stayPop_frequency_time", 0);
            this.Q = jSONObject.optInt("stayPop_frequency_pv", 0);
            b05.d("stayPop_frequency_totalPv=" + this.O);
            b05.d("stayPop_frequency_time=" + this.P);
            b05.d("stayPop_frequency_pv=" + this.Q);
            b05.d(str);
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
            long jI = sPUtil.i(scene, "key_showwanliudialog_time" + strE, 0L);
            b05.d("打开的key_showwanliudialog_time" + strE + ",总次数" + jI);
            int i2 = this.O;
            if (jI < i2 && i2 != 0) {
                long jI2 = sPUtil.i(scene, "key_showwanliudialog_frequence_lasttime" + strE, 0L);
                if (jI2 == 0) {
                    sPUtil.t(scene, "key_showwanliudialog_frequence_lasttime" + strE, Long.valueOf(System.currentTimeMillis()));
                    sPUtil.t(scene, "key_showwanliudialog_frequence_time" + strE, 1);
                    b05.d("第一次显示并设置值");
                    K0();
                } else if (System.currentTimeMillis() - jI2 >= this.P * 60 * 1000) {
                    sPUtil.t(scene, "key_showwanliudialog_frequence_lasttime" + strE, Long.valueOf(System.currentTimeMillis()));
                    sPUtil.t(scene, "key_showwanliudialog_frequence_time" + strE, 1);
                    b05.d("超过了频次值重新设置");
                    K0();
                } else {
                    long jI3 = sPUtil.i(scene, "key_showwanliudialog_frequence_time" + strE, 0L);
                    b05.d("已经打开过次数" + jI3);
                    if (jI3 < this.Q) {
                        sPUtil.t(scene, "key_showwanliudialog_frequence_time" + strE, Long.valueOf(jI3 + 1));
                        K0();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void D0() {
        try {
            List<LbsSquareSuperCityListResult> list = this.J;
            if (list == null || list.isEmpty()) {
                q05.w("key_super_expose_selected_cities", "");
            } else {
                q05.w("key_super_expose_selected_cities", az2.c(this.J));
            }
        } catch (Exception unused) {
        }
    }

    public final void E0(SuperExposeDialogInfo superExposeDialogInfo) {
        boolean z;
        if (q05.o(this.i)) {
            return;
        }
        this.s = superExposeDialogInfo;
        if (superExposeDialogInfo != null) {
            ArrayList<String> arrayList = superExposeDialogInfo.bubbleList;
            if (arrayList != null && arrayList.size() > 0) {
                this.r.h(superExposeDialogInfo.bubbleList);
                this.r.n();
            }
            this.i0.removeAllViews();
            this.k0 = null;
            this.j0 = null;
            this.l0 = null;
            this.M = null;
            this.H.clear();
            SuperExposeBuyCardConfig superExposeBuyCardConfig = superExposeDialogInfo.buyCardConfig;
            if (superExposeBuyCardConfig == null || superExposeBuyCardConfig.cardList == null) {
                return;
            }
            if (!superExposeBuyCardConfig.supportPurchaseLocationCard) {
                q05.t("key_super_expose_selected_cities");
            }
            SuperExposeBuyCardConfig superExposeBuyCardConfig2 = superExposeDialogInfo.buyCardConfig;
            String str = superExposeBuyCardConfig2.defProductId;
            ArrayList<SuperExposeCardItem> arrayList2 = superExposeBuyCardConfig2.cardList;
            if (arrayList2 != null) {
                int size = arrayList2.size();
                z = false;
                for (int i2 = 0; i2 < size; i2++) {
                    SuperExposeCardItem superExposeCardItem = superExposeDialogInfo.buyCardConfig.cardList.get(i2);
                    if (superExposeCardItem != null) {
                        this.H.add(superExposeCardItem);
                        if (superExposeCardItem.productId.equals(str)) {
                            z = true;
                        }
                    }
                }
            } else {
                z = false;
            }
            if (!z && this.H.size() > 0) {
                str = this.H.get(0).productId;
            }
            for (int i3 = 0; i3 < this.H.size(); i3++) {
                SuperExposeCardItem superExposeCardItem2 = this.H.get(i3);
                int i4 = superExposeCardItem2.type;
                if (i4 == 1 && this.k0 == null) {
                    View viewInflate = LayoutInflater.from(this.j).inflate(R.layout.super_expose_dialog_hour_card_layout, (ViewGroup) this.i0, false);
                    this.i0.addView(viewInflate);
                    this.k0 = (LinearLayout) viewInflate.findViewById(R.id.hourCardLayout);
                    TextView textView = (TextView) viewInflate.findViewById(R.id.hourTitle);
                    TextView textView2 = (TextView) viewInflate.findViewById(R.id.hourDescription);
                    ImageView imageView = (ImageView) viewInflate.findViewById(R.id.card_image);
                    TextView textView3 = (TextView) viewInflate.findViewById(R.id.left_text);
                    hc2.a(getContext()).load(superExposeCardItem2.img).into(imageView);
                    if (textView != null && !TextUtils.isEmpty(superExposeCardItem2.name)) {
                        textView.setText(superExposeCardItem2.name);
                    }
                    if (textView2 != null && !TextUtils.isEmpty(superExposeCardItem2.desc)) {
                        textView2.setText(Html.fromHtml(B0(superExposeCardItem2.desc)));
                    }
                    if (TextUtils.isEmpty(superExposeCardItem2.remainText)) {
                        textView3.setVisibility(8);
                    } else {
                        textView3.setVisibility(0);
                        textView3.setText(superExposeCardItem2.remainText);
                    }
                    if (superExposeCardItem2.productId.equals(str)) {
                        this.k0.setBackgroundResource(R.drawable.super_expose_dialog_card_selected);
                    } else {
                        this.k0.setBackgroundResource(R.drawable.super_expose_dialog_card_unselected);
                    }
                    if (superExposeCardItem2.productId.equals(str)) {
                        this.A = superExposeCardItem2;
                        String str2 = superExposeCardItem2.productId;
                        this.v = str2;
                        this.w = str2;
                        this.x = superExposeCardItem2.beanPrice;
                        if (!TextUtils.isEmpty(superExposeCardItem2.beanText)) {
                            new y(this.m, superExposeCardItem2.beanText).b();
                        }
                    }
                    this.k0.setOnClickListener(new b(superExposeCardItem2));
                } else if (i4 == 3 && this.j0 == null) {
                    View viewInflate2 = LayoutInflater.from(this.j).inflate(R.layout.super_expose_dialog_location_card_layout, (ViewGroup) this.i0, false);
                    this.i0.addView(viewInflate2);
                    this.j0 = (LinearLayout) viewInflate2.findViewById(R.id.locationCardLayout);
                    TextView textView4 = (TextView) viewInflate2.findViewById(R.id.locationTitle);
                    TextView textView5 = (TextView) viewInflate2.findViewById(R.id.locationDescription);
                    LinearLayout linearLayout = (LinearLayout) viewInflate2.findViewById(R.id.locationArrow);
                    this.l0 = (TextView) viewInflate2.findViewById(R.id.locationCityText);
                    ImageView imageView2 = (ImageView) viewInflate2.findViewById(R.id.card_image);
                    this.M = (MarqueeTextView) viewInflate2.findViewById(R.id.loop_message);
                    A0();
                    O0();
                    hc2.a(getContext()).load(superExposeCardItem2.img).into(imageView2);
                    if (textView4 != null && !TextUtils.isEmpty(superExposeCardItem2.name)) {
                        textView4.setText(superExposeCardItem2.name);
                    }
                    if (textView5 != null && !TextUtils.isEmpty(superExposeCardItem2.desc)) {
                        textView5.setText(Html.fromHtml(B0(superExposeCardItem2.desc)));
                    }
                    linearLayout.setOnClickListener(new c(superExposeCardItem2));
                    if (superExposeCardItem2.productId.equals(str)) {
                        this.j0.setBackgroundResource(R.drawable.super_expose_dialog_card_selected);
                    } else {
                        this.j0.setBackgroundResource(R.drawable.super_expose_dialog_card_unselected);
                    }
                    if (superExposeCardItem2.productId.equals(str)) {
                        this.L = true;
                        this.A = superExposeCardItem2;
                        String str3 = superExposeCardItem2.productId;
                        this.v = str3;
                        this.w = str3;
                        this.x = superExposeCardItem2.beanPrice;
                        if (!TextUtils.isEmpty(superExposeCardItem2.beanText)) {
                            new y(this.m, superExposeCardItem2.beanText).b();
                        }
                    }
                    this.j0.setOnClickListener(new d(superExposeCardItem2));
                }
            }
        }
    }

    public void F0(int i2, int i3, boolean z, int i4) {
        ImageView imageView;
        this.t = i2;
        this.u = i3;
        this.y = z;
        this.z = i4;
        if (w0() == 1 && (imageView = this.l) != null) {
            imageView.setImageResource(R.drawable.super_expose_dialog_sex_m_bg);
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(600L);
        scaleAnimation.setRepeatCount(Integer.MAX_VALUE);
        scaleAnimation.setRepeatMode(2);
        this.p.startAnimation(scaleAnimation);
    }

    public final void G0() {
        LogUtil.d("", "SuperDialog showBuySuccessDialog mAct " + this.i);
        Activity activity = this.i;
        if (activity != null) {
            this.E = null;
            un5 un5Var = new un5(activity);
            this.E = un5Var;
            un5Var.show();
        }
    }

    public final void H0() {
        if (this.A == null) {
            return;
        }
        zn6.j("boost_secceedRecharge_guidePop", "view", new l());
        MaterialDialog materialDialogE = new sd3(getContext()).b(true).c(0).q(0.8f).o(R.layout.layout_dialog_superexpose_charge_success, false).e();
        this.R = materialDialogE;
        View viewJ = materialDialogE.j();
        if (viewJ != null) {
            View viewFindViewById = viewJ.findViewById(R.id.btn_start);
            View viewFindViewById2 = viewJ.findViewById(R.id.dialog_close);
            TextView textView = (TextView) viewJ.findViewById(R.id.sub_title_text);
            TextView textView2 = (TextView) viewJ.findViewById(R.id.btn_name);
            ImageView imageView = (ImageView) viewJ.findViewById(R.id.card_image);
            String str = this.A.name;
            String str2 = String.format("是否立即获得%s，\n让异性主动撩你吧~", str);
            SpannableString spannableString = new SpannableString(str2);
            int iIndexOf = str2.indexOf(str);
            spannableString.setSpan(new lu(Color.parseColor("#FFFAB4"), a46.b(getContext(), 8.0f), Color.parseColor("#FF3D3D")), iIndexOf, str.length() + iIndexOf, 33);
            textView.setText(spannableString);
            if (!TextUtils.isEmpty(this.A.tipText)) {
                textView2.setText("(" + this.A.tipText + ")");
            }
            imageView.setSelected(this.A.type == 2);
            viewFindViewById.setOnClickListener(new m());
            viewFindViewById2.setOnClickListener(new n());
        }
        this.R.c(false);
        this.R.show();
    }

    public final void I0() {
        Activity activity = this.i;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        SuperExposeAgreementDialog superExposeAgreementDialog = new SuperExposeAgreementDialog(this.i, new e());
        superExposeAgreementDialog.w(false);
        superExposeAgreementDialog.show();
    }

    public final void J0(int i2) {
        if (this.U != null) {
            if (this.V != null) {
                p0(i2);
            }
            this.U.setVisibility(0);
            if (this.W == null || this.j == null) {
                return;
            }
            try {
                new c15(this.j).n("super_refund_red_bg.svga", new t(), new u());
            } catch (Exception unused) {
            }
        }
    }

    public final void K0() {
        String strE = v4.e(com.zenmen.palmchat.c.b());
        if (TextUtils.isEmpty(strE)) {
            return;
        }
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
        sPUtil.t(scene, "key_showwanliudialog_time" + strE, Long.valueOf(sPUtil.i(scene, "key_showwanliudialog_time" + strE, 0L) + 1));
        this.B = true;
        zn6.j("boost_stayPop", "view", new g());
        MaterialDialog materialDialogE = new sd3(getContext()).b(true).c(0).q(0.8f).o(R.layout.layout_dialog_wanliu, false).e();
        View viewJ = materialDialogE.j();
        if (viewJ != null) {
            TextView textView = (TextView) viewJ.findViewById(R.id.btn_free);
            TextView textView2 = (TextView) viewJ.findViewById(R.id.btn_not_interested);
            View viewFindViewById = viewJ.findViewById(R.id.dialog_close);
            TextView textView3 = (TextView) viewJ.findViewById(R.id.title_text);
            SpannableString spannableString = new SpannableString("确定要离开吗？\n如果感兴趣的话，\n不妨免费体验一下吧！");
            spannableString.setSpan(new lu(Color.parseColor("#FFFAB4"), a46.b(getContext(), 8.0f), Color.parseColor("#FF3D3D")), 19, 21, 33);
            textView3.setText(spannableString);
            textView.setOnClickListener(new h(materialDialogE));
            textView2.setOnClickListener(new i(materialDialogE));
            viewFindViewById.setOnClickListener(new j(materialDialogE));
        }
        materialDialogE.c(false);
        materialDialogE.show();
    }

    public final void L0() {
        if (hx3.m(com.zenmen.palmchat.c.b())) {
            this.o0 = true;
            com.zenmen.palmchat.location.d.g().k(LocationScene.PUBLISH_SQUARE, new o());
        }
    }

    public final void M0(RefundData refundData) {
        if (refundData != null) {
            this.X = refundData;
            this.g0 = refundData.type;
            this.f0 = refundData.id;
            this.z = 0;
            int i2 = refundData.status;
            if (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) {
                this.z = 1;
            }
            if (refundData.play) {
                av4.h(this.i, this.u, this.t, this.y);
                av4.l(this.j, az2.c(refundData), 2, true);
                return;
            }
            if (i2 == 0) {
                J0(refundData.expires);
                return;
            }
            if (i2 == 7) {
                LogUtil.i("RefundManager", "startSuperDialogData status STATUS_TIME_OUT= from " + this.u + " scene " + this.t);
                if (this.u == 37 && this.t == 601) {
                    sy5.h(this.j, "福利已过期", 1);
                }
            }
        }
    }

    public final void N0() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.SUPER_EXPOSE_MSG_TAB_CONFIG);
        if (dynamicConfig == null || !dynamicConfig.isEnable()) {
            return;
        }
        C0(dynamicConfig.getExtra());
    }

    public final void O0() {
        if (this.l0 != null) {
            if (this.J.isEmpty()) {
                this.l0.setText("选择城市");
            } else if (this.J.size() == 1) {
                this.l0.setText(this.J.get(0).cityName);
            } else {
                this.l0.setText(this.J.get(0).cityName + "等" + this.J.size() + "个城市");
            }
            String string = this.l0.getText().toString();
            if (string.length() <= 4) {
                this.l0.setVisibility(0);
                MarqueeTextView marqueeTextView = this.M;
                if (marqueeTextView != null) {
                    marqueeTextView.setVisibility(8);
                    return;
                }
                return;
            }
            this.l0.setVisibility(8);
            MarqueeTextView marqueeTextView2 = this.M;
            if (marqueeTextView2 != null) {
                marqueeTextView2.setVisibility(0);
                this.M.setText(string);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (this.i instanceof SuperBuyDialogBaseActivity) {
            LogUtil.d("", "SuperDialog dismiss superExposeBuySuccessDialog:" + this.E);
            un5 un5Var = this.E;
            if (un5Var == null || !un5Var.isShowing()) {
                LogUtil.d("", "SuperDialog dismiss mAct.finish()");
                this.i.finish();
            }
        }
        t0();
        av4.f1580a = false;
        try {
            ds0.a().d(this);
        } catch (Exception unused) {
        }
    }

    @Override // com.zenmen.palmchat.widget.LXBottomSheetDialog
    public View n() {
        return this.h;
    }

    public void n0() {
        if (this.K) {
            return;
        }
        this.K = true;
        String str = q05.c() + "/lbs.square.super.city.list";
        HashMap map = new HashMap();
        LocationEx locationExI = q05.i();
        if (locationExI != null) {
            map.put("cityCode", locationExI.getCityCode());
        }
        zw4.e(new a(str, map, true));
    }

    public final void o0(int i2) {
        LogUtil.d("", "InviteMine buy start inviteSuperBuy true");
        if (!this.N) {
            sy5.h(this.j, "商品获取失败，请刷新后重试", 1);
            return;
        }
        LocationEx locationExI = com.zenmen.palmchat.location.d.g().i(86400000L);
        SuperExposeCardItem superExposeCardItem = this.A;
        if (superExposeCardItem != null && superExposeCardItem.type == 3) {
            boolean zB = tg4.b(com.zenmen.palmchat.c.b(), com.kuaishou.weapon.p0.g.g);
            boolean zF = com.zenmen.palmchat.location.b.f(com.zenmen.palmchat.c.b());
            if (this.J.isEmpty()) {
                sy5.h(this.j, "请先选择曝光城市", 1);
                return;
            }
            if (!zF) {
                sy5.h(this.j, "请先开启定位，再来购买此服务吧", 1);
                return;
            } else if (!zB) {
                sy5.h(this.j, "你还未开启地理位置授权，无法购买此服务", 1);
                return;
            } else if (locationExI == null) {
                sy5.h(this.j, "你还未开启地理位置授权，无法购买此服务", 1);
                return;
            }
        }
        zw4.e(new f(i2, locationExI));
    }

    @qm5
    public void onCitySelectionEvent(uc0 uc0Var) {
        if (uc0Var == null || uc0Var.a() == null || uc0Var.a().isEmpty()) {
            return;
        }
        this.J.clear();
        this.J.addAll(uc0Var.a());
        D0();
        O0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.getId() != R.id.buyButton) {
                if (view.getId() != R.id.dialog_close) {
                    if (view.getId() == R.id.bug_info_text2) {
                        ap3.a().B(this.j, nl0.q + "/popup/#/boost/illustrate");
                        return;
                    }
                    return;
                }
                this.B = false;
                SuperExposeDialogInfo superExposeDialogInfo = this.s;
                if (superExposeDialogInfo != null) {
                    r0(superExposeDialogInfo.showRetain);
                }
                if (!this.B) {
                    dismiss();
                }
                HashMap map = new HashMap();
                map.put("from", String.valueOf(this.u));
                map.put("welfareType", String.valueOf(this.z));
                map.put(LxAdConst.EventKeyParams.KEY_PARAM_REQUESTID, this.h0);
                zn6.h("boost_SalesPop_CloseButton", "click", map);
                return;
            }
            HashMap map2 = new HashMap();
            map2.put("from", String.valueOf(this.u));
            map2.put("default_sku", String.valueOf(this.v));
            map2.put("sku", String.valueOf(this.w));
            map2.put("welfareType", String.valueOf(this.z));
            map2.put(LxAdConst.EventKeyParams.KEY_PARAM_REQUESTID, this.h0);
            SuperExposeCardItem superExposeCardItem = this.A;
            if (superExposeCardItem != null && superExposeCardItem.type == 3 && !this.J.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                Iterator<LbsSquareSuperCityListResult> it = this.J.iterator();
                while (it.hasNext()) {
                    String str = it.next().cityName;
                    if (str != null) {
                        arrayList.add(str);
                    }
                }
                map2.put("choose_city", arrayList);
            }
            zn6.j("boost_SalesPop_BuyButton", "click", map2);
            if (this.S.isSelected()) {
                o0(1);
            } else {
                I0();
            }
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @qm5
    public void onPermissionRequestResultEvent(sg4 sg4Var) {
        if (sg4Var == null) {
            return;
        }
        if (!sg4Var.f20737a) {
            Toast.makeText(this.j, "未授予定位权限，无法选择城市哦", 0).show();
        } else {
            if (this.o0) {
                return;
            }
            L0();
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, android.app.Dialog
    public void onStart() {
        super.onStart();
        LogUtil.i("SuperExposeDialogView", "onStart");
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onStop() {
        super.onStop();
        LogUtil.i("SuperExposeDialogView", "onStop");
    }

    public final void p0(int i2) {
        if (i2 > 0) {
            this.e0 = i2;
            y0();
            this.V.setText(av4.f(this.e0));
        }
    }

    public final void q0() {
        if (this.L) {
            boolean zB = tg4.b(com.zenmen.palmchat.c.b(), com.kuaishou.weapon.p0.g.g);
            if (!com.zenmen.palmchat.location.b.f(com.zenmen.palmchat.c.b())) {
                ry5.a("请打开位置服务");
                Intent intent = new Intent();
                intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
                try {
                    getContext().startActivity(intent);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            if (!zB) {
                Activity activity = this.i;
                if (activity instanceof FrameworkBaseActivity) {
                    BaseActivityPermissionDispatcher.b((FrameworkBaseActivity) activity, BaseActivityPermissionDispatcher.PermissionType.LOCATION, BaseActivityPermissionDispatcher.PermissionUsage.SUPER_EXPOSE_LOCATION);
                    return;
                } else {
                    Toast.makeText(this.j, "你还未开启地理位置授权，无法选择城市哦", 0).show();
                    return;
                }
            }
            LocationEx locationExI = q05.i();
            if (locationExI != null && !TextUtils.isEmpty(locationExI.getCityCode())) {
                n0();
            } else {
                if (this.o0) {
                    return;
                }
                L0();
            }
        }
    }

    public void r0(boolean z) {
        String strE = v4.e(com.zenmen.palmchat.c.b());
        if (TextUtils.isEmpty(strE)) {
            return;
        }
        long jI = SPUtil.f14322a.i(SPUtil.SCENE.APP_COMMON, "key_showsuperexposedialog_time" + strE, 0L);
        if (z) {
            Boolean bool = this.C;
            if (bool != null && !bool.booleanValue()) {
                N0();
            } else if (jI >= 3) {
                N0();
            }
        }
    }

    @qm5
    public void refundEvent(zu4 zu4Var) {
        LogUtil.d("RefundManager", "SuperDialogView refundEvent " + zu4Var);
        if (zu4Var != null) {
            int i2 = zu4Var.f22517a;
            if (i2 == 1 || i2 == 2) {
                s0(1, 20, false);
            }
        }
    }

    public final void s0(int i2, int i3, boolean z) {
        LogUtil.i("RefundManager", "checkSuperRefund request start");
        zw4.e(new s());
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        av4.f1580a = true;
        LocationEx locationExI = q05.i();
        if (locationExI != null && !TextUtils.isEmpty(locationExI.getCityCode())) {
            String cityCode = locationExI.getCityCode();
            String str = (String) q05.k("key_super_expose_last_city_code", "");
            q05.w("key_super_expose_last_city_code", cityCode);
            if (!TextUtils.isEmpty(str) && !str.equals(cityCode)) {
                q05.t("key_super_expose_selected_cities");
            }
        }
        HashMap map = new HashMap();
        map.put("from", String.valueOf(this.u));
        map.put("welfareType", String.valueOf(this.z));
        map.put(LxAdConst.EventKeyParams.KEY_PARAM_REQUESTID, this.h0);
        zn6.h("boost_SalesPop", "view", map);
        v0();
    }

    public final void t0() {
        Timer timer = this.Y;
        if (timer != null) {
            timer.cancel();
            this.Y = null;
        }
        SVGAImageView sVGAImageView = this.W;
        if (sVGAImageView != null) {
            sVGAImageView.stopAnimation();
            this.W.clear();
        }
    }

    public final String u0() {
        ContactInfoItem contactInfoItemA;
        String strE = v4.e(com.zenmen.palmchat.c.b());
        return (TextUtils.isEmpty(strE) || (contactInfoItemA = dn0.a(strE)) == null) ? "" : contactInfoItemA.getAge();
    }

    public void v0() {
        this.N = false;
        com.zenmen.palmchat.paidservices.superexpose.a.b().d(new x());
    }

    public final int w0() {
        ContactInfoItem contactInfoItemA;
        String strE = v4.e(com.zenmen.palmchat.c.b());
        if (TextUtils.isEmpty(strE) || (contactInfoItemA = dn0.a(strE)) == null) {
            return 0;
        }
        return contactInfoItemA.getGender();
    }

    public final void x0() {
        this.U = this.h.findViewById(R.id.super_redpkg_all_layout);
        this.V = (TextView) this.h.findViewById(R.id.super_redpkg_time);
        this.W = (SVGAImageView) this.h.findViewById(R.id.super_redpkg_img);
        s0(0, 10, true);
        this.U.setOnClickListener(new r());
    }

    public final void y0() {
        LogUtil.d("RefundManager", "initTimer mAllTimer " + this.Y);
        if (this.Y == null) {
            Timer timer = new Timer();
            this.Y = timer;
            timer.schedule(new v(), 1000L, 1000L);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class o implements i53 {
        public o() {
        }

        @Override // defpackage.i53
        public void onLocationReceived(LocationEx locationEx, int i, String str) {
            SuperExposeDialogView superExposeDialogView = SuperExposeDialogView.this;
            superExposeDialogView.o0 = false;
            if (i != 0 || locationEx == null) {
                return;
            }
            superExposeDialogView.n0();
        }

        @Override // defpackage.i53
        public void onRegeocodeSearched(String str) {
        }

        @Override // defpackage.i53
        public void onLocationSearchResultGot(int i, List<LocationEx> list, n53 n53Var) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class u implements c15.e {
        public u() {
        }

        @Override // c15.e
        public void onPlay(@NonNull List<? extends File> list) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements ky {
        public e() {
        }

        @Override // defpackage.ky
        public void a(Object obj) {
            SuperExposeDialogView.this.S.setSelected(true);
            SuperExposeDialogView.this.o0(1);
        }

        @Override // defpackage.ky
        public void onCancel() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class t implements c15.d {
        public t() {
        }

        @Override // c15.d
        public void onComplete(@NonNull m15 m15Var) {
            SuperExposeDialogView.this.W.setVideoItem(m15Var);
            SuperExposeDialogView.this.W.startAnimation();
        }

        @Override // c15.d
        public void onError() {
        }
    }
}
