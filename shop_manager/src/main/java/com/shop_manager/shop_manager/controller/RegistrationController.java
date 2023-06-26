package com.shop_manager.shop_manager.controller;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop_manager.shop_manager.dao.ProductDetailsRepository;
import com.shop_manager.shop_manager.dao.ShopDetailsRepository;
import com.shop_manager.shop_manager.dto.ProductList;
import com.shop_manager.shop_manager.dto.ProductStockResponse;
import com.shop_manager.shop_manager.dto.ShopFKey;
import com.shop_manager.shop_manager.dto.ShopMaster;
import com.shop_manager.shop_manager.entity.Product;
import com.shop_manager.shop_manager.entity.ProductStock;
import com.shop_manager.shop_manager.entity.ShopReg;



@RestController
public class RegistrationController {

	

	@Autowired
	private ShopDetailsRepository shopDetailsRepository;
	@Autowired
	private ProductDetailsRepository productDetailsRepository;
	
	
	public Session getSession() {
		Configuration config = new Configuration();
		config.configure();
		SessionFactory sessionFactor = config.buildSessionFactory();
		Session session = sessionFactor.openSession();
		return session;
	}
	
	@PostMapping("/shopRegistration")
	public ShopReg placeOrder(@RequestBody ShopMaster request) {
		return shopDetailsRepository.save(request.getShopReg());
	}
	@GetMapping("/findAllShops")
	public List<ShopReg> findAllShops(){
		return shopDetailsRepository.findAll();
	}
	
	@GetMapping("/searchProduct/name/{email}/{pName}")
	public List<String> searchProductByName(@PathVariable(value="pName") String pName,@PathVariable(value="email") String email){
		String pNameConcat = "%"+pName+"%";
		System.out.println(pNameConcat);
		return productDetailsRepository.searchByProductName(pNameConcat,shopDetailsRepository.getShopFk(email));
	}
	@GetMapping("/searchProduct/email/{email}")
	public List<String> searchProductListByName(@PathVariable(value="email") String email){
		
		return productDetailsRepository.getProductNameList(email);
		
	}
	
	@GetMapping("/searchProductNameByPId/pName/{pName}")
	public long searchProductNameByPId(@PathVariable(value="pName") String pName){
		
		return productDetailsRepository.searchByProducIdByPName(pName);
		
	}

	@GetMapping("/getStocks/{email}")
	public List<ProductStockResponse> getAllProductsStockdetails(@PathVariable(value="email") String email){
		long sId = shopDetailsRepository.getShopFk(email);
		Session session = getSession();
		Query<ProductStockResponse> qryToGetProductStock = session.createSQLQuery("select p.product_name, p.product_category, p.product_price, p.product_brand, sum(ps.quantity) from product as p join product_stock ps where p.p_id=ps.p_id and p.shop_fk=:sId group by p.product_name");
		qryToGetProductStock.setParameter("sId",sId);
		List<ProductStockResponse> ps = qryToGetProductStock.list();
		return ps;
	}
	
		
	@PutMapping("/addSell/{pId}/{batch}/{qty}")
	public void sellProduct(@PathVariable(value="pId") Long pId, @PathVariable(value="batch") String batch, @PathVariable(value="qty") Integer qty){
		Session session = getSession();
		Transaction txn = session.beginTransaction();
		int quantityFromDB = getQty(batch, qty, session);
		System.out.println(quantityFromDB);
		if(qty > quantityFromDB) {
			throw new RuntimeException();
		}
		Integer quantity = quantityFromDB - qty;
		Query<ProductStockResponse> qryToUpdateStock = session.createSQLQuery("UPDATE product_stock SET quantity=:qty WHERE batch_number=:batch && p_id=:pId");
		qryToUpdateStock.setParameter("pId", pId);
		qryToUpdateStock.setParameter("batch", batch);
		qryToUpdateStock.setParameter("qty", quantity);
		qryToUpdateStock.executeUpdate();
		txn.commit();
		
	}
	
	@PutMapping("/addSellByPName/{pName}/{batch}/{qty}")
	public void sellProductByName(@PathVariable(value="pName") String pName, @PathVariable(value="batch") String batch, @PathVariable(value="qty") Integer qty) throws SQLException{
		try {
		long pId = productDetailsRepository.searchByProducIdByPName(pName);
		Session session = getSession();
		Transaction txn = session.beginTransaction();
		int quantityFromDB = getQty(batch, qty, session);
		System.out.println(quantityFromDB);
		if(qty > quantityFromDB) {
			throw new SQLException();
		}
		Integer quantity = quantityFromDB - qty;
		Query<ProductStockResponse> qryToUpdateStock = session.createSQLQuery("UPDATE product_stock SET quantity=:qty WHERE batch_number=:batch && p_id=:pId");
		qryToUpdateStock.setParameter("pId", pId);
		qryToUpdateStock.setParameter("batch", batch);
		qryToUpdateStock.setParameter("qty", quantity);
		qryToUpdateStock.executeUpdate();
		txn.commit();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	@GetMapping("/findAllProducts/{id}")
	public List<ProductList> findAllProducts(@PathVariable(value="id") Long id){
		return shopDetailsRepository.getJoinInformation(id);
	}
	@GetMapping("/findFk/{email}")
	public ShopFKey findShopFkByEmailId(@PathVariable(value="email") String email){
		ShopFKey shKey = new ShopFKey();
		shKey.setShopFk(shopDetailsRepository.getShopFk(email));
		System.out.println(email);
		System.out.println(shKey);
		return shKey;
	}
	@GetMapping("/findAllProductsByEmail/{email}")
	public List<ProductList> findAllProductsByEmail(@PathVariable(value="email") String email){
		System.out.println(email);
		return shopDetailsRepository.getJoinInformationForEmail(email);
	}
	@PostMapping("/saveProduct/{id}")
	public Product saveProduct(@RequestBody Product product,@PathVariable(value="id") Long id){
//		return shopDetailsRepository.getJoinInformation(id);
		product.setShopFk(id);
//		product.setPicByte(ImageCompriserDecompriserService.compressBytes(product.getPicByte()));
		return productDetailsRepository.save(product);
	}
	@PostMapping("/saveProductWithImg/{id}")
	public Product saveProductWithImg(@RequestBody Product product,@PathVariable(value="id") Long id) throws Exception{
//		return shopDetailsRepository.getJoinInformation(id);
//		product.setPicByte(ImageCompriserDecompriserService.compressBytes(file.getBytes()));
		System.out.println("         -- hui --       ");
//		product.setByteArray(ImageCompriserDecompriserService.compressBytes(product.getByteArray()));
		product.setShopFk(id);
		return productDetailsRepository.save(product);
	}
	@PostMapping("/addProduct/{id}")
	public void addStock(@RequestBody ProductStock product, @PathVariable(value="id") Long id ){
//		return shopDetailsRepository.getJoinInformation(id);
		String batch = product.getBatchNumber();
		String exDate = product.getExDate();
		System.out.println(product.getMfDate());
		String mfDate = product.getMfDate();
		Integer qty = product.getQuantity();
		Configuration config = new Configuration();
		config.configure();
		SessionFactory sessionFactor = config.buildSessionFactory();
		Session session = sessionFactor.openSession();
		Transaction txn = session.beginTransaction();
		Query<ProductStock> pidExist = session.createSQLQuery("SELECT * FROM product_stock where p_id=:p_id");
		pidExist.setParameter("p_id", id);
		List<ProductStock> productStock = pidExist.list();
		System.out.println(productStock.size());
		if(productStock.isEmpty())
		{
		extracted(id, batch, exDate, mfDate, qty, session, txn);
//			 produStockRepository.save(product);
			
		}
		else {
			 
			Query checkBatchIsExist = session.createSQLQuery("SELECT * from product_stock where batch_number = :batch");
			checkBatchIsExist.setParameter("batch", batch);
			List<ProductStock> batchExist = checkBatchIsExist.list();
			if(batchExist.isEmpty()) {
				System.out.println("I am in");
				extracted(id, batch, exDate, mfDate, qty, session, txn);
			}
			else {
			int quantity = getQty(batch, qty, session);
			quantity = quantity + qty;
			Query updateExistingBatch = session.createSQLQuery("UPDATE product_stock SET quantity=:quantity  WHERE batch_number = :batch");
			updateExistingBatch.setParameter("batch", batch);
			updateExistingBatch.setParameter("quantity", quantity);
			updateExistingBatch.executeUpdate();
			System.out.println("no");
			txn.commit();
			}
		}
		
//		return produStockRepository.save(product);
	}

	private void extracted(Long id, String batch, String exDate, String mfDate, Integer qty, Session session,
			Transaction txn) {
		Query qrt = session.createSQLQuery("insert into product_stock(batch_number, ex_date, mf_date, quantity, p_id) values (\r\n"
				+ ":batch,:exDate,:mfDate,:qty,:p_id)");
		qrt.setParameter("p_id", id);
		qrt.setParameter("batch",batch);
		qrt.setParameter("exDate",exDate);
		qrt.setParameter("mfDate",mfDate);
		qrt.setParameter("qty",qty);
		qrt.executeUpdate();
		txn.commit();
	}

	private int getQty(String batch, Integer qty, Session session) {
		int quantity = 0;
		try {
		Query qryToGetQuantity = session.createSQLQuery("select quantity from `product_stock` where batch_number=:batch");
		qryToGetQuantity.setParameter("batch", batch);
		@SuppressWarnings("unchecked")
		List<Integer> quantity1 = qryToGetQuantity.list();
		if(!quantity1.isEmpty()) {
			quantity = quantity1.get(0);
		}
		System.out.println(quantity);
		return quantity;
		}
		catch(ArrayIndexOutOfBoundsException  ex) {
		  System.out.println("exption here"+ex);
		}
		return qty;
	}
}
 