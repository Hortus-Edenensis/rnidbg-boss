package defpackage;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.media3.muxer.MuxerUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.UByte;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderSignature;
import net.lingala.zip4j.model.enums.AesKeyStrength;
import net.lingala.zip4j.model.enums.AesVersion;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class zg2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public fr6 f22407a;
    public final dt4 b = new dt4();
    public final byte[] c = new byte[4];

    public final long a(fr6 fr6Var) {
        return fr6Var.h() ? fr6Var.e().e() : fr6Var.c().e();
    }

    public boolean b(byte[] bArr, String str) {
        byte b = bArr[0];
        if (b != 0 && nt.a(b, 4)) {
            return true;
        }
        byte b2 = bArr[3];
        if (b2 != 0 && nt.a(b2, 6)) {
            return true;
        }
        if (str != null) {
            return str.endsWith("/") || str.endsWith("\\");
        }
        return false;
    }

    public final long c(RandomAccessFile randomAccessFile) throws IOException {
        long length = randomAccessFile.length();
        if (length < 22) {
            throw new ZipException("Zip file size less than size of zip headers. Probably not a zip file.");
        }
        long j = length - 22;
        x(randomAccessFile, j);
        return ((long) this.b.c(randomAccessFile)) == HeaderSignature.END_OF_CENTRAL_DIRECTORY.getValue() ? j : d(randomAccessFile);
    }

    public final long d(RandomAccessFile randomAccessFile) throws IOException {
        long length = randomAccessFile.length() - 22;
        long length2 = randomAccessFile.length();
        long length3 = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        if (length2 < PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
            length3 = randomAccessFile.length();
        }
        while (length3 > 0 && length > 0) {
            length--;
            x(randomAccessFile, length);
            if (this.b.c(randomAccessFile) == HeaderSignature.END_OF_CENTRAL_DIRECTORY.getValue()) {
                return length;
            }
            length3--;
        }
        throw new ZipException("Zip headers not found. Probably not a zip file");
    }

    public final List<is1> e(byte[] bArr, int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < i) {
            is1 is1Var = new is1();
            is1Var.f(this.b.m(bArr, i2));
            int i3 = i2 + 2;
            int iM = this.b.m(bArr, i3);
            is1Var.g(iM);
            int i4 = i3 + 2;
            if (iM > 0) {
                byte[] bArr2 = new byte[iM];
                System.arraycopy(bArr, i4, bArr2, 0, iM);
                is1Var.e(bArr2);
            }
            i2 = i4 + iM;
            arrayList.add(is1Var);
        }
        if (arrayList.size() > 0) {
            return arrayList;
        }
        return null;
    }

    public final f f(List<is1> list, dt4 dt4Var) throws ZipException {
        if (list == null) {
            return null;
        }
        for (is1 is1Var : list) {
            if (is1Var != null) {
                long jC = is1Var.c();
                HeaderSignature headerSignature = HeaderSignature.AES_EXTRA_DATA_RECORD;
                if (jC == headerSignature.getValue()) {
                    if (is1Var.b() == null) {
                        throw new ZipException("corrupt AES extra data records");
                    }
                    f fVar = new f();
                    fVar.a(headerSignature);
                    fVar.h(is1Var.d());
                    byte[] bArrB = is1Var.b();
                    fVar.f(AesVersion.getFromVersionNumber(dt4Var.m(bArrB, 0)));
                    byte[] bArr = new byte[2];
                    System.arraycopy(bArrB, 2, bArr, 0, 2);
                    fVar.i(new String(bArr));
                    fVar.e(AesKeyStrength.getAesKeyStrengthFromRawCode(bArrB[4] & UByte.MAX_VALUE));
                    fVar.g(CompressionMethod.getCompressionMethodFromCode(dt4Var.m(bArrB, 5)));
                    return fVar;
                }
            }
        }
        return null;
    }

    public final void g(eu1 eu1Var, dt4 dt4Var) throws ZipException {
        f fVarF;
        if (eu1Var.g() == null || eu1Var.g().size() <= 0 || (fVarF = f(eu1Var.g(), dt4Var)) == null) {
            return;
        }
        eu1Var.r(fVarF);
        eu1Var.y(EncryptionMethod.AES);
    }

    public final void h(u43 u43Var, dt4 dt4Var) throws ZipException {
        f fVarF;
        if (u43Var.g() == null || u43Var.g().size() <= 0 || (fVarF = f(u43Var.g(), dt4Var)) == null) {
            return;
        }
        u43Var.r(fVarF);
        u43Var.y(EncryptionMethod.AES);
    }

    public fr6 i(RandomAccessFile randomAccessFile, vq6 vq6Var) throws IOException {
        if (randomAccessFile.length() < 22) {
            throw new ZipException("Zip file size less than minimum expected zip file size. Probably not a zip file or a corrupted zip file");
        }
        fr6 fr6Var = new fr6();
        this.f22407a = fr6Var;
        try {
            fr6Var.j(l(randomAccessFile, this.b, vq6Var));
            if (this.f22407a.c().e() == 0) {
                return this.f22407a;
            }
            fr6 fr6Var2 = this.f22407a;
            fr6Var2.l(s(randomAccessFile, this.b, fr6Var2.c().c()));
            if (this.f22407a.h()) {
                this.f22407a.m(r(randomAccessFile, this.b));
                if (this.f22407a.e() == null || this.f22407a.e().b() <= 0) {
                    this.f22407a.k(false);
                } else {
                    this.f22407a.k(true);
                }
            }
            this.f22407a.i(j(randomAccessFile, this.b, vq6Var.b()));
            return this.f22407a;
        } catch (ZipException e) {
            throw e;
        } catch (IOException e2) {
            e2.printStackTrace();
            throw new ZipException("Zip headers not found. Probably not a zip file or a corrupted zip file", e2);
        }
    }

    public final b00 j(RandomAccessFile randomAccessFile, dt4 dt4Var, Charset charset) throws IOException {
        b00 b00Var = new b00();
        ArrayList arrayList = new ArrayList();
        long jB = ah2.b(this.f22407a);
        long jA = a(this.f22407a);
        randomAccessFile.seek(jB);
        int i = 2;
        byte[] bArr = new byte[2];
        byte[] bArr2 = new byte[4];
        int i2 = 0;
        int i3 = 0;
        while (i3 < jA) {
            eu1 eu1Var = new eu1();
            byte[] bArr3 = bArr2;
            long jC = dt4Var.c(randomAccessFile);
            HeaderSignature headerSignature = HeaderSignature.CENTRAL_DIRECTORY;
            if (jC != headerSignature.getValue()) {
                throw new ZipException("Expected central directory entry not found (#" + (i3 + 1) + ")");
            }
            eu1Var.a(headerSignature);
            eu1Var.S(dt4Var.l(randomAccessFile));
            eu1Var.H(dt4Var.l(randomAccessFile));
            byte[] bArr4 = new byte[i];
            randomAccessFile.readFully(bArr4);
            eu1Var.x(nt.a(bArr4[i2], i2));
            eu1Var.v(nt.a(bArr4[i2], 3));
            eu1Var.D(nt.a(bArr4[1], 3));
            eu1Var.E((byte[]) bArr4.clone());
            eu1Var.t(CompressionMethod.getCompressionMethodFromCode(dt4Var.l(randomAccessFile)));
            eu1Var.F(dt4Var.c(randomAccessFile));
            randomAccessFile.readFully(bArr3);
            byte[] bArr5 = bArr;
            eu1Var.u(dt4Var.j(bArr3, i2));
            eu1Var.s(dt4Var.i(randomAccessFile, 4));
            eu1Var.G(dt4Var.i(randomAccessFile, 4));
            int iL = dt4Var.l(randomAccessFile);
            eu1Var.C(iL);
            eu1Var.A(dt4Var.l(randomAccessFile));
            int iL2 = dt4Var.l(randomAccessFile);
            eu1Var.P(iL2);
            eu1Var.M(dt4Var.l(randomAccessFile));
            randomAccessFile.readFully(bArr5);
            eu1Var.Q((byte[]) bArr5.clone());
            randomAccessFile.readFully(bArr3);
            eu1Var.N((byte[]) bArr3.clone());
            randomAccessFile.readFully(bArr3);
            long j = jA;
            eu1Var.R(dt4Var.j(bArr3, 0));
            if (iL > 0) {
                byte[] bArr6 = new byte[iL];
                randomAccessFile.readFully(bArr6);
                String strA = ah2.a(bArr6, eu1Var.q(), charset);
                if (strA.contains(":\\")) {
                    strA = strA.substring(strA.indexOf(":\\") + 2);
                }
                eu1Var.B(strA);
            } else {
                eu1Var.B(null);
            }
            eu1Var.w(b(eu1Var.K(), eu1Var.i()));
            p(randomAccessFile, eu1Var);
            u(eu1Var, dt4Var);
            g(eu1Var, dt4Var);
            if (iL2 > 0) {
                byte[] bArr7 = new byte[iL2];
                randomAccessFile.readFully(bArr7);
                eu1Var.O(ah2.a(bArr7, eu1Var.q(), charset));
            }
            if (eu1Var.p()) {
                if (eu1Var.b() != null) {
                    eu1Var.y(EncryptionMethod.AES);
                } else {
                    eu1Var.y(EncryptionMethod.ZIP_STANDARD);
                }
            }
            arrayList.add(eu1Var);
            i3++;
            bArr = bArr5;
            bArr2 = bArr3;
            jA = j;
            i = 2;
            i2 = 0;
        }
        b00Var.b(arrayList);
        fd1 fd1Var = new fd1();
        long jC2 = dt4Var.c(randomAccessFile);
        HeaderSignature headerSignature2 = HeaderSignature.DIGITAL_SIGNATURE;
        if (jC2 == headerSignature2.getValue()) {
            fd1Var.a(headerSignature2);
            fd1Var.d(dt4Var.l(randomAccessFile));
            if (fd1Var.b() > 0) {
                byte[] bArr8 = new byte[fd1Var.b()];
                randomAccessFile.readFully(bArr8);
                fd1Var.c(new String(bArr8));
            }
        }
        return b00Var;
    }

    public mu0 k(InputStream inputStream, boolean z) throws IOException {
        mu0 mu0Var = new mu0();
        byte[] bArr = new byte[4];
        wq6.g(inputStream, bArr);
        long j = this.b.j(bArr, 0);
        HeaderSignature headerSignature = HeaderSignature.EXTRA_DATA_RECORD;
        if (j == headerSignature.getValue()) {
            mu0Var.a(headerSignature);
            wq6.g(inputStream, bArr);
            mu0Var.f(this.b.j(bArr, 0));
        } else {
            mu0Var.f(j);
        }
        if (z) {
            mu0Var.e(this.b.f(inputStream));
            mu0Var.g(this.b.f(inputStream));
        } else {
            mu0Var.e(this.b.b(inputStream));
            mu0Var.g(this.b.b(inputStream));
        }
        return mu0Var;
    }

    public final qm1 l(RandomAccessFile randomAccessFile, dt4 dt4Var, vq6 vq6Var) throws IOException {
        long jC = c(randomAccessFile);
        x(randomAccessFile, 4 + jC);
        qm1 qm1Var = new qm1();
        qm1Var.a(HeaderSignature.END_OF_CENTRAL_DIRECTORY);
        qm1Var.g(dt4Var.l(randomAccessFile));
        qm1Var.h(dt4Var.l(randomAccessFile));
        qm1Var.m(dt4Var.l(randomAccessFile));
        qm1Var.l(dt4Var.l(randomAccessFile));
        qm1Var.k(dt4Var.c(randomAccessFile));
        qm1Var.i(jC);
        randomAccessFile.readFully(this.c);
        qm1Var.j(dt4Var.j(this.c, 0));
        qm1Var.f(w(randomAccessFile, dt4Var.l(randomAccessFile), vq6Var.b()));
        this.f22407a.k(qm1Var.b() > 0);
        return qm1Var;
    }

    public final List<is1> m(InputStream inputStream, int i) throws IOException {
        if (i < 4) {
            if (i <= 0) {
                return null;
            }
            inputStream.skip(i);
            return null;
        }
        byte[] bArr = new byte[i];
        wq6.g(inputStream, bArr);
        try {
            return e(bArr, i);
        } catch (Exception unused) {
            return Collections.emptyList();
        }
    }

    public final List<is1> n(RandomAccessFile randomAccessFile, int i) throws IOException {
        if (i < 4) {
            if (i <= 0) {
                return null;
            }
            randomAccessFile.skipBytes(i);
            return null;
        }
        byte[] bArr = new byte[i];
        randomAccessFile.read(bArr);
        try {
            return e(bArr, i);
        } catch (Exception unused) {
            return Collections.emptyList();
        }
    }

    public final void o(InputStream inputStream, u43 u43Var) throws IOException {
        int iH = u43Var.h();
        if (iH <= 0) {
            return;
        }
        u43Var.z(m(inputStream, iH));
    }

    public final void p(RandomAccessFile randomAccessFile, eu1 eu1Var) throws IOException {
        int iH = eu1Var.h();
        if (iH <= 0) {
            return;
        }
        eu1Var.z(n(randomAccessFile, iH));
    }

    public u43 q(InputStream inputStream, Charset charset) throws IOException {
        u43 u43Var = new u43();
        byte[] bArr = new byte[4];
        int iB = this.b.b(inputStream);
        if (iB == HeaderSignature.TEMPORARY_SPANNING_MARKER.getValue()) {
            iB = this.b.b(inputStream);
        }
        long j = iB;
        HeaderSignature headerSignature = HeaderSignature.LOCAL_FILE_HEADER;
        if (j != headerSignature.getValue()) {
            return null;
        }
        u43Var.a(headerSignature);
        u43Var.H(this.b.k(inputStream));
        byte[] bArr2 = new byte[2];
        if (wq6.g(inputStream, bArr2) != 2) {
            throw new ZipException("Could not read enough bytes for generalPurposeFlags");
        }
        u43Var.x(nt.a(bArr2[0], 0));
        u43Var.v(nt.a(bArr2[0], 3));
        boolean z = true;
        u43Var.D(nt.a(bArr2[1], 3));
        u43Var.E((byte[]) bArr2.clone());
        u43Var.t(CompressionMethod.getCompressionMethodFromCode(this.b.k(inputStream)));
        u43Var.F(this.b.b(inputStream));
        wq6.g(inputStream, bArr);
        u43Var.u(this.b.j(bArr, 0));
        u43Var.s(this.b.g(inputStream, 4));
        u43Var.G(this.b.g(inputStream, 4));
        int iK = this.b.k(inputStream);
        u43Var.C(iK);
        u43Var.A(this.b.k(inputStream));
        if (iK > 0) {
            byte[] bArr3 = new byte[iK];
            wq6.g(inputStream, bArr3);
            String strA = ah2.a(bArr3, u43Var.q(), charset);
            if (strA.contains(":" + System.getProperty("file.separator"))) {
                strA = strA.substring(strA.indexOf(":" + System.getProperty("file.separator")) + 2);
            }
            u43Var.B(strA);
            if (!strA.endsWith("/") && !strA.endsWith("\\")) {
                z = false;
            }
            u43Var.w(z);
        } else {
            u43Var.B(null);
        }
        o(inputStream, u43Var);
        v(u43Var, this.b);
        h(u43Var, this.b);
        if (u43Var.p() && u43Var.f() != EncryptionMethod.AES) {
            if (nt.a(u43Var.j()[0], 6)) {
                u43Var.y(EncryptionMethod.ZIP_STANDARD_VARIANT_STRONG);
            } else {
                u43Var.y(EncryptionMethod.ZIP_STANDARD);
            }
        }
        return u43Var;
    }

    public final yq6 r(RandomAccessFile randomAccessFile, dt4 dt4Var) throws IOException {
        if (this.f22407a.d() == null) {
            throw new ZipException("invalid zip64 end of central directory locator");
        }
        long jB = this.f22407a.d().b();
        if (jB < 0) {
            throw new ZipException("invalid offset for start of end of central directory record");
        }
        randomAccessFile.seek(jB);
        yq6 yq6Var = new yq6();
        long jC = dt4Var.c(randomAccessFile);
        HeaderSignature headerSignature = HeaderSignature.ZIP64_END_CENTRAL_DIRECTORY_RECORD;
        if (jC != headerSignature.getValue()) {
            throw new ZipException("invalid signature for zip64 end of central directory record");
        }
        yq6Var.a(headerSignature);
        yq6Var.k(dt4Var.h(randomAccessFile));
        yq6Var.n(dt4Var.l(randomAccessFile));
        yq6Var.o(dt4Var.l(randomAccessFile));
        yq6Var.g(dt4Var.c(randomAccessFile));
        yq6Var.h(dt4Var.c(randomAccessFile));
        yq6Var.m(dt4Var.h(randomAccessFile));
        yq6Var.l(dt4Var.h(randomAccessFile));
        yq6Var.j(dt4Var.h(randomAccessFile));
        yq6Var.i(dt4Var.h(randomAccessFile));
        long jD = yq6Var.d() - 44;
        if (jD > 0) {
            byte[] bArr = new byte[(int) jD];
            randomAccessFile.readFully(bArr);
            yq6Var.f(bArr);
        }
        return yq6Var;
    }

    public final xq6 s(RandomAccessFile randomAccessFile, dt4 dt4Var, long j) throws IOException {
        xq6 xq6Var = new xq6();
        y(randomAccessFile, j);
        long jC = dt4Var.c(randomAccessFile);
        HeaderSignature headerSignature = HeaderSignature.ZIP64_END_CENTRAL_DIRECTORY_LOCATOR;
        if (jC != headerSignature.getValue()) {
            this.f22407a.n(false);
            return null;
        }
        this.f22407a.n(true);
        xq6Var.a(headerSignature);
        xq6Var.c(dt4Var.c(randomAccessFile));
        xq6Var.d(dt4Var.h(randomAccessFile));
        xq6Var.e(dt4Var.c(randomAccessFile));
        return xq6Var;
    }

    public final zq6 t(List<is1> list, dt4 dt4Var, long j, long j2, long j3, int i) {
        for (is1 is1Var : list) {
            if (is1Var != null && HeaderSignature.ZIP64_EXTRA_FIELD_SIGNATURE.getValue() == is1Var.c()) {
                zq6 zq6Var = new zq6();
                byte[] bArrB = is1Var.b();
                if (is1Var.d() <= 0) {
                    return null;
                }
                int i2 = 0;
                if (is1Var.d() > 0 && j == MuxerUtil.UNSIGNED_INT_MAX_VALUE) {
                    zq6Var.i(dt4Var.j(bArrB, 0));
                    i2 = 8;
                }
                if (i2 < is1Var.d() && j2 == MuxerUtil.UNSIGNED_INT_MAX_VALUE) {
                    zq6Var.f(dt4Var.j(bArrB, i2));
                    i2 += 8;
                }
                if (i2 < is1Var.d() && j3 == MuxerUtil.UNSIGNED_INT_MAX_VALUE) {
                    zq6Var.h(dt4Var.j(bArrB, i2));
                    i2 += 8;
                }
                if (i2 < is1Var.d() && i == 65535) {
                    zq6Var.g(dt4Var.e(bArrB, i2));
                }
                return zq6Var;
            }
        }
        return null;
    }

    public final void u(eu1 eu1Var, dt4 dt4Var) {
        zq6 zq6VarT;
        if (eu1Var.g() == null || eu1Var.g().size() <= 0 || (zq6VarT = t(eu1Var.g(), dt4Var, eu1Var.l(), eu1Var.c(), eu1Var.L(), eu1Var.J())) == null) {
            return;
        }
        eu1Var.I(zq6VarT);
        if (zq6VarT.e() != -1) {
            eu1Var.G(zq6VarT.e());
        }
        if (zq6VarT.b() != -1) {
            eu1Var.s(zq6VarT.b());
        }
        if (zq6VarT.d() != -1) {
            eu1Var.R(zq6VarT.d());
        }
        if (zq6VarT.c() != -1) {
            eu1Var.M(zq6VarT.c());
        }
    }

    public final void v(u43 u43Var, dt4 dt4Var) throws ZipException {
        zq6 zq6VarT;
        if (u43Var == null) {
            throw new ZipException("file header is null in reading Zip64 Extended Info");
        }
        if (u43Var.g() == null || u43Var.g().size() <= 0 || (zq6VarT = t(u43Var.g(), dt4Var, u43Var.l(), u43Var.c(), 0L, 0)) == null) {
            return;
        }
        u43Var.I(zq6VarT);
        if (zq6VarT.e() != -1) {
            u43Var.G(zq6VarT.e());
        }
        if (zq6VarT.b() != -1) {
            u43Var.s(zq6VarT.b());
        }
    }

    public final String w(RandomAccessFile randomAccessFile, int i, Charset charset) {
        if (i <= 0) {
            return null;
        }
        try {
            byte[] bArr = new byte[i];
            randomAccessFile.readFully(bArr);
            if (charset == null) {
                charset = au2.c;
            }
            return ah2.a(bArr, false, charset);
        } catch (IOException unused) {
            return null;
        }
    }

    public final void x(RandomAccessFile randomAccessFile, long j) throws IOException {
        if (randomAccessFile instanceof e44) {
            ((e44) randomAccessFile).e(j);
        } else {
            randomAccessFile.seek(j);
        }
    }

    public final void y(RandomAccessFile randomAccessFile, long j) throws IOException {
        x(randomAccessFile, (((j - 4) - 8) - 4) - 4);
    }
}
