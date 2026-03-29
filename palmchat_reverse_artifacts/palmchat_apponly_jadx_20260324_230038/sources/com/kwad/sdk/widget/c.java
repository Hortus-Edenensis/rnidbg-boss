package com.kwad.sdk.widget;

import android.app.Dialog;
import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.o.m;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated
public class c extends Dialog {
    public c(@NonNull Context context) {
        super(m.wrapContextIfNeed(context));
        requestWindowFeature(1);
    }
}
