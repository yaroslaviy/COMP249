package question2;

import java.util.NoSuchElementException;

// TODO: Auto-generated Javadoc
/**
 * The Class CellList.
 */
public class CellList {

	/**
	 * The Class CellNode.
	 */
	public class CellNode {

		/** The cellphone. */
		private CellPhone cell;

		/** The next node. */
		private CellNode next;

		/**
		 * Instantiates a new cell node.
		 */
		public CellNode() {
			this.cell = null;
			this.next = null;
		}

		/**
		 * Instantiates a new cell node.
		 *
		 * @param cell the cellphone object
		 * @param next  the next node
		 */
		public CellNode(CellPhone cell, CellNode next) {
			this.cell = cell;
			this.next = next;
		}

		/**
		 * Instantiates a new cell node for copy.
		 *
		 * @param original the original node
		 */
		public CellNode(CellNode original) {
			this.cell = original.cell.clone();
			this.next = original.next;
		}

		/**
		 * Clone method to create new node from original
		 * 
		 * @return new cloned CellNode
		 */
		public CellNode clone() {
			return new CellNode(this.cell.clone(), this.next);
		}

		/**
		 * Gets the cell.
		 *
		 * @return the cell of this node
		 */
		public CellPhone getCell() {
			return cell;
		}

		/**
		 * Sets the cell.
		 *
		 * @param cell the new cell for the node
		 */
		public void setCell(CellPhone cell) {
			this.cell = cell;
		}

		/**
		 * Gets the next.
		 *
		 * @return the next for this node
		 */
		public CellNode getNext() {
			return next;
		}

		/**
		 * Sets the next.
		 *
		 * @param next the new next for the node
		 */
		public void setNext(CellNode next) {
			this.next = next;
		}

	}

	/** The head. */
	private CellNode head;

	/** The size. */
	private int size;

	/**
	 * Instantiates a new cell list.
	 */
	public CellList() {
		this.head = null;
		this.size = 0;
	}

	/**
	 * Instantiates a new copy cell list from original.
	 *
	 * @param original the original list
	 */
	public CellList(CellList original) {


		if (original.head == null)
			head = null;
		else {
			head = null;
			CellNode temp1, temp2, temp3;

			temp1 = original.head;
			temp2 = temp3 = null;
			while (temp1 != null) {
				if (head == null) {
					temp2 = new CellNode(temp1);
					head = temp2;
					
				} else {
					temp3 = new CellNode(temp1);
					temp2.next = temp3;
					temp2 = temp3;
				}
				temp1 = temp1.next;
				size++;
			}

			temp2 = temp3 = null;
		}
	}

	/**
	 * Gets the head.
	 *
	 * @return the head of the list
	 */
	public CellNode getHead() {
		return head;
	}

	/**
	 * Sets the head.
	 *
	 * @param head the new head of the list
	 */
	public void setHead(CellNode head) {
		if (head == null)
			size++;
		this.head = head;

	}

	/**
	 * Gets the size.
	 *
	 * @return the size of the list
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Sets the size.
	 *
	 * @param size the new size of the list
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Adds the new cellPhone to start.
	 *
	 * @param obj the new CellPhone object
	 */
	public void addToStart(CellPhone obj) {
		CellNode temp = head;
		head = new CellNode(obj, temp);
		size++;
	}

	/**
	 * Insert new phone at index.
	 *
	 * @param obj the new CellPhone object
	 * @param i the index
	 */
	public void insertAtIndex(CellPhone obj, int i) {
		try {
			if (i < 0 || i > this.size - 1)
				throw new NoSuchElementException();
			else {
				if (i == 0)
					this.addToStart(obj);
				else {
					CellNode pos = head;
					for (int ind = 0; ind < i - 1; ind++) {
						pos = pos.next;
					}
					CellNode temp = pos.next;
					pos.next = new CellNode(obj, temp);
					size++;
				}
			}

		} catch (NoSuchElementException e) {
			System.out.println("No element was found.");
			System.exit(0);
		}

	}

	/**
	 * Delete node from index.
	 *
	 * @param i the index
	 */
	public void deleteFromIndex(int i) {
		try {
			if (i < 0 || i > this.size - 1)
				throw new NoSuchElementException();
			else {
				if (i == 0)
					this.deleteFromStart();
				else {
					CellNode pos = head;
					for (int ind = 0; ind < i - 1; ind++) {
						pos = pos.next;
					}
					CellNode temp = pos.next;
					pos.next = temp.next;
					temp = null;
					size--;
				}
			}

		} catch (NoSuchElementException e) {
			System.out.println("No element was found.");
			System.exit(0);
		}

	}

	/**
	 * Delete node from start.
	 */
	public void deleteFromStart() {
		try {
			CellNode pos = head;
			head = pos.next;
			pos = null;
			size--;
		} catch (Exception e) {
			System.out.println("Node cannot be deleted.");
		}

	}

	/**
	 * Replace phone at index.
	 *
	 * @param obj the new CellPhone object
	 * @param i the index
	 */
	public void replaceAtIndex(CellPhone obj, int i) {
		try {
			if (i < 0 || i > this.size - 1) {
				throw new NoSuchElementException();
			} else {
				CellNode pos = head;
				if (i == 0) {
					head = new CellNode(obj, pos.next);
				} else
					for (int ind = 0; ind < i - 1; ind++) {
						pos = pos.next;
					}
				CellNode insert = new CellNode(obj, pos.next.next);
				CellNode delete = pos.next;
				pos.next = insert;
				delete = null;
			}
		} catch (NoSuchElementException e) {
			System.out.println("No element was found.");
			System.exit(0);
		}

	}

	/**
	 * Find object in the list.
	 *
	 * @param sNum the serial number too look for
	 * @return the cell node with the number
	 */
	public CellNode find(long sNum) {

		CellNode pointer = head;
		for (int i = 0; i < this.size - 1; i++) {
			if (pointer.cell.getSerialNum() == sNum) {
				System.out.println(sNum + " is located at index " + i);
				return pointer;
			}
			pointer = pointer.next;
		}
		return null;
	}

	/**
	 * Contains.
	 *
	 * @param sNum the s num
	 * @return true, if successful
	 */
	public boolean contains(long sNum) {


		CellNode pointer = head;
		for (int i = 0; i < this.size - 1; i++) {
			if (pointer.getCell().getSerialNum() == sNum)
				return true;
			pointer = pointer.next;
		}
		return false;
	}

	/**
	 * Equals.
	 *
	 * @param list the list
	 * @return true, if successful
	 */
	public boolean equals(CellList list) {
		if (this.getSize() != list.getSize())
			return false;
		CellNode pos1 = this.head;
		CellNode pos2 = list.head;
		for (int i = 0; i < this.size - 1; i++) {
			if (!pos1.getCell().equals(pos2.getCell()))
				return false;
		}
		return true;
	}

	/**
	 * Show contents.
	 */
	public void showContents() {

		System.out.println("Current size of this list is " + size);
		System.out.println("=====================================");
		CellNode pos = head;
		for (int i = 0; i < size; i++) {
			if (i % 3 == 2)
				System.out.println(pos.cell.toString() + "--->");
			else
				System.out.print(pos.cell.toString() + "--->");
			pos = pos.next;
		}
		System.out.println("X");
	}
}
