package com.zenmen.palmchat.zx.core;

import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import defpackage.dc4;
import defpackage.x55;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \f*\b\b\u0000\u0010\u0002*\u00020\u00012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003:\u0001\rB\u0015\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u000e"}, d2 = {"Lcom/zenmen/palmchat/zx/core/PSListWrapper;", "Landroid/os/Parcelable;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/zenmen/palmchat/zx/core/BPSWrapper;", "", "deserial", "", "serial", "Landroid/os/Parcelable$Creator;", "creator", "<init>", "(Landroid/os/Parcelable$Creator;)V", "Companion", "a", "zx-core_release"}, k = 1, mv = {1, 4, 0})
public class PSListWrapper<T extends Parcelable> extends BPSWrapper<T, List<? extends T>> {
    private static final long serialVersionUID = -3011954893498951620L;

    public PSListWrapper(Parcelable.Creator<T> creator) {
        super(creator);
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Serializable, java.lang.Object[]] */
    @Override // com.zenmen.palmchat.zx.core.BPSWrapper
    public byte[] serial() {
        Iterable iterable = get_value();
        if (iterable == null) {
            Intrinsics.throwNpe();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            byte[] bArrD = dc4.d((Parcelable) it.next());
            if (bArrD != null) {
                arrayList.add(bArrD);
            }
        }
        ?? array = arrayList.toArray(new byte[0][]);
        if (array != 0) {
            return x55.c(array);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @Override // com.zenmen.palmchat.zx.core.BPSWrapper
    public List<T> deserial() {
        byte[] data = getData();
        if (data == null) {
            Intrinsics.throwNpe();
        }
        Object[] objArr = (Object[]) x55.b(data, false, 2, null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            Parcelable parcelableB = dc4.b((byte[]) obj, getCreator());
            if (parcelableB != null) {
                arrayList.add(parcelableB);
            }
        }
        return arrayList;
    }
}
