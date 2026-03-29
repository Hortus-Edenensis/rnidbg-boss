package defpackage;

import com.kuaishou.weapon.p0.t;
import com.umeng.analytics.pro.bd;
import com.zenmen.palmchat.zx.jvm.TERMCOLORS;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\"\u001a\u0010\b\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007*@\u0010\r\"\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00020\t2\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00020\t¨\u0006\u000e"}, d2 = {"Lzb4;", "ei", "", "a", "", "Ljava/lang/String;", t.l, "()Ljava/lang/String;", "LOG_TAG", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", bd.b, "LoggerProcType", "zx-jvm"}, k = 2, mv = {1, 4, 0})
public final class t63 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f20912a = "Zx";

    public static final void a(zb4 zb4Var) {
        int i = s63.$EnumSwitchMapping$0[zb4Var.getLevel().ordinal()];
        System.out.println((Object) ((i != 1 ? i != 2 ? i != 3 ? TERMCOLORS.RESET.getColor() : TERMCOLORS.RED.getColor() : TERMCOLORS.PURPLE.getColor() : TERMCOLORS.BLUE.getColor()) + ' ' + zb4Var + ' ' + TERMCOLORS.RESET.getColor()));
        Throwable thA = zb4Var.getException();
        if (thA != null) {
            thA.printStackTrace();
        }
    }

    public static final String b() {
        return f20912a;
    }
}
