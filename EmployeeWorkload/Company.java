package EmployeeWorkload;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Company {
	public Product product;//��Ʒ
	public ArrayList<Employee> employee = new ArrayList<Employee>();//Ա��
	int size = 0;//Ա����Ŀ
	public File file = new File("D:\\programming\\eclipse\\EmployeeWorkload\\data\\employee.txt");//����Ա����Ϣ���ļ�����
	
	//���췽��
	public Company() throws FileNotFoundException {
		product = new Product();
		product.read();
		read();
	}
	
	//����ԭ�ȵ�Ա����Ϣ
	public void save() throws IOException {
		PrintWriter writer = new PrintWriter(file);
		int length = employee.size();
		for(int i = 0;i < length;i++) {
			Employee tempEmp = employee.get(i);
			writer.write(tempEmp.getJobNum() + "\n");
			writer.write(tempEmp.getName() + "\n");
			for(int j = 0;j < product.getLength();j++) {
				writer.write(tempEmp.getWorkload(j) + "  ");
			}
			writer.write(tempEmp.getSalary().toString() + "\n");
		}
		writer.close();
	}
	
	//��ȡԱ���б�
	public void read() throws FileNotFoundException {
		Scanner fileInput = new Scanner(file);
		String jobNum;
		String name;
		int workload[] = new int[product.getLength()];
		double salary;
		while(fileInput.hasNextLine()) {
			jobNum = fileInput.nextLine();
			name = fileInput.nextLine();
			for(int i = 0;i < product.getLength();i++) {
				workload[i] = fileInput.nextInt();
			}
			salary = fileInput.nextDouble();
			fileInput.nextLine();
			employee.add(new Employee(product,jobNum,name,workload,salary));
			size++;
		}
		fileInput.close();
	}
	
	//�Ǽ�Ա����Ϣ
	public void record(Scanner userInput) throws FileNotFoundException {
		String jobNum;
		String name;
		System.out.println("\t>>> �������Ǽ� <<<");
		System.out.print("\t�����빤��(����#����)��");
		jobNum = userInput.nextLine();
		if(jobNum.charAt(0) == '#') return;
		System.out.print("\t����������:");
		name = userInput.nextLine();
		int index = ifExist(name);
		if(index != -1) {
			employee.get(index).input(userInput,product);
		}//����Ѿ��и�Ա������Ϣ��ֱ�ӵǼǹ�����
		else {
			employee.add(new Employee(product,jobNum,name));
			size++;
			employee.get(size - 1).input(userInput,product);
		}//���û�и�Ա������Ϣ����Ӹ�Ա������Ϣ���ٵǼǹ�����
		System.out.println("\t�Ǽǳɹ�!");
	}
	
	//�������ж�Ա���Ƿ����
	public int ifExist(String name) {
		for(int i = 0;i < size;i++) {
			if(employee.get(i).getName().compareTo(name) == 0)return i;
		}
		return -1;
	}
	
	//��Ա������н�������
	public void sort() {
		ArrayList<Employee> emp = new ArrayList<Employee>(employee);//��employee����һ����������
		//ѡ������
		int i,j,k;
		for(i = 0;i < size - 1;i++) {
			k = i;
			for(j = i + 1;j < size;j++) {
				if(emp.get(k).getSalary() < emp.get(j).getSalary()) k = j;
			}
			if(k != i) {
				Employee temp = emp.get(i);
				emp.set(i, emp.get(k));
				emp.set(k,temp);
			}
		}
		//������а�
		System.out.println("\t>>> ���������а� <<<");
		System.out.printf("\t%4s\t%s\t\t%s\n","����","����","����");
		for(i = 0;i < emp.size();i++) {
			System.out.printf("\t%4d\t%s\t\t%.3f\n",i + 1,emp.get(i).getName(),emp.get(i).getSalary());
		}
	}
	
	//ɾ��Ա����Ϣ��֧�ְ�����ɾ��
	public void delete(Scanner userInput) {
		int option;
		System.out.print("\t��ѡ��ɾ��ģʽ(������ɾ��(1)/������ɾ��(0):");
		option = userInput.nextInt();
		userInput.nextLine();
		if(option == 1) {
			System.out.print("\t������Ա������:");
			String jobNum = userInput.nextLine();
			for(int i = 0;i < size;i++) {
				if(employee.get(i).getJobNum().compareTo(jobNum) == 0) {
					employee.remove(i);
					size--;
				}
			}
		}
		else {
			String name = null;
			System.out.print("\t������Ա������:");
			name = userInput.nextLine();
			int index = ifExist(name);
			if(index != -1) {
				employee.remove(index);
				size--;
			}
			else System.out.println("\tԱ��������!");
		}
	}
	
	public void search(Scanner userInput) {
		int option;
		System.out.print("\t��ѡ���ѯģʽ(�����Ų�ѯ(1)/��������ѯ(0):");
		option = userInput.nextInt();
		userInput.nextLine();
		if(option == 1) {
			System.out.print("\t������Ա������(����#����):");
			String jobNum = userInput.nextLine();
			if(jobNum.charAt(0) == '#') return;
			for(int i = 0;i < size;i++) {
				if(employee.get(i).getJobNum().compareTo(jobNum) == 0) {
					employee.get(i).show(product);
				}
			}
		}
		else {
			String name = null;
			System.out.print("\t������Ա������(����#����):");
			name = userInput.nextLine();
			if(name.charAt(0) == '#') return;
			int index = ifExist(name);
			if(index != -1) {
				employee.get(index).show(product);
			}
			else System.out.println("\tԱ��������!");
		}
	}
	
	//�û��˵�
	public void menu() {
		System.out.println("");
		System.out.println("\t        >>>>> �û�ģʽ <<<<<");
		System.out.println("\t����������������������������������������������������������������������������");
		System.out.println("\t�˵���");
		System.out.println("\t* �˳� - - - - - - - - - - - - - 0");
		System.out.println("\t* ��Ʒ�б� - - - - - - - - - -  - 1");
		System.out.println("\t* �Ǽǹ����� - - - - - - - - -  - 2");
		System.out.println("\t* ���а�- - - - - - - - - - -  - 3");
		System.out.println("\t* ע�� - - - - - - - - - - - - - 4");
		System.out.println("\t����������������������������������������������������������������������������");
		System.out.print("\t>>");
	}
	
	//����Ա�˵�
	public void adminstration() {
		System.out.println("");
		System.out.println("\t       >>>>> ����Աģʽ <<<<<");
		System.out.println("\t����������������������������������������������������������������������������");
		System.out.println("\t�˵���");
		System.out.println("\t* �����û�ģʽ - - - - - - - - - - - -0");
		System.out.println("\t* ��Ӳ�Ʒ - - - - - - - - - - - - - 1");
		System.out.println("\t* �鿴ȫ��Ա����Ϣ - - - - - - - - - -2");
		System.out.println("\t* ��ѯԱ���������� - - - - - - - - -  3");
		System.out.println("\t* ����Ա������ - - - - - - - - - - - 4");
		System.out.println("\t* ɾ��Ա������ - - - - - - - - - - - 5");
		System.out.print("\t>>");
	}
	
	public static void main(String[] args) throws InputMismatchException, IOException{
		Company company = new Company();//����company�����Զ���ȡ��Ʒ�б��Ա����Ϣ
		System.out.println("\t��������������������������������������������������������������������������");
		System.out.println("\t*  �������Զ����ļ��ж�ȡ��Ʒ�б�!      *");
		System.out.println("\t*  �������Զ����ļ��л�ȡ����Ա����Ϣ��  *");
		System.out.println("\t*  ��������ɳ�ʼ��!                  *");
		System.out.println("\t*     >>>>>  XX���޹�˾ <<<<<<       *");
		System.out.println("\t��������������������������������������������������������������������������");
		Scanner userInput = new Scanner(System.in);
		int option;
		while(true) {
			//ѡ������
			company.menu();
			try {
				option = userInput.nextInt();
				userInput.nextLine();
			}
			catch(InputMismatchException ex) {
				System.out.println("\t>>>>>>> ����������������룡 <<<<<<<");
				System.out.print("\t>>");
				userInput.nextLine();//��ջ�����
				option = userInput.nextInt();
			}
			System.out.println("");
			
			//����Աģʽ������1024�������Աģʽ
			if(option == 1024) {
				while(option != 0) {
				company.adminstration();
				try {
					option = userInput.nextInt();
					userInput.nextLine();
				}
				catch(InputMismatchException ex) {
					System.out.println("\t>>>>>>> ����������������룡 <<<<<<<");
					System.out.print("\t>>");
					userInput.nextLine();//��ջ�����
					option = userInput.nextInt();
				}
				System.out.println("");
					switch(option) {
					case 0: System.out.println("\t�ѷ����û�ģʽ��"); break;
					case 1: {
							company.product.productInput(company.product); 
							System.out.println("\t��ӳɹ�!");
							break;
					}
					case 2:{
						int length = company.employee.size();
						for(int i = 0;i < length;i++) {
						System.out.println("\t����������������������������������������"
								+ "����������������������������������������");
							company.employee.get(i).show(company.product);
						}
						System.out.println("\t����������������������������������������"
							+ "����������������������������������������");
						userInput.nextLine();
						break;
					}
					case 3: {
						company.search(userInput);
						break;
					}
					case 4: {
						company.save(); 
						System.out.println("\t���³ɹ�!");
						break;
					}
					case 5: {
						company.delete(userInput); 
						System.out.println("\tɾ���ɹ�!");
						break;
					}
					}
				}
			}
			
			//�û�ģʽ
			else {
				switch(option) {
				case 0: {
					company.save();//��������
					System.out.println("\t�������Զ�������Ա�����ݸ������ļ���!");
					userInput.close();
					System.out.println("\t��л����ʹ��!"); return;
				}
				case 1: {
					int flag = 0;
					System.out.printf("\t�Ƿ񰴹�������Ĳ�Ʒ�б�(1/0):");
					flag = userInput.nextInt();
					if(flag == 1) {
						company.product.sort();
					}
					else {
						company.product.showProduct();
					}
					userInput.nextLine();
					userInput.nextLine();
					break;
				}
				case 2: {
					company.record(userInput); break;
				}
				case 3: company.sort(); break;
				case 4: {
					String jobNum;
					String name;
					System.out.print("\t�����빤��:");
					jobNum = userInput.nextLine();
					System.out.print("\t����������:");
					name = userInput.nextLine();
					company.employee.add(new Employee(company.product,jobNum,name));
					System.out.println("\tע��ɹ�!");
					break;
				}
				default: System.out.println("\t>>>>>>> ����������������룡 <<<<<<<"); break;
				}
			}
		}
	}
}
