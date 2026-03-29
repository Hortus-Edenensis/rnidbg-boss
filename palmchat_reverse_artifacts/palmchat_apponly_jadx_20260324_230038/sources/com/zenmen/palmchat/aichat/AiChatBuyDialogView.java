package com.zenmen.palmchat.aichat;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.cdo.oaps.ad.OapsKey;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.LXBottomSheetDialog;
import defpackage.a46;
import defpackage.ap3;
import defpackage.az2;
import defpackage.ds0;
import defpackage.gk2;
import defpackage.go2;
import defpackage.hk2;
import defpackage.ky;
import defpackage.l50;
import defpackage.nl0;
import defpackage.qm5;
import defpackage.r8;
import defpackage.sw4;
import defpackage.sy5;
import defpackage.u93;
import defpackage.v8;
import defpackage.zw4;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AiChatBuyDialogView extends LXBottomSheetDialog {
    public TextView A;
    public TextView B;
    public TextView C;
    public TextView E;
    public TextView F;
    public TextView G;
    public TextView H;
    public TextView I;
    public TextView J;
    public TextView K;
    public ImageView L;
    public TextView M;
    public TextView N;
    public TextView O;
    public TextView P;
    public TextView Q;
    public TextView R;
    public String S;
    public String T;
    public String U;
    public String V;
    public AiChatMsgBuySkuBean W;
    public int X;
    public AiChatMsgSku Y;
    public int Z;
    public int e0;
    public int f0;
    public boolean g0;
    public ViewGroup h;
    public String h0;
    public Activity i;
    public boolean i0;
    public Context j;
    public ImageView k;
    public ImageView l;
    public View m;
    public TextView n;
    public TextView o;
    public View p;
    public TextView q;
    public ImageView r;
    public View s;
    public View t;
    public View u;
    public View v;
    public View w;
    public View x;
    public TextView y;
    public TextView z;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r8 f12476a;

        public a(r8 r8Var) {
            this.f12476a = r8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            AiChatBuyDialogView.this.M(this.f12476a.d);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends go2<LXBaseNetBean<JSONObject>> {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements gk2 {
            public a() {
            }

            @Override // defpackage.gk2
            public void a(boolean z) {
                if (z) {
                    AiChatBuyDialogView.this.X(0);
                }
            }
        }

        public c() {
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            map.put("fuid", Long.valueOf(AiChatBuyDialogView.this.W.fuid));
            map.put(DeviceInfoUtil.UID_TAG, Long.valueOf(AiChatBuyDialogView.this.W.uid));
            map.put("gender", Integer.valueOf(AiChatBuyDialogView.this.f0));
            map.put(OapsKey.KEY_PRICE, Integer.valueOf(AiChatBuyDialogView.this.Y.price));
            map.put("productId", AiChatBuyDialogView.this.Y.productId);
            map.put("pushScene", AiChatBuyDialogView.this.h0);
            map.put("payScene", AiChatBuyDialogView.this.e0 + "");
            return sw4.b(1, nl0.z + "/customer.service.virtual.buy", map).f(true);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<JSONObject> lXBaseNetBean, Exception exc) {
            LogUtil.d("AiChatPeopleManagerTag", "AiChatDialogBuy startBuy onResult=" + az2.c(lXBaseNetBean));
            if (lXBaseNetBean != null) {
                int i = lXBaseNetBean.resultCode;
                if (i != 0) {
                    if (i == -1004) {
                        v8.L(AiChatBuyDialogView.this.j, AiChatBuyDialogView.this.Y.price, AiChatBuyDialogView.this.e0, new a(), AiChatBuyDialogView.this.h0, AiChatBuyDialogView.this.W.fuid + "");
                        sy5.h(AiChatBuyDialogView.this.j, "连信豆不足，守护开通失败", 0);
                        return;
                    }
                    return;
                }
                r8 r8Var = new r8(2);
                v8.J(AiChatBuyDialogView.this.W.fuid + "", AiChatBuyDialogView.this.W.uid + "", 1);
                r8Var.d = 1;
                ds0.a().b(r8Var);
                sy5.h(AiChatBuyDialogView.this.j, "你已成功开通守护，继续和" + AiChatBuyDialogView.this.W.fNickName + "畅聊吧", 0);
                AiChatBuyDialogView.this.dismiss();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements hk2 {
        public d() {
        }

        @Override // defpackage.hk2
        public void onResult(int i) {
            LogUtil.d("AiChatPeopleManagerTag", "AiChatBuyDialogView setData postCheckOpenGuard result " + i);
            AiChatBuyDialogView.this.M(i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            AiChatBuyDialogView.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            AiChatBuyDialogView.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AiChatBuyDialogView.this.W(0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AiChatBuyDialogView.this.W(1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AiChatBuyDialogView.this.W(2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            AiChatBuyDialogView.this.L.setSelected(!AiChatBuyDialogView.this.L.isSelected());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class l implements View.OnClickListener {
        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            ap3.a().B(AiChatBuyDialogView.this.i, "https://storage.lianxinapp.com/mdc/res/v5/1/9ugxnorjls-13-4-a27b8ee997b04e3eaff63b905de96b76-sxf0gy");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class m implements View.OnClickListener {
        public m() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            if (AiChatBuyDialogView.this.L.isSelected()) {
                AiChatBuyDialogView.this.X(0);
            } else {
                AiChatBuyDialogView.this.Y();
            }
            if (AiChatBuyDialogView.this.W != null) {
                v8.s(AiChatBuyDialogView.this.W.fuid + "", AiChatBuyDialogView.this.e0, AiChatBuyDialogView.this.Z, AiChatBuyDialogView.this.W.ttl, AiChatBuyDialogView.this.W.defaultSelectProductId, AiChatBuyDialogView.this.Y);
            }
        }
    }

    public AiChatBuyDialogView(@NonNull Context context, int i2, int i3, String str) {
        super(context, i2);
        this.i = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.S = "#3E77FD";
        this.T = "#222222";
        this.U = "#88ABFD";
        this.V = "#CACCCF";
        this.Z = 1;
        this.i0 = false;
        ds0.a().c(this);
        setCanceledOnTouchOutside(true);
        this.e0 = i3;
        if (context instanceof Activity) {
            this.i = (Activity) context;
        }
        this.h0 = str;
        this.j = context;
        this.h = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.layout_aichat_buy_dialog, (ViewGroup) null);
        N();
    }

    public final void M(int i2) {
        if (i2 != 1) {
            this.Z = 1;
            this.p.setVisibility(8);
            this.n.setVisibility(0);
            AiChatMsgBuySkuBean aiChatMsgBuySkuBean = this.W;
            if (aiChatMsgBuySkuBean == null || TextUtils.isEmpty(aiChatMsgBuySkuBean.fNickName)) {
                return;
            }
            this.n.setText("守护" + this.W.fNickName);
            return;
        }
        this.p.setVisibility(0);
        this.n.setVisibility(8);
        this.Z = 2;
        AiChatMsgBuySkuBean aiChatMsgBuySkuBean2 = this.W;
        if (aiChatMsgBuySkuBean2 != null) {
            long j2 = aiChatMsgBuySkuBean2.ttl;
            if (j2 > 0) {
                int i3 = (int) (j2 / 86400);
                if (j2 % 86400 != 0) {
                    i3++;
                }
                this.o.setText(i3 + "");
            }
        }
    }

    public final void N() {
        this.k = (ImageView) this.h.findViewById(R.id.mine_avatar_img);
        this.l = (ImageView) this.h.findViewById(R.id.other_avatar_img);
        View viewFindViewById = this.h.findViewById(R.id.close_img);
        this.m = viewFindViewById;
        viewFindViewById.setOnClickListener(new e());
        this.h.findViewById(R.id.ai_chat_buy_all_layout).setOnClickListener(new f());
        this.h.findViewById(R.id.ai_chat_show_layout).setOnClickListener(new g());
        this.n = (TextView) this.h.findViewById(R.id.ai_name_title);
        this.p = this.h.findViewById(R.id.name_time_layout);
        this.o = (TextView) this.h.findViewById(R.id.name_time_view);
        this.q = (TextView) this.h.findViewById(R.id.location_name_view);
        this.O = (TextView) this.h.findViewById(R.id.ai_chat_buy_chat_desc);
        this.P = (TextView) this.h.findViewById(R.id.ai_chat_buy_yuyin_desc);
        this.Q = (TextView) this.h.findViewById(R.id.ai_chat_buy_pic_desc);
        this.R = (TextView) this.h.findViewById(R.id.ai_chat_buy_video_desc);
        this.r = (ImageView) this.h.findViewById(R.id.sex_img);
        this.s = this.h.findViewById(R.id.sku_buy_layout1);
        this.t = this.h.findViewById(R.id.sku_buy_layout2);
        this.u = this.h.findViewById(R.id.sku_buy_layout3);
        this.s.setOnClickListener(new h());
        this.t.setOnClickListener(new i());
        this.u.setOnClickListener(new j());
        this.v = this.h.findViewById(R.id.sku_buy_detail1);
        this.w = this.h.findViewById(R.id.sku_buy_detail2);
        this.x = this.h.findViewById(R.id.sku_buy_detail3);
        this.y = (TextView) this.h.findViewById(R.id.sku_buy_top1);
        this.z = (TextView) this.h.findViewById(R.id.sku_buy_top2);
        this.A = (TextView) this.h.findViewById(R.id.sku_buy_top3);
        this.B = (TextView) this.h.findViewById(R.id.sku_buy_1_time);
        this.F = (TextView) this.h.findViewById(R.id.sku_buy_2_time);
        this.I = (TextView) this.h.findViewById(R.id.sku_buy_3_time);
        this.C = (TextView) this.h.findViewById(R.id.sku_buy_1_price);
        this.G = (TextView) this.h.findViewById(R.id.sku_buy_2_price);
        this.J = (TextView) this.h.findViewById(R.id.sku_buy_3_price);
        this.E = (TextView) this.h.findViewById(R.id.sku_buy_1_num);
        this.H = (TextView) this.h.findViewById(R.id.sku_buy_2_num);
        this.K = (TextView) this.h.findViewById(R.id.sku_buy_3_num);
        ImageView imageView = (ImageView) this.h.findViewById(R.id.privacy_iv);
        this.L = imageView;
        imageView.setOnClickListener(new k());
        TextView textView = (TextView) this.h.findViewById(R.id.bug_info_text2);
        this.M = textView;
        textView.setOnClickListener(new l());
        TextView textView2 = (TextView) this.h.findViewById(R.id.ai_sku_btn);
        this.N = textView2;
        textView2.setOnClickListener(new m());
    }

    public void O(AiChatMsgBuySkuBean aiChatMsgBuySkuBean) {
        if (aiChatMsgBuySkuBean == null || !this.g0) {
            return;
        }
        this.W = aiChatMsgBuySkuBean;
        int i2 = 0;
        M(0);
        v8.H(new d(), aiChatMsgBuySkuBean.uid, aiChatMsgBuySkuBean.fuid);
        if (!TextUtils.isEmpty(aiChatMsgBuySkuBean.fHeadIconUrl)) {
            a46.u(aiChatMsgBuySkuBean.fHeadIconUrl, this.l, R.drawable.default_portrait);
        }
        if (!TextUtils.isEmpty(aiChatMsgBuySkuBean.headIconUrl)) {
            a46.u(aiChatMsgBuySkuBean.headIconUrl, this.k, R.drawable.default_portrait);
        }
        if (TextUtils.isEmpty(aiChatMsgBuySkuBean.cityName)) {
            this.q.setVisibility(8);
        } else {
            this.q.setVisibility(0);
            this.q.setText(aiChatMsgBuySkuBean.cityName);
        }
        if (!TextUtils.isEmpty(aiChatMsgBuySkuBean.buttonName)) {
            this.N.setText(aiChatMsgBuySkuBean.buttonName);
        }
        if (aiChatMsgBuySkuBean.gender == 1) {
            this.r.setImageResource(R.drawable.icon_female);
            this.O.setText("和她随时随地畅聊");
            this.P.setText("收听她的语音消息");
            this.Q.setText("查看她的专享照片");
            this.R.setText("查看她的专享视频");
        } else {
            this.r.setImageResource(R.drawable.icon_male);
            this.O.setText("和他随时随地畅聊");
            this.P.setText("收听他的语音消息");
            this.Q.setText("查看他的专享照片");
            this.R.setText("查看他的专享视频");
        }
        String str = aiChatMsgBuySkuBean.defaultSelectProductId;
        List<AiChatMsgSku> list = aiChatMsgBuySkuBean.sku;
        if (list != null && list.size() > 0) {
            int i3 = 0;
            for (int i4 = 0; i4 < aiChatMsgBuySkuBean.sku.size(); i4++) {
                AiChatMsgSku aiChatMsgSku = aiChatMsgBuySkuBean.sku.get(i4);
                if (aiChatMsgSku != null) {
                    int i5 = (int) (aiChatMsgSku.dayNum / 30.0f);
                    if (i4 == 0) {
                        this.s.setVisibility(0);
                        this.B.setText(i5 + "个月");
                        this.C.setText(aiChatMsgSku.price + "连信豆");
                        if (!TextUtils.isEmpty(aiChatMsgSku.subTitle)) {
                            this.E.setText(aiChatMsgSku.subTitle);
                        }
                        if (TextUtils.isEmpty(aiChatMsgSku.tag)) {
                            this.y.setVisibility(8);
                        } else {
                            this.y.setVisibility(0);
                            this.y.setText(aiChatMsgSku.tag);
                        }
                    } else if (i4 == 1) {
                        this.t.setVisibility(0);
                        this.F.setText(i5 + "个月");
                        this.G.setText(aiChatMsgSku.price + "连信豆");
                        if (!TextUtils.isEmpty(aiChatMsgSku.subTitle)) {
                            this.H.setText(aiChatMsgSku.subTitle);
                        }
                        if (TextUtils.isEmpty(aiChatMsgSku.tag)) {
                            this.z.setVisibility(8);
                        } else {
                            this.z.setVisibility(0);
                            this.z.setText(aiChatMsgSku.tag);
                        }
                    } else if (i4 == 2) {
                        this.u.setVisibility(0);
                        this.I.setText(i5 + "个月");
                        this.J.setText(aiChatMsgSku.price + "连信豆");
                        if (!TextUtils.isEmpty(aiChatMsgSku.subTitle)) {
                            this.K.setText(aiChatMsgSku.subTitle);
                        }
                        if (TextUtils.isEmpty(aiChatMsgSku.tag)) {
                            this.A.setVisibility(8);
                        } else {
                            this.A.setVisibility(0);
                            this.A.setText(aiChatMsgSku.tag);
                        }
                    }
                    if (!TextUtils.isEmpty(str) && str.equals(aiChatMsgSku.productId)) {
                        i3 = i4;
                    }
                }
            }
            i2 = i3;
        }
        LogUtil.d("AiChatPeopleManagerTag", "AiChatBuyDialogView setData index " + i2);
        W(i2);
        v8.r(this.W.fuid + "", this.e0);
    }

    public void P(int i2) {
        this.f0 = i2;
    }

    public final void Q() {
        this.v.setBackgroundResource(R.drawable.ai_chat_buy_sku_click_bg);
        this.B.setTextColor(Color.parseColor(this.S));
        this.C.setTextColor(Color.parseColor(this.S));
        this.E.setTextColor(Color.parseColor(this.U));
    }

    public final void R() {
        this.v.setBackgroundResource(R.drawable.ai_chat_buy_sku_normal_bg);
        this.B.setTextColor(Color.parseColor(this.T));
        this.C.setTextColor(Color.parseColor(this.T));
        this.E.setTextColor(Color.parseColor(this.V));
    }

    public final void S() {
        this.w.setBackgroundResource(R.drawable.ai_chat_buy_sku_click_bg);
        this.F.setTextColor(Color.parseColor(this.S));
        this.G.setTextColor(Color.parseColor(this.S));
        this.H.setTextColor(Color.parseColor(this.U));
    }

    public final void T() {
        this.w.setBackgroundResource(R.drawable.ai_chat_buy_sku_normal_bg);
        this.F.setTextColor(Color.parseColor(this.T));
        this.G.setTextColor(Color.parseColor(this.T));
        this.H.setTextColor(Color.parseColor(this.V));
    }

    public final void U() {
        this.x.setBackgroundResource(R.drawable.ai_chat_buy_sku_click_bg);
        this.I.setTextColor(Color.parseColor(this.S));
        this.J.setTextColor(Color.parseColor(this.S));
        this.K.setTextColor(Color.parseColor(this.U));
    }

    public final void V() {
        this.x.setBackgroundResource(R.drawable.ai_chat_buy_sku_normal_bg);
        this.I.setTextColor(Color.parseColor(this.T));
        this.J.setTextColor(Color.parseColor(this.T));
        this.K.setTextColor(Color.parseColor(this.V));
    }

    public final void W(int i2) {
        List<AiChatMsgSku> list;
        this.X = i2;
        AiChatMsgBuySkuBean aiChatMsgBuySkuBean = this.W;
        if (aiChatMsgBuySkuBean != null && (list = aiChatMsgBuySkuBean.sku) != null) {
            int size = list.size();
            int i3 = this.X;
            if (size > i3) {
                this.Y = this.W.sku.get(i3);
            }
        }
        if (i2 == 0) {
            if (this.s.getVisibility() == 0) {
                Q();
            }
            if (this.t.getVisibility() == 0) {
                T();
            }
            if (this.u.getVisibility() == 0) {
                V();
                return;
            }
            return;
        }
        if (i2 == 1) {
            if (this.s.getVisibility() == 0) {
                R();
            }
            if (this.t.getVisibility() == 0) {
                S();
            }
            if (this.u.getVisibility() == 0) {
                V();
                return;
            }
            return;
        }
        if (i2 == 2) {
            if (this.s.getVisibility() == 0) {
                R();
            }
            if (this.t.getVisibility() == 0) {
                T();
            }
            if (this.u.getVisibility() == 0) {
                U();
            }
        }
    }

    public final void X(int i2) {
        if (this.Y == null || this.i0) {
            return;
        }
        zw4.e(new c());
    }

    public final void Y() {
        Activity activity = this.i;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        AiChatBuyAgreementDialog aiChatBuyAgreementDialog = new AiChatBuyAgreementDialog(this.i, new b());
        aiChatBuyAgreementDialog.w(false);
        aiChatBuyAgreementDialog.show();
    }

    @qm5
    public void aiChatEvent(r8 r8Var) {
        if (r8Var == null || r8Var.a() != 2) {
            return;
        }
        LogUtil.d("AiChatPeopleManagerTag", "changeUiByGuardStatus aiChatEvent TYPE_MSG_BUY_SUCCESS");
        u93.c(new a(r8Var));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.g0) {
            try {
                super.dismiss();
                Activity activity = this.i;
                if (activity instanceof AiCHatBuyDialogBaseActivity) {
                    activity.finish();
                }
                ds0.a().d(this);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.zenmen.palmchat.widget.LXBottomSheetDialog
    public View n() {
        return this.h;
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            this.g0 = true;
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ky {
        public b() {
        }

        @Override // defpackage.ky
        public void a(Object obj) {
            AiChatBuyDialogView.this.X(0);
        }

        @Override // defpackage.ky
        public void onCancel() {
        }
    }
}
