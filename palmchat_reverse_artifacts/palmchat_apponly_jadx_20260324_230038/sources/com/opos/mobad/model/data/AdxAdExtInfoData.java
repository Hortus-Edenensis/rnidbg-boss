package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.mobad.b.a.ac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class AdxAdExtInfoData implements Parcelable {
    public static final Parcelable.Creator<AdxAdExtInfoData> CREATOR = new Parcelable.Creator<AdxAdExtInfoData>() { // from class: com.opos.mobad.model.data.AdxAdExtInfoData.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdxAdExtInfoData createFromParcel(Parcel parcel) {
            return new AdxAdExtInfoData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdxAdExtInfoData[] newArray(int i) {
            return new AdxAdExtInfoData[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f9078a;
    public List<String> b;

    public AdxAdExtInfoData() {
        this.f9078a = 0;
        this.b = new ArrayList();
    }

    public static List<AdxAdExtInfoData> a(List<ac.a> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator<ac.a> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new AdxAdExtInfoData(it.next()));
            }
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (this.f9078a == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.f9078a.intValue());
        }
        parcel.writeStringList(this.b);
    }

    public AdxAdExtInfoData(Parcel parcel) {
        this.f9078a = parcel.readByte() == 0 ? null : Integer.valueOf(parcel.readInt());
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        this.b = arrayListCreateStringArrayList;
        if (arrayListCreateStringArrayList == null) {
            this.b = new ArrayList();
        }
    }

    public AdxAdExtInfoData(ac.a aVar) {
        this.f9078a = aVar.e;
        this.b = aVar.f;
    }
}
