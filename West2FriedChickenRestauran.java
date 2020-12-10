package 西二二轮;

import java.time.LocalDate;
import java.util.ArrayList;

public class West2FriedChickenRestauran implements FriedChickenRestaurant{
	static double balance;
	Drinks drink;
	static final SetMeal meal;
	static ArrayList<Beer> beerList=new ArrayList<Beer>();
	static ArrayList<Juice> juiceList=new ArrayList<Juice>();
	static ArrayList<SetMeal> mealList=new ArrayList<SetMeal>();
	
	static {
		Drinks juice=new Juice("橙汁",5);
		juiceList.add((Juice) juice);
		meal=new SetMeal("套餐1","原味鸡",25,juice);
		mealList.add(meal);
		Drinks beer=new Beer("雪津",10,5);
		beerList.add((Beer)beer);
		
	}
	
	public West2FriedChickenRestauran() {
		this.balance=balance;
	}
	
	public void sale() {
		try {
			//卖啤酒
			if(meal.Drink instanceof Beer) {
				Beer beer=(Beer)drink;
				use(beer);
				balance=balance+meal.Drink.pay;
				System.out.println("成功售出"+meal);
			}else if(meal.Drink instanceof Juice) {
				//卖果汁
				Juice juice=(Juice)drink;
				use(juice);
				balance=balance+meal.Drink.pay;
				System.out.println("成功售出"+meal);
			}
		}catch(IngredientSortOutException e){
			System.out.println("购买失败");
			e.printStackTrace();
		}
	} 
	
	//啤酒的use方法
	private void use(Beer drink) {
		boolean flag=true;
		for(int i=0;i<beerList.size();i++) {
			Beer beer=(Beer)drink;
			if(beer.Overtime(LocalDate.now(),LocalDate.parse("2020-12-01"), 30)){
				beerList.remove(beer);
				flag=false;
			}
		}
		for(Beer beer:beerList) {
			if(beer.name==drink.name) {
				beerList.remove(beer);
				flag=false;
			}
		}
		if(flag) {
			throw new IngredientSortOutException(drink.name+"已售罄");
		}
	}
	
	//果汁的use方法
	private void use(Juice drink) {
		boolean flag=true;
		for(int i=0;i<juiceList.size();i++) {
			Juice juice=(Juice)drink;
			if(juice.Overtime(LocalDate.now(),LocalDate.parse("2020-12-01"), 2)){
				juiceList.remove(juice);
				flag=false;
			}
		}
		for(Juice juice:juiceList) {
			if(juice.name==drink.name) {
				juiceList.remove(juice);
				flag=false;
			}
		}
		if(flag) {
			throw new IngredientSortOutException(drink.name+"已售罄");
		}
	}

	public void input(int amount,Drinks drink) {
		try {
			//进啤酒
			if(drink instanceof Beer) {
				Beer beer=(Beer)drink;
				if(balance-beer.pay*amount>=0) {
					for(int i=0;i<amount;i++) {
						beerList.add(beer);
					}
					balance=balance-beer.pay*amount;
				}else {
					throw new OverdraftBalanceException("进货失败，差"+(beer.pay*amount-balance)+"元，方能进货"+beer.name);
				}
			}
			//进果汁
			if(drink instanceof Juice) {
				Juice juice=(Juice)drink;
				if(balance-juice.pay*amount>=0) {
					for(int i=0;i<amount;i++) {
						juiceList.add(juice);
					}
					balance=balance-juice.pay*amount;
				}else {
					throw new OverdraftBalanceException("进货失败，差"+(juice.pay*amount-balance)+"元，方能进货"+juice.name);
				}
			}
		}catch(OverdraftBalanceException e) {
			e.printStackTrace();
		}
	}
}
