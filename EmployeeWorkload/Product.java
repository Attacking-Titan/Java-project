package EmployeeWorkload;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Product {
	//ArrayList�����ڴ˴�ʵ�����������ڹ��췽���е�name��priceΪ��ֵ
	private int length;//��Ʒ�������Ŀ
	private ArrayList<String> name = new ArrayList<String>();
	private ArrayList<Double> price = new ArrayList<Double>();
	public File file = new File("D:\\programming\\eclipse\\EmployeeWorkload\\data\\product.txt");//Ĭ�϶�ȡ�ͱ���·��
	
	public void product(String[] name,double price[]) {
		if(name.length == price.length) {
			this.length = name.length;
			for(int i = 0;i < this.length;i++) {
				this.name.add(name[i]);
				this.price.add(price[i]);
			}
		}
		else {
			System.out.println("�޷��ó��Ȳ�ͬ�Ĳ�Ʒ��������Ͳ�Ʒ�۸����鹹�����");
			System.out.println("��ȷ��ÿһ����Ʒ���ж�Ӧ�ļ۸�");
		}
	}
	//������
	public ArrayList<String> getName(){
		return name;
	}//��ȡ��Ʒ���Ƶ�ArrayList����
	public ArrayList<Double> getPrice(){
		return price;
	}//��ȡ��Ʒ�۸��ArrayList����
	public String getName(int index) {
		return name.get(index);
	}//��ȡĳ��Ʒ����
	public double getPrice(int index) {
		return price.get(index);
	}
	public int getLength() {
		return length;
	}//��ȡ��Ʒ����
	
	//�޸���
	public void setName(String name,int index){
		this.name.set(index, name);
	}//index��0��ʼ
	public void setPrice(double price,int index) {
		this.price.set(index, price);
	}//index��0��ʼ
	
	//չʾ���в�Ʒ����
	public void showProduct() {
		System.out.println("\t����������������������������������������������������"
	    		+ "������������������������������������������������������");
		System.out.printf("\t\t���\t%-20s%s\n",">>>��Ʒ<<<",">>>�۸�<<<");
		for(int i = 0;i < name.size();i++) {
			System.out.printf("\t\t<%d>\t%-20s%s\n",i,name.get(i),price.get(i));
		}
		System.out.println("\t����������������������������������������������������"
	    		+ "������������������������������������������������������\n");
	}
	
	//��Ӳ�Ʒ
	public void add(String name,double price) {
		this.name.add(name);
		this.price.add(price);
		this.length++;
	}
	
	//����,��������
	@SuppressWarnings("unchecked")
	public void sort() {
		//�˴�name��price�������������е�name��price
		ArrayList<String> name = (ArrayList<String>) this.name.clone();
		ArrayList<Double> price = (ArrayList<Double>) this.price.clone();
		int length = name.size();
		int i,j;
		for(i = 0;i < length;i++) {
			String tempName = name.get(i);
			double tempPrice = price.get(i);
			for(j = i - 1;j >= 0;j--) {
				if(tempPrice > price.get(j) ) {
					name.set(j + 1, name.get(j));
					price.set(j + 1, price.get(j));
				}
				else break;
			}
			name.set(j + 1,tempName);
			price.set(j + 1, tempPrice);
		}
		System.out.println("\t����������������������������������������������������"
	    		+ "������������������������������������������������������");
		System.out.printf("\t\t���\t%-20s%s",">>>��Ʒ<<<",">>>�۸�<<<\n");
		for(i = 0;i < length;i++) {
			System.out.printf("\t\t<%d>\t%-20s%s\n",i,name.get(i),price.get(i));
		}
		System.out.println("\t����������������������������������������������������"
	    		+ "������������������������������������������������������\n");
	}
	
	//�����Ʒ����
	public void productInput(Product product) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("\t�������Ʒ���ƺͼ۸�(����#��������)");
		System.out.printf("\t  %-20s%s","��Ʒ","�۸�\n");
		while(true){
			System.out.print("\t>>");
			String name = userInput.next();
			if(name.charAt(0) == '#') break;
			double price = userInput.nextDouble();
			product.add(name,price);
		}
		userInput.close();
	}
	
	//����
	@SuppressWarnings("resource")
	public void save(File file) throws IOException {
		FileWriter writer = new FileWriter(file,true);//׷������2
		int length = name.size();
		if(length != price.size()) {
			System.out.println("��Ʒ�����ͼ۸���������ȣ�����ʧ��!");
			return;
		}
		for(int i = 0;i < length;i++) {
			writer.write(name.get(i) +  "\n");
			writer.write(price.get(i).toString() + "\n");
			writer.flush();
		}
		writer.close();
	}
	
	public void read() throws FileNotFoundException {
		try {
			Scanner readProduct = new Scanner(this.file);
			while(readProduct.hasNextLine()) {
				this.add(readProduct.nextLine(),Double.valueOf(readProduct.nextLine()));
			}
			readProduct.close();
		}
		catch(FileNotFoundException ex) {
			System.out.println("�ļ�δ�ҵ��򲻴��ڣ���ȡʧ��!");
			return;
		}
		
	}
	
	
	public static void main(String []args) throws IOException {
		//����
		Product product = new Product();
		product.productInput(product);
		product.showProduct();
		product.sort();
		product.save(product.file); 
		product.read();
		product.showProduct();
		product.sort();
	}
	
}
