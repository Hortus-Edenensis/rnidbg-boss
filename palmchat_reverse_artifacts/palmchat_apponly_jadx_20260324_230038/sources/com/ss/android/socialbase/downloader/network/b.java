package com.ss.android.socialbase.downloader.network;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class b {
    private int b;
    private double fx = -1.0d;
    private final int nr;
    private final double u;

    public b(double d) {
        this.u = d;
        this.nr = d == 0.0d ? Integer.MAX_VALUE : (int) Math.ceil(1.0d / d);
    }

    public void u(double d) {
        double d2 = 1.0d - this.u;
        int i = this.b;
        if (i > this.nr) {
            this.fx = Math.exp((d2 * Math.log(this.fx)) + (this.u * Math.log(d)));
        } else if (i > 0) {
            double d3 = (d2 * ((double) i)) / (((double) i) + 1.0d);
            this.fx = Math.exp((d3 * Math.log(this.fx)) + ((1.0d - d3) * Math.log(d)));
        } else {
            this.fx = d;
        }
        this.b++;
    }

    public double u() {
        return this.fx;
    }
}
