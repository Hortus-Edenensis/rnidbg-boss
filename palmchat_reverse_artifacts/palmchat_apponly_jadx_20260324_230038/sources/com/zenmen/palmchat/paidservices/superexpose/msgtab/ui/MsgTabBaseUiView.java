package com.zenmen.palmchat.paidservices.superexpose.msgtab.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.d;
import com.zenmen.palmchat.paidservices.superexpose.bean.SuperExposeInfo;
import com.zenmen.palmchat.paidservices.superexpose.msgtab.SuperExposeNumActivity;
import com.zenmen.palmchat.paidservices.superexpose.msgtab.model.SuperExposeMsgTabInfo;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.widget.EffectiveShapeView;
import defpackage.ap3;
import defpackage.b05;
import defpackage.bo5;
import defpackage.bq6;
import defpackage.dn0;
import defpackage.fo5;
import defpackage.go2;
import defpackage.gr2;
import defpackage.hs3;
import defpackage.l50;
import defpackage.sw4;
import defpackage.v4;
import defpackage.zw4;
import java.text.DecimalFormat;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class MsgTabBaseUiView extends FrameLayout {
    private static final long DAY_MI = 86400000;
    private boolean isRequesting;
    protected ContactInfoItem mContactInfoItem;
    protected Context mContext;
    protected int mCurStatus;
    protected EffectiveShapeView mIconView;
    protected bo5 mMsgTabCallBack;
    private CountDownTimer mRequestTimer;
    protected ImageView mSDView;
    protected View mSuperNumLayout;
    protected TextView mSuperNumTextView;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            Intent intent = new Intent();
            intent.setClass(MsgTabBaseUiView.this.getContext(), SuperExposeNumActivity.class);
            intent.putExtra("status", MsgTabBaseUiView.this.mCurStatus);
            if (!(MsgTabBaseUiView.this.getContext() instanceof Activity)) {
                intent.addFlags(268435456);
            }
            MsgTabBaseUiView.this.getContext().startActivity(intent);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends go2<LXBaseNetBean<SuperExposeInfo>> {
        public b() {
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            ContactInfoItem contactInfoItemA;
            HashMap map = new HashMap();
            String strE = v4.e(com.zenmen.palmchat.c.b());
            if (!TextUtils.isEmpty(strE) && (contactInfoItemA = dn0.a(strE)) != null) {
                map.put("gender", Integer.valueOf(contactInfoItemA.getGender()));
            }
            LocationEx locationExI = d.g().i(86400000L);
            if (locationExI != null) {
                map.put("latitude", locationExI.getLatitude() + "");
                map.put("longitude", locationExI.getLongitude() + "");
            }
            map.put("scene", 2);
            map.put("requestTab", 1);
            b05.d("MsgTabUiViewB===>requestSuperExposeInfo  requestTab=1");
            return sw4.b(1, ap3.d(), map).f(false);
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<SuperExposeInfo> lXBaseNetBean, Exception exc) {
            SuperExposeInfo superExposeInfo;
            LogUtil.d("", "SuperExposeMsgTabViewT requestSuperExposeInfo onResult call");
            try {
                MsgTabBaseUiView.this.isRequesting = false;
                fo5.g = lXBaseNetBean;
                if (lXBaseNetBean == null || lXBaseNetBean.resultCode != 0 || (superExposeInfo = lXBaseNetBean.data) == null) {
                    return;
                }
                SuperExposeInfo superExposeInfo2 = superExposeInfo;
                com.zenmen.palmchat.paidservices.superexpose.b.x = superExposeInfo2.superShowType;
                fo5.f17568a = superExposeInfo2.status;
                LogUtil.i("", "onResult 194 exposeStatus =" + fo5.f17568a);
                if (superExposeInfo2.status == 1) {
                    long j = superExposeInfo2.showCount;
                    if (j > 0) {
                        MsgTabBaseUiView.this.changeNumView(new DecimalFormat("###,###").format(j));
                    }
                }
                bo5 bo5Var = MsgTabBaseUiView.this.mMsgTabCallBack;
                if (bo5Var != null) {
                    bo5Var.a(lXBaseNetBean);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public MsgTabBaseUiView(@NonNull Context context) {
        super(context);
        this.mIconView = null;
        this.mSDView = null;
        this.mContactInfoItem = null;
        this.mMsgTabCallBack = null;
        this.mSuperNumLayout = null;
        this.mSuperNumTextView = null;
        this.mCurStatus = -1;
        this.mContext = context;
        addView(LayoutInflater.from(context).inflate(getRootLayout(), (ViewGroup) null, false));
    }

    public void checkSDViewByStatus(int i) {
        ImageView imageView = this.mSDView;
        if (imageView != null) {
            if (i == 1) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
            }
        }
    }

    public void destroyTime() {
        CountDownTimer countDownTimer = this.mRequestTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.mRequestTimer = null;
        }
    }

    public abstract int getRootLayout();

    public void initItemView(bo5 bo5Var) {
        this.mMsgTabCallBack = bo5Var;
        this.mIconView = (EffectiveShapeView) findViewById(R.id.header_icon);
        this.mSDView = (ImageView) findViewById(R.id.msg_tab_a_sd);
        this.mSuperNumLayout = findViewById(R.id.super_num_title_all_layout);
        this.mSuperNumTextView = (TextView) findViewById(R.id.super_num_title);
        View view = this.mSuperNumLayout;
        if (view != null) {
            view.setOnClickListener(new a());
        }
        if (this.mSDView != null) {
            try {
                Glide.with(this.mContext).asGif().load2(Integer.valueOf(R.drawable.super_expose_msg_tab_ui_sd_gif)).into(this.mSDView);
            } catch (Exception unused) {
            }
        }
    }

    public void onDestroy() {
        destroyTime();
    }

    public void requestSuperExposeInfo() {
        if (this.isRequesting) {
            return;
        }
        this.isRequesting = true;
        LogUtil.d("", "SuperExposeMsgTabViewT mRequestStatusLastTime requestSuperExposeInfo start");
        zw4.e(new b());
    }

    public void setData(SuperExposeMsgTabInfo superExposeMsgTabInfo, SuperExposeInfo superExposeInfo, boolean z, boolean z2) {
        ContactInfoItem contactInfoItemA;
        String strE = v4.e(com.zenmen.palmchat.c.b());
        if (!TextUtils.isEmpty(strE) && (contactInfoItemA = dn0.a(strE)) != null) {
            this.mContactInfoItem = contactInfoItemA;
            String iconURL = contactInfoItemA.getIconURL();
            if (!TextUtils.isEmpty(iconURL) && this.mIconView != null) {
                gr2.j().h(iconURL, this.mIconView, bq6.s());
            }
        }
        setSuperNumLayoutShow();
    }

    public void setSuperNumLayoutShow() {
        try {
            if (TextUtils.isEmpty(fo5.i) || TextUtils.isEmpty(v4.e(AppContext.getContext())) || !fo5.i.contains(v4.e(AppContext.getContext()))) {
                return;
            }
            LogUtil.d("", "MsgTabTaijiModelManager setSuperNumLayoutShow uid allow ");
            View view = this.mSuperNumLayout;
            if (view != null) {
                view.setVisibility(0);
            }
            TextView textView = this.mSuperNumTextView;
            if (textView != null) {
                textView.setText(hs3.c + "人");
            }
        } catch (Exception unused) {
        }
    }

    public void startRefreshStatus(boolean z) {
        b05.d("startRefreshStatus===>msgTabShow===>" + z);
        if (z) {
            if (this.mRequestTimer == null) {
                this.mRequestTimer = new c(5000L, 5000L);
            }
            this.mRequestTimer.cancel();
            this.mRequestTimer.start();
            return;
        }
        if (this.mRequestTimer != null) {
            b05.d("startRefreshStatus===>关闭timer");
            this.mRequestTimer.cancel();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends CountDownTimer {
        public c(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            MsgTabBaseUiView.this.requestSuperExposeInfo();
            if (MsgTabBaseUiView.this.mRequestTimer != null) {
                b05.d("startRefreshStatus===>onFinish");
                MsgTabBaseUiView.this.mRequestTimer.cancel();
                MsgTabBaseUiView.this.mRequestTimer.start();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
        }
    }

    public void changeNumView(String str) {
    }

    public void visibleShow(boolean z) {
    }
}
