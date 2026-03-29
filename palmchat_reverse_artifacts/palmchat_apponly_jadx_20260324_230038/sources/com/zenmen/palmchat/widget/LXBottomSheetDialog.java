package com.zenmen.palmchat.widget;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.zenmen.palmchat.framework.R$color;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.framework.R$layout;
import com.zenmen.palmchat.framework.R$string;
import com.zenmen.palmchat.framework.R$style;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.b05;
import defpackage.me1;
import defpackage.wn4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class LXBottomSheetDialog extends BottomSheetDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f15972a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;
    public c f;
    public wn4 g;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LXBottomSheetDialog.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends BottomSheetBehavior.BottomSheetCallback {
        public b() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(@NonNull View view, float f) {
            LogUtil.i("LXBottomSheetDialog", "onSlide " + f);
            LXBottomSheetDialog.this.r(f);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(@NonNull View view, int i) {
            LogUtil.i("LXBottomSheetDialog", "onStateChanged " + i);
            if (i == 5) {
                LXBottomSheetDialog.this.dismiss();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a(float f);
    }

    public LXBottomSheetDialog(@NonNull Context context) {
        super(context, R$style.LXBottomSheetDialogBase);
        this.f15972a = 0.68f;
        this.d = true;
        this.e = false;
        this.f = null;
    }

    private int p() {
        int i = R$layout.layout_bottom_sheet_dialog;
        int i2 = this.c;
        return i2 == 1 ? R$layout.layout_bottom_sheet_dialog2 : i2 == 2 ? R$layout.layout_bottom_sheet_dialog3 : i2 == 3 ? R$layout.layout_bottom_sheet_dialog4 : i;
    }

    public abstract View n();

    public c o() {
        return this.f;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.b == 0) {
            this.b = (int) (me1.f() * this.f15972a);
            b05.d("sangxiang====>height====>" + this.b);
        }
        getWindow().setLayout(-1, this.c == 3 ? -2 : this.b + me1.b(getContext(), 45));
        getWindow().setGravity(80);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(p(), (ViewGroup) null);
        ImageView imageView = (ImageView) viewGroup.findViewById(R$id.img_close);
        if (imageView != null) {
            if (this.d) {
                imageView.setOnClickListener(new a());
            } else {
                imageView.setVisibility(8);
            }
        }
        FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(R$id.container);
        int i = this.c;
        if (i == 0 || i == 2) {
            frameLayout.addView(n(), new ViewGroup.LayoutParams(-1, -1));
            setContentView(viewGroup, new ViewGroup.LayoutParams(-1, this.b));
        } else {
            frameLayout.addView(n(), new ViewGroup.LayoutParams(-1, -2));
            setContentView(viewGroup, new ViewGroup.LayoutParams(-1, -2));
        }
        getWindow().findViewById(R$id.design_bottom_sheet).setBackgroundResource(R$color.translucent);
        BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from((View) viewGroup.getParent());
        bottomSheetBehaviorFrom.setPeekHeight(this.b);
        if (this.e) {
            viewGroup.setBackgroundColor(0);
        }
        if (this.c == 2) {
            bottomSheetBehaviorFrom.setHideable(false);
        }
        if (this.f != null) {
            bottomSheetBehaviorFrom.setBottomSheetCallback(new b());
        }
    }

    public void q() {
        wn4 wn4Var = this.g;
        if (wn4Var != null) {
            try {
                wn4Var.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void r(float f) {
        LogUtil.i("LXBottomSheetDialog", "onHeightChanged" + f);
        c cVar = this.f;
        if (cVar != null) {
            cVar.a(f);
        }
    }

    public void s(boolean z) {
        this.e = z;
    }

    public void t(int i) {
        this.b = i;
    }

    public void u(c cVar) {
        this.f = cVar;
    }

    public void v(float f) {
        this.f15972a = f;
    }

    public void w(boolean z) {
        this.d = z;
    }

    public void x(int i) {
        this.c = i;
    }

    public void y() {
        if (this.g == null) {
            wn4 wn4Var = new wn4(getContext());
            this.g = wn4Var;
            wn4Var.setCancelable(false);
            this.g.b(getContext().getString(R$string.progress_sending));
        }
        this.g.show();
    }

    public LXBottomSheetDialog(@NonNull Context context, @StyleRes int i) {
        super(context, i);
        this.f15972a = 0.68f;
        this.d = true;
        this.e = false;
        this.f = null;
    }
}
