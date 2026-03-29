package com.baidu.mapapi.map;

import android.util.Log;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.baidu.mapapi.model.LatLng;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class CircleHoleOptions extends HoleOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LatLng f3614a;
    private int b;

    public CircleHoleOptions() {
        this.mHoleType = TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE;
    }

    public CircleHoleOptions center(LatLng latLng) {
        if (latLng == null) {
            Log.e("baidumapsdk", "CircleHole center can not be null");
            return this;
        }
        this.f3614a = latLng;
        return this;
    }

    public LatLng getHoleCenter() {
        return this.f3614a;
    }

    public int getHoleRadius() {
        return this.b;
    }

    public CircleHoleOptions radius(int i) {
        if (i <= 0) {
            Log.e("baidumapsdk", "CircleHole's radius can not be less than zero");
            return this;
        }
        this.b = i;
        return this;
    }
}
