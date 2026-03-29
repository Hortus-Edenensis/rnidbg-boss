package com.qq.gdt.action.g;

import android.os.HandlerThread;
import android.os.Message;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f10521a;
    private final a b;

    private b() {
        HandlerThread handlerThread = new HandlerThread("recorder");
        handlerThread.start();
        this.b = new a(handlerThread.getLooper());
    }

    public static b a() {
        if (f10521a == null) {
            synchronized (b.class) {
                if (f10521a == null) {
                    f10521a = new b();
                }
            }
        }
        return f10521a;
    }

    public void b() {
        this.b.sendEmptyMessage(3);
    }

    public void a(com.qq.gdt.action.g.a.a... aVarArr) {
        ArrayList arrayList = new ArrayList();
        for (com.qq.gdt.action.g.a.a aVar : aVarArr) {
            if (aVar != null) {
                arrayList.add(aVar);
            }
        }
        Message messageObtainMessage = this.b.obtainMessage(2);
        messageObtainMessage.obj = arrayList;
        this.b.sendMessage(messageObtainMessage);
    }
}
