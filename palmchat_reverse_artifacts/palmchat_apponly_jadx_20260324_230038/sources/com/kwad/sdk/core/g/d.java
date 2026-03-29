package com.kwad.sdk.core.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import androidx.annotation.Nullable;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.utils.bi;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class d {
    private static float aNW = 9.81f;
    private static double aNX = 0.01d;
    private volatile boolean aNM = true;
    private final bi.b aNT = new bi.b() { // from class: com.kwad.sdk.core.g.d.1
        @Override // com.kwad.sdk.utils.bi.b
        public final void onFailed() {
            if (d.this.aNY != null) {
                d.this.aNY.cc();
            }
        }
    };
    private float aNV;

    @Nullable
    private b aNY;

    @Nullable
    private a aNZ;

    public d(float f) {
        if (f <= 0.0f) {
            this.aNV = 5.0f;
        } else {
            this.aNV = f;
        }
    }

    public final synchronized void KT() {
        this.aNM = true;
    }

    public final void bP(Context context) {
        if (context == null) {
            com.kwad.sdk.core.d.c.d("ShakeDetector", "startDetect context is null");
            return;
        }
        this.aNM = true;
        if (this.aNZ == null) {
            this.aNZ = new a();
        }
        bi.To().a(1, 2, this.aNZ, this.aNT);
    }

    public final synchronized void bQ(Context context) {
        if (context != null) {
            if (this.aNZ != null) {
                bi.To().a(this.aNZ);
                this.aNZ = null;
            }
        }
    }

    public final void k(float f) {
        this.aNV = f;
    }

    public static /* synthetic */ boolean a(d dVar, boolean z) {
        dVar.aNM = false;
        return false;
    }

    public final void a(@Nullable b bVar) {
        this.aNY = bVar;
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements SensorEventListener {
        private Random aKg;
        private boolean aOc;
        private final float[] aOb = {0.0f, 0.0f, 9.8f};
        private final float[] aOd = {0.0f, 0.0f, 0.0f};

        public a() {
            this.aOc = false;
            if (((DevelopMangerComponents) com.kwad.sdk.components.d.f(DevelopMangerComponents.class)) != null) {
                this.aOc = false;
            }
        }

        private void KZ() {
            if (this.aKg == null) {
                this.aKg = new Random();
            }
            if (this.aKg.nextInt(100) == 1) {
                a(this.aOb);
            }
        }

        private void a(float[] fArr) {
            c(fArr);
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            double dAbs = Math.abs(Math.sqrt((f * f) + (f2 * f2) + (f3 * f3)));
            if (b(fArr)) {
                dAbs = Math.abs(dAbs - ((double) d.aNW));
            }
            if (!d.this.aNM || dAbs < d.this.aNV || d.this.aNY == null) {
                return;
            }
            d.a(d.this, false);
            d.this.aNY.a(dAbs);
        }

        private static boolean b(float[] fArr) {
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[2];
            return Math.abs(Math.abs(Math.sqrt((double) (((f * f) + (f2 * f2)) + (f3 * f3)))) - ((double) d.aNW)) <= d.aNX;
        }

        private void c(float[] fArr) {
            float[] fArr2 = this.aOd;
            float f = fArr2[0];
            float f2 = (f == 0.0f && fArr2[1] == 0.0f && fArr2[2] == 0.0f) ? 1.0f : 0.6f;
            float f3 = 1.0f - f2;
            fArr[0] = (fArr[0] * f2) + (f * f3);
            fArr[1] = (fArr[1] * f2) + (fArr2[1] * f3);
            fArr[2] = (f2 * fArr[2]) + (f3 * fArr2[2]);
            System.arraycopy(fArr, 0, fArr2, 0, 3);
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            a(sensorEvent.values);
            if (this.aOc) {
                KZ();
            }
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i) {
        }
    }
}
