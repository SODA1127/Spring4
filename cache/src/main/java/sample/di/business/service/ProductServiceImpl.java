package sample.di.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import sample.di.business.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;

	public Product findProduct(String name) {

		// 측정 시작
		StopWatch sw = new StopWatch();
		sw.start();

		Product product = productDao.findProduct(name);

		// 측정 종료
		sw.stop();

		System.out.format("Seconds=%1$s, value=%2$s%n",
				sw.getTotalTimeSeconds(), product);

		return product;
	}

	public void addProduct(Product product) {
		productDao.addProduct(product);
	}
}