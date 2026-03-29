package com.tencent.turingfd.sdk.ams.ad;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class TuringSDK extends Flat {

    /* JADX INFO: compiled from: SearchBox */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f10746a;
        public ITuringPrivacyPolicy s;
        public ITuringDeviceInfoProvider t;
        public ITuringPkgProvider u;
        public ITuringIoTFeatureMap v;
        public String b = "";
        public int c = 5000;
        public long d = 60000;
        public int e = 3;
        public String f = "";
        public String g = "";
        public int h = 0;
        public String i = "";
        public int j = 0;
        public Map<Integer, String> k = new HashMap();
        public boolean l = true;
        public String m = "";
        public String n = "";
        public boolean o = true;
        public boolean p = true;
        public boolean q = false;
        public boolean r = true;
        public boolean w = false;
        public boolean x = false;
        public boolean y = false;
        public boolean z = false;

        public Builder(Context context, ITuringPrivacyPolicy iTuringPrivacyPolicy) {
            this.f10746a = context.getApplicationContext();
            this.s = iTuringPrivacyPolicy;
        }

        public final Builder appid(String str) {
            this.m = str;
            return this;
        }

        public final Builder autoRequestBg(boolean z) {
            this.p = z;
            return this;
        }

        public final TuringSDK build() {
            return new TuringSDK(this);
        }

        public final Builder channel(int i) {
            this.j = i;
            return this;
        }

        public final Builder clientBuildNo(int i) {
            this.h = i;
            return this;
        }

        public final Builder clientChannel(String str) {
            this.f = str;
            return this;
        }

        public final Builder clientLc(String str) {
            this.i = str;
            return this;
        }

        public final Builder clientMetaDataMap(Map<Integer, String> map) {
            this.k = map;
            return this;
        }

        public final Builder clientVersion(String str) {
            this.g = str;
            return this;
        }

        public final Builder enableClickRisk() {
            this.x = true;
            return this;
        }

        public final Builder enableDRM() {
            this.y = true;
            return this;
        }

        public final Builder forceReqServiceEveryTime(boolean z) {
            this.q = z;
            return this;
        }

        public final Builder honorOAIDPreferred() {
            this.z = true;
            return this;
        }

        public final Builder initNetwork(boolean z) {
            this.r = z;
            return this;
        }

        public final Builder loadLibrary(boolean z) {
            this.l = z;
            return this;
        }

        public final Builder phyFeature(boolean z) {
            this.o = z;
            return this;
        }

        public final Builder retryTime(int i) {
            if (i < 1) {
                i = 1;
            }
            if (i > 10) {
                i = 10;
            }
            this.e = i;
            return this;
        }

        public final Builder riskDetectTimeout(int i) {
            if (i < 100) {
                i = 100;
            }
            if (i > 60000) {
                i = 60000;
            }
            this.d = i;
            return this;
        }

        public final Builder soFilePath(String str) {
            this.n = str;
            return this;
        }

        public final Builder timeout(int i) {
            if (i < 100) {
                i = 100;
            }
            if (i > 60000) {
                i = 60000;
            }
            this.c = i;
            return this;
        }

        public final Builder turingDeviceInfoProvider(ITuringDeviceInfoProvider iTuringDeviceInfoProvider) {
            this.t = iTuringDeviceInfoProvider;
            return this;
        }

        public final Builder turingIoTFeatureMap(ITuringIoTFeatureMap iTuringIoTFeatureMap) {
            this.v = iTuringIoTFeatureMap;
            return this;
        }

        public final Builder turingPkgProvider(ITuringPkgProvider iTuringPkgProvider) {
            this.u = iTuringPkgProvider;
            return this;
        }

        public final Builder tvOS(boolean z) {
            this.w = z;
            return this;
        }

        public final Builder uniqueId(String str) {
            this.b = str;
            return this;
        }
    }

    public TuringSDK(Builder builder) {
        a(builder.f10746a);
        this.g = builder.b;
        this.w = builder.c;
        this.x = builder.d;
        this.y = builder.e;
        this.m = builder.g;
        this.l = builder.f;
        this.n = builder.h;
        this.o = builder.i;
        this.p = builder.k;
        this.f = builder.j;
        this.h = builder.l;
        this.q = builder.m;
        this.k = builder.n;
        this.t = builder.o;
        this.r = builder.p;
        this.s = builder.q;
        this.u = builder.r;
        this.b = builder.s;
        this.c = builder.t;
        this.d = builder.u;
        this.e = builder.v;
        this.v = builder.w;
        this.A = builder.x;
        this.B = builder.y;
        this.C = builder.z;
        a();
    }

    public static Builder createConf(Context context, ITuringPrivacyPolicy iTuringPrivacyPolicy) {
        return new Builder(context, iTuringPrivacyPolicy);
    }

    public static String getVersionInfo() {
        return Marc.b();
    }

    public int init() {
        AtomicBoolean atomicBoolean = Marc.c;
        synchronized (atomicBoolean) {
            if (atomicBoolean.get()) {
                return 0;
            }
            if (Build.VERSION.SDK_INT == 23) {
                String strA = Damson.a("M String fixed1".getBytes(), "UTF-8");
                if (strA == null) {
                    strA = "M String fixed1 failed";
                }
                Log.i("TuringFdJava", strA);
                String strA2 = Damson.a("M String fixed2".getBytes(), null);
                if (strA2 == null) {
                    strA2 = "M String fixed2 failed";
                }
                Log.i("TuringFdJava", strA2);
            }
            int i = this.f;
            if (i > 0) {
                Carambola.f10673a = i;
            }
            if (Carambola.f10673a == 0) {
                Log.e("TuringFdJava", "please input valid channel!");
                return -10018;
            }
            Carambola.b = this.A;
            synchronized (Flat.class) {
                Flat.D = this;
            }
            Log.i("TuringFdJava", Marc.b());
            AtomicReference<String> atomicReference = Cdefault.f10756a;
            if (!TextUtils.isEmpty(null)) {
                AtomicReference<String> atomicReference2 = Cdefault.f10756a;
                synchronized (atomicReference2) {
                    atomicReference2.set(null);
                }
            }
            System.currentTimeMillis();
            int iB = Marc.b(this);
            if (iB == 0) {
                iB = Marc.c(this);
                if (iB == 0) {
                    Longan.b.f10715a = this;
                    Marc.a(this);
                    atomicBoolean.set(true);
                    return 0;
                }
            }
            return iB;
        }
    }
}
