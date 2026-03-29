package defpackage;

import androidx.exifinterface.media.ExifInterface;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B;\u0012\u0006\u0010\f\u001a\u00028\u0000\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\r\u0012\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007j\b\u0012\u0004\u0012\u00028\u0000`\b¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016R*\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007j\b\u0012\u0004\u0012\u00028\u0000`\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Ln55;", ExifInterface.LONGITUDE_EAST, "Lm55;", "", "s", "", WkAdxAdConfigMg.DSP_NAME_BAIDU, "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "f", "Lkotlin/jvm/functions/Function1;", "onUndeliveredElement", "pollResult", "Laz;", "cont", "<init>", "(Ljava/lang/Object;Laz;Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class n55<E> extends m55<E> {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @JvmField
    public final Function1<E, Unit> onUndeliveredElement;

    /* JADX WARN: Multi-variable type inference failed */
    public n55(E e, az<? super Unit> azVar, Function1<? super E, Unit> function1) {
        super(e, azVar);
        this.onUndeliveredElement = function1;
    }

    @Override // defpackage.j55
    public void B() {
        C1503w74.b(this.onUndeliveredElement, getElement(), this.cont.get$context());
    }

    @Override // defpackage.v53
    public boolean s() {
        if (!super.s()) {
            return false;
        }
        B();
        return true;
    }
}
