package com.zenmen.square.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.widget.LXBottomSheetDialog;
import com.zenmen.square.R$id;
import com.zenmen.square.R$layout;
import com.zenmen.square.support.SquareSingleton;
import defpackage.a46;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class NearByFilterDialog extends LXBottomSheetDialog implements View.OnClickListener {
    public static int n = 2;
    public static int o = 0;
    public static int p = 1;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public a l;
    public int m;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(int i);

        void onCancel();
    }

    public NearByFilterDialog(@NonNull Context context) {
        super(context);
        this.m = n;
    }

    public static void A(Activity activity, a aVar) {
        if (activity.isFinishing()) {
            return;
        }
        NearByFilterDialog nearByFilterDialog = new NearByFilterDialog(activity);
        nearByFilterDialog.z(aVar);
        nearByFilterDialog.w(false);
        nearByFilterDialog.t(a46.b(activity, 208.0f));
        nearByFilterDialog.show();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        a aVar = this.l;
        if (aVar != null) {
            aVar.onCancel();
        }
    }

    @Override // com.zenmen.palmchat.widget.LXBottomSheetDialog
    public View n() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.square_layout_nearby_filter_dialog, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R$id.btn_all);
        this.h = textView;
        textView.setTag(Integer.valueOf(n));
        TextView textView2 = (TextView) viewInflate.findViewById(R$id.btn_male);
        this.i = textView2;
        textView2.setTag(Integer.valueOf(o));
        TextView textView3 = (TextView) viewInflate.findViewById(R$id.btn_female);
        this.j = textView3;
        textView3.setTag(Integer.valueOf(p));
        this.h.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.j.setOnClickListener(this);
        viewInflate.findViewById(R$id.iv_filter_dialog_close).setOnClickListener(this);
        int nearByFilter = SquareSingleton.getInstance().getNearByFilter();
        this.m = nearByFilter;
        if (nearByFilter == n) {
            this.h.setSelected(true);
            this.k = this.h;
        } else if (nearByFilter == o) {
            this.i.setSelected(true);
            this.k = this.i;
        } else {
            this.j.setSelected(true);
            this.k = this.j;
        }
        return viewInflate;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            if (view.getId() == R$id.iv_filter_dialog_close) {
                dismiss();
                return;
            }
            if (view instanceof TextView) {
                this.k.setSelected(false);
                view.setSelected(true);
                this.k = (TextView) view;
                int iIntValue = ((Integer) view.getTag()).intValue();
                if (iIntValue == this.m) {
                    dismiss();
                    return;
                }
                SquareSingleton.getInstance().setNearByFilter(iIntValue);
                a aVar = this.l;
                if (aVar != null) {
                    aVar.a(iIntValue);
                    this.l = null;
                }
                dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void z(a aVar) {
        this.l = aVar;
    }
}
