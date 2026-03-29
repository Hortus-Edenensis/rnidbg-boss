package com.zenmen.palmchat.location;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class LocationClientOption {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LocationMode f14323a = LocationMode.High_Accuracy;
    public int b = 5000;
    public boolean c = true;
    public int d;

    /* JADX INFO: compiled from: SearchBox */
    public enum LocationMode {
        High_Accuracy,
        Battery_Saving
    }

    public int a() {
        return this.d;
    }

    public LocationMode b() {
        return this.f14323a;
    }

    public boolean c() {
        return this.c;
    }

    public void d(int i) {
        this.d = i;
    }

    public void e(LocationMode locationMode) {
        this.f14323a = locationMode;
    }

    public void f(boolean z) {
        this.c = z;
    }
}
