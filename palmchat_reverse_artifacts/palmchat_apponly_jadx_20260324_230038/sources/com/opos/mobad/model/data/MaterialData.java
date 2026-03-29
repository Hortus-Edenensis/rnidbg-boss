package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.mobad.b.a.ac;
import com.opos.mobad.b.a.ak;
import com.opos.mobad.b.a.g;
import com.opos.mobad.b.a.r;
import com.opos.mobad.b.a.v;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class MaterialData extends a implements Parcelable, Comparable {
    public static final Parcelable.Creator<MaterialData> CREATOR = new Parcelable.Creator<MaterialData>() { // from class: com.opos.mobad.model.data.MaterialData.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MaterialData createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            MaterialData materialData = new MaterialData();
            materialData.a(parcel.readString());
            materialData.b(parcel.readInt());
            Parcelable.Creator<MaterialFileData> creator = MaterialFileData.CREATOR;
            materialData.a(parcel.createTypedArrayList(creator));
            materialData.b(parcel.readString());
            materialData.c(parcel.readString());
            materialData.b(parcel.createTypedArrayList(creator));
            materialData.a(parcel.readByte() != 0);
            materialData.d(parcel.readString());
            materialData.a(parcel.readLong());
            materialData.e(parcel.readString());
            materialData.c(parcel.createStringArrayList());
            materialData.d(parcel.createStringArrayList());
            materialData.e(parcel.createStringArrayList());
            materialData.f(parcel.readString());
            materialData.g(parcel.readString());
            materialData.c(parcel.readInt());
            materialData.b(parcel.readByte() != 0);
            materialData.h(parcel.readString());
            materialData.i(parcel.readString());
            materialData.b(parcel.readLong());
            materialData.d(parcel.readInt());
            materialData.j(parcel.readString());
            materialData.f(parcel.createStringArrayList());
            materialData.g(parcel.createStringArrayList());
            materialData.h(parcel.createStringArrayList());
            materialData.i(parcel.createStringArrayList());
            materialData.j(parcel.createStringArrayList());
            materialData.k(parcel.createStringArrayList());
            materialData.l(parcel.createStringArrayList());
            materialData.e(parcel.readInt());
            materialData.f(parcel.readInt());
            materialData.c(parcel.readByte() != 0);
            materialData.m(parcel.createTypedArrayList(creator));
            materialData.g(parcel.readInt());
            materialData.h(parcel.readInt());
            materialData.i(parcel.readInt());
            materialData.j(parcel.readInt());
            materialData.k(parcel.readInt());
            materialData.d(parcel.readByte() != 0);
            materialData.l(parcel.readInt());
            materialData.k(parcel.readString());
            materialData.e(parcel.readByte() != 0);
            materialData.f(parcel.readByte() != 0);
            materialData.m(parcel.readInt());
            materialData.a((AppDownloadData) parcel.readParcelable(AppDownloadData.class.getClassLoader()));
            materialData.n(parcel.createStringArrayList());
            materialData.o(parcel.createStringArrayList());
            materialData.p(parcel.createStringArrayList());
            materialData.l(parcel.readString());
            materialData.m(parcel.readString());
            materialData.n(parcel.readInt());
            materialData.a((FloatLayerData) parcel.readParcelable(FloatLayerData.class.getClassLoader()));
            materialData.o(parcel.readInt());
            materialData.p(parcel.readInt());
            materialData.g(parcel.readByte() != 0);
            materialData.n(parcel.readString());
            materialData.h(parcel.readByte() != 0);
            materialData.r(parcel.readInt());
            materialData.q(parcel.readInt());
            materialData.i(parcel.readByte() != 0);
            materialData.j(parcel.readByte() != 0);
            materialData.s(parcel.readInt());
            materialData.k(parcel.readByte() != 0);
            materialData.o(parcel.readString());
            materialData.ap = parcel.readByte() == 1;
            materialData.aq = parcel.readInt();
            materialData.p = parcel.createTypedArrayList(creator);
            materialData.ar = parcel.readLong();
            materialData.as = parcel.readInt();
            materialData.at = parcel.readInt();
            materialData.au = parcel.readString();
            materialData.av = parcel.readString();
            materialData.aw = (InteractiveData) parcel.readParcelable(InteractiveData.class.getClassLoader());
            materialData.ax = parcel.readInt();
            materialData.ay = parcel.readString();
            materialData.az = parcel.readInt();
            materialData.aA = parcel.readString();
            materialData.aB = parcel.createTypedArrayList(AdxAdExtInfoData.CREATOR);
            materialData.aC = parcel.readString();
            materialData.aD = parcel.readLong();
            return materialData;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MaterialData[] newArray(int i) {
            return new MaterialData[i];
        }
    };
    private boolean A;
    private String B;
    private String C;
    private long D;
    private int E;
    private String F;
    private List<String> G;
    private List<String> H;
    private List<String> I;
    private List<String> J;
    private List<String> K;
    private List<String> L;
    private List<String> M;
    private int N;
    private int O;
    private boolean P;
    private List<MaterialFileData> Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int V;
    private boolean W;
    private int X;
    private String Y;
    private boolean Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9088a;
    private String aA;
    private List<AdxAdExtInfoData> aB;
    private String aC;
    private long aD;
    private int aa;
    private boolean ab;
    private AppDownloadData ac;
    private List<String> ad;
    private List<String> ae;
    private List<String> af;
    private String ag;
    private String ah;
    private int ai;
    private FloatLayerData aj;
    private int ak;
    private int al;
    private boolean am;
    private boolean an;
    private String ao;
    private boolean ap;
    private int aq;
    private long ar;
    private int as;
    private int at;
    private String au;
    private String av;
    private InteractiveData aw;
    private int ax;
    private String ay;
    private int az;
    public boolean b;
    public int c;
    public int d;
    public boolean e;
    public boolean f;
    public int g;
    public List<String> h;
    public String i;
    private String j;
    private int k;
    private List<MaterialFileData> l;
    private String m;
    private String n;
    private List<MaterialFileData> o;
    private List<MaterialFileData> p;
    private boolean q;
    private String r;
    private long s;
    private String t;
    private List<String> u;
    private List<String> v;
    private List<String> w;
    private String x;
    private String y;
    private int z;

    /* JADX INFO: renamed from: com.opos.mobad.model.data.MaterialData$2, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9089a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;
        static final /* synthetic */ int[] d;
        static final /* synthetic */ int[] e;
        static final /* synthetic */ int[] f;
        static final /* synthetic */ int[] g;
        static final /* synthetic */ int[] h;
        static final /* synthetic */ int[] i;
        static final /* synthetic */ int[] j;
        static final /* synthetic */ int[] k;

        static {
            int[] iArr = new int[v.values().length];
            k = iArr;
            try {
                iArr[v.TYPE_16_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                k[v.TYPE_16_9.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[ac.h.values().length];
            j = iArr2;
            try {
                iArr2[ac.h.OPEN_HOME.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                j[ac.h.OPEN_DETAIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr3 = new int[ac.i.values().length];
            i = iArr3;
            try {
                iArr3[ac.i.SURFING.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                i[ac.i.DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                i[ac.i.MIDDLE_PAGE_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                i[ac.i.OPEN_HOME_PAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                i[ac.i.OPEN_DETAIL_PAGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                i[ac.i.OPEN_INSTANT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                i[ac.i.OPEN_MINI_PROGRAM.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                i[ac.i.OPEN_WECHAT_NATIVE_PAGE.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            int[] iArr4 = new int[ac.g.values().length];
            h = iArr4;
            try {
                iArr4[ac.g.SHOW_REMINDER_TOAST.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                h[ac.g.AUTO_OPEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            int[] iArr5 = new int[ac.n.values().length];
            g = iArr5;
            try {
                iArr5[ac.n.WEBVIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                g[ac.n.SYSTEM_BROWSER.ordinal()] = 2;
            } catch (NoSuchFieldError unused16) {
            }
            int[] iArr6 = new int[ac.o.values().length];
            f = iArr6;
            try {
                iArr6[ac.o.IMAGE_TIP_BAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f[ac.o.GRAPHIC_MIX_TIP_BAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr7 = new int[ac.d.values().length];
            e = iArr7;
            try {
                iArr7[ac.d.SDK_APP.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                e[ac.d.DEEPLINK_APP.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                e[ac.d.DOWNLOADER.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                e[ac.d.SAFE_DEEPLINK_APP.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            int[] iArr8 = new int[ac.p.values().length];
            d = iArr8;
            try {
                iArr8[ac.p.JUMP_LANDING_PAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                d[ac.p.JUMP_FLOATING_LAYER.ordinal()] = 2;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                d[ac.p.NO_JUMP_ACTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused25) {
            }
            int[] iArr9 = new int[ac.e.values().length];
            c = iArr9;
            try {
                iArr9[ac.e.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                c[ac.e.MODEL_A.ordinal()] = 2;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                c[ac.e.MODEL_INTERACTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused28) {
            }
            int[] iArr10 = new int[ak.c.values().length];
            b = iArr10;
            try {
                iArr10[ak.c.VIDEO_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                b[ak.c.VIDEO_PROCESS_25_PERCENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                b[ak.c.VIDEO_PROCESS_50_PERCENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                b[ak.c.VIDEO_PROCESS_75_PERCENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                b[ak.c.VIDEO_COMPLETE.ordinal()] = 5;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                b[ak.c.VIDEO_CLICK.ordinal()] = 6;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                b[ak.c.VIDEO_CLOSE.ordinal()] = 7;
            } catch (NoSuchFieldError unused35) {
            }
            int[] iArr11 = new int[r.b.values().length];
            f9089a = iArr11;
            try {
                iArr11[r.b.DOWNLOAD_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                f9089a[r.b.DOWNLOAD_COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                f9089a[r.b.INSTALL_COMPLETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused38) {
            }
        }
    }

    public MaterialData() {
        this.A = true;
        this.O = 0;
    }

    private static int a(ac.d dVar) {
        int i;
        if (dVar == null || (i = AnonymousClass2.e[dVar.ordinal()]) == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i != 3) {
            return i != 4 ? 0 : 3;
        }
        return 2;
    }

    public int A() {
        return this.N;
    }

    public int B() {
        return this.O;
    }

    public boolean C() {
        return this.P;
    }

    public List<MaterialFileData> D() {
        return this.Q;
    }

    public int E() {
        return this.S;
    }

    public int F() {
        return this.T;
    }

    public int G() {
        return this.U;
    }

    public int H() {
        return this.V;
    }

    public int I() {
        return this.X;
    }

    public String J() {
        return this.Y;
    }

    public AppDownloadData K() {
        return this.ac;
    }

    public List<String> L() {
        return this.ad;
    }

    public List<String> M() {
        return this.ae;
    }

    public List<String> N() {
        return this.af;
    }

    public String O() {
        return this.ag;
    }

    public String P() {
        return this.ah;
    }

    public int Q() {
        return this.ai;
    }

    public FloatLayerData R() {
        return this.aj;
    }

    public int S() {
        return this.ak;
    }

    public int T() {
        return this.al;
    }

    public boolean U() {
        return this.am;
    }

    public String V() {
        return this.f9088a;
    }

    public boolean W() {
        return this.an;
    }

    public String X() {
        return this.ao;
    }

    public long Y() {
        return this.ar;
    }

    public int Z() {
        return this.as;
    }

    public int aa() {
        return this.at;
    }

    public String ab() {
        return this.au;
    }

    public String ac() {
        return this.av;
    }

    public InteractiveData ad() {
        return this.aw;
    }

    public String ae() {
        return this.ay;
    }

    public int af() {
        return this.az;
    }

    public String ag() {
        return this.aA;
    }

    public List<AdxAdExtInfoData> ah() {
        return this.aB;
    }

    public String ai() {
        return this.aC;
    }

    public long aj() {
        return this.aD;
    }

    public int b() {
        return this.aq;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj instanceof AdItemData) {
            return this.z <= ((MaterialData) obj).z ? -1 : 1;
        }
        return 0;
    }

    public int d() {
        return this.k;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String f() {
        return this.m;
    }

    public String g() {
        return this.n;
    }

    public List<MaterialFileData> h() {
        return this.o;
    }

    public String i() {
        return this.r;
    }

    public long j() {
        return this.s;
    }

    public String k() {
        return this.t;
    }

    public List<String> l() {
        return this.u;
    }

    public List<String> m() {
        return this.v;
    }

    public List<String> n() {
        return this.w;
    }

    public String o() {
        return this.x;
    }

    public String p() {
        return this.y;
    }

    public String q() {
        return this.B;
    }

    public String r() {
        return this.C;
    }

    public long s() {
        return this.D;
    }

    public int t() {
        return this.E;
    }

    public String toString() {
        return "MaterialData{materialId='" + this.j + "', interactionType=" + this.k + ", imgFileList=" + this.l + ", interactiveFileList=" + this.p + ", title='" + this.m + "', desc='" + this.n + "', iconFileList=" + this.o + ", gbClick=" + this.q + ", downloadPkgName='" + this.r + "', apkSize=" + this.s + ", targetUrl='" + this.t + "', expStartUrls=" + this.u + ", expEndUrls=" + this.v + ", clickUrls=" + this.w + ", traceId='" + this.x + "', transparent='" + this.y + "', currentIndex=" + this.z + ", forceJsInit=" + this.A + ", extraUrl='" + this.B + "', dlChannel='" + this.C + "', videoDuration=" + this.D + ", showOffBnTime=" + this.E + ", landingPageUrl='" + this.F + "', videoStartUrls=" + this.G + ", video25PercentUrls=" + this.H + ", video50PercentUrls=" + this.I + ", video75PercentUrls=" + this.J + ", videoCompleteUrls=" + this.K + ", videoClickUrls=" + this.L + ", videoCloseUrls=" + this.M + ", installCompleteAction=" + this.N + ", surfingType=" + this.O + ", isGbClickToast=" + this.P + ", videoFileList=" + this.Q + ", tipBarType=" + this.R + ", rewardLimitTime=" + this.S + ", installedAction=" + this.T + ", extraActionType=" + this.U + ", videoActionType=" + this.V + ", isRemoveRepeatAd=" + this.W + ", downloadStyle=" + this.X + ", downloadUrl=" + this.Y + ", maxDownloaderNums='" + this.aa + "', showDownloadNotification='" + this.ab + "', wifiRemindAtCellular='" + this.Z + "', trackContent=" + this.ag + ", trackReference=" + this.ah + ", appDownloadData=" + this.ac + "', downloadStartUrls=" + this.ad + "', downloadCompleteUrls=" + this.ae + "', downloadInstalledUrls=" + this.af + "', videoCompleteAction=" + this.ai + "', floatLayerData=" + this.aj + "', floatLayerBtAction=" + this.ak + "', floatLayerExtraAction=" + this.al + "', isMobileAutoPlay=" + this.am + "', buttonTitle=" + this.f9088a + "', isShowMediaInfo=" + this.b + "', isShowConvertBar=" + this.e + "', isDynamicPopUpConvert=" + this.f + "', portEndPageModelType=" + this.d + "', landEndPageModelType=" + this.c + "', imgType=" + this.g + "', isShowFeedBack=" + this.an + "', isVertical=" + this.ap + "', templateId=" + this.aq + "', apkDownloadTimes=" + this.ar + "', specificationId=" + this.as + "', creativeType=" + this.ax + "', grade=" + this.ay + "', interactiveMode=" + this.az + "', dpToken=" + this.aA + "', adxAdExtInfo=" + this.aB + "', playableGameId=" + this.aC + "', playableGameVersion=" + this.aD + "'}";
    }

    public String u() {
        return this.F;
    }

    public List<String> v() {
        return this.G;
    }

    public List<String> w() {
        return this.H;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.j);
        parcel.writeInt(this.k);
        parcel.writeTypedList(this.l);
        parcel.writeString(this.m);
        parcel.writeString(this.n);
        parcel.writeTypedList(this.o);
        parcel.writeByte(this.q ? (byte) 1 : (byte) 0);
        parcel.writeString(this.r);
        parcel.writeLong(this.s);
        parcel.writeString(this.t);
        parcel.writeStringList(this.u);
        parcel.writeStringList(this.v);
        parcel.writeStringList(this.w);
        parcel.writeString(this.x);
        parcel.writeString(this.y);
        parcel.writeInt(this.z);
        parcel.writeByte(this.A ? (byte) 1 : (byte) 0);
        parcel.writeString(this.B);
        parcel.writeString(this.C);
        parcel.writeLong(this.D);
        parcel.writeInt(this.E);
        parcel.writeString(this.F);
        parcel.writeStringList(this.G);
        parcel.writeStringList(this.H);
        parcel.writeStringList(this.I);
        parcel.writeStringList(this.J);
        parcel.writeStringList(this.K);
        parcel.writeStringList(this.L);
        parcel.writeStringList(this.M);
        parcel.writeInt(this.N);
        parcel.writeInt(this.O);
        parcel.writeByte(this.P ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.Q);
        parcel.writeInt(this.R);
        parcel.writeInt(this.S);
        parcel.writeInt(this.T);
        parcel.writeInt(this.U);
        parcel.writeInt(this.V);
        parcel.writeByte(this.W ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.X);
        parcel.writeString(this.Y);
        parcel.writeByte(this.Z ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.ab ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.aa);
        parcel.writeParcelable(this.ac, i);
        parcel.writeStringList(this.ad);
        parcel.writeStringList(this.ae);
        parcel.writeStringList(this.af);
        parcel.writeString(this.ag);
        parcel.writeString(this.ah);
        parcel.writeInt(this.ai);
        parcel.writeParcelable(this.aj, i);
        parcel.writeInt(this.ak);
        parcel.writeInt(this.al);
        parcel.writeByte(this.am ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f9088a);
        parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.d);
        parcel.writeInt(this.c);
        parcel.writeByte(this.e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.g);
        parcel.writeByte(this.an ? (byte) 1 : (byte) 0);
        parcel.writeString(this.ao);
        parcel.writeByte(this.ap ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.aq);
        parcel.writeTypedList(this.p);
        parcel.writeLong(this.ar);
        parcel.writeInt(this.as);
        parcel.writeInt(this.at);
        parcel.writeString(this.au);
        parcel.writeString(this.av);
        parcel.writeParcelable(this.aw, i);
        parcel.writeInt(this.ax);
        parcel.writeString(this.ay);
        parcel.writeInt(this.az);
        parcel.writeString(this.aA);
        parcel.writeTypedList(this.aB);
        parcel.writeString(this.aC);
        parcel.writeLong(this.aD);
    }

    public List<String> x() {
        return this.I;
    }

    public List<String> y() {
        return this.J;
    }

    public List<String> z() {
        return this.K;
    }

    public MaterialData(ac acVar, List<MaterialFileData> list, List<MaterialFileData> list2, List<MaterialFileData> list3, List<MaterialFileData> list4, FloatLayerData floatLayerData) {
        List<String> list5;
        List<String> list6;
        this.A = true;
        this.O = 0;
        String str = acVar.R;
        this.j = str == null ? "" : str;
        this.k = a(acVar.T);
        this.U = a(acVar.aw);
        this.V = a(acVar.ax);
        this.T = a(acVar.av);
        String str2 = acVar.V;
        this.m = str2 == null ? "" : str2;
        String str3 = acVar.W;
        this.n = str3 == null ? "" : str3;
        this.l = list;
        this.o = list2;
        this.Q = list3;
        this.p = list4;
        Boolean bool = acVar.Y;
        this.q = (bool == null ? ac.f : bool).booleanValue();
        String str4 = acVar.Z;
        this.r = str4 == null ? "" : str4;
        Long l = acVar.aa;
        this.s = (l == null ? ac.g : l).longValue();
        String str5 = acVar.ab;
        this.t = str5 == null ? "" : str5;
        List<String> list7 = acVar.ac;
        if (list7 != null && list7.size() > 0) {
            this.u = list7;
        }
        List<String> list8 = acVar.ad;
        if (list8 != null && list8.size() > 0) {
            this.v = list8;
        }
        List<String> list9 = acVar.ae;
        if (list9 != null && list9.size() > 0) {
            this.w = list9;
        }
        String str6 = acVar.af;
        this.x = str6 == null ? "" : str6;
        String str7 = acVar.ag;
        this.y = str7 == null ? "" : str7;
        Integer num = acVar.ah;
        this.z = (num == null ? ac.h : num).intValue();
        Boolean bool2 = acVar.ai;
        this.A = (bool2 == null ? ac.i : bool2).booleanValue();
        String str8 = acVar.aj;
        this.B = str8 == null ? "" : str8;
        String str9 = acVar.ak;
        this.C = str9 == null ? "" : str9;
        Long l2 = acVar.al;
        this.D = (l2 == null ? ac.j : l2).longValue();
        Integer num2 = acVar.am;
        this.E = (num2 == null ? ac.k : num2).intValue();
        String str10 = acVar.an;
        this.F = str10 == null ? "" : str10;
        r(acVar.ao);
        this.N = a(acVar.ap);
        this.O = a(acVar.aq);
        Boolean bool3 = acVar.ar;
        this.P = (bool3 == null ? ac.n : bool3).booleanValue();
        this.R = a(acVar.at);
        Integer num3 = acVar.au;
        this.S = (num3 == null ? ac.p : num3).intValue();
        Boolean bool4 = acVar.ay;
        this.W = (bool4 == null ? ac.t : bool4).booleanValue();
        this.X = a(acVar.az);
        String str11 = acVar.aA;
        this.Y = str11 == null ? "" : str11;
        String str12 = acVar.aH;
        this.ag = str12 == null ? "" : str12;
        String str13 = acVar.aG;
        this.ah = str13 == null ? "" : str13;
        this.ai = a(acVar.aI);
        Boolean bool5 = acVar.aM;
        this.am = (bool5 == null ? ac.B : bool5).booleanValue();
        String str14 = acVar.aO;
        this.f9088a = str14 == null ? "" : str14;
        Boolean bool6 = acVar.aP;
        this.b = (bool6 == null ? ac.D : bool6).booleanValue();
        this.d = a(acVar.aQ);
        this.c = a(acVar.aR);
        Boolean bool7 = acVar.aS;
        this.e = (bool7 == null ? ac.G : bool7).booleanValue();
        Boolean bool8 = acVar.aT;
        this.f = (bool8 == null ? ac.H : bool8).booleanValue();
        Boolean bool9 = acVar.aD;
        this.Z = (bool9 == null ? ac.x : bool9).booleanValue();
        Boolean bool10 = acVar.aC;
        this.ab = (bool10 == null ? ac.w : bool10).booleanValue();
        Integer num4 = acVar.aB;
        this.aa = (num4 == null ? ac.v : num4).intValue();
        this.ac = a(acVar.aE);
        q(acVar.aF);
        this.aj = floatLayerData;
        this.ak = a(acVar.aK);
        this.al = a(acVar.aL);
        this.i = acVar.aU;
        this.h = acVar.aV;
        this.g = a(acVar.aX);
        Boolean bool11 = acVar.aY;
        this.an = (bool11 == null ? ac.J : bool11).booleanValue();
        String str15 = acVar.aW;
        this.ao = str15 == null ? "" : str15;
        Boolean bool12 = acVar.aZ;
        this.ap = (bool12 == null ? ac.K : bool12).booleanValue();
        Integer num5 = acVar.bb;
        this.aq = (num5 == null ? ac.L : num5).intValue();
        List<String> list10 = this.w;
        if ((list10 == null || list10.size() <= 0) && (list5 = this.L) != null && list5.size() > 0) {
            this.w = this.L;
        }
        List<String> list11 = this.v;
        if ((list11 == null || list11.size() <= 0) && (list6 = this.M) != null && list6.size() > 0) {
            this.v = this.M;
        }
        Long l3 = acVar.bd;
        this.ar = (l3 == null ? ac.M : l3).longValue();
        Integer num6 = acVar.bf;
        this.as = (num6 == null ? ac.O : num6).intValue();
        Integer num7 = acVar.be;
        this.at = (num7 == null ? ac.N : num7).intValue();
        String str16 = acVar.bg;
        this.au = str16 == null ? "" : str16;
        String str17 = acVar.bh;
        this.av = str17 == null ? "" : str17;
        this.aw = InteractiveData.a(acVar.bi);
        this.ay = acVar.bk;
        ac.k kVar = acVar.bl;
        if (kVar != null) {
            this.az = kVar.a();
        }
        String str18 = acVar.bm;
        if (str18 != null) {
            this.aA = str18 == null ? "" : str18;
        }
        List<ac.a> list12 = acVar.bn;
        if (list12 != null) {
            this.aB = AdxAdExtInfoData.a(list12);
        }
        String str19 = acVar.bo;
        this.aC = str19 != null ? str19 : "";
        Long l4 = acVar.bp;
        this.aD = (l4 == null ? ac.Q : l4).longValue();
    }

    private static int a(ac.e eVar) {
        int i;
        if (eVar == null || (i = AnonymousClass2.c[eVar.ordinal()]) == 1) {
            return 0;
        }
        if (i != 2) {
            return i != 3 ? 0 : 2;
        }
        return 1;
    }

    public String c() {
        return this.j;
    }

    public void f(int i) {
        this.O = i;
    }

    public void g(int i) {
        this.R = i;
    }

    public void h(int i) {
        this.S = i;
    }

    public void i(int i) {
        this.T = i;
    }

    public void j(int i) {
        this.U = i;
    }

    public void k(int i) {
        this.V = i;
    }

    public void l(int i) {
        this.X = i;
    }

    public void m(int i) {
        this.aa = i;
    }

    public void n(int i) {
        this.ai = i;
    }

    public void o(int i) {
        this.ak = i;
    }

    public void p(int i) {
        this.al = i;
    }

    public void q(int i) {
        this.c = i;
    }

    public void r(int i) {
        this.d = i;
    }

    public void s(int i) {
        this.g = i;
    }

    private static int a(ac.g gVar) {
        if (gVar != null) {
            int i = AnonymousClass2.h[gVar.ordinal()];
            if (i == 1) {
                return 1;
            }
            if (i == 2) {
                return 2;
            }
        }
        return 0;
    }

    private void q(List<r> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (r rVar : list) {
            int i = AnonymousClass2.f9089a[rVar.e.ordinal()];
            if (i == 1) {
                this.ad = rVar.f;
            } else if (i == 2) {
                this.ae = rVar.f;
            } else if (i == 3) {
                this.af = rVar.f;
            }
        }
    }

    private void r(List<ak> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (ak akVar : list) {
            switch (AnonymousClass2.b[akVar.e.ordinal()]) {
                case 1:
                    this.G = akVar.f;
                    break;
                case 2:
                    this.H = akVar.f;
                    break;
                case 3:
                    this.I = akVar.f;
                    break;
                case 4:
                    this.J = akVar.f;
                    break;
                case 5:
                    this.K = akVar.f;
                    break;
                case 6:
                    this.L = akVar.f;
                    break;
                case 7:
                    this.M = akVar.f;
                    break;
            }
        }
    }

    public List<MaterialFileData> e() {
        return this.l;
    }

    public void f(String str) {
        this.x = str;
    }

    public void g(String str) {
        this.y = str;
    }

    public void h(String str) {
        this.B = str;
    }

    public void i(String str) {
        this.C = str;
    }

    public void j(String str) {
        this.F = str;
    }

    public void k(String str) {
        this.Y = str;
    }

    public void l(String str) {
        this.ag = str;
    }

    public void m(String str) {
        this.ah = str;
    }

    public void n(String str) {
        this.f9088a = str;
    }

    public void o(String str) {
        this.ao = str;
    }

    public void p(List<String> list) {
        this.af = list;
    }

    private static int a(ac.h hVar) {
        if (hVar != null) {
            int i = AnonymousClass2.j[hVar.ordinal()];
            if (i == 1) {
                return 1;
            }
            if (i == 2) {
                return 2;
            }
        }
        return 0;
    }

    public void c(int i) {
        this.z = i;
    }

    public void d(int i) {
        this.E = i;
    }

    public void e(int i) {
        this.N = i;
    }

    public void f(List<String> list) {
        this.G = list;
    }

    public void g(List<String> list) {
        this.H = list;
    }

    public void h(List<String> list) {
        this.I = list;
    }

    public void i(List<String> list) {
        this.J = list;
    }

    public void j(List<String> list) {
        this.K = list;
    }

    public void k(List<String> list) {
        this.L = list;
    }

    public void l(List<String> list) {
        this.M = list;
    }

    public void m(List<MaterialFileData> list) {
        this.Q = list;
    }

    public void n(List<String> list) {
        this.ad = list;
    }

    public void o(List<String> list) {
        this.ae = list;
    }

    public static int a(ac.i iVar) {
        if (iVar != null) {
            switch (AnonymousClass2.i[iVar.ordinal()]) {
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
            }
        }
        return 0;
    }

    public void c(String str) {
        this.n = str;
    }

    public void d(String str) {
        this.r = str;
    }

    public void e(String str) {
        this.t = str;
    }

    public void f(boolean z) {
        this.ab = z;
    }

    public void g(boolean z) {
        this.am = z;
    }

    public void h(boolean z) {
        this.b = z;
    }

    public void i(boolean z) {
        this.e = z;
    }

    public void j(boolean z) {
        this.f = z;
    }

    public void k(boolean z) {
        this.an = z;
    }

    private static int a(ac.n nVar) {
        int i;
        return (nVar == null || (i = AnonymousClass2.g[nVar.ordinal()]) == 1 || i != 2) ? 0 : 1;
    }

    public void b(int i) {
        this.k = i;
    }

    public void c(List<String> list) {
        this.u = list;
    }

    public void d(List<String> list) {
        this.v = list;
    }

    public void e(List<String> list) {
        this.w = list;
    }

    private static int a(ac.o oVar) {
        int i;
        return (oVar == null || (i = AnonymousClass2.f[oVar.ordinal()]) == 1 || i != 2) ? 0 : 1;
    }

    public void b(long j) {
        this.D = j;
    }

    public void c(boolean z) {
        this.P = z;
    }

    public void d(boolean z) {
        this.W = z;
    }

    public void e(boolean z) {
        this.Z = z;
    }

    private static int a(ac.p pVar) {
        int i;
        if (pVar == null || (i = AnonymousClass2.d[pVar.ordinal()]) == 1) {
            return 0;
        }
        if (i != 2) {
            return i != 3 ? 0 : 2;
        }
        return 1;
    }

    public void b(String str) {
        this.m = str;
    }

    private int a(v vVar) {
        return (vVar == null || AnonymousClass2.k[vVar.ordinal()] != 1) ? 1 : 0;
    }

    public void b(List<MaterialFileData> list) {
        this.o = list;
    }

    public void b(boolean z) {
        this.A = z;
    }

    private AppDownloadData a(g gVar) {
        if (gVar == null) {
            return null;
        }
        AppDownloadData appDownloadData = new AppDownloadData();
        String str = gVar.d;
        if (str == null) {
            str = "";
        }
        appDownloadData.a(str);
        String str2 = gVar.f;
        if (str2 == null) {
            str2 = "";
        }
        appDownloadData.c(str2);
        String str3 = gVar.g;
        if (str3 == null) {
            str3 = "";
        }
        appDownloadData.d(str3);
        String str4 = gVar.e;
        appDownloadData.b(str4 != null ? str4 : "");
        return appDownloadData;
    }

    public void a(int i) {
        this.aq = i;
    }

    public void a(long j) {
        this.s = j;
    }

    public void a(AppDownloadData appDownloadData) {
        this.ac = appDownloadData;
    }

    public void a(FloatLayerData floatLayerData) {
        this.aj = floatLayerData;
    }

    public void a(String str) {
        this.j = str;
    }

    public void a(List<MaterialFileData> list) {
        this.l = list;
    }

    public void a(boolean z) {
        this.q = z;
    }

    public boolean a() {
        return this.ap;
    }
}
