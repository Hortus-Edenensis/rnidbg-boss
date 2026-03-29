package com.heytap.msp.mobad.api.ad;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.heytap.msp.mobad.api.ProxyManager;
import com.heytap.msp.mobad.api.listener.INativeAdvanceInteractInfoListener;
import com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener;
import com.heytap.msp.mobad.api.listener.INativeAdvanceLoadListener;
import com.heytap.msp.mobad.api.listener.INativeAdvanceMediaListener;
import com.heytap.msp.mobad.api.params.BaseNativeAdvanceData;
import com.heytap.msp.mobad.api.params.INativeAdFile;
import com.heytap.msp.mobad.api.params.INativeAdvanceComplianceInfo;
import com.heytap.msp.mobad.api.params.INativeAdvanceData;
import com.heytap.msp.mobad.api.params.INativeComplianceListener;
import com.heytap.msp.mobad.api.params.MediaView;
import com.heytap.msp.mobad.api.params.NativeAdvanceContainer;
import com.opos.cmn.an.h.f.a;
import com.opos.mobad.ad.e.e;
import com.opos.mobad.ad.e.g;
import com.opos.mobad.ad.e.h;
import com.opos.mobad.ad.e.i;
import com.opos.mobad.ad.e.j;
import com.opos.mobad.ad.e.k;
import com.opos.mobad.ad.e.t;
import com.opos.mobad.ad.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class NativeAdvanceAd {
    private static final String TAG = "NativeAdvanceAd";
    private Context mContext;
    private NativeAdvanceListenerWrapper mListener;
    private volatile g mNativeAdImpl;
    private String mPosId;

    /* JADX INFO: compiled from: SearchBox */
    public static class NativeAdvanceDataImp extends BaseNativeAdvanceData implements f {
        private INativeAdvanceComplianceInfo mComplianceInfo;
        private h mData;

        public NativeAdvanceDataImp(h hVar) {
            this.mData = hVar;
            if (hVar.n() != null) {
                this.mComplianceInfo = new INativeAdvanceComplianceInfo() { // from class: com.heytap.msp.mobad.api.ad.NativeAdvanceAd.NativeAdvanceDataImp.6
                    @Override // com.heytap.msp.mobad.api.params.INativeAdvanceComplianceInfo
                    public String getAppDescUrl() {
                        return NativeAdvanceDataImp.this.mData.n().f();
                    }

                    @Override // com.heytap.msp.mobad.api.params.INativeAdvanceComplianceInfo
                    public String getAppName() {
                        return NativeAdvanceDataImp.this.mData.n().c();
                    }

                    @Override // com.heytap.msp.mobad.api.params.INativeAdvanceComplianceInfo
                    public String getAppVersion() {
                        return NativeAdvanceDataImp.this.mData.n().a();
                    }

                    @Override // com.heytap.msp.mobad.api.params.INativeAdvanceComplianceInfo
                    public String getDeveloperName() {
                        return NativeAdvanceDataImp.this.mData.n().b();
                    }

                    @Override // com.heytap.msp.mobad.api.params.INativeAdvanceComplianceInfo
                    public String getPermissionUrl() {
                        return NativeAdvanceDataImp.this.mData.n().e();
                    }

                    @Override // com.heytap.msp.mobad.api.params.INativeAdvanceComplianceInfo
                    public String getPrivacyUrl() {
                        return NativeAdvanceDataImp.this.mData.n().d();
                    }
                };
            }
        }

        private int getColorInputValue(Map<String, Object> map, String str, int i) {
            Object obj;
            int iIntValue;
            return (map == null || !map.containsKey(str) || (obj = map.get(str)) == null || !(obj instanceof Integer) || (iIntValue = ((Integer) obj).intValue()) == 0) ? i : ((iIntValue >>> 24) & 255) < 77 ? (iIntValue & 16777215) + 1291845632 : iIntValue;
        }

        private int getEnumValue(Map<String, Object> map, String str, int i, int i2, int i3) {
            Object obj;
            int iIntValue;
            return (map == null || !map.containsKey(str) || (obj = map.get(str)) == null || !(obj instanceof Integer) || (iIntValue = ((Integer) obj).intValue()) < i || iIntValue > i2) ? i3 : iIntValue;
        }

        private int getInputValue(Map<String, Object> map, String str, int i, int i2, int i3) {
            Object obj;
            if (map == null || !map.containsKey(str) || (obj = map.get(str)) == null || !(obj instanceof Integer)) {
                return i3;
            }
            int iIntValue = ((Integer) obj).intValue();
            return iIntValue < i ? i : iIntValue > i2 ? i2 : iIntValue;
        }

        @Override // com.heytap.msp.mobad.api.params.BaseNativeAdvanceData, com.heytap.msp.mobad.api.params.INativeAdvanceData
        public void bindMediaView(Context context, MediaView mediaView, INativeAdvanceMediaListener iNativeAdvanceMediaListener) {
            if (this.mData.g() == 13) {
                this.widthRate = 16;
                this.heightRate = 9;
            } else if (this.mData.g() == 16) {
                this.widthRate = 9;
                this.heightRate = 16;
            }
            super.bindMediaView(context, mediaView, iNativeAdvanceMediaListener);
            this.mData.a(context, mediaView, new NativeAdvanceMediaListenerWrapper(iNativeAdvanceMediaListener));
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public void bindToComplianceView(Context context, List<View> list, final INativeComplianceListener iNativeComplianceListener, List<View> list2, final INativeComplianceListener iNativeComplianceListener2) {
            this.mData.a(context, list, new h.a() { // from class: com.heytap.msp.mobad.api.ad.NativeAdvanceAd.NativeAdvanceDataImp.1
                @Override // com.opos.mobad.ad.e.h.a
                public void onClick(View view) {
                    INativeComplianceListener iNativeComplianceListener3 = iNativeComplianceListener;
                    if (iNativeComplianceListener3 == null) {
                        return;
                    }
                    iNativeComplianceListener3.onClick(view);
                }

                @Override // com.opos.mobad.ad.e.h.a
                public void onClose() {
                    INativeComplianceListener iNativeComplianceListener3 = iNativeComplianceListener;
                    if (iNativeComplianceListener3 == null) {
                        return;
                    }
                    iNativeComplianceListener3.onClose();
                }
            }, list2, new h.a() { // from class: com.heytap.msp.mobad.api.ad.NativeAdvanceAd.NativeAdvanceDataImp.2
                @Override // com.opos.mobad.ad.e.h.a
                public void onClick(View view) {
                    INativeComplianceListener iNativeComplianceListener3 = iNativeComplianceListener2;
                    if (iNativeComplianceListener3 == null) {
                        return;
                    }
                    iNativeComplianceListener3.onClick(view);
                }

                @Override // com.opos.mobad.ad.e.h.a
                public void onClose() {
                    INativeComplianceListener iNativeComplianceListener3 = iNativeComplianceListener2;
                    if (iNativeComplianceListener3 == null) {
                        return;
                    }
                    iNativeComplianceListener3.onClose();
                }
            });
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public void bindToView(Context context, NativeAdvanceContainer nativeAdvanceContainer, List<View> list) {
            this.mData.a(context, nativeAdvanceContainer, (t) null, list, (List<View>) null);
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public boolean canIUse(String str) {
            return this.mData.a(str);
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public String getBidId() {
            return this.mData.o();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public String getClickBnText() {
            return this.mData.l();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public INativeAdvanceComplianceInfo getComplianceInfo() {
            return this.mComplianceInfo;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public int getContentType() {
            return this.mData.p();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public int getCreativeType() {
            return this.mData.g();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public String getDesc() {
            return this.mData.b();
        }

        @Override // com.heytap.msp.mobad.api.ad.IBidding
        public int getECPM() {
            return this.mData.f();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public String getExtra() {
            return this.mData.k();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public List<INativeAdFile> getIconFiles() {
            List<e> listC = this.mData.c();
            if (listC == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (e eVar : listC) {
                if (eVar != null) {
                    arrayList.add(new NativeFileImp(eVar));
                }
            }
            return arrayList;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public List<INativeAdFile> getImgFiles() {
            List<e> listD = this.mData.d();
            if (listD == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (e eVar : listD) {
                if (eVar != null) {
                    arrayList.add(new NativeFileImp(eVar));
                }
            }
            return arrayList;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public INativeAdFile getLogoFile() {
            e eVarI = this.mData.i();
            if (eVarI == null) {
                return null;
            }
            return new NativeFileImp(eVarI);
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public String getTitle() {
            return this.mData.a();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public int getVideoDuration() {
            return this.mData.h();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public List<INativeAdFile> getVideoFiles() {
            List<e> listQ = this.mData.q();
            if (listQ == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (e eVar : listQ) {
                if (eVar != null) {
                    arrayList.add(new NativeVideoFileImp(eVar));
                }
            }
            return arrayList;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public boolean isAdValid() {
            return this.mData.j();
        }

        @Override // com.heytap.msp.mobad.api.ad.IBidding
        public void notifyRankLoss(int i, String str, int i2) {
            this.mData.a(i, str, i2);
        }

        @Override // com.heytap.msp.mobad.api.ad.IBidding
        public void notifyRankWin(int i) {
            this.mData.b(i);
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public void release() {
            this.mData.m();
        }

        @Override // com.heytap.msp.mobad.api.ad.IBidding
        public void setBidECPM(int i) {
            this.mData.c(i);
        }

        @Override // com.opos.mobad.ad.f
        public void setDlClickListener(com.opos.mobad.ad.g gVar) {
            h hVar = this.mData;
            if (hVar instanceof f) {
                ((f) hVar).setDlClickListener(gVar);
            }
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public void setInteractListener(INativeAdvanceInteractListener iNativeAdvanceInteractListener) {
            this.mData.a(new NativeAdvanceInteractListenerWrapper(iNativeAdvanceInteractListener));
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public void bindToComplianceView(Context context, List<View> list, final INativeComplianceListener iNativeComplianceListener, List<View> list2, final INativeComplianceListener iNativeComplianceListener2, List<View> list3, final INativeComplianceListener iNativeComplianceListener3) {
            this.mData.a(context, list, new h.a() { // from class: com.heytap.msp.mobad.api.ad.NativeAdvanceAd.NativeAdvanceDataImp.3
                @Override // com.opos.mobad.ad.e.h.a
                public void onClick(View view) {
                    INativeComplianceListener iNativeComplianceListener4 = iNativeComplianceListener;
                    if (iNativeComplianceListener4 == null) {
                        return;
                    }
                    iNativeComplianceListener4.onClick(view);
                }

                @Override // com.opos.mobad.ad.e.h.a
                public void onClose() {
                    INativeComplianceListener iNativeComplianceListener4 = iNativeComplianceListener;
                    if (iNativeComplianceListener4 == null) {
                        return;
                    }
                    iNativeComplianceListener4.onClose();
                }
            }, list2, new h.a() { // from class: com.heytap.msp.mobad.api.ad.NativeAdvanceAd.NativeAdvanceDataImp.4
                @Override // com.opos.mobad.ad.e.h.a
                public void onClick(View view) {
                    INativeComplianceListener iNativeComplianceListener4 = iNativeComplianceListener2;
                    if (iNativeComplianceListener4 == null) {
                        return;
                    }
                    iNativeComplianceListener4.onClick(view);
                }

                @Override // com.opos.mobad.ad.e.h.a
                public void onClose() {
                    INativeComplianceListener iNativeComplianceListener4 = iNativeComplianceListener2;
                    if (iNativeComplianceListener4 == null) {
                        return;
                    }
                    iNativeComplianceListener4.onClose();
                }
            }, list3, new h.a() { // from class: com.heytap.msp.mobad.api.ad.NativeAdvanceAd.NativeAdvanceDataImp.5
                @Override // com.opos.mobad.ad.e.h.a
                public void onClick(View view) {
                    INativeComplianceListener iNativeComplianceListener4 = iNativeComplianceListener3;
                    if (iNativeComplianceListener4 == null) {
                        return;
                    }
                    iNativeComplianceListener4.onClick(view);
                }

                @Override // com.opos.mobad.ad.e.h.a
                public void onClose() {
                    INativeComplianceListener iNativeComplianceListener4 = iNativeComplianceListener3;
                    if (iNativeComplianceListener4 == null) {
                        return;
                    }
                    iNativeComplianceListener4.onClose();
                }
            });
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        public void bindToView(Context context, NativeAdvanceContainer nativeAdvanceContainer, List<View> list, List<View> list2) {
            this.mData.a(context, nativeAdvanceContainer, (t) null, list, list2);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0073  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x007a  */
        @Override // com.heytap.msp.mobad.api.params.INativeAdvanceData
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void bindToView(Context context, NativeAdvanceContainer nativeAdvanceContainer, Map<String, Object> map, List<View> list, List<View> list2) {
            byte b;
            if (map != null) {
                t.a aVar = new t.a();
                int width = nativeAdvanceContainer.getWidth() > 0 ? nativeAdvanceContainer.getWidth() : a.b(context);
                int height = nativeAdvanceContainer.getHeight() > 0 ? nativeAdvanceContainer.getHeight() : a.c(context);
                if (map.containsKey(INativeAdvanceData.KEY_CLOSE_BUTTON_POSITION)) {
                    Object obj = map.get(INativeAdvanceData.KEY_CLOSE_BUTTON_POSITION);
                    if (obj == null || !(obj instanceof String)) {
                        aVar.a(1);
                    } else {
                        String str = (String) obj;
                        switch (str.hashCode()) {
                            case -1682792238:
                                b = !str.equals(INativeAdvanceData.POSITION_BOTTOM_LEFT) ? (byte) -1 : (byte) 1;
                                break;
                            case -1140120836:
                                if (str.equals(INativeAdvanceData.POSITION_TOP_LEFT)) {
                                    b = 0;
                                    break;
                                }
                                break;
                            case -978346553:
                                if (str.equals(INativeAdvanceData.POSITION_TOP_RIGHT)) {
                                    b = 3;
                                    break;
                                }
                                break;
                            case -621290831:
                                if (str.equals(INativeAdvanceData.POSITION_BOTTOM_RIGHT)) {
                                    b = 2;
                                    break;
                                }
                                break;
                        }
                        if (b == 0) {
                            aVar.a(0);
                        } else if (b == 1) {
                            aVar.a(2);
                        } else if (b == 2) {
                            aVar.a(3);
                        }
                    }
                } else {
                    aVar.a(-1);
                }
                aVar.b(getInputValue(map, INativeAdvanceData.KEY_NATIVE_APP_INFO_LINES, 1, 2, 1));
                aVar.c(getInputValue(map, INativeAdvanceData.KEY_NATIVE_APP_INFO_START_MARGIN, 0, Integer.MAX_VALUE, 16));
                aVar.d(getInputValue(map, INativeAdvanceData.KEY_NATIVE_APP_INFO_BOTTOM_MARGIN, 0, Integer.MAX_VALUE, 38));
                aVar.e(getInputValue(map, INativeAdvanceData.KEY_NATIVE_PRIVACY_START_MARGIN, 0, Integer.MAX_VALUE, 16));
                aVar.f(getInputValue(map, INativeAdvanceData.KEY_NATIVE_PRIVACY_BOTTOM_MARGIN, 0, Integer.MAX_VALUE, 16));
                aVar.g(getInputValue(map, INativeAdvanceData.KEY_NATIVE_AD_BUTTON_WIDTH, 44, Integer.MAX_VALUE, 74));
                aVar.h(getInputValue(map, INativeAdvanceData.KEY_NATIVE_AD_BUTTON_HEIGHT, 28, 100, 32));
                aVar.i(getInputValue(map, INativeAdvanceData.KEY_NATIVE_AD_BUTTON_END_MARGIN, 0, Integer.MAX_VALUE, 16));
                aVar.j(getInputValue(map, INativeAdvanceData.KEY_NATIVE_AD_BUTTON_BOTTOM_MARGIN, 0, Integer.MAX_VALUE, 16));
                aVar.k(getInputValue(map, INativeAdvanceData.KEY_NATIVE_AD_BUTTON_TEXT_SIZE, 10, 36, 12));
                aVar.l(getInputValue(map, INativeAdvanceData.KEY_NATIVE_AD_BUTTON_BORDER_RADIUS, 0, 50, 50));
                aVar.m(getColorInputValue(map, INativeAdvanceData.KEY_NATIVE_AD_BUTTON_BACKGROUND_COLOR, -16777216));
                aVar.n(getColorInputValue(map, INativeAdvanceData.KEY_NATIVE_AD_BUTTON_TEXT_COLOR, -1));
                aVar.o(getInputValue(map, INativeAdvanceData.KEY_NATIVE_AD_BUTTON_BORDER_COLOR, Integer.MIN_VALUE, Integer.MAX_VALUE, 0));
                aVar.p(getEnumValue(map, INativeAdvanceData.KEY_NATIVE_AD_IS_SHOW_INTERACTIVE_COMPONENT, 0, 1, 0));
                aVar.q(getInputValue(map, INativeAdvanceData.KEY_NATIVE_AD_INTERACTIVE_COMPONENT_START_MARGIN, 0, width, 12));
                aVar.r(getInputValue(map, INativeAdvanceData.KEY_NATIVE_AD_INTERACTIVE_COMPONENT_TOP_MARGIN, 0, height, 12));
                aVar.s(getEnumValue(map, INativeAdvanceData.KEY_NATIVE_AD_INTERACTIVE_COMPONENT_SIZE_TYPE, 0, 1, 0));
                this.mData.a(context, nativeAdvanceContainer, aVar.a(), list, list2);
                return;
            }
            this.mData.a(context, nativeAdvanceContainer, (t) null, list, list2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class NativeAdvanceInteractListenerWrapper implements i {
        private INativeAdvanceInteractListener mListener;

        public NativeAdvanceInteractListenerWrapper(INativeAdvanceInteractListener iNativeAdvanceInteractListener) {
            this.mListener = iNativeAdvanceInteractListener;
        }

        @Override // com.opos.mobad.ad.e.i
        public void onAdClick(int i) {
            INativeAdvanceInteractListener iNativeAdvanceInteractListener = this.mListener;
            if (iNativeAdvanceInteractListener != null) {
                if (iNativeAdvanceInteractListener instanceof INativeAdvanceInteractInfoListener) {
                    ((INativeAdvanceInteractInfoListener) iNativeAdvanceInteractListener).onClick(i);
                } else {
                    iNativeAdvanceInteractListener.onClick();
                }
            }
        }

        @Override // com.opos.mobad.ad.e.i
        public void onAdClose() {
            INativeAdvanceInteractListener iNativeAdvanceInteractListener = this.mListener;
            if (iNativeAdvanceInteractListener == null || !(iNativeAdvanceInteractListener instanceof INativeAdvanceInteractInfoListener)) {
                return;
            }
            ((INativeAdvanceInteractInfoListener) iNativeAdvanceInteractListener).onClose();
        }

        @Override // com.opos.mobad.ad.e.i
        public void onAdShow() {
            INativeAdvanceInteractListener iNativeAdvanceInteractListener = this.mListener;
            if (iNativeAdvanceInteractListener != null) {
                iNativeAdvanceInteractListener.onShow();
            }
        }

        @Override // com.opos.mobad.ad.e.i
        public void onError(int i, String str) {
            INativeAdvanceInteractListener iNativeAdvanceInteractListener = this.mListener;
            if (iNativeAdvanceInteractListener != null) {
                iNativeAdvanceInteractListener.onError(i, str);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class NativeAdvanceListenerWrapper implements j {
        private INativeAdvanceLoadListener mNativeAdListener;

        public NativeAdvanceListenerWrapper(INativeAdvanceLoadListener iNativeAdvanceLoadListener) {
            this.mNativeAdListener = iNativeAdvanceLoadListener;
        }

        @Override // com.opos.mobad.ad.e.a
        public void onAdFailed(int i, String str) {
            INativeAdvanceLoadListener iNativeAdvanceLoadListener = this.mNativeAdListener;
            if (iNativeAdvanceLoadListener != null) {
                iNativeAdvanceLoadListener.onAdFailed(i, str);
            }
        }

        @Override // com.opos.mobad.ad.e.a
        public void onAdSuccess(List<h> list) {
            ArrayList arrayList;
            if (this.mNativeAdListener != null) {
                if (list != null) {
                    arrayList = new ArrayList();
                    Iterator<h> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new NativeAdvanceDataImp(it.next()));
                    }
                } else {
                    arrayList = null;
                }
                this.mNativeAdListener.onAdSuccess(arrayList);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class NativeAdvanceMediaListenerWrapper implements k {
        private INativeAdvanceMediaListener mListener;

        public NativeAdvanceMediaListenerWrapper(INativeAdvanceMediaListener iNativeAdvanceMediaListener) {
            this.mListener = iNativeAdvanceMediaListener;
        }

        @Override // com.opos.mobad.ad.e.k
        public void onVideoPlayComplete() {
            INativeAdvanceMediaListener iNativeAdvanceMediaListener = this.mListener;
            if (iNativeAdvanceMediaListener != null) {
                iNativeAdvanceMediaListener.onVideoPlayComplete();
            }
        }

        @Override // com.opos.mobad.ad.e.k
        public void onVideoPlayError(int i, String str) {
            INativeAdvanceMediaListener iNativeAdvanceMediaListener = this.mListener;
            if (iNativeAdvanceMediaListener != null) {
                iNativeAdvanceMediaListener.onVideoPlayError(i, str);
            }
        }

        @Override // com.opos.mobad.ad.e.k
        public void onVideoPlayStart() {
            INativeAdvanceMediaListener iNativeAdvanceMediaListener = this.mListener;
            if (iNativeAdvanceMediaListener != null) {
                iNativeAdvanceMediaListener.onVideoPlayStart();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class NativeFileImp implements INativeAdFile {
        private e mNativeFile;

        public NativeFileImp(e eVar) {
            this.mNativeFile = eVar;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdFile
        public int getHeight() {
            return this.mNativeFile.c();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdFile
        public String getMd5() {
            return this.mNativeFile.b();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdFile
        public String getUrl() {
            return this.mNativeFile.a();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdFile
        public int getWidth() {
            return this.mNativeFile.d();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class NativeVideoFileImp implements INativeAdFile {
        private e mNativeFile;

        public NativeVideoFileImp(e eVar) {
            this.mNativeFile = eVar;
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdFile
        public int getHeight() {
            return this.mNativeFile.c();
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdFile
        public String getMd5() {
            return "";
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdFile
        public String getUrl() {
            return "";
        }

        @Override // com.heytap.msp.mobad.api.params.INativeAdFile
        public int getWidth() {
            return this.mNativeFile.d();
        }
    }

    public NativeAdvanceAd(Context context, String str, INativeAdvanceLoadListener iNativeAdvanceLoadListener) {
        if (context == null || TextUtils.isEmpty(str) || iNativeAdvanceLoadListener == null) {
            Log.e(TAG, "NativeAd Constructor param context and posId and iNativeAdListener can't be null.");
            return;
        }
        this.mContext = context;
        this.mPosId = str;
        this.mListener = getLoadListener(iNativeAdvanceLoadListener);
        initImplIfNeed();
    }

    private boolean initImplIfNeed() {
        if (this.mNativeAdImpl != null) {
            return true;
        }
        if (this.mContext == null || TextUtils.isEmpty(this.mPosId)) {
            return false;
        }
        synchronized (this) {
            if (this.mNativeAdImpl != null) {
                return true;
            }
            this.mNativeAdImpl = ProxyManager.getInstance().a(this.mContext.getApplicationContext(), this.mPosId, this.mListener);
            return this.mNativeAdImpl != null;
        }
    }

    public void destroyAd() {
        if (this.mNativeAdImpl != null) {
            this.mNativeAdImpl.b();
        }
        this.mContext = null;
        this.mPosId = null;
    }

    public int getECPM() {
        if (this.mNativeAdImpl == null) {
            return 0;
        }
        this.mNativeAdImpl.f();
        return 0;
    }

    public NativeAdvanceListenerWrapper getLoadListener(INativeAdvanceLoadListener iNativeAdvanceLoadListener) {
        return new NativeAdvanceListenerWrapper(iNativeAdvanceLoadListener);
    }

    public void loadAd() {
        loadInter((List<String>) null);
    }

    public void loadAdWithData(String str) {
        loadInter(str);
    }

    public void loadInter(String str) {
        if (initImplIfNeed()) {
            this.mNativeAdImpl.a(str);
            return;
        }
        NativeAdvanceListenerWrapper nativeAdvanceListenerWrapper = this.mListener;
        if (nativeAdvanceListenerWrapper != null) {
            nativeAdvanceListenerWrapper.onAdFailed(-1, "inter ad create fail");
        }
    }

    private void loadInter(List<String> list) {
        if (initImplIfNeed()) {
            if (list == null) {
                this.mNativeAdImpl.a();
                return;
            } else {
                this.mNativeAdImpl.a(list);
                return;
            }
        }
        NativeAdvanceListenerWrapper nativeAdvanceListenerWrapper = this.mListener;
        if (nativeAdvanceListenerWrapper != null) {
            nativeAdvanceListenerWrapper.onAdFailed(-1, "inter ad create fail");
        }
    }

    public void loadAd(List<String> list) {
        if (list != null && list.size() > 0) {
            loadInter(new ArrayList(list));
            return;
        }
        NativeAdvanceListenerWrapper nativeAdvanceListenerWrapper = this.mListener;
        if (nativeAdvanceListenerWrapper != null) {
            nativeAdvanceListenerWrapper.onAdFailed(10701, "load error, please check you bidIds");
        }
    }
}
