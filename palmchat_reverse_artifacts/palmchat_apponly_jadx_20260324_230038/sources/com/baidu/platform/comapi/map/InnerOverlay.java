package com.baidu.platform.comapi.map;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.wifi.ad.core.config.DeviceInfoUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class InnerOverlay extends Overlay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f4157a;
    protected Bundle b;
    private boolean c;
    public AppBaseMap mBaseMap;

    public InnerOverlay() {
        this.mBaseMap = null;
        this.f4157a = null;
        this.b = null;
        this.c = true;
    }

    public boolean IsOverlayShow() {
        AppBaseMap appBaseMap;
        return (this.mLayerID == 0 || (appBaseMap = this.mBaseMap) == null || appBaseMap.GetId() == 0 || !this.mBaseMap.LayersIsShow(this.mLayerID)) ? false : true;
    }

    public void SetMapParam(long j, AppBaseMap appBaseMap) {
        this.mLayerID = j;
        this.mBaseMap = appBaseMap;
    }

    public void SetOverlayShow(boolean z) {
        AppBaseMap appBaseMap;
        if (this.mLayerID == 0 || (appBaseMap = this.mBaseMap) == null || appBaseMap.GetId() == 0) {
            return;
        }
        long jCurrentTimeMillis = k.f4213a ? System.currentTimeMillis() : 0L;
        this.mBaseMap.ShowLayers(this.mLayerID, z);
        if (k.f4213a) {
            k.a("InnerOverlay", "ShowLayer:" + this.mLayerID + ":" + z + " tag:" + getLayerTag() + " [" + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms]");
        }
    }

    public void UpdateOverlay() {
        AppBaseMap appBaseMap;
        if (this.mLayerID == 0 || (appBaseMap = this.mBaseMap) == null || appBaseMap.GetId() == 0) {
            return;
        }
        long jCurrentTimeMillis = k.f4213a ? System.currentTimeMillis() : 0L;
        this.mBaseMap.UpdateLayers(this.mLayerID);
        if (k.f4213a) {
            k.a("InnerOverlay", "UpdateLayer:" + this.mLayerID + " tag:" + getLayerTag() + " [" + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms]");
        }
    }

    public boolean addedToMapView() {
        AppBaseMap appBaseMap = this.mBaseMap;
        if (appBaseMap != null && appBaseMap.GetId() != 0) {
            long jCurrentTimeMillis = k.f4213a ? System.currentTimeMillis() : 0L;
            this.mLayerID = this.mBaseMap.AddLayer(getUpdateType(), getUpdateTimeInterval(), getLayerTag());
            if (k.f4213a) {
                k.a("InnerOverlay", "AddLayer:" + this.mLayerID + " type:" + this.mType + " tag:" + getLayerTag() + " [" + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms]");
            }
            long j = this.mLayerID;
            if (j != 0) {
                this.mBaseMap.SetLayersClickable(j, this.c);
                SetOverlayShow(getDefaultShowStatus());
                return true;
            }
        }
        return false;
    }

    public void clear() {
        long jCurrentTimeMillis = k.f4213a ? System.currentTimeMillis() : 0L;
        if (!TextUtils.isEmpty(this.f4157a)) {
            this.f4157a = null;
            AppBaseMap appBaseMap = this.mBaseMap;
            if (appBaseMap != null) {
                appBaseMap.ClearLayer(this.mLayerID);
            }
        }
        if (k.f4213a) {
            k.a("InnerOverlay", "ClearLayer:" + this.mLayerID + " tag:" + getLayerTag() + " [" + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms]");
        }
    }

    public String getData() {
        return this.f4157a;
    }

    public boolean getDefaultShowStatus() {
        return false;
    }

    public String getLayerTag() {
        return MapController.DEFAULT_LAYER_TAG;
    }

    public Bundle getParam() {
        return this.b;
    }

    public int getType() {
        return this.mType;
    }

    public int getUpdateTimeInterval() {
        return 0;
    }

    public int getUpdateType() {
        return 0;
    }

    public void setClickAble(boolean z) {
        this.c = z;
        AppBaseMap appBaseMap = this.mBaseMap;
        if (appBaseMap == null || appBaseMap.GetId() == 0) {
            return;
        }
        long j = this.mLayerID;
        if (j != 0) {
            this.mBaseMap.SetLayersClickable(j, z);
        }
    }

    public void setData(String str) {
        if (str != null) {
            this.f4157a = str;
        }
    }

    public void setFocus(int i, boolean z, String str) {
        AppBaseMap appBaseMap = this.mBaseMap;
        if (appBaseMap == null || appBaseMap.GetId() == 0) {
            return;
        }
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(DeviceInfoUtil.UID_TAG, str);
        }
        this.mBaseMap.SetFocus(this.mLayerID, i, z, bundle);
    }

    public void setParam(Bundle bundle) {
        this.b = bundle;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public InnerOverlay(int i) {
        this.mBaseMap = null;
        this.f4157a = null;
        this.b = null;
        this.c = true;
        setType(i);
    }

    public void setFocus(int i, boolean z) {
        setFocus(i, z, null);
    }

    public InnerOverlay(int i, AppBaseMap appBaseMap) {
        this.mBaseMap = null;
        this.f4157a = null;
        this.b = null;
        this.c = true;
        setType(i);
        this.mBaseMap = appBaseMap;
    }
}
