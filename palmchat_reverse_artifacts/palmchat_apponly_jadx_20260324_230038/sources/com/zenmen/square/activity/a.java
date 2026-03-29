package com.zenmen.square.activity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.square.R$drawable;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import defpackage.k36;
import defpackage.sd3;
import defpackage.tg4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MaterialDialog f16158a;
    public FrameworkBaseActivity b;

    /* JADX INFO: renamed from: com.zenmen.square.activity.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class ViewOnClickListenerC1152a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f16159a;

        public ViewOnClickListenerC1152a(d dVar) {
            this.f16159a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f16159a.b();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f16160a;
        public final /* synthetic */ d b;

        public b(MaterialDialog materialDialog, d dVar) {
            this.f16160a = materialDialog;
            this.b = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f16160a.dismiss();
            this.b.a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MaterialDialog f16161a;

        public c(MaterialDialog materialDialog) {
            this.f16161a = materialDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f16161a.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void a();

        void b();
    }

    public a(FrameworkBaseActivity frameworkBaseActivity) {
        this.b = frameworkBaseActivity;
    }

    public void a(FrameworkBaseActivity frameworkBaseActivity, d dVar) {
        View viewInflate = View.inflate(frameworkBaseActivity, R$layout.dialog_square_location_permission_confirm, null);
        MaterialDialog materialDialogE = new sd3(frameworkBaseActivity).p(viewInflate, false).h(false).e();
        materialDialogE.show();
        View viewFindViewById = viewInflate.findViewById(R$id.action);
        View viewFindViewById2 = viewInflate.findViewById(R$id.close);
        viewInflate.findViewById(R$id.location_rl).setOnClickListener(new ViewOnClickListenerC1152a(dVar));
        viewFindViewById.setOnClickListener(new b(materialDialogE, dVar));
        viewFindViewById2.setOnClickListener(new c(materialDialogE));
        this.f16158a = materialDialogE;
    }

    public final void b(String str, boolean z, boolean z2) {
        if (this.f16158a.j() != null) {
            TextView textView = (TextView) this.f16158a.j().findViewById(R$id.location);
            if (!TextUtils.isEmpty(str)) {
                textView.setCompoundDrawables(null, null, null, null);
                textView.setText(str);
                return;
            }
            Drawable drawable = this.b.getResources().getDrawable(R$drawable.square_publish_right_arrow);
            drawable.setColorFilter(Color.parseColor("#222222"), PorterDuff.Mode.SRC_ATOP);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView.setCompoundDrawablePadding(k36.b(4.0f));
            if (z) {
                textView.setCompoundDrawables(null, null, null, null);
                textView.setText("定位中...");
            } else if (!tg4.b(this.b, BaseActivityPermissionDispatcher.PermissionType.LOCATION.permissionList)) {
                textView.setCompoundDrawables(null, null, drawable, null);
                textView.setText("请授权位置信息");
            } else if (z2) {
                textView.setCompoundDrawables(null, null, null, null);
                textView.setText("   ");
            } else {
                textView.setCompoundDrawables(null, null, drawable, null);
                textView.setText("定位失败，点击重试");
            }
        }
    }

    public void c(String str, boolean z, boolean z2) {
        MaterialDialog materialDialog = this.f16158a;
        if (materialDialog == null || !materialDialog.isShowing()) {
            return;
        }
        b(str, z, z2);
    }
}
