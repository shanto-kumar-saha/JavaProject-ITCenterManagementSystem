package interfaces;

import java.lang.*;

import entity.*;

public interface IPurchaseRepo
{
	public void insertInDB(Purchase p);
	//public void deleteFromDB(String purchaseId);
	public void updateInDB(Purchase p);
	public Purchase searchPurchase(String purchaseId);
	public String[][] getAllPurchase();
}