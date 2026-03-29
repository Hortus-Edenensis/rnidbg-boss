package defpackage;

import com.baidu.platform.comapi.map.MapBundleKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002R\u0018\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lp50;", "Ldy2;", "", "cause", "", "x", "Lbz;", "e", "Lbz;", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "<init>", "(Lbz;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class p50 extends dy2 {

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @JvmField
    public final bz<?> child;

    public p50(bz<?> bzVar) {
        this.child = bzVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        x(th);
        return Unit.INSTANCE;
    }

    @Override // defpackage.sj0
    public void x(Throwable cause) {
        bz<?> bzVar = this.child;
        bzVar.F(bzVar.u(y()));
    }
}
