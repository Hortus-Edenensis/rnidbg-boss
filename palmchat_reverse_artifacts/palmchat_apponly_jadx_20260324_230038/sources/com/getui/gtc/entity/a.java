package com.getui.gtc.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<C0343a> f5769a = new SparseArray<>();
    public boolean b = false;
    private String c;

    /* JADX INFO: renamed from: com.getui.gtc.entity.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0343a implements Parcelable {
        public static final Parcelable.Creator<C0343a> CREATOR = new Parcelable.Creator<C0343a>() { // from class: com.getui.gtc.entity.a.a.1
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ C0343a createFromParcel(Parcel parcel) {
                return new C0343a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ C0343a[] newArray(int i) {
                return new C0343a[i];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5770a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public long g;
        public String h;
        public boolean i;
        public boolean j;

        public C0343a() {
        }

        public C0343a(Parcel parcel) {
            this.f5770a = parcel.readInt();
            this.b = parcel.readString();
            this.c = parcel.readString();
            this.d = parcel.readString();
            this.e = parcel.readString();
            this.f = parcel.readString();
            this.g = parcel.readLong();
            this.h = parcel.readString();
            this.i = parcel.readByte() != 0;
            this.j = parcel.readByte() != 0;
        }

        public final String a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", this.f5770a);
                jSONObject.put("version", this.b);
                jSONObject.put("name", this.c);
                jSONObject.put("cls_name", this.d);
                jSONObject.put("url", this.h);
                jSONObject.put("isdestroy", this.i);
                jSONObject.put("effective", String.valueOf(this.g));
                jSONObject.put("key", this.f);
                jSONObject.put("checksum", this.e);
            } catch (Exception e) {
                com.getui.gtc.i.c.a.b(e);
            }
            return jSONObject.toString();
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f5770a);
            parcel.writeString(this.b);
            parcel.writeString(this.c);
            parcel.writeString(this.d);
            parcel.writeString(this.e);
            parcel.writeString(this.f);
            parcel.writeLong(this.g);
            parcel.writeString(this.h);
            parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.j ? (byte) 1 : (byte) 0);
        }
    }

    public final C0343a a(int i) {
        SparseArray<C0343a> sparseArray = this.f5769a;
        return sparseArray.get(sparseArray.keyAt(i));
    }

    public final C0343a b(int i) {
        return this.f5769a.get(i);
    }

    public final void c(int i) {
        this.f5769a.removeAt(i);
    }

    public static a a(Map<String, String> map) {
        long j;
        String str = map.get("ext_infos");
        a aVar = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            a aVar2 = new a();
            aVar2.c = jSONObject.getString("version");
            String str2 = map.get("sdk.gtc.gws.load.enable");
            if (!TextUtils.isEmpty(str2) && !"none".equals(str2)) {
                aVar2.b = Boolean.parseBoolean(str2);
            }
            JSONArray jSONArray = jSONObject.getJSONArray("extensions");
            if (jSONArray.length() > 0) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    C0343a c0343a = new C0343a();
                    c0343a.f5770a = jSONObject2.getInt("id");
                    c0343a.b = jSONObject2.getString("version");
                    c0343a.c = jSONObject2.getString("name");
                    c0343a.d = jSONObject2.getString("cls_name");
                    c0343a.h = jSONObject2.getString("url");
                    c0343a.e = jSONObject2.getString("checksum");
                    c0343a.f = jSONObject2.getString("key");
                    if (jSONObject2.has("isdestroy")) {
                        c0343a.i = jSONObject2.getBoolean("isdestroy");
                    }
                    if (jSONObject2.has("effective")) {
                        try {
                            j = Long.parseLong(jSONObject2.getString("effective")) * 1000;
                        } catch (Exception e) {
                            com.getui.gtc.i.c.a.c(e);
                            j = 0;
                        }
                        c0343a.g = j;
                    }
                    aVar2.f5769a.put(c0343a.f5770a, c0343a);
                }
            }
            aVar = aVar2;
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.c(th);
        }
        String str3 = map.get("sdk.push.plugins");
        if (aVar != null && !TextUtils.isEmpty(str3)) {
            for (String str4 : str3.split(",")) {
                try {
                    C0343a c0343aB = aVar.b(Integer.parseInt(str4));
                    if (c0343aB != null) {
                        c0343aB.j = true;
                    }
                } catch (Exception unused) {
                }
            }
        }
        return aVar;
    }

    public final String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", this.c);
            JSONArray jSONArray = new JSONArray();
            jSONObject.put("extensions", jSONArray);
            int size = this.f5769a.size();
            for (int i = 0; i < size; i++) {
                SparseArray<C0343a> sparseArray = this.f5769a;
                jSONArray.put(i, new JSONObject(sparseArray.get(sparseArray.keyAt(i)).a()));
            }
        } catch (Exception e) {
            com.getui.gtc.i.c.a.b(e);
        }
        return jSONObject.toString();
    }
}
