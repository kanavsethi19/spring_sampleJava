import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.pluralsight.repository.CustomerRepository;
import com.pluralsight.repository.HibernateCustomerRepositoryImpl;
import com.pluralsight.service.CustomerService;
import com.pluralsight.service.CustomerServiceImpl;

@Configuration
@ComponentScan({"com.pluralsight"})
public class AppConfig {
	
	@Bean(name ="customerService")
	public CustomerService getCustomerService() {
		CustomerServiceImpl customerServiceImpl=new CustomerServiceImpl();
		customerServiceImpl.setCustomerRepository(getCustomerRepository()); // setter injection
	//	CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl(getCustomerRepository()); // Const injection
		
		Set<String> set1 = new HashSet<>();
		return customerServiceImpl;
	}
	
	
	@Bean(name="customerRepository")
	public CustomerRepository getCustomerRepository() {
		return new HibernateCustomerRepositoryImpl();
	}
}
