package com.baidu.platform.comapi.map;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class OverlayItem {
    public static final int ALIGN_BOTTON = 2;
    public static final int ALIGN_TOP = 3;
    public static final int ALING_CENTER = 1;
    private int b;
    private int c;
    protected GeoPoint d;
    protected String e;
    protected String f;
    private Bundle m;
    private Bundle n;
    private float o;
    private byte[] p;
    private float q;
    private int s;
    private CoordType i = CoordType.CoordType_BD09;
    private Drawable g = null;
    private int r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4180a = 2;
    private String h = "";
    private float j = 0.5f;
    private float k = 1.0f;
    private ArrayList<Bundle> l = new ArrayList<>();

    /* JADX INFO: compiled from: SearchBox */
    public enum AnimEffect {
        NONE,
        GROWTH,
        WAVE,
        SHRINK,
        FADE_OUT,
        FADE_IN,
        GROWTH_FADE_IN,
        SHRINK_FADE_OUT,
        GROWTH_REBOUND,
        ALPHA,
        ANCHOR_GROUTH,
        ROTATE
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum AnimationSubType {
        NONE,
        RADAR
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum CoordType {
        CoordType_BD09LL,
        CoordType_BD09
    }

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4181a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[AnimationSubType.values().length];
            b = iArr;
            try {
                iArr[AnimationSubType.RADAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[AnimationSubType.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[AnimEffect.values().length];
            f4181a = iArr2;
            try {
                iArr2[AnimEffect.GROWTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4181a[AnimEffect.WAVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4181a[AnimEffect.SHRINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4181a[AnimEffect.FADE_OUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4181a[AnimEffect.FADE_IN.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4181a[AnimEffect.GROWTH_FADE_IN.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4181a[AnimEffect.SHRINK_FADE_OUT.ordinal()] = 7;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f4181a[AnimEffect.GROWTH_REBOUND.ordinal()] = 8;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f4181a[AnimEffect.ALPHA.ordinal()] = 9;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f4181a[AnimEffect.ANCHOR_GROUTH.ordinal()] = 10;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f4181a[AnimEffect.ROTATE.ordinal()] = 11;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f4181a[AnimEffect.NONE.ordinal()] = 12;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public OverlayItem(GeoPoint geoPoint, String str, String str2) {
        this.d = geoPoint;
        this.e = str;
        this.f = str2;
    }

    public void addClickRect(Bundle bundle) {
        if (this.l == null) {
            this.l = new ArrayList<>();
        }
        this.l.add(bundle);
    }

    public float getAnchorX() {
        return this.j;
    }

    public float getAnchorY() {
        return this.k;
    }

    public Bundle getAnimate() {
        return this.m;
    }

    public int getBound() {
        return this.f4180a;
    }

    public ArrayList<Bundle> getClickRect() {
        return this.l;
    }

    public CoordType getCoordType() {
        return this.i;
    }

    public Bundle getDelay() {
        return this.n;
    }

    public float getGeoZ() {
        return this.o;
    }

    public byte[] getGifData() {
        return this.p;
    }

    public String getId() {
        return this.h;
    }

    public int getIndoorPoi() {
        return this.s;
    }

    public int getLevel() {
        return this.b;
    }

    public final Drawable getMarker() {
        return this.g;
    }

    public int getMask() {
        return this.c;
    }

    public float getMultiplyDpi() {
        return this.r;
    }

    public GeoPoint getPoint() {
        return this.d;
    }

    public int getResId() {
        if (getMarker() == null) {
            return -1;
        }
        return getMarker().hashCode();
    }

    public float getScale() {
        return this.q;
    }

    public String getSnippet() {
        return this.f;
    }

    public String getTitle() {
        return this.e;
    }

    public void setAnchor(float f, float f2) {
        this.j = f;
        this.k = f2;
    }

    public void setAnimate(Bundle bundle) {
        this.m = bundle;
    }

    public void setAnimateDuration(int i) {
        if (this.m == null) {
            this.m = new Bundle();
        }
        this.m.putInt("dur", i);
    }

    public void setAnimateEffect(AnimEffect animEffect) {
        if (this.m == null) {
            this.m = new Bundle();
        }
        switch (a.f4181a[animEffect.ordinal()]) {
            case 1:
                this.m.putInt("type", 1);
                break;
            case 2:
                this.m.putInt("type", 2);
                break;
            case 3:
                this.m.putInt("type", 3);
                break;
            case 4:
                this.m.putInt("type", 4);
                break;
            case 5:
                this.m.putInt("type", 5);
                break;
            case 6:
                this.m.putInt("type", 6);
                break;
            case 7:
                this.m.putInt("type", 7);
                break;
            case 8:
                this.m.putInt("type", 8);
                break;
            case 9:
                this.m.putInt("type", 9);
                break;
            case 10:
                this.m.putInt("type", 10);
                break;
            case 11:
                this.m.putInt("type", 11);
                break;
            default:
                this.m.putInt("type", 0);
                break;
        }
    }

    public void setAnimateEndSize(int i, int i2) {
        if (this.m == null) {
            this.m = new Bundle();
        }
        this.m.putInt("en_w", i);
        this.m.putInt("en_h", i2);
    }

    public void setAnimateStartSize(int i, int i2) {
        if (this.m == null) {
            this.m = new Bundle();
        }
        this.m.putInt("st_w", i);
        this.m.putInt("st_h", i2);
    }

    public void setBound(int i) {
        this.f4180a = i;
    }

    public void setClickRect(ArrayList<Bundle> arrayList) {
        this.l = arrayList;
    }

    public void setCoordType(CoordType coordType) {
        this.i = coordType;
    }

    public void setDelay(Bundle bundle) {
        this.n = bundle;
    }

    public void setGeoPoint(GeoPoint geoPoint) {
        this.d = geoPoint;
    }

    public void setGeoZ(float f) {
        this.o = f;
    }

    public void setGifData(byte[] bArr) {
        this.p = bArr;
    }

    public void setId(String str) {
        this.h = str;
    }

    public void setIndoorPoi(int i) {
        this.s = i;
    }

    public void setLevel(int i) {
        this.b = i;
    }

    public void setMarker(Drawable drawable) {
        this.g = drawable;
    }

    public void setMask(int i) {
        this.c = i;
    }

    public void setMultiplyDpi(int i) {
        this.r = i;
    }

    public void setScale(float f) {
        this.q = f;
    }

    public void setSnippet(String str) {
        this.f = str;
    }

    public void setSubAnimateEffect(AnimationSubType animationSubType) {
        if (this.m == null) {
            this.m = new Bundle();
        }
        if (a.b[animationSubType.ordinal()] != 1) {
            this.m.putInt("sub_type", 0);
        } else {
            this.m.putInt("sub_type", 1);
        }
    }

    public void setTitle(String str) {
        this.e = str;
    }

    public void setAnchor(int i) {
        if (i == 1) {
            setAnchor(0.5f, 0.5f);
        } else if (i == 2) {
            setAnchor(0.5f, 1.0f);
        } else {
            if (i != 3) {
                return;
            }
            setAnchor(0.5f, 0.0f);
        }
    }
}
