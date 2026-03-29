package com.zenmen.palmchat.chat;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.BaseFragment;
import com.zenmen.palmchat.R;
import defpackage.sd3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ChatterMoreActionFragment extends BaseFragment implements View.OnClickListener {
    public static final String k = "ChatterMoreActionFragment";
    public Handler g;
    public ImageView i;
    public ImageView j;
    public boolean f = true;
    public boolean h = true;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends MaterialDialog.e {
        public a() {
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            if (ChatterMoreActionFragment.this.g != null) {
                ChatterMoreActionFragment.this.g.sendEmptyMessage(1000);
            }
            super.onPositive(materialDialog);
        }
    }

    public boolean T() {
        return this.f;
    }

    public void V(boolean z) {
        this.f = z;
        if (this.h) {
            this.j.setEnabled(z);
        }
        this.i.setEnabled(z);
    }

    public void W(boolean z) {
        this.h = z;
    }

    public void Y(Handler handler) {
        this.g = handler;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Handler handler;
        if (view == this.i) {
            sd3 sd3Var = new sd3(getActivity());
            sd3Var.j(R.string.confirm_delete).N(R.color.material_dialog_button_text_color_red).O(R.string.string_delete).K(R.string.dialog_cancel).f(new a());
            sd3Var.e().show();
        } else {
            if (view != this.j || (handler = this.g) == null) {
                return;
            }
            handler.sendEmptyMessage(1001);
        }
    }

    @Override // com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_fragment_more_action, (ViewGroup) null);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.action_delete);
        this.i = imageView;
        imageView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.action_forward);
        this.j = imageView2;
        imageView2.setOnClickListener(this);
        this.j.setEnabled(this.h);
        return viewInflate;
    }
}
