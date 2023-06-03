package AddressBook;

import java.util.Date;

public class Person {
	/* ������,˽�з�װ��ֻ����Person���з��� */
	private String name;//����
	private String address;//��ַ
	private String postalCode;//��������
	private String phoneNumber;//�绰����
	private String creationDate;//��������
	private String comment;//��ע
	
	/************* ���췽�� *************/
	/* �������� */
	public Person(String name,String address,String postalCode,String phoneNumber,String comment) {
		this.name = name;
		this.address = address;
		this.postalCode = postalCode;
		this.phoneNumber = phoneNumber;
		this.comment = comment;
		Date date = new Date();
		//SimpleDateFormat time= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.creationDate = date.toString();//��������
	}
	/* ��ݴ��� */
	public Person(String name,String phoneNumber,String comment) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.comment = comment;
		this.address = "null";
		this.postalCode = "null";
		Date date = new Date();
		//SimpleDateFormat time= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.creationDate = date.toString();//��������
	}
	/* ��ȡ���� */
	public Person(String name,String address,String postalCode,String phoneNumber,String creationDate,String comment) {
		this.name = name;
		this.address = address;
		this.postalCode = postalCode;
		this.phoneNumber = phoneNumber;
		this.creationDate = creationDate;
		this.comment = comment;
	}
	/************* ���췽�� *************/

	
	/************* ������ *************/
	public String getName() {
		return this.name;
	}
	public String getAddress() {
		return this.address;
	}
	public String getPostalCode() {
		return this.postalCode;
	}
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	public String getcreationDate() {
		return this.creationDate;
	}
	public String getComment() {
		return this.comment;
	}
	/************* ������ *************/
	
	
	/************* �޸��� *************/
	public void setName(String name) {
		if(name != null && !name.isEmpty()) {
			this.name = name;
		}
	}
	public void setAddress(String address) {
		if(name != null && !name.isEmpty()) {
			this.address = address;
		}
	}
	public void setPostalCode(String postalCode) {
		if(name != null && !name.isEmpty()) {
			this.postalCode = postalCode;
		}
	}
	public void setPhoneNumber(String phoneNumber) {
		if(name != null && !name.isEmpty()) {
			this.phoneNumber = phoneNumber;
		}
	}
	public void setCreationDate(String creationDate) {
		if(name != null && !name.isEmpty()) {
			this.creationDate = creationDate;
		}
	}
	public void setComment(String comment) {
		if(name != null && !name.isEmpty()) {
			this.comment = comment;
		}
	}
	/************* �޸��� *************/
	
	/************* ��ʾ���� *************/
	public void showPerson() {
		if(this != null) {
			System.out.printf("\t������%s(%s)\n", name,comment);
			if(address.compareTo("null") != 0) System.out.println("\t��ַ��" + address);
			if(postalCode.compareTo("null") != 0)System.out.println("\t�������룺" + postalCode);
			System.out.println("\t�绰���룺" + phoneNumber);
			System.out.println("\t�������ڣ�" + creationDate);
		}
	}
	/************* ��ʾ���� *************/
	
}

