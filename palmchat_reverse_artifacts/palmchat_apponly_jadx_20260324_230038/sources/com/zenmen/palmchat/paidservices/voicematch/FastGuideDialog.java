package com.zenmen.palmchat.paidservices.voicematch;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.framework.bridge.voicomatch.SkuItem;
import com.zenmen.palmchat.framework.bridge.voicomatch.VoiceMatchType;
import defpackage.l50;
import defpackage.lh6;
import defpackage.me1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class FastGuideDialog extends BottomSheetDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f14878a;
    public View b;
    public Activity c;
    public d d;
    public String e;
    public String f;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FastGuideDialog.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l50.a()) {
                return;
            }
            if (FastGuideDialog.this.d != null) {
                FastGuideDialog.this.d.onConfirm();
            }
            FastGuideDialog.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        void onConfirm();
    }

    public FastGuideDialog(@NonNull Activity activity, d dVar, String str) {
        String str2;
        super(activity, R.style.CircleBottomDialog);
        this.c = activity;
        this.d = dVar;
        this.f = str;
        SkuItem skuItem = lh6.V().x().getSkuItem(VoiceMatchType.FAST);
        if (skuItem == null) {
            str2 = "";
        } else if (skuItem.remainingQuantity > 0) {
            str2 = "(剩余" + skuItem.remainingQuantity + "次)";
        } else {
            str2 = "(" + skuItem.price + "连信豆/次)";
        }
        this.e = str2;
    }

    public void n() {
        View viewInflate = getLayoutInflater().inflate(R.layout.layout_dialog_voice_match_fast_guide, (ViewGroup) null);
        viewInflate.findViewById(R.id.close).setOnClickListener(new a());
        View viewFindViewById = viewInflate.findViewById(R.id.confirm);
        this.b = viewFindViewById;
        viewFindViewById.setOnClickListener(new b());
        TextView textView = (TextView) viewInflate.findViewById(R.id.title);
        String str = this.f;
        if (str != null) {
            textView.setText(str);
        }
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.price);
        this.f14878a = textView2;
        textView2.setText(this.e);
        setCanceledOnTouchOutside(false);
        setOnCancelListener(new c());
        setContentView(viewInflate, new ViewGroup.LayoutParams(me1.g(), -2));
        o(viewInflate);
    }

    public final void o(View view) {
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.width = getContext().getResources().getDisplayMetrics().widthPixels;
            attributes.height = me1.b(getContext(), MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SAVED_HOST_TIME);
            attributes.flags &= 2;
            window.setAttributes(attributes);
            BottomSheetBehavior.from((View) view.getParent()).setPeekHeight(me1.b(getContext(), MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SAVED_HOST_TIME));
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(67108864);
        n();
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements DialogInterface.OnCancelListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
        }
    }
}
