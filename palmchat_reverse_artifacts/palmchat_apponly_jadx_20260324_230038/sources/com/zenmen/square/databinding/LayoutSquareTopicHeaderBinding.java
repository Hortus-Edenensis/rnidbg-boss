package com.zenmen.square.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.zenmen.square.topic.view.TopicHeadView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class LayoutSquareTopicHeaderBinding extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final TopicHeadView f16236a;

    public LayoutSquareTopicHeaderBinding(Object obj, View view, int i, TopicHeadView topicHeadView) {
        super(obj, view, i);
        this.f16236a = topicHeadView;
    }
}
