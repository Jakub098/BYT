package p1;

public class Driver {
	
	public static void main(String[] args) {
		
		ObjectPool pool = ObjectPool.getInstance();
		
		User user1 = new User();
		User user2 = new User();
		
		user1.takeObjectFromPool(pool);
		user1.takeObjectFromPool(pool);
		user1.takeObjectFromPool(pool);
		user1.takeObjectFromPool(pool);
		user1.takeObjectFromPool(pool);
		user1.takeObjectFromPool(pool);
		user1.takeObjectFromPool(pool);
		user1.takeObjectFromPool(pool);
		user1.takeObjectFromPool(pool);
		user1.takeObjectFromPool(pool);
		user1.takeObjectFromPool(pool);
		user1.takeObjectFromPool(pool);
		user1.takeObjectFromPool(pool);
		user1.takeObjectFromPool(pool);
		user2.returnObjectToPool(pool);
		user1.takeObjectFromPool(pool);
		user2.takeObjectFromPool(pool);
		
		
	
		
	
		System.out.println();
		System.out.println("number of objects user 1: " + user1.getListSize());
		System.out.println("number of objects user 2: " + user2.getListSize());
		System.out.println("number of objects pool: " + pool.getListSize());
		ObjectPool.printNumber();
		
		
	}

}
