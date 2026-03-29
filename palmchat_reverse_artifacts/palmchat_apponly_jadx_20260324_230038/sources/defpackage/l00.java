package defpackage;

import androidx.exifinterface.media.ExifInterface;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u0004*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u0005¨\u0006\u0006"}, d2 = {"Ll00;", ExifInterface.LONGITUDE_EAST, "Ll55;", "Lut4;", "a0", "a", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public interface l00<E> extends l55<E>, ut4<E> {

    /* JADX INFO: renamed from: a0, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.f18869a;

    /* JADX INFO: renamed from: l00$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0007\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Ll00$a;", "", "", t.l, "I", "a", "()I", "CHANNEL_DEFAULT_CAPACITY", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f18869a = new Companion();

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public static final int CHANNEL_DEFAULT_CAPACITY = fr5.b("kotlinx.coroutines.channels.defaultBuffer", 64, 1, 2147483646);

        public final int a() {
            return CHANNEL_DEFAULT_CAPACITY;
        }
    }
}
