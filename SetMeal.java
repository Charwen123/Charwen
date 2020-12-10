package 西二二轮;

public class SetMeal {
	String name1;
	String chicken;
	double mealPrice;
	Drinks Drink;
	
	public SetMeal() {
		
	}
	public SetMeal(String name1,String chicken,double mealPrice,Drinks Drink) {
		this.name1=name1;
		this.chicken=chicken;
		this.mealPrice=mealPrice;
		this.Drink=Drink;
	}

	public String toString() {
		return name1+":"+chicken+"\t"+Drink.name+"\t总价："+mealPrice;
	}
	
}
