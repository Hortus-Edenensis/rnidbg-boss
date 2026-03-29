package com.baidu.platform.comapi.map;

import android.text.TextUtils;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comapi.util.JsonBuilder;
import com.bytedance.pangle.ZeusPluginEventCallback;
import com.cdo.oaps.ad.OapsWrapper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected z f4206a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public String i;
    public boolean j;
    protected double[] o;
    protected double[] p;
    protected int[] q;
    protected JsonBuilder u;
    public float k = 5.0f;
    private boolean l = false;
    private int m = 0;
    private int n = 0;
    protected GeoPoint r = new GeoPoint(0, 0);
    protected GeoPoint s = new GeoPoint(0, 0);
    protected boolean t = true;
    protected int v = -1;
    protected int w = 0;

    public f(z zVar) {
        this.f4206a = zVar;
    }

    public abstract String a();

    public String a(int i) {
        JsonBuilder jsonBuilder = new JsonBuilder();
        this.u = jsonBuilder;
        jsonBuilder.object();
        int i2 = 0;
        if (i == 0) {
            this.u.key(OapsWrapper.KEY_PATH).arrayValue();
            if (this.o != null) {
                int i3 = 0;
                while (true) {
                    double[] dArr = this.o;
                    if (i3 >= dArr.length) {
                        break;
                    }
                    this.u.value(dArr[i3]);
                    i3++;
                }
            }
            this.u.endArrayValue();
            this.u.key("arrColor").arrayValue();
            if (this.q != null) {
                int i4 = 0;
                while (true) {
                    int[] iArr = this.q;
                    if (i4 >= iArr.length) {
                        break;
                    }
                    this.u.value(iArr[i4]);
                    i4++;
                }
            }
            this.u.endArrayValue();
            this.u.key("useColorArray").value(this.g);
        } else if (i == 1) {
            this.u.key("sgeo");
            this.u.object();
            this.u.key("bound").arrayValue();
            GeoPoint geoPoint = this.r;
            if (geoPoint != null && this.s != null) {
                this.u.value(geoPoint.getLongitude());
                this.u.value(this.r.getLatitude());
                this.u.value(this.s.getLongitude());
                this.u.value(this.s.getLatitude());
            }
            this.u.endArrayValue();
            if (this.w == 4) {
                this.u.key("type").value(3);
            } else {
                this.u.key("type").value(this.w);
            }
            this.u.key("elements").arrayValue();
            this.u.object();
            this.u.key("points").arrayValue();
            if (this.o != null) {
                int i5 = 0;
                while (true) {
                    double[] dArr2 = this.o;
                    if (i5 >= dArr2.length) {
                        break;
                    }
                    this.u.value(dArr2[i5]);
                    i5++;
                }
            }
            this.u.endArrayValue();
            this.u.endObject();
            this.u.endArrayValue();
            this.u.endObject();
        }
        this.u.key("ud").value(String.valueOf(hashCode()));
        this.u.key(MapBundleKey.MapObjKey.OBJ_DIR).value(0);
        z zVar = this.f4206a;
        if (zVar == null || zVar.c() == 0) {
            int i6 = this.w;
            if (i6 == 3) {
                this.u.key(MapBundleKey.MapObjKey.OBJ_TYPE).value(ZeusPluginEventCallback.EVENT_FINISH_INITIALIZATION);
            } else if (i6 == 4) {
                this.u.key(MapBundleKey.MapObjKey.OBJ_TYPE).value(3200);
            } else {
                this.u.key(MapBundleKey.MapObjKey.OBJ_TYPE).value(-1);
            }
        } else {
            this.u.key(MapBundleKey.MapObjKey.OBJ_NORMALSTYTLE).value(this.f4206a.c());
            this.u.key(MapBundleKey.MapObjKey.OBJ_FOCUSSTYTLE).value(this.f4206a.c());
            this.u.key(MapBundleKey.MapObjKey.OBJ_TYPE).value(32);
        }
        this.u.key(MapBundleKey.MapObjKey.OBJ_OFFSET).value(0);
        this.u.key("in").value(0);
        this.u.key(MapBundleKey.MapObjKey.OBJ_TEXT).value("");
        this.u.key(MapBundleKey.MapObjKey.OBJ_DIS).value(0);
        this.u.key("align").value(0);
        if (this.b) {
            this.u.key("dash").value(1);
            this.u.key(MapBundleKey.MapObjKey.OBJ_TYPE).value(this.w);
        }
        if (this.c) {
            this.u.key("trackMove").object();
            this.u.key("pointStyle").value(((a0) this.f4206a).e());
            this.u.endObject();
        }
        if (this.e) {
            this.u.key("cancelDataReduction").value(1);
        } else {
            this.u.key("cancelDataReduction").value(0);
        }
        if (this.f) {
            this.u.key("cancelSmooth").value(1);
        } else {
            this.u.key("cancelSmooth").value(0);
        }
        if (this.j) {
            this.u.key("isTrackBloom").value(1);
            this.u.key("bloomSpeed").value(this.k);
        } else {
            this.u.key("isTrackBloom").value(0);
        }
        if (this.d) {
            this.u.key("pointMove").object();
            if (this.h) {
                this.u.key("use3dPoint").value(1);
            } else {
                this.u.key("use3dPoint").value(0);
            }
            if (this.l) {
                this.u.key("duration").value(this.m);
                this.u.key("easingCurve").value(this.n);
                this.l = false;
            } else {
                this.u.key("duration").value(0);
                this.u.key("easingCurve").value(0);
            }
            this.u.key("pointArray").arrayValue();
            if (this.p != null) {
                while (true) {
                    double[] dArr3 = this.p;
                    if (i2 >= dArr3.length) {
                        break;
                    }
                    this.u.value(dArr3[i2]);
                    i2++;
                }
            }
            this.u.endArrayValue();
            if (!TextUtils.isEmpty(this.i)) {
                this.u.key("imagePath").value(this.i);
            }
            this.u.endObject();
        }
        this.u.key("style").object();
        if (this.f4206a != null) {
            this.u.key("width").value(this.f4206a.d());
            this.u.key("color").value(z.c(this.f4206a.a()));
            int i7 = this.w;
            if (i7 == 3 || i7 == 4) {
                this.u.key("scolor").value(z.c(this.f4206a.b()));
            }
        }
        this.u.endObject();
        this.u.endObject();
        return this.u.toString();
    }

    public void a(boolean z, int i, int i2) {
        this.l = z;
        this.m = i;
        this.n = i2;
    }
}
