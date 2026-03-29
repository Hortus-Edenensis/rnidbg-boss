package com.tencent.turingfd.sdk.ams.ad;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Nucleus {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f10724a;
    public final Object b;
    public Process c;
    public DataOutputStream d;
    public Cdo e;
    public Cdo f;
    public ByteArrayOutputStream g;
    public ByteArrayOutputStream h;

    /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.Nucleus$do, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class Cdo extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public InputStream f10725a;
        public ByteArrayOutputStream b;

        public Cdo(String str, InputStream inputStream, ByteArrayOutputStream byteArrayOutputStream) {
            super(str);
            this.f10725a = inputStream;
            this.b = byteArrayOutputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            byte[] bArr;
            try {
                bArr = new byte[1024];
            } catch (Exception unused) {
                return;
            }
            while (true) {
                int i = this.f10725a.read(bArr);
                if (i < 0) {
                    synchronized (Nucleus.this.b) {
                        this.b.write(":RET=EOF".getBytes());
                        this.b.flush();
                    }
                    synchronized (Nucleus.this.f10724a) {
                        Nucleus.this.f10724a.notifyAll();
                    }
                    return;
                }
                if (i > 0) {
                    synchronized (Nucleus.this.b) {
                        this.b.write(bArr, 0, i);
                        this.b.flush();
                    }
                    synchronized (Nucleus.this.f10724a) {
                        Nucleus.this.f10724a.notifyAll();
                    }
                }
                return;
            }
        }
    }

    /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.Nucleus$for, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class Cfor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f10726a;
        public final String b;
        public final long c;

        public Cfor(String str, String str2, long j) {
            this.f10726a = str;
            this.b = str2;
            this.c = j;
        }
    }

    /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.Nucleus$if, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class Cif {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f10727a;
        public final String b;

        public Cif(String str, Integer num, String str2, String str3) {
            this.f10727a = str2;
            this.b = str3;
        }
    }

    public Nucleus(String str) throws InterruptedException, IOException, IllegalArgumentException {
        boolean z;
        Object obj = new Object();
        this.f10724a = obj;
        this.b = new Object();
        this.g = new ByteArrayOutputStream();
        this.h = new ByteArrayOutputStream();
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith("/") && !new File(str).exists()) {
            throw new FileNotFoundException();
        }
        this.c = Runtime.getRuntime().exec(str);
        synchronized (obj) {
            obj.wait(10L);
        }
        try {
            this.c.exitValue();
            z = true;
        } catch (Exception unused) {
            z = false;
        }
        if (z) {
            throw new IOException();
        }
        this.d = new DataOutputStream(this.c.getOutputStream());
        this.e = new Cdo("s", this.c.getInputStream(), this.g);
        this.f = new Cdo("e", this.c.getErrorStream(), this.h);
        synchronized (this.f10724a) {
            this.f10724a.wait(10L);
        }
        this.e.start();
        this.f.start();
    }

    public final Cif a(Cfor cfor, long j) throws InterruptedException {
        boolean z;
        synchronized (this.f10724a) {
            synchronized (this.b) {
                z = new String(this.g.toByteArray()).lastIndexOf(":RET=") == -1;
            }
            if (z) {
                this.f10724a.wait(j);
            }
        }
        synchronized (this.b) {
            byte[] byteArray = this.g.toByteArray();
            byte[] byteArray2 = this.h.toByteArray();
            String str = new String(byteArray);
            String str2 = new String(byteArray2);
            if (str.lastIndexOf(":RET=") == -1) {
                return null;
            }
            this.g.reset();
            this.h.reset();
            if (str.lastIndexOf(":RET=0") != -1) {
                return new Cif(cfor.f10726a, 0, str.substring(0, str.lastIndexOf(":RET=")), str2);
            }
            return new Cif(cfor.f10726a, Integer.valueOf((str.lastIndexOf(":RET=EOF") == -1 && str2.lastIndexOf(":RET=EOF") == -1) ? 1 : 2), str.substring(0, str.lastIndexOf(":RET=")), str2);
        }
    }

    public void finalize() throws Throwable {
        try {
            a();
        } catch (Throwable unused) {
        }
        super.finalize();
    }

    public final void a() {
        try {
            this.d.write("exit\n".getBytes());
            this.d.flush();
            this.c.wait(100L);
        } catch (Exception unused) {
        }
        Cdo cdo = this.e;
        if (cdo != null) {
            cdo.interrupt();
            this.e = null;
        }
        Cdo cdo2 = this.f;
        if (cdo2 != null) {
            cdo2.interrupt();
            this.f = null;
        }
        Process process = this.c;
        if (process != null) {
            try {
                process.destroy();
            } catch (Throwable unused2) {
            }
            this.c = null;
        }
    }

    public synchronized Cif a(Cfor cfor) throws InterruptedException, TimeoutException, IOException, IllegalArgumentException {
        Cif cifA;
        String str;
        if (cfor != null) {
            String str2 = cfor.f10726a;
            if (!(str2 == null || str2.length() <= 0 || (str = cfor.b) == null || str.length() <= 0) && cfor.c >= 0) {
                synchronized (this.b) {
                    this.g.reset();
                    this.h.reset();
                }
                this.d.write((cfor.b + "\n").getBytes());
                this.d.flush();
                synchronized (this.f10724a) {
                    this.f10724a.wait(10L);
                }
                this.d.writeBytes("echo :RET=$?\n");
                this.d.flush();
                long jNanoTime = System.nanoTime();
                long jNanoTime2 = 0;
                do {
                    long j = cfor.c;
                    if (j != 0) {
                        jNanoTime2 = j - ((System.nanoTime() - jNanoTime) / 1000000);
                        if (jNanoTime2 <= 0) {
                            throw new TimeoutException("t");
                        }
                    }
                    cifA = a(cfor, jNanoTime2);
                } while (cifA == null);
            }
        }
        throw new IllegalArgumentException("v");
        return cifA;
    }
}
