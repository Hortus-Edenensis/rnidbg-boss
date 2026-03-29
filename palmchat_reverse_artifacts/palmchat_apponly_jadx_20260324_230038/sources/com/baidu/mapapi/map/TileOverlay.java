package com.baidu.mapapi.map;

import android.util.Log;
import com.baidu.mapapi.common.Logger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class TileOverlay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3703a = "TileOverlay";
    private static int b;
    BaiduMap c;
    private TileProvider g;
    private HashMap<String, Tile> e = new HashMap<>();
    private HashSet<String> f = new HashSet<>();
    private ExecutorService d = Executors.newFixedThreadPool(1);

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f3704a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ String d;

        public a(int i, int i2, int i3, String str) {
            this.f3704a = i;
            this.b = i2;
            this.c = i3;
            this.d = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Tile tile = ((FileTileProvider) TileOverlay.this.g).getTile(this.f3704a, this.b, this.c);
            if (tile == null) {
                Log.e(TileOverlay.f3703a, "FileTile pic is null");
            } else if (tile.width == 256 && tile.height == 256) {
                TileOverlay.this.a(this.f3704a + "_" + this.b + "_" + this.c, tile);
            } else {
                Log.e(TileOverlay.f3703a, "FileTile pic must be 256 * 256");
            }
            TileOverlay.this.f.remove(this.d);
        }
    }

    public TileOverlay(BaiduMap baiduMap, TileProvider tileProvider) {
        this.c = baiduMap;
        this.g = tileProvider;
    }

    private synchronized boolean c(String str) {
        return this.f.contains(str);
    }

    public boolean clearTileCache() {
        BaiduMap baiduMap = this.c;
        if (baiduMap == null) {
            return false;
        }
        return baiduMap.a();
    }

    public void removeTileOverlay() {
        BaiduMap baiduMap = this.c;
        if (baiduMap == null) {
            return;
        }
        baiduMap.a(this);
    }

    private synchronized Tile b(String str) {
        if (!this.e.containsKey(str)) {
            return null;
        }
        Tile tile = this.e.get(str);
        this.e.remove(str);
        return tile;
    }

    public void c() {
        this.d.shutdownNow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str, Tile tile) {
        this.e.put(str, tile);
    }

    private synchronized void a(String str) {
        this.f.add(str);
    }

    public synchronized void b() {
        Logger.logE(f3703a, "clearTaskSet");
        this.f.clear();
        this.e.clear();
    }

    public Tile a(int i, int i2, int i3) {
        String str = i + "_" + i2 + "_" + i3;
        Tile tileB = b(str);
        if (tileB != null) {
            return tileB;
        }
        BaiduMap baiduMap = this.c;
        if (baiduMap != null && b == 0) {
            WinRound winRound = baiduMap.getMapStatus().c.j;
            b = (((winRound.right - winRound.left) / 256) + 2) * (((winRound.bottom - winRound.top) / 256) + 2);
        }
        if (this.e.size() > b) {
            b();
        }
        if (c(str) || this.d.isShutdown()) {
            return null;
        }
        try {
            a(str);
            this.d.execute(new a(i, i2, i3, str));
            return null;
        } catch (RejectedExecutionException unused) {
            Log.e(f3703a, "ThreadPool excepiton");
            return null;
        } catch (Exception unused2) {
            Log.e(f3703a, "fileDir is not legal");
            return null;
        }
    }
}
