package com.zenmen.palmchat.widget;

import android.content.Context;
import android.util.AttributeSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SocialPortraitView extends EffectiveShapeView {
    public static final int SHAPE = 1;

    public SocialPortraitView(Context context) {
        super(context);
    }

    @Override // com.zenmen.palmchat.widget.EffectiveShapeView
    public void changeShapeType(int i) {
        super.changeShapeType(1);
    }

    public SocialPortraitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SocialPortraitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
