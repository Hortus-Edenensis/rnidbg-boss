package com.zenmen.media.album.pop;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.me1;
import defpackage.nk4;
import defpackage.xk3;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class PopMediaDialog extends BottomSheetDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f11940a;
    public View b;
    public BottomSheetBehavior<FrameLayout> c;
    public int d;
    public int e;
    public nk4 f;
    public xk3.a g;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PopMediaDialog.this.cancel();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements DialogInterface.OnDismissListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            PopMediaDialog.this.n();
        }
    }

    public PopMediaDialog(@NonNull FrameworkBaseActivity frameworkBaseActivity) {
        super(frameworkBaseActivity, R.style.SquareBottomDialog);
        this.d = 0;
        this.e = 0;
        this.f = null;
        LogUtil.i("PoMediaDialog", "init");
        View viewInflate = getLayoutInflater().inflate(R.layout.square_layout_dialog_media_select, (ViewGroup) null);
        this.f11940a = viewInflate.findViewById(R.id.media_select);
        this.b = viewInflate;
        this.f = new nk4(frameworkBaseActivity, this, viewInflate);
        viewInflate.findViewById(R.id.close).setOnClickListener(new a());
        int iF = me1.f();
        this.d = iF;
        int i = (int) (iF * 0.56f);
        this.e = me1.b(frameworkBaseActivity, 66);
        setContentView(viewInflate, new ViewGroup.LayoutParams(-1, i));
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.design_bottom_sheet);
        if (frameLayout != null) {
            try {
                BottomSheetBehavior<FrameLayout> bottomSheetBehaviorFrom = BottomSheetBehavior.from(frameLayout);
                this.c = bottomSheetBehaviorFrom;
                bottomSheetBehaviorFrom.setPeekHeight(i);
                this.c.setBottomSheetCallback(new b());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void m(int i, int i2, @Nullable Intent intent) {
        LogUtil.i("PoMediaDialog", "onActivityResult");
        this.f.y(i, i2, intent);
    }

    public void n() {
        try {
            this.f.A();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void o(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage) {
        LogUtil.i("PoMediaDialog", "onPermissionDenied");
        this.f.C(permissionType, permissionUsage);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        LogUtil.i("PoMediaDialog", "onAttachedToWindow");
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LogUtil.i("PoMediaDialog", "onCreate");
        getWindow().addFlags(67108864);
        this.f.z();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LogUtil.i("PoMediaDialog", "onDetachedFromWindow");
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, android.app.Dialog
    public void onStart() {
        super.onStart();
        setOnDismissListener(new c());
        LogUtil.i("PoMediaDialog", "onStart");
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onStop() {
        super.onStop();
        LogUtil.i("PoMediaDialog", "onStop");
    }

    public void p(BaseActivityPermissionDispatcher.PermissionType permissionType, BaseActivityPermissionDispatcher.PermissionUsage permissionUsage, boolean z) {
        LogUtil.i("PoMediaDialog", "onPermissionGrant");
        this.f.D(permissionType, permissionUsage, z);
    }

    public void q() {
        this.f.E();
    }

    public void r(ArrayList<MediaItem> arrayList) {
        LogUtil.i("PoMediaDialog", "onSelected");
        xk3.a aVar = this.g;
        if (aVar != null) {
            aVar.a(arrayList);
        }
    }

    public void s(xk3.a aVar) {
        this.g = aVar;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends BottomSheetBehavior.BottomSheetCallback {
        public b() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(View view, int i) {
            if (i == 5) {
                PopMediaDialog.this.cancel();
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(View view, float f) {
        }
    }
}
