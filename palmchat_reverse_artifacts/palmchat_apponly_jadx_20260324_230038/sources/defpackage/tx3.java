package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.maintab.DynamicConfigFragment;
import com.zenmen.palmchat.maintab.cell.AbsCellViewController;
import com.zenmen.palmchat.maintab.config.CellItem;
import com.zenmen.palmchat.maintab.config.GroupItem;
import com.zenmen.palmchat.maintab.config.TabItem;
import com.zenmen.palmchat.mine.view.LoopTextView;
import com.zenmen.palmchat.sync.MyTabOfNewVipCenterConfig;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.LightingAnimationView;
import com.zenmen.square.vip.VipEnterConfig;
import defpackage.fg6;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class tx3 extends AbsCellViewController implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f21089a;
    public RelativeLayout b;
    public TextView c;
    public LoopTextView d;
    public View e;
    public ImageView f;
    public FrameworkBaseActivity g;
    public com.zenmen.palmchat.sync.a h;
    public VipEnterConfig.VipCenter i;
    public int j = -1;
    public boolean k = false;
    public LinearLayout l;
    public TextView m;
    public LoopTextView n;
    public TextView o;
    public LightingAnimationView p;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements fg6.b {
        public a() {
        }

        @Override // fg6.b
        public void onFail(Exception exc) {
            LogUtil.i("getVip", "onFail: " + exc.getMessage());
        }

        @Override // fg6.b
        public void onSuccess(int i) {
            LogUtil.i("getVip", "onSuccess: vipType =" + i);
            tx3.this.k = i >= 0;
            tx3.this.h(i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        i("pagemy_vip_fold", "click");
        if (this.h != null) {
            if (this.e.getVisibility() == 0) {
                this.e.setVisibility(8);
                j();
            }
            MyTabOfNewVipCenterConfig myTabOfNewVipCenterConfigB = this.h.b();
            if (myTabOfNewVipCenterConfigB != null && !il5.l(myTabOfNewVipCenterConfigB.jump_page)) {
                ap3.t(this.g, myTabOfNewVipCenterConfigB.jump_page);
                return;
            }
        }
        ap3.q(this.g, "10");
    }

    public String d() {
        return WkAdxAdConfigMg.DSP_NAME_BAIDU;
    }

    public final void e() {
        this.b = (RelativeLayout) this.f21089a.findViewById(R.id.rl_root);
        this.c = (TextView) this.f21089a.findViewById(R.id.tv_title);
        this.d = (LoopTextView) this.f21089a.findViewById(R.id.tv_tips);
        this.e = this.f21089a.findViewById(R.id.vip_dot);
        this.f = (ImageView) this.f21089a.findViewById(R.id.vip_banner);
        this.b.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.d.setText(12.0f, 0, Color.parseColor("#A05717"), 8388629);
        this.d.setTextStillTime(3000L);
        this.d.setAnimTime(300L);
        this.d.setOnItemClickListener(new LoopTextView.d() { // from class: sx3
            @Override // com.zenmen.palmchat.mine.view.LoopTextView.d
            public final void a() {
                this.f20868a.g();
            }
        });
        this.l = (LinearLayout) this.f21089a.findViewById(R.id.ll_new_root);
        this.m = (TextView) this.f21089a.findViewById(R.id.tv_new_title);
        LoopTextView loopTextView = (LoopTextView) this.f21089a.findViewById(R.id.tv_new_tips);
        this.n = loopTextView;
        loopTextView.setText(12.0f, 0, Color.parseColor("#A05717"), 16);
        this.n.setTextStillTime(3000L);
        this.n.setFactory();
        this.o = (TextView) this.f21089a.findViewById(R.id.tv_desc);
        this.p = (LightingAnimationView) this.f21089a.findViewById(R.id.anim_view);
        this.f21089a.findViewById(R.id.btn_root).setOnClickListener(this);
        this.l.setOnClickListener(this);
    }

    public boolean f() {
        return !"A".equalsIgnoreCase(d());
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController
    public int getDefaultIconResId() {
        return 0;
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public View getView() {
        return this.f21089a;
    }

    public final void h(int i, boolean z) {
        MyTabOfNewVipCenterConfig.NewVipDetailConf newVipDetailConf;
        MyTabOfNewVipCenterConfig.NewVipDetailConf newVipDetailConf2;
        MyTabOfNewVipCenterConfig.NewVipDetailConf newVipDetailConf3;
        MyTabOfNewVipCenterConfig.NewVipDetailConf newVipDetailConf4;
        if (i != this.j || z) {
            this.j = i;
            MyTabOfNewVipCenterConfig myTabOfNewVipCenterConfigB = this.h.b();
            if (!f()) {
                VipEnterConfig.VipCenter vipCenter = this.i;
                if (vipCenter != null && !il5.l(vipCenter.viptext) && !il5.l(this.i.campaign)) {
                    this.c.setText(this.i.viptext);
                    this.d.setText(this.i.campaign);
                    return;
                }
                this.c.setText(i > 0 ? myTabOfNewVipCenterConfigB.viptext_vip : myTabOfNewVipCenterConfigB.viptext_nonvip);
                String[] strArr = i > 0 ? myTabOfNewVipCenterConfigB.campaign_vip : myTabOfNewVipCenterConfigB.campaign_nonvip;
                if (strArr != null) {
                    if (strArr.length <= 1) {
                        this.d.setText(strArr[0]);
                        return;
                    }
                    ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(strArr));
                    if (myTabOfNewVipCenterConfigB.autorun != 1) {
                        this.d.setText(arrayList.get(0));
                        return;
                    } else {
                        this.d.setTextList(arrayList);
                        this.d.startAutoScroll();
                        return;
                    }
                }
                return;
            }
            int i2 = myTabOfNewVipCenterConfigB.autorun;
            MyTabOfNewVipCenterConfig.NewVipConf newVipConf = myTabOfNewVipCenterConfigB.new_vip_conf;
            if (i == -2) {
                if (newVipConf == null || (newVipDetailConf = newVipConf.expire_conf) == null) {
                    k(this.g.getString(R.string.new_vip_defalut_title), new String[]{this.g.getString(R.string.new_vip_expire_default_campaign_text)}, this.g.getString(R.string.new_vip_expire_default_btn_text), i2);
                    return;
                }
                String string = il5.l(newVipDetailConf.title_text) ? this.g.getString(R.string.new_vip_defalut_title) : newVipDetailConf.title_text;
                String[] strArr2 = newVipDetailConf.campaign_text;
                if (strArr2 == null || strArr2.length <= 0) {
                    strArr2 = new String[]{this.g.getString(R.string.new_vip_expire_default_campaign_text)};
                }
                k(string, strArr2, il5.l(newVipDetailConf.btn_text) ? this.g.getString(R.string.new_vip_expire_default_btn_text) : newVipDetailConf.btn_text, i2);
                return;
            }
            if (i == -1) {
                if (newVipConf == null || (newVipDetailConf2 = newVipConf.normal_conf) == null) {
                    k(this.g.getString(R.string.new_vip_defalut_title), new String[]{this.g.getString(R.string.new_vip_normal_default_campaign_text)}, this.g.getString(R.string.new_vip_normal_default_btn_text), i2);
                    return;
                }
                String string2 = il5.l(newVipDetailConf2.title_text) ? this.g.getString(R.string.new_vip_defalut_title) : newVipDetailConf2.title_text;
                String[] strArr3 = newVipDetailConf2.campaign_text;
                if (strArr3 == null || strArr3.length <= 0) {
                    strArr3 = new String[]{this.g.getString(R.string.new_vip_normal_default_campaign_text)};
                }
                k(string2, strArr3, il5.l(newVipDetailConf2.btn_text) ? this.g.getString(R.string.new_vip_normal_default_btn_text) : newVipDetailConf2.btn_text, i2);
                return;
            }
            if (i == 0) {
                if (newVipConf == null || (newVipDetailConf3 = newVipConf.vip_conf) == null) {
                    k(this.g.getString(R.string.new_vip_defalut_title), new String[]{this.g.getString(R.string.new_vip_vip_default_campaign_text)}, this.g.getString(R.string.new_vip_vip_default_btn_text), i2);
                    return;
                }
                String string3 = il5.l(newVipDetailConf3.title_text) ? this.g.getString(R.string.new_vip_defalut_title) : newVipDetailConf3.title_text;
                String[] strArr4 = newVipDetailConf3.campaign_text;
                if (strArr4 == null || strArr4.length <= 0) {
                    strArr4 = new String[]{this.g.getString(R.string.new_vip_vip_default_campaign_text)};
                }
                k(string3, strArr4, il5.l(newVipDetailConf3.btn_text) ? this.g.getString(R.string.new_vip_vip_default_btn_text) : newVipDetailConf3.btn_text, i2);
                return;
            }
            if (i != 1) {
                return;
            }
            if (newVipConf == null || (newVipDetailConf4 = newVipConf.svip_conf) == null) {
                k(this.g.getString(R.string.new_vip_defalut_title), new String[]{this.g.getString(R.string.new_vip_svip_default_campaign_text)}, this.g.getString(R.string.new_vip_svip_default_btn_text), i2);
                return;
            }
            String string4 = il5.l(newVipDetailConf4.title_text) ? this.g.getString(R.string.new_vip_defalut_title) : newVipDetailConf4.title_text;
            String[] strArr5 = newVipDetailConf4.campaign_text;
            if (strArr5 == null || strArr5.length <= 0) {
                strArr5 = new String[]{this.g.getString(R.string.new_vip_svip_default_campaign_text)};
            }
            k(string4, strArr5, il5.l(newVipDetailConf4.btn_text) ? this.g.getString(R.string.new_vip_svip_default_btn_text) : newVipDetailConf4.btn_text, i2);
        }
    }

    public final void i(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("vip_status", this.j);
            jSONObject.put("taichi", "LX-42300");
            jSONObject.put("exp_group", d());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.f(str, str2, jSONObject);
    }

    public final void j() {
        MyTabOfNewVipCenterConfig myTabOfNewVipCenterConfigB;
        List<MyTabOfNewVipCenterConfig.RedDotConf> list;
        com.zenmen.palmchat.sync.a aVar = this.h;
        if (aVar == null || (myTabOfNewVipCenterConfigB = aVar.b()) == null || (list = myTabOfNewVipCenterConfigB.reddot_period) == null || list.isEmpty()) {
            return;
        }
        for (MyTabOfNewVipCenterConfig.RedDotConf redDotConf : myTabOfNewVipCenterConfigB.reddot_period) {
            if (redDotConf != null && !il5.l(redDotConf.start) && !il5.l(redDotConf.end) && redDotConf.num > 0 && iv0.c(iv0.d(System.currentTimeMillis()), iv0.e(redDotConf.start), iv0.e(redDotConf.end))) {
                int iC = this.h.c(redDotConf.start + "_" + redDotConf.end);
                this.h.d(redDotConf.start + "_" + redDotConf.end, iC + 1);
                return;
            }
        }
    }

    public final void k(String str, String[] strArr, String str2, int i) {
        LoopTextView loopTextView;
        TextView textView = this.m;
        if (il5.l(str)) {
            str = "";
        }
        textView.setText(str);
        TextView textView2 = this.o;
        if (il5.l(str2)) {
            str2 = "";
        }
        textView2.setText(str2);
        this.p.startLightingAnimation(0);
        if (strArr == null || (loopTextView = this.n) == null) {
            return;
        }
        loopTextView.stopAutoScroll();
        if (strArr.length <= 1) {
            this.n.setNoAnim();
            this.n.setText(strArr[0]);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(strArr));
        if (i != 1) {
            this.n.setNoAnim();
            this.n.setText(arrayList.get(0));
        } else {
            this.n.setAnim();
            this.n.setTextList(arrayList);
            this.n.startAutoScroll();
        }
    }

    public final void l() {
        VipEnterConfig.VipCenter vipCenterD = com.zenmen.square.vip.a.c().d();
        this.i = vipCenterD;
        if (vipCenterD != null && !TextUtils.isEmpty(vipCenterD.bannerBg) && !TextUtils.isEmpty(this.i.bannerUrl)) {
            this.b.setVisibility(8);
            this.l.setVisibility(8);
            this.f.setVisibility(0);
            hc2.b(this.g).load(this.i.bannerBg).diskCacheStrategy(DiskCacheStrategy.NONE).transform(new RoundedCornersTransformation(12, 0)).placeholder(R.drawable.ic_details_pic).error(R.drawable.ic_details_pic).into(this.f);
            i("pagemy_vip_campaign", "view");
            return;
        }
        if (f()) {
            this.b.setVisibility(8);
            this.l.setVisibility(0);
            this.f.setVisibility(8);
        } else {
            this.b.setVisibility(0);
            this.l.setVisibility(8);
            this.f.setVisibility(8);
            com.zenmen.palmchat.sync.a aVar = this.h;
            if (aVar == null || !aVar.a(System.currentTimeMillis())) {
                this.e.setVisibility(8);
            } else {
                this.e.setVisibility(0);
            }
        }
        m();
        h(this.j, true);
    }

    public final void m() {
        fg6.i(this.g, new a());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_root /* 2131362617 */:
            case R.id.ll_new_root /* 2131365571 */:
                try {
                    MyTabOfNewVipCenterConfig myTabOfNewVipCenterConfigB = this.h.b();
                    if (myTabOfNewVipCenterConfigB == null || il5.l(myTabOfNewVipCenterConfigB.jump_page)) {
                        ap3.q(this.g, "10");
                        i("pagemy_vip_fold", "click");
                    } else {
                        ap3.t(this.g, myTabOfNewVipCenterConfigB.jump_page);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.rl_root /* 2131366866 */:
                try {
                    if (this.e.getVisibility() == 0) {
                        this.e.setVisibility(8);
                        j();
                    }
                    MyTabOfNewVipCenterConfig myTabOfNewVipCenterConfigB2 = this.h.b();
                    if (myTabOfNewVipCenterConfigB2 == null || il5.l(myTabOfNewVipCenterConfigB2.jump_page)) {
                        ap3.q(this.g, "10");
                        i("pagemy_vip_fold", "click");
                    } else {
                        ap3.t(this.g, myTabOfNewVipCenterConfigB2.jump_page);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
                break;
            case R.id.vip_banner /* 2131368332 */:
                VipEnterConfig.VipCenter vipCenter = this.i;
                if (vipCenter != null && !TextUtils.isEmpty(vipCenter.bannerBg) && !TextUtils.isEmpty(this.i.bannerUrl)) {
                    VipEnterConfig.VipCenter vipCenter2 = this.i;
                    int i = vipCenter2.urlType;
                    if (i == 2 || i == 3) {
                        ve.s(this.g, vipCenter2.bannerUrl, false);
                    } else {
                        ap3.t(this.g, vipCenter2.bannerUrl);
                    }
                }
                i("pagemy_vip_campaign", "click");
                break;
        }
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onCreateView(DynamicConfigFragment dynamicConfigFragment, TabItem tabItem, GroupItem groupItem, CellItem cellItem) {
        super.onCreateView(dynamicConfigFragment, tabItem, groupItem, cellItem);
        FrameworkBaseActivity frameworkBaseActivity = (FrameworkBaseActivity) dynamicConfigFragment.getActivity();
        this.g = frameworkBaseActivity;
        this.f21089a = LayoutInflater.from(frameworkBaseActivity).inflate(R.layout.layout_fragment_mine_new_vip_item, (ViewGroup) null);
        this.h = new com.zenmen.palmchat.sync.a();
        e();
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onDestroyView() {
        LoopTextView loopTextView = this.d;
        if (loopTextView != null) {
            loopTextView.stopAutoScroll();
        }
        LoopTextView loopTextView2 = this.n;
        if (loopTextView2 != null) {
            loopTextView2.stopAutoScroll();
        }
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onResume() {
        l();
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onStatusChanged(uk5 uk5Var) {
        if (uk5Var.f21235a == 53) {
            m();
        }
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void setUserVisibleHint(boolean z) {
        if (z) {
            l();
        }
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController
    public void updateViewStatus(a00 a00Var) {
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onPause() {
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void processOnClick(Activity activity, CellItem cellItem) {
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onActivityResult(int i, int i2, Intent intent) {
    }
}
