package ��������;

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
		Drinks juice=new Juice("��֭",5);
		juiceList.add((Juice) juice);
		meal=new SetMeal("�ײ�1","ԭζ��",25,juice);
		mealList.add(meal);
		Drinks beer=new Beer("ѩ��",10,5);
		beerList.add((Beer)beer);
		
	}
	
	public West2FriedChickenRestauran() {
		this.balance=balance;
	}
	
	public void sale() {
		try {
			//��ơ��
			if(meal.Drink instanceof Beer) {
				Beer beer=(Beer)drink;
				use(beer);
				balance=balance+meal.Drink.pay;
				System.out.println("�ɹ��۳�"+meal);
			}else if(meal.Drink instanceof Juice) {
				//����֭
				Juice juice=(Juice)drink;
				use(juice);
				balance=balance+meal.Drink.pay;
				System.out.println("�ɹ��۳�"+meal);
			}
		}catch(IngredientSortOutException e){
			System.out.println("����ʧ��");
			e.printStackTrace();
		}
	} 
	
	//ơ�Ƶ�use����
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
			throw new IngredientSortOutException(drink.name+"������");
		}
	}
	
	//��֭��use����
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
			throw new IngredientSortOutException(drink.name+"������");
		}
	}

	public void input(int amount,Drinks drink) {
		try {
			//��ơ��
			if(drink instanceof Beer) {
				Beer beer=(Beer)drink;
				if(balance-beer.pay*amount>=0) {
					for(int i=0;i<amount;i++) {
						beerList.add(beer);
					}
					balance=balance-beer.pay*amount;
				}else {
					throw new OverdraftBalanceException("����ʧ�ܣ���"+(beer.pay*amount-balance)+"Ԫ�����ܽ���"+beer.name);
				}
			}
			//����֭
			if(drink instanceof Juice) {
				Juice juice=(Juice)drink;
				if(balance-juice.pay*amount>=0) {
					for(int i=0;i<amount;i++) {
						juiceList.add(juice);
					}
					balance=balance-juice.pay*amount;
				}else {
					throw new OverdraftBalanceException("����ʧ�ܣ���"+(juice.pay*amount-balance)+"Ԫ�����ܽ���"+juice.name);
				}
			}
		}catch(OverdraftBalanceException e) {
			e.printStackTrace();
		}
	}
}
