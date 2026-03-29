package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.mobad.b.a.u;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class FloatLayerData extends a implements Parcelable {
    public static final Parcelable.Creator<FloatLayerData> CREATOR = new Parcelable.Creator<FloatLayerData>() { // from class: com.opos.mobad.model.data.FloatLayerData.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FloatLayerData createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            FloatLayerData floatLayerData = new FloatLayerData();
            floatLayerData.a((MaterialFileData) parcel.readParcelable(FloatLayerData.class.getClassLoader()));
            floatLayerData.a(parcel.readString());
            floatLayerData.b(parcel.readString());
            Parcelable.Creator<MaterialFileData> creator = MaterialFileData.CREATOR;
            floatLayerData.a(parcel.createTypedArrayList(creator));
            floatLayerData.e = parcel.createTypedArrayList(creator);
            return floatLayerData;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FloatLayerData[] newArray(int i) {
            return new FloatLayerData[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MaterialFileData f9084a;
    private String b;
    private String c;
    private List<MaterialFileData> d;
    private List<MaterialFileData> e;

    private FloatLayerData() {
    }

    public FloatLayerData(u uVar, MaterialFileData materialFileData, List<MaterialFileData> list, List<MaterialFileData> list2) {
        this.f9084a = materialFileData;
        this.d = list;
        this.e = list2;
        String str = uVar.e;
        this.b = str == null ? "" : str;
        String str2 = uVar.f;
        this.c = str2 != null ? str2 : "";
    }

    public MaterialFileData a() {
        return this.f9084a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public List<MaterialFileData> d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<MaterialFileData> e() {
        return this.e;
    }

    public String toString() {
        return "FloatLayerData{iconFile='" + this.f9084a + "'title='" + this.b + "'desc='" + this.c + "'imgFileList='" + this.d + "'interactiveFileList='" + this.e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f9084a, i);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeTypedList(this.d);
        parcel.writeTypedList(this.e);
    }

    public void b(String str) {
        this.c = str;
    }

    public void a(MaterialFileData materialFileData) {
        this.f9084a = materialFileData;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(List<MaterialFileData> list) {
        this.d = list;
    }
}
