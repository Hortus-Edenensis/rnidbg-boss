package com.opos.mobad.model.utils;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class AdHelper {

    /* JADX INFO: compiled from: SearchBox */
    public static class AdHelperData extends a implements Parcelable {
        public static final Parcelable.Creator<AdHelperData> CREATOR = new Parcelable.Creator<AdHelperData>() { // from class: com.opos.mobad.model.utils.AdHelper.AdHelperData.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public AdHelperData createFromParcel(Parcel parcel) {
                return new AdHelperData(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public AdHelperData[] newArray(int i) {
                return new AdHelperData[i];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AdData f9107a;
        public final long b;

        public AdHelperData(Parcel parcel) {
            super((AdItemData) parcel.readParcelable(AdItemData.class.getClassLoader()), (MaterialData) parcel.readParcelable(MaterialData.class.getClassLoader()), (MaterialFileData) parcel.readParcelable(MaterialFileData.class.getClassLoader()));
            this.f9107a = (AdData) parcel.readParcelable(AdData.class.getClassLoader());
            this.b = parcel.readLong();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.c, i);
            parcel.writeParcelable(this.d, i);
            parcel.writeParcelable(this.e, i);
            parcel.writeParcelable(this.f9107a, i);
            parcel.writeLong(this.b);
        }

        private AdHelperData(AdData adData, AdItemData adItemData, MaterialData materialData, long j) {
            this(adData, adItemData, materialData, (MaterialFileData) null, j);
        }

        private AdHelperData(AdData adData, AdItemData adItemData, MaterialData materialData, MaterialFileData materialFileData, long j) {
            super(adItemData, materialData, materialFileData);
            this.f9107a = adData;
            this.b = j;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        public final AdItemData c;
        public final MaterialData d;
        public final MaterialFileData e;

        public a(AdItemData adItemData, MaterialData materialData, MaterialFileData materialFileData) {
            this.c = adItemData;
            this.d = materialData;
            this.e = materialFileData;
        }
    }

    public static AdHelperData a(Context context, String str, String str2, String str3) {
        if (context == null) {
            return null;
        }
        AdData adData = new AdData(10000, "ok.");
        boolean z = context.getResources().getConfiguration().orientation == 1;
        MaterialData materialData = new MaterialData();
        materialData.a(z ? 10002 : 10001);
        materialData.b(1);
        materialData.h("oaps://qg/home");
        materialData.b(30000L);
        ArrayList arrayList = new ArrayList();
        arrayList.add(materialData);
        return new AdHelperData(adData, AdItemData.a.a().d(str).e(str2).b(str3).c("99").a(1).b(2).c(1).a("union_advert").a(Long.MAX_VALUE).a(true).e(1).d(z ? 2 : 1).a(arrayList).b(true).b(), materialData, null, SystemClock.elapsedRealtime());
    }

    public static final AdHelperData a(AdData adData) {
        return a(adData, SystemClock.elapsedRealtime());
    }

    public static final AdHelperData a(AdData adData, long j) {
        List<AdItemData> listF;
        MaterialData materialData;
        MaterialFileData materialFileData;
        if (adData != null && (listF = adData.f()) != null && listF.size() > 0) {
            for (int i = 0; i < listF.size(); i++) {
                AdItemData adItemData = listF.get(i);
                if (adItemData != null && adItemData.i() != null && adItemData.i().size() > 0 && (materialData = adItemData.i().get(0)) != null) {
                    if (!com.opos.mobad.ui.c.f.a(materialData.Z())) {
                        return new AdHelperData(adData, adItemData, materialData, j);
                    }
                    if (materialData.D() != null && materialData.D().size() > 0 && (materialFileData = materialData.D().get(0)) != null) {
                        return new AdHelperData(adData, adItemData, materialData, materialFileData, j);
                    }
                }
            }
        }
        return null;
    }
}
