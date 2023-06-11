package EmployeeWorkload;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Employee {
	private String jobNum;//Ա������
	private String name;//Ա������
	private int workload[];//������
	private double salary;//��������Ӧ��нˮ
	
	//�������췽��
	public Employee(Product product,String jobNum,String name,int workload[]) throws FileNotFoundException {
		//��ȡ��Ʒ�б�
		this.jobNum = jobNum;
		this.name = name;
		int length = product.getLength();
		this.workload = new int[length];
		for(int i = 0;i < length;i++) {
			this.workload[i] = workload[i];
		}
		//����нˮ
		for(int i = 0;i < length;i++) {
			this.salary += product.getPrice(i) * workload[i];
		}
	}
	//��ȡ���췽��
	public Employee(Product product,String jobNum,String name,int workload[],double salary) throws FileNotFoundException {
		//��ȡ��Ʒ�б�
		this.jobNum = jobNum;
		this.name = name;
		int length = product.getLength();
		this.workload = new int[length];
		for(int i = 0;i < length;i++) {
			this.workload[i] = workload[i];
		}
		this.salary = salary;
	}
	//�������췽��
	public Employee(Product product,String jobNum,String name) throws FileNotFoundException {
		workload = new int[product.getLength()];
		this.jobNum = jobNum;
		this.name = name;
	}
	
	//������
	public String getJobNum() {
		return jobNum;
	}
	public String getName() {
		return name;
	}
	public int getWorkload(int index) {
		return workload[index];
	}
	public Double getSalary() {
		return salary;
	}
	
	//�޸���
	public void setJobNum(String jobNum) {
		this.jobNum = jobNum;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setWorkload(int index,int workload) {
		this.workload[index] = workload;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public void caculateSalary(Product product) {
		int length = product.getLength();
		//����нˮ
		double salary = 0;
		for(int i = 0;i < length;i++) {
			salary += product.getPrice(i) * workload[i];
		}
		this.salary = salary;
	}
	
	public void input(Scanner userInput,Product product) {
		product.showProduct();
		while(true) {
			int index,num;
			System.out.print("\t�������Ʒ���(����-1��������):");
			index = userInput.nextInt();
			if(index == -1) break;
			System.out.printf("\t�����빤����:");
			num = userInput.nextInt();
			workload[index] += num;
		}
		//����нˮ
		caculateSalary(product);
	}
	
	//��ʾ����Ա����Ϣ
	public void show(Product product) {
		int length = product.getLength();
		System.out.println("\t���ţ�" + jobNum);
		System.out.printf("\t>>> %s <<<\n",name);
		for(int i = 0;i < length;i++) {
			if(workload[i] > 0) System.out.printf("\t%s��%d\n",product.getName(i),workload[i]);
		}
		System.out.printf("\t��н��%.3f\n",salary);
	}
	
	public static void main(String []args) throws FileNotFoundException {
		Product product = new Product();
		product.read();
		Employee employee = new Employee(product,"100001","������");
		employee.show(product);
	}
}
