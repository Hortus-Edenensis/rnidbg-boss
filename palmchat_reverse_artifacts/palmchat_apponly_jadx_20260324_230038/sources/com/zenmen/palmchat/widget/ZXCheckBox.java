package com.zenmen.palmchat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ZXCheckBox extends CheckBox {
    private a listener;

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a implements CompoundButton.OnCheckedChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f16013a = true;

        public abstract void b(CompoundButton compoundButton, boolean z, boolean z2);

        public final void c(boolean z) {
            this.f16013a = z;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            b(compoundButton, z, this.f16013a);
        }
    }

    public ZXCheckBox(Context context) {
        super(context);
    }

    public void setChecked(boolean z, boolean z2) {
        a aVar = this.listener;
        if (aVar != null) {
            aVar.c(z2);
        }
        super.setChecked(z);
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(@Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        if (onCheckedChangeListener instanceof a) {
            this.listener = (a) onCheckedChangeListener;
        }
    }

    public ZXCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ZXCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        a aVar = this.listener;
        if (aVar != null) {
            aVar.c(true);
        }
        super.setChecked(z);
    }
}
