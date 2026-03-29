package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.opos.mobad.b.a.ac;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class InteractiveData implements Parcelable {
    public static final Parcelable.Creator<InteractiveData> CREATOR = new Parcelable.Creator<InteractiveData>() { // from class: com.opos.mobad.model.data.InteractiveData.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public InteractiveData createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            try {
                int i = parcel.readInt();
                if (i <= 0) {
                    return null;
                }
                byte[] bArr = new byte[i];
                parcel.readByteArray(bArr);
                return InteractiveData.a(ac.j.c.a(bArr));
            } catch (Exception unused) {
                com.opos.cmn.an.f.a.b("mob_model", "interactive data fail");
                return null;
            }
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public InteractiveData[] newArray(int i) {
            return new InteractiveData[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9087a;
    public int b;
    public int c;
    public String d;
    public List<String> e;
    public String f;
    public String g;
    public int h = 0;
    private ac.j i;

    private InteractiveData(int i, int i2, int i3, String str, List<String> list, ac.j jVar) {
        this.c = i;
        this.f9087a = i2;
        this.b = i3;
        this.d = str;
        this.e = list;
        this.i = jVar;
    }

    public static final InteractiveData a(ac.j jVar) {
        Map<String, String> map;
        if (jVar == null || (map = jVar.g) == null || map.isEmpty()) {
            return null;
        }
        Integer num = jVar.f;
        Integer num2 = jVar.h;
        if (num == null || !(num2 == null || num2.intValue() == 0)) {
            if (num2.intValue() == 1) {
                return new InteractiveData(jVar.g.get("easyPlayableExtension"), jVar.g.get("easyPlayableUrl"), jVar);
            }
            return null;
        }
        String str = jVar.g.get("delay_show_time");
        String str2 = jVar.g.get("auto_close_time");
        String str3 = jVar.g.get("reward_cdk");
        List<String> listA = a(jVar.g.get("rsList"));
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            return new InteractiveData(jVar.f.intValue(), Math.max(0, Integer.valueOf(str).intValue() * 1000), Math.max(0, Integer.valueOf(str2).intValue() * 1000), str3, listA, jVar);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("mob_model", "parse fail", e);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        try {
            byte[] bArrB = ac.j.c.b(this.i);
            parcel.writeInt(bArrB.length);
            parcel.writeByteArray(bArrB);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("mob_model", "interactive parcel fail", e);
        }
    }

    private InteractiveData(String str, String str2, ac.j jVar) {
        this.f = str;
        this.g = str2;
        this.i = jVar;
    }

    private static final List<String> a(String str) {
        String[] strArrSplit;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str) && (strArrSplit = str.split(",")) != null && strArrSplit.length > 0) {
            for (String str2 : strArrSplit) {
                if (!TextUtils.isEmpty(str2)) {
                    arrayList.add(str2);
                }
            }
        }
        return arrayList;
    }

    public Map<String, String> a() {
        return this.i.g;
    }
}
