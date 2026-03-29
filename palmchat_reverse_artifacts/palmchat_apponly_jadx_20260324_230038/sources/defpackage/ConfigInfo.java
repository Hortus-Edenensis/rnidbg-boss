package defpackage;

import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: sl0, reason: from toString */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\n\u0010\u0012\u001a\u00060\u0002j\u0002`\u000e\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0012\u001a\u00060\u0002j\u0002`\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\t\u0010\u0011¨\u0006\u0016"}, d2 = {"Lsl0;", "", "", "toString", "", "hashCode", AdnName.OTHER, "", "equals", "a", "Z", "c", "()Z", "DEBUGGABLE", "Lcom/zenmen/palmchat/zx/jvm/BuildType;", t.l, "Ljava/lang/String;", "()Ljava/lang/String;", "BUILD_TYPE", "BUILD_ID", "<init>", "(ZLjava/lang/String;Ljava/lang/String;)V", "zx-jvm"}, k = 1, mv = {1, 4, 0})
public final /* data */ class ConfigInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean DEBUGGABLE;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata and from toString */
    public final String BUILD_TYPE;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata and from toString */
    public final String BUILD_ID;

    public ConfigInfo(boolean z, String str, String str2) {
        this.DEBUGGABLE = z;
        this.BUILD_TYPE = str;
        this.BUILD_ID = str2;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getBUILD_ID() {
        return this.BUILD_ID;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getBUILD_TYPE() {
        return this.BUILD_TYPE;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final boolean getDEBUGGABLE() {
        return this.DEBUGGABLE;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConfigInfo)) {
            return false;
        }
        ConfigInfo configInfo = (ConfigInfo) other;
        return this.DEBUGGABLE == configInfo.DEBUGGABLE && Intrinsics.areEqual(this.BUILD_TYPE, configInfo.BUILD_TYPE) && Intrinsics.areEqual(this.BUILD_ID, configInfo.BUILD_ID);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z = this.DEBUGGABLE;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        String str = this.BUILD_TYPE;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.BUILD_ID;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ConfigInfo(DEBUGGABLE=" + this.DEBUGGABLE + ", BUILD_TYPE=" + this.BUILD_TYPE + ", BUILD_ID=" + this.BUILD_ID + ")";
    }
}
