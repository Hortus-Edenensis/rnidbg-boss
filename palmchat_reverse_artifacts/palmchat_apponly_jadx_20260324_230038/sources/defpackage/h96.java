package defpackage;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.RadarEntry;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class h96 {
    public String a(float f, jn jnVar) {
        return f(f);
    }

    public String b(BarEntry barEntry) {
        return f(barEntry.getY());
    }

    public String c(float f, BarEntry barEntry) {
        return f(f);
    }

    public String d(BubbleEntry bubbleEntry) {
        return f(bubbleEntry.getSize());
    }

    public String e(CandleEntry candleEntry) {
        return f(candleEntry.getHigh());
    }

    public abstract String f(float f);

    public String g(float f, PieEntry pieEntry) {
        return f(f);
    }

    public String h(Entry entry) {
        return f(entry.getY());
    }

    public String i(RadarEntry radarEntry) {
        return f(radarEntry.getY());
    }
}
