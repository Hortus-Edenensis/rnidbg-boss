package com.zenmen.openapi.auth.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.wifi.adsdk.download.LxAdDLManager;
import com.zenmen.openapi.R$id;
import com.zenmen.openapi.comm.widget.LxDialogView;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import defpackage.a46;
import defpackage.hc2;
import defpackage.sm;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ConfirmDialogView extends LxDialogView implements View.OnClickListener {
    public static final int EVENT_CANCEL = 1;
    public static final int EVENT_CONFIRM = 0;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements LxDialogView.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12015a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;

        public static a a(JSONObject jSONObject) {
            a aVar = new a();
            aVar.b = jSONObject.optString("appIcon");
            aVar.c = jSONObject.optString(WfConstant.EVENT_KEY_APP_NAME);
            aVar.f12015a = jSONObject.optString("scope");
            aVar.d = jSONObject.optString("scopeInfoContent");
            aVar.f = jSONObject.optString(LxAdDLManager.ITEM_ICONURL);
            aVar.e = jSONObject.optString("nickname");
            aVar.g = jSONObject.optString("mobile");
            return aVar;
        }
    }

    public ConfirmDialogView(Context context) {
        this(context, null);
    }

    @Override // com.zenmen.openapi.comm.widget.LxDialogView
    public void initView(LxDialogView.a aVar) {
        super.initView(aVar);
        a aVar2 = (a) aVar;
        hc2.a(getContext()).load(aVar2.b).transform(new RoundedCornersTransformation(a46.b(getContext(), 2.0f), 0)).into((ImageView) findViewById(R$id.lx_auth_confirm_app_icon));
        ((TextView) findViewById(R$id.lx_auth_confirm_app_name)).setText(aVar2.c);
        ((TextView) findViewById(R$id.lx_auth_confirm_content)).setText(aVar2.d);
        hc2.a(getContext()).load(aVar2.f).transform(new RoundedCornersTransformation(a46.b(getContext(), 5.0f), 0)).into((ImageView) findViewById(R$id.lx_auth_confirm_avatar));
        ((TextView) findViewById(R$id.lx_auth_confirm_username)).setText(aVar2.e);
        ((TextView) findViewById(R$id.lx_auth_confirm_mobile)).setText(sm.a(aVar2.g));
        findViewById(R$id.lx_auth_confirm_cancel).setOnClickListener(this);
        findViewById(R$id.lx_auth_confirm_ok).setOnClickListener(this);
        if ("BASE".equals(aVar2.f12015a)) {
            findViewById(R$id.lx_auth_confirm_mobile_wrap).setVisibility(8);
        } else {
            findViewById(R$id.lx_auth_confirm_mobile_wrap).setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R$id.lx_auth_confirm_ok) {
            this.mCallback.onEvent(0, null);
        } else if (id == R$id.lx_auth_confirm_cancel) {
            this.mCallback.onEvent(1, null);
        }
    }

    public ConfirmDialogView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ConfirmDialogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
