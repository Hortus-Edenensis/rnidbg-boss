package com.bytedance.sdk.openadsdk.core.kj;

import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONArray f5308a;
    private String b;
    private String fx;
    private String iz;
    private String jk;
    private float l;
    private JSONArray mv;
    private String n;
    private String nr;
    private String pn;
    private HashMap<String, String> s = new HashMap<>();
    private String t;
    private String u;
    private String x;

    public String a() {
        return this.iz;
    }

    public JSONArray b() {
        return this.mv;
    }

    public float fx() {
        return this.l;
    }

    public String iz() {
        return this.nr;
    }

    public String jk() {
        return this.x;
    }

    public JSONArray l() {
        return this.f5308a;
    }

    public String mv() {
        return this.jk;
    }

    public String n() {
        return this.b;
    }

    public String nr() {
        return this.pn;
    }

    public String pn() {
        return this.u;
    }

    public String s() {
        return this.t;
    }

    public String t() {
        return this.n;
    }

    public void u(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.s.put(str, str2);
    }

    public String x() {
        return this.fx;
    }

    public void a(String str) {
        this.jk = str;
    }

    public void b(String str) {
        this.fx = str;
    }

    public void fx(String str) {
        this.nr = str;
    }

    public void iz(String str) {
        this.iz = str;
    }

    public void jk(String str) {
        this.t = str;
    }

    public void n(String str) {
        this.n = str;
    }

    public void nr(String str) {
        this.u = str;
    }

    public void pn(String str) {
        this.b = str;
    }

    public void x(String str) {
        this.x = str;
    }

    public void nr(JSONArray jSONArray) {
        this.f5308a = jSONArray;
    }

    public HashMap<String, String> u() {
        return this.s;
    }

    public void u(String str) {
        this.pn = str;
    }

    public void u(float f) {
        this.l = f;
    }

    public void u(JSONArray jSONArray) {
        this.mv = jSONArray;
    }
}
