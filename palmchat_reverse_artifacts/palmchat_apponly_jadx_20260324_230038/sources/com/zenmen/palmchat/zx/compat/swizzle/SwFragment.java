package com.zenmen.palmchat.zx.compat.swizzle;

import androidx.fragment.app.Fragment;
import com.zenmen.palmchat.zx.annotation.SwizzleParent;
import defpackage.r43;
import defpackage.rm2;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0017\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\t\b\u0016¢\u0006\u0004\b\f\u0010\rR$\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/zenmen/palmchat/zx/compat/swizzle/SwFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/zenmen/palmchat/zx/compat/Fragment;", "Lrm2;", "Lr43;", "d", "Lr43;", "U0", "()Lr43;", "a0", "(Lr43;)V", "__sw_loaders__", "<init>", "()V", "zx-compat_release"}, k = 1, mv = {1, 4, 0})
@SwizzleParent(category = "compat", value = Fragment.class)
public class SwFragment extends Fragment implements rm2 {

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public r43 __sw_loaders__;

    @Override // defpackage.rm2
    /* JADX INFO: renamed from: U0, reason: from getter */
    public r43 get__sw_loaders__() {
        return this.__sw_loaders__;
    }

    @Override // defpackage.rm2
    public void a0(r43 r43Var) {
        this.__sw_loaders__ = r43Var;
    }
}
