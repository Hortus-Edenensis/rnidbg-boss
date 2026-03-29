package com.tencent.turingfd.sdk.ams.ad;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.huawei.openalliance.ad.constant.x;
import com.ss.bytertc.engine.type.WarningCode;
import com.tencent.turingfd.sdk.ams.ad.Bootes;
import com.zenmen.palmchat.utils.EncryptUtils;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Cumquat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f10685a = Cfinally.a(Cfinally.G0);

    /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.Cumquat$do, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class Cdo implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f10686a;
        public final /* synthetic */ long b;
        public final /* synthetic */ Object c;

        /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.Cumquat$do$do, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C0895do extends Thread {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ IBinder f10687a;

            public C0895do(IBinder iBinder) {
                this.f10687a = iBinder;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Bootes c0894do;
                int i;
                IBinder iBinder = this.f10687a;
                String str = Bootes.Cdo.f10667a;
                if (iBinder == null) {
                    c0894do = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(Bootes.Cdo.f10667a);
                    c0894do = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof Bootes)) ? new Bootes.Cdo.C0894do(iBinder) : (Bootes) iInterfaceQueryLocalInterface;
                }
                try {
                    if (c0894do.c(2000)) {
                        i = 0;
                    } else {
                        c0894do.b(2000);
                        i = 1;
                    }
                } catch (Throwable unused) {
                    i = -1;
                }
                try {
                    Cif cifA = Cumquat.a(c0894do.d(2000).b);
                    int i2 = cifA.f10688a;
                    if (i2 != 0) {
                        Cdo.this.f10686a.set(Coconut.a(i2, i));
                    } else {
                        Cdo.this.f10686a.set(new Coconut(0, 200, System.currentTimeMillis() - Cdo.this.b, cifA.b.c, c0894do.a(), i));
                    }
                } catch (Throwable unused2) {
                    Cdo.this.f10686a.set(Coconut.a(WarningCode.WARNING_CODE_SUBSCRIBE_STREAM_FAILED404, i));
                }
                synchronized (Cdo.this.c) {
                    Cdo.this.c.notify();
                }
                if (Kiwifruit.f.a("s_t_d_ask", false)) {
                    try {
                        c0894do.a(2000);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public Cdo(AtomicReference atomicReference, long j, Object obj) {
            this.f10686a = atomicReference;
            this.b = j;
            this.c = obj;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            new C0895do(iBinder).start();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            this.f10686a.set(Coconut.a(WarningCode.WARNING_CODE_SUBSCRIBE_STREAM_FAILED5XX, -3));
            synchronized (this.c) {
                this.c.notify();
            }
        }
    }

    /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.Cumquat$if, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class Cif {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f10688a;
        public Cranberry b;

        public Cif(int i, Cranberry cranberry) {
            this.f10688a = i;
            this.b = cranberry;
        }
    }

    public static Coconut a() {
        String name;
        StringBuilder sb;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            Method method = Class.forName(Cfinally.a(Cfinally.H0)).getMethod(Cfinally.a(Cfinally.I0), new Class[0]);
            method.setAccessible(true);
            method.invoke(null, new Object[0]);
            Provider[] providers = Security.getProviders();
            if (providers == null) {
                return Coconut.a(-1201);
            }
            int length = providers.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    name = providers[i].getName();
                    if (name != null && name.startsWith(f10685a)) {
                        break;
                    }
                    i++;
                } else {
                    name = null;
                    break;
                }
            }
            if (TextUtils.isEmpty(name)) {
                return Coconut.a(-1202);
            }
            boolean z = name.split("\\.").length > 1;
            try {
                KeyStore keyStore = KeyStore.getInstance(name);
                keyStore.load(null);
                int iMyUid = Process.myUid();
                try {
                    sb = new StringBuilder();
                    sb.append("dddd");
                    sb.append(iMyUid);
                } catch (Throwable unused) {
                }
                boolean z2 = keyStore.getCertificate(sb.toString()) != null;
                if (!z2) {
                    try {
                        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(EncryptUtils.RSA_ENCRYPT_ALGORITHM, name);
                        try {
                            try {
                                keyPairGenerator.initialize(GalacticCore.a("dddd" + iMyUid + Cfinally.a(Cfinally.J0), z ? 16 : 4).a(x.dW).b("PSS").a());
                                try {
                                    keyPairGenerator.generateKeyPair();
                                } catch (Throwable unused2) {
                                }
                            } catch (InvalidAlgorithmParameterException unused3) {
                                return Coconut.a(-1701);
                            }
                        } catch (ClassNotFoundException unused4) {
                            return Coconut.a(-1601);
                        } catch (IllegalAccessException unused5) {
                            return Coconut.a(-1603);
                        } catch (InstantiationException unused6) {
                            return Coconut.a(-1605);
                        } catch (NoSuchMethodException unused7) {
                            return Coconut.a(-1602);
                        } catch (InvocationTargetException unused8) {
                            return Coconut.a(-1604);
                        }
                    } catch (NoSuchAlgorithmException unused9) {
                        return Coconut.a(-1501);
                    } catch (NoSuchProviderException unused10) {
                        return Coconut.a(-1502);
                    }
                }
                if (z) {
                    try {
                        return new Coconut(0, 100, System.currentTimeMillis() - jCurrentTimeMillis, new Cranberry(keyStore.getCertificateChain("dddd" + iMyUid)).c, -1, -2);
                    } catch (KeyStoreException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        Key key = keyStore.getKey("dddd" + iMyUid, Cfinally.a(Cfinally.K0).toCharArray());
                        if (key != null) {
                            Cif cifA = a(key.getEncoded());
                            int i2 = cifA.f10688a;
                            if (i2 != 0) {
                                return Coconut.a(i2);
                            }
                            Cranberry cranberry = cifA.b;
                            if (Kiwifruit.f.a("s_t_d_entry", false)) {
                                try {
                                    keyStore.deleteEntry("dddd" + iMyUid);
                                } catch (Throwable unused11) {
                                }
                            }
                            return new Coconut(0, 100, System.currentTimeMillis() - jCurrentTimeMillis, cranberry.c, -1, -2);
                        }
                    } catch (KeyStoreException unused12) {
                        return Coconut.a(-1801);
                    } catch (NoSuchAlgorithmException unused13) {
                        return Coconut.a(-1802);
                    } catch (UnrecoverableKeyException unused14) {
                        return Coconut.a(-1803);
                    }
                }
                return Coconut.a(-1901);
            } catch (IOException unused15) {
                return Coconut.a(-1303);
            } catch (KeyStoreException unused16) {
                return Coconut.a(-1301);
            } catch (NoSuchAlgorithmException unused17) {
                return Coconut.a(-1304);
            } catch (CertificateException unused18) {
                return Coconut.a(-1302);
            }
        } catch (ClassNotFoundException unused19) {
            return Coconut.a(-1104);
        } catch (IllegalAccessException unused20) {
            return Coconut.a(-1103);
        } catch (NoSuchMethodException unused21) {
            return Coconut.a(-1102);
        } catch (InvocationTargetException unused22) {
            return Coconut.a(-1101);
        }
    }

    public static Coconut a(Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Intent intent = new Intent();
        intent.setAction(Cfinally.a(Cfinally.L0));
        intent.setPackage(Cfinally.a(Cfinally.M0));
        Object obj = new Object();
        AtomicReference atomicReference = new AtomicReference();
        atomicReference.set(Coconut.a(WarningCode.WARNING_CODE_JOIN_ROOM_FAILED, -1));
        if (context.getApplicationContext().bindService(intent, new Cdo(atomicReference, jCurrentTimeMillis, obj), 1)) {
            synchronized (obj) {
                try {
                    obj.wait(5000L);
                } catch (InterruptedException unused) {
                }
            }
        } else {
            atomicReference.set(Coconut.a(WarningCode.WARNING_CODE_PUBLISH_STREAM_FAILED, -1));
        }
        return (Coconut) atomicReference.get();
    }

    public static Cif a(byte[] bArr) {
        if (bArr == null) {
            return new Cif(AVMDLDataLoader.AVMDLErrorIsStatusCodeMoreThan500, null);
        }
        if (bArr.length < 4) {
            return new Cif(AVMDLDataLoader.AVMDLErrorIsStatusCodeMoreThan500, null);
        }
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            i += (bArr2[i2] & 255) << (i2 * 8);
        }
        if (i > 1048576) {
            return new Cif(-3003, null);
        }
        byte[] bArr3 = new byte[i];
        int i3 = i + 4;
        if (bArr.length < i3) {
            return new Cif(-3004, null);
        }
        System.arraycopy(bArr, 4, bArr3, 0, i);
        Cranberry cranberry = new Cranberry(new String(bArr3), "");
        int length = bArr.length - i3;
        if (length != 0) {
            byte[] bArr4 = new byte[length];
            System.arraycopy(bArr, i3, bArr4, 0, length);
            Base64.encodeToString(bArr4, 2);
            return new Cif(0, cranberry);
        }
        return new Cif(-3005, null);
    }
}
