package defpackage;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.kuaishou.weapon.p0.t;
import com.qq.gdt.action.ActionUtils;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J!\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00018\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u000e\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\rR\u001e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcd0;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroid/content/Context;", "context", "", "a", ActionUtils.PAYMENT_AMOUNT, "", "c", "(Ljava/lang/Object;Landroid/content/Context;)V", t.l, "()Ljava/lang/Object;", "Ljava/lang/Object;", "_value", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "_context", "<init>", "()V", "zx-permission_release"}, k = 1, mv = {1, 4, 0})
public final class cd0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public T _value;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public WeakReference<Context> _context = new WeakReference<>(null);

    public final boolean a(Context context) {
        return this._value == null || (Intrinsics.areEqual(this._context.get(), context) ^ true);
    }

    public final T b() {
        return this._value;
    }

    public final void c(T value, Context context) {
        this._value = value;
        this._context = new WeakReference<>(context);
    }
}
