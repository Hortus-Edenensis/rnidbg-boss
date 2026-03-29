package com.zenmen.square.tag.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.R$style;
import com.zenmen.square.tag.adapter.SquareTagAdapter;
import com.zenmen.square.tag.bean.SquareTagBean;
import com.zenmen.square.tag.widget.SquareTagSelecDialogtHelper;
import defpackage.k36;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareTagSelectDialog extends BottomSheetDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f16491a;
    public Activity b;
    public SquareTagSelecDialogtHelper c;
    public c d;
    public SquareTagBean e;
    public boolean f;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SquareTagSelectDialog.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a(SquareTagBean squareTagBean);
    }

    public SquareTagSelectDialog(@NonNull Context context, boolean z) {
        super(context, R$style.SquareBottomDialog);
        this.b = (Activity) context;
        this.f = z;
    }

    public final void o() {
        this.c = (SquareTagSelecDialogtHelper) findViewById(R$id.tag);
        ((ImageView) findViewById(R$id.close)).setOnClickListener(new a());
        this.c.setSelectTag(this.e);
        this.c.bind(new b());
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(67108864);
        setContentView(R$layout.square_layout_dialog_publish_tag);
        this.f16491a = (ViewGroup) findViewById(R$id.root);
        o();
        p();
        s();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, @NonNull KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    public final void p() {
        this.c.load();
    }

    public void q(c cVar) {
        this.d = cVar;
    }

    public void r(SquareTagBean squareTagBean) {
        this.e = squareTagBean;
    }

    public final void s() {
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.width = getContext().getResources().getDisplayMetrics().widthPixels;
            attributes.height = k36.c(getContext());
            if (this.f) {
                attributes.flags &= 2;
                attributes.windowAnimations = R$style.squareDialogOutAndInStyle;
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            window.setAttributes(attributes);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements SquareTagSelecDialogtHelper.f {

        /* JADX INFO: compiled from: SearchBox */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SquareTagSelectDialog.this.dismiss();
            }
        }

        public b() {
        }

        @Override // com.zenmen.square.tag.widget.SquareTagSelecDialogtHelper.f
        public void b(SquareTagAdapter.a aVar) {
            SquareTagBean squareTagBeanB = aVar.b();
            if (SquareTagSelectDialog.this.d != null) {
                SquareTagSelectDialog.this.d.a(squareTagBeanB);
            }
            SquareTagSelectDialog.this.c.postDelayed(new a(), 200L);
        }

        @Override // com.zenmen.square.tag.widget.SquareTagSelecDialogtHelper.f
        public SquareTagSelecDialogtHelper.Scene getScene() {
            return SquareTagSelecDialogtHelper.Scene.PUBLISH_TOTAL;
        }

        @Override // com.zenmen.square.tag.widget.SquareTagSelecDialogtHelper.f
        public void a() {
        }

        @Override // com.zenmen.square.tag.widget.SquareTagSelecDialogtHelper.f
        public void c() {
        }
    }
}
