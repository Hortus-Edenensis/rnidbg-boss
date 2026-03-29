package com.zenmen.palmchat.zx.jvm;

import androidx.exifinterface.media.ExifInterface;
import com.qq.gdt.action.ActionUtils;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 \u000b*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\fB\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/zenmen/palmchat/zx/jvm/SkipSerial;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/io/Serializable;", ActionUtils.PAYMENT_AMOUNT, "Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "<init>", "()V", "Companion", "a", "zx-jvm"}, k = 1, mv = {1, 4, 0})
public class SkipSerial<T> implements Serializable {
    private static final long serialVersionUID = 1081404190305786299L;
    private transient T value;

    public final T getValue() {
        return this.value;
    }

    public final void setValue(T t) {
        this.value = t;
    }
}
