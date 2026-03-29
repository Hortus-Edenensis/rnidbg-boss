package com.amap.api.col.p0002sl;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import com.amap.api.col.p0002sl.ga;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.LatLonSharePoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IShareSearch;
import com.amap.api.services.share.ShareSearch;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class fo implements IShareSearch {
    private static String b = "http://wb.amap.com/?r=%f,%f,%s,%f,%f,%s,%d,%d,%d,%s,%s,%s&sourceapplication=openapi/0";
    private static String c = "http://wb.amap.com/?q=%f,%f,%s&sourceapplication=openapi/0";
    private static String d = "http://wb.amap.com/?n=%f,%f,%f,%f,%d&sourceapplication=openapi/0";
    private static String e = "http://wb.amap.com/?p=%s,%f,%f,%s,%s&sourceapplication=openapi/0";
    private static final String f = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f2779a;
    private ShareSearch.OnShareSearchListener g;

    public fo(Context context) throws AMapException {
        gb gbVarA = ga.a(context, dh.a(false));
        if (gbVarA.f2821a == ga.c.SuccessCode) {
            this.f2779a = context;
        } else {
            String str = gbVarA.b;
            throw new AMapException(str, 1, str, gbVarA.f2821a.a());
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchBusRouteShareUrl(ShareSearch.ShareBusRouteQuery shareBusRouteQuery) throws AMapException {
        try {
            if (shareBusRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            int busMode = shareBusRouteQuery.getBusMode();
            ShareSearch.ShareFromAndTo shareFromAndTo = shareBusRouteQuery.getShareFromAndTo();
            if (shareFromAndTo.getFrom() == null || shareFromAndTo.getTo() == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            LatLonPoint from = shareFromAndTo.getFrom();
            LatLonPoint to = shareFromAndTo.getTo();
            String fromName = shareFromAndTo.getFromName();
            String toName = shareFromAndTo.getToName();
            String str = b;
            String str2 = f;
            return new ep(this.f2779a, String.format(str, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), fromName, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), toName, Integer.valueOf(busMode), 1, 0, str2, str2, str2)).b();
        } catch (AMapException e2) {
            di.a(e2, "ShareSearch", "searchBusRouteShareUrl");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchBusRouteShareUrlAsyn(final ShareSearch.ShareBusRouteQuery shareBusRouteQuery) {
        try {
            es.a().a(new Runnable() { // from class: com.amap.api.col.2sl.fo.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (fo.this.g == null) {
                        return;
                    }
                    Message messageObtainMessage = dt.a().obtainMessage();
                    messageObtainMessage.arg1 = 11;
                    messageObtainMessage.what = AMapException.CODE_AMAP_ENGINE_RETURN_TIMEOUT;
                    messageObtainMessage.obj = fo.this.g;
                    try {
                        try {
                            String strSearchBusRouteShareUrl = fo.this.searchBusRouteShareUrl(shareBusRouteQuery);
                            Bundle bundle = new Bundle();
                            bundle.putString("shareurlkey", strSearchBusRouteShareUrl);
                            messageObtainMessage.setData(bundle);
                            messageObtainMessage.arg2 = 1000;
                        } catch (AMapException e2) {
                            messageObtainMessage.arg2 = e2.getErrorCode();
                        }
                    } finally {
                        dt.a().sendMessage(messageObtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchDrivingRouteShareUrl(ShareSearch.ShareDrivingRouteQuery shareDrivingRouteQuery) throws AMapException {
        try {
            if (shareDrivingRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            int drivingMode = shareDrivingRouteQuery.getDrivingMode();
            ShareSearch.ShareFromAndTo shareFromAndTo = shareDrivingRouteQuery.getShareFromAndTo();
            if (shareFromAndTo.getFrom() == null || shareFromAndTo.getTo() == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            LatLonPoint from = shareFromAndTo.getFrom();
            LatLonPoint to = shareFromAndTo.getTo();
            String fromName = shareFromAndTo.getFromName();
            String toName = shareFromAndTo.getToName();
            String str = b;
            String str2 = f;
            return new ep(this.f2779a, String.format(str, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), fromName, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), toName, Integer.valueOf(drivingMode), 0, 0, str2, str2, str2)).b();
        } catch (AMapException e2) {
            di.a(e2, "ShareSearch", "searchDrivingRouteShareUrl");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchDrivingRouteShareUrlAsyn(final ShareSearch.ShareDrivingRouteQuery shareDrivingRouteQuery) {
        try {
            es.a().a(new Runnable() { // from class: com.amap.api.col.2sl.fo.4
                @Override // java.lang.Runnable
                public final void run() {
                    if (fo.this.g == null) {
                        return;
                    }
                    Message messageObtainMessage = dt.a().obtainMessage();
                    messageObtainMessage.arg1 = 11;
                    messageObtainMessage.what = 1104;
                    messageObtainMessage.obj = fo.this.g;
                    try {
                        try {
                            String strSearchDrivingRouteShareUrl = fo.this.searchDrivingRouteShareUrl(shareDrivingRouteQuery);
                            Bundle bundle = new Bundle();
                            bundle.putString("shareurlkey", strSearchDrivingRouteShareUrl);
                            messageObtainMessage.setData(bundle);
                            messageObtainMessage.arg2 = 1000;
                        } catch (AMapException e2) {
                            messageObtainMessage.arg2 = e2.getErrorCode();
                        }
                    } finally {
                        dt.a().sendMessage(messageObtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchLocationShareUrl(LatLonSharePoint latLonSharePoint) throws AMapException {
        try {
            if (latLonSharePoint != null) {
                return new ep(this.f2779a, String.format(c, Double.valueOf(latLonSharePoint.getLatitude()), Double.valueOf(latLonSharePoint.getLongitude()), latLonSharePoint.getSharePointName())).b();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            di.a(e2, "ShareSearch", "searchLocationShareUrl");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchLocationShareUrlAsyn(final LatLonSharePoint latLonSharePoint) {
        try {
            es.a().a(new Runnable() { // from class: com.amap.api.col.2sl.fo.6
                @Override // java.lang.Runnable
                public final void run() {
                    if (fo.this.g == null) {
                        return;
                    }
                    Message messageObtainMessage = dt.a().obtainMessage();
                    messageObtainMessage.arg1 = 11;
                    messageObtainMessage.what = 1101;
                    messageObtainMessage.obj = fo.this.g;
                    try {
                        try {
                            String strSearchLocationShareUrl = fo.this.searchLocationShareUrl(latLonSharePoint);
                            Bundle bundle = new Bundle();
                            bundle.putString("shareurlkey", strSearchLocationShareUrl);
                            messageObtainMessage.setData(bundle);
                            messageObtainMessage.arg2 = 1000;
                        } catch (AMapException e2) {
                            messageObtainMessage.arg2 = e2.getErrorCode();
                        }
                    } finally {
                        dt.a().sendMessage(messageObtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchNaviShareUrl(ShareSearch.ShareNaviQuery shareNaviQuery) throws AMapException {
        try {
            if (shareNaviQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            ShareSearch.ShareFromAndTo fromAndTo = shareNaviQuery.getFromAndTo();
            if (fromAndTo.getTo() == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            LatLonPoint from = fromAndTo.getFrom();
            LatLonPoint to = fromAndTo.getTo();
            int naviMode = shareNaviQuery.getNaviMode();
            return new ep(this.f2779a, fromAndTo.getFrom() == null ? String.format(d, null, null, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), Integer.valueOf(naviMode)) : String.format(d, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), Integer.valueOf(naviMode))).b();
        } catch (AMapException e2) {
            di.a(e2, "ShareSearch", "searchNaviShareUrl");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchNaviShareUrlAsyn(final ShareSearch.ShareNaviQuery shareNaviQuery) {
        try {
            es.a().a(new Runnable() { // from class: com.amap.api.col.2sl.fo.5
                @Override // java.lang.Runnable
                public final void run() {
                    if (fo.this.g == null) {
                        return;
                    }
                    Message messageObtainMessage = dt.a().obtainMessage();
                    messageObtainMessage.arg1 = 11;
                    messageObtainMessage.what = 1102;
                    messageObtainMessage.obj = fo.this.g;
                    try {
                        try {
                            String strSearchNaviShareUrl = fo.this.searchNaviShareUrl(shareNaviQuery);
                            Bundle bundle = new Bundle();
                            bundle.putString("shareurlkey", strSearchNaviShareUrl);
                            messageObtainMessage.setData(bundle);
                            messageObtainMessage.arg2 = 1000;
                        } catch (AMapException e2) {
                            messageObtainMessage.arg2 = e2.getErrorCode();
                        }
                    } finally {
                        dt.a().sendMessage(messageObtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchPoiShareUrl(PoiItem poiItem) throws AMapException {
        if (poiItem != null) {
            try {
                if (poiItem.getLatLonPoint() != null) {
                    LatLonPoint latLonPoint = poiItem.getLatLonPoint();
                    return new ep(this.f2779a, String.format(e, poiItem.getPoiId(), Double.valueOf(latLonPoint.getLatitude()), Double.valueOf(latLonPoint.getLongitude()), poiItem.getTitle(), poiItem.getSnippet())).b();
                }
            } catch (AMapException e2) {
                di.a(e2, "ShareSearch", "searchPoiShareUrl");
                throw e2;
            }
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchPoiShareUrlAsyn(final PoiItem poiItem) {
        try {
            es.a().a(new Runnable() { // from class: com.amap.api.col.2sl.fo.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (fo.this.g == null) {
                        return;
                    }
                    Message messageObtainMessage = dt.a().obtainMessage();
                    messageObtainMessage.arg1 = 11;
                    messageObtainMessage.what = 1100;
                    messageObtainMessage.obj = fo.this.g;
                    try {
                        try {
                            String strSearchPoiShareUrl = fo.this.searchPoiShareUrl(poiItem);
                            Bundle bundle = new Bundle();
                            bundle.putString("shareurlkey", strSearchPoiShareUrl);
                            messageObtainMessage.setData(bundle);
                            messageObtainMessage.arg2 = 1000;
                        } catch (AMapException e2) {
                            messageObtainMessage.arg2 = e2.getErrorCode();
                        }
                    } finally {
                        dt.a().sendMessage(messageObtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchWalkRouteShareUrl(ShareSearch.ShareWalkRouteQuery shareWalkRouteQuery) throws AMapException {
        try {
            if (shareWalkRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            int walkMode = shareWalkRouteQuery.getWalkMode();
            ShareSearch.ShareFromAndTo shareFromAndTo = shareWalkRouteQuery.getShareFromAndTo();
            if (shareFromAndTo.getFrom() == null || shareFromAndTo.getTo() == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            LatLonPoint from = shareFromAndTo.getFrom();
            LatLonPoint to = shareFromAndTo.getTo();
            String fromName = shareFromAndTo.getFromName();
            String toName = shareFromAndTo.getToName();
            String str = b;
            String str2 = f;
            return new ep(this.f2779a, String.format(str, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), fromName, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), toName, Integer.valueOf(walkMode), 2, 0, str2, str2, str2)).b();
        } catch (AMapException e2) {
            di.a(e2, "ShareSearch", "searchWalkRouteShareUrl");
            throw e2;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchWalkRouteShareUrlAsyn(final ShareSearch.ShareWalkRouteQuery shareWalkRouteQuery) {
        try {
            es.a().a(new Runnable() { // from class: com.amap.api.col.2sl.fo.3
                @Override // java.lang.Runnable
                public final void run() {
                    if (fo.this.g == null) {
                        return;
                    }
                    Message messageObtainMessage = dt.a().obtainMessage();
                    messageObtainMessage.arg1 = 11;
                    messageObtainMessage.what = 1105;
                    messageObtainMessage.obj = fo.this.g;
                    try {
                        try {
                            String strSearchWalkRouteShareUrl = fo.this.searchWalkRouteShareUrl(shareWalkRouteQuery);
                            Bundle bundle = new Bundle();
                            bundle.putString("shareurlkey", strSearchWalkRouteShareUrl);
                            messageObtainMessage.setData(bundle);
                            messageObtainMessage.arg2 = 1000;
                        } catch (AMapException e2) {
                            messageObtainMessage.arg2 = e2.getErrorCode();
                        }
                    } finally {
                        dt.a().sendMessage(messageObtainMessage);
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void setOnShareSearchListener(ShareSearch.OnShareSearchListener onShareSearchListener) {
        this.g = onShareSearchListener;
    }
}
