package com.baidu.apis.cluster;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.apis.cluster.BaiduClusterRender;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.DistanceUtil;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BaiduClusterOverlay implements BaiduMap.OnMarkerClickListener {
    private Map<String, Marker> addedMarker;
    private List<Marker> mAddMarkers;
    private BaiduMap mBaiduMap;
    private BaiduClusterClickListener mClusterClickListener;
    private double mClusterDistance;
    private List<BaiduClusterItem> mClusterItems;
    private BaiduClusterRender mClusterRender;
    private int mClusterSize;
    private List<BaiduCluster> mClusters;
    private Context mContext;
    private boolean mIsCanceled;
    private HandlerThread mMarkerHandlerThread;
    private Handler mMarkerhandler;
    private float mPXInMeters;
    private Handler mSignClusterHandler;
    private HandlerThread mSignClusterThread;
    private Map<Marker, BaiduCluster> markerClusterMap;
    private Map<String, BaiduCluster> needAddMarker;
    private float zIndex;

    /* JADX INFO: compiled from: SearchBox */
    public class BlurUpdateObj {
        public Bitmap bitmap;
        public BaiduCluster cluster;

        private BlurUpdateObj() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class MarkerHandler extends Handler {
        static final int ADD_CLUSTER_LIST = 0;
        static final int ADD_SINGLE_CLUSTER = 1;
        static final int UPDATE_SINGLE_CLUSTER = 2;
        static final int UPDATE_TRIP_BLUR_CLUSTER = 3;

        public MarkerHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                BaiduClusterOverlay.this.addClusterToMap((List) message.obj);
                return;
            }
            if (i == 1) {
                BaiduClusterOverlay.this.addSingleClusterToMap((BaiduCluster) message.obj);
            } else if (i == 2) {
                BaiduClusterOverlay.this.updateCluster((BaiduCluster) message.obj);
            } else {
                if (i != 3) {
                    return;
                }
                BaiduClusterOverlay.this.updateBlurCluster((BlurUpdateObj) message.obj);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class SignClusterHandler extends Handler {
        static final int CALCULATE_CLUSTER = 0;

        public SignClusterHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 0) {
                return;
            }
            BaiduClusterOverlay.this.calculateClusters();
        }
    }

    public BaiduClusterOverlay(BaiduMap baiduMap, int i, Context context) {
        this(baiduMap, null, i, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void addClusterToMap(List<BaiduCluster> list) {
        HashMap map = new HashMap();
        for (BaiduCluster baiduCluster : list) {
            if (this.mIsCanceled) {
                return;
            }
            Marker markerAddSingleClusterToMap = addSingleClusterToMap(baiduCluster);
            if (markerAddSingleClusterToMap != null) {
                map.put(this.mClusterRender.getKey(baiduCluster), markerAddSingleClusterToMap);
            }
        }
        removeUnlessMarker();
        this.addedMarker = map;
        downloadAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void addMarker(BaiduCluster baiduCluster) {
        String key = this.mClusterRender.getKey(baiduCluster);
        Marker marker = (Marker) this.mBaiduMap.addOverlay(new MarkerOptions().position(baiduCluster.getCenterLatLng()).icon(getBitmapDes(baiduCluster)).anchor(0.5f, 0.5f).zIndex((int) this.zIndex));
        baiduCluster.setMarker(marker);
        this.markerClusterMap.put(marker, baiduCluster);
        this.addedMarker.put(key, marker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Marker addSingleClusterToMap(BaiduCluster baiduCluster) {
        String key = this.mClusterRender.getKey(baiduCluster);
        if (this.needAddMarker.containsKey(key)) {
            return null;
        }
        if (this.addedMarker.containsKey(key)) {
            return this.addedMarker.remove(key);
        }
        if (this.mClusterRender.drawAsync()) {
            this.needAddMarker.put(key, baiduCluster);
            return null;
        }
        Marker marker = (Marker) this.mBaiduMap.addOverlay(new MarkerOptions().position(baiduCluster.getCenterLatLng()).icon(getBitmapDes(baiduCluster)).anchor(0.5f, 0.5f).zIndex((int) this.zIndex));
        baiduCluster.setMarker(marker);
        this.markerClusterMap.put(marker, baiduCluster);
        return marker;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void calculateClusters() {
        this.mIsCanceled = false;
        this.mClusters.clear();
        for (BaiduClusterItem baiduClusterItem : new ArrayList(this.mClusterItems)) {
            if (this.mIsCanceled) {
                return;
            }
            LatLng position = baiduClusterItem.getPosition();
            BaiduCluster cluster = getCluster(position, this.mClusters);
            if (cluster != null) {
                cluster.addClusterItem(baiduClusterItem);
            } else {
                BaiduCluster baiduCluster = new BaiduCluster(position);
                this.mClusters.add(baiduCluster);
                baiduCluster.addClusterItem(baiduClusterItem);
            }
        }
        LogUtil.d("BaiduCluster", "calculateClusters mClusters size " + this.mClusters.size() + " mClusterItems size " + this.mClusterItems.size());
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mClusters);
        Message messageObtain = Message.obtain();
        messageObtain.what = 0;
        messageObtain.obj = arrayList;
        if (this.mIsCanceled) {
            return;
        }
        this.mMarkerhandler.sendMessage(messageObtain);
    }

    private void downloadAsync() {
        for (String str : this.needAddMarker.keySet()) {
            if (this.mIsCanceled) {
                this.needAddMarker.clear();
                return;
            }
            this.mClusterRender.loadBitmapAsync(this.needAddMarker.get(str), new BaiduClusterRender.LoadCallback() { // from class: com.baidu.apis.cluster.BaiduClusterOverlay.1
                @Override // com.baidu.apis.cluster.BaiduClusterRender.LoadCallback
                public void onBitmapCallback(BaiduCluster baiduCluster) {
                    if (BaiduClusterOverlay.this.mIsCanceled) {
                        return;
                    }
                    BaiduClusterOverlay.this.addMarker(baiduCluster);
                }
            });
        }
        this.needAddMarker.clear();
    }

    private BitmapDescriptor getBitmapDes(BaiduCluster baiduCluster) {
        return BitmapDescriptorFactory.fromBitmap(this.mClusterRender.getDrawAble(baiduCluster));
    }

    private BaiduCluster getCluster(LatLng latLng, List<BaiduCluster> list) {
        for (BaiduCluster baiduCluster : list) {
            LatLng centerLatLng = baiduCluster.getCenterLatLng();
            double distance = DistanceUtil.getDistance(new LatLng(latLng.latitude, latLng.longitude), new LatLng(centerLatLng.latitude, centerLatLng.longitude));
            LogUtil.d("BaiduCluster", "distance:" + distance + " mClusterDistance:" + this.mClusterDistance);
            if (distance < this.mClusterDistance) {
                return baiduCluster;
            }
        }
        return null;
    }

    private void initThreadHandler() {
        this.mMarkerHandlerThread.start();
        this.mSignClusterThread.start();
        this.mMarkerhandler = new MarkerHandler(this.mMarkerHandlerThread.getLooper());
        this.mSignClusterHandler = new SignClusterHandler(this.mSignClusterThread.getLooper());
    }

    private synchronized void removeUnlessMarker() {
        Iterator<String> it = this.addedMarker.keySet().iterator();
        while (it.hasNext()) {
            Marker marker = this.addedMarker.get(it.next());
            marker.remove();
            this.markerClusterMap.remove(marker);
        }
        this.addedMarker.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBlurCluster(BlurUpdateObj blurUpdateObj) {
        BaiduCluster baiduCluster;
        Marker marker;
        if (blurUpdateObj == null || (baiduCluster = blurUpdateObj.cluster) == null || blurUpdateObj.bitmap == null || (marker = baiduCluster.getMarker()) == null) {
            return;
        }
        marker.setIcon(BitmapDescriptorFactory.fromBitmap(blurUpdateObj.bitmap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCluster(BaiduCluster baiduCluster) {
        Marker marker = baiduCluster.getMarker();
        if (marker != null) {
            marker.setIcon(getBitmapDes(baiduCluster));
        }
    }

    public void assignClusters() {
        this.mIsCanceled = true;
        this.mSignClusterHandler.removeMessages(0);
        this.mSignClusterHandler.sendEmptyMessage(0);
    }

    public List<BaiduCluster> getAllCluster() {
        return this.mClusters;
    }

    public void onDestroy() {
        this.mIsCanceled = true;
        this.mSignClusterHandler.removeCallbacksAndMessages(null);
        this.mMarkerhandler.removeCallbacksAndMessages(null);
        this.mSignClusterThread.quit();
        this.mMarkerHandlerThread.quit();
        for (Marker marker : this.mAddMarkers) {
            marker.remove();
            this.markerClusterMap.remove(marker);
        }
        this.mAddMarkers.clear();
        this.markerClusterMap.clear();
    }

    @Override // com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        if (this.mClusterClickListener == null) {
            return true;
        }
        BaiduCluster baiduCluster = this.markerClusterMap.get(marker);
        if (baiduCluster == null) {
            return false;
        }
        this.mClusterClickListener.onClick(marker, baiduCluster);
        return true;
    }

    public void refreshClusters(List<BaiduClusterItem> list) {
        this.mPXInMeters = (float) ((Math.cos((this.mBaiduMap.getMapStatus().target.latitude * 3.141592653589793d) / 180.0d) * 156543.03392d) / Math.pow(2.0d, this.mBaiduMap.getMapStatus().zoom));
        this.mClusterDistance = r0 * this.mClusterSize;
        this.mClusterItems = list;
        assignClusters();
    }

    public void setClusterRenderer(BaiduClusterRender baiduClusterRender) {
        this.mClusterRender = baiduClusterRender;
    }

    public void setOnClusterClickListener(BaiduClusterClickListener baiduClusterClickListener) {
        this.mClusterClickListener = baiduClusterClickListener;
    }

    public void setzIndex(float f) {
        this.zIndex = f;
    }

    public void updateClusterBitmap(BaiduCluster baiduCluster, Bitmap bitmap) {
        if (baiduCluster == null || bitmap == null) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 3;
        BlurUpdateObj blurUpdateObj = new BlurUpdateObj();
        blurUpdateObj.bitmap = bitmap;
        blurUpdateObj.cluster = baiduCluster;
        messageObtain.obj = blurUpdateObj;
        this.mMarkerhandler.removeMessages(3);
        this.mMarkerhandler.sendMessageDelayed(messageObtain, 5L);
    }

    public BaiduClusterOverlay(BaiduMap baiduMap, List<BaiduClusterItem> list, int i, Context context) {
        this.mAddMarkers = new ArrayList();
        this.addedMarker = new HashMap();
        this.needAddMarker = new HashMap();
        this.markerClusterMap = new HashMap();
        this.mMarkerHandlerThread = new HandlerThread("addMarker");
        this.mSignClusterThread = new HandlerThread("calculateCluster");
        this.mIsCanceled = false;
        this.zIndex = 0.0f;
        if (list != null) {
            this.mClusterItems = list;
        } else {
            this.mClusterItems = new ArrayList();
        }
        this.mContext = context;
        this.mClusters = new ArrayList();
        this.mBaiduMap = baiduMap;
        this.mClusterSize = i;
        this.mPXInMeters = (float) ((Math.cos((this.mBaiduMap.getMapStatus().target.latitude * 3.141592653589793d) / 180.0d) * 156543.03392d) / Math.pow(2.0d, baiduMap.getMapStatus().zoom));
        LogUtil.d("BaiduCluster", "mClusterSize:" + this.mClusterSize + " mPXInMeters:" + this.mPXInMeters);
        this.mClusterDistance = (double) (this.mPXInMeters * ((float) this.mClusterSize));
        baiduMap.setOnMarkerClickListener(this);
        initThreadHandler();
    }

    public void onMapDrag(LocationEx locationEx) {
    }
}
