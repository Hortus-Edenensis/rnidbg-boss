package com.heytap.msp.mobad.api.params;

import android.content.Context;
import android.view.View;
import com.heytap.msp.mobad.api.ad.IBidding;
import com.heytap.msp.mobad.api.listener.INativeAdvanceInteractListener;
import com.heytap.msp.mobad.api.listener.INativeAdvanceMediaListener;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface INativeAdvanceData extends IBidding {
    public static final int APP_INFO_LINE_ONE = 1;
    public static final int APP_INFO_LINE_TWO = 2;
    public static final int CONTENT_TYPE_APP = 2;
    public static final int CONTENT_TYPE_BRAND_TOPIC = 4;
    public static final int CONTENT_TYPE_INSTANT = 3;
    public static final int CONTENT_TYPE_LINK = 1;
    public static final int CONTENT_TYPE_LINK_APP = 6;
    public static final int CONTENT_TYPE_LIVE = 8;
    public static final int CONTENT_TYPE_THIRD_PARTY_APP = 5;
    public static final int CONTENT_TYPE_UNKNOWN = 0;
    public static final int CONTENT_TYPE_WECHAT_APPLET = 7;
    public static final int CONTENT_TYPE_WECHAT_NATIVE = 9;
    public static final int CREATIVE_TYPE_NATIVE_VERTICAL_IMAGE = 15;
    public static final int CREATIVE_TYPE_NATIVE_VIDEO = 13;
    public static final int CREATIVE_TYPE_NATIVE_VIDEO_VERTICAL = 16;
    public static final int CREATIVE_TYPE_TEXT_ICON = 3;
    public static final int CREATIVE_TYPE_TEXT_ICON_320X210 = 7;
    public static final int CREATIVE_TYPE_TEXT_ICON_640X320 = 6;
    public static final int CREATIVE_TYPE_TEXT_ICON_GROUP_320X210 = 8;
    public static final int DEFAULT_APP_INFO_BOTTOM_MARGIN = 38;
    public static final int DEFAULT_APP_INFO_START_MARGIN = 16;
    public static final int DEFAULT_NATIVE_AD_BUTTON_BACKGROUND_COLOR = -16777216;
    public static final int DEFAULT_NATIVE_AD_BUTTON_BORDER_COLOR = 0;
    public static final int DEFAULT_NATIVE_AD_BUTTON_BORDER_RADIUS = 50;
    public static final int DEFAULT_NATIVE_AD_BUTTON_BOTTOM_MARGIN = 16;
    public static final int DEFAULT_NATIVE_AD_BUTTON_END_MARGIN = 16;
    public static final int DEFAULT_NATIVE_AD_BUTTON_HEIGHT = 32;
    public static final int DEFAULT_NATIVE_AD_BUTTON_TEXT_COLOR = -1;
    public static final int DEFAULT_NATIVE_AD_BUTTON_TEXT_SIZE = 12;
    public static final int DEFAULT_NATIVE_AD_BUTTON_WIDTH = 74;
    public static final int DEFAULT_NATIVE_AD_INTERACTIVE_COMPONENT_START_MARGIN = 12;
    public static final int DEFAULT_NATIVE_AD_INTERACTIVE_COMPONENT_TOP_MARGIN = 12;
    public static final int DEFAULT_PRIVACY_BOTTOM_MARGIN = 16;
    public static final int DEFAULT_PRIVACY_START_MARGIN = 16;
    public static final String KEY_CLOSE_BUTTON_POSITION = "closeBtnPosition";
    public static final String KEY_NATIVE_AD_BUTTON = "nativeAdButton";
    public static final String KEY_NATIVE_AD_BUTTON_BACKGROUND_COLOR = "adButtonBackgroundColor";
    public static final String KEY_NATIVE_AD_BUTTON_BORDER_COLOR = "adButtonBorderColor";
    public static final String KEY_NATIVE_AD_BUTTON_BORDER_RADIUS = "adButtonBorderRadius";
    public static final String KEY_NATIVE_AD_BUTTON_BOTTOM_MARGIN = "adButtonBottomMargin";
    public static final String KEY_NATIVE_AD_BUTTON_END_MARGIN = "adButtonEndMargin";
    public static final String KEY_NATIVE_AD_BUTTON_HEIGHT = "adButtonHeight";
    public static final String KEY_NATIVE_AD_BUTTON_TEXT_COLOR = "adButtonTextColor";
    public static final String KEY_NATIVE_AD_BUTTON_TEXT_SIZE = "adButtonTextSize";
    public static final String KEY_NATIVE_AD_BUTTON_WIDTH = "adButtonWidth";
    public static final String KEY_NATIVE_AD_INTERACTIVE_COMPONENT_SIZE_TYPE = "interactiveComponentSizeType";
    public static final String KEY_NATIVE_AD_INTERACTIVE_COMPONENT_START_MARGIN = "interactiveComponentStartMargin";
    public static final String KEY_NATIVE_AD_INTERACTIVE_COMPONENT_TOP_MARGIN = "interactiveComponentTopMargin";
    public static final String KEY_NATIVE_AD_IS_SHOW_INTERACTIVE_COMPONENT = "isShowInteractiveComponent";
    public static final String KEY_NATIVE_APP_INFO_BOTTOM_MARGIN = "appInfoBottomMargin";
    public static final String KEY_NATIVE_APP_INFO_LINES = "appInfoLines";
    public static final String KEY_NATIVE_APP_INFO_START_MARGIN = "appInfoStartMargin";
    public static final String KEY_NATIVE_CLOSE_BUTTON = "nativeCloseBtn";
    public static final String KEY_NATIVE_PRIVACY_BOTTOM_MARGIN = "privacyBottomMargin";
    public static final String KEY_NATIVE_PRIVACY_COMPONENT = "nativePrivacyComponent";
    public static final String KEY_NATIVE_PRIVACY_START_MARGIN = "privacyStartMargin";
    public static final String POSITION_BOTTOM_LEFT = "bottomLeft";
    public static final String POSITION_BOTTOM_RIGHT = "bottomRight";
    public static final String POSITION_TOP_LEFT = "topLeft";
    public static final String POSITION_TOP_RIGHT = "topRight";
    public static final int VALUE_NATIVE_AD_INTERACTIVE_COMPONENT_SIZE_TYPE_BIG = 1;
    public static final int VALUE_NATIVE_AD_INTERACTIVE_COMPONENT_SIZE_TYPE_SMALL = 0;
    public static final int VALUE_NATIVE_AD_IS_SHOW_INTERACTIVE_COMPONENT_NO = 0;
    public static final int VALUE_NATIVE_AD_IS_SHOW_INTERACTIVE_COMPONENT_YES = 1;

    void bindMediaView(Context context, MediaView mediaView, INativeAdvanceMediaListener iNativeAdvanceMediaListener);

    @Deprecated
    void bindToComplianceView(Context context, List<View> list, INativeComplianceListener iNativeComplianceListener, List<View> list2, INativeComplianceListener iNativeComplianceListener2);

    void bindToComplianceView(Context context, List<View> list, INativeComplianceListener iNativeComplianceListener, List<View> list2, INativeComplianceListener iNativeComplianceListener2, List<View> list3, INativeComplianceListener iNativeComplianceListener3);

    void bindToView(Context context, NativeAdvanceContainer nativeAdvanceContainer, List<View> list);

    void bindToView(Context context, NativeAdvanceContainer nativeAdvanceContainer, List<View> list, List<View> list2);

    void bindToView(Context context, NativeAdvanceContainer nativeAdvanceContainer, Map<String, Object> map, List<View> list, List<View> list2);

    boolean canIUse(String str);

    String getBidId();

    String getClickBnText();

    INativeAdvanceComplianceInfo getComplianceInfo();

    int getContentType();

    int getCreativeType();

    String getDesc();

    String getExtra();

    List<INativeAdFile> getIconFiles();

    List<INativeAdFile> getImgFiles();

    INativeAdFile getLogoFile();

    String getTitle();

    int getVideoDuration();

    List<INativeAdFile> getVideoFiles();

    boolean isAdValid();

    void release();

    void setInteractListener(INativeAdvanceInteractListener iNativeAdvanceInteractListener);
}
