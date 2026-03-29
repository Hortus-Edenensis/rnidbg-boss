package com.opos.mobad.model.a;

import com.opos.mobad.provider.ad.AdEntity;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class d implements com.opos.mobad.model.b.a<com.opos.mobad.b.a.b> {
    private com.opos.mobad.b.a.d b(byte[] bArr) throws IOException {
        if (bArr == null) {
            return null;
        }
        return com.opos.mobad.b.a.d.c.a(bArr);
    }

    @Override // com.opos.mobad.model.b.a
    public com.opos.mobad.model.c.d a(AdEntity adEntity) throws IOException {
        if (adEntity == null) {
            return null;
        }
        return new com.opos.mobad.model.c.d(b(adEntity.f9161a), a(adEntity.b), adEntity.c);
    }

    @Override // com.opos.mobad.model.b.a
    public AdEntity a(List<com.opos.mobad.b.a.b> list, com.opos.mobad.model.c.d dVar, int i) throws IOException {
        return new AdEntity(a(dVar), a(list), dVar.i(), i);
    }

    private List<com.opos.mobad.b.a.b> a(byte[] bArr) throws IOException {
        if (bArr == null) {
            return null;
        }
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        ArrayList arrayList = new ArrayList();
        while (dataInputStream.available() > 0) {
            int i = dataInputStream.readInt();
            byte[] bArr2 = new byte[i];
            dataInputStream.read(bArr2, 0, i);
            arrayList.add(com.opos.mobad.b.a.b.c.a(bArr2));
        }
        return arrayList;
    }

    public byte[] a(com.opos.mobad.model.c.d dVar) throws IOException {
        if (dVar == null || dVar.c() == null) {
            return null;
        }
        return com.opos.mobad.b.a.d.c.b(dVar.c());
    }

    public byte[] a(List<com.opos.mobad.b.a.b> list) throws IOException {
        if (list == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        Iterator<com.opos.mobad.b.a.b> it = list.iterator();
        while (it.hasNext()) {
            byte[] bArrB = com.opos.mobad.b.a.b.c.b(it.next());
            dataOutputStream.writeInt(bArrB.length);
            dataOutputStream.write(bArrB);
        }
        dataOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }
}
