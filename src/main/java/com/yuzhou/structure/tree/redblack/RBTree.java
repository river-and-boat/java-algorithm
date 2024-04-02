package com.yuzhou.structure.tree.redblack;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicLong;

public class RBTree<T extends Comparable<T>> {
    private final RBTreeNode<T> root;

    private AtomicLong size = new AtomicLong(0);

    public volatile boolean overrideMode = true;

    public RBTree() {
        this.root = new RBTreeNode<>();
    }

    public RBTree(boolean overrideMode) {
        this();
        this.overrideMode = overrideMode;
    }

    public long getSize() {
        return this.size.get();
    }

    public RBTreeNode<T> getRoot() {
        return this.root.left;
    }

    public void addNode(T value) {
        RBTreeNode<T> node = new RBTreeNode<>(value);
        addNode(node);
    }

    public T find(T value) {
        RBTreeNode<T> dataRoot = getRoot();
        while (dataRoot != null) {
            int cmp = dataRoot.value.compareTo(value);
            if (cmp < 0) {
                dataRoot = dataRoot.right;
                continue;
            }
            if (cmp > 0) {
                dataRoot = dataRoot.left;
                continue;
            }
            return dataRoot.value;
        }
        return null;
    }

    private void addNode(RBTreeNode<T> node) {
        node.left = null;
        node.right = null;
        node.red = true;
        setParent(node, null);
        if (root.left == null) {
            root.left = node;
            node.red = false;
            size.incrementAndGet();
        } else {
            RBTreeNode<T> parentNode = findParentNode(node);
            int cmp = parentNode.value.compareTo(node.value);
            if (this.overrideMode && cmp == 0) {
                T value = parentNode.value;
                parentNode.value = node.value; // 更新value的值
                return;
            }
            if (!this.overrideMode && cmp == 0) {
                return;
            }
            setParent(node, parentNode);
            if (cmp > 0) {
                parentNode.left = node;
            } else {
                parentNode.right = node;
            }
            // 调整红黑树结构，使其满足红黑树定义
            fixInsert(node);
            size.incrementAndGet();
        }
    }

    private void setParent(RBTreeNode<T> node, RBTreeNode<T> parent) {
        if (node != null) {
            node.parent = parent;
            if (parent == root) {
                node.parent = null;
            }
        }
    }

    private RBTreeNode<T> findParentNode(RBTreeNode<T> node) {
        RBTreeNode<T> dataRoot = getRoot();
        RBTreeNode<T> child = dataRoot;
        while (child != null) {
            int cmp = child.value.compareTo(node.value);
            if (cmp == 0) {
                return child;
            }
            dataRoot = child;
            if (cmp > 0) {
                child = child.left;
            } else {
                child = child.right;
            }
        }
        return dataRoot;
    }

    /**
     * 插入新节点后，使用此方法对红黑树进行调整，主要操作包括：变色、左旋、右旋
     * 使插入新节点后的树满足红黑树的定义
     * *****************************************
     * 红黑树定义:
     * 1. 任何一个节点都有颜色，红色或黑色
     * 2. 根节点必须是黑色
     * 3. 父子节点之间不能出现两个连续的红节点
     * 4. 任何一个节点向下遍历到其子孙的叶子节点，所经过的黑色节点个数必须相等
     * 5. 空节点被认为是黑色的
     *
     * @param node 插入的新节点
     */
    private void fixInsert(RBTreeNode<T> node) {
        RBTreeNode<T> parent = node.parent;
        // 插入修复操作 只有当新节点的parent为红色时，才需要修复
        while (parent != null && parent.red) {
            RBTreeNode<T> uncle = getUncle(node);
            if (uncle != null) {
                // 如果叔叔节点不为空，那他必然是红色，因为parent为红色
                parent.red = false;
                uncle.red = false;
                parent.parent.red = true;
                // 继续向上修复
                node = parent.parent;
                parent = node.parent;
            } else {
                RBTreeNode<T> ancestor = parent.parent;
                // case1: 如果叔叔节点为空，并且祖父、父亲和新节点在一条斜线，则以父节点为中心，直接进行右旋，并且将父节点与祖父节点颜色互换
                // case2: 如果叔叔节点为空，但是祖父、父亲和新节点不在一条斜线，则先将新节点左旋，再进行case1操作
                if (parent == ancestor.left) {
                    boolean isRight = node == parent.right;
                    if (isRight) {
                        rotateLeft(parent);
                    }
                    rotateRight(ancestor);
                    // 叔叔节点不存在，那么祖父节点一定是黑色，不然不满足定义，因此转换后可以终止循环
                    if (isRight) {
                        node.red = false;
                        parent = null;
                    } else {
                        parent.red = false;
                    }
                    ancestor.red = true;
                } else {
                    boolean isLeft = node == parent.left;
                    if (isLeft) {
                        rotateRight(parent);
                    }
                    rotateLeft(ancestor);
                    if (isLeft) {
                        node.red = false;
                        parent = null;
                    } else {
                        parent.red = false;
                    }
                    ancestor.red = true;
                }
            }
        }
        getRoot().red = false;
        getRoot().parent = null;
    }

    private RBTreeNode<T> getUncle(RBTreeNode<T> node) {
        RBTreeNode<T> parent = node.parent;
        RBTreeNode<T> ancestor = parent.parent;
        if (ancestor == null) {
            return null;
        }
        if (parent == ancestor.left) {
            return ancestor.right;
        } else {
            return ancestor.left;
        }
    }

    private void rotateLeft(RBTreeNode<T> node) {
        RBTreeNode<T> right = node.right;
        if (right == null) {
            throw new IllegalStateException("right node is null");
        }
        RBTreeNode<T> parent = node.parent;
        node.right = right.left;
        setParent(right.left, node);
        right.left = node;
        setParent(node, right);
        if (parent == null) {
            root.left = right;
            setParent(right, null);
        } else {
            if (parent.left == node) {
                parent.left = right;
            } else {
                parent.right = right;
            }
            setParent(right, parent);
        }
    }

    private void rotateRight(RBTreeNode<T> node) {
        RBTreeNode<T> left = node.left;
        if (left == null) {
            throw new IllegalStateException("left node is null");
        }
        RBTreeNode<T> parent = node.parent;
        node.left = left.right;
        setParent(left.right, node);
        left.right = node;
        setParent(node, left);

        if (parent == null) {
            root.left = left;
            setParent(left, null);
        } else {
            if (parent.left == node) {
                parent.left = left;
            } else {
                parent.right = left;
            }
            setParent(left, parent);
        }
    }

    public void printTree(RBTreeNode<T> root) {
        LinkedList<RBTreeNode<T>> queue = new LinkedList<>();
        if (root == null) {
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            RBTreeNode<T> node = queue.poll();
            if (node != null) {
                String pos = node.parent == null ? "" : (node == node.parent.left ? " LE" : " RI");
                String pstr = node.parent == null ? "" : node.parent.value.toString();
                String cstr = node.red ? "R" : "B";
                cstr = node.parent == null ? cstr : cstr + " ";
                System.out.print(node.value.toString() + "(" + (cstr) + pstr + (pos) + ")" + "\t");

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }
}
