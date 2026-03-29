package defpackage;

import android.graphics.Color;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.framework.R$string;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class c6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1897a = 3;
    public int b = 5;
    public int c = 8;
    public int d = 0;
    public int e = 4;
    public String f = c.b().getResources().getString(R$string.ad_moments_name);
    public String g = c.b().getResources().getString(R$string.ad_moments_default_desc);
    public String h = "";
    public int i = 1;
    public int j = 60;
    public int k = 50;
    public int l = 500;
    public int m = Color.parseColor("#B3000000");
    public int n = Color.parseColor("#99FFFFFF");
    public int o = Color.parseColor("#FFFFFF");

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append("limit=" + this.f1897a);
        sb.append(",firstAd=" + this.b);
        sb.append(",gapLength=" + this.c);
        sb.append(",firstAdRequestTime=" + this.d);
        sb.append(",adRequestTime=" + this.e);
        sb.append(",appName=" + this.f);
        sb.append(",adTitle=" + this.g);
        sb.append(",inFor=" + this.h);
        sb.append(",min1=" + this.i);
        sb.append(",max1=" + this.j);
        sb.append(",min2=" + this.k);
        sb.append(",max2=" + this.l);
        sb.append(",buttonColor=#" + Integer.toHexString(this.m));
        sb.append(",borderColor=#" + Integer.toHexString(this.n));
        sb.append(",textColor=#" + Integer.toHexString(this.o));
        sb.append("]");
        return sb.toString();
    }
}
