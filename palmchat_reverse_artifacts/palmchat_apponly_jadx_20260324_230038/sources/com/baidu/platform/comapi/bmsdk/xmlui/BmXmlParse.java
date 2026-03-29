package com.baidu.platform.comapi.bmsdk.xmlui;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class BmXmlParse {
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0039 -> B:27:0x003c). Please report as a decompilation issue!!! */
    public static Document a(byte[] bArr) {
        Document document = null;
        if (bArr == null || bArr.length < 10) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            try {
                try {
                    try {
                        try {
                            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(byteArrayInputStream);
                            byteArrayInputStream.close();
                        } catch (SAXException e) {
                            e.printStackTrace();
                            byteArrayInputStream.close();
                        }
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        byteArrayInputStream.close();
                    }
                } catch (ParserConfigurationException e3) {
                    e3.printStackTrace();
                    byteArrayInputStream.close();
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            if (document != null) {
                a(document.getDocumentElement());
            }
            return document;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            throw th;
        }
    }

    private static native String nativeConvertRichText2Xml(String str);

    private static void a(Node node) {
        while (node != null) {
            Node previousSibling = node.getPreviousSibling();
            if ("#text".equalsIgnoreCase(node.getNodeName())) {
                node.getParentNode().removeChild(node);
            } else {
                NodeList childNodes = node.getChildNodes();
                if (childNodes != null && childNodes.getLength() > 0) {
                    a(node.getLastChild());
                }
            }
            node = previousSibling;
        }
    }
}
