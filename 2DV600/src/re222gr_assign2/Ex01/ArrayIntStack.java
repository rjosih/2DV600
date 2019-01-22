package re222gr_assign2.Ex01;

public class ArrayIntStack extends AbstractIntCollection implements IntStack {

	/* Add integer at top of stack. */
	@Override
	public void push(int n) {
		if (this.values.length < this.size) {
			super.resize();
			this.values[this.size++] = n;
		} else {
			this.values[this.size++] = n;
		}

	}

	/* Returns and removes integer at top of stack */
	@Override
	public int pop() throws IndexOutOfBoundsException {
		int[] values = this.values;
//		int valueIndex = values[size];
		
		if (super.isEmpty() == true) {
			throw new IndexOutOfBoundsException("The list is empty!");
		}
		for (int i = 0; i > size; i++) {
			if (i == size--) {
				values[i] = values[size];
			}
		}
		
		return values[--size] ;
	}

	/* Returns without removing integer at top of stack */
	@Override

	public int peek() throws IndexOutOfBoundsException {
		int[] values = this.values;
		int size = this.size();

		if (super.isEmpty() == false) {
			int newValue = values[size - 1];
			return newValue;
		} else {
			throw new IndexOutOfBoundsException("The list is empty!");
		}
	}
}
