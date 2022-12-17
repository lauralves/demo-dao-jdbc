package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;


public class ProgramDepartment {

	public static void main(String[] args) {

		DepartmentDao dep = DaoFactory.createDepartmentDao();
		List<Department> list = dep.findAll();
		System.out.println("=== TEST 1: department findAll ===");
		list = dep.findAll();

		for (Department obj : list) {
			System.out.println(obj);
		}

	}

}
