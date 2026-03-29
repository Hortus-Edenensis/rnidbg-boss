package defpackage;

import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.api.model.AdnName;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: qg4, reason: from toString */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0080\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012¨\u0006\u0014"}, d2 = {"Lqg4;", "", "", "toString", "", "hashCode", AdnName.OTHER, "", "equals", "", "a", "Ljava/util/List;", "()Ljava/util/List;", "permissions", "Lkotlin/Function0;", "", t.l, "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", "proc", "zx-permission_release"}, k = 1, mv = {1, 4, 0})
public final /* data */ class PermissionProc {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final List<String> permissions;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    public final Function0<Unit> proc;

    public final List<String> a() {
        return this.permissions;
    }

    public final Function0<Unit> b() {
        return this.proc;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PermissionProc)) {
            return false;
        }
        PermissionProc permissionProc = (PermissionProc) other;
        return Intrinsics.areEqual(this.permissions, permissionProc.permissions) && Intrinsics.areEqual(this.proc, permissionProc.proc);
    }

    public int hashCode() {
        List<String> list = this.permissions;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        Function0<Unit> function0 = this.proc;
        return iHashCode + (function0 != null ? function0.hashCode() : 0);
    }

    public String toString() {
        return "PermissionProc(permissions=" + this.permissions + ", proc=" + this.proc + ")";
    }
}
