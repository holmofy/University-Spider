package cn.hff.dto;

/**
 * GsonFormatter生成
 * <p>
 * Created by Holmofy on 2018/5/13.
 */
public class TreeNodeDto {

    /**
     * id : 11020100
     * nodeType : null
     * text : 林学(<font color=#0099FF>无</font>)
     * leaf : true
     * children : null
     * iconCls : Department
     */

    private String id;
    private Object nodeType;
    private String text;
    private boolean leaf;
    private Object children;
    private String iconCls;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getNodeType() {
        return nodeType;
    }

    public void setNodeType(Object nodeType) {
        this.nodeType = nodeType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public Object getChildren() {
        return children;
    }

    public void setChildren(Object children) {
        this.children = children;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }
}
