package com.opos.mobad.template.cmn;

import android.graphics.Color;
import androidx.palette.graphics.Palette;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class s {
    public static int a(int i, int i2) {
        for (d dVar : d.values()) {
            if (dVar.a(i)) {
                return Color.parseColor(dVar.a());
            }
        }
        return i2;
    }

    public static Palette.Swatch b(Palette palette) {
        if (palette == null || palette.getSwatches() == null || palette.getSwatches().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(palette.getSwatches());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (((Palette.Swatch) it.next()) == null) {
                it.remove();
            }
        }
        a(arrayList);
        if (arrayList.size() > 0) {
            return (Palette.Swatch) arrayList.get(0);
        }
        return null;
    }

    private static float[] c(Palette.Swatch swatch) {
        float[] fArr = new float[3];
        int rgb = swatch.getRgb();
        i.a(Color.red(rgb), Color.green(rgb), Color.blue(rgb), fArr);
        return fArr;
    }

    private static boolean d(Palette.Swatch swatch) {
        float[] hsl = swatch.getHsl();
        float f = hsl[0];
        float f2 = hsl[1] * 100.0f;
        float f3 = hsl[2] * 100.0f;
        if (a(f, f2, f3) || b(f, f2, f3)) {
            return true;
        }
        float[] fArrC = c(swatch);
        float f4 = fArrC[0] * 100.0f;
        float f5 = fArrC[1] * 100.0f;
        float f6 = fArrC[2] * 100.0f;
        return a(f4, f5, f6) || b(f4, f5, f6);
    }

    public static Palette.Swatch a(Palette palette) {
        if (palette == null || palette.getSwatches() == null || palette.getSwatches().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(palette.getSwatches());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Palette.Swatch swatch = (Palette.Swatch) it.next();
            if (swatch == null || d(swatch)) {
                it.remove();
            }
        }
        a(arrayList);
        if (arrayList.size() > 0) {
            return (Palette.Swatch) arrayList.get(0);
        }
        return null;
    }

    private static boolean b(float f, float f2, float f3) {
        return f >= 0.0f && f <= 360.0f && f2 >= 0.0f && f2 <= 100.0f && f3 >= 0.0f && f3 <= 5.0f;
    }

    private static void a(List<Palette.Swatch> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        Collections.sort(list, new Comparator<Palette.Swatch>() { // from class: com.opos.mobad.template.cmn.s.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(Palette.Swatch swatch, Palette.Swatch swatch2) {
                return swatch2.getPopulation() - swatch.getPopulation();
            }
        });
    }

    public static boolean b(Palette.Swatch swatch) {
        float[] hsl = swatch.getHsl();
        if (b(hsl[0], hsl[1] * 100.0f, hsl[2] * 100.0f)) {
            return true;
        }
        float[] fArrC = c(swatch);
        return b(fArrC[0] * 100.0f, fArrC[1] * 100.0f, fArrC[2] * 100.0f);
    }

    private static boolean a(float f, float f2, float f3) {
        return f >= 0.0f && f <= 360.0f && f2 >= 0.0f && f2 <= 5.0f && f3 >= 0.0f && f3 <= 100.0f;
    }

    public static boolean a(Palette.Swatch swatch) {
        float[] hsl = swatch.getHsl();
        if (a(hsl[0], hsl[1] * 100.0f, hsl[2] * 100.0f)) {
            return true;
        }
        float[] fArrC = c(swatch);
        return a(fArrC[0] * 100.0f, fArrC[1] * 100.0f, fArrC[2] * 100.0f);
    }

    public static float[] a(Palette.Swatch swatch, float f, float f2) {
        float[] hsl = swatch.getHsl();
        hsl[1] = f;
        hsl[2] = f2;
        return hsl;
    }
}
