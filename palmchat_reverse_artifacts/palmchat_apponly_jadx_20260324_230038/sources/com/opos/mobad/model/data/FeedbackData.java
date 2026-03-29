package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class FeedbackData extends a implements Parcelable {
    public static final Parcelable.Creator<FeedbackData> CREATOR = new Parcelable.Creator<FeedbackData>() { // from class: com.opos.mobad.model.data.FeedbackData.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FeedbackData createFromParcel(Parcel parcel) {
            return new FeedbackData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FeedbackData[] newArray(int i) {
            return new FeedbackData[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<Integer> f9083a;
    private List<String> b;

    public FeedbackData() {
        this.f9083a = new ArrayList();
        this.b = new ArrayList();
    }

    public List<String> a() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "FeedbackData{types=" + this.f9083a + ", urls='" + this.b + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.f9083a);
        parcel.writeStringList(this.b);
    }

    public FeedbackData(Parcel parcel) {
        if (parcel != null) {
            ArrayList arrayList = new ArrayList();
            this.f9083a = arrayList;
            parcel.readList(arrayList, Integer.class.getClassLoader());
            this.b = parcel.createStringArrayList();
        }
    }

    public void a(int i, String str) {
        this.f9083a.add(Integer.valueOf(i));
        this.b.add(str);
    }
}
