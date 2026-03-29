package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.maintab.DynamicConfigFragment;
import com.zenmen.palmchat.maintab.cell.AbsCellViewController;
import com.zenmen.palmchat.maintab.config.CellItem;
import com.zenmen.palmchat.maintab.config.GroupItem;
import com.zenmen.palmchat.maintab.config.TabItem;
import com.zenmen.palmchat.mine.view.LoopTextView;
import com.zenmen.palmchat.mine.view.VipTagImageView;
import com.zenmen.palmchat.sync.MyTabOfVipCenterConfig;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.fg6;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class u65 extends AbsCellViewController implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f21148a;
    public VipTagImageView b;
    public FrameLayout c;
    public RelativeLayout d;
    public TextView e;
    public LoopTextView f;
    public LoopTextView g;
    public Context h;
    public mt3 i;
    public Handler j;
    public View l;
    public int k = 0;
    public boolean m = false;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            u65.this.o(true, false);
            u65.this.i.c(MyTabOfVipCenterConfig.SP_VIP_CENTER_FIRST);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PopupWindow f21150a;

        public b(PopupWindow popupWindow) {
            this.f21150a = popupWindow;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f21150a.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements fg6.b {
        public c() {
        }

        @Override // fg6.b
        public void onFail(Exception exc) {
            LogUtil.i("getVip", "onFail: " + exc.getMessage());
        }

        @Override // fg6.b
        public void onSuccess(int i) {
            u65.this.m = i >= 0;
            u65.this.k(i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        ap3.q(this.h, "10");
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        ap3.q(this.h, "11");
        m();
    }

    public static void n(Context context, View view) {
        PopupWindow popupWindow = new PopupWindow(LayoutInflater.from(context).inflate(R.layout.layout_popup_vip_center_tips_dialog, (ViewGroup) null), -2, -2);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.showAsDropDown(view, 14, -me1.b(context, 105));
        popupWindow.update();
        view.postDelayed(new b(popupWindow), 3000L);
    }

    public final void g() {
        if (this.i.a(MyTabOfVipCenterConfig.SP_VIP_CENTER_FIRST)) {
            o(false, false);
            this.j.postDelayed(new a(), 3000L);
        } else if (!this.i.a(MyTabOfVipCenterConfig.SP_VIP_CENTER_SECOND)) {
            o(true, false);
        } else {
            o(true, true);
            this.i.c(MyTabOfVipCenterConfig.SP_VIP_CENTER_SECOND);
        }
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController
    public int getDefaultIconResId() {
        return 0;
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public View getView() {
        return this.f21148a;
    }

    public final void h() {
        this.c = (FrameLayout) this.f21148a.findViewById(R.id.fr_zhankai);
        this.d = (RelativeLayout) this.f21148a.findViewById(R.id.rl_zhedie);
        this.l = this.f21148a.findViewById(R.id.iv_arrow);
        this.b = (VipTagImageView) this.f21148a.findViewById(R.id.vip_tag);
        this.f = (LoopTextView) this.f21148a.findViewById(R.id.tv_sub_title);
        this.e = (TextView) this.f21148a.findViewById(R.id.tv_go_open);
        this.g = (LoopTextView) this.f21148a.findViewById(R.id.tv_tips);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.g.setOnItemClickListener(new LoopTextView.d() { // from class: s65
            @Override // com.zenmen.palmchat.mine.view.LoopTextView.d
            public final void a() {
                this.f20674a.i();
            }
        });
        this.f.setOnItemClickListener(new LoopTextView.d() { // from class: t65
            @Override // com.zenmen.palmchat.mine.view.LoopTextView.d
            public final void a() {
                this.f20913a.j();
            }
        });
        this.f.setText(12.0f, 0, Color.parseColor("#84440C"), 8388627);
        this.f.setTextStillTime(3000L);
        this.f.setAnimTime(300L);
        this.g.setText(12.0f, 0, Color.parseColor("#84440C"), 8388629);
        this.g.setTextStillTime(3000L);
        this.g.setAnimTime(300L);
    }

    public final void k(int i, boolean z) {
        if (i != this.k || z) {
            this.k = i;
            MyTabOfVipCenterConfig myTabOfVipCenterConfigB = this.i.b();
            if (i > 0) {
                String[] strArr = myTabOfVipCenterConfigB.main_text_vip;
                if (strArr.length > 1) {
                    ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(strArr));
                    if (myTabOfVipCenterConfigB.autorun_fold == 1) {
                        this.g.setTextList(arrayList);
                        this.g.startAutoScroll();
                    } else {
                        this.g.setText(arrayList.get(0));
                    }
                    if (myTabOfVipCenterConfigB.autorun_unfold == 1) {
                        this.f.setTextList(arrayList);
                        this.f.startAutoScroll();
                    } else {
                        this.f.setText(arrayList.get(0));
                    }
                } else {
                    this.g.setText(strArr[0]);
                    this.f.setText(strArr[0]);
                }
                if (TextUtils.isEmpty(myTabOfVipCenterConfigB.extra_text_vip)) {
                    this.b.setVisibility(8);
                } else {
                    this.b.setVisibility(0);
                    this.b.setTagText(myTabOfVipCenterConfigB.extra_text_vip);
                }
                this.e.setText(myTabOfVipCenterConfigB.button_vip_android);
                return;
            }
            String[] strArr2 = myTabOfVipCenterConfigB.main_text_nonmember;
            if (strArr2.length > 1) {
                ArrayList<String> arrayList2 = new ArrayList<>(Arrays.asList(strArr2));
                if (myTabOfVipCenterConfigB.autorun_fold == 1) {
                    this.g.setTextList(arrayList2);
                    this.g.startAutoScroll();
                } else {
                    this.g.setText(arrayList2.get(0));
                }
                if (myTabOfVipCenterConfigB.autorun_unfold == 1) {
                    this.f.setTextList(arrayList2);
                    this.f.startAutoScroll();
                } else {
                    this.f.setText(arrayList2.get(0));
                }
            } else {
                this.g.setText(strArr2[0]);
                this.f.setText(strArr2[0]);
            }
            if (TextUtils.isEmpty(myTabOfVipCenterConfigB.extra_text_nonmember)) {
                this.b.setVisibility(8);
            } else {
                this.b.setVisibility(0);
                this.b.setTagText(myTabOfVipCenterConfigB.extra_text_nonmember);
            }
            this.e.setText(myTabOfVipCenterConfigB.button_nonmember);
        }
    }

    public final void l() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("report_type", "click");
            jSONObject.put("vip_status", this.m ? 1 : 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("pagemy_vip_fold", null, jSONObject.toString());
    }

    public final void m() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("report_type", "click");
            jSONObject.put("vip_status", this.m ? 1 : 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        zn6.d("pagemy_vip_unfold_click", null, jSONObject.toString());
    }

    public final void o(boolean z, boolean z2) {
        if (!z) {
            this.d.setVisibility(8);
            this.c.setVisibility(0);
            return;
        }
        this.c.setVisibility(8);
        this.d.setVisibility(0);
        if (z2) {
            n(this.h, this.d);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.fr_zhankai) {
            ap3.q(this.h, "11");
            m();
        } else {
            if (id != R.id.rl_zhedie) {
                return;
            }
            ap3.q(this.h, "10");
            l();
        }
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onCreateView(DynamicConfigFragment dynamicConfigFragment, TabItem tabItem, GroupItem groupItem, CellItem cellItem) {
        super.onCreateView(dynamicConfigFragment, tabItem, groupItem, cellItem);
        FragmentActivity activity = dynamicConfigFragment.getActivity();
        this.h = activity;
        this.f21148a = (RelativeLayout) LayoutInflater.from(activity).inflate(R.layout.layout_fragment_mine_vip_item, (ViewGroup) null);
        this.j = new Handler();
        this.i = new mt3(this.h);
        h();
        p();
        k(this.k, true);
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onDestroyView() {
        LoopTextView loopTextView = this.f;
        if (loopTextView != null) {
            loopTextView.stopAutoScroll();
        }
        LoopTextView loopTextView2 = this.g;
        if (loopTextView2 != null) {
            loopTextView2.stopAutoScroll();
        }
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onResume() {
        p();
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void onStatusChanged(uk5 uk5Var) {
        RelativeLayout relativeLayout;
        if (uk5Var == null || 49 != uk5Var.f21235a) {
            if (uk5Var.f21235a == 53) {
                p();
                return;
            }
            return;
        }
        int i = uk5Var.b;
        if (i == 1) {
            FrameLayout frameLayout = this.c;
            if (frameLayout == null || frameLayout.getVisibility() == 0) {
                return;
            }
            o(false, false);
            return;
        }
        if (i != 2 || (relativeLayout = this.d) == null || relativeLayout.getVisibility() == 0) {
            return;
        }
        o(true, false);
    }

    public final void p() {
        fg6.i(AppContext.getContext(), new c());
    }

    @Override // com.zenmen.palmchat.maintab.cell.AbsCellViewController, defpackage.zz
    public void setUserVisibleHint(boolean z) {
        if (z) {
            g();
            p();
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
