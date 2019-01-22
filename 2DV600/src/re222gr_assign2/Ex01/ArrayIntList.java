/**
 * 
 */
package re222gr_assign2.Ex01;

/**
 * @author rjosi
 *
 */
public class ArrayIntList extends AbstractIntCollection implements IntList {

	/* Add integer n to the end of the list. */
	@Override
	public void add(int n) {
		int[] values = this.values;
		values[this.size++] = n;
	}

	/*
	 * Inserts integer n at position index. Shifts the element currently at that
	 * position (if any) and any subsequent elements to the right.
	 */
	@Override
	public void addAt(int n, int index) throws IndexOutOfBoundsException {
		if (super.size != 0) {
			size++;
			int[] values = this.values;
			for (int i = 0; i < size; i++)
				if (i == index) {
					for (int j = size + 1; j > index; j--) {
						int newValue = values[j - 1];
						this.values[j] = newValue;
					}
				}
			values[index] = n;	
		}else { 
			throw new IndexOutOfBoundsException();
		}
	}

	/* Remove integer at position index. */
	@Override
	public void remove(int index) throws IndexOutOfBoundsException {
		if(checkIndex(index, size())){
			
			for (int i = index; i < size(); i++){
				values[i] = values[i+1];			
			}
			size--;
		}else {
			throw new IndexOutOfBoundsException();			
		}
	}

	/* Get integer at position index. */
	@Override
	public int get(int index) throws IndexOutOfBoundsException {
		if (super.size() == 0) {
			throw new IndexOutOfBoundsException("EMPTY LIST");
		} else {
			return values[index];
		}
	}

	/* Find position of integer n, otherwise return -1 */
	@Override
	public int indexOf(int n) {
		int size = this.size;
		int[] values = this.values;

		if (super.size() > 0) {
			for (int i = 0; i < size; i++) {
				if (values[i] == n) {
					return i;
				}
			}
		}
		return -1;
	}

}
