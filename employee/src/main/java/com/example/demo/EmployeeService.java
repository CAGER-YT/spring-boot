
package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


//

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao ed;
	public String saveEmp(Employee e) {
		return ed.saveEmp(e);
	}
	public String saveAll(List<Employee> e) {
		return ed.saveAll(e);
	}
	public Optional<Employee> getEmp(int num) {
		return ed.getEmp(num);
	}
	public List<Employee> getAllEmp() {
		return ed.getAllEmp();
	}
	public String delemp(int num) {
		return ed.delemp(num);
	}
	public String delallemp() {
		return ed.delallemp();
	}
	public String change(int id,Employee e) {
		return ed.change(id,e);
	}
	public Employee getByName(String p) {
	    return ed.getByName(p);
	}
	public List<Employee> getAges(int age){
		return ed.getAges(age);
	}
	public List<Employee> getMax() {
		Integer z=ed.getMax().stream().map(x->x.getSalary()).distinct().sorted(Collections.reverseOrder()).skip(1).max(Comparable::compareTo).get();
		return ed.getMax().stream().filter(x->x.getSalary()==z).toList();
	}
	public List<Employee> getlowestsalry() {
		 List<Employee> x = ed.getAllEmp().stream()
                 .sorted(Comparator.comparingInt(Employee::getSalary)).limit(3)
                 .collect(Collectors.toList());
		return x;
	}
	public String patchData(int id,Employee e) {
		return ed.patchData(id, e);
		
	}
//	public List<Employee> getEmpTaxPayable() {
//	    List<Employee> e = ed.getEmpTaxPayable();
//	    
//	    List<Employee> y=new ArrayList<>();
//	    
//		 for(Employee x:e) {
//			 int yearlysalary=x.getSalary()*12;
//		 if(yearlysalary>=500000) {
//			 int ctc=yearlysalary-(yearlysalary/100)*10;
//			 x.setSalary(ctc);
//			 y.add(x);
//			 return y;
//		 }else if(yearlysalary>=1000000){
//			 int ctc=yearlysalary-(yearlysalary/100)*25;
//			 x.setSalary(ctc);
//			 y.add(x);
//			 return y;
//		 }else if(yearlysalary>=1500000) {
//			 int ctc=yearlysalary-(yearlysalary/100)*30;
//			 x.setSalary(ctc);
//			 y.add(x);
//			 return y;
//		 }
//		 }
//		 return e;
//	}
	public List<Employee> getEmpTaxPayable() {
	    List<Employee> e = ed.getEmpTaxPayable();
	    List<Employee> y = new ArrayList<>();

	    for (Employee x : e) {
	        int yearlySalary = x.getSalary() * 12;
	        int ctc = 0;

	        if (yearlySalary >= 1500000) {
	            ctc = yearlySalary - (yearlySalary / 100) * 30;
	        } else if (yearlySalary >= 1000000) {
	            ctc = yearlySalary - (yearlySalary / 100) * 25;
	        } else if (yearlySalary >= 500000) {
	            ctc = yearlySalary - (yearlySalary / 100) * 10;
	        } else {
	            ctc = yearlySalary - (yearlySalary / 100) * 5;
	        }
	        x.setSalary(ctc);
	        y.add(x);
	    }
	    return y;
	}

	public List<Employee> getString() {
		List<Employee> e =ed.getAllEmp();
		for(Employee x:e) {
			String name = x.getName();
			if(name.length()%2==0) {
				int len=name.length()/2;
				String mi=x.getName().substring(len-1,len+2);
//				x.setName(mi);
			}else {
				int len=name.length()/2;
				String mi=x.getName().substring(len,len+1);
				x.setName(mi);
			}
		}
		return e;
//		return e.stream()
//                .map(x -> {
//                    String name = x.getName();
//                    if (name.length() % 2 == 0) {
//                        int mi = name.length() / 2;
//                        char mc = name.charAt(mi - 1);
//                        char nc = name.charAt(mi);
//                        x.setName(String.valueOf(mc) + nc);
//                    } else {
//                        int mi = name.length() / 2;
//                        char mc = name.charAt(mi);
//                        x.setName(String.valueOf(mc));
//                    }
//                    return x;
//                })
//                .collect(Collectors.toList());
	}
}
