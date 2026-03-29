package com.zenmen.palmchat.chat.aigreeting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.opensource.svgaplayer.SVGAImageView;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.palmchat.chat.ChatterAdapter;
import com.zenmen.palmchat.chat.InputFragment;
import com.zenmen.palmchat.chat.aigreeting.AiGreetingBuyDialog;
import com.zenmen.palmchat.chat.aigreeting.vo.AiGreetingInfo;
import com.zenmen.palmchat.chat.aigreeting.vo.AiGreetingListItem;
import com.zenmen.palmchat.chat.aigreeting.vo.AiGreetingStateInfo;
import com.zenmen.palmchat.chat.aigreeting.vo.SkuConfig;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.settings.AiGreetingSettingActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.voiceroom.adapter.RcyHolder;
import com.zenmen.palmchat.voiceroom.adapter.RcySAdapter;
import defpackage.a65;
import defpackage.a9;
import defpackage.b9;
import defpackage.c15;
import defpackage.io2;
import defpackage.ir5;
import defpackage.k86;
import defpackage.l50;
import defpackage.m15;
import defpackage.sy5;
import defpackage.v05;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a implements View.OnClickListener {
    public static String s = "AiGreetingChatUIHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f12733a;
    public AiLoadingTextView b;
    public TextView c;
    public TextView d;
    public View e;
    public View f;
    public View g;
    public View h;
    public RecyclerView i;
    public final InputFragment.h1 k;
    public final j l;
    public final Activity m;
    public final View n;
    public final View o;
    public k r;
    public RcySAdapter<AiGreetingListItem, RcyHolder> j = null;
    public boolean p = false;
    public boolean q = true;

    /* JADX INFO: renamed from: com.zenmen.palmchat.chat.aigreeting.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class ViewOnClickListenerC0972a implements View.OnClickListener {
        public ViewOnClickListenerC0972a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            a.this.r.d();
            a.this.k.d();
            a.this.r();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends RcySAdapter<AiGreetingListItem, RcyHolder> {
        public b(Context context, int i) {
            super(context, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void l(AiGreetingListItem aiGreetingListItem, View view) {
            if (!l50.a() && aiGreetingListItem.state == 0) {
                zn6.i("AiChat_entrance_panel_clicksend", b9.b(a.this.k.b()));
                a.this.l.a(aiGreetingListItem.title);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(AiGreetingListItem aiGreetingListItem, View view) {
            if (!l50.a() && aiGreetingListItem.state == 0) {
                zn6.i("AiChat_entrance_panel_click_edit", b9.b(a.this.k.b()));
                a.this.l.b(aiGreetingListItem.title);
            }
        }

        @Override // com.zenmen.palmchat.voiceroom.adapter.RcySAdapter
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public void h(RcyHolder rcyHolder, final AiGreetingListItem aiGreetingListItem, int i) {
            AiGreetingContentItemView aiGreetingContentItemView = (AiGreetingContentItemView) rcyHolder.l(R.id.content);
            View viewL = rcyHolder.l(R.id.icon);
            aiGreetingContentItemView.update(aiGreetingListItem.title);
            if (aiGreetingListItem.title.contains("||")) {
                viewL.setVisibility(4);
            } else {
                viewL.setVisibility(0);
            }
            rcyHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: y8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f22157a.l(aiGreetingListItem, view);
                }
            });
            viewL.setOnClickListener(new View.OnClickListener() { // from class: z8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f22376a.m(aiGreetingListItem, view);
                }
            });
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements io2<LXBaseNetBean<SkuConfig>> {
        public c() {
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<SkuConfig> lXBaseNetBean, Exception exc) {
            SkuConfig skuConfig;
            if (lXBaseNetBean == null || !lXBaseNetBean.isSuccess() || (skuConfig = lXBaseNetBean.data) == null) {
                return;
            }
            if (skuConfig.canSend()) {
                a.this.B(true);
            } else {
                sy5.h(AppContext.getContext(), "当天帮聊次数已用尽！", 0);
                a.this.v();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements AiGreetingBuyDialog.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f12736a;
        public final /* synthetic */ Runnable b;

        public d(boolean z, Runnable runnable) {
            this.f12736a = z;
            this.b = runnable;
        }

        @Override // com.zenmen.palmchat.chat.aigreeting.AiGreetingBuyDialog.f
        public void a() {
            if (this.f12736a) {
                a.this.B(true);
            }
            Runnable runnable = this.b;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // com.zenmen.palmchat.chat.aigreeting.AiGreetingBuyDialog.f
        public void b(boolean z) {
            HashMap<String, String> mapB = b9.b(a.this.k.b());
            mapB.put("menu", z ? "monthly_package" : "second_package");
            zn6.i("AiChat_recharge_popclick", mapB);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements io2<LXBaseNetBean<SkuConfig>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f12737a;

        public e(Runnable runnable) {
            this.f12737a = runnable;
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<SkuConfig> lXBaseNetBean, Exception exc) {
            if (lXBaseNetBean == null || !lXBaseNetBean.isSuccess() || lXBaseNetBean.data == null) {
                return;
            }
            a.this.w(false, this.f12737a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ChatterAdapter chatterAdapterA = a.this.k.a();
            if (chatterAdapterA != null) {
                chatterAdapterA.E().g(true);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f12739a;

        public g(Runnable runnable) {
            this.f12739a = runnable;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            this.f12739a.run();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h implements io2<LXBaseNetBean<AiGreetingInfo>> {
        public h() {
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<AiGreetingInfo> lXBaseNetBean, Exception exc) {
            String str;
            int i;
            a.this.p = false;
            List<AiGreetingListItem> list = AiGreetingListItem.getList(lXBaseNetBean);
            a.this.E();
            if (list.size() > 0) {
                a.this.F(0, list);
            } else {
                a.this.F(2, null);
            }
            if (!z || lXBaseNetBean == null) {
                str = "";
                i = -10086;
            } else {
                i = lXBaseNetBean.resultCode;
                str = lXBaseNetBean.errorMsg;
            }
            HashMap<String, String> mapB = b9.b(a.this.k.b());
            mapB.put("errorcode", String.valueOf(i));
            mapB.put("errormsg", str);
            mapB.put("result", list.size() > 0 ? "success" : "fail");
            zn6.i("AiChat_entrance_panel_result", mapB);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i extends MaterialDialog.e {

        /* JADX INFO: renamed from: com.zenmen.palmchat.chat.aigreeting.a$i$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0973a implements io2<LXBaseNetBean<SkuConfig>> {
            public C0973a() {
            }

            @Override // defpackage.io2
            public void onResult(boolean z, LXBaseNetBean<SkuConfig> lXBaseNetBean, Exception exc) {
                if (lXBaseNetBean == null || !lXBaseNetBean.isSuccess()) {
                    return;
                }
                a.this.B(true);
            }
        }

        public i() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            a9.f(new C0973a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface j {
        void a(String str);

        void b(String str);

        void c(boolean z);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface l {
        void a(boolean z);
    }

    public a(Activity activity, View view, View view2, View view3, InputFragment.h1 h1Var, j jVar) {
        this.r = null;
        this.m = activity;
        this.f12733a = view3;
        this.n = view;
        this.o = view2;
        this.r = new k(view2);
        this.k = h1Var;
        this.l = jVar;
        o();
    }

    public final void A() {
        if (!b9.d().g()) {
            F(2, null);
            return;
        }
        F(1, null);
        if (!b9.d().f().hasRemainCountFroRequest()) {
            sy5.h(AppContext.getContext(), "当天帮聊次数已用尽！", 0);
            B(false);
            v();
        } else if (this.k != null) {
            this.p = true;
            b9.d().k(this.k.b(), 2, this.k.c(), new h());
        }
    }

    public void B(boolean z) {
        D(z, true);
    }

    public void C(ChatItem chatItem, l lVar) {
        boolean zJ = j();
        if (zJ) {
            zn6.i("AiChat_entrance_show", b9.b(chatItem));
            this.r.e(true);
        } else {
            this.r.e(false);
        }
        lVar.a(zJ);
    }

    public final void D(boolean z, boolean z2) {
        this.l.c(z);
        if (!z) {
            this.n.setVisibility(8);
            n();
            return;
        }
        this.n.setVisibility(0);
        z();
        E();
        if (!b9.d().i()) {
            this.i.setVisibility(8);
            this.h.setVisibility(0);
            return;
        }
        this.i.setVisibility(0);
        this.h.setVisibility(8);
        if (z2) {
            A();
        }
    }

    public final void E() {
        AiGreetingStateInfo aiGreetingStateInfoF = b9.d().f();
        this.c.setText(aiGreetingStateInfoF.getRemainCountForShow());
        if (aiGreetingStateInfoF.remainDay <= 0) {
            this.d.setVisibility(4);
            return;
        }
        this.d.setVisibility(0);
        this.d.setText("剩余" + aiGreetingStateInfoF.remainDay + "天");
    }

    public final void F(int i2, List<AiGreetingListItem> list) {
        if (i2 == 0) {
            this.i.setVisibility(0);
            this.j.g(list, true);
            this.b.setVisibility(8);
            this.b.stopLoading();
            return;
        }
        if (i2 == 1) {
            this.i.setVisibility(8);
            this.b.setVisibility(0);
            this.b.startLoading("生成中", "正在分析对方资料信息");
        } else if (i2 == 2) {
            this.i.setVisibility(8);
            this.b.setVisibility(0);
            this.b.stopLoading();
            this.b.setText("生成失败，刷新重试");
        }
    }

    public boolean j() {
        ChatItem chatItemB = this.k.b();
        return b9.j() && (chatItemB instanceof ContactInfoItem) && !a65.e(chatItemB) && !a65.c(chatItemB);
    }

    public final void k() {
        if (j() && b9.d().g()) {
            this.r.c();
        }
    }

    public final void l() {
        if (!this.q) {
            sy5.h(AppContext.getContext(), "无法生成，对方太受欢迎！", 0);
        } else if (b9.d().g()) {
            t();
        } else {
            B(true);
            y();
        }
    }

    public final void m(Activity activity, Runnable runnable) {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
        if (sPUtil.a(scene, k86.a("key_ai_greeting_chat_privacy_auto_dialog"), false) || b9.d().g()) {
            return;
        }
        sPUtil.t(scene, k86.a("key_ai_greeting_chat_privacy_auto_dialog"), Boolean.TRUE);
        b9.d().l(activity, new g(runnable));
    }

    public void n() {
        if (this.f12733a.getVisibility() == 0) {
            this.f12733a.setVisibility(8);
            zn6.i("AiChat_entrance_panel_close", b9.b(this.k.b()));
        }
    }

    public final void o() {
        this.b = (AiLoadingTextView) this.f12733a.findViewById(R.id.state_content);
        this.c = (TextView) this.f12733a.findViewById(R.id.remainTv);
        this.d = (TextView) this.f12733a.findViewById(R.id.remainDay);
        View viewFindViewById = this.f12733a.findViewById(R.id.add);
        this.e = viewFindViewById;
        viewFindViewById.setOnClickListener(this);
        View viewFindViewById2 = this.f12733a.findViewById(R.id.refresh);
        this.f = viewFindViewById2;
        viewFindViewById2.setOnClickListener(this);
        View viewFindViewById3 = this.f12733a.findViewById(R.id.setting);
        this.g = viewFindViewById3;
        viewFindViewById3.setOnClickListener(this);
        this.i = (RecyclerView) this.f12733a.findViewById(R.id.aiGreetingList);
        View viewFindViewById4 = this.f12733a.findViewById(R.id.permissionLayout);
        this.h = viewFindViewById4;
        viewFindViewById4.setOnClickListener(this);
        this.o.setOnClickListener(new ViewOnClickListenerC0972a());
        b bVar = new b(this.f12733a.getContext(), R.layout.item_quicksend_ai_greeting);
        this.j = bVar;
        this.i.setAdapter(bVar);
        this.i.setLayoutManager(new LinearLayoutManager(this.f12733a.getContext(), 1, false));
        this.j.g(new ArrayList(), true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (l50.a()) {
            return;
        }
        if (!b9.d().g()) {
            y();
            return;
        }
        if (view.getId() == R.id.add) {
            zn6.i("AiChat_entrance_panel_clickrecharge", b9.b(this.k.b()));
            v();
            return;
        }
        if (view.getId() == R.id.refresh) {
            if (b9.d().i()) {
                if (this.p) {
                    sy5.h(AppContext.getContext(), "生成中，请勿频繁操作", 0);
                    return;
                } else {
                    zn6.i("AiChat_entrance_panel_click_refresh", b9.b(this.k.b()));
                    A();
                    return;
                }
            }
            return;
        }
        if (view.getId() == R.id.setting) {
            zn6.b("AiChat_entrance_panel_click_set");
            p();
        } else if (view.getId() == R.id.permissionLayout) {
            p();
        }
    }

    public final void p() {
        Intent intent = new Intent();
        intent.setClass(this.m, AiGreetingSettingActivity.class);
        this.m.startActivity(intent);
    }

    public void q() {
        LogUtil.i(s, "AiGreetingQuickRequestFail ");
        k();
    }

    public final void r() {
        boolean z = this.f12733a.getVisibility() == 0 && this.n.getVisibility() == 0;
        if (z) {
            B(false);
        } else {
            l();
        }
        HashMap<String, String> mapB = b9.b(this.k.b());
        mapB.put("panel", z ? "close" : "open");
        zn6.i("AiChat_entrance_click", mapB);
    }

    public void s() {
        boolean z;
        List<AiGreetingListItem> data;
        if (j()) {
            if (this.n.getVisibility() == 0 && this.f12733a.getVisibility() == 0) {
                RcySAdapter<AiGreetingListItem, RcyHolder> rcySAdapter = this.j;
                if (rcySAdapter == null || (data = rcySAdapter.getData()) == null) {
                    z = true;
                    D(true, z);
                } else {
                    Iterator<AiGreetingListItem> it = data.iterator();
                    while (it.hasNext()) {
                        if (it.next().state == 0) {
                            z = false;
                            break;
                        }
                    }
                    z = true;
                    D(true, z);
                }
            }
            m(this.m, new f());
        }
    }

    public final void t() {
        a9.f(new c());
    }

    public void u(boolean z) {
        this.q = z;
        LogUtil.i(s, "setCanSend " + z);
        if (z) {
            return;
        }
        k();
    }

    public void v() {
        w(true, null);
    }

    public final void w(boolean z, Runnable runnable) {
        new AiGreetingBuyDialog(this.m, new d(z, runnable)).show();
        zn6.i("AiChat_recharge_popshow", b9.b(this.k.b()));
    }

    public void x(Runnable runnable) {
        a9.f(new e(runnable));
    }

    public final void y() {
        b9.d().l(this.m, new i());
    }

    public final void z() {
        if (this.f12733a.getVisibility() == 8) {
            this.f12733a.setVisibility(0);
            zn6.i("AiChat_entrance_panel_show", b9.b(this.k.b()));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f12743a;
        public SVGAImageView b;
        public ImageView c;

        public k(View view) {
            this.f12743a = view;
            this.b = (SVGAImageView) view.findViewById(R.id.ai_greeting_icon1);
            this.c = (ImageView) view.findViewById(R.id.ai_greeting_icon2);
        }

        public void c() {
            int iF;
            LogUtil.i(a.s, "checkAndAnimation  ");
            String strA = ir5.a();
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
            if (!sPUtil.a(scene, "key_ai_greeting_enter_last_animation_time" + strA, false) && (iF = sPUtil.f(scene, "key_ai_greeting_enter_animation_count", 0)) < 5) {
                sPUtil.t(scene, "key_ai_greeting_enter_last_animation_time" + strA, Boolean.TRUE);
                sPUtil.t(scene, "key_ai_greeting_enter_animation_count", Integer.valueOf(iF + 1));
                this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.b.setFillMode(SVGAImageView.FillMode.Clear);
                this.b.setLoops(6);
                this.b.setClearsAfterDetached(true);
                c15.INSTANCE.b().n("svga/ai_greeting_entrance.svga", new C0974a(), null);
            }
        }

        public void d() {
            this.b.setVisibility(8);
            this.c.setVisibility(0);
        }

        public void e(boolean z) {
            if (!z) {
                this.f12743a.setVisibility(8);
                return;
            }
            boolean z2 = false;
            this.f12743a.setVisibility(0);
            if (b9.d().g() && a.this.k.a() != null && !a.this.k.a().E().f()) {
                z2 = true;
            }
            LogUtil.i(a.s, "updateEntrance canAnimation " + z2);
            if (z2) {
                c();
            }
        }

        /* JADX INFO: renamed from: com.zenmen.palmchat.chat.aigreeting.a$k$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0974a implements c15.d {
            public C0974a() {
            }

            @Override // c15.d
            public void onComplete(@NonNull m15 m15Var) {
                k.this.b.setVisibility(0);
                k.this.c.setVisibility(8);
                k.this.b.setVideoItem(m15Var);
                k.this.b.stepToPercentage(0.2d, false);
                k.this.b.startAnimation();
                k.this.b.setCallback(new C0975a());
            }

            /* JADX INFO: renamed from: com.zenmen.palmchat.chat.aigreeting.a$k$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C0975a implements v05 {
                public C0975a() {
                }

                @Override // defpackage.v05
                public void a() {
                    k.this.b.setVisibility(8);
                    k.this.c.setVisibility(0);
                }

                @Override // defpackage.v05
                public void c() {
                }

                @Override // defpackage.v05
                public void onPause() {
                }

                @Override // defpackage.v05
                public void b(int i, double d) {
                }
            }

            @Override // c15.d
            public void onError() {
            }
        }
    }
}
