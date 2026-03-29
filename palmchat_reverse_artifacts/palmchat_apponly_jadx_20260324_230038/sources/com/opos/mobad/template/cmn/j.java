package com.opos.mobad.template.cmn;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.opos.mobad.d.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class j {

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(int i, Bitmap bitmap);

        void a(Bitmap bitmap);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        boolean a();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void a(int i);

        void a(Bitmap bitmap);
    }

    public static final void a(String str, String str2, int i, int i2, com.opos.mobad.d.a aVar, a aVar2, b bVar) {
        a(str, str2, Integer.valueOf(i), Integer.valueOf(i2), aVar, aVar2, bVar);
    }

    public static final void a(String str, String str2, int i, int i2, com.opos.mobad.d.a aVar, c cVar, b bVar) {
        a(str, str2, Integer.valueOf(i), Integer.valueOf(i2), aVar, cVar, bVar);
    }

    public static final void a(String str, String str2, com.opos.mobad.d.a aVar, a aVar2, b bVar) {
        a(str, str2, (Integer) null, (Integer) null, aVar, aVar2, bVar);
    }

    public static final void a(String str, String str2, com.opos.mobad.d.a aVar, c cVar, b bVar) {
        a(str, str2, (Integer) null, (Integer) null, aVar, cVar, bVar);
    }

    private static final void a(String str, String str2, Integer num, Integer num2, com.opos.mobad.d.a aVar, final a aVar2, final b bVar) {
        if (TextUtils.isEmpty(str) || aVar == null) {
            aVar2.a(-1000, null);
            return;
        }
        a.InterfaceC0732a interfaceC0732a = new a.InterfaceC0732a() { // from class: com.opos.mobad.template.cmn.j.2
            @Override // com.opos.mobad.d.a.InterfaceC0732a
            public void a(final int i, final Bitmap bitmap) {
                b bVar2 = bVar;
                if (bVar2 == null || !bVar2.a()) {
                    if (i == 0 || i == 1) {
                        com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.cmn.j.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                b bVar3 = bVar;
                                if (bVar3 == null || !bVar3.a()) {
                                    Bitmap bitmap2 = bitmap;
                                    if (bitmap2 == null || bitmap2.isRecycled()) {
                                        aVar2.a(-1000, null);
                                        return;
                                    }
                                    int i2 = i;
                                    if (i2 == 1) {
                                        aVar2.a(i2, bitmap);
                                    } else {
                                        aVar2.a(bitmap);
                                    }
                                }
                            }
                        });
                    } else {
                        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.cmn.j.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                b bVar3 = bVar;
                                if (bVar3 == null || !bVar3.a()) {
                                    aVar2.a(i, null);
                                }
                            }
                        });
                    }
                }
            }
        };
        if (num == null || num2 == null) {
            aVar.a(str, str2, interfaceC0732a);
        } else {
            aVar.a(str, str2, num.intValue(), num2.intValue(), interfaceC0732a);
        }
    }

    private static final void a(String str, String str2, Integer num, Integer num2, com.opos.mobad.d.a aVar, final c cVar, final b bVar) {
        if (TextUtils.isEmpty(str) || aVar == null) {
            cVar.a(-1000);
            return;
        }
        a.InterfaceC0732a interfaceC0732a = new a.InterfaceC0732a() { // from class: com.opos.mobad.template.cmn.j.1
            @Override // com.opos.mobad.d.a.InterfaceC0732a
            public void a(final int i, final Bitmap bitmap) {
                b bVar2 = bVar;
                if (bVar2 == null || !bVar2.a()) {
                    if (i == 0 || i == 1) {
                        com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.cmn.j.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                int i2 = i;
                                if (i2 == 1) {
                                    cVar.a(i2);
                                }
                                b bVar3 = bVar;
                                if (bVar3 == null || !bVar3.a()) {
                                    Bitmap bitmap2 = bitmap;
                                    if (bitmap2 == null || bitmap2.isRecycled()) {
                                        cVar.a(-1000);
                                    } else {
                                        cVar.a(bitmap);
                                    }
                                }
                            }
                        });
                    } else {
                        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.cmn.j.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                b bVar3 = bVar;
                                if (bVar3 == null || !bVar3.a()) {
                                    cVar.a(i);
                                }
                            }
                        });
                    }
                }
            }
        };
        if (num == null || num2 == null) {
            aVar.a(str, str2, interfaceC0732a);
        } else {
            aVar.a(str, str2, num.intValue(), num2.intValue(), interfaceC0732a);
        }
    }
}
