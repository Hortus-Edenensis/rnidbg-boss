package com.bytedance.sdk.component.a.fx;

import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    public boolean u = false;
    public boolean nr = true;
    public Map<String, Integer> fx = null;
    public Map<String, String> b = null;
    public int pn = 10;
    public int iz = 1;
    public int x = 1;
    public int n = 10;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5075a = 1;
    public int jk = 1;
    public int t = 900;
    public int l = 120;
    public String mv = null;
    public int s = 0;
    public long k = 0;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" localEnable: ");
        sb.append(this.u);
        sb.append(" probeEnable: ");
        sb.append(this.nr);
        sb.append(" hostFilter: ");
        Map<String, Integer> map = this.fx;
        sb.append(map != null ? map.size() : 0);
        sb.append(" hostMap: ");
        Map<String, String> map2 = this.b;
        sb.append(map2 != null ? map2.size() : 0);
        sb.append(" reqTo: ");
        sb.append(this.pn);
        sb.append("#");
        sb.append(this.iz);
        sb.append("#");
        sb.append(this.x);
        sb.append(" reqErr: ");
        sb.append(this.n);
        sb.append("#");
        sb.append(this.f5075a);
        sb.append("#");
        sb.append(this.jk);
        sb.append(" updateInterval: ");
        sb.append(this.t);
        sb.append(" updateRandom: ");
        sb.append(this.l);
        sb.append(" httpBlack: ");
        sb.append(this.mv);
        return sb.toString();
    }
}
