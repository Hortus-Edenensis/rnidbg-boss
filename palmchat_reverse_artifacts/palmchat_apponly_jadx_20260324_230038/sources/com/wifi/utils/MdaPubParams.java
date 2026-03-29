package com.wifi.utils;

import android.app.Application;
import android.os.Build;
import com.lantern.core.AbsPubParams;
import com.oplus.tblplayer.misc.MediaInfo;
import com.zenmen.palmchat.c;
import defpackage.ac1;
import defpackage.eb4;
import defpackage.hx3;
import defpackage.k86;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class MdaPubParams extends AbsPubParams {
    private static final String[] eventList = {"lx_client_login_0", "lx_client_app_1", "lx_client_login_popagree", "lx_client_login_devicepermision", "lx_client_login_devicepopshow", "lx_client_login_devicepopclick", "lx_client_login_wifi_start", "lx_client_login_wifi_return", "lx_client_login_mobile_start", "lx_client_login_mobile_return", "lx_client_login_agreement_linkclick", "lx_client_login_loginpageshow", "lx_client_login_loginpageclick", "lx_client_login_loginpageback", "lx_client_quicklogin_show", "lx_client_quicklogin_agreement", "lx_client_quicklogin_other", "lx_client_quicklogin_click", "lx_client_quicklogin_popshow", "lx_client_quicklogin_popclick", "lx_client_quicklogin_popclose", "lx_client_quicklogin_req", "lx_client_quicklogin_resp", "lx_client_auth_req", "lx_client_auth_resp", "lx_client_login_jump_complete", "lx_client_messagelogin_show", "lx_client_messagelogin_back", "lx_client_messagelogin_input", "lx_client_messagelogin_input_complete", "lx_client_messagelogin_agreement", "lx_client_messagelogin_click", "lx_client_messagelogin_popshow", "lx_client_messagelogin_popclick", "lx_client_messagelogin_popclose", "lx_client_messagelogin_send", "lx_client_messagelogin_ret", "lx_client_messagelogin_freeaccess", "lx_client_messagelogin_verify_show", "lx_client_messagelogin_verify_back", "lx_client_messagelogin_verify_dlg_wait", "lx_client_messagelogin_verify_dlg_back", "lx_client_messagelogin_verify_timeout", "lx_client_messagelogin_verify_resend", "lx_client_messagelogin_verify_input", "lx_client_messagelogin_verify_complete", "lx_client_messagelogin_verify_send", "lx_client_messagelogin_verify_ret", "lx_client_app_21", "lx_client_frd_29", "lx_client_app_3", "lx_client_app_5", "lx_client_near_31", "lx_client_app_4", "lx_client_multi_934", "advertising_message_request", "advertising_message_return", "advertising_match_jump", "newpagephotoupload", "pagephotoupload_upright_skip", "newpagephotoupload_center_upload", "pagediscover_pagegenderage", "pagediscover_pagegenderage_next", "pagediscover_pagegenderage_close", "pagediscover_pageleadtag", "pagediscover_pageleadtag_next", "pagediscover_pageleadtag_close", "reggenderage_show", "reggenderage_clickmale", "reggenderage_clickfamale", "reggenderage_clicknext", "reggenderage_clickage", "reggenderage_clickback", "reggenderage_detaintop", "reggenderage_detaintop_exit", "reggenderage_detaintop_continue", "regphotonick_show", "regphotonick_clickphoto", "regphotonick_clickphotodone", "regphotonick_namewrite", "regphotonick_clicknext", "regphotonick_clickback", "regphotonick_clickskip", "regphotonick_complete", "regphotonick_cancel", "regoccupation_show", "regoccupation_clickskip", "regoccupation_clicknext", "regincome_show", "regincome_clickback", "regincome_clickskip", "regincome_clicknext", "regintention_show", "regintention_clickback", "regintention_clickskip", "regintention_clicknext"};
    private Application app;
    private boolean debug;

    public MdaPubParams(Application application, boolean z) {
        this.app = application;
        this.debug = z;
    }

    @Override // com.lantern.core.AbsPubParams, com.lantern.core.business.IPubParams
    public List<String> getAdvancedPresetEventList() {
        return Arrays.asList(eventList);
    }

    @Override // com.lantern.core.business.IPubParams
    public String getAesIv() {
        return ConstantMix.AES_IV;
    }

    @Override // com.lantern.core.business.IPubParams
    public String getAesKey() {
        return ConstantMix.AES_KEY;
    }

    @Override // com.lantern.core.business.IPubParams
    public String getAndroidId() {
        return ac1.p;
    }

    @Override // com.lantern.core.business.IPubParams
    public String getAppId() {
        try {
            return eb4.b();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.lantern.core.business.IPubParams
    public String getAraCode() {
        return null;
    }

    @Override // com.lantern.core.business.IPubParams
    public String getBssid() {
        return MediaInfo.RENDERER_TYPE_UNKNOWN;
    }

    @Override // com.lantern.core.business.IPubParams
    public long getBuketId() {
        return -1111L;
    }

    @Override // com.lantern.core.business.IPubParams
    public String getChanId() {
        try {
            return ac1.m;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.lantern.core.AbsPubParams, com.lantern.core.business.IPubParams
    public String getConfigUrl() {
        return ServerConstantMix.EVENT_CONFIG_DEFAULT_URL;
    }

    @Override // com.lantern.core.business.IPubParams
    public String getDHID() {
        try {
            return WKID.getInstance().get(this.app);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.lantern.core.business.IPubParams
    public long getExpId() {
        return -1111L;
    }

    @Override // com.lantern.core.business.IPubParams
    public long getGroupId() {
        return -1111L;
    }

    @Override // com.lantern.core.business.IPubParams
    public String getIMEI() {
        return MediaInfo.RENDERER_TYPE_UNKNOWN;
    }

    @Override // com.lantern.core.AbsPubParams, com.lantern.core.business.IPubParams
    public String getInstEventUrl() {
        return this.debug ? "http://wifi3a.51y5.net/alpsmda/fcompb.pgs" : ServerConstantMix.INSERT_EVENT_DEFAULT_HOST;
    }

    @Override // com.lantern.core.business.IPubParams
    public String getLanguage() {
        return MdaParamUtils.getLanguage();
    }

    @Override // com.lantern.core.business.IPubParams
    public String getLati() {
        try {
            return Build.MODEL;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.lantern.core.business.IPubParams
    public String getLongi() {
        try {
            return Build.MANUFACTURER;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.lantern.core.business.IPubParams
    public String getMac() {
        return MediaInfo.RENDERER_TYPE_UNKNOWN;
    }

    @Override // com.lantern.core.business.IPubParams
    public String getMapSp() {
        return "a";
    }

    @Override // com.lantern.core.business.IPubParams
    public String getNetModel() {
        return hx3.e();
    }

    @Override // com.lantern.core.AbsPubParams, com.lantern.core.business.IPubParams
    public String getOfflineEventUrl() {
        return this.debug ? "http://wifi3a.51y5.net/alpsmda/fcompb.pgs" : ServerConstantMix.OFFLINE_EVENT_DEFAULT_HOST;
    }

    @Override // com.lantern.core.business.IPubParams
    public String getOid() {
        return null;
    }

    @Override // com.lantern.core.AbsPubParams, com.lantern.core.business.IPubParams
    public String getOnceEventUrl() {
        return this.debug ? "http://wifi3a.51y5.net/alpsmda/fcompb.pgs" : ServerConstantMix.ONCE_EVENT_DEFAULT_HOST;
    }

    @Override // com.lantern.core.business.IPubParams
    public String getOrigChanId() {
        try {
            return ac1.m;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.lantern.core.business.IPubParams
    public String getPid() {
        return null;
    }

    @Override // com.lantern.core.AbsPubParams, com.lantern.core.business.IPubParams
    public List<String> getPresetEventList() {
        return Arrays.asList(eventList);
    }

    @Override // com.lantern.core.business.IPubParams
    public String getProcessId() {
        return System.currentTimeMillis() + "";
    }

    @Override // com.lantern.core.business.IPubParams
    public String getProcessName() {
        return k86.m(c.b());
    }

    @Override // com.lantern.core.business.IPubParams
    public String getSN() {
        return null;
    }

    @Override // com.lantern.core.business.IPubParams
    public String getSR() {
        return null;
    }

    @Override // com.lantern.core.business.IPubParams
    public String getSessionId() {
        return System.currentTimeMillis() + "";
    }

    @Override // com.lantern.core.business.IPubParams
    public String getSsid() {
        return MediaInfo.RENDERER_TYPE_UNKNOWN;
    }

    @Override // com.lantern.core.business.IPubParams
    public long getTs() {
        return System.currentTimeMillis();
    }

    @Override // com.lantern.core.business.IPubParams
    public String getUHID() {
        try {
            return MdaParamUtils.getUhid();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.lantern.core.business.IPubParams
    public String getUserToken() {
        return null;
    }

    @Override // com.lantern.core.business.IPubParams
    public int getVerCode() {
        try {
            return Integer.parseInt(ac1.f);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // com.lantern.core.business.IPubParams
    public String getVerName() {
        return ac1.g;
    }

    @Override // com.lantern.core.business.IPubParams
    public long getVersionNun() {
        return -1111L;
    }

    @Override // com.lantern.core.AbsPubParams, com.lantern.core.business.IPubParams
    public String getWifiEventUrl() {
        return this.debug ? "http://wifi3a.51y5.net/alpsmda/fcompb.pgs" : ServerConstantMix.WIFI_EVENT_DEFAULT_HOST;
    }

    @Override // com.lantern.core.business.IPubParams
    public boolean isForceground() {
        try {
            return !c.a().isBackground();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.lantern.core.business.IPubParams
    public boolean isUseLimit() {
        return true;
    }

    @Override // com.lantern.core.business.IPubParams
    public boolean openDbError() {
        return false;
    }
}
