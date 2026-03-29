package defpackage;

import android.util.Log;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000e"}, d2 = {"Le61;", "Lsm2;", "", "tag", "msg", "", "info", "debug", t.l, "", "error", "a", "<init>", "()V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public final class e61 implements sm2 {
    @Override // defpackage.sm2
    public void a(String tag, String msg, Throwable error) {
        Log.e(tag, msg, error);
    }

    @Override // defpackage.sm2
    public void b(String tag, String msg) {
        Log.w(tag, msg);
    }

    @Override // defpackage.sm2
    public void debug(String tag, String msg) {
        Log.d(tag, msg);
    }

    @Override // defpackage.sm2
    public void info(String tag, String msg) {
        Log.i(tag, msg);
    }
}
