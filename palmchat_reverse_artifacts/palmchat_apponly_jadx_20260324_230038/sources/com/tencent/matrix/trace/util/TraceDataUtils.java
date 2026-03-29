package com.tencent.matrix.trace.util;

import android.util.Log;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.items.MethodItem;
import com.tencent.matrix.util.MatrixLog;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TraceDataUtils {
    private static final String TAG = "Matrix.TraceDataUtils";

    /* JADX INFO: compiled from: SearchBox */
    public interface IStructuredDataFilter {
        void fallback(List<MethodItem> list, int i);

        int getFilterMaxCount();

        boolean isFilter(long j, int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class TreeNode {
        LinkedList<TreeNode> children = new LinkedList<>();
        TreeNode father;
        MethodItem item;

        public TreeNode(MethodItem methodItem, TreeNode treeNode) {
            this.item = methodItem;
            this.father = treeNode;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void add(TreeNode treeNode) {
            this.children.addFirst(treeNode);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int depth() {
            MethodItem methodItem = this.item;
            if (methodItem == null) {
                return 0;
            }
            return methodItem.depth;
        }

        private boolean isLeaf() {
            return this.children.isEmpty();
        }
    }

    private static int addMethodItem(LinkedList<MethodItem> linkedList, MethodItem methodItem) {
        if (AppMethodBeat.isDev) {
            Log.v(TAG, "method:" + methodItem);
        }
        MethodItem methodItemPeek = !linkedList.isEmpty() ? linkedList.peek() : null;
        if (methodItemPeek != null && methodItemPeek.methodId == methodItem.methodId) {
            int i = methodItemPeek.depth;
            int i2 = methodItem.depth;
            if (i == i2 && i2 != 0) {
                int i3 = methodItem.durTime;
                if (i3 == 5000) {
                    i3 = methodItemPeek.durTime;
                }
                methodItem.durTime = i3;
                methodItemPeek.mergeMore(i3);
                return methodItemPeek.durTime;
            }
        }
        linkedList.push(methodItem);
        return methodItem.durTime;
    }

    public static int countTreeNode(TreeNode treeNode) {
        int size = treeNode.children.size();
        Iterator<TreeNode> it = treeNode.children.iterator();
        while (it.hasNext()) {
            size += countTreeNode(it.next());
        }
        return size;
    }

    private static int getMethodId(long j) {
        return (int) ((j >> 43) & 1048575);
    }

    private static long getTime(long j) {
        return j & 8796093022207L;
    }

    @Deprecated
    public static String getTreeKey(List<MethodItem> list, final int i) {
        StringBuilder sb = new StringBuilder();
        LinkedList linkedList = new LinkedList(list);
        trimStack(linkedList, i, new IStructuredDataFilter() { // from class: com.tencent.matrix.trace.util.TraceDataUtils.1
            @Override // com.tencent.matrix.trace.util.TraceDataUtils.IStructuredDataFilter
            public void fallback(List<MethodItem> list2, int i2) {
                MatrixLog.w(TraceDataUtils.TAG, "[getTreeKey] size:%s targetSize:%s", Integer.valueOf(i2), Integer.valueOf(i));
                ListIterator<MethodItem> listIterator = list2.listIterator(Math.min(i2, i));
                while (listIterator.hasNext()) {
                    listIterator.next();
                    listIterator.remove();
                }
            }

            @Override // com.tencent.matrix.trace.util.TraceDataUtils.IStructuredDataFilter
            public int getFilterMaxCount() {
                return 60;
            }

            @Override // com.tencent.matrix.trace.util.TraceDataUtils.IStructuredDataFilter
            public boolean isFilter(long j, int i2) {
                return j < ((long) (i2 * 5));
            }
        });
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            sb.append(((MethodItem) it.next()).methodId + HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        }
        return sb.toString();
    }

    private static boolean isIn(long j) {
        return ((j >> 63) & 1) == 1;
    }

    public static void printTree(TreeNode treeNode, StringBuilder sb) {
        sb.append("|*   TraceStack: ");
        sb.append("\n");
        printTree(treeNode, 0, sb, "|*        ");
    }

    public static long stackToString(LinkedList<MethodItem> linkedList, StringBuilder sb, StringBuilder sb2) {
        sb2.append("|*\t\tTraceStack:");
        sb2.append("\n");
        sb2.append("|*\t\t[id count cost]");
        sb2.append("\n");
        long j = 0;
        for (MethodItem methodItem : linkedList) {
            sb.append(methodItem.toString());
            sb.append('\n');
            sb2.append("|*\t\t");
            sb2.append(methodItem.print());
            sb2.append('\n');
            int i = methodItem.durTime;
            if (j < i) {
                j = i;
            }
        }
        return j;
    }

    public static int stackToTree(LinkedList<MethodItem> linkedList, TreeNode treeNode) {
        TreeNode treeNode2;
        ListIterator<MethodItem> listIterator = linkedList.listIterator(0);
        TreeNode treeNode3 = null;
        int i = 0;
        while (listIterator.hasNext()) {
            TreeNode treeNode4 = new TreeNode(listIterator.next(), treeNode3);
            i++;
            if (treeNode3 == null && treeNode4.depth() != 0) {
                MatrixLog.e(TAG, "[stackToTree] begin error! why the first node'depth is not 0!", new Object[0]);
                return 0;
            }
            int iDepth = treeNode4.depth();
            if (treeNode3 == null || iDepth == 0) {
                treeNode.add(treeNode4);
            } else if (treeNode3.depth() >= iDepth) {
                while (treeNode3 != null && treeNode3.depth() > iDepth) {
                    treeNode3 = treeNode3.father;
                }
                if (treeNode3 != null && (treeNode2 = treeNode3.father) != null) {
                    treeNode4.father = treeNode2;
                    treeNode3.father.add(treeNode4);
                }
            } else {
                treeNode3.add(treeNode4);
            }
            treeNode3 = treeNode4;
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0046 A[PHI: r3
      0x0046: PHI (r3v11 boolean) = (r3v1 boolean), (r3v14 boolean) binds: [B:9:0x0022, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void structuredDataToStack(long[] jArr, LinkedList<MethodItem> linkedList, boolean z, long j) {
        int methodId;
        LinkedList linkedList2 = new LinkedList();
        boolean z2 = !z;
        int size = 0;
        for (long j2 : jArr) {
            if (0 != j2) {
                if (z) {
                    if (isIn(j2) && 1048574 == getMethodId(j2)) {
                        z2 = true;
                    }
                    if (!z2) {
                        MatrixLog.d(TAG, "never begin! pass this method[%s]", Integer.valueOf(getMethodId(j2)));
                    }
                } else if (isIn(j2)) {
                    if (getMethodId(j2) == 1048574) {
                        size = 0;
                    }
                    size++;
                    linkedList2.push(Long.valueOf(j2));
                } else {
                    int methodId2 = getMethodId(j2);
                    if (linkedList2.isEmpty()) {
                        MatrixLog.w(TAG, "[structuredDataToStack] method[%s] not found in! ", Integer.valueOf(methodId2));
                    } else {
                        long jLongValue = ((Long) linkedList2.pop()).longValue();
                        size--;
                        LinkedList linkedList3 = new LinkedList();
                        linkedList3.add(Long.valueOf(jLongValue));
                        while (true) {
                            methodId = getMethodId(jLongValue);
                            if (methodId == methodId2 || linkedList2.isEmpty()) {
                                break;
                            }
                            MatrixLog.w(TAG, "pop inMethodId[%s] to continue match ouMethodId[%s]", Integer.valueOf(methodId), Integer.valueOf(methodId2));
                            jLongValue = ((Long) linkedList2.pop()).longValue();
                            size--;
                            linkedList3.add(Long.valueOf(jLongValue));
                        }
                        if (methodId == methodId2 || methodId != 1048574) {
                            long time = getTime(j2) - getTime(jLongValue);
                            if (time < 0) {
                                MatrixLog.e(TAG, "[structuredDataToStack] trace during invalid:%d", Long.valueOf(time));
                                linkedList2.clear();
                                linkedList.clear();
                                return;
                            }
                            addMethodItem(linkedList, new MethodItem(methodId2, (int) time, size));
                        } else {
                            MatrixLog.e(TAG, "inMethodId[%s] != outMethodId[%s] throw this outMethodId!", Integer.valueOf(methodId), Integer.valueOf(methodId2));
                            linkedList2.addAll(linkedList3);
                            size += linkedList2.size();
                        }
                    }
                }
            }
        }
        while (!linkedList2.isEmpty() && z) {
            long jLongValue2 = ((Long) linkedList2.pop()).longValue();
            int methodId3 = getMethodId(jLongValue2);
            boolean zIsIn = isIn(jLongValue2);
            long time2 = getTime(jLongValue2) + AppMethodBeat.getDiffTime();
            MatrixLog.w(TAG, "[structuredDataToStack] has never out method[%s], isIn:%s, inTime:%s, endTime:%s,rawData size:%s", Integer.valueOf(methodId3), Boolean.valueOf(zIsIn), Long.valueOf(time2), Long.valueOf(j), Integer.valueOf(linkedList2.size()));
            if (zIsIn) {
                addMethodItem(linkedList, new MethodItem(methodId3, (int) (j - time2), linkedList2.size()));
            } else {
                MatrixLog.e(TAG, "[structuredDataToStack] why has out Method[%s]? is wrong! ", Integer.valueOf(methodId3));
            }
        }
        TreeNode treeNode = new TreeNode(null, null);
        MatrixLog.i(TAG, "stackToTree: count=%s", Integer.valueOf(stackToTree(linkedList, treeNode)));
        linkedList.clear();
        treeToStack(treeNode, linkedList);
    }

    private static void treeToStack(TreeNode treeNode, LinkedList<MethodItem> linkedList) {
        for (int i = 0; i < treeNode.children.size(); i++) {
            TreeNode treeNode2 = treeNode.children.get(i);
            if (treeNode2 != null) {
                MethodItem methodItem = treeNode2.item;
                if (methodItem != null) {
                    linkedList.add(methodItem);
                }
                if (!treeNode2.children.isEmpty()) {
                    treeToStack(treeNode2, linkedList);
                }
            }
        }
    }

    public static void trimStack(List<MethodItem> list, int i, IStructuredDataFilter iStructuredDataFilter) {
        if (i < 0) {
            list.clear();
            return;
        }
        int size = list.size();
        int i2 = 1;
        while (size > i) {
            ListIterator<MethodItem> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                if (iStructuredDataFilter.isFilter(listIterator.previous().durTime, i2)) {
                    listIterator.remove();
                    size--;
                    if (size <= i) {
                        return;
                    }
                }
            }
            size = list.size();
            i2++;
            if (iStructuredDataFilter.getFilterMaxCount() < i2) {
                break;
            }
        }
        int size2 = list.size();
        if (size2 > i) {
            iStructuredDataFilter.fallback(list, size2);
        }
    }

    public static void printTree(TreeNode treeNode, int i, StringBuilder sb, String str) {
        StringBuilder sb2 = new StringBuilder(str);
        for (int i2 = 0; i2 <= i; i2++) {
            sb2.append("    ");
        }
        for (int i3 = 0; i3 < treeNode.children.size(); i3++) {
            TreeNode treeNode2 = treeNode.children.get(i3);
            sb.append(sb2.toString());
            sb.append(treeNode2.item.methodId);
            sb.append("[");
            sb.append(treeNode2.item.durTime);
            sb.append("]");
            sb.append("\n");
            if (!treeNode2.children.isEmpty()) {
                printTree(treeNode2, i + 1, sb, str);
            }
        }
    }

    public static String getTreeKey(List<MethodItem> list, long j) {
        StringBuilder sb = new StringBuilder();
        long j2 = (long) (j * 0.3f);
        LinkedList linkedList = new LinkedList();
        for (MethodItem methodItem : list) {
            if (methodItem.durTime >= j2) {
                linkedList.add(methodItem);
            }
        }
        Collections.sort(linkedList, new Comparator<MethodItem>() { // from class: com.tencent.matrix.trace.util.TraceDataUtils.2
            @Override // java.util.Comparator
            public int compare(MethodItem methodItem2, MethodItem methodItem3) {
                return Integer.compare((methodItem3.depth + 1) * methodItem3.durTime, (methodItem2.depth + 1) * methodItem2.durTime);
            }
        });
        if (linkedList.isEmpty() && !list.isEmpty()) {
            linkedList.add(list.get(0));
        } else if (linkedList.size() > 1 && ((MethodItem) linkedList.peek()).methodId == 1048574) {
            linkedList.removeFirst();
        }
        Iterator it = linkedList.iterator();
        if (it.hasNext()) {
            sb.append(((MethodItem) it.next()).methodId + HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        }
        return sb.toString();
    }
}
