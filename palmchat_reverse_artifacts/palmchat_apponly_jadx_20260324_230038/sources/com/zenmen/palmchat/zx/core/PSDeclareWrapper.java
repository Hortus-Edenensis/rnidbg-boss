package com.zenmen.palmchat.zx.core;

import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import defpackage.dc4;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \f*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\rB\u0015\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\u0004\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u000e"}, d2 = {"Lcom/zenmen/palmchat/zx/core/PSDeclareWrapper;", "Landroid/os/Parcelable;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/zenmen/palmchat/zx/core/BPSWrapper;", "deserial", "()Landroid/os/Parcelable;", "", "serial", "Landroid/os/Parcelable$Creator;", "creator", "<init>", "(Landroid/os/Parcelable$Creator;)V", "Companion", "a", "zx-core_release"}, k = 1, mv = {1, 4, 0})
public class PSDeclareWrapper<T extends Parcelable> extends BPSWrapper<T, T> {
    private static final long serialVersionUID = 2232924248120464977L;

    public PSDeclareWrapper(Parcelable.Creator<T> creator) {
        super(creator);
    }

    @Override // com.zenmen.palmchat.zx.core.BPSWrapper
    public byte[] serial() {
        T t = get_value();
        if (t == 0) {
            Intrinsics.throwNpe();
        }
        return dc4.d((Parcelable) t);
    }

    @Override // com.zenmen.palmchat.zx.core.BPSWrapper
    public T deserial() {
        byte[] data = getData();
        if (data == null) {
            Intrinsics.throwNpe();
        }
        return (T) dc4.b(data, getCreator());
    }
}
