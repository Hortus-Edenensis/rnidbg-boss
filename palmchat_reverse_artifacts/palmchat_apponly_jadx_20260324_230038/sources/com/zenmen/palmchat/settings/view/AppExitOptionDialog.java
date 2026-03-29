package com.zenmen.palmchat.settings.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.zenmen.palmchat.R;
import defpackage.me1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class AppExitOptionDialog extends BottomSheetDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f15331a;
    public TextView b;
    public TextView c;
    public TextView d;
    public a e;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(int i);
    }

    public AppExitOptionDialog(@NonNull Context context, a aVar) {
        super(context, R.style.CircleBottomDialog);
        this.f15331a = context;
        this.e = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(View view) {
        this.e.a(R.id.tv_exit);
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(View view) {
        this.e.a(R.id.tv_close);
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(View view) {
        dismiss();
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View viewInflate = getLayoutInflater().inflate(R.layout.dialog_layout_app_exit_option, (ViewGroup) null);
        setContentView(viewInflate, new ViewGroup.LayoutParams(me1.g(), -2));
        q();
        p();
        u(viewInflate);
    }

    public final void p() {
        this.b.setOnClickListener(new View.OnClickListener() { // from class: sg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20734a.r(view);
            }
        });
        this.c.setOnClickListener(new View.OnClickListener() { // from class: tg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20979a.s(view);
            }
        });
        this.d.setOnClickListener(new View.OnClickListener() { // from class: ug
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f21205a.t(view);
            }
        });
    }

    public final void q() {
        this.b = (TextView) findViewById(R.id.tv_exit);
        this.c = (TextView) findViewById(R.id.tv_close);
        this.d = (TextView) findViewById(R.id.tv_cancel);
    }

    public final void u(View view) {
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.width = getContext().getResources().getDisplayMetrics().widthPixels;
            attributes.height = me1.b(getContext(), 200);
            attributes.flags &= 2;
            window.setAttributes(attributes);
            BottomSheetBehavior.from((View) view.getParent()).setPeekHeight(me1.b(getContext(), 200));
        }
    }
}
