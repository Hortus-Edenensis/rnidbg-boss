package com.zenmen.palmchat.circle.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.R;
import defpackage.oc0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InterfaceC1015a f13267a;

    /* JADX INFO: renamed from: com.zenmen.palmchat.circle.ui.dialog.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC1015a {
        void a(int i);
    }

    public a(@NonNull Context context, InterfaceC1015a interfaceC1015a) {
        super(context);
        this.f13267a = interfaceC1015a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        oc0.g("lx_deletepopup_cancel_click");
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        oc0.g("lx_deletepopup_delete_click");
        h(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(View view) {
        oc0.g("lx_deletepopup_foreverdelete_click");
        h(1);
    }

    public final void d() {
        findViewById(R.id.layout_circle_cancel).setOnClickListener(new View.OnClickListener() { // from class: tc1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20958a.e(view);
            }
        });
        findViewById(R.id.layout_circle_remove_member).setOnClickListener(new View.OnClickListener() { // from class: uc1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f21188a.f(view);
            }
        });
        findViewById(R.id.layout_circle_remove_and_black_user).setOnClickListener(new View.OnClickListener() { // from class: vc1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f21403a.g(view);
            }
        });
    }

    public final void h(int i) {
        dismiss();
        InterfaceC1015a interfaceC1015a = this.f13267a;
        if (interfaceC1015a != null) {
            interfaceC1015a.a(i);
        }
    }

    public final void i() {
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(0));
        WindowManager.LayoutParams attributes = window.getAttributes();
        setCanceledOnTouchOutside(true);
        attributes.gravity = 80;
        attributes.width = getContext().getResources().getDisplayMetrics().widthPixels;
        attributes.flags &= 2;
        window.setAttributes(attributes);
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_circle_remove_or_black_user_layout);
        d();
        i();
    }

    @Override // android.app.Dialog
    public void show() {
        oc0.g("lx_group_deletepopup_show");
        super.show();
    }
}
