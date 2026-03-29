package com.zenmen.openapi.jssdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.zenmen.openapi.R$drawable;
import com.zenmen.openapi.R$id;
import com.zenmen.openapi.comm.widget.LxDialogView;
import defpackage.a46;
import defpackage.hc2;
import defpackage.ka3;
import defpackage.w43;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class PermissionDialogView extends LxDialogView implements View.OnClickListener {

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements LxDialogView.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ka3.b f12022a;
        public String b;
        public String c;
    }

    public PermissionDialogView(Context context) {
        this(context, null);
    }

    @Override // com.zenmen.openapi.comm.widget.LxDialogView
    public void initView(LxDialogView.a aVar) {
        super.initView(aVar);
        ImageView imageView = (ImageView) findViewById(R$id.lx_permission_confirm_app_icon);
        imageView.setImageResource(R$drawable.ad_head);
        a aVar2 = (a) aVar;
        hc2.a(getContext()).load(aVar2.f12022a.c).transform(new RoundedCornersTransformation(a46.b(getContext(), 2.0f), 0)).into(imageView);
        ((TextView) findViewById(R$id.lx_permission_confirm_app_name)).setText(aVar2.f12022a.b);
        ((TextView) findViewById(R$id.lx_permission_confirm_content)).setText(w43.f21615a.get(aVar2.b));
        ((TextView) findViewById(R$id.lx_permission_target)).setText(aVar2.c);
        findViewById(R$id.lx_permission_confirm_cancel).setOnClickListener(this);
        findViewById(R$id.lx_permission_confirm_ok).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R$id.lx_permission_confirm_ok) {
            a aVar = (a) this.mInfo;
            w43.g(getContext(), aVar.f12022a.f21948a, aVar.b, true);
            this.mCallback.onEvent(0, null);
        } else if (id == R$id.lx_permission_confirm_cancel) {
            this.mCallback.onEvent(1, null);
        }
    }

    public PermissionDialogView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PermissionDialogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
