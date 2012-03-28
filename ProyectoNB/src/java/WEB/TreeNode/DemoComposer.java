package WEB.TreeNode;

import java.util.HashMap;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.DropEvent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.DefaultTreeNode;
import org.zkoss.zul.Hlayout;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.Tree;
import org.zkoss.zul.Treecell;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.TreeitemRenderer;
import org.zkoss.zul.Treerow;
import org.zkoss.zul.Window;

import WEB.TreeNode.ContactList;
import WEB.TreeNode.ContactList2;

import WEB.TreeNode.Contact;

public class DemoComposer extends GenericForwardComposer {
	private Window demoWindow;
	private Tree tree;
	private AdvancedTreeModel contactTreeModel;

	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		// tree.setTreeitemRenderer(new ContactTreeRenderer()); Before 5.0.6
		tree.setItemRenderer(new ContactTreeRenderer());
		contactTreeModel = new AdvancedTreeModel(new ContactList2().setContactList()); //error  ContactList().getRoot()
		tree.setModel(contactTreeModel);
                
	}

	/**
	 * The structure of tree
	 * 
	 * <pre>
	 * &lt;treeitem>
	 *   &lt;treerow>
	 *     &lt;treecell>...&lt;/treecell>
	 *   &lt;/treerow>
	 *   &lt;treechildren>
	 *     &lt;treeitem>...&lt;/treeitem>
	 *   &lt;/treechildren>
	 * &lt;/treeitem>
	 * </pre>
	 */
	private final class ContactTreeRenderer implements TreeitemRenderer {
		@Override
		public void render(final Treeitem treeItem, Object treeNode) throws Exception {
			ContactTreeNode ctn = (ContactTreeNode) treeNode;
			Contact contact = (Contact) ctn.getData();
			Treerow dataRow = new Treerow();
			dataRow.setParent(treeItem);
			treeItem.setValue(ctn);
			treeItem.setOpen(ctn.isOpen());

			if (!isCategory(contact)) { // Contact Row
				Hlayout hl = new Hlayout();
                                //crear alarma para KO u OK 
                                Image img = new Image();
                                img.setSrc("/images/KO.gif");
                                
                               hl.appendChild(img);  //+ contact.getProfilepic()
				hl.appendChild(new Label(contact.getName()));
				hl.setSclass("h-inline-block");
				Treecell treeCell = new Treecell();
				treeCell.appendChild(hl);
				dataRow.setDraggable("true");
				dataRow.appendChild(treeCell);
				dataRow.addEventListener(Events.ON_CLICK, new EventListener() {  //ON_DOUBLE_CLICK
					@Override
					public void onEvent(Event event) throws Exception {
						ContactTreeNode clickedNodeValue = (ContactTreeNode) ((Treeitem) event.getTarget().getParent()).getValue();
						Window w = new Window("Sensor - " + ((Contact) clickedNodeValue.getData()).getName(), "normal", true);
						w.setPosition("parent");
						w.setParent(demoWindow);
						HashMap<String, String> dataArgs = new HashMap<String, String>();
						dataArgs.put("name", clickedNodeValue.getData().toString());
                                                dataArgs.put("sensor",String.valueOf(((Contact) clickedNodeValue.getData()).getIdSensor()) );
                                                dataArgs.put("unidad",String.valueOf(((Contact) clickedNodeValue.getData()).getCategory()) );
                                                dataArgs.put("nombre",String.valueOf(((Contact) clickedNodeValue.getData()).getName()) );
                                                dataArgs.put("micro",String.valueOf(((Contact) clickedNodeValue.getData()).getIdMicro()) );
						Executions.createComponents("/dialog.zul", w, dataArgs);
						w.doOverlapped();
					}
				});
                                
                                if(0<1){
                                    img.setSrc("/images/Ok.gif");
                                }
                                
			} else { // Category Row
				dataRow.appendChild(new Treecell(contact.getCategory()));
			}
			// Both category row and contact row can be item dropped
			dataRow.setDroppable("true"); 
			dataRow.addEventListener(Events.ON_DROP, new EventListener() {
				@Override
				public void onEvent(Event event) throws Exception {
					// The dragged target is a TreeRow belongs to an Treechildren of TreeItem.
					Treeitem draggedItem = (Treeitem) ((DropEvent) event).getDragged().getParent();
					ContactTreeNode draggedValue = (ContactTreeNode) draggedItem.getValue();
					Treeitem parentItem = treeItem.getParentItem();
					contactTreeModel.remove(draggedValue);
					if (isCategory((Contact) ((ContactTreeNode) treeItem.getValue()).getData())) {
						contactTreeModel.add((ContactTreeNode) treeItem.getValue(), new DefaultTreeNode[] { draggedValue });
					} else {
						int index = parentItem.getTreechildren().getChildren().indexOf(treeItem);
						contactTreeModel.insert(parentItem.getValue(), index, index, new DefaultTreeNode[] { draggedValue });
					}
				}
			});

		}

		private boolean isCategory(Contact contact) {
			return contact.getName() == null;
		}
	}
}