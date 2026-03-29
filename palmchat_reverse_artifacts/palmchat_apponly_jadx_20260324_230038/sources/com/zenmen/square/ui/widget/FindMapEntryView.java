package com.zenmen.square.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.find.ConditionHelper;
import com.zenmen.find.bean.DriftInfo;
import com.zenmen.openapi.comm.widget.LxRelativeLayout;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$string;
import com.zenmen.square.bean.UserrecommendTabs230414Config;
import com.zenmen.square.mvp.model.bean.NearByResp;
import com.zenmen.square.util.conf.MapFinderConfig;
import defpackage.a46;
import defpackage.an1;
import defpackage.bj5;
import defpackage.dd1;
import defpackage.gi5;
import defpackage.hc2;
import defpackage.i53;
import defpackage.ir5;
import defpackage.k86;
import defpackage.kc2;
import defpackage.l50;
import defpackage.n53;
import defpackage.pm5;
import defpackage.ry5;
import defpackage.sd3;
import defpackage.v4;
import defpackage.vm2;
import defpackage.zn6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class FindMapEntryView extends LxRelativeLayout implements View.OnClickListener, vm2 {
    public static final int FROM_APP_URI = 7;
    public static final int FROM_MAIN_CLICK = 1;
    public static final int FROM_MAIN_FILTER_NEARBY = 2;
    public static final int FROM_MAIN_FILTER_RECOMMEND = 3;
    public static final int FROM_MAIN_RECOMMEND_CARD = 4;
    public static final int FROM_MAIN_REFIND = 1;
    public static final int FROM_MAP_FIND_GUIDE = 13;
    public static final int FROM_OLD_NEARBY_BUBBLE = 6;
    public static final int FROM_OLD_NEARBY_CLICK = 5;
    public static final int FROM_TAB_MAP_FIND = 12;
    public static final String TAG = "FindMapEntryView";
    private TextView bubbleText;
    private View bubbleTextLayout;
    private View closeView;
    boolean hasShow;
    private ImageView iconImageView;
    private View infoBar;
    private FindSelectTabView mHeadView;
    private View mapIconView;
    private View redDot;
    private TextView tvInfo;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends MaterialDialog.e {
        public a() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
            zn6.b("mapfinder_closefindpopup_cancel");
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            FindMapEntryView.this.infoBar.setVisibility(8);
            UserrecommendTabs230414Config userrecommendTabs230414Config = UserrecommendTabs230414Config.getUserrecommendTabs230414Config();
            if ("A".equals(bj5.b().a().Q("LX-74314")) || !userrecommendTabs230414Config.mapfinder.show_Switch) {
                FindMapEntryView.this.mapIconView.setVisibility(0);
            } else if (FindMapEntryView.this.mHeadView.getCurPageType() == 113) {
                FindMapEntryView.this.mapIconView.setVisibility(8);
            } else if (FindMapEntryView.this.mHeadView.getCurPageType() == 49) {
                FindMapEntryView.this.mapIconView.setVisibility(0);
            }
            ConditionHelper.getInstance().setDriftInfo(null, true, true, 0);
            zn6.b("mapfinder_closefindpopup_confirm");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends MaterialDialog.e {
        public c() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onNegative(MaterialDialog materialDialog) {
            super.onNegative(materialDialog);
            zn6.b("mapfinder_locationtimeout_popup_cancel");
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            FindMapEntryView.this.checkPermissionAndJump(1, 0, 0);
            zn6.b("mapfinder_locationtimeout_popup_findagain");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f16518a;

        public d(String str) {
            this.f16518a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            LogUtil.i(FindMapEntryView.TAG, "set visible delay");
            if (FindMapEntryView.this.getVisibility() != 0 || ConditionHelper.isDrifting()) {
                return;
            }
            FindMapEntryView.this.bubbleText.setText(this.f16518a);
            FindMapEntryView.this.bubbleTextLayout.setVisibility(0);
            SPUtil.f14322a.t(SPUtil.SCENE.SQUARE, "key_map_finder_entry_bubble_time", Long.valueOf(ir5.b()));
            HashMap map = new HashMap();
            map.put("page", FindMapEntryView.this.mHeadView == null ? "2" : "1");
            if (FindMapEntryView.this.bubbleTextLayout.getVisibility() == 0 && FindMapEntryView.this.bubbleText.getText() != null) {
                map.put("text", FindMapEntryView.this.bubbleText.getText().toString());
            }
            zn6.i("map_finder_bubbleview", map);
        }
    }

    public FindMapEntryView(Context context) {
        super(context);
        this.hasShow = false;
    }

    private void hasShowRedDot() {
        this.hasShow = SPUtil.f14322a.a(SPUtil.SCENE.SQUARE, "key_drift_click" + v4.e(com.zenmen.palmchat.c.b()), false);
    }

    private void openDrift(int i, int i2, int i3, boolean z) {
        new HashMap().put("from", String.valueOf(i));
        bj5.b().a().i(getContext(), ConditionHelper.getInstance().getDriftInfo().location, this.mHeadView == null, i2, i3, z, i);
        this.bubbleTextLayout.setVisibility(8);
        updateShowRedDot(true);
    }

    private void showCloseDialog() {
        new sd3(getContext()).U("确认关闭地图找人？").k("关闭后将恢复为你当前位置的附近用户列表").P("确认关闭").L("不，点歪了").f(new a()).u().e().show();
        zn6.b("mapfinder_closefindpopup");
    }

    private void showDriftExceptionDialog(String str) {
        new sd3(getContext()).U("温馨提示").P("重新找人").K(R$string.square_btn_know).k(str).u().f(new c()).e().show();
        zn6.b("mapfinder_locationtimeout_popup");
    }

    private void updateShowRedDot(boolean z) {
        if (this.hasShow == z) {
            return;
        }
        SPUtil.f14322a.t(SPUtil.SCENE.SQUARE, "key_drift_click" + v4.e(com.zenmen.palmchat.c.b()), Boolean.valueOf(z));
        this.hasShow = z;
        if (z) {
            this.redDot.setVisibility(8);
        }
    }

    public void checkPermissionAndJump(int i, int i2, int i3, boolean z) {
        if (a46.o()) {
            if (a46.q()) {
                openDrift(i, i2, i3, z);
                return;
            } else {
                BaseActivityPermissionDispatcher.b((FrameworkBaseActivity) getContext(), BaseActivityPermissionDispatcher.PermissionType.FIND_FRIEND_DRIFT_LOCATION, BaseActivityPermissionDispatcher.PermissionUsage.FIND_FRIEND_GET_LOCATION);
                return;
            }
        }
        ry5.a("请打开位置服务");
        Intent intent = new Intent();
        intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
        try {
            getContext().startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.zenmen.openapi.comm.widget.LxRelativeLayout
    public void createView(Context context) {
        LayoutInflater.from(context).inflate(R$layout.layout_find_map_entry_view, (ViewGroup) this, true);
        this.infoBar = findViewById(R$id.rl_find_map_text);
        View viewFindViewById = findViewById(R$id.rl_find_map_icon);
        this.mapIconView = viewFindViewById;
        viewFindViewById.setOnClickListener(this);
        this.redDot = findViewById(R$id.dot_guide);
        hasShowRedDot();
        if (this.hasShow) {
            this.redDot.setVisibility(8);
        }
        View viewFindViewById2 = findViewById(R$id.iv_find_bar_close);
        this.closeView = viewFindViewById2;
        viewFindViewById2.setOnClickListener(this);
        this.tvInfo = (TextView) findViewById(R$id.tv_find_bar_info);
        this.iconImageView = (ImageView) findViewById(R$id.iv_map);
        this.bubbleText = (TextView) findViewById(R$id.text);
        View viewFindViewById3 = findViewById(R$id.textLayout);
        this.bubbleTextLayout = viewFindViewById3;
        viewFindViewById3.setVisibility(8);
        this.infoBar.setOnClickListener(this);
        ((ImageView) findViewById(R$id.iv_location)).setColorFilter(-1);
        an1.c().p(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        if (l50.a()) {
            return;
        }
        if (view != this.mapIconView && view != this.infoBar && view != this.bubbleTextLayout) {
            if (view == this.closeView) {
                showCloseDialog();
                zn6.b("map_finder_close");
                return;
            }
            return;
        }
        HashMap map = new HashMap();
        map.put("status", view == this.mapIconView ? "0" : "1");
        map.put("page", this.mHeadView == null ? "2" : "1");
        if (this.bubbleTextLayout.getVisibility() == 0 && this.bubbleText.getText() != null) {
            map.put("text", this.bubbleText.getText().toString());
        }
        zn6.i("map_finder_click", map);
        if (this.mHeadView == null) {
            i = 5;
        } else {
            i = ("A".equals(bj5.b().a().Q("LX-74314")) || !UserrecommendTabs230414Config.getUserrecommendTabs230414Config().mapfinder.show_Switch) ? 1 : 13;
        }
        checkPermissionAndJump(i, 0, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        an1.c().r(this);
    }

    public void setHeadView(FindSelectTabView findSelectTabView) {
        this.mHeadView = findSelectTabView;
    }

    public void setInfoBarStatus(int i) {
        View view = this.infoBar;
        if (view != null) {
            view.setVisibility(i);
        }
    }

    public void setMapIconViewStatus(int i) {
        View view = this.mapIconView;
        if (view != null) {
            view.setVisibility(i);
        }
    }

    public void showDialog(NearByResp.DriftBean driftBean) {
        if (driftBean.unlockBy == 2) {
            dd1.a(getContext(), "已使用会员权益为您更新目标地点的附近用户列表", driftBean.remainFreeCount);
        } else {
            dd1.a(getContext(), "已为您更新目标地点的附近用户", -1);
        }
        HashMap map = new HashMap();
        map.put("type", 1);
        zn6.j("mapfinder_findcompletepopup", null, map);
    }

    public void triggleBubbleShow() {
        MapFinderConfig.MainEntry mainEntry = gi5.g().main_circleentry;
        if (mainEntry == null) {
            return;
        }
        if (!TextUtils.isEmpty(mainEntry.entry_pic)) {
            kc2<Drawable> kc2VarLoad = hc2.a(getContext()).load(k86.p(mainEntry.entry_pic));
            int i = R$drawable.ic_find_map;
            kc2VarLoad.placeholder(i).error(i).into(this.iconImageView);
        }
        if (this.bubbleTextLayout.getVisibility() == 0) {
            return;
        }
        if (ConditionHelper.isDrifting()) {
            this.bubbleTextLayout.setVisibility(8);
        }
        LogUtil.i(TAG, "start check bubble");
        ArrayList<String> arrayList = mainEntry.bubble_text;
        if (arrayList == null || arrayList.size() <= 0 || mainEntry.standingtime <= 0 || Math.abs(SPUtil.f14322a.i(SPUtil.SCENE.SQUARE, "key_map_finder_entry_bubble_time", 0L) - ir5.b()) < ((long) mainEntry.fre) * 1000) {
            return;
        }
        Collections.shuffle(mainEntry.bubble_text);
        postDelayed(new d(mainEntry.bubble_text.get(0)), ((long) mainEntry.standingtime) * 1000);
    }

    @pm5(threadMode = ThreadMode.MAIN)
    public void updateDriftState(NearByResp.DriftBean driftBean) {
        if (this.mHeadView == null) {
            return;
        }
        String showDialogMsg = driftBean.getShowDialogMsg();
        DriftInfo driftInfo = ConditionHelper.getInstance().getDriftInfo();
        LocationEx locationExI = com.zenmen.palmchat.location.d.g().i(86400000L);
        if (!TextUtils.isEmpty(showDialogMsg)) {
            showDriftExceptionDialog(showDialogMsg);
            this.mapIconView.setVisibility(0);
            this.infoBar.setVisibility(8);
            ConditionHelper.getInstance().setDriftInfo(null, false, false, 0);
            FindSelectTabView findSelectTabView = this.mHeadView;
            if (findSelectTabView != null) {
                findSelectTabView.setItemRedTextShow("nearbyrecommend", false);
            }
        } else if (driftBean.drift && driftInfo.valid()) {
            this.bubbleTextLayout.setVisibility(8);
            this.infoBar.setVisibility(0);
            String address = driftInfo.location.getAddress();
            if (TextUtils.isEmpty(address)) {
                bj5.b().a().N(getContext(), new b(driftInfo, locationExI), driftInfo.location);
            } else {
                this.tvInfo.setText(getContext().getString(R$string.find_map_selected_info, a46.a(driftInfo.location, locationExI), "已定位到", address));
            }
            if (driftInfo.firstDrift) {
                showDialog(driftBean);
            }
            if (this.mHeadView != null) {
                UserrecommendTabs230414Config userrecommendTabs230414Config = UserrecommendTabs230414Config.getUserrecommendTabs230414Config();
                if ("A".equals(bj5.b().a().Q("LX-74314")) || !userrecommendTabs230414Config.mapfinder.show_Switch) {
                    this.mHeadView.setItemRedTextShow("nearbyrecommend", true);
                }
            }
        } else {
            this.mapIconView.setVisibility(0);
            this.infoBar.setVisibility(8);
            FindSelectTabView findSelectTabView2 = this.mHeadView;
            if (findSelectTabView2 != null) {
                findSelectTabView2.setItemRedTextShow("nearbyrecommend", false);
            }
        }
        ConditionHelper.getInstance().setDriftInfoConsumed();
    }

    public FindMapEntryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hasShow = false;
    }

    public FindMapEntryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hasShow = false;
    }

    public FindMapEntryView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.hasShow = false;
    }

    public void checkPermissionAndJump(int i, int i2, int i3) {
        checkPermissionAndJump(i, i2, i3, false);
    }

    @Override // defpackage.vm2
    public void separationState(int i) {
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements i53 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DriftInfo f16516a;
        public final /* synthetic */ LocationEx b;

        public b(DriftInfo driftInfo, LocationEx locationEx) {
            this.f16516a = driftInfo;
            this.b = locationEx;
        }

        @Override // defpackage.i53
        public void onRegeocodeSearched(String str) {
            FindMapEntryView.this.tvInfo.setText(FindMapEntryView.this.getContext().getString(R$string.find_map_selected_info, a46.a(this.f16516a.location, this.b), "已定位到", str));
        }

        @Override // defpackage.i53
        public void onLocationReceived(LocationEx locationEx, int i, String str) {
        }

        @Override // defpackage.i53
        public void onLocationSearchResultGot(int i, List<LocationEx> list, n53 n53Var) {
        }
    }
}
