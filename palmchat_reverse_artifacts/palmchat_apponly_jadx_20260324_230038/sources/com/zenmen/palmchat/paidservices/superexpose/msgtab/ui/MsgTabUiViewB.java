package com.zenmen.palmchat.paidservices.superexpose.msgtab.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.paidservices.superexpose.bean.SuperExposeInfo;
import com.zenmen.palmchat.paidservices.superexpose.msgtab.model.SuperExposeMsgTabInfo;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.b05;
import defpackage.bo5;
import defpackage.is3;
import defpackage.l50;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class MsgTabUiViewB extends MsgTabBaseUiView {
    private TextView mNumView;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            bo5 bo5Var;
            if (l50.a() || (bo5Var = MsgTabUiViewB.this.mMsgTabCallBack) == null) {
                return;
            }
            bo5Var.d(32, 1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f14856a;

        public b(String str) {
            this.f14856a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            MsgTabUiViewB.this.mNumView.setText(this.f14856a);
        }
    }

    public MsgTabUiViewB(Context context, boolean z) {
        super(context);
        this.mNumView = null;
        this.mCurStatus = 1;
        this.mNumView = (TextView) findViewById(R.id.msg_tab_b_num);
        setOnClickListener(new a());
        if (z) {
            startRefreshStatus(true);
        }
    }

    @Override // com.zenmen.palmchat.paidservices.superexpose.msgtab.ui.MsgTabBaseUiView
    public void changeNumView(String str) {
        TextView textView = this.mNumView;
        if (textView != null) {
            textView.post(new b(str));
        }
    }

    @Override // com.zenmen.palmchat.paidservices.superexpose.msgtab.ui.MsgTabBaseUiView
    public int getRootLayout() {
        return R.layout.super_expose_msg_tab_ui_b;
    }

    @Override // com.zenmen.palmchat.paidservices.superexpose.msgtab.ui.MsgTabBaseUiView
    public void initItemView(bo5 bo5Var) {
        super.initItemView(bo5Var);
        if (is3.b().e()) {
            findViewById(R.id.contentRootLayout).setBackgroundColor(0);
        }
    }

    @Override // com.zenmen.palmchat.paidservices.superexpose.msgtab.ui.MsgTabBaseUiView
    public void onDestroy() {
        super.onDestroy();
        LogUtil.d("SuperExposeMsgTab", "MsgTabUiViewB onDestroy：");
    }

    @Override // com.zenmen.palmchat.paidservices.superexpose.msgtab.ui.MsgTabBaseUiView
    public void setData(SuperExposeMsgTabInfo superExposeMsgTabInfo, SuperExposeInfo superExposeInfo, boolean z, boolean z2) {
        super.setData(superExposeMsgTabInfo, superExposeInfo, z, z2);
        if (superExposeInfo == null || superExposeInfo.showCount <= 0) {
            return;
        }
        changeNumView(superExposeInfo.showCount + "");
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            startRefreshStatus(true);
        } else {
            destroyTime();
        }
    }

    @Override // com.zenmen.palmchat.paidservices.superexpose.msgtab.ui.MsgTabBaseUiView
    public void visibleShow(boolean z) {
        super.visibleShow(z);
        b05.d("visibleShow===>isShow===>" + z);
        if (z) {
            startRefreshStatus(true);
        } else {
            destroyTime();
        }
    }
}
