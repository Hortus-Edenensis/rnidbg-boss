package com.heytap.openid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface m_b extends IInterface {

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class m_a extends Binder implements m_b {

        /* JADX INFO: renamed from: com.heytap.openid.m_b$m_a$m_a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C0402m_a implements m_b {
            public IBinder m_a;

            public C0402m_a(IBinder iBinder) {
                this.m_a = iBinder;
            }

            @Override // android.os.IInterface
            public native IBinder asBinder();

            @Override // com.heytap.openid.m_b
            public native String m_b(String str, String str2, String str3);
        }

        public static native m_b m_a(IBinder iBinder);
    }

    String m_b(String str, String str2, String str3);
}
