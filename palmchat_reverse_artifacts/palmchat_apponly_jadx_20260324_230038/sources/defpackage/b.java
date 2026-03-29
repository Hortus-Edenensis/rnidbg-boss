package defpackage;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0014\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H\u0016J\b\u0010\t\u001a\u00020\bH&R*\u0010\u000f\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lb;", ExifInterface.GPS_DIRECTION_TRUE, "La;", "", "Lcom/zenmen/palmchat/zx/jvm/TimeStampValue;", "now", "", "c", "", "g", "Ljava/lang/Long;", "get_expireAt", "()Ljava/lang/Long;", "h", "(Ljava/lang/Long;)V", "_expireAt", "<init>", "()V", "zx-jvm"}, k = 1, mv = {1, 4, 0})
public abstract class b<T> extends a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public Long _expireAt;

    @Override // defpackage.a
    public boolean c(long now) {
        Long l = this._expireAt;
        if (l == null) {
            return false;
        }
        if (l == null) {
            Intrinsics.throwNpe();
        }
        if (l.longValue() > now) {
            return false;
        }
        g();
        this._expireAt = null;
        return true;
    }

    public abstract void g();

    public final void h(Long l) {
        this._expireAt = l;
    }
}
