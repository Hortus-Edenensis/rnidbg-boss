package com.zenmen.square.fragment;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.zenmen.square.InteractMessageActivity;
import defpackage.xi5;
import defpackage.xt2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class InteractMessageFragment extends SquareInteractFragment {
    public long o;
    public int p;

    @Override // com.zenmen.square.fragment.SquareInteractFragment
    public xi5 M0() {
        if (this.k == 0) {
            this.k = new xt2(this.o, this.p);
        }
        return (xi5) this.k;
    }

    @Override // com.zenmen.square.fragment.SquareInteractFragment, com.zenmen.listui.duration.BaseDurationFragment
    public int o() {
        return 18;
    }

    @Override // com.zenmen.listui.duration.BaseDurationFragment, com.zenmen.palmchat.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.o = getArguments().getLong(InteractMessageActivity.r);
        this.p = getArguments().getInt(InteractMessageActivity.s);
    }
}
