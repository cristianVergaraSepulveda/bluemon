package WEB.TreeNode;

import org.zkoss.zul.DefaultTreeNode;

public class ContactTreeNode extends DefaultTreeNode {
	private boolean open = false;

	public ContactTreeNode(Object data, DefaultTreeNode[] children) {
		super(data, children);
	}

	public ContactTreeNode(Object data, DefaultTreeNode[] children, boolean open) {
		super(data, children);
		setOpen(open);
	}

	public ContactTreeNode(Object data) {
		super(data);

	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

}
