package defpackage;

import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.PublishedApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0004\u001a\u00020\u0003H\u0003R\u001a\u0010\t\u001a\u00020\u00038\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00038PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u0010"}, d2 = {"Lfy2;", "Loy2;", "Lmj0;", "", "y0", t.l, "Z", "O", "()Z", "handlesException", "P", "onCancelComplete", "Lcy2;", "parent", "<init>", "(Lcy2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
@PublishedApi
public class fy2 extends oy2 implements mj0 {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final boolean handlesException;

    public fy2(cy2 cy2Var) {
        super(true);
        V(cy2Var);
        this.handlesException = y0();
    }

    @Override // defpackage.oy2
    /* JADX INFO: renamed from: O, reason: from getter */
    public boolean getHandlesException() {
        return this.handlesException;
    }

    @Override // defpackage.oy2
    public boolean P() {
        return true;
    }

    public final boolean y0() {
        oy2 oy2VarY;
        q50 q50VarR = R();
        r50 r50Var = q50VarR instanceof r50 ? (r50) q50VarR : null;
        if (r50Var != null && (oy2VarY = r50Var.y()) != null) {
            while (!oy2VarY.getHandlesException()) {
                q50 q50VarR2 = oy2VarY.R();
                r50 r50Var2 = q50VarR2 instanceof r50 ? (r50) q50VarR2 : null;
                if (r50Var2 == null || (oy2VarY = r50Var2.y()) == null) {
                }
            }
            return true;
        }
        return false;
    }
}
