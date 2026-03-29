package com.huawei.openalliance.ad.utils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class bh implements Runnable {
    private static final String Code = "TaskWrapper";
    private Runnable V;

    public bh(Runnable runnable) {
        this.V = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = this.V;
        if (runnable != null) {
            try {
                runnable.run();
            } finally {
                try {
                } finally {
                }
            }
        }
    }
}
