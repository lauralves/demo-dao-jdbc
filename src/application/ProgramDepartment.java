package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class ProgramDepartment {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		DepartmentDao dep = DaoFactory.createDepartmentDao();
		List<Department> list = dep.findAll();
		System.out.println("=== TEST 1: department findAll ===");
		list = dep.findAll();

		for (Department obj : list) {
			System.out.println(obj);
		}

		System.out.println();
		System.out.println("=== TEST 2: department findById ===");

		Department department = dep.findById(2);
		System.out.println(department);
		
		System.out.println();
		System.out.println("=== TEST 3: department insert ===");
		
		//Department newDep = new Department(null, "Test2");
		//dep.insert(newDep);
		//System.out.println("Inserted! New id = " + newDep.getId());
		
		System.out.println();
		System.out.println("=== TEST 5: department update ===");
		
		department = dep.findById(5);
		department.setName("Update test");
		dep.update(department);
		System.out.println("Update completed!");
		
		System.out.println();
		System.out.println("=== TEST 6: department delete ===");
		
		System.out.print("Entender id for delete test: ");
		int id = scan.nextInt();
		dep.deleteById(id);
		System.out.println("Delete completed!");
	}

}
