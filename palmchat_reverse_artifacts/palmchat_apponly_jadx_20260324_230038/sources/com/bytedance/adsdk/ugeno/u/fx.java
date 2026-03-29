package com.bytedance.adsdk.ugeno.u;

import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class fx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5043a = 1;
    private String b;
    private int fx;
    private u iz;
    private JSONObject jk;
    private String n;
    private long nr;
    private long pn;
    private Map<String, TreeMap<Float, String>> u;
    private String x;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        public String nr;
        public String u;
    }

    public String a() {
        return this.n;
    }

    public int b() {
        return this.fx;
    }

    public long fx() {
        return this.nr;
    }

    public long iz() {
        return this.pn;
    }

    public int jk() {
        return this.f5043a;
    }

    public String n() {
        return this.x;
    }

    public Map<String, TreeMap<Float, String>> nr() {
        return this.u;
    }

    public String pn() {
        return this.b;
    }

    public String toString() {
        return "AnimationModel{mKeyFramesMap=" + this.u + ", mDuration=" + this.nr + ", mPlayCount=" + this.fx + ", mPlayDirection=" + this.b + ", mDelay=" + this.pn + ", mName=" + this.n + ", mPlayState=" + this.f5043a + ", mTransformOrigin='" + this.iz + "', mTimingFunction='" + this.x + "'}";
    }

    public JSONObject u() {
        return this.jk;
    }

    public u x() {
        return this.iz;
    }

    public void fx(String str) {
        this.n = str;
    }

    public void nr(long j) {
        this.pn = j;
    }

    public void u(JSONObject jSONObject) {
        this.jk = jSONObject;
    }

    public void nr(String str) {
        this.x = str;
    }

    public void u(Map<String, TreeMap<Float, String>> map) {
        this.u = map;
    }

    public void nr(int i) {
        this.f5043a = i;
    }

    public void u(long j) {
        this.nr = j;
    }

    public void u(int i) {
        this.fx = i;
    }

    public void u(String str) {
        this.b = str;
    }

    public void u(u uVar) {
        this.iz = uVar;
    }
}
