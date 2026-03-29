package com.opos.mobad.model.b;

import com.opos.mobad.provider.ad.AdEntity;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface a<K> {
    com.opos.mobad.model.c.d a(AdEntity adEntity) throws IOException;

    AdEntity a(List<K> list, com.opos.mobad.model.c.d dVar, int i) throws IOException;
}
