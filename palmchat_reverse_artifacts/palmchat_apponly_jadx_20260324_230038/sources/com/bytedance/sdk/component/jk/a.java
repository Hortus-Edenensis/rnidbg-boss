package com.bytedance.sdk.component.jk;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class a implements Comparable<a>, Runnable {
    private int mPriority;
    private String name;

    public a(String str, int i) {
        this.mPriority = 0;
        this.mPriority = i == 0 ? 5 : i;
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public void setPriority(int i) {
        this.mPriority = i;
    }

    @Override // java.lang.Comparable
    public int compareTo(a aVar) {
        if (getPriority() < aVar.getPriority()) {
            return 1;
        }
        return getPriority() >= aVar.getPriority() ? -1 : 0;
    }

    public a(String str) {
        this.mPriority = 5;
        this.name = str;
    }
}
