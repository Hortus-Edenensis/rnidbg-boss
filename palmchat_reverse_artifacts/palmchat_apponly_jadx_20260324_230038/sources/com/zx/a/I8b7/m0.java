package com.zx.a.I8b7;

import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class m0 {
    public static void a(File file) {
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                a(new File(file2.getPath()));
            } else {
                file2.delete();
            }
        }
        if (file.listFiles().length <= 0) {
            file.delete();
        }
    }
}
