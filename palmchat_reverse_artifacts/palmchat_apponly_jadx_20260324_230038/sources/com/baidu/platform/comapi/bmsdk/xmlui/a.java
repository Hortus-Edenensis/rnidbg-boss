package com.baidu.platform.comapi.bmsdk.xmlui;

import android.graphics.Color;
import android.text.TextUtils;
import com.baidu.platform.comapi.bmsdk.style.BmGuessResource;
import com.baidu.platform.comapi.bmsdk.style.BmTextStyle;
import com.baidu.platform.comapi.bmsdk.ui.BmBaseUI;
import com.baidu.platform.comapi.bmsdk.ui.BmFrameLayout;
import com.baidu.platform.comapi.bmsdk.ui.BmGroupUI;
import com.baidu.platform.comapi.bmsdk.ui.BmHorizontalLayout;
import com.baidu.platform.comapi.bmsdk.ui.BmImageUI;
import com.baidu.platform.comapi.bmsdk.ui.BmLabelUI;
import com.baidu.platform.comapi.bmsdk.ui.BmRichView;
import com.baidu.platform.comapi.bmsdk.ui.BmVerticalLayout;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.huawei.hms.ads.ex;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.zenmen.palmchat.peoplematch.bean.PeopleMatchCardBean;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a {
    private BmImageUI c(Node node) {
        BmImageUI bmImageUI = new BmImageUI();
        if (node.getAttributes() != null) {
            a(bmImageUI, node);
        }
        return bmImageUI;
    }

    private BmLabelUI d(Node node) {
        BmLabelUI bmLabelUI = new BmLabelUI();
        if (node.getAttributes() != null) {
            a(bmLabelUI, node);
        }
        return bmLabelUI;
    }

    private BmVerticalLayout e(Node node) {
        BmVerticalLayout bmVerticalLayout = new BmVerticalLayout();
        if (node.getAttributes() != null) {
            a(bmVerticalLayout, node);
        }
        return bmVerticalLayout;
    }

    public BmRichView a(Document document) {
        BmBaseUI bmBaseUIB = b(document);
        if (bmBaseUIB == null) {
            return null;
        }
        BmRichView bmRichView = new BmRichView();
        bmRichView.a(bmBaseUIB);
        return bmRichView;
    }

    public BmBaseUI b(Document document) {
        if (document != null) {
            return a(document.getDocumentElement(), (BmGroupUI) null);
        }
        return null;
    }

    public final BmBaseUI f(Node node) {
        String nodeName = node.getNodeName();
        nodeName.hashCode();
        switch (nodeName) {
            case "VerticalLayout":
                return e(node);
            case "Label":
                return d(node);
            case "ImageView":
                return c(node);
            case "FrameLayout":
                return a(node);
            case "HorizontalLayout":
                return b(node);
            default:
                return null;
        }
    }

    private BmHorizontalLayout b(Node node) {
        BmHorizontalLayout bmHorizontalLayout = new BmHorizontalLayout();
        if (node.getAttributes() != null) {
            a(bmHorizontalLayout, node);
        }
        return bmHorizontalLayout;
    }

    private BmBaseUI a(Node node, BmGroupUI bmGroupUI) {
        BmBaseUI bmBaseUI = null;
        if (node == null) {
            return null;
        }
        for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            BmBaseUI bmBaseUIF = f(firstChild);
            if (bmBaseUIF != null) {
                if (firstChild.hasChildNodes()) {
                    a(firstChild, (BmGroupUI) bmBaseUIF);
                }
                if ((bmGroupUI == null || bmGroupUI.a(bmBaseUIF)) && bmBaseUI == null) {
                    bmBaseUI = bmBaseUIF;
                }
            }
        }
        return bmBaseUI;
    }

    private BmFrameLayout a(Node node) {
        BmFrameLayout bmFrameLayout = new BmFrameLayout();
        if (node.getAttributes() != null) {
            a(bmFrameLayout, node);
        }
        return bmFrameLayout;
    }

    private void a(BmBaseUI bmBaseUI, String str, String str2) {
        if ("name".equals(str)) {
            bmBaseUI.setName(str2);
            return;
        }
        if ("tag".equals(str)) {
            bmBaseUI.setTag(str2);
            return;
        }
        if ("bkImage".equals(str)) {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            bmBaseUI.a(new BmGuessResource(str2));
            return;
        }
        int i = 0;
        if ("bkColor".equals(str)) {
            if (str2.charAt(0) == '#') {
                bmBaseUI.b(Color.parseColor(str2));
                return;
            } else {
                bmBaseUI.b(Integer.parseInt(str2));
                return;
            }
        }
        if ("bkColorL".equals(str)) {
            if (str2.charAt(0) == '#') {
                bmBaseUI.c(Color.parseColor(str2));
                return;
            } else {
                bmBaseUI.c(Integer.parseInt(str2));
                return;
            }
        }
        if ("bkColorR".equals(str)) {
            if (str2.charAt(0) == '#') {
                bmBaseUI.d(Color.parseColor(str2));
                return;
            } else {
                bmBaseUI.d(Integer.parseInt(str2));
                return;
            }
        }
        if ("width".equals(str)) {
            if ("auto".equals(str2)) {
                bmBaseUI.i(-2);
                return;
            } else {
                bmBaseUI.i(Integer.parseInt(str2));
                return;
            }
        }
        if ("height".equals(str)) {
            if ("auto".equals(str2)) {
                bmBaseUI.f(-2);
                return;
            } else {
                bmBaseUI.f(Integer.parseInt(str2));
                return;
            }
        }
        if ("clickAction".equals(str)) {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            bmBaseUI.a(str2);
            bmBaseUI.a(true);
            return;
        }
        if ("padding".equals(str)) {
            String[] strArrSplit = str2.split(",");
            if (strArrSplit == null || strArrSplit.length != 4) {
                return;
            }
            bmBaseUI.b(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), Integer.parseInt(strArrSplit[3]));
            return;
        }
        if ("margin".equals(str)) {
            String[] strArrSplit2 = str2.split(",");
            if (strArrSplit2 == null || strArrSplit2.length != 4) {
                return;
            }
            bmBaseUI.a(Integer.parseInt(strArrSplit2[0]), Integer.parseInt(strArrSplit2[1]), Integer.parseInt(strArrSplit2[2]), Integer.parseInt(strArrSplit2[3]));
            return;
        }
        if (RemoteMessageConst.Notification.VISIBILITY.equals(str)) {
            if (MapBundleKey.MapObjKey.OBJ_SL_VISI.equals(str2)) {
                bmBaseUI.h(1);
                return;
            } else if ("gone".equals(str2)) {
                bmBaseUI.h(4);
                return;
            } else {
                if ("invisible".equals(str2)) {
                    bmBaseUI.h(1);
                    return;
                }
                return;
            }
        }
        if ("vcenterInparent".equals(str)) {
            if (ex.Code.equals(str2)) {
                bmBaseUI.e(32);
                return;
            }
            return;
        }
        if ("layoutWeight".equals(str)) {
            bmBaseUI.g(Integer.parseInt(str2));
            return;
        }
        if ("alignParent".equals(str)) {
            String[] strArrSplit3 = str2.split("\\|");
            if (strArrSplit3 != null && strArrSplit3.length > 0) {
                int length = strArrSplit3.length;
                int i2 = 0;
                while (i < length) {
                    String str3 = strArrSplit3[i];
                    if (str3.contains("left")) {
                        i2 |= 1;
                    } else if (str3.contains("right")) {
                        i2 |= 4;
                    } else if (str3.contains(Constant.MAP_KEY_TOP)) {
                        i2 |= 2;
                    } else if (str3.contains("bottom")) {
                        i2 |= 8;
                    } else if (str3.contains("hcenter")) {
                        i2 |= 16;
                    } else if (str3.contains("vcenter")) {
                        i2 |= 32;
                    } else if (str3.contains("center")) {
                        i2 |= 48;
                    }
                    i++;
                }
                i = i2;
            }
            bmBaseUI.a(i);
            return;
        }
        "trim".equals(str);
    }

    private void a(BmLabelUI bmLabelUI, Node node) {
        NamedNodeMap attributes = node.getAttributes();
        int length = attributes.getLength();
        BmTextStyle bmTextStyle = new BmTextStyle();
        for (int i = 0; i < length; i++) {
            Node nodeItem = attributes.item(i);
            String nodeName = nodeItem.getNodeName();
            String nodeValue = nodeItem.getNodeValue();
            if (!TextUtils.isEmpty(nodeName) && !TextUtils.isEmpty(nodeValue)) {
                if ("text".equals(nodeName)) {
                    bmLabelUI.b(nodeValue);
                } else if ("maxLines".equals(nodeName)) {
                    bmLabelUI.j(Integer.parseInt(nodeValue));
                } else if ("fontSize".equals(nodeName)) {
                    bmTextStyle.e(Integer.parseInt(nodeValue));
                } else if ("fontOption".equals(nodeName)) {
                    if (PeopleMatchCardBean.RECOMMEND_TYPE_NORMAL.equals(nodeValue)) {
                        bmTextStyle.c(0);
                    } else if ("bold".equals(nodeValue)) {
                        bmTextStyle.c(1);
                    } else if ("italic".equals(nodeValue)) {
                        bmTextStyle.c(2);
                    }
                } else if ("textColor".equals(nodeName)) {
                    if (nodeValue.charAt(0) == '#') {
                        bmTextStyle.d(Color.parseColor(nodeValue));
                    } else {
                        bmTextStyle.d(Integer.parseInt(nodeValue));
                    }
                } else if ("borderColor".equals(nodeName)) {
                    if (nodeValue.charAt(0) == '#') {
                        bmTextStyle.a(Color.parseColor(nodeValue));
                    } else {
                        bmTextStyle.a(Integer.parseInt(nodeValue));
                    }
                } else if ("borderWidth".equals(nodeName)) {
                    bmTextStyle.b(Integer.parseInt(nodeValue));
                } else if ("gravity".equals(nodeName)) {
                    if ("left".equals(nodeValue)) {
                        bmLabelUI.e(1);
                    } else if ("right".equals(nodeValue)) {
                        bmLabelUI.e(4);
                    } else if ("hcenter".equals(nodeValue)) {
                        bmLabelUI.e(16);
                    } else if (Constant.MAP_KEY_TOP.equals(nodeValue)) {
                        bmLabelUI.e(2);
                    } else if ("bottom".equals(nodeValue)) {
                        bmLabelUI.e(8);
                    } else if ("vcenter".equals(nodeValue)) {
                        bmLabelUI.e(32);
                    } else if ("bottom|hcenter".equals(nodeValue)) {
                        bmLabelUI.e(24);
                    } else if ("center".equals(nodeValue)) {
                        bmLabelUI.e(48);
                    }
                } else {
                    a(bmLabelUI, nodeName, nodeValue);
                }
            }
        }
        bmLabelUI.a(bmTextStyle);
    }

    private void a(BmImageUI bmImageUI, Node node) {
        NamedNodeMap attributes = node.getAttributes();
        int length = attributes.getLength();
        for (int i = 0; i < length; i++) {
            Node nodeItem = attributes.item(i);
            String nodeName = nodeItem.getNodeName();
            String nodeValue = nodeItem.getNodeValue();
            if (!TextUtils.isEmpty(nodeName) && !TextUtils.isEmpty(nodeValue)) {
                if ("frImage".equals(nodeName)) {
                    if (!TextUtils.isEmpty(nodeValue)) {
                        bmImageUI.b(new BmGuessResource(nodeValue));
                    }
                } else if ("mask".equals(nodeName)) {
                    if (!TextUtils.isEmpty(nodeValue)) {
                        bmImageUI.c(new BmGuessResource(nodeValue));
                    }
                } else {
                    a(bmImageUI, nodeName, nodeValue);
                }
            }
        }
    }

    private void a(BmVerticalLayout bmVerticalLayout, Node node) {
        NamedNodeMap attributes = node.getAttributes();
        int length = attributes.getLength();
        for (int i = 0; i < length; i++) {
            Node nodeItem = attributes.item(i);
            String nodeName = nodeItem.getNodeName();
            String nodeValue = nodeItem.getNodeValue();
            if (!TextUtils.isEmpty(nodeName) && !TextUtils.isEmpty(nodeValue)) {
                if (!"gravity".equals(nodeName) && !"childhalign".equals(nodeName)) {
                    a(bmVerticalLayout, nodeName, nodeValue);
                } else if ("left".equals(nodeValue)) {
                    bmVerticalLayout.e(1);
                } else if ("right".equals(nodeValue)) {
                    bmVerticalLayout.e(4);
                } else if ("hcenter".equals(nodeValue)) {
                    bmVerticalLayout.e(16);
                }
            }
        }
    }

    private void a(BmHorizontalLayout bmHorizontalLayout, Node node) {
        NamedNodeMap attributes = node.getAttributes();
        int length = attributes.getLength();
        for (int i = 0; i < length; i++) {
            Node nodeItem = attributes.item(i);
            String nodeName = nodeItem.getNodeName();
            String nodeValue = nodeItem.getNodeValue();
            if (!TextUtils.isEmpty(nodeName) && !TextUtils.isEmpty(nodeValue)) {
                if (!"gravity".equals(nodeName) && !"childvalign".equals(nodeName)) {
                    a(bmHorizontalLayout, nodeName, nodeValue);
                } else if (Constant.MAP_KEY_TOP.equals(nodeValue)) {
                    bmHorizontalLayout.e(2);
                } else if ("bottom".equals(nodeValue)) {
                    bmHorizontalLayout.e(8);
                } else if ("vcenter".equals(nodeValue)) {
                    bmHorizontalLayout.e(32);
                }
            }
        }
    }

    private void a(BmFrameLayout bmFrameLayout, Node node) {
        NamedNodeMap attributes = node.getAttributes();
        int length = attributes.getLength();
        for (int i = 0; i < length; i++) {
            Node nodeItem = attributes.item(i);
            String nodeName = nodeItem.getNodeName();
            String nodeValue = nodeItem.getNodeValue();
            if (!TextUtils.isEmpty(nodeName) && !TextUtils.isEmpty(nodeValue)) {
                if (!"gravity".equals(nodeName) && !"childalign".equals(nodeName)) {
                    a(bmFrameLayout, nodeName, nodeValue);
                } else if ("left".equals(nodeValue)) {
                    bmFrameLayout.e(1);
                } else if ("right".equals(nodeValue)) {
                    bmFrameLayout.e(4);
                } else if ("center".equals(nodeValue)) {
                    bmFrameLayout.e(48);
                } else if ("hcenter".equals(nodeValue)) {
                    bmFrameLayout.e(16);
                } else if (Constant.MAP_KEY_TOP.equals(nodeValue)) {
                    bmFrameLayout.e(2);
                } else if ("bottom".equals(nodeValue)) {
                    bmFrameLayout.e(8);
                } else if ("vcenter".equals(nodeValue)) {
                    bmFrameLayout.e(32);
                } else if ("bottom|hcenter".equals(nodeValue)) {
                    bmFrameLayout.e(24);
                }
            }
        }
    }
}
