package com.volcengine.lxvertc.common;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatDialog;
import com.zenmen.palmchat.lxvoip.vertc.R$style;
import com.zenmen.palmchat.lxvoip.vertc.databinding.DialogSolutionCommonBinding;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class SolutionCommonDialog extends AppCompatDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DialogSolutionCommonBinding f11316a;

    public SolutionCommonDialog(Context context) {
        super(context, R$style.SolutionCommonDialog);
        setCancelable(true);
        DialogSolutionCommonBinding dialogSolutionCommonBindingC = DialogSolutionCommonBinding.c(getLayoutInflater());
        this.f11316a = dialogSolutionCommonBindingC;
        dialogSolutionCommonBindingC.getRoot().setOnClickListener(new View.OnClickListener() { // from class: dg5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f17047a.n(view);
            }
        });
        setContentView(dialogSolutionCommonBindingC.getRoot(), new ViewGroup.LayoutParams(-1, -2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(View view) {
        dismiss();
    }

    public void o(String str) {
        this.f11316a.b.setText(str);
    }

    public void p(View.OnClickListener onClickListener) {
        this.f11316a.c.setVisibility(0);
        this.f11316a.c.setOnClickListener(onClickListener);
    }

    public void q(View.OnClickListener onClickListener) {
        this.f11316a.d.setOnClickListener(onClickListener);
    }
}
