package com.wifi.ad.core.entity;

import androidx.annotation.NonNull;
import com.kwad.sdk.api.model.AdnName;
import com.wifi.adsdk.download.LxAdDLManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\b\u0010\u0014\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/wifi/ad/core/entity/AdProviderEntity;", "", "providerType", "", "classPath", LxAdDLManager.ITEM_DESC, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClassPath", "()Ljava/lang/String;", "getDesc", "getProviderType", "component1", "component2", "component3", "copy", "equals", "", AdnName.OTHER, "hashCode", "", "toString", "core_release"}, k = 1, mv = {1, 1, 16})
public final /* data */ class AdProviderEntity {
    private final String classPath;
    private final String desc;
    private final String providerType;

    public AdProviderEntity(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        this.providerType = str;
        this.classPath = str2;
        this.desc = str3;
    }

    public static /* synthetic */ AdProviderEntity copy$default(AdProviderEntity adProviderEntity, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = adProviderEntity.providerType;
        }
        if ((i & 2) != 0) {
            str2 = adProviderEntity.classPath;
        }
        if ((i & 4) != 0) {
            str3 = adProviderEntity.desc;
        }
        return adProviderEntity.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getProviderType() {
        return this.providerType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getClassPath() {
        return this.classPath;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    public final AdProviderEntity copy(@NonNull String providerType, @NonNull String classPath, @NonNull String desc) {
        return new AdProviderEntity(providerType, classPath, desc);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdProviderEntity)) {
            return false;
        }
        AdProviderEntity adProviderEntity = (AdProviderEntity) other;
        return Intrinsics.areEqual(this.providerType, adProviderEntity.providerType) && Intrinsics.areEqual(this.classPath, adProviderEntity.classPath) && Intrinsics.areEqual(this.desc, adProviderEntity.desc);
    }

    public final String getClassPath() {
        return this.classPath;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getProviderType() {
        return this.providerType;
    }

    public int hashCode() {
        String str = this.providerType;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.classPath;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.desc;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "AdProviderEntity(providerType=" + this.providerType + ", classPath='" + this.classPath + "', desc='" + this.desc + "')";
    }

    public /* synthetic */ AdProviderEntity(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? str2 : str3);
    }
}
