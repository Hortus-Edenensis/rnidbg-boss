package com.zenmen.media.roomchat.floatingview;

import android.content.Context;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import com.zenmen.palmchat.R;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class EnFloatingView extends FloatingMagnetView {
    public EnFloatingView(@NonNull Context context) {
        this(context, R.layout.manychats_en_floating_view);
    }

    public EnFloatingView(@NonNull Context context, @LayoutRes int i) {
        super(context, null);
        View.inflate(context, R.layout.manychats_view_float_voip, this);
    }

    public void setIconImage(@DrawableRes int i) {
    }
}
