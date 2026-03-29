package com.wifi.adsdk.entity;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.wifi.adsdk.LxAdManager;
import com.wifi.adsdk.params.LxAdReqParams;
import com.wifi.adsdk.render.ILxAdItem;
import com.wifi.adsdk.render.IRender;
import com.wifi.adsdk.utils.LxAdConst;
import com.wifi.adsdk.utils.LxAdLog;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class LxAdAbsItem implements ILxAdItem, IRender {
    public LxAdBeanData adItem;
    private LxAdBaseView lxAdBaseView;
    protected LxAdReqParams reqParams;

    public void adRemoveDone() {
        LxAdLog.d("LxAdAbsItem adRemoveDone lxAdBaseView " + this.lxAdBaseView);
        LxAdManager.getAdManager().getConfig().getUrlEvent().reportClose(this.adItem);
        LxAdBaseView lxAdBaseView = this.lxAdBaseView;
        if (lxAdBaseView != null) {
            lxAdBaseView.adDestroy();
        }
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public String getAdId() {
        LxAdBeanData lxAdBeanData = this.adItem;
        return lxAdBeanData != null ? lxAdBeanData.getAdId() : "";
    }

    public LxAdBeanData getAdItem() {
        return this.adItem;
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public String getApiId() {
        LxAdBeanData lxAdBeanData = this.adItem;
        return lxAdBeanData != null ? lxAdBeanData.getApiId() : "";
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public String getApiSrcId() {
        LxAdBeanData lxAdBeanData = this.adItem;
        if (lxAdBeanData != null) {
            return lxAdBeanData.getApiSlotId();
        }
        return null;
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public String getAppDeveloper() {
        LxAdBeanData lxAdBeanData = this.adItem;
        return lxAdBeanData != null ? lxAdBeanData.getAdvertiserName() : "";
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public String getAppFunction() {
        LxAdBeanData lxAdBeanData = this.adItem;
        return lxAdBeanData != null ? lxAdBeanData.getDescriptionUrl() : "";
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public String getAppIcon() {
        LxAdBeanData lxAdBeanData = this.adItem;
        return lxAdBeanData != null ? lxAdBeanData.getIconUrl() : "";
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public String getAppName() {
        LxAdBeanData lxAdBeanData = this.adItem;
        return lxAdBeanData != null ? lxAdBeanData.getAppName() : "";
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public String getAppPermission() {
        LxAdBeanData lxAdBeanData = this.adItem;
        return lxAdBeanData != null ? lxAdBeanData.getPermissionUrl() : "";
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public String getAppPrivacy() {
        LxAdBeanData lxAdBeanData = this.adItem;
        return lxAdBeanData != null ? lxAdBeanData.getPrivacyPolicyUrl() : "";
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public long getAppSize() {
        if (this.adItem != null) {
            return r0.getAppSize();
        }
        return 0L;
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public String getAppVersion() {
        LxAdBeanData lxAdBeanData = this.adItem;
        return lxAdBeanData != null ? lxAdBeanData.getAppVersion() : "";
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public List<String> getClicks() {
        LxAdBeanData lxAdBeanData = this.adItem;
        if (lxAdBeanData == null || lxAdBeanData.getTrackingList() == null) {
            return null;
        }
        return this.adItem.getTrackingList().getClickLink();
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public List<String> getDeeplinkSuccessLink() {
        LxAdBeanData lxAdBeanData = this.adItem;
        if (lxAdBeanData == null || lxAdBeanData.getTrackingList() == null) {
            return null;
        }
        return this.adItem.getTrackingList().getDeeplinkSuccessLink();
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public String getDeeplinkUrl() {
        LxAdBeanData lxAdBeanData = this.adItem;
        return (lxAdBeanData == null || lxAdBeanData.getClickTargetUrl() == null) ? "" : this.adItem.getClickTargetUrl().getCustomizedInvokeUrl();
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public String getDescription() {
        LxAdBeanData lxAdBeanData = this.adItem;
        return lxAdBeanData != null ? lxAdBeanData.getDescription() : "";
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public List<String> getDownloadFinish() {
        LxAdBeanData lxAdBeanData = this.adItem;
        if (lxAdBeanData == null || lxAdBeanData.getTrackingList() == null) {
            return null;
        }
        return this.adItem.getTrackingList().getDownloadFinishedLink();
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public String getDownloadMd5() {
        return "";
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public List<String> getDownloadStart() {
        LxAdBeanData lxAdBeanData = this.adItem;
        if (lxAdBeanData == null || lxAdBeanData.getTrackingList() == null) {
            return null;
        }
        return this.adItem.getTrackingList().getDownloadStartedLink();
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public String getDownloadUrl() {
        LxAdBeanData lxAdBeanData = this.adItem;
        return (lxAdBeanData == null || lxAdBeanData.getClickTargetUrl() == null) ? "" : this.adItem.getClickTargetUrl().getPackageUrl();
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public int getEcpm() {
        LxAdBeanData lxAdBeanData = this.adItem;
        if (lxAdBeanData != null) {
            return lxAdBeanData.getEcpm();
        }
        return 0;
    }

    public LxEventReplace getEventReplace() {
        LxAdBeanData lxAdBeanData = this.adItem;
        if (lxAdBeanData != null) {
            return lxAdBeanData.getEventReplace();
        }
        return null;
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public View getExpressView(Context context) {
        return null;
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public List<SingleImage> getImageList() {
        LxAdBeanData lxAdBeanData = this.adItem;
        if (lxAdBeanData == null || lxAdBeanData.getGroupImage() == null) {
            return null;
        }
        return this.adItem.getGroupImage();
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public String getImageUrl() {
        LxAdBeanData lxAdBeanData = this.adItem;
        return lxAdBeanData != null ? lxAdBeanData.getSingleImage() != null ? this.adItem.getSingleImage().getUrl() : (this.adItem.getGroupImage() == null || this.adItem.getGroupImage().size() <= 0) ? "" : this.adItem.getGroupImage().get(0).getUrl() : "";
    }

    public int getImgHeight() {
        LxAdBeanData lxAdBeanData = this.adItem;
        if (lxAdBeanData != null) {
            if (lxAdBeanData.getSingleImage() != null) {
                return this.adItem.getSingleImage().getHeight();
            }
            if (this.adItem.getGroupImage() != null && this.adItem.getGroupImage().size() > 0) {
                return this.adItem.getGroupImage().get(0).getHeight();
            }
        }
        return 0;
    }

    public int getImgWidth() {
        LxAdBeanData lxAdBeanData = this.adItem;
        if (lxAdBeanData != null) {
            if (lxAdBeanData.getSingleImage() != null) {
                return this.adItem.getSingleImage().getWidth();
            }
            if (this.adItem.getGroupImage() != null && this.adItem.getGroupImage().size() > 0) {
                return this.adItem.getGroupImage().get(0).getWidth();
            }
        }
        return 0;
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public List<String> getInstalleds() {
        LxAdBeanData lxAdBeanData = this.adItem;
        if (lxAdBeanData == null || lxAdBeanData.getTrackingList() == null) {
            return null;
        }
        return this.adItem.getTrackingList().getInstallFinishedLink();
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public String getLandingUrl() {
        LxAdBeanData lxAdBeanData = this.adItem;
        return (lxAdBeanData == null || lxAdBeanData.getClickTargetUrl() == null) ? "" : this.adItem.getClickTargetUrl().getLandingPageUrl();
    }

    public LxAdBaseView getLxAdBaseView() {
        return this.lxAdBaseView;
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public int getMaterialHeight() {
        LxAdBeanData lxAdBeanData = this.adItem;
        if (lxAdBeanData != null) {
            if (lxAdBeanData.getMaterialType() == 3) {
                if (this.adItem.getVideo() != null) {
                    return this.adItem.getVideo().getVideoHeight();
                }
                if (this.adItem.getSingleImage() != null) {
                    return this.adItem.getSingleImage().getHeight();
                }
                if (this.adItem.getGroupImage() != null && this.adItem.getGroupImage().size() > 0) {
                    return this.adItem.getGroupImage().get(0).getHeight();
                }
            } else {
                if (this.adItem.getSingleImage() != null) {
                    return this.adItem.getSingleImage().getHeight();
                }
                if (this.adItem.getGroupImage() != null && this.adItem.getGroupImage().size() > 0) {
                    return this.adItem.getGroupImage().get(0).getHeight();
                }
                if (this.adItem.getVideo() != null) {
                    return this.adItem.getVideo().getVideoHeight();
                }
            }
        }
        return 0;
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public int getMaterialType() {
        LxAdBeanData lxAdBeanData = this.adItem;
        if (lxAdBeanData != null) {
            return lxAdBeanData.getMaterialType();
        }
        return 0;
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public int getMaterialWidth() {
        LxAdBeanData lxAdBeanData = this.adItem;
        if (lxAdBeanData != null) {
            if (lxAdBeanData.getMaterialType() == 3) {
                if (this.adItem.getVideo() != null) {
                    return this.adItem.getVideo().getVideoWidth();
                }
                if (this.adItem.getSingleImage() != null) {
                    return this.adItem.getSingleImage().getWidth();
                }
                if (this.adItem.getGroupImage() != null && this.adItem.getGroupImage().size() > 0) {
                    return this.adItem.getGroupImage().get(0).getWidth();
                }
            } else {
                if (this.adItem.getSingleImage() != null) {
                    return this.adItem.getSingleImage().getWidth();
                }
                if (this.adItem.getGroupImage() != null && this.adItem.getGroupImage().size() > 0) {
                    return this.adItem.getGroupImage().get(0).getWidth();
                }
                if (this.adItem.getVideo() != null) {
                    return this.adItem.getVideo().getVideoWidth();
                }
            }
        }
        return 0;
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public String getPackageName() {
        return "";
    }

    public LxAdReqParams getReqParams() {
        return this.reqParams;
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public String getRequestId() {
        LxAdBeanData lxAdBeanData = this.adItem;
        return lxAdBeanData != null ? lxAdBeanData.getRequestId() : "";
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public List<String> getShows() {
        LxAdBeanData lxAdBeanData = this.adItem;
        if (lxAdBeanData == null || lxAdBeanData.getTrackingList() == null) {
            return null;
        }
        return this.adItem.getTrackingList().getShowLink();
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public SingleImage getSingleImage() {
        LxAdBeanData lxAdBeanData = this.adItem;
        if (lxAdBeanData != null) {
            return lxAdBeanData.getSingleImage();
        }
        return null;
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public String getSlotId() {
        LxAdBeanData lxAdBeanData = this.adItem;
        return lxAdBeanData != null ? lxAdBeanData.getSlotId() : "";
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public String getTitle() {
        LxAdBeanData lxAdBeanData = this.adItem;
        return lxAdBeanData != null ? lxAdBeanData.getTitle() : "";
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public List<String> getVideo25s() {
        LxAdBeanData lxAdBeanData = this.adItem;
        if (lxAdBeanData == null || lxAdBeanData.getTrackingList() == null) {
            return null;
        }
        return this.adItem.getTrackingList().getVideoShow25ppLink();
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public List<String> getVideo50s() {
        LxAdBeanData lxAdBeanData = this.adItem;
        if (lxAdBeanData == null || lxAdBeanData.getTrackingList() == null) {
            return null;
        }
        return this.adItem.getTrackingList().getVideoShow50ppLink();
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public List<String> getVideo75s() {
        LxAdBeanData lxAdBeanData = this.adItem;
        if (lxAdBeanData == null || lxAdBeanData.getTrackingList() == null) {
            return null;
        }
        return this.adItem.getTrackingList().getVideoShow75ppLink();
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public int getVideoDura() {
        LxAdBeanData lxAdBeanData = this.adItem;
        if (lxAdBeanData == null || lxAdBeanData.getVideo() == null) {
            return 0;
        }
        return this.adItem.getVideo().getVideoDuration();
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public List<String> getVideoEs() {
        LxAdBeanData lxAdBeanData = this.adItem;
        if (lxAdBeanData == null || lxAdBeanData.getTrackingList() == null) {
            return null;
        }
        return this.adItem.getTrackingList().getVideoShowEndLink();
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public int getVideoHeight() {
        LxAdBeanData lxAdBeanData = this.adItem;
        if (lxAdBeanData == null || lxAdBeanData.getVideo() == null) {
            return 0;
        }
        return this.adItem.getVideo().getVideoHeight();
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public String getVideoImgUrl() {
        LxAdBeanData lxAdBeanData = this.adItem;
        return (lxAdBeanData == null || lxAdBeanData.getVideo() == null) ? "" : this.adItem.getVideo().getPreImgUrl();
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public List<String> getVideoSs() {
        LxAdBeanData lxAdBeanData = this.adItem;
        if (lxAdBeanData == null || lxAdBeanData.getTrackingList() == null) {
            return null;
        }
        return this.adItem.getTrackingList().getVideoShowStartLink();
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public String getVideoUrl() {
        LxAdBeanData lxAdBeanData = this.adItem;
        return (lxAdBeanData == null || lxAdBeanData.getVideo() == null) ? "" : this.adItem.getVideo().getVideoUrl();
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    @Nullable
    public View getVideoView(@NonNull Context context) {
        LxAdBaseView lxAdBaseView = this.lxAdBaseView;
        if (lxAdBaseView != null) {
            return lxAdBaseView.getVideoView();
        }
        return null;
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public int getVideoWidth() {
        LxAdBeanData lxAdBeanData = this.adItem;
        if (lxAdBeanData == null || lxAdBeanData.getVideo() == null) {
            return 0;
        }
        return this.adItem.getVideo().getVideoWidth();
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public boolean isDownloadAd() {
        LxAdBeanData lxAdBeanData = this.adItem;
        if (lxAdBeanData == null || lxAdBeanData.getClickTargetUrl() == null) {
            return false;
        }
        return (TextUtils.isEmpty(this.adItem.getClickTargetUrl().getMarketUrl()) && TextUtils.isEmpty(this.adItem.getClickTargetUrl().getPackageUrl())) ? false : true;
    }

    public abstract void setAdBeanData(LxAdBeanData lxAdBeanData, LxAdReqParams lxAdReqParams);

    public void setLxAdBaseView(LxAdBaseView lxAdBaseView) {
        this.lxAdBaseView = lxAdBaseView;
    }

    public void setShowAct(Activity activity) {
        LxAdBaseView lxAdBaseView = this.lxAdBaseView;
        if (lxAdBaseView != null) {
            lxAdBaseView.setShowAct(activity);
        }
    }

    public void toShowEvent() {
        LxAdBeanData lxAdBeanData = this.adItem;
        if (lxAdBeanData != null) {
            LxAdManager.getAdManager().getConfig().getReporter().onEvent(LxAdConst.EventKey.LXSDK_TOSHOW, LxAdEventParams.toJson(LxAdEventParams.createEventParams(this.reqParams, lxAdBeanData.getEcpm(), this.adItem.getMaterialType(), this.adItem.getApiId(), 0, "", this.adItem.getApiSlotId(), "")));
        }
    }

    @Override // com.wifi.adsdk.render.IRender
    public void showTempAd() {
    }

    @Override // com.wifi.adsdk.render.IRender
    public void showPopAd(Activity activity) {
    }

    @Override // com.wifi.adsdk.render.IRender
    public void showSplash(ViewGroup viewGroup) {
    }
}
