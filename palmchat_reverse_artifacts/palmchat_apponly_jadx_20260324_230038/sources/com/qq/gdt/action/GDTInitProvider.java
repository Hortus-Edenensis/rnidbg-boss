package com.qq.gdt.action;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.qq.gdt.action.j.g;
import com.qq.gdt.action.j.o;
import com.qq.gdt.action.j.s;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class GDTInitProvider extends ContentProvider {
    /* JADX WARN: Removed duplicated region for block: B:14:0x0064  */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bundle call(String str, String str2, Bundle bundle) {
        byte b;
        o.a("get  method : " + str + ", arg: " + str2 + " , bundle: " + bundle.toString(), new Object[0]);
        bundle.setClassLoader(getClass().getClassLoader());
        final Bundle bundle2 = new Bundle();
        try {
            com.qq.gdt.action.h.a.a(3300);
            int iHashCode = str.hashCode();
            if (iHashCode != -606299040) {
                b = (iHashCode == 854044409 && str.equals("get_user_info")) ? (byte) 1 : (byte) -1;
            } else if (str.equals("save_user_info")) {
                b = 0;
            }
            if (b == 0) {
                com.qq.gdt.action.h.a.a(3301);
                com.qq.gdt.action.multioprocess.b bVar = (com.qq.gdt.action.multioprocess.b) bundle.getSerializable("user_message_info");
                o.a("cp save userMessage " + bVar, new Object[0]);
                if (bVar == null) {
                    com.qq.gdt.action.h.a.a(3303);
                    o.a("save null，end", new Object[0]);
                } else {
                    com.qq.gdt.action.multioprocess.d.a().f10548a = bVar;
                    s.a(bVar);
                    o.a("cp save end", new Object[0]);
                }
            } else if (b != 1) {
                com.qq.gdt.action.h.a.a(3302);
                o.a("cp not match method ", new Object[0]);
            } else {
                com.qq.gdt.action.h.a.a(3307);
                com.qq.gdt.action.multioprocess.b bVar2 = com.qq.gdt.action.multioprocess.d.a().f10548a;
                o.a("cp process get UserMessage = " + bVar2, new Object[0]);
                if (bVar2 != null) {
                    o.a("cp memory UserMessage not null", new Object[0]);
                    com.qq.gdt.action.h.a.a(3401, bVar2);
                    bundle2.putSerializable("result_user_info", bVar2);
                } else {
                    s.a(new com.qq.gdt.action.multioprocess.c() { // from class: com.qq.gdt.action.GDTInitProvider.1
                        @Override // com.qq.gdt.action.multioprocess.c
                        public void a(com.qq.gdt.action.multioprocess.b bVar3) {
                            if (bVar3 == null) {
                                o.a("save file not null, getUserMessage null", new Object[0]);
                                com.qq.gdt.action.h.a.a(3404);
                                return;
                            }
                            o.a("cp save file not null, memory update getUserMessage =  " + bVar3, new Object[0]);
                            com.qq.gdt.action.multioprocess.d.a().f10548a = bVar3;
                            bundle2.putSerializable("result_user_info", bVar3);
                            com.qq.gdt.action.h.a.a(3403, bVar3);
                        }
                    });
                }
            }
            o.a("cp return bundle = " + bundle2, new Object[0]);
            com.qq.gdt.action.h.a.a(3407);
            return bundle2;
        } catch (Throwable th) {
            o.a("bundle call e", th);
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        try {
            o.a("GDTInitProvider", "MySDKInitProvider onCreate >>> " + hashCode(), new Object[0]);
            g.a().a(true);
            g.a().f10529a = g.a.CP;
            return true;
        } catch (Exception e) {
            o.c("GDTInitProvider onCreate e = " + e.toString());
            return true;
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, String str3, Bundle bundle) {
        return super.call(str, str2, str3, bundle);
    }
}
