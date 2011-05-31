package pl.edu.uj.kognitywistyka.user.model;

import javax.faces.model.DataModel;

import pl.edu.uj.kognitywistyka.util.Predicate;

import java.util.Comparator;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FilterAndSortData<E> extends DataModel<E> {

	private DataModel<E> model;
	private Integer[] rows;

	public FilterAndSortData() { // mandated by JSF spec
		setWrappedData(null);
	}

	public FilterAndSortData(E[] names) { // recommended by JSF spec
		setWrappedData(names);
	}

	public FilterAndSortData(DataModel<E> model) {
		this.model = model;
		initializeRows();
	}

	private E getData(int row) {
		int originalIndex = model.getRowIndex();
		model.setRowIndex(row);
		E thisRowData = model.getRowData();
		model.setRowIndex(originalIndex);
		return thisRowData;
	}

	public void sortBy(final Comparator<E> dataComp) {
		Comparator<Integer> rowComp = new Comparator<Integer>() {
			public int compare(Integer r1, Integer r2) {
				E e1 = getData(r1);
				E e2 = getData(r2);
				return dataComp.compare(e1, e2);
			}
		};
		Arrays.sort(rows, rowComp);
	}
	
	public void filterBy(final Predicate<E> predicate)
	{	
		List<E> result = new LinkedList<E>();
	    for (Integer row: rows) {
	    	E element = this.getData(row);
	        if (predicate.apply(element)) {
	            result.add(element);
	        }
	    }
		this.setWrappedData(result);
	}
	public void filterBy2(final Predicate<E> predicate)
	{	
		List<Integer> result = new LinkedList<Integer>();
	    for (Integer row: rows) {
	    	E element = this.getData(row);
	        if (predicate.apply(element)) {
	            result.add(row);
	        }
	    }
		rows = null;
		rows = result.toArray(new Integer[1]);
	}
	
	public void setRowIndex(int rowIndex) {
		if (0 <= rowIndex && rowIndex < rows.length)
			model.setRowIndex(rows[rowIndex]);
		else
			model.setRowIndex(rowIndex);
	}

	// The following methods delegate to the decorated model

	public boolean isRowAvailable() {
		return model.isRowAvailable();
	}

	public int getRowCount() {
		return model.getRowCount();
	}

	public E getRowData() {
		return model.getRowData();
	}

	public int getRowIndex() {
		return model.getRowIndex();
	}

	public Object getWrappedData() {
		return model.getWrappedData();
	}

	public void setWrappedData(Object data) {
		model.setWrappedData(data);
		initializeRows();
	}

	private void initializeRows() {
		int rowCnt = model.getRowCount();
		if (rowCnt != -1) {
			rows = new Integer[rowCnt];
			for (int i = 0; i < rowCnt; ++i)
				rows[i] = i;
		}
	}
}
