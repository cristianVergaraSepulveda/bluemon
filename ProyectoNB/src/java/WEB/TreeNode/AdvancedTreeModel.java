package WEB.TreeNode;

import org.zkoss.zul.DefaultTreeModel;
import org.zkoss.zul.DefaultTreeNode;

public class AdvancedTreeModel extends DefaultTreeModel {
	DefaultTreeNode _root;

	public AdvancedTreeModel(ContactTreeNode contactTreeNode) {
		super(contactTreeNode);
		_root = contactTreeNode;
	}

	/**
	 * remove the nodes which parent is <code>parent</code> with indexes
	 * <code>indexes</code>
	 * 
	 * @param parent
	 *            The parent of nodes are removed
	 * @param indexFrom
	 *            the lower index of the change range
	 * @param indexTo
	 *            the upper index of the change range
	 * @throws IndexOutOfBoundsException
	 *             - indexFrom < 0 or indexTo > number of parent's children
	 */
	public void remove(DefaultTreeNode parent, int indexFrom, int indexTo) throws IndexOutOfBoundsException {
		DefaultTreeNode stn = parent;
		for (int i = indexTo; i >= indexFrom; i--)
			try {
				stn.getChildren().remove(i);
			} catch (Exception exp) {
				exp.printStackTrace();
			}
	}

	public void remove(DefaultTreeNode target) throws IndexOutOfBoundsException {
		int index = 0;
		DefaultTreeNode parent = null;
		// find the parent and index of target
		parent = dfSearchParent(_root, target);
		for (index = 0; index < parent.getChildCount(); index++) {
			if (parent.getChildAt(index).equals(target)) {
				break;
			}
		}
		remove(parent, index, index);
	}

	/**
	 * insert new nodes which parent is <code>parent</code> with indexes
	 * <code>indexes</code> by new nodes <code>newNodes</code>
	 * 
	 * @param parent
	 *            The parent of nodes are inserted
	 * @param indexFrom
	 *            the lower index of the change range
	 * @param indexTo
	 *            the upper index of the change range
	 * @param newNodes
	 *            New nodes which are inserted
	 * @throws IndexOutOfBoundsException
	 *             - indexFrom < 0 or indexTo > number of parent's children
	 */
	public void insert(Object parent, int indexFrom, int indexTo, DefaultTreeNode[] newNodes)
			throws IndexOutOfBoundsException {
		DefaultTreeNode stn = (DefaultTreeNode) parent;
		for (int i = indexFrom; i <= indexTo; i++) {
			try {
				stn.getChildren().add(i, newNodes[i - indexFrom]);
			} catch (Exception exp) {
				throw new IndexOutOfBoundsException("Out of bound: " + i + " while size=" + stn.getChildren().size());
			}
		}
	}

	/**
	 * append new nodes which parent is <code>parent</code> by new nodes
	 * <code>newNodes</code>
	 * 
	 * @param parent
	 *            The parent of nodes are appended
	 * @param newNodes
	 *            New nodes which are appended
	 */
	public void add(DefaultTreeNode parent, Object[] newNodes) {
		DefaultTreeNode stn = (DefaultTreeNode) parent;
		int indexFrom = stn.getChildren().size();
		int indexTo = stn.getChildren().size() + newNodes.length - 1;
		for (int i = 0; i < newNodes.length; i++)
			stn.getChildren().add(newNodes[i]);

	}

	private boolean dfSearch(Object node, Object target) {
		if (node.equals(target)) {
			return true;
		} else {
			int size = getChildCount(node);
			for (int i = 0; i < size; i++) {
				boolean flag = dfSearch(getChild(node, i), target);
				if (flag) {
					return true;
				}
			}
		}
		return false;
	}

	private DefaultTreeNode dfSearchParent(DefaultTreeNode node, DefaultTreeNode target) {
		if (node.getChildren() != null && node.getChildren().contains(target)) {
			return node;
		} else {
			int size = getChildCount(node);
			for (int i = 0; i < size; i++) {
				DefaultTreeNode parent = dfSearchParent((DefaultTreeNode) getChild(node, i), target);
				if (parent != null) {
					return parent;
				}
			}
		}
		return null;
	}

}
