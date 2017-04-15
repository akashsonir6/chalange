package com.niit.chalange.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.chalange.Dao.AuthenticationDao;
import com.niit.chalange.Dao.BillingAddressDao;
import com.niit.chalange.Dao.CardDao;
import com.niit.chalange.Dao.CartDao;
import com.niit.chalange.Dao.CartItemDao;
import com.niit.chalange.Dao.CategoryDao;
import com.niit.chalange.Dao.OrderDao;
import com.niit.chalange.Dao.OrderItemsDao;
import com.niit.chalange.Dao.PayDao;
import com.niit.chalange.Dao.ProductDao;
import com.niit.chalange.Dao.SellerDao;
import com.niit.chalange.Dao.ShippingAddressDao;
import com.niit.chalange.Dao.UserDao;
import com.niit.chalange.DaoImpl.AuthenticationDaoImpl;
import com.niit.chalange.DaoImpl.BillingAddressDaoImpl;
import com.niit.chalange.DaoImpl.CardDaoImpl;
import com.niit.chalange.DaoImpl.CartDaoImpl;
import com.niit.chalange.DaoImpl.CartItemDaoImpl;
import com.niit.chalange.DaoImpl.CategoryDaoImpl;
import com.niit.chalange.DaoImpl.OrderDaoImpl;
import com.niit.chalange.DaoImpl.OrderItemsDaoImpl;
import com.niit.chalange.DaoImpl.PayDaoImpl;
import com.niit.chalange.DaoImpl.ProductDaoImpl;
import com.niit.chalange.DaoImpl.SellerDaoImpl;
import com.niit.chalange.DaoImpl.ShippingAddressDaoImpl;
import com.niit.chalange.DaoImpl.UserDaoImpl;
import com.niit.chalange.model.Authentication;
import com.niit.chalange.model.BillingAddress;
import com.niit.chalange.model.Card;
import com.niit.chalange.model.Cart;
import com.niit.chalange.model.CartItem;
import com.niit.chalange.model.Category;
import com.niit.chalange.model.Order;
import com.niit.chalange.model.OrderItems;
import com.niit.chalange.model.Pay;
import com.niit.chalange.model.Product;
import com.niit.chalange.model.Seller;
import com.niit.chalange.model.ShippingAddress;
import com.niit.chalange.model.User;

@Configuration
@ComponentScan("com.niit.*")
@EnableTransactionManagement
public class ApplicationContext {

	@Bean("dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test/aaa");
		dataSource.setUsername("sa");
		dataSource.setPassword("aaa");

		// Properties connectionProperties=new Properties();
		// connectionProperties.setProperty("hibernate.show_sql", "true");
		// connectionProperties.setProperty("hibernate.dialect",
		// "org.hibernate.dialect");
		return dataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.connection.pool_size", "10");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		return properties;
	}

	@Autowired
	@Bean("sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Seller.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(CartItem.class);
		sessionBuilder.addAnnotatedClass(Authentication.class);
		sessionBuilder.addAnnotatedClass(BillingAddress.class);
		sessionBuilder.addAnnotatedClass(ShippingAddress.class);
		sessionBuilder.addAnnotatedClass(Pay.class);
		sessionBuilder.addAnnotatedClass(Card.class);
		sessionBuilder.addAnnotatedClass(Order.class);
        sessionBuilder.addAnnotatedClass(OrderItems.class);
		return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean("transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	
	@Autowired
	@Bean("billingAddressDao")
	public BillingAddressDao getbillingAddressDao(SessionFactory sessionFactory) {
		return new BillingAddressDaoImpl(sessionFactory);
	}
//	@Autowired
//	@Bean("orderItemsDao")
//	public OrderItemsDao getOrderItemsDao(SessionFactory sessionFactory) {
//		return new OrderItemsDaoImpl(sessionFactory);
//	}
//	@Autowired
//	@Bean("orderDao")
//	public OrderDao getOrderDao(SessionFactory sessionFactory) {
//		return new OrderDaoImpl(sessionFactory);
//	}
	@Autowired
	@Bean("cardDao")
	public CardDao getCardDao(SessionFactory sessionFactory) {
		return new CardDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean("payDao")
	public PayDao getPayDao(SessionFactory sessionFactory) {
		return new PayDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean("shippingAddressDao")
	public ShippingAddressDao getshippingAddressDao(SessionFactory sessionFactory) {
		return new ShippingAddressDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("categoryDao")
	public CategoryDao getCategoryDao(SessionFactory sessionFactory) {
		return new CategoryDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean("sellerDao")
	public SellerDao getSellrDao(SessionFactory sessionFactory) {
		return new SellerDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean("productDao")
	public ProductDao getProductDao(SessionFactory sessionFactory) {
		return new ProductDaoImpl(sessionFactory);

	}

	@Autowired
	@Bean("userDao")
	public UserDao getUserDao(SessionFactory sessionFactory) {
		return new UserDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean("cartDao")
	public CartDao getcartDao(SessionFactory sessionFactory) {
		return new CartDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean("cartItemDao")
	public CartItemDao getCartItemDao(SessionFactory sessionFactory) {
		return new CartItemDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="authenticationDao")
	public AuthenticationDao getAuthenticationDao(SessionFactory sessionFactory) {
		return new AuthenticationDaoImpl(sessionFactory);
	}

}
