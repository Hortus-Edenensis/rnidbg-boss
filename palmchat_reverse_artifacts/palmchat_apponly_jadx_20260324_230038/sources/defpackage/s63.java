package defpackage;

import com.zenmen.palmchat.zx.jvm.LOG_LEVEL;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
public final /* synthetic */ class s63 {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

    static {
        int[] iArr = new int[LOG_LEVEL.values().length];
        $EnumSwitchMapping$0 = iArr;
        iArr[LOG_LEVEL.INFO.ordinal()] = 1;
        iArr[LOG_LEVEL.WARN.ordinal()] = 2;
        iArr[LOG_LEVEL.FATAL.ordinal()] = 3;
    }
}
