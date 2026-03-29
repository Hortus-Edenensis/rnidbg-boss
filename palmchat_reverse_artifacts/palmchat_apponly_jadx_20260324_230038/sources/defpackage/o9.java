package defpackage;

import android.app.Application;
import com.wifi.AllinoneHelper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class o9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f19715a = nl0.g();
    public static final String[] b = {"lx_client_login_0", "lx_client_app_1", "lx_client_login_popagree", "lx_client_login_devicepermision", "lx_client_login_devicepopshow", "lx_client_login_devicepopclick", "lx_client_login_wifi_start", "lx_client_login_wifi_return", "lx_client_login_mobile_start", "lx_client_login_mobile_return", "lx_client_login_agreement_linkclick", "lx_client_login_loginpageshow", "lx_client_login_loginpageclick", "lx_client_login_loginpageback", "lx_client_quicklogin_show", "lx_client_quicklogin_agreement", "lx_client_quicklogin_other", "lx_client_quicklogin_click", "lx_client_quicklogin_popshow", "lx_client_quicklogin_popclick", "lx_client_quicklogin_popclose", "lx_client_quicklogin_req", "lx_client_quicklogin_resp", "lx_client_auth_req", "lx_client_auth_resp", "lx_client_login_jump_complete", "lx_client_messagelogin_show", "lx_client_messagelogin_back", "lx_client_messagelogin_input", "lx_client_messagelogin_input_complete", "lx_client_messagelogin_agreement", "lx_client_messagelogin_click", "lx_client_messagelogin_popshow", "lx_client_messagelogin_popclick", "lx_client_messagelogin_popclose", "lx_client_messagelogin_send", "lx_client_messagelogin_ret", "lx_client_messagelogin_freeaccess", "lx_client_messagelogin_verify_show", "lx_client_messagelogin_verify_back", "lx_client_messagelogin_verify_dlg_wait", "lx_client_messagelogin_verify_dlg_back", "lx_client_messagelogin_verify_timeout", "lx_client_messagelogin_verify_resend", "lx_client_messagelogin_verify_input", "lx_client_messagelogin_verify_complete", "lx_client_messagelogin_verify_send", "lx_client_messagelogin_verify_ret", "lx_client_app_21", "lx_client_frd_29", "lx_client_app_3", "lx_client_app_5", "lx_client_near_31", "lx_client_app_4", "lx_client_multi_934", "advertising_message_request", "advertising_message_return", "advertising_match_jump", "newpagephotoupload", "pagephotoupload_upright_skip", "newpagephotoupload_center_upload", "pagediscover_pagegenderage", "pagediscover_pagegenderage_next", "pagediscover_pagegenderage_close", "pagediscover_pageleadtag", "pagediscover_pageleadtag_next", "pagediscover_pageleadtag_close", "reggenderage_show", "reggenderage_clickmale", "reggenderage_clickfamale", "reggenderage_clicknext", "reggenderage_clickage", "reggenderage_clickback", "reggenderage_detaintop", "reggenderage_detaintop_exit", "reggenderage_detaintop_continue", "regphotonick_show", "regphotonick_clickphoto", "regphotonick_clickphotodone", "regphotonick_namewrite", "regphotonick_clicknext", "regphotonick_clickback", "regphotonick_clickskip", "regphotonick_complete", "regphotonick_cancel", "regoccupation_show", "regoccupation_clickskip", "regoccupation_clicknext", "regincome_show", "regincome_clickback", "regincome_clickskip", "regincome_clicknext", "regintention_show", "regintention_clickback", "regintention_clickskip", "regintention_clicknext"};

    public static void a(Application application) {
        AllinoneHelper.initAnalytics(application);
        AllinoneHelper.initSM(application);
        AllinoneHelper.initMDA(application);
    }
}
