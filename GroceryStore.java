import java.util.ArrayList;
import java.util.Iterator;

public class GroceryStore
{
    ArrayList myItems;
    
    /**
     * Creates an initially empty grocery store
     */
    public GroceryStore()
    {
	myItems = new ArrayList();
    }


    /**
     * Changes the price of the item associated with itemName
     */
	
    public void setPrice(String itemName, double price)
    {
	GroceryItem item = getItem(itemName);
	if (item != null) {
	    ( (GItem) item).price = price;
	}
    }

    /**
     * returns the item associated with itemName
     */
	
    public GroceryItem getItem(String itemName)
    {
	return getGItem(itemName);
    }

    /**
     * returns a (possibly empty) ArrayList of all
     * the items in the specified category
     */
	
    public ArrayList getAllItems(String category)
    {
	ArrayList list = new ArrayList();
	for(int k=0; k < myItems.size(); k++) {
	    GItem item = (GItem) myItems.get(k);
	    if (item.getCategory().equals(category)) {
		list.add(item);
	    }
	}
	return list;
    }

    /**
     * precondition: names.length == prices.length
     * changes the price of the item associated with names[k]
     * to the price specified by prices[k]
     */
	
    public void changePrices(String[] names, double[] prices)
    {
	for(int k=0; k < names.length; k++) {
	    setPrice(names[k],prices[k]);
	}
    }


    private GItem getGItem(String itemName)
    {
	Iterator it = myItems.iterator();
	while (it.hasNext()) {
	    GItem gitem = (GItem) it.next();
	    if (gitem.getName().equals(itemName)) {
		return gitem;
	    }
	}
	return null;
    }
    
    private class GItem implements GroceryItem
    {
	String name;
	double price;
	String category;
	int size;
	public String getName()  { return name;  }
	public double getPrice() { return price; }
	public int    getSize()  { return size;  }
	public String getCategory() { return category; }
    }
	
}
