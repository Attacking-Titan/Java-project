package AddressBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;//׷�����ݵ��ļ���
import java.io.IOException;//�ļ���������쳣
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;//���벻ƥ���쳣����
import java.util.Scanner;

public class AddressBook{
	
	Scanner input = new Scanner(System.in);//����
	static Scanner userInput = new Scanner(System.in);//����
	public AddressBook() {
	}//���캯��
	
	/************* �˵� *************/
	public void menu() {
		/*
		System.out.println("\t______________________________________________________________");
		System.out.println("\t*                                                            *");
		System.out.println("\t*                ___________________________                 *");
		System.out.println("\t*                |                         |                 *");
		System.out.println("\t*                |         ͨ��¼           |                 *");
		System.out.println("\t*                |_________________________|                 *");
		System.out.println("\t*                �˵���                                       *");
		System.out.println("\t*                ����������������������������������������������������������               *");
		System.out.println("\t*                *                           *               *");
		System.out.println("\t*                *  �˳���- - - - - - - -  0  *               *");
		System.out.println("\t*                *                           *               *");
		System.out.println("\t*                *  ���룺- - - - - - - -  1  *               *");
		System.out.println("\t*                *                           *               *");
		System.out.println("\t*                *  ��ʾ��- - - - - - - -  2  *               *");
		System.out.println("\t*                *                           *               *");
		System.out.println("\t*                *  �޸ģ�- - - - - - - -  3  *               *");
		System.out.println("\t*                *                           *               *");
		System.out.println("\t*                *  ɾ����- - - - - - - -  4  *               *");
		System.out.println("\t*                *                           *               *");
		System.out.println("\t*                *  ��ѯ��- - - - - - - -  5  *               *");
		System.out.println("\t*                ����������������������������������������������������������               *");
		System.out.println("\t*                                                            *");
		System.out.println("\t*____________________________________________________________*");
		System.out.print("\t>>");
		*/
		
		System.out.println("\t                  ___________________________");
		System.out.println("\t                  |                         |");
		System.out.println("\t                  |         ͨ��¼           |");
		System.out.println("\t                  |_________________________|");
		System.out.println("\t                  �˵���");
		System.out.println("\t            ����������������������������������������������������������������������������������");
		System.out.println("\t            |     *  �˳���- - - - - - - -  0        |\n");
		System.out.println("\t            |     *  ���룺- - - - - - - -  1        |\n");
		System.out.println("\t            |     *  ��ʾ��- - - - - - - -  2        |\n");
		System.out.println("\t            |     *  �޸ģ�- - - - - - - -  3        |\n");
		System.out.println("\t            |     *  ɾ����- - - - - - - -  4        |\n");
		System.out.println("\t            |     *  ��ѯ��- - - - - - - -  5        |\n");
		System.out.println("\t            ��������������������������������������������������������������������������������");
		System.out.print("\t>>");
		
		/*
		System.out.println("\t\n");
		System.out.println("\t                �˵���");
		System.out.println("\t                * �˳���- - - - - - - -  0\n");
		System.out.println("\t                * ���룺- - - - - - - -  1\n");
		System.out.println("\t                * ��ʾ��- - - - - - - -  2\n");
		System.out.println("\t                * �޸ģ�- - - - - - - -  3\n");
		System.out.println("\t                * ɾ����- - - - - - - -  4\n");
		System.out.println("\t                * ��ѯ��- - - - - - - -  5\n");
		System.out.print("\t>>");
		*/
	}
	
	/************* �������� *************/
	public Person completeInput() {
		String name;//����
		String address;//��ַ
		String postalCode;//��������
		String phoneNumber;//�绰����
		String comment;//��ע
		System.out.print("\t������");
		name = input.nextLine();
		System.out.print("\t��ַ��");
		address = input.nextLine();
		System.out.print("\t�������룺");
		postalCode = input.nextLine();
		System.out.print("\t�绰���룺");
		phoneNumber = input.nextLine();
		System.out.print("\t��ע��");
		comment = input.nextLine();
		return new Person(name,address,postalCode,phoneNumber,comment);
	}
	/************* ������� *************/
	public Person quickInput() {
		String name;//����
		String phoneNumber;//�绰����
		String comment;//��ע
		System.out.print("\t������");
		name = input.nextLine();
		System.out.print("\t�绰���룺");
		phoneNumber = input.nextLine();
		System.out.print("\t��ע��");
		comment = input.nextLine();
		return new Person(name,phoneNumber,comment);
	}
	
	/************* �������� ***************/
	public void save(FileWriter output,Person person) throws IOException{
		/* 
		 * ����˳��name->address->postalCode->phoneNumber->creationDate->comment
		 */
		output.write(person.getName() + "\n");
		output.write(person.getAddress() + "\n");
		output.write(person.getPostalCode() + "\n");
		output.write(person.getPhoneNumber() + "\n");
		output.write(person.getcreationDate() + "\n");
		output.write(person.getComment() + "\n");
		output.flush();
	}//׷��
	
	public void cover(PrintWriter output,Person person) throws IOException {
		/* 
		 * ����˳��name->address->postalCode->phoneNumber->creationDate->comment
		 */
		output.write(person.getName() + "\n");
		output.write(person.getAddress() + "\n");
		output.write(person.getPostalCode() + "\n");
		output.write(person.getPhoneNumber() + "\n");
		output.write(person.getcreationDate() + "\n");
		output.write(person.getComment() + "\n");
		output.flush();
	}//����
	
	/************* �û����� **************/
	@SuppressWarnings("resource")
	public void input() throws IOException,InputMismatchException{
		Person[] person = new Person[50];//person����
		FileWriter output = new FileWriter("D:\\programming\\eclipse\\ͨ��¼\\data\\addressBook.txt",true);
		int size = 0;
		System.out.println("\t�������:���� - �绰���� - ��ע  >>1");
		System.out.println("\t��������:���� - ��ַ - ������� - �绰���� - ��ע  >>2");
		System.out.println("\t���� >>3");
		int flag = 0;
		try {
			System.out.print("\t>>");
			flag = userInput.nextInt();
		}
		catch(InputMismatchException ex) {
			System.out.println("\t>>>>>>> ����������������룡 <<<<<<<");
			System.out.print("\t>>");
			userInput.nextLine();//��ջ�����
			flag = userInput.nextInt();
		}
		if(flag == 1) {//�������
			while(flag != 0){
				System.out.println("\t����������������������������������������������������������������������������"
								  	+ "����������������������������������������������������������������������������");
				person[size++] = quickInput();//����һ������
				try {
					System.out.print("\t�Ƿ�������룿(����1/����0) >>");
					flag = userInput.nextInt();
				}
				catch(InputMismatchException ex) {
					System.out.println("\t>>>>>>> ����������������룡 <<<<<<<");
					System.out.print("\t�Ƿ�������룿(����1/����0) >>");
					userInput.nextLine();//��ջ�����
					flag = userInput.nextInt();
				}
			}
			System.out.println("\t>>> ������� <<<");
			System.out.println("\t>>>>>>> �������  <<<<<<<");
			//����������Ϣ
			for(int i = 0;i < size;i++) {
				System.out.println("\t����������������������������������������������������������������������������"
						   			+ "����������������������������������������������������������������������������");
				person[i].showPerson();
			}
			//д�뵽�ļ���
			for(int i = 0;i < size;i++) {
				save(output,person[i]);
			}
			return;
		}
		else if(flag == 2) {//��������
			while(flag != 0){
				System.out.println("\t����������������������������������������������������������������������������"
								   + "����������������������������������������������������������������������������");
				person[size++] = completeInput();//����һ������
				try {
					System.out.print("\t�Ƿ�������룿(����1/����0) >>");
					flag = userInput.nextInt();
				}
				catch(InputMismatchException ex) {
					System.out.println("\t>>>>>>> ����������������룡 <<<<<<<");
					System.out.print("\t�Ƿ�������룿(����1/����0) >>");
					userInput.nextLine();//��ջ�����
					flag = userInput.nextInt();
				}
			}
			System.out.println("\t>>> ������� <<<");
			System.out.println("\t>>>>>>> �������  <<<<<<<");
			//����������Ϣ
			for(int i = 0;i < size;i++) {
				System.out.println("\t����������������������������������������������������������������������������"
						   			+ "����������������������������������������������������������������������������");
				person[i].showPerson();
			}
			//д�뵽�ļ���
			for(int i = 0;i < size;i++) {
				save(output,person[i]);
			}
			output.close();//�ر��ļ����
		}
		else if(flag == 3) {
			return;//����
		}
		else {//�������
			System.out.println("\t����������Զ��������˵���");
		}
		output.close();//�ر��ļ����
	}
	
	public void show(File file) throws FileNotFoundException {
		//�ж�file�Ƿ����
		try {
			Scanner temp = new Scanner(file);
			temp.close();
		}
		catch (FileNotFoundException ex) {
			//����ļ������ڣ����û��ֶ������ļ����Ե�ַ
			System.out.println("�ļ������ڣ��������µ��ļ���ַ(���Ե�ַ):");
			file = new File(userInput.nextLine());
		}
		Scanner fileInput = new Scanner(file);//�˴������׳��ļ��������쳣��δ����
		String name;//����
		String address;//��ַ
		String postalCode;//��������
		String phoneNumber;//�绰����
		String creationDate;//��������
		String comment;//��ע
		while(fileInput.hasNextLine()) {
			name = fileInput.nextLine();
			address = fileInput.nextLine();
			postalCode = fileInput.nextLine();
			phoneNumber = fileInput.nextLine();
			creationDate = fileInput.nextLine();
			comment = fileInput.nextLine();
			System.out.println("\t������������������������������������������������������������������������������������������������");
			System.out.printf("\t������%s(%s)\n", name,comment);
			if(address.compareTo("null") != 0) System.out.println("\t��ַ��" + address);
			if(postalCode.compareTo("null") != 0)System.out.println("\t�������룺" + postalCode);
			System.out.println("\t�绰���룺" + phoneNumber);
			System.out.println("\t�������ڣ�" + creationDate);
		}
		System.out.println("\t������������������������������������������������������������������������������������������������");
		fileInput.close();
		userInput.nextLine();//�ȴ��û��س�
		userInput.nextLine();//�ȴ��û��س�
	}
	
	public void change(File file) throws IOException {
		ArrayList<Person> personArray = new ArrayList<Person>();
		Scanner fileInput = new Scanner(file);
		while(fileInput.hasNextLine()) {
			personArray.add(new Person(fileInput.nextLine(),fileInput.nextLine(),fileInput.nextLine(),
						fileInput.nextLine(),fileInput.nextLine(),fileInput.nextLine()));
		}
		fileInput.close();//�ر��ļ�����
		for(int i = 0;i < personArray.size();i++) {
			System.out.println("\t������������������������������������������������������������������������������������������������");
			System.out.printf("\t< %d >\n",i);
			personArray.get(i).showPerson();
		}
		System.out.println("\t������������������������������������������������������������������������������������������������");
		int flag = 1;
		int number = -1;
		while(flag != 0){
			try {
				System.out.print("\t������Ҫ�޸ĵ���������(���븺���������˵�):");
				number = userInput.nextInt();
			}
			catch(InputMismatchException ex) {
				System.out.println("\t>>>>>>> ����������������룡 <<<<<<<");
				System.out.print("\t������Ҫ�޸ĵ���������(���븺���������˵�):");
				userInput.nextLine();//��ջ�����
				number = userInput.nextInt();
			}
			if(number < 0) {
				System.out.println("\t�������˵��ɹ�,��֮ǰ�����޸Ĳ����ѱ�ȡ����");
				return; 
			}
			Person t = personArray.get(number);//t������ȡperson���������
			userInput.nextLine();
			System.out.println("\t************************************************");
			System.out.print("\t������" + t.getName() + "->" );
			t.setName(userInput.nextLine());
			System.out.print("\t��ַ��" + t.getAddress() + "->");
			t.setAddress(userInput.nextLine());
			System.out.print("\t�������룺" + t.getPostalCode() + "->");
			t.setPostalCode(userInput.nextLine());
			System.out.print("\t�绰���룺" + t.getPhoneNumber() + "->");
			t.setPhoneNumber(userInput.nextLine());
			System.out.print("\t�������ڣ�" + t.getcreationDate() + "->");
			t.setCreationDate(userInput.nextLine());
			System.out.print("\t��ע��" + t.getComment() + "->");
			t.setComment(userInput.nextLine());
			System.out.println("\t************************************************");
			try {
				System.out.print("\t�Ƿ�������룿(����1/����0) >>");
				flag = userInput.nextInt();
			}
			catch(InputMismatchException ex) {
				System.out.println("\t>>>>>>> ����������������룡 <<<<<<<");
				System.out.print("\t�Ƿ�������룿(����1/����0) >>");
				userInput.nextLine();//��ջ�����
				flag = userInput.nextInt();
			}
		}
		System.out.println("\t>>>>>>>  �޸ĳɹ�!  <<<<<<<");
		//���޸ĺ������д�뵽�ļ��У�PrintWriterʵ�ָ���
		PrintWriter writer = new PrintWriter(file);//����ԭ������
		for (Person person : personArray)  {//��ǿ�͵�for
			cover(writer, person);
		}
		writer.close();//�ر��ļ�д��
	}
	
	public void delete(File file) throws IOException {
		ArrayList<Person> personArray = new ArrayList<Person>();
		Scanner fileInput = new Scanner(file);
		while(fileInput.hasNextLine()) {
			personArray.add(new Person(fileInput.nextLine(),fileInput.nextLine(),fileInput.nextLine(),
						fileInput.nextLine(),fileInput.nextLine(),fileInput.nextLine()));
		}
		fileInput.close();//�ر��ļ�����
		int flag = 1;
		while(flag != 0){
			for(int i = 0;i < personArray.size();i++) {
				System.out.println("\t������������������������������������������������������������������������������������������������");
				System.out.printf("\t< %d >\n",i);
				personArray.get(i).showPerson();
			}
			System.out.println("\t������������������������������������������������������������������������������������������������");
			int number = -1;
			try {
				System.out.print("\t������Ҫɾ������������(���븺���������˵�):");
				number = userInput.nextInt();
			}
			catch(InputMismatchException ex) {
				System.out.println("\t>>>>>>> ����������������룡 <<<<<<<");
				System.out.print("\t������Ҫɾ������������(���븺���������˵�):");
				userInput.nextLine();//��ջ�����
				number = userInput.nextInt();
			}
			if(number < 0) {
				System.out.println("\t�������˵��ɹ�,��֮ǰ����ɾ�������ѱ�ȡ����");
				return; 
			}
			personArray.remove(number);//ɾ�����Ϊnumber��������
			try {
				System.out.print("\t�Ƿ�������룿(����1/����0) >>");
				flag = userInput.nextInt();
			}
			catch(InputMismatchException ex) {
				System.out.println("\t>>>>>>> ����������������룡 <<<<<<<");
				System.out.print("\t�Ƿ�������룿(����1/����0) >>");
				userInput.nextLine();//��ջ�����
				flag = userInput.nextInt();
			}
		}
		System.out.println("\t>>>>>>>  ɾ���ɹ�!  <<<<<<<");
		//���޸ĺ������д�뵽�ļ��У�PrintWriterʵ�ָ���
		PrintWriter writer = new PrintWriter(file);//����ԭ������
		for (Person person : personArray)  {//��ǿ�͵�for
			cover(writer, person);
		}
		writer.close();//�ر��ļ�д��
	}
	
	public boolean isContain(Person data,String keywords) {
		if(data.getName().contains(keywords)) return true;
		if(data.getAddress().contains(keywords)) return true;
		if(data.getPostalCode().contains(keywords)) return true;
		if(data.getPhoneNumber().contains(keywords)) return true;
		if(data.getcreationDate().contains(keywords)) return true;
		if(data.getComment().contains(keywords)) return true;
		return false;
	}
	public void search(File file) throws IOException {
		ArrayList<Person> personArray = new ArrayList<Person>();
		Scanner fileInput = new Scanner(file);
		while(fileInput.hasNextLine()) {
			personArray.add(new Person(fileInput.nextLine(),fileInput.nextLine(),fileInput.nextLine(),
						fileInput.nextLine(),fileInput.nextLine(),fileInput.nextLine()));
		}
		fileInput.close();
		userInput.nextLine();
		System.out.println("\t������ؼ���(����end�������˵�):");
		System.out.print("\t>>>");
		String keywords = userInput.nextLine();
		if(keywords.contains("end")) {
			System.out.println("\t�������˵��ɹ�!");
			return;
		}
		boolean flag =  false;//�ж������Ƿ��н��
		for (Person person : personArray) {//��ǿ�͵�for
            if (isContain(person, keywords)) {
                System.out.println("\t������������������������������������������������������������������������������������������������");
                person.showPerson();
                System.out.println("\t������������������������������������������������������������������������������������������������");
                flag = true;
            }
        }
		if(flag) {
			System.out.println("\t>>>>>>>  ��ѯ�ɹ�!  <<<<<<<");
		}
		else System.out.println("\t>>>>>>>  �����޽��!  <<<<<<<");
	}
	
	public static void main(String []args) throws InputMismatchException, IOException {
		AddressBook addressBook = new AddressBook();//addressBook����
		File file = new File("D:\\programming\\eclipse\\ͨ��¼\\data\\addressBook.txt");//�ļ�
		int option = 0;
		do{
			addressBook.menu();
			option = userInput.nextInt();
			System.out.println();
			switch(option) {
				case 0: System.out.println("\t>>>>>>> ��л����ʹ�ã� <<<<<<<"); break; 
				case 1: {
					addressBook.input();
					break;
				}
				case 2:{
					addressBook.show(file);
					break;
				}
				case 3:{
					addressBook.change(file);
					break;
				}
				case 4:{
					addressBook.delete(file);
					break;
				}
				case 5:{
					addressBook.search(file);
					break;
				}
				default: System.out.println("\t�������");
			}
			//��ǿ�͵�switch
			/*
			switch (option) {
            case 0 -> System.out.println("\t>>>>>>> ��л����ʹ�ã� <<<<<<<");
            case 1 -> {
                addressBook.input();
            }
            case 2 -> {
                addressBook.show(file);
            }
            case 3 -> {
                addressBook.change(file);
            }
            case 4 -> {
                addressBook.delete(file);
            }
            case 5 -> {
                addressBook.search(file);
            }
            default -> System.out.println("\t�������");
        	}
        	*/
		}while(option != 0);
		userInput.close();
	}
}
