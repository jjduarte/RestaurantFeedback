package br.com.managersystems.web;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import br.com.managersystems.dao.ConnectionPool;
import br.com.managersystems.entity.Product;
import br.com.managersystems.services.ProductService;
import br.com.managersystems.services.impl.ProductServiceImpl;

@Controller
public class ProductController implements ServletContextAware{

	private ServletContext servletContext;

	@RequestMapping("/listProducts")
	public String listProducs(Model model) {

		Connection conn = new ConnectionPool().getConnection();
		ProductService service = new ProductServiceImpl();

		try {
			model.addAttribute("productList", service.list(conn));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "products/list-products";
	}

	@RequestMapping("/insertProducts")
	public String insertProduct(@Valid Product product, BindingResult result,
			@RequestParam(value = "photo", required = true) MultipartFile image) {
		if (!image.isEmpty()) {
			try {
				validateImage(image);

			} catch (RuntimeException re) {
				result.reject(re.getMessage());
				return "products/list-products";
			}

			try {
				saveImage(product.getName() + ".jpg", image);
			} catch (IOException e) {
				result.reject(e.getMessage());
				return "products/list-products";
			}
		}

		return "products/list-products";
	}

	private void saveImage(String filename, MultipartFile image) throws RuntimeException, IOException {
		try {
			File file = new File(servletContext.getRealPath("/") + "/" + filename);
			FileUtils.writeByteArrayToFile(file, image.getBytes());
			System.out.println("Go to the location:  " + file.toString()
					+ " on your computer and verify that the image has been stored.");
		} catch (IOException e) {
			throw e;
		}
	}

	private void validateImage(MultipartFile image) {
		if (!image.getContentType().equals("image/jpeg")) {
			throw new RuntimeException("Only JPG images are accepted");
		}
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;

	}
}
