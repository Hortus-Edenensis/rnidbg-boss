package defpackage;

import androidx.media3.common.SimpleBasePlayer;
import androidx.media3.transformer.CompositionPlayer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ok0 implements SimpleBasePlayer.PositionSupplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompositionPlayer f19783a;

    public /* synthetic */ ok0(CompositionPlayer compositionPlayer) {
        this.f19783a = compositionPlayer;
    }

    @Override // androidx.media3.common.SimpleBasePlayer.PositionSupplier
    public final long get() {
        return this.f19783a.getContentPositionMs();
    }
}
