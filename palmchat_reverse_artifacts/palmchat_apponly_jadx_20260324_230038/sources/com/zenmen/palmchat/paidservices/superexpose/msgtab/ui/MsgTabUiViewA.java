package com.zenmen.palmchat.paidservices.superexpose.msgtab.ui;

import android.content.Context;
import android.view.View;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.paidservices.superexpose.bean.SuperExposeInfo;
import com.zenmen.palmchat.paidservices.superexpose.msgtab.model.SuperExposeMsgTabInfo;
import defpackage.bo5;
import defpackage.is3;
import defpackage.l50;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class MsgTabUiViewA extends MsgTabBaseUiView {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            bo5 bo5Var;
            if (l50.a() || (bo5Var = MsgTabUiViewA.this.mMsgTabCallBack) == null) {
                return;
            }
            bo5Var.c(32);
        }
    }

    public MsgTabUiViewA(Context context) {
        super(context);
        setOnClickListener(new a());
    }

    @Override // com.zenmen.palmchat.paidservices.superexpose.msgtab.ui.MsgTabBaseUiView
    public int getRootLayout() {
        return R.layout.super_expose_msg_tab_ui_a;
    }

    @Override // com.zenmen.palmchat.paidservices.superexpose.msgtab.ui.MsgTabBaseUiView
    public void initItemView(bo5 bo5Var) {
        super.initItemView(bo5Var);
        if (is3.b().e()) {
            findViewById(R.id.contentRootLayout).setBackgroundColor(0);
        }
    }

    @Override // com.zenmen.palmchat.paidservices.superexpose.msgtab.ui.MsgTabBaseUiView
    public void setData(SuperExposeMsgTabInfo superExposeMsgTabInfo, SuperExposeInfo superExposeInfo, boolean z, boolean z2) {
        super.setData(superExposeMsgTabInfo, superExposeInfo, z, z2);
    }
}
