package com.zenmen.palmchat.giftkit.widgit;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.zenmen.giftkit.R$color;
import com.zenmen.giftkit.R$drawable;
import com.zenmen.giftkit.R$id;
import com.zenmen.giftkit.R$layout;
import com.zenmen.giftkit.R$style;
import com.zenmen.palmchat.giftkit.GiftPanel;
import defpackage.hc2;
import defpackage.me1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public abstract class CustomBottomSheetDialog extends BottomSheetDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14094a;
    public float b;
    public int c;
    public GiftPanel.g d;

    public CustomBottomSheetDialog(@NonNull Context context, int i, GiftPanel.g gVar) {
        super(context, R$style.CustomBottomSheetDialog);
        this.b = 0.68f;
        this.f14094a = i;
        this.d = gVar;
    }

    public abstract View m();

    public abstract View n();

    public abstract int o();

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        if (this.c == 0) {
            int iF = (int) (me1.f() * this.b);
            this.c = iF;
            if (this.d != null) {
                this.c = iF + me1.b(getContext(), 86);
            }
        }
        getWindow().setLayout(-1, this.c + me1.b(getContext(), 45));
        getWindow().setGravity(80);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R$layout.layout_custom_bottom_sheet_dialog, (ViewGroup) null);
        FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(R$id.container);
        RelativeLayout relativeLayout = (RelativeLayout) viewGroup.findViewById(R$id.header_ext);
        View viewFindViewById = viewGroup.findViewById(R$id.contentLayout);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewFindViewById.getLayoutParams();
        View viewFindViewById2 = viewGroup.findViewById(R$id.bannerLayout);
        TextView textView = (TextView) viewGroup.findViewById(R$id.bannerTitle);
        ImageView imageView = (ImageView) viewGroup.findViewById(R$id.notfriend_bannerIv);
        GiftPanel.g gVar = this.d;
        if (gVar != null) {
            if (TextUtils.isEmpty(gVar.b)) {
                viewFindViewById2.setVisibility(0);
                imageView.setVisibility(8);
                textView.setText(this.d.f14070a);
            } else {
                viewFindViewById2.setVisibility(8);
                imageView.setVisibility(0);
                hc2.a(getContext()).load(this.d.b).error(R$drawable.ic_gift_banner_bg_not_friend).into(imageView);
            }
            layoutParams.topMargin = me1.b(getContext(), 86);
        } else {
            viewFindViewById2.setVisibility(8);
            imageView.setVisibility(8);
            layoutParams.topMargin = 0;
        }
        viewFindViewById.setLayoutParams(layoutParams);
        relativeLayout.removeAllViews();
        View viewN = n();
        if (viewN != null) {
            relativeLayout.setVisibility(0);
            if (viewN.getParent() != null) {
                ((ViewGroup) viewN.getParent()).removeAllViews();
            }
            relativeLayout.addView(viewN, new RelativeLayout.LayoutParams(-1, o()));
        } else {
            relativeLayout.setVisibility(8);
        }
        frameLayout.addView(m(), new ViewGroup.LayoutParams(-1, -2));
        if (p()) {
            viewFindViewById.setBackgroundResource(R$color.transparent);
            frameLayout.setBackgroundColor(this.f14094a == 0 ? -1 : Color.parseColor("#05030D"));
        } else {
            viewFindViewById.setBackgroundResource(this.f14094a == 0 ? R$drawable.bg_sheet_dialog_light : R$drawable.bg_sheet_dialog_dark);
            frameLayout.setBackgroundResource(R$color.transparent);
        }
        setContentView(viewGroup, new ViewGroup.LayoutParams(-1, this.c));
        getWindow().findViewById(R$id.design_bottom_sheet).setBackgroundResource(R$color.transparent);
        BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from((View) viewGroup.getParent());
        bottomSheetBehaviorFrom.setPeekHeight(this.c);
        bottomSheetBehaviorFrom.setHideable(false);
    }

    public abstract boolean p();

    public void q(int i) {
        this.c = i;
    }
}
