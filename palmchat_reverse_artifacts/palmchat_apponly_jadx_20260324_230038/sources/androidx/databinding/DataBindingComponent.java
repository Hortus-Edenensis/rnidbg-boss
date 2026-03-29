package androidx.databinding;

import com.zenmen.find.holder.NearbyMapFinderGuideViewHolder;
import com.zenmen.square.fragment.FeedDetailFragment;
import com.zenmen.square.mvp.holder.FeedViewHolder;
import com.zenmen.square.mvp.holder.FriendMessageViewHolder;
import com.zenmen.square.mvp.holder.NearByViewHolder;
import com.zenmen.square.mvp.holder.NestTopicFeedViewHolder;
import com.zenmen.square.mvp.holder.QualityFriendShipViewHolder;
import com.zenmen.square.mvp.holder.SquareInteractViewHolder;
import com.zenmen.square.show.FeedShowDetailFragment;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public interface DataBindingComponent {
    FeedDetailFragment getFeedDetailFragment();

    FeedShowDetailFragment getFeedShowDetailFragment();

    FeedViewHolder getFeedViewHolder();

    FriendMessageViewHolder getFriendMessageViewHolder();

    NearByViewHolder getNearByViewHolder();

    NearbyMapFinderGuideViewHolder getNearbyMapFinderGuideViewHolder();

    NestTopicFeedViewHolder getNestTopicFeedViewHolder();

    QualityFriendShipViewHolder getQualityFriendShipViewHolder();

    SquareInteractViewHolder getSquareInteractViewHolder();
}
