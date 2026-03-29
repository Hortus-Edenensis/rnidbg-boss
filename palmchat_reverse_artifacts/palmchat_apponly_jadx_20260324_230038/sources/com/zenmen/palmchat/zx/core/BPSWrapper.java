package com.zenmen.palmchat.zx.core;

import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.qq.gdt.action.ActionUtils;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u0016*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005:\u0001\u0017B\u0015\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0011\u0010\b\u001a\u0004\u0018\u00018\u0001H&¢\u0006\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00018\u00018\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000eR(\u0010\u000f\u001a\u0004\u0018\u00018\u00012\b\u0010\u000f\u001a\u0004\u0018\u00018\u00018V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/zenmen/palmchat/zx/core/BPSWrapper;", "Landroid/os/Parcelable;", ExifInterface.GPS_DIRECTION_TRUE, "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/zenmen/palmchat/zx/core/APSWrapper;", "", "serial", "deserial", "()Ljava/lang/Object;", "_value", "Ljava/lang/Object;", "get_value", "set_value", "(Ljava/lang/Object;)V", ActionUtils.PAYMENT_AMOUNT, "getValue", "setValue", "Landroid/os/Parcelable$Creator;", "creator", "<init>", "(Landroid/os/Parcelable$Creator;)V", "Companion", "a", "zx-core_release"}, k = 1, mv = {1, 4, 0})
public abstract class BPSWrapper<T extends Parcelable, V> extends APSWrapper<T, V> {
    private static final long serialVersionUID = -5667605795335674114L;
    private transient V _value;

    public BPSWrapper(Parcelable.Creator<T> creator) {
        super(creator);
    }

    public abstract V deserial();

    @Override // com.zenmen.palmchat.zx.core.APSWrapper
    public V getValue() {
        if (this._value == null && getData() != null) {
            this._value = deserial();
        }
        return this._value;
    }

    public final V get_value() {
        return this._value;
    }

    public abstract byte[] serial();

    @Override // com.zenmen.palmchat.zx.core.APSWrapper
    public void setValue(V v) {
        this._value = v;
        setData(v == null ? null : serial());
    }

    public final void set_value(V v) {
        this._value = v;
    }
}
