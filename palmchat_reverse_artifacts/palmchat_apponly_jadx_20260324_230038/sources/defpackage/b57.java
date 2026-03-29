package defpackage;

import com.cdadata.sdk.api.protobuf.event.CDASecurityInfoOuterClass;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class b57 extends s57 {
    @Override // defpackage.s57
    public byte[] a(byte[] bArr) throws IOException {
        byte[] bytes = "a".getBytes();
        byte[] bArrO = e67.o(bArr);
        String strQ = e67.q(16);
        String strQ2 = e67.q(16);
        byte[] bArrT = e67.t(strQ, strQ2, bArrO);
        CDASecurityInfoOuterClass.CDASecurityInfo.Builder builderNewBuilder = CDASecurityInfoOuterClass.CDASecurityInfo.newBuilder();
        builderNewBuilder.setKey(strQ);
        builderNewBuilder.setIv(strQ2);
        byte[] byteArray = builderNewBuilder.build().toByteArray();
        Random random = new Random();
        int iNextInt = random.nextInt((byteArray.length / 3) - 5) + 5;
        byte[] bArr2 = new byte[iNextInt];
        System.arraycopy(byteArray, 0, bArr2, 0, iNextInt);
        int iNextInt2 = random.nextInt(((byteArray.length * 2) / 3) - iNextInt) + iNextInt;
        int i = iNextInt2 - iNextInt;
        byte[] bArr3 = new byte[i];
        System.arraycopy(byteArray, iNextInt, bArr3, 0, i);
        int length = byteArray.length - iNextInt2;
        byte[] bArr4 = new byte[length];
        System.arraycopy(byteArray, iNextInt2, bArr4, 0, length);
        int iNextInt3 = random.nextInt((bArrT.length / 4) - 5) + 5;
        byte[] bArr5 = new byte[iNextInt3];
        System.arraycopy(bArrT, 0, bArr5, 0, iNextInt3);
        int iNextInt4 = random.nextInt(((bArrT.length * 2) / 4) - iNextInt3) + iNextInt3;
        int i2 = iNextInt4 - iNextInt3;
        byte[] bArr6 = new byte[i2];
        System.arraycopy(bArrT, iNextInt3, bArr6, 0, i2);
        int iNextInt5 = random.nextInt(((bArrT.length * 3) / 4) - iNextInt4) + iNextInt4;
        int i3 = iNextInt5 - iNextInt4;
        byte[] bArr7 = new byte[i3];
        System.arraycopy(bArrT, iNextInt4, bArr7, 0, i3);
        int length2 = bArrT.length - iNextInt5;
        byte[] bArr8 = new byte[length2];
        System.arraycopy(bArrT, iNextInt5, bArr8, 0, length2);
        byte[] bArrK = e67.k(iNextInt3 + 24);
        byte[] bArrK2 = e67.k(iNextInt);
        int i4 = iNextInt3 + iNextInt + i2;
        byte[] bArrK3 = e67.k(i4 + 24);
        byte[] bArrK4 = e67.k(i);
        byte[] bArrK5 = e67.k(i4 + i + i3 + 24);
        byte[] bArrK6 = e67.k(length);
        ArrayList arrayList = new ArrayList();
        arrayList.add(bytes);
        arrayList.add(bArrK);
        arrayList.add(bArrK2);
        arrayList.add(bArrK3);
        arrayList.add(bArrK4);
        arrayList.add(bArrK5);
        arrayList.add(bArrK6);
        arrayList.add(bArr5);
        arrayList.add(bArr2);
        arrayList.add(bArr6);
        arrayList.add(bArr3);
        arrayList.add(bArr7);
        arrayList.add(bArr4);
        arrayList.add(bArr8);
        return e67.m(arrayList);
    }
}
