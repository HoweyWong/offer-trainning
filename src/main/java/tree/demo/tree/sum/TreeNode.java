package tree.demo.tree.sum;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author huanghao
 * @Date 2021-12-21
 * @Version 1.0
 */
@Data
public class TreeNode {
    @Override
    public String toString() {
        return "TreeNode{" +
                "rowMap=" + rowMap +
                ", rowMaps=" + rowMaps +
                ", id=" + id +
                ", label='" + label + '\'' +
                ", pid=" + pid +
                ", children=" + children +
                '}';
    }

    private Map<String, Object> rowMap;
    private List<Map<String, Object>> rowMaps = new ArrayList<>();
    /**
     * 节点ID
     */
    private long id;
    /**
     * 显示名称
     */
    private String label;
    /**
     * 父节点ID
     */
    private long pid;
    /**
     * 子节点集合对象
     */
    private List<TreeNode> children = new ArrayList<TreeNode>();
    /**
     * 是否计算本身
     */
    private boolean addSelf = false;

}
