package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import com.zenmen.square.dynamiclife.CommonViewHolder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class hd5<T> extends zu2<T, CommonViewHolder> {
    public int b = 6;

    @LayoutRes
    public abstract int i();

    @Override // defpackage.zu2
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public CommonViewHolder d(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(i(), viewGroup, false);
        this.b = k();
        return new CommonViewHolder(viewInflate, viewGroup, this.b);
    }

    public int k() {
        return this.b;
    }
}
