package com.zenmen.square;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.zenmen.square.databinding.FeedLayoutItemViewBindingImpl;
import com.zenmen.square.databinding.LayoutMomentsDetailFullBindingImpl;
import com.zenmen.square.databinding.LayoutNestTagHeaderViewBindingImpl;
import com.zenmen.square.databinding.LayoutPraiseFootViewBindingImpl;
import com.zenmen.square.databinding.LayoutQualityFriendshipItemBindingImpl;
import com.zenmen.square.databinding.LayoutSquareDetailHalfBindingImpl;
import com.zenmen.square.databinding.LayoutSquareEmptyFriendBindingImpl;
import com.zenmen.square.databinding.LayoutSquareFriendMsgItemBindingImpl;
import com.zenmen.square.databinding.LayoutSquareInteractItemBindingImpl;
import com.zenmen.square.databinding.LayoutSquareListDividerTiltleBindingImpl;
import com.zenmen.square.databinding.LayoutSquareMapFinderGuideBindingImpl;
import com.zenmen.square.databinding.LayoutSquareMediaViewBindingImpl;
import com.zenmen.square.databinding.LayoutSquareNearbyItemBindingImpl;
import com.zenmen.square.databinding.LayoutSquareNestTopicFeedItemBindingImpl;
import com.zenmen.square.databinding.LayoutSquareShowMediaViewBindingImpl;
import com.zenmen.square.databinding.LayoutSquareTopicHeaderBindingImpl;
import com.zenmen.square.databinding.SquareGenericListItemAdBindingImpl;
import com.zenmen.square.databinding.SquareGenericListItemAdGroupItemBindingImpl;
import com.zenmen.square.databinding.SquareInteractHeaderBindingImpl;
import com.zenmen.square.databinding.SquareNearbyAdListItemBigpicBindingImpl;
import com.zenmen.square.databinding.SquareNearbyAdListItemMultipicBindingImpl;
import com.zenmen.square.databinding.SquareNearbyUnlockItemTipBindingImpl;
import com.zenmen.square.databinding.SquareUserdetailAdBannerContentBindingImpl;
import com.zenmen.square.databinding.SquareUserdetailAdEmptyWrapperBindingImpl;
import com.zenmen.square.databinding.SquareUserdetailAdLargedivContentBindingImpl;
import com.zenmen.square.databinding.SquareUserdetailAdLargepicContentBindingImpl;
import com.zenmen.square.databinding.SquareUserdetailAdListWrapperBindingImpl;
import com.zenmen.square.databinding.SquareUserdetailAdMultipicContentBindingImpl;
import com.zenmen.square.databinding.SquareVoiceMatchGuideBubbleBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class DataBinderMapperImpl extends DataBinderMapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseIntArray f16077a;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SparseArray<String> f16078a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(9);
            f16078a = sparseArray;
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
        public static final HashMap<String, Integer> f16079a;

        static {
            HashMap<String, Integer> map = new HashMap<>(29);
            f16079a = map;
            map.put("layout/feed_layout_item_view_0", Integer.valueOf(R$layout.feed_layout_item_view));
            map.put("layout/layout_moments_detail_full_0", Integer.valueOf(R$layout.layout_moments_detail_full));
            map.put("layout/layout_nest_tag_header_view_0", Integer.valueOf(R$layout.layout_nest_tag_header_view));
            map.put("layout/layout_praise_foot_view_0", Integer.valueOf(R$layout.layout_praise_foot_view));
            map.put("layout/layout_quality_friendship_item_0", Integer.valueOf(R$layout.layout_quality_friendship_item));
            map.put("layout/layout_square_detail_half_0", Integer.valueOf(R$layout.layout_square_detail_half));
            map.put("layout/layout_square_empty_friend_0", Integer.valueOf(R$layout.layout_square_empty_friend));
            map.put("layout/layout_square_friend_msg_item_0", Integer.valueOf(R$layout.layout_square_friend_msg_item));
            map.put("layout/layout_square_interact_item_0", Integer.valueOf(R$layout.layout_square_interact_item));
            map.put("layout/layout_square_list_divider_tiltle_0", Integer.valueOf(R$layout.layout_square_list_divider_tiltle));
            map.put("layout/layout_square_map_finder_guide_0", Integer.valueOf(R$layout.layout_square_map_finder_guide));
            map.put("layout/layout_square_media_view_0", Integer.valueOf(R$layout.layout_square_media_view));
            map.put("layout/layout_square_nearby_item_0", Integer.valueOf(R$layout.layout_square_nearby_item));
            map.put("layout/layout_square_nest_topic_feed_item_0", Integer.valueOf(R$layout.layout_square_nest_topic_feed_item));
            map.put("layout/layout_square_show_media_view_0", Integer.valueOf(R$layout.layout_square_show_media_view));
            map.put("layout/layout_square_topic_header_0", Integer.valueOf(R$layout.layout_square_topic_header));
            map.put("layout/square_generic_list_item_ad_0", Integer.valueOf(R$layout.square_generic_list_item_ad));
            map.put("layout/square_generic_list_item_ad_group_item_0", Integer.valueOf(R$layout.square_generic_list_item_ad_group_item));
            map.put("layout/square_interact_header_0", Integer.valueOf(R$layout.square_interact_header));
            map.put("layout/square_nearby_ad_list_item_bigpic_0", Integer.valueOf(R$layout.square_nearby_ad_list_item_bigpic));
            map.put("layout/square_nearby_ad_list_item_multipic_0", Integer.valueOf(R$layout.square_nearby_ad_list_item_multipic));
            map.put("layout/square_nearby_unlock_item_tip_0", Integer.valueOf(R$layout.square_nearby_unlock_item_tip));
            map.put("layout/square_userdetail_ad_banner_content_0", Integer.valueOf(R$layout.square_userdetail_ad_banner_content));
            map.put("layout/square_userdetail_ad_empty_wrapper_0", Integer.valueOf(R$layout.square_userdetail_ad_empty_wrapper));
            map.put("layout/square_userdetail_ad_largediv_content_0", Integer.valueOf(R$layout.square_userdetail_ad_largediv_content));
            map.put("layout/square_userdetail_ad_largepic_content_0", Integer.valueOf(R$layout.square_userdetail_ad_largepic_content));
            map.put("layout/square_userdetail_ad_list_wrapper_0", Integer.valueOf(R$layout.square_userdetail_ad_list_wrapper));
            map.put("layout/square_userdetail_ad_multipic_content_0", Integer.valueOf(R$layout.square_userdetail_ad_multipic_content));
            map.put("layout/square_voice_match_guide_bubble_0", Integer.valueOf(R$layout.square_voice_match_guide_bubble));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(29);
        f16077a = sparseIntArray;
        sparseIntArray.put(R$layout.feed_layout_item_view, 1);
        sparseIntArray.put(R$layout.layout_moments_detail_full, 2);
        sparseIntArray.put(R$layout.layout_nest_tag_header_view, 3);
        sparseIntArray.put(R$layout.layout_praise_foot_view, 4);
        sparseIntArray.put(R$layout.layout_quality_friendship_item, 5);
        sparseIntArray.put(R$layout.layout_square_detail_half, 6);
        sparseIntArray.put(R$layout.layout_square_empty_friend, 7);
        sparseIntArray.put(R$layout.layout_square_friend_msg_item, 8);
        sparseIntArray.put(R$layout.layout_square_interact_item, 9);
        sparseIntArray.put(R$layout.layout_square_list_divider_tiltle, 10);
        sparseIntArray.put(R$layout.layout_square_map_finder_guide, 11);
        sparseIntArray.put(R$layout.layout_square_media_view, 12);
        sparseIntArray.put(R$layout.layout_square_nearby_item, 13);
        sparseIntArray.put(R$layout.layout_square_nest_topic_feed_item, 14);
        sparseIntArray.put(R$layout.layout_square_show_media_view, 15);
        sparseIntArray.put(R$layout.layout_square_topic_header, 16);
        sparseIntArray.put(R$layout.square_generic_list_item_ad, 17);
        sparseIntArray.put(R$layout.square_generic_list_item_ad_group_item, 18);
        sparseIntArray.put(R$layout.square_interact_header, 19);
        sparseIntArray.put(R$layout.square_nearby_ad_list_item_bigpic, 20);
        sparseIntArray.put(R$layout.square_nearby_ad_list_item_multipic, 21);
        sparseIntArray.put(R$layout.square_nearby_unlock_item_tip, 22);
        sparseIntArray.put(R$layout.square_userdetail_ad_banner_content, 23);
        sparseIntArray.put(R$layout.square_userdetail_ad_empty_wrapper, 24);
        sparseIntArray.put(R$layout.square_userdetail_ad_largediv_content, 25);
        sparseIntArray.put(R$layout.square_userdetail_ad_largepic_content, 26);
        sparseIntArray.put(R$layout.square_userdetail_ad_list_wrapper, 27);
        sparseIntArray.put(R$layout.square_userdetail_ad_multipic_content, 28);
        sparseIntArray.put(R$layout.square_voice_match_guide_bubble, 29);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.zenmen.giftkit.DataBinderMapperImpl());
        arrayList.add(new com.zenmen.listui.DataBinderMapperImpl());
        arrayList.add(new com.zenmen.palmchat.friendcircle.DataBinderMapperImpl());
        arrayList.add(new com.zenmen.palmchat.privinfo.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int i) {
        return a.f16078a.get(i);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        int i2 = f16077a.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        switch (i2) {
            case 1:
                if ("layout/feed_layout_item_view_0".equals(tag)) {
                    return new FeedLayoutItemViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for feed_layout_item_view is invalid. Received: " + tag);
            case 2:
                if ("layout/layout_moments_detail_full_0".equals(tag)) {
                    return new LayoutMomentsDetailFullBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_moments_detail_full is invalid. Received: " + tag);
            case 3:
                if ("layout/layout_nest_tag_header_view_0".equals(tag)) {
                    return new LayoutNestTagHeaderViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_nest_tag_header_view is invalid. Received: " + tag);
            case 4:
                if ("layout/layout_praise_foot_view_0".equals(tag)) {
                    return new LayoutPraiseFootViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_praise_foot_view is invalid. Received: " + tag);
            case 5:
                if ("layout/layout_quality_friendship_item_0".equals(tag)) {
                    return new LayoutQualityFriendshipItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_quality_friendship_item is invalid. Received: " + tag);
            case 6:
                if ("layout/layout_square_detail_half_0".equals(tag)) {
                    return new LayoutSquareDetailHalfBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_square_detail_half is invalid. Received: " + tag);
            case 7:
                if ("layout/layout_square_empty_friend_0".equals(tag)) {
                    return new LayoutSquareEmptyFriendBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_square_empty_friend is invalid. Received: " + tag);
            case 8:
                if ("layout/layout_square_friend_msg_item_0".equals(tag)) {
                    return new LayoutSquareFriendMsgItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_square_friend_msg_item is invalid. Received: " + tag);
            case 9:
                if ("layout/layout_square_interact_item_0".equals(tag)) {
                    return new LayoutSquareInteractItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_square_interact_item is invalid. Received: " + tag);
            case 10:
                if ("layout/layout_square_list_divider_tiltle_0".equals(tag)) {
                    return new LayoutSquareListDividerTiltleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_square_list_divider_tiltle is invalid. Received: " + tag);
            case 11:
                if ("layout/layout_square_map_finder_guide_0".equals(tag)) {
                    return new LayoutSquareMapFinderGuideBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_square_map_finder_guide is invalid. Received: " + tag);
            case 12:
                if ("layout/layout_square_media_view_0".equals(tag)) {
                    return new LayoutSquareMediaViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_square_media_view is invalid. Received: " + tag);
            case 13:
                if ("layout/layout_square_nearby_item_0".equals(tag)) {
                    return new LayoutSquareNearbyItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_square_nearby_item is invalid. Received: " + tag);
            case 14:
                if ("layout/layout_square_nest_topic_feed_item_0".equals(tag)) {
                    return new LayoutSquareNestTopicFeedItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_square_nest_topic_feed_item is invalid. Received: " + tag);
            case 15:
                if ("layout/layout_square_show_media_view_0".equals(tag)) {
                    return new LayoutSquareShowMediaViewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_square_show_media_view is invalid. Received: " + tag);
            case 16:
                if ("layout/layout_square_topic_header_0".equals(tag)) {
                    return new LayoutSquareTopicHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_square_topic_header is invalid. Received: " + tag);
            case 17:
                if ("layout/square_generic_list_item_ad_0".equals(tag)) {
                    return new SquareGenericListItemAdBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for square_generic_list_item_ad is invalid. Received: " + tag);
            case 18:
                if ("layout/square_generic_list_item_ad_group_item_0".equals(tag)) {
                    return new SquareGenericListItemAdGroupItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for square_generic_list_item_ad_group_item is invalid. Received: " + tag);
            case 19:
                if ("layout/square_interact_header_0".equals(tag)) {
                    return new SquareInteractHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for square_interact_header is invalid. Received: " + tag);
            case 20:
                if ("layout/square_nearby_ad_list_item_bigpic_0".equals(tag)) {
                    return new SquareNearbyAdListItemBigpicBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for square_nearby_ad_list_item_bigpic is invalid. Received: " + tag);
            case 21:
                if ("layout/square_nearby_ad_list_item_multipic_0".equals(tag)) {
                    return new SquareNearbyAdListItemMultipicBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for square_nearby_ad_list_item_multipic is invalid. Received: " + tag);
            case 22:
                if ("layout/square_nearby_unlock_item_tip_0".equals(tag)) {
                    return new SquareNearbyUnlockItemTipBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for square_nearby_unlock_item_tip is invalid. Received: " + tag);
            case 23:
                if ("layout/square_userdetail_ad_banner_content_0".equals(tag)) {
                    return new SquareUserdetailAdBannerContentBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for square_userdetail_ad_banner_content is invalid. Received: " + tag);
            case 24:
                if ("layout/square_userdetail_ad_empty_wrapper_0".equals(tag)) {
                    return new SquareUserdetailAdEmptyWrapperBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for square_userdetail_ad_empty_wrapper is invalid. Received: " + tag);
            case 25:
                if ("layout/square_userdetail_ad_largediv_content_0".equals(tag)) {
                    return new SquareUserdetailAdLargedivContentBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for square_userdetail_ad_largediv_content is invalid. Received: " + tag);
            case 26:
                if ("layout/square_userdetail_ad_largepic_content_0".equals(tag)) {
                    return new SquareUserdetailAdLargepicContentBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for square_userdetail_ad_largepic_content is invalid. Received: " + tag);
            case 27:
                if ("layout/square_userdetail_ad_list_wrapper_0".equals(tag)) {
                    return new SquareUserdetailAdListWrapperBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for square_userdetail_ad_list_wrapper is invalid. Received: " + tag);
            case 28:
                if ("layout/square_userdetail_ad_multipic_content_0".equals(tag)) {
                    return new SquareUserdetailAdMultipicContentBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for square_userdetail_ad_multipic_content is invalid. Received: " + tag);
            case 29:
                if ("layout/square_voice_match_guide_bubble_0".equals(tag)) {
                    return new SquareVoiceMatchGuideBubbleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for square_voice_match_guide_bubble is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f16079a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || f16077a.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
