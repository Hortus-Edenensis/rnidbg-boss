package defpackage;

import android.animation.TimeInterpolator;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@RequiresApi(11)
public class uj1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f21227a = new k();
    public static final c0 b = new u();
    public static final c0 c = new v();
    public static final c0 d = new w();
    public static final c0 e = new x();
    public static final c0 f = new y();
    public static final c0 g = new z();
    public static final c0 h = new a0();
    public static final c0 i = new b0();
    public static final c0 j = new a();
    public static final c0 k = new b();
    public static final c0 l = new c();
    public static final c0 m = new d();
    public static final c0 n = new e();
    public static final c0 o = new f();
    public static final c0 p = new g();
    public static final c0 q = new h();
    public static final c0 r = new i();
    public static final c0 s = new j();
    public static final c0 t = new l();
    public static final c0 u = new m();
    public static final c0 v = new n();
    public static final c0 w = new o();
    public static final c0 x = new p();
    public static final c0 y = new q();
    public static final c0 z = new r();
    public static final c0 A = new s();
    public static final c0 B = new t();

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements c0 {
        @Override // uj1.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float fPow;
            float f2;
            float f3 = f * 2.0f;
            if (f3 < 1.0f) {
                fPow = (float) Math.pow(f3, 4.0d);
                f2 = 0.5f;
            } else {
                fPow = ((float) Math.pow(f3 - 2.0f, 4.0d)) - 2.0f;
                f2 = -0.5f;
            }
            return fPow * f2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a0 implements c0 {
        @Override // uj1.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return (float) Math.pow(f, 4.0d);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements c0 {
        @Override // uj1.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return (-((float) Math.cos(((double) f) * 1.5707963267948966d))) + 1.0f;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b0 implements c0 {
        @Override // uj1.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return -(((float) Math.pow(f - 1.0f, 4.0d)) - 1.0f);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c implements c0 {
        @Override // uj1.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return (float) Math.sin(((double) f) * 1.5707963267948966d);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c0 extends TimeInterpolator {
        @Override // android.animation.TimeInterpolator
        float getInterpolation(float f);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d implements c0 {
        @Override // uj1.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return (((float) Math.cos(((double) f) * 3.141592653589793d)) - 1.0f) * (-0.5f);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e implements c0 {
        @Override // uj1.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f == 0.0f) {
                return 0.0f;
            }
            return (float) Math.pow(2.0d, (f - 1.0f) * 10.0f);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class f implements c0 {
        @Override // uj1.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f == 1.0f) {
                return 1.0f;
            }
            return -((float) Math.pow(2.0d, (f + 1.0f) * (-10.0f)));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class g implements c0 {
        @Override // uj1.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f == 0.0f) {
                return 0.0f;
            }
            if (f == 1.0f) {
                return 1.0f;
            }
            return (f * 2.0f < 1.0f ? (float) Math.pow(2.0d, (r8 - 1.0f) * 10.0f) : (-((float) Math.pow(2.0d, (r8 - 1.0f) * (-10.0f)))) + 2.0f) * 0.5f;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class h implements c0 {
        @Override // uj1.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return -(((float) Math.sqrt(1.0f - (f * f))) - 1.0f);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class i implements c0 {
        @Override // uj1.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (float) Math.sqrt(1.0f - (f2 * f2));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class j implements c0 {
        @Override // uj1.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float fSqrt;
            float f2;
            float f3 = f * 2.0f;
            if (f3 < 1.0f) {
                fSqrt = ((float) Math.sqrt(1.0f - (f3 * f3))) - 1.0f;
                f2 = -0.5f;
            } else {
                float f4 = f3 - 2.0f;
                fSqrt = ((float) Math.sqrt(1.0f - (f4 * f4))) + 1.0f;
                f2 = 0.5f;
            }
            return fSqrt * f2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class l implements c0 {
        @Override // uj1.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f == 0.0f) {
                return 0.0f;
            }
            if (f == 1.0f) {
                return 1.0f;
            }
            float f2 = f - 1.0f;
            return -(((float) Math.pow(2.0d, 10.0f * f2)) * ((float) Math.sin(((f2 - (0.047746483f * ((float) Math.asin(1.0d)))) * 6.2831855f) / 0.3f)));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class m implements c0 {
        @Override // uj1.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f == 0.0f) {
                return 0.0f;
            }
            if (f == 1.0f) {
                return 1.0f;
            }
            return (((float) Math.pow(2.0d, (-10.0f) * f)) * ((float) Math.sin(((f - (0.047746483f * ((float) Math.asin(1.0d)))) * 6.2831855f) / 0.3f))) + 1.0f;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class n implements c0 {
        @Override // uj1.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f == 0.0f) {
                return 0.0f;
            }
            float f2 = f * 2.0f;
            if (f2 == 2.0f) {
                return 1.0f;
            }
            float fAsin = ((float) Math.asin(1.0d)) * 0.07161972f;
            if (f2 < 1.0f) {
                float f3 = f2 - 1.0f;
                return ((float) Math.pow(2.0d, 10.0f * f3)) * ((float) Math.sin(((f3 * 1.0f) - fAsin) * 6.2831855f * 2.2222223f)) * (-0.5f);
            }
            float f4 = f2 - 1.0f;
            return (((float) Math.pow(2.0d, (-10.0f) * f4)) * 0.5f * ((float) Math.sin(((f4 * 1.0f) - fAsin) * 6.2831855f * 2.2222223f))) + 1.0f;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class o implements c0 {
        @Override // uj1.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f * f * ((f * 2.70158f) - 1.70158f);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class p implements c0 {
        @Override // uj1.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * ((f2 * 2.70158f) + 1.70158f)) + 1.0f;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class q implements c0 {
        @Override // uj1.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f * 2.0f;
            if (f2 < 1.0f) {
                return f2 * f2 * ((3.5949094f * f2) - 2.5949094f) * 0.5f;
            }
            float f3 = f2 - 2.0f;
            return ((f3 * f3 * ((3.5949094f * f3) + 2.5949094f)) + 2.0f) * 0.5f;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class r implements c0 {
        @Override // uj1.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return 1.0f - uj1.A.getInterpolation(1.0f - f);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class s implements c0 {
        @Override // uj1.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            if (f < 0.36363637f) {
                return 7.5625f * f * f;
            }
            if (f < 0.72727275f) {
                float f2 = f - 0.54545456f;
                return (7.5625f * f2 * f2) + 0.75f;
            }
            if (f < 0.90909094f) {
                float f3 = f - 0.8181818f;
                return (7.5625f * f3 * f3) + 0.9375f;
            }
            float f4 = f - 0.95454544f;
            return (7.5625f * f4 * f4) + 0.984375f;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class t implements c0 {
        @Override // uj1.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f < 0.5f ? uj1.z.getInterpolation(f * 2.0f) * 0.5f : (uj1.A.getInterpolation((f * 2.0f) - 1.0f) * 0.5f) + 0.5f;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u implements c0 {
        @Override // uj1.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f * f;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class v implements c0 {
        @Override // uj1.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return (-f) * (f - 2.0f);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class w implements c0 {
        @Override // uj1.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f * 2.0f;
            if (f2 < 1.0f) {
                return 0.5f * f2 * f2;
            }
            float f3 = f2 - 1.0f;
            return ((f3 * (f3 - 2.0f)) - 1.0f) * (-0.5f);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class x implements c0 {
        @Override // uj1.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return (float) Math.pow(f, 3.0d);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class y implements c0 {
        @Override // uj1.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return ((float) Math.pow(f - 1.0f, 3.0d)) + 1.0f;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class z implements c0 {
        @Override // uj1.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f * 2.0f;
            return (f2 < 1.0f ? (float) Math.pow(f2, 3.0d) : ((float) Math.pow(f2 - 2.0f, 3.0d)) + 2.0f) * 0.5f;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class k implements c0 {
        @Override // uj1.c0, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f;
        }
    }
}
