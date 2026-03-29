package com.tencent.matrix.report;

import java.util.HashSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class IssuePublisher {
    private final OnIssueDetectListener mIssueListener;
    private final HashSet<String> mPublishedMap = new HashSet<>();

    /* JADX INFO: compiled from: SearchBox */
    public interface OnIssueDetectListener {
        void onDetectIssue(Issue issue);
    }

    public IssuePublisher(OnIssueDetectListener onIssueDetectListener) {
        this.mIssueListener = onIssueDetectListener;
    }

    public boolean isPublished(String str) {
        if (str == null) {
            return false;
        }
        return this.mPublishedMap.contains(str);
    }

    public void markPublished(String str) {
        if (str == null) {
            return;
        }
        this.mPublishedMap.add(str);
    }

    public void publishIssue(Issue issue) {
        OnIssueDetectListener onIssueDetectListener = this.mIssueListener;
        if (onIssueDetectListener == null) {
            throw new RuntimeException("publish issue, but issue listener is null");
        }
        if (issue != null) {
            onIssueDetectListener.onDetectIssue(issue);
        }
    }

    public void unMarkPublished(String str) {
        if (str == null) {
            return;
        }
        this.mPublishedMap.remove(str);
    }
}
