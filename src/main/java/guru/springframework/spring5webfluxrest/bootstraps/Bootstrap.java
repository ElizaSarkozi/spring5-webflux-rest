package guru.springframework.spring5webfluxrest.bootstraps;

import guru.springframework.spring5webfluxrest.domain.Category;
import guru.springframework.spring5webfluxrest.domain.Vendor;
import guru.springframework.spring5webfluxrest.repositories.CategoryRepository;
import guru.springframework.spring5webfluxrest.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if(categoryRepository.count().block() == 0){
            System.out.println("###### Loading category data on bootstrap#######");

            categoryRepository.save(Category.builder().description("Fruits").build()).block();
            categoryRepository.save(Category.builder().description("Nuts").build()).block();
            categoryRepository.save(Category.builder().description("Fruits").build()).block();
            categoryRepository.save(Category.builder().description("Breads").build()).block();
            categoryRepository.save(Category.builder().description("Meats").build()).block();
            categoryRepository.save(Category.builder().description("Eggs").build()).block();

            System.out.println("Loaded categories: " + categoryRepository.count().block());
        }

        if(vendorRepository.count().block() == 0){
            System.out.println("########Loading vendor data on bootstrap######");

            vendorRepository.save(Vendor.builder().firstName("Ana").lastName("Bala").build()).block();
            vendorRepository.save(Vendor.builder().firstName("Ion").lastName("Cala").build()).block();
            vendorRepository.save(Vendor.builder().firstName("John").lastName("Dala").build()).block();
            vendorRepository.save(Vendor.builder().firstName("Eli").lastName("Eala").build()).block();
            vendorRepository.save(Vendor.builder().firstName("Dani").lastName("Fala").build()).block();

            System.out.println("Loaded vendors: " + vendorRepository.count().block());
        }

    }
}
