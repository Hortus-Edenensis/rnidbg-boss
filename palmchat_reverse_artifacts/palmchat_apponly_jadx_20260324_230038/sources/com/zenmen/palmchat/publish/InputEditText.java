package com.zenmen.palmchat.publish;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class InputEditText extends EditText {
    public InputEditText(Context context) {
        super(context);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i) {
        try {
            return super.onTextContextMenuItem(i);
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public InputEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InputEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @TargetApi(21)
    public InputEditText(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
