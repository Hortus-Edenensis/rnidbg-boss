package com.baidu.mapapi.favorite;

import android.util.Log;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapsdkplatform.comapi.favrite.FavSyncPoi;
import com.baidu.mapsdkplatform.comapi.map.e;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class FavoriteManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static FavoriteManager f3569a;
    private static com.baidu.mapsdkplatform.comapi.favrite.a b;

    private FavoriteManager() {
    }

    public static FavoriteManager getInstance() {
        if (f3569a == null) {
            f3569a = new FavoriteManager();
        }
        return f3569a;
    }

    public int add(FavoritePoiInfo favoritePoiInfo) {
        if (b == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return 0;
        }
        if (favoritePoiInfo == null || favoritePoiInfo.c == null) {
            Log.e("baidumapsdk", "object or pt can not be null!");
            return 0;
        }
        String str = favoritePoiInfo.b;
        if (str == null || str.equals("")) {
            Log.e("baidumapsdk", "poiName can not be null or empty!");
            return -1;
        }
        FavSyncPoi favSyncPoiA = a.a(favoritePoiInfo);
        int iA = b.a(favSyncPoiA.b, favSyncPoiA);
        if (iA == 1) {
            favoritePoiInfo.f3570a = favSyncPoiA.f3968a;
            favoritePoiInfo.g = Long.parseLong(favSyncPoiA.h);
        }
        return iA;
    }

    public boolean clearAllFavPois() {
        com.baidu.mapsdkplatform.comapi.favrite.a aVar = b;
        if (aVar != null) {
            return aVar.a();
        }
        Log.e("baidumapsdk", "you may have not call init method!");
        return false;
    }

    public boolean deleteFavPoi(String str) {
        if (b == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return false;
        }
        if (str == null || str.equals("")) {
            return false;
        }
        return b.a(str);
    }

    public void destroy() {
        com.baidu.mapsdkplatform.comapi.favrite.a aVar = b;
        if (aVar != null) {
            aVar.b();
            b = null;
            BMapManager.destroy();
            e.a();
        }
    }

    public List<FavoritePoiInfo> getAllFavPois() {
        JSONArray jSONArrayOptJSONArray;
        com.baidu.mapsdkplatform.comapi.favrite.a aVar = b;
        if (aVar == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return null;
        }
        String strC = aVar.c();
        if (strC != null && !strC.equals("")) {
            try {
                JSONObject jSONObject = new JSONObject(strC);
                if (jSONObject.optInt("favpoinum") != 0 && (jSONArrayOptJSONArray = jSONObject.optJSONArray("favcontents")) != null && jSONArrayOptJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                        if (jSONObject2 != null) {
                            arrayList.add(a.a(jSONObject2));
                        }
                    }
                    return arrayList;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public FavoritePoiInfo getFavPoi(String str) {
        FavSyncPoi favSyncPoiB;
        if (b == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return null;
        }
        if (str == null || str.equals("") || (favSyncPoiB = b.b(str)) == null) {
            return null;
        }
        return a.a(favSyncPoiB);
    }

    public void init() {
        if (b == null) {
            e.c();
            BMapManager.init();
            b = com.baidu.mapsdkplatform.comapi.favrite.a.f();
        }
    }

    public boolean updateFavPoi(String str, FavoritePoiInfo favoritePoiInfo) {
        if (b == null) {
            Log.e("baidumapsdk", "you may have not call init method!");
            return false;
        }
        if (str != null && !str.equals("") && favoritePoiInfo != null) {
            if (favoritePoiInfo.c == null) {
                Log.e("baidumapsdk", "object or pt can not be null!");
                return false;
            }
            String str2 = favoritePoiInfo.b;
            if (str2 != null && !str2.equals("")) {
                favoritePoiInfo.f3570a = str;
                return b.b(str, a.a(favoritePoiInfo));
            }
            Log.e("baidumapsdk", "poiName can not be null or empty!");
        }
        return false;
    }
}
