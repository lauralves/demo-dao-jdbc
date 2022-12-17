package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class ProgramSeller {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ===");
		
		Seller seller = sellerDao.findById(2);
		System.out.println(seller);
		
		System.out.println();
		
		System.out.println("=== TEST 2: seller findByDepartment ===");
		Department department =  new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println();
		System.out.println("=== TEST 3: seller findAll ===");
	
		list = sellerDao.findAll();
		
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println();
		System.out.println("=== TEST 4: seller insert ===");
		
		//Seller newSeller = new Seller(null, "Greg", "greg@gamil.com", new Date(), 4000.0, department);
		//sellerDao.insert(newSeller);
		
		//System.out.println("Inserted! New id = " + newSeller.getId());
		
		
		System.out.println();
		System.out.println("=== TEST 5: seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Wayne");
		sellerDao.update(seller);
		System.out.println("Update completed!");
		
		System.out.println();
		System.out.println("=== TEST 6: seller delete ===");
		System.out.print("Entender id for delete test: ");
		int id = scan.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed!");
		
		
		scan.close();
		
	}

}