package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.opos.cmn.an.b.b;
import com.opos.mobad.b.a.b;
import com.opos.mobad.b.a.f;
import com.opos.mobad.b.a.i;
import com.opos.mobad.b.a.t;
import com.opos.mobad.b.a.y;
import com.opos.mobad.mediaplayer.b.d;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class AdItemData extends com.opos.mobad.model.data.a implements Parcelable {
    private boolean A;
    private boolean B;
    private int C;
    private ActivatingData D;
    private int E;
    private boolean F;
    private String G;
    private String H;
    private int I;
    private volatile boolean J;
    private volatile boolean K;
    private long L;
    private AppPrivacyData M;
    private CustomInfoData N;
    private int O;
    private String P;
    private int Q;
    private int R;
    private String S;
    private String T;
    private String U;
    private String V;
    private int W;
    private String X;
    private long Y;
    private InteractionSensorData Z;
    private FeedbackData aa;
    private MaterialFileData ab;
    private MaterialFileData ac;
    private boolean ad;
    private String ae;
    private boolean af;
    private int ag;
    private String ah;
    List<MaterialData> d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private boolean l;
    private int m;
    private MaterialFileData n;
    private int o;
    private String p;
    private long q;
    private boolean r;
    private int s;
    private int t;
    private int u;
    private int v;
    private long w;
    private boolean x;
    private int y;
    private String z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9075a = b.a("b3Bwb19hZHg=");
    public static final String b = b.a("b3Bwb19mZWVk");
    public static final String c = b.a("b3Bwb19jcGQ=");
    public static final Parcelable.Creator<AdItemData> CREATOR = new Parcelable.Creator<AdItemData>() { // from class: com.opos.mobad.model.data.AdItemData.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdItemData createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            AdItemData adItemData = new AdItemData();
            adItemData.a(parcel.readString());
            adItemData.b(parcel.readString());
            adItemData.c(parcel.readString());
            adItemData.d(parcel.readString());
            adItemData.e(parcel.readString());
            adItemData.f(parcel.readString());
            adItemData.g(parcel.readString());
            adItemData.a(parcel.createTypedArrayList(MaterialData.CREATOR));
            adItemData.a(parcel.readByte() != 0);
            adItemData.a(parcel.readInt());
            adItemData.a((MaterialFileData) parcel.readParcelable(MaterialFileData.class.getClassLoader()));
            adItemData.b(parcel.readInt());
            adItemData.h(parcel.readString());
            adItemData.a(parcel.readLong());
            adItemData.b(parcel.readByte() != 0);
            adItemData.c(parcel.readInt());
            adItemData.d(parcel.readInt());
            adItemData.e(parcel.readInt());
            adItemData.f(parcel.readInt());
            adItemData.b(parcel.readLong());
            adItemData.c(parcel.readByte() != 0);
            adItemData.g(parcel.readInt());
            adItemData.i(parcel.readString());
            adItemData.g(parcel.readByte() != 0);
            adItemData.i(parcel.readInt());
            adItemData.j(parcel.readInt());
            adItemData.a((ActivatingData) parcel.readParcelable(ActivatingData.class.getClassLoader()));
            adItemData.k(parcel.readString());
            adItemData.H = parcel.readString();
            adItemData.I = parcel.readInt();
            adItemData.h(parcel.readByte() != 0);
            adItemData.i(parcel.readByte() != 0);
            adItemData.L = parcel.readLong();
            adItemData.a((AppPrivacyData) parcel.readParcelable(AppPrivacyData.class.getClassLoader()));
            adItemData.N = (CustomInfoData) parcel.readParcelable(CustomInfoData.class.getClassLoader());
            adItemData.O = parcel.readInt();
            adItemData.P = parcel.readString();
            adItemData.Q = parcel.readInt();
            adItemData.S = parcel.readString();
            adItemData.R = parcel.readInt();
            adItemData.T = parcel.readString();
            adItemData.U = parcel.readString();
            adItemData.V = parcel.readString();
            adItemData.h(parcel.readInt());
            adItemData.X = parcel.readString();
            adItemData.Y = parcel.readLong();
            adItemData.Z = (InteractionSensorData) parcel.readParcelable(InteractionSensorData.class.getClassLoader());
            adItemData.aa = (FeedbackData) parcel.readParcelable(FeedbackData.class.getClassLoader());
            adItemData.b((MaterialFileData) parcel.readParcelable(MaterialFileData.class.getClassLoader()));
            adItemData.c((MaterialFileData) parcel.readParcelable(MaterialFileData.class.getClassLoader()));
            adItemData.e(parcel.readByte() != 0);
            adItemData.j(parcel.readString());
            if (parcel.readByte() != 0) {
                adItemData.N();
            }
            adItemData.f(parcel.readByte() != 0);
            adItemData.k(parcel.readInt());
            adItemData.m(parcel.readString());
            return adItemData;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AdItemData[] newArray(int i) {
            return new AdItemData[i];
        }
    };

    /* JADX INFO: renamed from: com.opos.mobad.model.data.AdItemData$2, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9076a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;
        static final /* synthetic */ int[] d;

        static {
            int[] iArr = new int[b.EnumC0718b.values().length];
            d = iArr;
            try {
                iArr[b.EnumC0718b.LINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                d[b.EnumC0718b.APP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                d[b.EnumC0718b.INSTANT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                d[b.EnumC0718b.BRAND_TOPIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                d[b.EnumC0718b.THIRD_PARTY_APP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                d[b.EnumC0718b.LINK_APP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                d[b.EnumC0718b.WECHAT_APPLET.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                d[b.EnumC0718b.LIVE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                d[b.EnumC0718b.WECHAT_NATIVE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr2 = new int[b.d.values().length];
            c = iArr2;
            try {
                iArr2[b.d.PLAY_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                c[b.d.PLAY_STREAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            int[] iArr3 = new int[b.g.values().length];
            b = iArr3;
            try {
                iArr3[b.g.TOP_RIGHT_CORNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                b[b.g.MIDDLE_RIGHT_CORNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                b[b.g.BOTTOM_RIGHT_CORNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
            int[] iArr4 = new int[b.c.values().length];
            f9076a = iArr4;
            try {
                iArr4[b.c.SENSOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f9076a[b.c.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f9076a[b.c.VERTICAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {
        private ActivatingData A;
        private int B;
        private boolean C;
        private String D;
        private String E;
        private int F;
        private boolean G;
        private boolean H;
        private long I;
        private AppPrivacyData J;
        private CustomInfoData K;
        private int L;
        private String M;
        private int N;
        private int O;
        private String P;
        private String Q;
        private String R;
        private String S;
        private int T;
        private String U;
        private long V;
        private InteractionSensorData W = AdItemData.b((y) null);
        private FeedbackData X;
        private MaterialFileData Y;
        private MaterialFileData Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f9077a;
        private boolean aa;
        private String ab;
        private boolean ac;
        private String ad;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private List<MaterialData> h;
        private boolean i;
        private int j;
        private MaterialFileData k;
        private int l;
        private String m;
        private long n;
        private boolean o;
        private int p;
        private int q;
        private int r;
        private int s;
        private long t;
        private boolean u;
        private int v;
        private String w;
        private boolean x;
        private boolean y;
        private int z;

        private a() {
        }

        public static a a() {
            return new a();
        }

        public a b(int i) {
            this.s = i;
            return this;
        }

        public a c(int i) {
            this.v = i;
            return this;
        }

        public a d(int i) {
            this.B = i;
            return this;
        }

        public a e(int i) {
            this.T = i;
            return this;
        }

        public a a(int i) {
            this.j = i;
            return this;
        }

        public a b(String str) {
            this.b = str;
            return this;
        }

        public a c(String str) {
            this.e = str;
            return this;
        }

        public a d(String str) {
            this.f = str;
            return this;
        }

        public a e(String str) {
            this.E = str;
            return this;
        }

        public a a(long j) {
            this.t = j;
            return this;
        }

        public a b(boolean z) {
            this.ac = z;
            return this;
        }

        public a a(String str) {
            this.f9077a = str;
            return this;
        }

        public AdItemData b() {
            AdItemData adItemData = new AdItemData();
            adItemData.a(this.f9077a);
            adItemData.c(this.c);
            adItemData.d(this.d);
            adItemData.e(this.e);
            adItemData.f(this.f);
            adItemData.g(this.g);
            adItemData.a(this.i);
            adItemData.a(this.j);
            adItemData.b(this.l);
            adItemData.h(this.m);
            adItemData.a(this.n);
            adItemData.b(this.o);
            adItemData.c(this.p);
            adItemData.d(this.q);
            adItemData.e(this.r);
            adItemData.f(this.s);
            adItemData.c(this.u);
            adItemData.g(this.v);
            adItemData.i(this.w);
            adItemData.d(this.x);
            adItemData.g(this.y);
            adItemData.i(this.z);
            adItemData.a(this.A);
            adItemData.j(this.B);
            adItemData.k(this.D);
            adItemData.h(this.G);
            adItemData.i(this.H);
            adItemData.l(this.S);
            adItemData.h(this.T);
            adItemData.b(this.Y);
            adItemData.c(this.Z);
            adItemData.j(this.ab);
            adItemData.a(this.h);
            adItemData.ad = this.aa;
            adItemData.Z = this.W;
            adItemData.Q = this.N;
            adItemData.M = this.J;
            adItemData.Y = this.V;
            adItemData.I = this.F;
            adItemData.R = this.O;
            adItemData.F = this.C;
            adItemData.L = this.I;
            adItemData.T = this.Q;
            adItemData.X = this.U;
            adItemData.aa = this.X;
            adItemData.H = this.E;
            adItemData.f = this.b;
            adItemData.a(this.k);
            adItemData.N = this.K;
            adItemData.O = this.L;
            adItemData.P = this.M;
            adItemData.S = this.P;
            adItemData.U = this.R;
            adItemData.w = this.t;
            adItemData.af = this.ac;
            adItemData.ah = this.ad;
            return adItemData;
        }

        public a a(List<MaterialData> list) {
            this.h = list;
            return this;
        }

        public a a(boolean z) {
            this.C = z;
            return this;
        }
    }

    private AdItemData() {
        this.z = "广告";
        this.A = false;
        this.B = false;
        this.F = false;
        this.J = false;
        this.K = false;
        this.ad = false;
        this.ae = "";
        this.af = false;
        this.ag = -1;
    }

    private static int a(b.EnumC0718b enumC0718b) {
        if (enumC0718b != null) {
            switch (AnonymousClass2.d[enumC0718b.ordinal()]) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                    return 6;
                case 7:
                    return 7;
                case 8:
                    return 8;
                case 9:
                    return 9;
            }
        }
        return 0;
    }

    public boolean A() {
        return (this.y & 8) == 8;
    }

    public boolean B() {
        return (this.y & 16) == 16;
    }

    public boolean C() {
        return (this.y & 32) == 32;
    }

    public boolean D() {
        return this.y == 0;
    }

    public String E() {
        return this.z;
    }

    public int F() {
        return this.W;
    }

    public boolean G() {
        return this.A;
    }

    public boolean H() {
        return this.af;
    }

    public String I() {
        return this.ae;
    }

    public boolean J() {
        return this.B;
    }

    public int K() {
        return this.C;
    }

    public int L() {
        return this.E;
    }

    public ActivatingData M() {
        return this.D;
    }

    public void N() {
        this.F = true;
    }

    public boolean O() {
        return this.F;
    }

    public String P() {
        return this.G;
    }

    public int Q() {
        return this.I;
    }

    public boolean R() {
        return this.J;
    }

    public boolean S() {
        return this.K;
    }

    public long T() {
        return this.L;
    }

    public AppPrivacyData U() {
        return this.M;
    }

    public String V() {
        FeedbackData feedbackData = this.aa;
        if (feedbackData == null || feedbackData.a() == null || this.aa.a().isEmpty()) {
            return null;
        }
        for (String str : this.aa.a()) {
            if (str != null && !str.isEmpty()) {
                return str;
            }
        }
        return null;
    }

    public int W() {
        CustomInfoData customInfoData = this.N;
        return customInfoData != null ? customInfoData.b() : d.c();
    }

    public int X() {
        CustomInfoData customInfoData = this.N;
        if (customInfoData != null) {
            return customInfoData.c();
        }
        return 0;
    }

    public int Y() {
        CustomInfoData customInfoData = this.N;
        if (customInfoData != null) {
            return customInfoData.d();
        }
        return 3000;
    }

    public int Z() {
        CustomInfoData customInfoData = this.N;
        if (customInfoData != null) {
            return customInfoData.e();
        }
        return 2000;
    }

    public int aa() {
        return this.O;
    }

    public String ab() {
        return this.P;
    }

    public int ac() {
        return this.Q;
    }

    public int ad() {
        return this.R;
    }

    public String ae() {
        return this.S;
    }

    public String af() {
        return this.T;
    }

    public String ag() {
        return this.U;
    }

    public String ah() {
        return this.V;
    }

    public String ai() {
        return this.X;
    }

    public long aj() {
        return this.Y;
    }

    public InteractionSensorData ak() {
        return this.Z;
    }

    public String al() {
        return this.ah;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.h;
    }

    public String f() {
        return this.i;
    }

    public String g() {
        return this.j;
    }

    public String h() {
        return this.k;
    }

    public void j(int i) {
        this.E = i;
    }

    public int k() {
        return this.m;
    }

    public MaterialFileData l() {
        return this.n;
    }

    public MaterialFileData m() {
        return this.ab;
    }

    public MaterialFileData n() {
        return this.ac;
    }

    public int o() {
        return this.o;
    }

    public String p() {
        return this.p;
    }

    public long q() {
        return this.q;
    }

    public int r() {
        return this.s;
    }

    public int s() {
        return this.t;
    }

    public int t() {
        return this.v;
    }

    public String toString() {
        return "AdItemData{adSource='" + this.e + ", respId='" + this.f + ", adId='" + this.i + ", posId='" + this.j + ", planId='" + this.k + ", materialDataList=" + this.d + ", showLogo=" + this.l + ", closeBnStyle=" + this.m + ", logoFile=" + this.n + ", refreshTime=" + this.o + ", ext='" + this.p + ", countdown=" + this.q + ", showSkipBn=" + this.r + ", showInterval=" + this.s + ", clickInterval=" + this.t + ", reqInterval=" + this.u + ", playMode=" + this.v + ", expTime=" + this.w + ", playRemindAtCellular=" + this.x + ", rewardScene=" + this.y + ", logoText='" + this.z + ", hasReward='" + this.A + ", isFallback=" + this.ad + ", errorReqId=" + this.ae + ", playVideoInSilence='" + this.B + ", splashSkipBtPosition='" + this.C + ", videoOrientation='" + this.E + ", activatingData='" + this.D + ", isDownloaderStartReport=" + this.J + ", isDownloaderCompleteReport=" + this.K + ", appPrivacyData=" + this.M + ", customInfo= " + this.N + ", posType= " + this.O + ", ageGrading= " + this.P + ", bidIds= " + this.T + ", clkScore= " + this.U + ", contentType= " + this.W + ", wechatExtInfo= " + this.X + ", dspId= " + this.Y + ", interactionSensorData= " + this.Z + ", feedbackData= " + this.aa + ", darkLogoFile=" + this.ab + ", surfaceLogoFile=" + this.ac + ", isRequestFallback=" + this.af + ", shortTraceId=" + this.ah + '}';
    }

    public long u() {
        return this.w;
    }

    public boolean v() {
        return this.x;
    }

    public int w() {
        return this.y;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeTypedList(this.d);
        parcel.writeByte(this.l ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.m);
        parcel.writeParcelable(this.n, i);
        parcel.writeInt(this.o);
        parcel.writeString(this.p);
        parcel.writeLong(this.q);
        parcel.writeByte(this.r ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.s);
        parcel.writeInt(this.t);
        parcel.writeInt(this.u);
        parcel.writeInt(this.v);
        parcel.writeLong(this.w);
        parcel.writeByte(this.x ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.y);
        parcel.writeString(this.z);
        parcel.writeByte(this.B ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.C);
        parcel.writeInt(this.E);
        parcel.writeParcelable(this.D, i);
        parcel.writeString(this.G);
        parcel.writeString(this.H);
        parcel.writeInt(this.I);
        parcel.writeByte(this.J ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.K ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.L);
        parcel.writeParcelable(this.M, i);
        parcel.writeParcelable(this.N, i);
        parcel.writeInt(this.O);
        parcel.writeString(this.P);
        parcel.writeInt(this.Q);
        parcel.writeString(this.S);
        parcel.writeInt(this.R);
        parcel.writeString(this.T);
        parcel.writeString(this.U);
        parcel.writeString(this.V);
        parcel.writeInt(this.W);
        parcel.writeString(this.X);
        parcel.writeLong(this.Y);
        parcel.writeParcelable(this.Z, i);
        parcel.writeParcelable(this.aa, i);
        parcel.writeParcelable(this.ab, i);
        parcel.writeParcelable(this.ac, i);
        parcel.writeByte(this.ad ? (byte) 1 : (byte) 0);
        parcel.writeString(this.ae);
        parcel.writeByte(this.F ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.af ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.ag);
        parcel.writeString(this.ah);
    }

    public boolean x() {
        return (this.y & 1) == 1;
    }

    public boolean y() {
        return (this.y & 2) == 2;
    }

    public boolean z() {
        return (this.y & 4) == 4;
    }

    public AdItemData(com.opos.mobad.b.a.b bVar, List<MaterialData> list, MaterialFileData materialFileData, InstantData instantData, long j, String str, String str2, CustomInfoData customInfoData, int i, String str3, String str4, String str5, String str6) {
        this.z = "广告";
        this.A = false;
        this.B = false;
        this.F = false;
        this.J = false;
        this.K = false;
        this.ad = false;
        this.ae = "";
        this.af = false;
        this.ag = -1;
        String str7 = bVar.C;
        this.i = str7 == null ? "" : str7;
        String str8 = bVar.D;
        this.j = str8 == null ? "" : str8;
        String str9 = bVar.E;
        this.k = str9 == null ? "" : str9;
        String str10 = bVar.K;
        this.p = str10 == null ? "" : str10;
        String str11 = bVar.W;
        this.e = str11 == null ? "" : str11;
        this.d = list;
        Integer num = bVar.H;
        this.m = (num == null ? com.opos.mobad.b.a.b.e : num).intValue();
        this.n = materialFileData;
        Boolean bool = bVar.G;
        this.l = (bool == null ? com.opos.mobad.b.a.b.d : bool).booleanValue();
        Integer num2 = bVar.J;
        this.o = (num2 == null ? com.opos.mobad.b.a.b.f : num2).intValue();
        Long l = bVar.L;
        this.q = (l == null ? com.opos.mobad.b.a.b.g : l).longValue();
        Boolean bool2 = bVar.M;
        this.r = (bool2 == null ? com.opos.mobad.b.a.b.h : bool2).booleanValue();
        Integer num3 = bVar.N;
        this.s = (num3 == null ? com.opos.mobad.b.a.b.i : num3).intValue();
        Integer num4 = bVar.O;
        this.t = (num4 == null ? com.opos.mobad.b.a.b.j : num4).intValue();
        Integer num5 = bVar.Q;
        this.u = (num5 == null ? com.opos.mobad.b.a.b.l : num5).intValue();
        b.d dVar = bVar.R;
        this.v = a(dVar == null ? com.opos.mobad.b.a.b.m : dVar);
        Boolean bool3 = bVar.S;
        this.x = (bool3 == null ? com.opos.mobad.b.a.b.n : bool3).booleanValue();
        Integer num6 = bVar.ae;
        this.y = (num6 == null ? com.opos.mobad.b.a.b.u : num6).intValue();
        String str12 = bVar.U;
        if (str12 != null) {
            this.z = str12;
        }
        Boolean bool4 = bVar.X;
        this.B = (bool4 == null ? com.opos.mobad.b.a.b.q : bool4).booleanValue();
        b.g gVar = bVar.Y;
        this.C = a(gVar == null ? com.opos.mobad.b.a.b.r : gVar);
        this.E = a(bVar.aa);
        if (instantData != null) {
            this.g = instantData.f9085a;
            this.h = instantData.b;
        }
        this.w = j;
        this.f = str == null ? "" : str;
        String str13 = bVar.ab;
        this.G = str13 == null ? "" : str13;
        this.H = str2;
        Integer num7 = bVar.ac;
        this.I = (num7 == null ? com.opos.mobad.b.a.b.t : num7).intValue();
        a(bVar.Z);
        this.L = SystemClock.elapsedRealtime();
        this.M = a(bVar);
        this.N = customInfoData;
        this.O = i;
        this.P = str3;
        Integer num8 = bVar.af;
        this.Q = (num8 == null ? com.opos.mobad.b.a.b.v : num8).intValue();
        Integer num9 = bVar.ag;
        this.R = (num9 == null ? com.opos.mobad.b.a.b.w : num9).intValue();
        this.S = str4;
        String str14 = bVar.ah;
        this.T = str14 == null ? "" : str14;
        this.U = str5;
        b.EnumC0718b enumC0718b = bVar.ai;
        this.W = a(enumC0718b == null ? com.opos.mobad.b.a.b.x : enumC0718b);
        String str15 = bVar.aj;
        this.X = str15 == null ? "" : str15;
        Long l2 = bVar.am;
        this.Y = (l2 == null ? com.opos.mobad.b.a.b.y : l2).longValue();
        this.Z = b(bVar.an);
        this.aa = b(bVar.ao);
        Integer num10 = bVar.as;
        this.ag = (num10 == null ? com.opos.mobad.b.a.b.B : num10).intValue();
        String str16 = bVar.ar;
        this.ah = str16 != null ? str16 : "";
    }

    private static int a(b.c cVar) {
        int i;
        if (cVar == null || (i = AnonymousClass2.f9076a[cVar.ordinal()]) == 1) {
            return 0;
        }
        if (i != 2) {
            return i != 3 ? 0 : 2;
        }
        return 1;
    }

    public List<MaterialData> i() {
        return this.d;
    }

    public void j(String str) {
        this.ae = str;
    }

    public void k(int i) {
        this.ag = i;
    }

    public void l(String str) {
        this.V = str;
    }

    public void m(String str) {
        this.ah = str;
    }

    private static int a(b.d dVar) {
        if (dVar != null) {
            int i = AnonymousClass2.c[dVar.ordinal()];
            if (i == 1) {
                return 1;
            }
            if (i == 2) {
                return 2;
            }
        }
        return 0;
    }

    public String c() {
        return this.f;
    }

    public String d() {
        return this.g;
    }

    public void e(int i) {
        this.u = i;
    }

    public void f(int i) {
        this.v = i;
    }

    public void g(int i) {
        this.y = i;
    }

    public void h(int i) {
        this.W = i;
    }

    public void i(int i) {
        this.C = i;
    }

    public boolean j() {
        return this.l;
    }

    public void k(String str) {
        this.G = str;
    }

    private static int a(b.g gVar) {
        int i;
        if (gVar == null || (i = AnonymousClass2.b[gVar.ordinal()]) == 1) {
            return 0;
        }
        if (i != 2) {
            return i != 3 ? 0 : 2;
        }
        return 1;
    }

    public FeedbackData b(List<t> list) {
        FeedbackData feedbackData = new FeedbackData();
        if (list == null || list.isEmpty()) {
            feedbackData.a(t.d.intValue(), "");
        } else {
            for (t tVar : list) {
                Integer num = tVar.e;
                if (num == null) {
                    num = t.d;
                }
                int iIntValue = num.intValue();
                String str = tVar.f;
                if (str == null) {
                    str = "";
                }
                feedbackData.a(iIntValue, str);
            }
        }
        return feedbackData;
    }

    public void e(String str) {
        this.i = str;
    }

    public void f(String str) {
        this.j = str;
    }

    public void g(String str) {
        this.k = str;
    }

    public void h(String str) {
        this.p = str;
    }

    public void i(String str) {
        if (com.opos.cmn.an.d.b.a(str)) {
            return;
        }
        this.z = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InteractionSensorData b(y yVar) {
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        Integer num5;
        Integer num6;
        Integer num7;
        Integer num8;
        Integer num9;
        Boolean bool;
        Integer num10;
        Integer num11;
        Integer num12;
        Integer num13;
        return new InteractionSensorData((yVar == null || (num13 = yVar.r) == null) ? com.opos.mobad.template.e.b.a.p : num13.intValue(), (yVar == null || (num12 = yVar.s) == null) ? com.opos.mobad.template.e.b.a.q : num12.intValue(), (yVar == null || (num11 = yVar.t) == null) ? com.opos.mobad.template.e.b.a.r : num11.intValue(), (yVar == null || (num10 = yVar.u) == null) ? com.opos.mobad.template.e.b.a.s : num10.intValue(), (yVar == null || (bool = yVar.v) == null) ? com.opos.mobad.template.e.b.a.t : bool.booleanValue(), (yVar == null || (num9 = yVar.w) == null) ? com.opos.mobad.template.e.b.a.u : num9.intValue(), (yVar == null || (num8 = yVar.x) == null) ? com.opos.mobad.template.e.b.a.v : num8.intValue(), (yVar == null || (num7 = yVar.y) == null) ? com.opos.mobad.template.e.b.a.w : num7.intValue(), (yVar == null || (num6 = yVar.z) == null) ? com.opos.mobad.template.e.b.a.x : num6.intValue(), (yVar == null || (num5 = yVar.A) == null) ? com.opos.mobad.template.e.b.a.y : num5.intValue(), (yVar == null || (num4 = yVar.B) == null) ? com.opos.mobad.template.e.b.a.z : num4.intValue(), (yVar == null || (num3 = yVar.C) == null) ? com.opos.mobad.template.e.b.a.A : num3.intValue(), (yVar == null || (num2 = yVar.D) == null) ? com.opos.mobad.template.e.b.a.B : num2.intValue(), (yVar == null || (num = yVar.E) == null) ? com.opos.mobad.template.e.b.a.C : num.intValue());
    }

    public void c(int i) {
        this.s = i;
    }

    public void d(int i) {
        this.t = i;
    }

    public void e(boolean z) {
        this.ad = z;
    }

    public void f(boolean z) {
        this.af = z;
    }

    public void g(boolean z) {
        this.B = z;
    }

    public void h(boolean z) {
        this.J = z;
    }

    public void i(boolean z) {
        this.K = z;
    }

    private AppPrivacyData a(com.opos.mobad.b.a.b bVar) {
        i iVar = bVar.ad;
        if (iVar == null || TextUtils.isEmpty(iVar.e) || TextUtils.isEmpty(iVar.d) || TextUtils.isEmpty(iVar.g) || TextUtils.isEmpty(iVar.f) || TextUtils.isEmpty(iVar.h)) {
            return null;
        }
        List<MaterialData> list = this.d;
        return new AppPrivacyData(iVar.d, iVar.e, iVar.g, iVar.f, (list == null || list.get(0) == null) ? "" : this.d.get(0).f(), iVar.h);
    }

    public String b() {
        return this.e;
    }

    public void c(MaterialFileData materialFileData) {
        this.ac = materialFileData;
    }

    public void d(String str) {
        this.h = str;
    }

    public void c(String str) {
        this.g = str;
    }

    public void d(boolean z) {
        this.A = z;
    }

    public void b(int i) {
        this.o = i;
    }

    public void c(boolean z) {
        this.x = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j) {
        this.w = j;
    }

    public void b(MaterialFileData materialFileData) {
        this.ab = materialFileData;
    }

    public String a() {
        return this.H;
    }

    public void b(String str) {
        this.f = str;
    }

    public void b(boolean z) {
        this.r = z;
    }

    public void a(int i) {
        this.m = i;
    }

    public void a(long j) {
        this.q = j;
    }

    private void a(com.opos.mobad.b.a.a aVar) {
        ArrayList arrayList;
        if (aVar == null) {
            return;
        }
        if (aVar.g == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (f fVar : aVar.g) {
                arrayList.add(new ApkSignerData(fVar.d, fVar.e, fVar.f));
            }
        }
        this.D = new ActivatingData(aVar.e, aVar.f, arrayList, aVar.h.intValue());
    }

    public void a(ActivatingData activatingData) {
        this.D = activatingData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppPrivacyData appPrivacyData) {
        this.M = appPrivacyData;
    }

    public void a(MaterialFileData materialFileData) {
        this.n = materialFileData;
    }

    public void a(String str) {
        this.e = str;
    }

    public void a(List<MaterialData> list) {
        this.d = list;
    }

    public void a(boolean z) {
        this.l = z;
    }
}
