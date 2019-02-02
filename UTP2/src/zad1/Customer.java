package zad1;

public class Customer {

    private String name;
    private ShoppingCart sC = null;
	private double money;
	private Box box = null;
	public boolean packFlag = false;
	

    public Customer(String name, double pieniadze) {
        this.name = name;
        this.money = pieniadze;
        sC =  new ShoppingCart(this);
        box =  new Box(this);
            
    }

	public ShoppingCart getShoppingCart() {
		return this.sC;	
		
	}

	public double getCash() {
		return this.money;
	}

	public double pay() {
		this.sC.check();
		money = sC.obliczKoszyk();
		return money;
	}

	public void pack(Box box) {
		box.products = this.getShoppingCart().getFlowersList();
		this.packFlag = true;
	}
	
	public boolean getPackFlag() {
		return packFlag;
	}

	public Customer getCustomer() {
		return this;
	}

	public void get(Flower f) {
		sC.addFlower(f);
	}
	
	public String getName() {
		return name;
	}
}
