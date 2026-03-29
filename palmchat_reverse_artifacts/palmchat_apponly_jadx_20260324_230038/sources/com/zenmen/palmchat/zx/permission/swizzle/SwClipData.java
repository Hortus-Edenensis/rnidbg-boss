package com.zenmen.palmchat.zx.permission.swizzle;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ContentResolver;
import android.os.Parcel;
import androidx.annotation.RequiresApi;
import com.baidu.platform.comapi.map.MapController;
import com.huawei.openalliance.ad.constant.bq;
import com.igexin.push.core.b;
import com.kwad.sdk.api.model.AdnName;
import defpackage.dd0;
import defpackage.sp5;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000eH\u0017J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u0013\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0016R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/zenmen/palmchat/zx/permission/swizzle/SwClipData;", "Landroid/content/ClipData;", "Landroid/os/Parcel;", "dest", "", bq.f.z, "", "writeToParcel", "getItemCount", "", "toString", "Landroid/content/ClipDescription;", "getDescription", "index", "Landroid/content/ClipData$Item;", "getItemAt", MapController.ITEM_LAYER_TAG, "addItem", "Landroid/content/ContentResolver;", "resolver", "describeContents", "", AdnName.OTHER, "", "equals", "hashCode", "", "Lsp5;", "_items", "Ljava/util/List;", "data", "Landroid/content/ClipData;", "<init>", "(Landroid/content/ClipData;)V", "zx-permission_release"}, k = 1, mv = {1, 4, 0})
public final class SwClipData extends ClipData {
    private final List<sp5> _items;
    private final ClipData data;

    public SwClipData(ClipData clipData) {
        super(clipData.getDescription(), new ClipData.Item(b.m));
        this.data = clipData;
        List<ClipData.Item> listA = dd0.a(clipData);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listA, 10));
        Iterator<T> it = listA.iterator();
        while (it.hasNext()) {
            arrayList.add(new sp5((ClipData.Item) it.next()));
        }
        this._items = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
    }

    @Override // android.content.ClipData
    public void addItem(ClipData.Item item) {
        this.data.addItem(item);
        this._items.add(new sp5(item));
    }

    @Override // android.content.ClipData, android.os.Parcelable
    public int describeContents() {
        return this.data.describeContents();
    }

    public boolean equals(Object other) {
        return this.data.equals(other);
    }

    @Override // android.content.ClipData
    public ClipDescription getDescription() {
        ClipDescription description = this.data.getDescription();
        Intrinsics.checkExpressionValueIsNotNull(description, "data.description");
        return description;
    }

    @Override // android.content.ClipData
    public ClipData.Item getItemAt(int index) {
        return this._items.get(index);
    }

    @Override // android.content.ClipData
    public int getItemCount() {
        return this._items.size();
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    @Override // android.content.ClipData
    public String toString() {
        String string = this.data.toString();
        Intrinsics.checkExpressionValueIsNotNull(string, "data.toString()");
        return string;
    }

    @Override // android.content.ClipData, android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        this.data.writeToParcel(dest, flags);
    }

    @Override // android.content.ClipData
    @RequiresApi(26)
    public void addItem(ContentResolver resolver, ClipData.Item item) {
        this.data.addItem(resolver, item);
        this._items.add(new sp5(getItemAt(getItemCount() - 1)));
    }
}
