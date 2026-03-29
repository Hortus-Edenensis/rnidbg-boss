package com.oplus.tbl.exoplayer2.effect;

import androidx.annotation.OptIn;
import com.oplus.tbl.exoplayer2.GlObjectsProvider;
import com.oplus.tbl.exoplayer2.GlTextureInfo;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.GlUtil;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import defpackage.bv2;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class TexturePool {
    private final int capacity;
    private final Queue<GlTextureInfo> freeTextures;
    private final Queue<GlTextureInfo> inUseTextures;
    private final boolean useHighPrecisionColorComponents;

    public TexturePool(boolean z, int i) {
        this.capacity = i;
        this.useHighPrecisionColorComponents = z;
        this.freeTextures = new ArrayDeque(i);
        this.inUseTextures = new ArrayDeque(i);
    }

    @OptIn(markerClass = {UnstableApi.class})
    private void createTextures(GlObjectsProvider glObjectsProvider, int i, int i2) throws GlUtil.GlException {
        Assertions.checkState(this.freeTextures.isEmpty());
        Assertions.checkState(this.inUseTextures.isEmpty());
        for (int i3 = 0; i3 < this.capacity; i3++) {
            this.freeTextures.add(glObjectsProvider.createBuffersForTexture(GlUtil.createTexture(i, i2, this.useHighPrecisionColorComponents), i, i2));
        }
    }

    private Iterator<GlTextureInfo> getIteratorToAllTextures() {
        return bv2.d(this.freeTextures, this.inUseTextures).iterator();
    }

    public int capacity() {
        return this.capacity;
    }

    @OptIn(markerClass = {UnstableApi.class})
    public void deleteAllTextures() throws GlUtil.GlException {
        Iterator<GlTextureInfo> iteratorToAllTextures = getIteratorToAllTextures();
        while (iteratorToAllTextures.hasNext()) {
            iteratorToAllTextures.next().release();
        }
        this.freeTextures.clear();
        this.inUseTextures.clear();
    }

    @OptIn(markerClass = {UnstableApi.class})
    public void ensureConfigured(GlObjectsProvider glObjectsProvider, int i, int i2) throws GlUtil.GlException {
        if (!isConfigured()) {
            createTextures(glObjectsProvider, i, i2);
            return;
        }
        GlTextureInfo next = getIteratorToAllTextures().next();
        if (next.width == i && next.height == i2) {
            return;
        }
        deleteAllTextures();
        createTextures(glObjectsProvider, i, i2);
    }

    public void freeAllTextures() {
        this.freeTextures.addAll(this.inUseTextures);
        this.inUseTextures.clear();
    }

    public void freeTexture() {
        Assertions.checkState(!this.inUseTextures.isEmpty());
        this.freeTextures.add(this.inUseTextures.remove());
    }

    public int freeTextureCount() {
        return !isConfigured() ? this.capacity : this.freeTextures.size();
    }

    public boolean isConfigured() {
        return getIteratorToAllTextures().hasNext();
    }

    public boolean isUsingTexture(GlTextureInfo glTextureInfo) {
        return this.inUseTextures.contains(glTextureInfo);
    }

    public GlTextureInfo useTexture() {
        if (this.freeTextures.isEmpty()) {
            throw new IllegalStateException("Textures are all in use. Please release in-use textures before calling useTexture.");
        }
        GlTextureInfo glTextureInfoRemove = this.freeTextures.remove();
        this.inUseTextures.add(glTextureInfoRemove);
        return glTextureInfoRemove;
    }

    public void freeTexture(GlTextureInfo glTextureInfo) {
        Assertions.checkState(this.inUseTextures.contains(glTextureInfo));
        this.inUseTextures.remove(glTextureInfo);
        this.freeTextures.add(glTextureInfo);
    }
}
