package com.opos.cmn.biz.monitor;

import android.os.Parcel;
import android.os.Parcelable;
import com.zenmen.palmchat.chat.aigreeting.vo.SkuConfig;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class MonitorEvent implements Parcelable {
    public static final Parcelable.Creator<MonitorEvent> CREATOR = new Parcelable.Creator<MonitorEvent>() { // from class: com.opos.cmn.biz.monitor.MonitorEvent.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MonitorEvent createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            parcel.readList(arrayList, AnonymousClass1.class.getClassLoader());
            return new MonitorEvent(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), arrayList);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MonitorEvent[] newArray(int i) {
            return new MonitorEvent[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7823a;
    private int b;
    private int c;
    private int d;
    private int e;
    private String f;
    private String g;
    private int h;
    private String i;
    private String j;
    private List<String> k;

    /* JADX INFO: compiled from: SearchBox */
    public enum a {
        BTN("1"),
        EXTRA("2");

        private String c;

        a(String str) {
            this.c = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String a() {
            return this.c;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {
        private a i;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f7825a = -1;
        private int b = SkuConfig.INFINITE_COUNT;
        private int c = SkuConfig.INFINITE_COUNT;
        private int d = SkuConfig.INFINITE_COUNT;
        private int e = SkuConfig.INFINITE_COUNT;
        private c f = c.OTHER;
        private d g = d.OTHER;
        private int h = 1;
        private String j = "";
        private List<String> k = new ArrayList();

        public b a(int i) {
            if (i >= 0) {
                this.f7825a = i;
            }
            return this;
        }

        public b a(int i, int i2, int i3, int i4) {
            if (i >= 0 && i2 >= 0 && i3 >= 0 && i4 >= 0) {
                this.b = i;
                this.c = i2;
                this.d = i3;
                this.e = i4;
            }
            return this;
        }

        public b a(a aVar) {
            this.i = aVar;
            return this;
        }

        public b a(c cVar) {
            if (cVar == null) {
                return this;
            }
            this.f = cVar;
            return this;
        }

        public b a(d dVar) {
            if (dVar == null) {
                return this;
            }
            this.g = dVar;
            return this;
        }

        public b a(String str) {
            this.j = str;
            return this;
        }

        public MonitorEvent a() {
            a aVar = this.i;
            return new MonitorEvent(this.f7825a, this.b, this.c, this.d, this.e, this.f.a(), this.g.a(), this.h, aVar != null ? aVar.a() : "", this.j, this.k);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum c {
        IMAGE("1"),
        CLICK_BUTTON("2"),
        TEXT("3"),
        OPEN_BUTTON("4"),
        OTHER("0");

        private String f;

        c(String str) {
            this.f = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String a() {
            return this.f;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum d {
        WEB_URL("1"),
        DEEP_LINK("2"),
        APP_HOME("3"),
        QA("4"),
        APP_SHOP("5"),
        DOWNLOADER("6"),
        OTHER("0"),
        MINI_PROGRAM("7");

        private String i;

        d(String str) {
            this.i = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String a() {
            return this.i;
        }
    }

    private MonitorEvent(int i, int i2, int i3, int i4, int i5, String str, String str2, int i6, String str3, String str4, List<String> list) {
        this.f7823a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = str;
        this.g = str2;
        this.h = i6;
        this.i = str3;
        this.j = str4;
        this.k = list;
    }

    public int a() {
        return this.f7823a;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.e;
    }

    public String f() {
        return this.f;
    }

    public String g() {
        return this.g;
    }

    public int h() {
        return this.h;
    }

    public String i() {
        return this.i;
    }

    public String j() {
        return this.j;
    }

    public String k() {
        StringBuilder sb = new StringBuilder();
        if (this.k != null) {
            for (int i = 0; i < this.k.size(); i++) {
                sb.append(this.k.get(i).trim());
                if (i < this.k.size() - 1) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.k);
        parcel.writeInt(this.f7823a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeInt(this.h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
    }
}
