package com.zenmen.palmchat.zx.core;

import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.qq.gdt.action.ActionUtils;
import defpackage.cc4;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 \u001f*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u0005:\u0001 B\u0015\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019¢\u0006\u0004\b\u001d\u0010\u001eR\u001b\u0010\b\u001a\u00060\u0006j\u0002`\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00018\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006!"}, d2 = {"Lcom/zenmen/palmchat/zx/core/APSWrapper;", "Landroid/os/Parcelable;", ExifInterface.GPS_DIRECTION_TRUE, "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Ljava/io/Serializable;", "", "Lcom/zenmen/palmchat/zx/core/ParcelCreatorId;", "creatorId", "I", "getCreatorId", "()I", "", "data", "[B", "getData", "()[B", "setData", "([B)V", ActionUtils.PAYMENT_AMOUNT, "Ljava/lang/Object;", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "Landroid/os/Parcelable$Creator;", "getCreator", "()Landroid/os/Parcelable$Creator;", "creator", "<init>", "(Landroid/os/Parcelable$Creator;)V", "Companion", "a", "zx-core_release"}, k = 1, mv = {1, 4, 0})
public abstract class APSWrapper<T extends Parcelable, V> implements Serializable {
    private static final long serialVersionUID = 1861544580281745735L;
    private final int creatorId;
    private byte[] data;
    private transient V value;

    public APSWrapper(Parcelable.Creator<T> creator) {
        Integer numB = cc4.c.b(creator);
        if (numB == null) {
            Intrinsics.throwNpe();
        }
        this.creatorId = numB.intValue();
    }

    public final Parcelable.Creator<T> getCreator() {
        Parcelable.Creator<T> creatorA = cc4.c.a(this.creatorId);
        if (creatorA == null) {
            Intrinsics.throwNpe();
        }
        return creatorA;
    }

    public final int getCreatorId() {
        return this.creatorId;
    }

    public final byte[] getData() {
        return this.data;
    }

    public V getValue() {
        return this.value;
    }

    public final void setData(byte[] bArr) {
        this.data = bArr;
    }

    public void setValue(V v) {
        this.value = v;
    }
}
