package tree.demo.tree.sum;

import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

/**
 * @Description
 * @Author huanghao
 * @Date 2021-12-21
 * @Version 1.0
 */
public class TreeManager {

    /**
     * 将List转成tree结构数据
     *
     * @param list
     * @param rootId 默认顶级节点ID
     * @return
     */
    public static List<TreeNode> listToTree(List<TreeNode> list, long rootId) {
        List<TreeNode> tree = new ArrayList<TreeNode>();
        Map<Long, TreeNode> map = new HashMap<Long, TreeNode>();
        // 将所有的数据，以键值对的形式装入map中
        for (TreeNode node : list) {
            // 去除冗余的子节点
            node.setChildren(new ArrayList<TreeNode>());
            map.put(node.getId(), node);
        }
        for (TreeNode node : list) {
            // 如果id是父级的话就放入tree中
            if (node.getId() == rootId) {
                tree.add(node);
            } else {
                // 子级通过父id获取到父级的类型
                TreeNode parent = map.get(node.getPid());
                // 父级获得子级，再将子级放到对应的父级中
                if (parent != null) {
                    parent.getChildren().add(node);
                }
            }
        }
        return tree;
    }

    /**
     * 将tree结构数据转成List结构
     *
     * @param list
     * @return
     */
    public static void treeToList(TreeNode node, List<TreeNode> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        //设置当前节点的必要数据
        TreeNode nodeValue = new TreeNode();
        nodeValue.setId(node.getId());
        nodeValue.setLabel(node.getLabel());
        nodeValue.setPid(node.getPid());
        nodeValue.setChildren(new ArrayList<>());
        nodeValue.setRowMap(node.getRowMap());
        nodeValue.setRowMaps(new ArrayList<>());
        list.add(nodeValue);
        //遍历递归子节点
        if (node.getChildren().size() > 0) {
            for (int i = 0; i < node.getChildren().size(); i++) {
                TreeNode node_ = node.getChildren().get(i);
                treeToList(node_, list);
            }
        }
    }


    /**
     * 转换数据格式并设置对应节点的值汇总到根节点
     *
     * @param tree
     * @return
     */
    public static List<TreeNode> treeToListWithRowMap(TreeNode tree) {
        List<TreeNode> list = new ArrayList<>();
        // 获取到List
        treeToList(tree, list);
        Map<Long, TreeNode> nodeMap = new HashMap<>();
        // 将所有的数据，以键值对的形式装入map中
        for (TreeNode node : list) {
            // 去除冗余的子节点
            // 根据ID唯一利用map key去重
            node.setChildren(new ArrayList<>());
            nodeMap.put(node.getId(), node);
        }
        // 存储叶子节点ID
        Map<Long, Object> leaf = new HashMap<>();
        findMinNodes(tree, leaf);
        // 逐级设置父节点的值
        setRowMapToParentNode(leaf, nodeMap);

        // 汇总所有节点的值
        for (TreeNode node : nodeMap.values()) {
            // 每个节点包含的行数据，汇总到自己节点的当前行中
            List<Map<String, Object>> rowMaps = node.getRowMaps();
            if (CollectionUtils.isNotEmpty(rowMaps)) {
                Set<String> keys = rowMaps.get(0).keySet();
                Map<String, Object> rowMap = new HashMap<>();
                for (String key : keys) {
                    double sum = rowMaps.stream().mapToDouble(r -> {
                        Object o = r.get(key);
                        // 判空处理
                        return Double.parseDouble((o != null ? o : 0).toString());
                    }).sum();
                    rowMap.put(key, sum);
                }
                node.setRowMap(rowMap);
                nodeMap.put(node.getId(), node);
            }
        }
        // 将处理完的map的value集构建生成list返回
        List<TreeNode> result = new ArrayList<>(nodeMap.values());
        return result;
    }


    /**
     * 逐级追加设置节点的值（行数据）
     *
     * @param leaf
     * @param map
     */
    public static void setRowMapToParentNode(Map<Long, Object> leaf, Map<Long, TreeNode> map) {
        Map<Long, Object> newLeaf = new HashMap<Long, Object>();
        // 设置每个节点的值，从当前的叶子节点集合中遍历
        for (Long id_ : leaf.keySet()) {
            setParentNodeRowMap(newLeaf, map, id_);
        }
        if (newLeaf.size() > 1) {
            setRowMapToParentNode(newLeaf, map);
        }
    }

    /**
     * 查找最小子叶节点（没有子节点的节点）
     *
     * @param node
     * @param leafList
     */
    private static void findMinNodes(TreeNode node, Map<Long, Object> leafList) {
        if (node.getChildren().size() > 0) {
            TreeNode nodeTmp;
            for (int i = 0; i < node.getChildren().size(); i++) {
                nodeTmp = node.getChildren().get(i);
                findMinNodes(nodeTmp, leafList);
            }
        } else {
            leafList.put(node.getId(), node.getId());
        }
    }


    /**
     * 根据ID逐级查找父节点并设置值(设置rowmap逐级递归)
     *
     * @param map
     * @param id
     */
    private static void setParentNodeRowMap(Map<Long, Object> newLeaf, Map<Long, TreeNode> map, long id) {
        TreeNode node = map.get(id);
        // 设置自身节点的值
        if (!node.isAddSelf()) {
            node.setAddSelf(true);
            Map<String, Object> rowMap = node.getRowMap();
            if (!rowMap.isEmpty()) {
                node.getRowMaps().add(rowMap);
                // 更新节点数据
                map.put(node.getId(), node);
            }
        }
        TreeNode pNode = map.get(node.getPid());
        if (pNode != null) {
            // 将子节点的值赋给父节点
            pNode.getRowMaps().addAll(node.getRowMaps());
            // 设置自身节点的值
            if (!pNode.isAddSelf()) {
                pNode.setAddSelf(true);
                Map<String, Object> rowMap = pNode.getRowMap();
                if (rowMap != null && !rowMap.isEmpty()) {
                    pNode.getRowMaps().add(rowMap);
                }
            }
            // 更新节点数据
            map.put(pNode.getId(), pNode);
            // 往上递归，父节点变为叶子节点
            newLeaf.put(pNode.getId(), pNode.getId());
        }
    }


    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        tree.setId(1);
        tree.setLabel("顶层节点");
        tree.setPid(0);

        List<TreeNode> list = new ArrayList<>();
        TreeNode node1 = new TreeNode();
        node1.setId(2);
        node1.setLabel("子节点1");
        node1.setPid(1);
        list.add(node1);

        // 子节点设置子节点
        List<TreeNode> node1List = new ArrayList<>();
        TreeNode node = new TreeNode();
        node.setId(21);
        node.setLabel("子节点11");
        node.setPid(2);
        Map<String, Object> row = new HashMap<String, Object>() {{
            put("a", null);
            put("b", 1);
            put("c", 1);
        }};
        node.setRowMap(row);
        node1List.add(node);
        node1.setChildren(node1List);

        TreeNode node2 = new TreeNode();
        node2.setId(3);
        node2.setLabel("子节点2");
        Map<String, Object> row2 = new HashMap<String, Object>() {{
            put("a", 2);
            put("b", 2);
            put("c", 2);
        }};
        node2.setRowMap(row2);
        node2.setPid(1);
        list.add(node2);

        tree.setChildren(list);

        List<TreeNode> treeNodes = TreeManager.treeToListWithRowMap(tree);
        System.out.println(treeNodes);

    }
}
