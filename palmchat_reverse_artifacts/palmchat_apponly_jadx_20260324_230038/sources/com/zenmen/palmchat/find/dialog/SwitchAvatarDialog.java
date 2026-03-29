package com.zenmen.palmchat.find.dialog;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.widget.LXBottomSheetDialog;
import com.zenmen.square.support.SquareSingleton;
import defpackage.a46;
import defpackage.k86;
import defpackage.ky;
import defpackage.mc3;
import defpackage.yg4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class SwitchAvatarDialog<T> extends LXBottomSheetDialog implements View.OnClickListener {
    public ky h;
    public View i;
    public View j;
    public CheckBox k;
    public TextView l;
    public TextView m;
    public int n;
    public mc3 o;
    public boolean p;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            SwitchAvatarDialog.this.l.setText(z ? "开启" : "关闭");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends ClickableSpan {
        public b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            AgreementDialog.A(SwitchAvatarDialog.this.getContext(), "https://storage.lianxinapp.com/mdc/res/v5/1/9ugxnorjls-13-4-c75a6cfbe92140adae03fc770df92656-s03l2b");
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
            textPaint.setColor(Color.parseColor("#14CD64"));
        }
    }

    public SwitchAvatarDialog(@NonNull Context context, ky<T> kyVar, mc3 mc3Var) {
        super(context);
        this.p = false;
        this.h = kyVar;
        this.o = mc3Var;
        s(true);
        this.n = AppContext.getContext().getTrayPreferences().b(k86.w(), 0);
    }

    public final SpannableString A() {
        String string = this.m.getText().toString();
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new b(), string.length() - 12, string.length(), 17);
        return spannableString;
    }

    public final void B(View view) {
        this.i = view.findViewById(R.id.iv_agreement_checkbox);
        this.j = view.findViewById(R.id.confirm);
        this.i.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.k = (CheckBox) view.findViewById(R.id.avatar_show_checkbox);
        this.l = (TextView) view.findViewById(R.id.tv_switch_box_desc);
        TextView textView = (TextView) view.findViewById(R.id.tv_agreement_desc);
        this.m = textView;
        textView.setText(A());
        this.m.setMovementMethod(LinkMovementMethod.getInstance());
        this.k.setOnCheckedChangeListener(new a());
        this.k.setChecked(yg4.a(this.n, 32768) || !SquareSingleton.getInstance().getUsedTagHelper().a(2L));
        if (yg4.a(this.n, 32768)) {
            this.i.setVisibility(4);
            this.m.setVisibility(4);
        }
    }

    public final void C(boolean z) {
        ky kyVar = this.h;
        if (kyVar != null) {
            if (z) {
                kyVar.a(Boolean.valueOf(this.k.isChecked()));
            } else {
                this.p = true;
                kyVar.onCancel();
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
            mc3 mc3Var = this.o;
            if (mc3Var != null) {
                mc3Var.a(this.p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.zenmen.palmchat.widget.LXBottomSheetDialog
    public View n() {
        View viewInflate = getLayoutInflater().inflate(R.layout.dialog_find_map_avatar_switch, (ViewGroup) null);
        t(a46.b(getContext(), 309.0f));
        B(viewInflate);
        return viewInflate;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View view2 = this.i;
        boolean z = true;
        if (view == view2) {
            view2.setSelected(!view2.isSelected());
        }
        if (view == this.j) {
            if (yg4.a(this.n, 32768) ^ this.k.isChecked()) {
                if (!this.i.isSelected() && this.k.isChecked()) {
                    z = false;
                }
                C(z);
            }
            dismiss();
        }
    }
}
