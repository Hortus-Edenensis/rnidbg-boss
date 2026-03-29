package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import okio.Utf8;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class p1 implements SensorEventListener {
    public static volatile p1 f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SensorManager f19320a;
    public int b;
    public int c = 0;
    public float[] d = new float[3];
    public ArrayList e = new ArrayList();

    static {
        new DecimalFormat((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8649b3", new byte[]{121, 122, 23}));
        f = null;
    }

    public p1(Context context) {
        this.f19320a = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            this.f19320a = (SensorManager) applicationContext.getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b843f7", new byte[]{96, Utf8.REPLACEMENT_BYTE, 73, 84, 86, 50}));
        }
    }

    public static p1 e(Context context) {
        if (f == null) {
            synchronized (p1.class) {
                if (f == null) {
                    f = new p1(context);
                }
            }
        }
        return f;
    }

    public final synchronized void a() {
        try {
            SensorManager sensorManager = this.f19320a;
            if (sensorManager != null) {
                if (this.b == 0) {
                    if (!this.f19320a.registerListener(this, sensorManager.getDefaultSensor(1), 3)) {
                        return;
                    }
                }
                this.b++;
            }
        } catch (Exception unused) {
        }
    }

    public final synchronized String b() {
        StringBuilder sb = new StringBuilder();
        int size = this.e.size();
        if (size <= 0) {
            return null;
        }
        try {
            ArrayList arrayList = this.e;
            int i = size - 50;
            if (i <= 0) {
                i = 0;
            }
            List<JSONArray> listSubList = arrayList.subList(i, size);
            if (listSubList.size() > 0) {
                for (JSONArray jSONArray : listSubList) {
                    if (jSONArray != null) {
                        sb.append(jSONArray.get(0).toString());
                        sb.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "30e436", new byte[]{110}));
                        sb.append(jSONArray.get(1).toString());
                        sb.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a2f1a0", new byte[]{60}));
                        sb.append(jSONArray.get(2).toString());
                        sb.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "62868d", new byte[]{59}));
                    }
                }
            }
            if (sb.length() > 0) {
                sb.delete(sb.length() - 1, sb.length());
            }
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    public final synchronized void c() {
        JSONArray jSONArrayF = f();
        if (jSONArrayF == null) {
            return;
        }
        this.e.add(jSONArrayF);
        try {
            int size = this.e.size();
            if (size > 100) {
                ArrayList arrayList = new ArrayList(this.e.subList(size - 50, size));
                this.e.clear();
                this.e = arrayList;
            }
        } catch (Throwable unused) {
        }
    }

    public final synchronized void d() {
        try {
            SensorManager sensorManager = this.f19320a;
            if (sensorManager != null) {
                int i = this.b - 1;
                this.b = i;
                if (i == 0) {
                    sensorManager.unregisterListener(this);
                }
            }
        } catch (Exception unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "191692", new byte[]{51, 40, 65, 125, 19});
        }
    }

    public final JSONArray f() {
        byte b;
        JSONArray jSONArray;
        BigDecimal bigDecimal;
        try {
            b = pble.c() != null ? (byte) 1 : (byte) 0;
        } catch (Throwable unused) {
            b = -1;
        }
        if (b != 1) {
            return null;
        }
        a();
        try {
            try {
                synchronized (this) {
                    int i = 0;
                    while (this.c == 0 && i < 10) {
                        i++;
                        wait(1000L);
                    }
                }
                jSONArray = new JSONArray();
                jSONArray.put(new BigDecimal(this.d[0]).setScale(2, 4));
                jSONArray.put(new BigDecimal(this.d[1]).setScale(2, 4));
                bigDecimal = new BigDecimal(this.d[2]);
            } catch (Exception unused2) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e70f29", new byte[]{103, 38, 64, 45, 10});
                jSONArray = new JSONArray();
                jSONArray.put(new BigDecimal(this.d[0]).setScale(2, 4));
                jSONArray.put(new BigDecimal(this.d[1]).setScale(2, 4));
                bigDecimal = new BigDecimal(this.d[2]);
            }
            jSONArray.put(bigDecimal.setScale(2, 4));
            d();
            this.c = 0;
            return jSONArray;
        } catch (Throwable th) {
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(new BigDecimal(this.d[0]).setScale(2, 4));
            jSONArray2.put(new BigDecimal(this.d[1]).setScale(2, 4));
            jSONArray2.put(new BigDecimal(this.d[2]).setScale(2, 4));
            d();
            this.c = 0;
            throw th;
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        this.d = sensorEvent.values;
        this.c = 1;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }
}
