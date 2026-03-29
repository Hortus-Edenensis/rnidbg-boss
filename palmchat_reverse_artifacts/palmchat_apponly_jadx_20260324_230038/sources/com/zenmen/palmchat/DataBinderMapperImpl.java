package com.zenmen.palmchat;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.zenmen.palmchat.databinding.ActivityAllNoticeSettingsBindingImpl;
import com.zenmen.palmchat.databinding.ActivityDynamicExposeHomeBindingImpl;
import com.zenmen.palmchat.databinding.ActivitySuperExposeCityChoseBindingImpl;
import com.zenmen.palmchat.databinding.ActivitySuperExposeCityChoseLabelItemBindingImpl;
import com.zenmen.palmchat.databinding.ActivitySuperExposeHomeBindingImpl;
import com.zenmen.palmchat.databinding.ActivityTrackHomeBindingImpl;
import com.zenmen.palmchat.databinding.DynamicTrackRecycleviewItemBindingImpl;
import com.zenmen.palmchat.databinding.FragmentDhvideoContentBindingImpl;
import com.zenmen.palmchat.databinding.FragmentDynamicTrackBindingImpl;
import com.zenmen.palmchat.databinding.FragmentSuperExposeMyDynamicBindingImpl;
import com.zenmen.palmchat.databinding.FragmentSuperExposeMyselfBindingImpl;
import com.zenmen.palmchat.databinding.FragmentTrackCommonBindingImpl;
import com.zenmen.palmchat.databinding.FragmentUserTrackBindingImpl;
import com.zenmen.palmchat.databinding.LayoutActivityPersonalInfoNewBindingImpl;
import com.zenmen.palmchat.databinding.LayoutActivityPersonalInfoPortriatListBindingImpl;
import com.zenmen.palmchat.databinding.LayoutActivityVoiceMatchBindingImpl;
import com.zenmen.palmchat.databinding.LayoutChatEnergyViewBindingImpl;
import com.zenmen.palmchat.databinding.LayoutSuperExposeNumAllBindingImpl;
import com.zenmen.palmchat.databinding.LayoutUserDetailEnergyView2BindingImpl;
import com.zenmen.palmchat.databinding.LayoutUserDetailEnergyViewBindingImpl;
import com.zenmen.palmchat.databinding.LayoutVideoMatchPanelBindingImpl;
import com.zenmen.palmchat.databinding.LayoutVoiceMatchPanelBindingImpl;
import com.zenmen.palmchat.databinding.ListitemDynamicExposeHomeBuyBindingImpl;
import com.zenmen.palmchat.databinding.ListitemDynamicExposeHomeDynamicBindingImpl;
import com.zenmen.palmchat.databinding.LovematchPopNewMatchBindingImpl;
import com.zenmen.palmchat.databinding.LovematchPopNewMsgBindingImpl;
import com.zenmen.palmchat.databinding.NewPeopleMatchLikedLoadingFooterBindingImpl;
import com.zenmen.palmchat.databinding.PopupEnergyTipBindingImpl;
import com.zenmen.palmchat.databinding.SuperExposeNumLayoutItemBindingImpl;
import com.zenmen.palmchat.databinding.UserTrackFooterViewBindingImpl;
import com.zenmen.palmchat.databinding.UserTrackRecycleviewItemBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class DataBinderMapperImpl extends DataBinderMapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseIntArray f12075a;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SparseArray<String> f12076a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(9);
            f12076a = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "bean");
            sparseArray.put(2, "bridge");
            sparseArray.put(3, "clickListener");
            sparseArray.put(4, MediationConstant.RIT_TYPE_FEED);
            sparseArray.put(5, "feedVM");
            sparseArray.put(6, "footBean");
            sparseArray.put(7, "mBean");
            sparseArray.put(8, "showBridge");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HashMap<String, Integer> f12077a;

        static {
            HashMap<String, Integer> map = new HashMap<>(31);
            f12077a = map;
            map.put("layout/activity_all_notice_settings_0", Integer.valueOf(R.layout.activity_all_notice_settings));
            map.put("layout/activity_dynamic_expose_home_0", Integer.valueOf(R.layout.activity_dynamic_expose_home));
            map.put("layout/activity_super_expose_city_chose_0", Integer.valueOf(R.layout.activity_super_expose_city_chose));
            map.put("layout/activity_super_expose_city_chose_label_item_0", Integer.valueOf(R.layout.activity_super_expose_city_chose_label_item));
            map.put("layout/activity_super_expose_home_0", Integer.valueOf(R.layout.activity_super_expose_home));
            map.put("layout/activity_track_home_0", Integer.valueOf(R.layout.activity_track_home));
            map.put("layout/dynamic_track_recycleview_item_0", Integer.valueOf(R.layout.dynamic_track_recycleview_item));
            map.put("layout/fragment_dhvideo_content_0", Integer.valueOf(R.layout.fragment_dhvideo_content));
            map.put("layout/fragment_dynamic_track_0", Integer.valueOf(R.layout.fragment_dynamic_track));
            map.put("layout/fragment_super_expose_my_dynamic_0", Integer.valueOf(R.layout.fragment_super_expose_my_dynamic));
            map.put("layout/fragment_super_expose_myself_0", Integer.valueOf(R.layout.fragment_super_expose_myself));
            map.put("layout/fragment_track_common_0", Integer.valueOf(R.layout.fragment_track_common));
            map.put("layout/fragment_user_track_0", Integer.valueOf(R.layout.fragment_user_track));
            map.put("layout/layout_activity_personal_info_new_0", Integer.valueOf(R.layout.layout_activity_personal_info_new));
            map.put("layout/layout_activity_personal_info_portriat_list_0", Integer.valueOf(R.layout.layout_activity_personal_info_portriat_list));
            map.put("layout/layout_activity_voice_match_0", Integer.valueOf(R.layout.layout_activity_voice_match));
            map.put("layout/layout_chat_energy_view_0", Integer.valueOf(R.layout.layout_chat_energy_view));
            map.put("layout/layout_super_expose_num_all_0", Integer.valueOf(R.layout.layout_super_expose_num_all));
            map.put("layout/layout_user_detail_energy_view_0", Integer.valueOf(R.layout.layout_user_detail_energy_view));
            map.put("layout/layout_user_detail_energy_view2_0", Integer.valueOf(R.layout.layout_user_detail_energy_view2));
            map.put("layout/layout_video_match_panel_0", Integer.valueOf(R.layout.layout_video_match_panel));
            map.put("layout/layout_voice_match_panel_0", Integer.valueOf(R.layout.layout_voice_match_panel));
            map.put("layout/listitem_dynamic_expose_home_buy_0", Integer.valueOf(R.layout.listitem_dynamic_expose_home_buy));
            map.put("layout/listitem_dynamic_expose_home_dynamic_0", Integer.valueOf(R.layout.listitem_dynamic_expose_home_dynamic));
            map.put("layout/lovematch_pop_new_match_0", Integer.valueOf(R.layout.lovematch_pop_new_match));
            map.put("layout/lovematch_pop_new_msg_0", Integer.valueOf(R.layout.lovematch_pop_new_msg));
            map.put("layout/new_people_match_liked_loading_footer_0", Integer.valueOf(R.layout.new_people_match_liked_loading_footer));
            map.put("layout/popup_energy_tip_0", Integer.valueOf(R.layout.popup_energy_tip));
            map.put("layout/super_expose_num_layout_item_0", Integer.valueOf(R.layout.super_expose_num_layout_item));
            map.put("layout/user_track_footer_view_0", Integer.valueOf(R.layout.user_track_footer_view));
            map.put("layout/user_track_recycleview_item_0", Integer.valueOf(R.layout.user_track_recycleview_item));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(31);
        f12075a = sparseIntArray;
        sparseIntArray.put(R.layout.activity_all_notice_settings, 1);
        sparseIntArray.put(R.layout.activity_dynamic_expose_home, 2);
        sparseIntArray.put(R.layout.activity_super_expose_city_chose, 3);
        sparseIntArray.put(R.layout.activity_super_expose_city_chose_label_item, 4);
        sparseIntArray.put(R.layout.activity_super_expose_home, 5);
        sparseIntArray.put(R.layout.activity_track_home, 6);
        sparseIntArray.put(R.layout.dynamic_track_recycleview_item, 7);
        sparseIntArray.put(R.layout.fragment_dhvideo_content, 8);
        sparseIntArray.put(R.layout.fragment_dynamic_track, 9);
        sparseIntArray.put(R.layout.fragment_super_expose_my_dynamic, 10);
        sparseIntArray.put(R.layout.fragment_super_expose_myself, 11);
        sparseIntArray.put(R.layout.fragment_track_common, 12);
        sparseIntArray.put(R.layout.fragment_user_track, 13);
        sparseIntArray.put(R.layout.layout_activity_personal_info_new, 14);
        sparseIntArray.put(R.layout.layout_activity_personal_info_portriat_list, 15);
        sparseIntArray.put(R.layout.layout_activity_voice_match, 16);
        sparseIntArray.put(R.layout.layout_chat_energy_view, 17);
        sparseIntArray.put(R.layout.layout_super_expose_num_all, 18);
        sparseIntArray.put(R.layout.layout_user_detail_energy_view, 19);
        sparseIntArray.put(R.layout.layout_user_detail_energy_view2, 20);
        sparseIntArray.put(R.layout.layout_video_match_panel, 21);
        sparseIntArray.put(R.layout.layout_voice_match_panel, 22);
        sparseIntArray.put(R.layout.listitem_dynamic_expose_home_buy, 23);
        sparseIntArray.put(R.layout.listitem_dynamic_expose_home_dynamic, 24);
        sparseIntArray.put(R.layout.lovematch_pop_new_match, 25);
        sparseIntArray.put(R.layout.lovematch_pop_new_msg, 26);
        sparseIntArray.put(R.layout.new_people_match_liked_loading_footer, 27);
        sparseIntArray.put(R.layout.popup_energy_tip, 28);
        sparseIntArray.put(R.layout.super_expose_num_layout_item, 29);
        sparseIntArray.put(R.layout.user_track_footer_view, 30);
        sparseIntArray.put(R.layout.user_track_recycleview_item, 31);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(6);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.zenmen.giftkit.DataBinderMapperImpl());
        arrayList.add(new com.zenmen.listui.DataBinderMapperImpl());
        arrayList.add(new com.zenmen.palmchat.friendcircle.DataBinderMapperImpl());
        arrayList.add(new com.zenmen.palmchat.privinfo.DataBinderMapperImpl());
        arrayList.add(new com.zenmen.square.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int i) {
        return a.f12076a.get(i);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        int i2 = f12075a.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        switch (i2) {
            case 1:
                if ("layout/activity_all_notice_settings_0".equals(tag)) {
                    return new ActivityAllNoticeSettingsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_all_notice_settings is invalid. Received: " + tag);
            case 2:
                if ("layout/activity_dynamic_expose_home_0".equals(tag)) {
                    return new ActivityDynamicExposeHomeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_dynamic_expose_home is invalid. Received: " + tag);
            case 3:
                if ("layout/activity_super_expose_city_chose_0".equals(tag)) {
                    return new ActivitySuperExposeCityChoseBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_super_expose_city_chose is invalid. Received: " + tag);
            case 4:
                if ("layout/activity_super_expose_city_chose_label_item_0".equals(tag)) {
                    return new ActivitySuperExposeCityChoseLabelItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_super_expose_city_chose_label_item is invalid. Received: " + tag);
            case 5:
                if ("layout/activity_super_expose_home_0".equals(tag)) {
                    return new ActivitySuperExposeHomeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_super_expose_home is invalid. Received: " + tag);
            case 6:
                if ("layout/activity_track_home_0".equals(tag)) {
                    return new ActivityTrackHomeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_track_home is invalid. Received: " + tag);
            case 7:
                if ("layout/dynamic_track_recycleview_item_0".equals(tag)) {
                    return new DynamicTrackRecycleviewItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dynamic_track_recycleview_item is invalid. Received: " + tag);
            case 8:
                if ("layout/fragment_dhvideo_content_0".equals(tag)) {
                    return new FragmentDhvideoContentBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_dhvideo_content is invalid. Received: " + tag);
            case 9:
                if ("layout/fragment_dynamic_track_0".equals(tag)) {
                    return new FragmentDynamicTrackBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_dynamic_track is invalid. Received: " + tag);
            case 10:
                if ("layout/fragment_super_expose_my_dynamic_0".equals(tag)) {
                    return new FragmentSuperExposeMyDynamicBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_super_expose_my_dynamic is invalid. Received: " + tag);
            case 11:
                if ("layout/fragment_super_expose_myself_0".equals(tag)) {
                    return new FragmentSuperExposeMyselfBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_super_expose_myself is invalid. Received: " + tag);
            case 12:
                if ("layout/fragment_track_common_0".equals(tag)) {
                    return new FragmentTrackCommonBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_track_common is invalid. Received: " + tag);
            case 13:
                if ("layout/fragment_user_track_0".equals(tag)) {
                    return new FragmentUserTrackBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_user_track is invalid. Received: " + tag);
            case 14:
                if ("layout/layout_activity_personal_info_new_0".equals(tag)) {
                    return new LayoutActivityPersonalInfoNewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_activity_personal_info_new is invalid. Received: " + tag);
            case 15:
                if ("layout/layout_activity_personal_info_portriat_list_0".equals(tag)) {
                    return new LayoutActivityPersonalInfoPortriatListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_activity_personal_info_portriat_list is invalid. Received: " + tag);
            case 16:
                if ("layout/layout_activity_voice_match_0".equals(tag)) {
                    return new LayoutActivityVoiceMatchBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_activity_voice_match is invalid. Received: " + tag);
            case 17:
                if ("layout/layout_chat_energy_view_0".equals(tag)) {
                    return new LayoutChatEnergyViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_chat_energy_view is invalid. Received: " + tag);
            case 18:
                if ("layout/layout_super_expose_num_all_0".equals(tag)) {
                    return new LayoutSuperExposeNumAllBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_super_expose_num_all is invalid. Received: " + tag);
            case 19:
                if ("layout/layout_user_detail_energy_view_0".equals(tag)) {
                    return new LayoutUserDetailEnergyViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_user_detail_energy_view is invalid. Received: " + tag);
            case 20:
                if ("layout/layout_user_detail_energy_view2_0".equals(tag)) {
                    return new LayoutUserDetailEnergyView2BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_user_detail_energy_view2 is invalid. Received: " + tag);
            case 21:
                if ("layout/layout_video_match_panel_0".equals(tag)) {
                    return new LayoutVideoMatchPanelBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_video_match_panel is invalid. Received: " + tag);
            case 22:
                if ("layout/layout_voice_match_panel_0".equals(tag)) {
                    return new LayoutVoiceMatchPanelBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_voice_match_panel is invalid. Received: " + tag);
            case 23:
                if ("layout/listitem_dynamic_expose_home_buy_0".equals(tag)) {
                    return new ListitemDynamicExposeHomeBuyBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for listitem_dynamic_expose_home_buy is invalid. Received: " + tag);
            case 24:
                if ("layout/listitem_dynamic_expose_home_dynamic_0".equals(tag)) {
                    return new ListitemDynamicExposeHomeDynamicBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for listitem_dynamic_expose_home_dynamic is invalid. Received: " + tag);
            case 25:
                if ("layout/lovematch_pop_new_match_0".equals(tag)) {
                    return new LovematchPopNewMatchBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for lovematch_pop_new_match is invalid. Received: " + tag);
            case 26:
                if ("layout/lovematch_pop_new_msg_0".equals(tag)) {
                    return new LovematchPopNewMsgBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for lovematch_pop_new_msg is invalid. Received: " + tag);
            case 27:
                if ("layout/new_people_match_liked_loading_footer_0".equals(tag)) {
                    return new NewPeopleMatchLikedLoadingFooterBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for new_people_match_liked_loading_footer is invalid. Received: " + tag);
            case 28:
                if ("layout/popup_energy_tip_0".equals(tag)) {
                    return new PopupEnergyTipBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for popup_energy_tip is invalid. Received: " + tag);
            case 29:
                if ("layout/super_expose_num_layout_item_0".equals(tag)) {
                    return new SuperExposeNumLayoutItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for super_expose_num_layout_item is invalid. Received: " + tag);
            case 30:
                if ("layout/user_track_footer_view_0".equals(tag)) {
                    return new UserTrackFooterViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for user_track_footer_view is invalid. Received: " + tag);
            case 31:
                if ("layout/user_track_recycleview_item_0".equals(tag)) {
                    return new UserTrackRecycleviewItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for user_track_recycleview_item is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f12077a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || f12075a.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
