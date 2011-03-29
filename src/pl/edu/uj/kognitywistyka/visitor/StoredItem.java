package pl.edu.uj.kognitywistyka.visitor;

import java.text.SimpleDateFormat;

public class StoredItem {
	private Storable item;
	private SimpleDateFormat dateAdd;

	public StoredItem(Storable item, SimpleDateFormat dateAdd) {
		super();
		this.item = item;
		this.dateAdd = dateAdd;
	}

	public Storable getItem() {
		return item;
	}

	public SimpleDateFormat getDateAdd() {
		return dateAdd;
	}

}
